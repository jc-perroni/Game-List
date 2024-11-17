package com.juliop.gamesproject.controllers;

import com.juliop.gamesproject.persistence.dto.GameDTO;
import com.juliop.gamesproject.persistence.dto.GameMinDTO;
import com.juliop.gamesproject.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameServices gameServices;

    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameServices.findAll();
    }
    @GetMapping(value = "/{id}")
    public GameDTO findGame(@PathVariable Long id){
        return gameServices.findById(id);
    }

}
