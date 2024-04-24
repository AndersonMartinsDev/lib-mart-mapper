package convert.impl;

import mocks.ClassA;
import mocks.ClassB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapperConvertReflectImplTest {

    @InjectMocks
    MapperConvertReflectImpl mapperConvertReflect;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenEverythingIsOk(){
        var a = ClassA
                .builder()
                .text("test text")
                .date(LocalDate.now())
                .number(2)
                .listClassA(List.of(ClassA.builder().build(),ClassA.builder().build()))
                .build();

        ClassB entity = mapperConvertReflect.mapper(a, ClassB.class);
        System.out.println(entity);
    }

}