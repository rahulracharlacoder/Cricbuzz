package com.example.Crizbuzz.service;

import com.example.Crizbuzz.converter.PlayerConverter;
import com.example.Crizbuzz.dto.request.PlayerRequest;
import com.example.Crizbuzz.dto.response.PlayerResponse;
import com.example.Crizbuzz.exception.PlayerNotFoundException;
import com.example.Crizbuzz.exception.TeamNotFoundException;
import com.example.Crizbuzz.model.Enum.Gender;
import com.example.Crizbuzz.model.Enum.Speciality;
import com.example.Crizbuzz.model.Player;
import com.example.Crizbuzz.model.Team;
import com.example.Crizbuzz.repository.PlayerRepository;
import com.example.Crizbuzz.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    Logger loggers = LoggerFactory.getLogger(PlayerService.class);

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TeamRepository teamRepository;

    public PlayerResponse addPlayer(PlayerRequest playerRequest) {
        loggers.info("addPlayer method started");
        Player player = PlayerConverter.PlayerRequestToPlayer(playerRequest);
        Player savedPlayer = playerRepository.save(player);
        sendEmail(savedPlayer);
        loggers.info("addPlayer method started");
        return PlayerConverter.playerToPlayerResponse(savedPlayer);
    }

    private void sendEmail(Player savedPlayer) {
        loggers.info("sendEmail method started");
        String text = "Hi!" +savedPlayer.getName()+" your profile has been registered on Cricbuzz";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rahulracharla17@gmail.com");
        message.setTo(savedPlayer.getEmail());
        message.setSubject("Congrats!! You have been registered");
        message.setText(text);
        javaMailSender.send(message);
        loggers.info("sendEmail method started");
    }

    public String addPlayerInTeam(int team_id, int player_id) {
        loggers.info("addPlayerInTeam method started");
        Optional<Team> optionalTeam = teamRepository.findById(team_id);
        Optional<Player> optionalPlayer = playerRepository.findById(player_id);
        if(optionalTeam.isEmpty() | optionalPlayer.isEmpty()) {
            if(optionalTeam.isEmpty()){
                loggers.error("Exception occurred in addPlayerInTeam method for team");
                throw new TeamNotFoundException("Invalid team id");
            }
            else{
                loggers.error("Exception occurred in addPlayerInTeam method for player");
                throw new PlayerNotFoundException("Invalid player id");
            }
        }
        Team team = optionalTeam.get();
        Player player = optionalPlayer.get();
        player.setTeam(team);
        playerRepository.save(player);
        loggers.info("addPlayerInTeam method started");
        return "Player of id "+player_id+" is add in the team of id "+team_id;
    }

    public List<PlayerResponse> getAllPlayers() {
        loggers.info("getAllPlayers method started");
        List<Player> players = playerRepository.findAll();
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getAllPlayers method started");
        return playerResponses;
    }

    public PlayerResponse getPlayer(int player_id) {
        loggers.info("getPlayer method started");
        Optional<Player> playerOptional = playerRepository.findById(player_id);
        if(playerOptional.isEmpty()) {
            loggers.error("Exception occurred in getPlayer method");
            throw new PlayerNotFoundException("Player with id "+player_id+" doesn't exist");
        }
        loggers.info("getPlayer method started");
        return PlayerConverter.playerToPlayerResponse(playerOptional.get());
    }

    public List<PlayerResponse> getByName(String name) {
        loggers.info("getByName method started");
        List<Player> players = playerRepository.findByName(name);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player:players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getByName method started");
        return playerResponses;
    }

    public List<PlayerResponse> getByAge(int age) {
        loggers.info("getByAge method started");
        List<Player> players = playerRepository.findByAge(age);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player:players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getByAge method started");
        return playerResponses;
    }

    public List<PlayerResponse> getBySpeciality(Speciality speciality) {
        loggers.info("getBySpeciality method started");
        List<Player> players = playerRepository.findBySpeciality(speciality);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player:players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getBySpeciality method started");
        return playerResponses;
    }

    public List<PlayerResponse> getByGender(Gender gender) {
        loggers.info("getByGender method started");
        List<Player> players = playerRepository.findByGender(gender);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player:players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getByGender method started");
        return playerResponses;
    }

    public PlayerResponse getByEmail(String email) {
        loggers.info("getByEmail method started");
        Optional<Player> playerOptional = playerRepository.findByEmail(email);
        if(playerOptional.isEmpty()) {
            loggers.error("Exception occurred in getByEmail method");
            throw new PlayerNotFoundException("Player with email "+email+" doesn't exist");
        }
        loggers.info("getByEmail method started");
        return PlayerConverter.playerToPlayerResponse(playerOptional.get());
    }

    public List<PlayerResponse> getByGenderAndName(Gender gender, String name) {
        loggers.info("getByGenderAndName method started");
        List<Player> players = playerRepository.findByGenderAndName(gender, name);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getByGenderAndName method started");
        return playerResponses;
    }

    public List<PlayerResponse> getPlayerByGenderAndAge(Gender gender, int age) {
        loggers.info("getPlayerByGenderAndAge method started");
        List<Player> players = playerRepository.findByGenderAndAgeGreaterThan(gender, age);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getPlayerByGenderAndAge method started");
        return playerResponses;
    }

    public List<PlayerResponse> getPlayerByGenderAndSpeciality(Gender gender, Speciality speciality) {
        loggers.info("getPlayerByGenderAndSpeciality method started");
        List<Player> players = playerRepository.getByGenderAndSpeciality(gender, speciality);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getPlayerByGenderAndSpeciality method started");
        return playerResponses;
    }

    public List<PlayerResponse> getByNameAndAge(String name, int age) {
        loggers.info("getByNameAndAge method started");
        List<Player> players = playerRepository.findByNameAndAge(name, age);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getByNameAndAge method started");
        return playerResponses;
    }

    public List<PlayerResponse> getByNameAndSpeciality(String name, Speciality speciality) {
        loggers.info("getByNameAndSpeciality method started");
        List<Player> players = playerRepository.findByNameAndSpeciality(name, speciality);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getByNameAndSpeciality method started");
        return playerResponses;
    }

    public List<PlayerResponse> getByAgeAndSpeciality(int age, Speciality speciality) {
        loggers.info("getByAgeAndSpeciality method started");
        List<Player> players = playerRepository.findByAgeAndSpeciality(age, speciality);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getByAgeAndSpeciality method started");
        return playerResponses;
    }

    public List<PlayerResponse>  getByNameAgeAndSpeciality(String name, int age, Speciality speciality) {
        loggers.info("getByNameAgeAndSpeciality method started");
        List<Player> players = playerRepository.findByAgeNameAndSpeciality(name, age, speciality.name());
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getByNameAgeAndSpeciality method started");
        return playerResponses;
    }
    public List<PlayerResponse>  getByNameAgeAndGender(String name, int age, Gender gender) {
        loggers.info("getByNameAgeAndGender method started");
        List<Player> players = playerRepository.findByAgeNameAndGender(name, age, gender.name());
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        loggers.info("getByNameAgeAndGender method started");
        return playerResponses;
    }

    public String updatePlayer(PlayerRequest playerRequest, int player_id) {
        loggers.info("updatePlayer method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updatePlayer method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        player1.setName(playerRequest.getName());
        player1.setAge(playerRequest.getAge());
        player1.setSpeciality(playerRequest.getSpeciality());
        player1.setGender(playerRequest.getGender());
        player1.setEmail(playerRequest.getEmail());
        playerRepository.save(player1);
        loggers.info("updatePlayer method started");
        return "Player of id "+player_id+" info updated successfully";
    }

    public String updateName(String name, int player_id) {
        loggers.info("updateName method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateName method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        player1.setName(name);
        playerRepository.save(player1);
        loggers.info("updateName method started");
        return "Name of player of id "+player_id+" info updated successfully";
    }

    public String updateAge(int age, int player_id) {
        loggers.info("updateAge method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateAge method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        player1.setAge(age);
        playerRepository.save(player1);
        loggers.info("updateAge method started");
        return "Age of player of id "+player_id+" info updated successfully";
    }

    public String updateSpeciality(Speciality speciality, int player_id) {
        loggers.info("updateSpeciality method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateSpeciality method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        player1.setSpeciality(speciality);
        playerRepository.save(player1);
        loggers.info("updateSpeciality method started");
        return "Speciality of player of id "+player_id+" info updated successfully";
    }

    public String updateGender(Gender gender, int player_id) {
        loggers.info("updateGender method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateGender method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        player1.setGender(gender);
        playerRepository.save(player1);
        loggers.info("updateGender method started");
        return "Gender of player of id "+player_id+" info updated successfully";
    }

    public String updateEmail(String email, int player_id) {
        loggers.info("updateEmail method started");
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()) {
            loggers.error("Exception occurred in updateEmail method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player1 = player.get();
        player1.setEmail(email);
        playerRepository.save(player1);
        loggers.info("updateEmail method started");
        return "Email of player of id "+player_id+" info updated successfully";
    }

    public String deletePlayer(int player_id) {
        loggers.info("deletePlayer method started");
        Optional<Player> optionalPlayer = playerRepository.findById(player_id);
        if(optionalPlayer.isEmpty()) {
            loggers.error("Exception occurred in deletePlayer method");
            throw new PlayerNotFoundException("Player with id "+player_id+" is not present");
        }
        Player player = optionalPlayer.get();
        Team team = player.getTeam();
        if(team != null) {
            team.getPlayers().remove(player);
        }
        playerRepository.delete(player);
        loggers.info("deletePlayer method started");
        return "Player of id "+player_id+" deleted successfully";
    }
}
