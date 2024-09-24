package com.example.PetitionsProject.controllers;

import com.example.PetitionsProject.dto.PetitionDto;
import com.example.PetitionsProject.models.Petition;
import com.example.PetitionsProject.service.PetitionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PetitionController {
    private PetitionService petitionService;
    // Ін’єкція через конструктор
    @Autowired
    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    @GetMapping("/petitions")
    public String listPetitions(Model model){
        List<PetitionDto> petitions = petitionService.findAllPetitions();
        model.addAttribute("petitions", petitions);
        return "petitions-list";
    }

    @GetMapping("/petitions/{petitionId}")
    public String getPetition(@PathVariable("petitionId") Long petitionId, Model model) {
        PetitionDto petition = petitionService.findByPetitionId(petitionId);
        model.addAttribute("petition", petition);
        return "petition-details";
    }

    @GetMapping("/petitions/add")
    public String addPetition(Model model) {
        Petition petition = new Petition();
        model.addAttribute("petition", petition);
        return "petition-add";
    }

    @PostMapping("/petitions/add")
    public String savePetition(@Valid @ModelAttribute("petition") PetitionDto petitionDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("petition", petitionDto);
            return "petition-add";
        }
        petitionService.savePetition(petitionDto);
        return "redirect:/petitions";
    }

    @GetMapping("/petitions/{petitionId}/edit")
    public String editPetitionForm(@PathVariable("petitionId") Long petitionId, Model model) {
        PetitionDto petition = petitionService.findByPetitionId(petitionId);
        model.addAttribute("petition", petition);
        return "petition-edit";
    }

    @PostMapping("/petitions/{petitionId}/edit")
    public String updatePetition(@PathVariable("petitionId") Long petitionId,
                                 @Valid @ModelAttribute("petition") PetitionDto petition,
                                BindingResult result){
        if (result.hasErrors()) {
            return "petition-edit";
        }
        petition.setIdPetition(petitionId);
        petitionService.updatePetition(petition);
        return "redirect:/petitions";
    }

    @GetMapping("/petitions/{petitionId}/delete")
    public String deletePetition(@PathVariable("petitionId") Long petitionId, Model model) {
        petitionService.deletePetition(petitionId);
        return "redirect:/petitions";
    }

    @GetMapping("/petitions/search")
    public String searchPetitions(@RequestParam(value = "query") String query, Model model){
        List<PetitionDto> petitions = petitionService.searchPetitions(query);
        model.addAttribute("petitions", petitions);
        return "petitions-list";
    }
}
