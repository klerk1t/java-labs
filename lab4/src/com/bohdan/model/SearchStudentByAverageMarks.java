package com.bohdan.model;

import com.bohdan.model.entity.Student;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class SearchStudentByAverageMarks {

    private Map<Student, Double> map;

    public SearchStudentByAverageMarks(Map<Student, Double> map) {
        this.map = map;
    }

    public List<Student> search() {
        return map.entrySet().stream()
                .filter(e -> e.getValue() >= 4.0)
                .map(Map.Entry::getKey)
                .collect(toList());
    }
}
