package com.juliop.gamesproject.repoositories;

import com.juliop.gamesproject.entities.Game;
import com.juliop.gamesproject.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
	List<GameMinProjection> searchByList(Long listId);
}


//		SELECT POSITION, GAME_ID, GAME.TITLE
//FROM TB_BELONGING
//INNER JOIN TB_GAME GAME
//WHERE GAME_ID = GAME.ID AND
//		LIST_ID = 1

