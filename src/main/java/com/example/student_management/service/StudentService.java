package com.example.student_management.service;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public boolean delete(int id) {
        Optional<Student> studentOptional = studentRepository.findById((long) id);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        } else {
            return false;
        }
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public long countStudents() {
        return studentRepository.count();
    }

    public Collection<?> findNbrStudentByYear() {
        return studentRepository.findNbrStudentByYear();
    }

    // Méthodes supplémentaires pour compatibilité avec l'implémentation actuelle
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public long count() {
        return studentRepository.count();
    }

    public Long countByAnneeNaissance(int annee) {
        return studentRepository.countByAnneeNaissance(annee);
    }

    public List<Student> findByAnneeNaissance(int annee) {
        return studentRepository.findByAnneeNaissance(annee);
    }

    public List<Student> findByNom(String nom) {
        return studentRepository.findByNomContainingIgnoreCase(nom);
    }
}
