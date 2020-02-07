package com.swagger2.demo.repository;

import com.swagger2.demo.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageRepository extends JpaRepository<Language, Long> {
}
