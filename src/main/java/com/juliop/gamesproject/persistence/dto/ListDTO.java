package com.juliop.gamesproject.persistence.dto;

import com.juliop.gamesproject.entities.GameList;
import org.springframework.beans.BeanUtils;

public class ListDTO {

    private long id;
    private String Name;

    public ListDTO(){}

    public ListDTO(GameList list) {
        BeanUtils.copyProperties(list, this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
