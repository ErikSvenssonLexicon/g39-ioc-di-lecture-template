package se.lexicon.model.entity;

import java.util.Objects;

public class LearnedSkill {

    private Integer id;
    private int grade;
    private String studentNote;
    private Skill skill;

    public LearnedSkill(int grade, String studentNote, Skill skill) {
        this.grade = grade;
        this.studentNote = studentNote;
        this.skill = skill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(this.id == null && id != null){
            this.id = id;
        }
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getStudentNote() {
        return studentNote;
    }

    public void setStudentNote(String studentNote) {
        this.studentNote = studentNote;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LearnedSkill that = (LearnedSkill) o;
        return grade == that.grade && Objects.equals(id, that.id) && Objects.equals(studentNote, that.studentNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grade, studentNote);
    }

    @Override
    public String toString() {
        return "LearnedSkill{" +
                "id=" + id +
                ", grade=" + grade +
                ", studentNote='" + studentNote + '\'' +
                '}';
    }
}
