package com.swagger2.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "programming_languages")
@Setter
@Getter
@NoArgsConstructor
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String name;

    public ProgrammingLanguage(String name) {
        this.name = name;
    }
}
