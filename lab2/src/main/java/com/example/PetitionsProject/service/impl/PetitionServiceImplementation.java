package com.example.PetitionsProject.service.impl;

import com.example.PetitionsProject.dto.PetitionDto;
import com.example.PetitionsProject.models.Petition;
import com.example.PetitionsProject.repository.PetitionRepository;
import com.example.PetitionsProject.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.PetitionsProject.mappers.PetitionMapper.mapToPetition;
import static com.example.PetitionsProject.mappers.PetitionMapper.mapToPetitionDto;

@Service
public class PetitionServiceImplementation implements PetitionService {
    private PetitionRepository petitionRepository;
    @Autowired // Ін’єкція через конструктор
    public PetitionServiceImplementation(PetitionRepository petitionRepository){
        this.petitionRepository = petitionRepository;
    }
    @Autowired // Ін’єкція через сеттер
    public void setPetitionRepository(PetitionRepository petitionRepository) {
        this.petitionRepository = petitionRepository;
    }

    @Override
    public List<PetitionDto> findAllPetitions() {
        List<Petition> petitions = petitionRepository.findAll();
        return petitions.stream().map((petition) -> mapToPetitionDto(petition)).collect(Collectors.toList());
    }

    @Override
    public Petition savePetition(PetitionDto petitionDto) {
        Petition petition = mapToPetition(petitionDto);
        return petitionRepository.save(petition);
    }

    @Override
    public PetitionDto findByPetitionId(long petitionId) {
        Petition petition = petitionRepository.findById(petitionId).get();
        return mapToPetitionDto(petition);
    }

    @Override
    public void deletePetition(Long petitionId) {
        petitionRepository.deleteById(petitionId);
    }

    @Override
    public void updatePetition(PetitionDto petitionDto) {
        Petition petition = mapToPetition(petitionDto);
        petitionRepository.save(petition);
    }

    @Override
    public List<PetitionDto> searchPetitions(String query) {
        List<Petition> petitions = petitionRepository.searchPetitions(query);
        return petitions.stream().map(petition -> mapToPetitionDto(petition)).collect(Collectors.toList());
    }
}
