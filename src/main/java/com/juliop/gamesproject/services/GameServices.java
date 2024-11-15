package com.juliop.gamesproject.services;

import com.juliop.gamesproject.entities.Game;
import com.juliop.gamesproject.persistence.dto.GameMinDTO;
import com.juliop.gamesproject.repoositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServices {

    @Autowired
    GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }

}
