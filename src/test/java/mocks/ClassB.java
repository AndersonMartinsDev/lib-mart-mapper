package mocks;

import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class ClassB {
    private String text;
    private Integer number;
    private LocalDate date;

    private ClassA classA;
    private List<ClassA> listClassA;
    private Map<String,Object> map;
    private Set<String> set;
}
