package se.lexicon.dao;

import se.lexicon.dao.sequencer.Sequencers;
import se.lexicon.model.entity.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO{

    private final Collection<Student> students;
    private final Sequencers sequencers;

    public StudentDAOImpl(Sequencers sequencers) {
        this.sequencers = sequencers;
        students = new HashSet<>();
    }

    @Override
    public Student save(Student entity) {
        if(entity == null) throw new IllegalArgumentException("Entity was null");
        if(entity.getId() == null){
            return internalCreate(entity);
        }
        return internalMerge(entity);
    }

    public Student internalMerge(Student student) {
        return student;
    }

    public Student internalCreate(Student student){
        student.setId(sequencers.nextStudentId());
        students.add(student);
        return student;
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(Student entity) {
        students.remove(entity);
    }
}
