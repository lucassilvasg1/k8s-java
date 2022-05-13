package io.github.lucassilva.application.controllers;

import io.github.lucassilva.application.dto.CourseDTO;
import io.github.lucassilva.application.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @GetMapping(value = "{id}")
    public ResponseEntity<CourseDTO> get(HttpServletRequest request, @PathVariable("id") Long id) {
        return new ResponseEntity<>(new CourseDTO(1L, "Math"), HttpStatus.OK);
    }


}