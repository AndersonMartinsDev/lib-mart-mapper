package convert.impl;

import convert.Mappers;
import org.springframework.stereotype.Component;

@Component
public class MappersImpl extends ParseToNewClass implements Mappers {
    @Override
    public <E> E mapper(Object old, Class clazz) {
        return mapperToNewClass(old,clazz);
    }
}
