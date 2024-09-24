package com.example.PetitionsProject.mappers;

import com.example.PetitionsProject.dto.PetitionDto;
import com.example.PetitionsProject.models.Petition;

public class PetitionMapper {
    public static Petition mapToPetition(PetitionDto petition) {
        Petition petitionDto = Petition.builder()
                .idPetition(petition.getIdPetition())
                .title(petition.getTitle())
                .text(petition.getText())
                .build();
        return petitionDto;
    }

    public static PetitionDto mapToPetitionDto(Petition petition){
        PetitionDto petitionDto = PetitionDto.builder()
                .idPetition(petition.getIdPetition())
                .title(petition.getTitle())
                .text(petition.getText())
                .build();
        return petitionDto;
    }
}
