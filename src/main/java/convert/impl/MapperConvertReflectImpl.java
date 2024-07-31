package convert.impl;

import convert.MapperConvertReflect;
import org.springframework.stereotype.Component;

@Component
public class MapperConvertReflectImpl extends ParseToNewClass implements MapperConvertReflect {
    @Override
    public <E> E mapper(Object old, Class clazz) {
        return mapperToNewClass(old,clazz);
    }
}
