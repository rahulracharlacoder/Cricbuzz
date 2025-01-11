package com.example.Crizbuzz.repository;

import com.example.Crizbuzz.model.Enum.Gender;
import com.example.Crizbuzz.model.Enum.Speciality;
import com.example.Crizbuzz.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findByGenderAndAgeGreaterThan(Gender gender,int age);

    List<Player> getByGenderAndSpeciality(Gender gender, Speciality speciality);

    List<Player> findByName(String name);

    List<Player> findByAge(int age);

    List<Player> findBySpeciality(Speciality speciality);

    List<Player> findByGender(Gender gender);

    Optional<Player> findByEmail(String email);

    List<Player> findByGenderAndName(Gender gender, String name);

    List<Player> findByNameAndAge(String name, int age);

    List<Player> findByNameAndSpeciality(String name, Speciality speciality);

    List<Player> findByAgeAndSpeciality(int age, Speciality speciality);

    @Query(value = "SELECT * FROM player WHERE name = :name AND age = :age AND speciality = :speciality", nativeQuery = true)
    List<Player> findByAgeNameAndSpeciality(@Param("name") String name, @Param("age") int age, @Param("speciality") String speciality);

    @Query(value = "SELECT * FROM player WHERE name = :name AND age = :age AND gender = :gender", nativeQuery = true)
    List<Player> findByAgeNameAndGender(@Param("name") String name, @Param("age") int age, @Param("gender") String gender);
}
