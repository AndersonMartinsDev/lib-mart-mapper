package convert.impl;

import convert.MapperConvertReflect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MapperConvertReflectImpl  extends ParseToNewClass implements MapperConvertReflect {
    @Override
    public <E> E mapper(Object entity, Class clazz) {
        var newObject = getNewInstance(clazz);
        Arrays.stream(newObject.getClass().getDeclaredFields()).forEach(field->{
            try {
                field.setAccessible(true);
                field.set(newObject,setValue(field,entity));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }finally {
                field.setAccessible(false);
            }
        });

        return (E) newObject;
    }
}
