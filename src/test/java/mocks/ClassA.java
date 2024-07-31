package mocks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassA {
    private String text;
    private Integer number;
    private LocalDate date;
    private List<ClassA> listClassA;
    private Map<String,Object> map;
    private Set<String> set;
}
