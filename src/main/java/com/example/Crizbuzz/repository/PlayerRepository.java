package com.example.Crizbuzz.repository;

import com.example.Crizbuzz.model.Enum.Gender;
import com.example.Crizbuzz.model.Enum.Speciality;
import com.example.Crizbuzz.model.Player;
import org.hibernate.id.factory.spi.GeneratorDefinitionResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findByGenderAndAgeGreaterThan(Gender gender,int age);

    @Query(value = "select * from player where gender = :gender AND speciality = :speciality", nativeQuery = true)
    List<Player> getByGenderAndSpeciality(Gender gender, Speciality speciality);
}
