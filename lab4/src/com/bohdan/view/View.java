package com.bohdan.view;

import com.bohdan.model.entity.Student;

import java.util.List;

public class View {

    public void print(String str) {
        System.out.println(str);
    }

    public void printStudentList(List<Student> list) {
        if(list.isEmpty()) {
            System.out.println("List is empty");
        }
        list.forEach(System.out::println);
    }


}
