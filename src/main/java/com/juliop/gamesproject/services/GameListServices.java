package com.juliop.gamesproject.services;


import com.juliop.gamesproject.entities.Game;
import com.juliop.gamesproject.entities.GameList;
import com.juliop.gamesproject.persistence.dto.ListDTO;
import com.juliop.gamesproject.projections.GameMinProjection;
import com.juliop.gamesproject.repoositories.GameRepository;
import com.juliop.gamesproject.repoositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameListServices {

    @Autowired
    ListRepository listRepository;
    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public  List<ListDTO> findAll(){
        List<GameList> result = listRepository.findAll();
        return   result
                .stream()
                .map(ListDTO::new)
                .toList();
    }
    @Transactional
    public void move(long id, int originIndex, int destinationIndex){
        List<GameMinProjection> listBase = gameRepository.searchByList(id);
        var removedItem = listBase.remove(originIndex);
        listBase.add(destinationIndex, removedItem);
        int min = Math.min(originIndex, destinationIndex);
        int max = Math.max(originIndex, destinationIndex);

        for (int i = min; i <= max; i++){
            listRepository.updateBelongingPosition(id, listBase.get(i).getId(), i);
            System.out.println("Updated the " + listBase.get(i).getTitle() + " to position " + i);
        }

}}
