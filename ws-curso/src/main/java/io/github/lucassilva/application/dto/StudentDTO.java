package io.github.lucassilva.application.dto;

import java.util.List;

public record StudentDTO(Long id, String name, List<CourseDTO> courses) {
}
