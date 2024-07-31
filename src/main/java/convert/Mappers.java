package convert;

public interface Mappers {
    <E> E mapper(Object entity,Class mapperClass);
}
