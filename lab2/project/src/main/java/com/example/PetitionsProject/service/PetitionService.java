package com.example.PetitionsProject.service;

import com.example.PetitionsProject.dto.PetitionDto;
import com.example.PetitionsProject.models.Petition;

import java.util.List;

public interface PetitionService {
    List<PetitionDto> findAllPetitions();
    Petition savePetition(PetitionDto petition);
    PetitionDto findByPetitionId(long petitionId);
    void deletePetition(Long petId);
    void updatePetition(PetitionDto petition);
    List<PetitionDto> searchPetitions(String query);
}
