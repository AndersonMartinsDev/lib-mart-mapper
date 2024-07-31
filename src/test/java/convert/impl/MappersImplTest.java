package convert.impl;

import mocks.ClassA;
import mocks.ClassB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.*;

class MappersImplTest {

    @InjectMocks
    MappersImpl mapperConvertReflect;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenEverythingIsOk(){
        var classeA = ClassA
                .builder()
                .text("test text")
                .date(LocalDate.now())
                .number(2)
                .listClassA(
                        List.of(
                                ClassA
                                        .builder()
                                        .text("ista 1")
                                        .build(),
                                ClassA
                                        .builder()
                                        .text("lista2")
                                        .number(2)
                                        .build()))
                .build();

        ClassB entity = mapperConvertReflect.mapper(classeA, ClassB.class);
        System.out.println(entity);
    }

    @Test
    void whenUsinMap(){
        var classeA = ClassA
                .builder()
                .text("test text")
                .date(LocalDate.now())
                .number(2)
                .listClassA(
                        List.of(
                                ClassA
                                        .builder()
                                        .text("ista 1")
                                        .build(),
                                ClassA
                                        .builder()
                                        .text("lista2")
                                        .number(2)
                                        .build()))
                .map(Map.of("teste","teste","teste1","teste1"))
                .build();

        ClassB entity = mapperConvertReflect.mapper(classeA, ClassB.class);
        System.out.println(entity);
    }

    @Test
    void whenUsinSet(){
        Set<String> set = new HashSet<>();
        set.add("teste set 1 ");
        set.add("teste set 2 ");
        set.add("teste set 3 ");

        var classeA = ClassA
                .builder()
                .text("test text")
                .date(LocalDate.now())
                .number(2)
                .set(set)
                .build();

        ClassB entity = mapperConvertReflect.mapper(classeA, ClassB.class);
        System.out.println(entity);
    }

}