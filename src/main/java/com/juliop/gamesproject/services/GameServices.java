package com.juliop.gamesproject.services;

import com.juliop.gamesproject.entities.Game;
import com.juliop.gamesproject.persistence.dto.GameDTO;
import com.juliop.gamesproject.persistence.dto.GameMinDTO;
import com.juliop.gamesproject.repoositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServices {

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }
    @Transactional(readOnly = true)
    public GameDTO findById(long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
}
