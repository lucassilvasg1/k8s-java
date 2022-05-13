package io.github.lucassilva.application.controllers;

import io.github.lucassilva.application.dto.CourseDTO;
import io.github.lucassilva.application.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("students")
@CrossOrigin(origins = "*")
public class StudentController {

    @GetMapping(value = "{id}")
    public ResponseEntity<StudentDTO> get(HttpServletRequest request, @PathVariable("id") Long id) {

        ResponseEntity<CourseDTO> response = getCourse();
//        ResponseEntity<CourseDTO> response = new ResponseEntity<>(new CourseDTO(1L, "Math"), HttpStatus.OK);

        StudentDTO dto = new StudentDTO(id, "Lucas", response.getBody());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    private ResponseEntity<CourseDTO> getCourse() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://ws-cursos:8080/courses/1";
        return restTemplate.getForEntity(url, CourseDTO.class);
    }


}