package com.juliop.gamesproject.services;


import com.juliop.gamesproject.entities.GameList;
import com.juliop.gamesproject.persistence.dto.ListDTO;
import com.juliop.gamesproject.repoositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListServices {

    @Autowired
    ListRepository listRepository;

    @Transactional(readOnly = true)
    public  List<ListDTO> findAll(){
        List<GameList> result = listRepository.findAll();
        return   result
                .stream()
                .map(ListDTO::new)
                .toList();
    }
}
