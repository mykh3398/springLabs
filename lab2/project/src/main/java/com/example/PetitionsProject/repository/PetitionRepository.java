package com.example.PetitionsProject.repository;

import com.example.PetitionsProject.models.Petition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PetitionRepository extends JpaRepository<Petition, Long> {
    Optional<Petition> findByTitle(String title);
    @Query("SELECT p from Petition p WHERE p.title LIKE CONCAT('%', :query, '%')")
    List<Petition> searchPetitions(String query);

}
