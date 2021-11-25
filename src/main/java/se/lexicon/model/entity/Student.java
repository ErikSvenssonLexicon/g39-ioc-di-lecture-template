package se.lexicon.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

    private Integer id;
    private String name;
    private List<LearnedSkill> learnedSkills;

    public Student(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(this.id == null && id != null){
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LearnedSkill> getLearnedSkills() {
        if(learnedSkills == null) learnedSkills = new ArrayList<>();
        return learnedSkills;
    }

    public void setLearnedSkills(List<LearnedSkill> learnedSkills) {
        if(learnedSkills == null) learnedSkills = new ArrayList<>();
        this.learnedSkills = learnedSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
