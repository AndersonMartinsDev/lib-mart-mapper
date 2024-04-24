package mocks;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public class ClassA {
    private String text;
    private Integer number;
    private LocalDate date;

    private List<ClassA> listClassA;
}
