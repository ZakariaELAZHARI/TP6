package com.example.student_management.repository;

import com.example.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Requête personnalisée : compter les étudiants par année de naissance
    @Query("SELECT COUNT(s) FROM Student s WHERE YEAR(s.dateNaissance) = :annee")
    Long countByAnneeNaissance(@Param("annee") int annee);

    // Requête personnalisée : trouver les étudiants par nom
    List<Student> findByNomContainingIgnoreCase(String nom);

    // Requête personnalisée : trouver les étudiants par année de naissance
    @Query("SELECT s FROM Student s WHERE YEAR(s.dateNaissance) = :annee")
    List<Student> findByAnneeNaissance(@Param("annee") int annee);

    // Requête personnalisée : nombre d'étudiants par année de naissance (pour les statistiques)
    @Query("SELECT YEAR(s.dateNaissance) as annee, COUNT(s) as nombre FROM Student s GROUP BY YEAR(s.dateNaissance)")
    Collection<?> findNbrStudentByYear();
}
