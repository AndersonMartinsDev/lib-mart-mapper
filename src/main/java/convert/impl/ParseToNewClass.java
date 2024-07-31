package convert.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.*;

public abstract class ParseToNewClass {

    private <E> E setValue(Field field, Object old) {
        try {
            var value = getValueOld(field, old);
            if (value instanceof Iterable) {
                value = caseList(field, (Iterable<? extends Object>) value);
            }
            return (E) value;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <E> Iterable<E> caseList(Field field, Iterable<E> iterable) {
        if (!(field.getGenericType() instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType typeClass = (ParameterizedType) field.getGenericType();
        Class<?> objectClass = (Class<?>) typeClass.getActualTypeArguments()[0];
        var stack = new Stack<E>();
        var iteraror = iterable.iterator();
        while (iteraror.hasNext()) {
            var object = iteraror.next();
            if (!objectFilter(object.getClass())) {
                stack.add(mapperToNewClass(object, objectClass));
            } else {
                stack.add(object);
            }
        }

        if(field.getType() == java.util.List.class){
            return new ArrayList<>(stack);
        }
        if(field.getType() == java.util.Set.class){
            return new TreeSet<E>(stack);
        }
        return stack;
    }

    private <E> E getNewInstance(Class clazz) {
        try {
            return (E) clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    private <E> E getValueOld(Field field, Object oldValue) throws NoSuchFieldException, IllegalAccessException {
        var value = oldValue.getClass().getDeclaredField(field.getName());
        value.setAccessible(true);
        return (E) value.get(oldValue);
    }

    protected <E> E mapperToNewClass(Object old, Class clazz) {
        var newObj = getNewInstance(clazz);
        var fieldArray = newObj.getClass().getDeclaredFields();
        var fieldSize = fieldArray.length;
        try {
            for (int i = 0; i < fieldSize; i++) {
                var field = fieldArray[i];
                field.setAccessible(true);
                field.set(newObj, setValue(field, old));
                field.setAccessible(false);
            }
        } catch (IllegalAccessException ex) {
            throw new RuntimeException("Erro ao tentar setar valor em var", ex.getCause());
        }
        return (E) newObj;
    }

    private boolean objectFilter(Class<?> clazz) {
        List<Class<?>> arrayClassFilter = List.of(String.class,
                                            Integer.class,
                                            Double.class,
                                            Float.class,
                                            BigDecimal.class);
        return arrayClassFilter.contains(clazz);
    }
}
