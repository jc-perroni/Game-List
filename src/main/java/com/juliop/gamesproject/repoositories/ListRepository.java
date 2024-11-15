package com.juliop.gamesproject.repoositories;

import com.juliop.gamesproject.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<GameList, Long> {
}
