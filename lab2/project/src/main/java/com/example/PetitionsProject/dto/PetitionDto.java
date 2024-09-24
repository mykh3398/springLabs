package com.example.PetitionsProject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetitionDto {
    private Long idPetition;
    @NotEmpty(message = "Title shouldn't be empty")
    private String title;
    @NotEmpty(message = "Textarea shouldn't be empty")
    private String text;
}
