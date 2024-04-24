package convert.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class ParseToNewClass {

    protected <E> E setValue(Field field, Object old){
            try {
               var value = getValueOld(field,old) ;
//               if(value instanceof Iterable){
//                   value = caseList(field,(List<?>) value);
//               }
               return (E) value;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
    }

    protected <E> List<E> caseList(Field field, List list){
        if(!(field.getGenericType() instanceof ParameterizedType)){
            return null;
        }
        ParameterizedType typeClass = (ParameterizedType) field.getGenericType();
        Class<?> objectClass = (Class<?>) typeClass.getActualTypeArguments()[0];

        List listNewObject = new ArrayList<>();
        list.forEach(e-> {
            setValue(field,e);
            list.add(e);
        });
        return (List<E>) listNewObject;
    }

    protected  <E> E getNewInstance(Class clazz) {
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
        return (E) value.get(oldValue) ;
    }
}
