package convert;

public interface MapperConvertReflect {
    <E> E mapper(Object entity,Class mapperClass);
}
