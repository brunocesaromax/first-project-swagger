package com.swagger2.demo.repository;

import com.swagger2.demo.model.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {
}
