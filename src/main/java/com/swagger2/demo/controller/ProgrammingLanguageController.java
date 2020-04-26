package com.swagger2.demo.controller;

import com.swagger2.demo.configuration.SwaggerConfig;
import com.swagger2.demo.model.ProgrammingLanguage;
import com.swagger2.demo.repository.IProgrammingLanguageRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/programming-languages")
@Api(tags = SwaggerConfig.PROGRAMMING_LANGUAGE)
@RequiredArgsConstructor
public class ProgrammingLanguageController {

    private final IProgrammingLanguageRepository programmingLanguageRepository;

    @ApiOperation(value = "View a list of available programming languages", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    public ResponseEntity<List<ProgrammingLanguage>> findAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
        return new ResponseEntity<>(programmingLanguages, HttpStatus.OK);
    }

    @ApiOperation(value = "View a programming language by id parameter.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved resource"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(programmingLanguageRepository.findById(id));
    }

    @ApiOperation(value = "Save a new programming language.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created resource"),
            @ApiResponse(code = 401, message = "You are not authorized to save the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 400, message = "The resource is bad formatted.")
    })
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProgrammingLanguage programmingLanguage) {
        return ResponseEntity.status(HttpStatus.CREATED).body(programmingLanguageRepository.save(programmingLanguage));
    }

    @ApiOperation(value = "Delete a programming language.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted resource"),
            @ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (programmingLanguageRepository.findById(id).isPresent()) {
            programmingLanguageRepository.deleteById(id);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
