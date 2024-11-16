package com.juliop.gamesproject.controllers;

import com.juliop.gamesproject.persistence.dto.GameMinDTO;
import com.juliop.gamesproject.persistence.dto.ListDTO;
import com.juliop.gamesproject.services.GameServices;
import com.juliop.gamesproject.services.ListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class ListController {

    @Autowired
    private ListServices listServices;
    @Autowired
    private GameServices gameServices;

    @GetMapping
    public List<ListDTO> findAllLists(){
        return listServices.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable long listId){
        return gameServices.findByList(listId);

    }
}
