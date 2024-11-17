package com.juliop.gamesproject.controllers;

import com.juliop.gamesproject.persistence.dto.GameMinDTO;
import com.juliop.gamesproject.persistence.dto.ListDTO;
import com.juliop.gamesproject.persistence.dto.ReplacementDTO;
import com.juliop.gamesproject.services.GameServices;
import com.juliop.gamesproject.services.GameListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class ListController {

    @Autowired
    private GameListServices gameListServices;
    @Autowired
    private GameServices gameServices;

    @GetMapping
    public List<ListDTO> findAllLists(){
        return gameListServices.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable long listId){
        return gameServices.findByList(listId);

    }
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable long listId, @RequestBody ReplacementDTO body){
        gameListServices.move(listId, body.originIndex(), body.destinationIndex());
    }

}
