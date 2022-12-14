package com.dynamic.progress.repository;

import com.dynamic.progress.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
