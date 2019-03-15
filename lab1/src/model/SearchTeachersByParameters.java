package model;

import model.entity.Teacher;
import model.enums.Gender;
import model.enums.Subjects;
import java.util.Arrays;

public class SearchTeachersByParameters {

    public Teacher[] getTeachersByDepartments(Teacher[] teachers, String department) {
        return Arrays.stream(teachers)
                .filter(e -> e.getDepartment().getName().equals(department))
                .toArray(Teacher[]::new);
    }

    public Teacher[] getTeachersBySubject(Teacher[] teachers, String selectedSubject) {
        return Arrays.stream(teachers)
                .filter(e -> Arrays.stream(e.getSubjects())
                        .map(Subjects::getName)
                        .anyMatch(selectedSubject::equals)
                )
                .toArray(Teacher[]::new);

    }

    public Teacher[] getFemaleDocent(Teacher[] teachers) {
        return Arrays.stream(teachers)
                .filter(e -> e.getGender().equals(Gender.FEMALE))
                .toArray(Teacher[]::new);
    }

}
