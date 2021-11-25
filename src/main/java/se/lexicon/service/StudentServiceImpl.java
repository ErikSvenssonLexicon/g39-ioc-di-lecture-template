package se.lexicon.service;

import se.lexicon.dao.StudentDAO;
import se.lexicon.model.dto.StudentFormDTO;
import se.lexicon.model.entity.Student;

import java.util.Collection;

public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student create(StudentFormDTO studentFormDTO) {
        if(studentFormDTO == null) throw new IllegalArgumentException("Dto was null");
        Student student = new Student(studentFormDTO.getName().trim());
        return studentDAO.save(student);
    }

    @Override
    public Collection<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find student with id " + id));
    }

    @Override
    public Student update(Integer id, StudentFormDTO studentFormDTO) {
        if(id == null || studentFormDTO == null) throw new IllegalArgumentException("Id or form was null");
        Student student = findById(id);
        student.setName(studentFormDTO.getName().trim());

        return studentDAO.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentDAO.delete(findById(id));
    }
}
