package com.services;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import com.entities.BattleArea;
import com.entities.Player;
import com.entities.Ship;
import com.entities.ShipType;
import com.services.impl.BattleAreaServiceImpl;
import com.services.impl.GameServiceImpl;
import com.services.impl.PlayerServiceImpl;

public class testGameServiceImpl {

	Player player , playerOpponent = null;
	PlayerService playerService;
	BattleAreaService battleAreaService;
	GameService gameService ;
	
	@Before
	public void setup() throws InterruptedException {
		playerService = new PlayerServiceImpl();
		battleAreaService = new BattleAreaServiceImpl();

		player = new Player(null, "Player 1");
		String[] attacks = { "A1" , "A2" , "P3" , "P3", "P5" };
		player.setSequenceofAttacks( Arrays.asList(attacks));
		
		String[] strCells = { "A1", "A2" };
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		Ship ship = Ship.create(cells, ShipType.P);
		BattleArea battleArea = battleAreaService.create(3, 'E');
		battleAreaService.place(battleArea, ship);
		
		playerOpponent = new Player(battleArea, "Player 2");
		gameService = new GameServiceImpl();
	}
	
	@Test
	public void testPlayTurn() throws InterruptedException {
		gameService.playTurn(player, playerOpponent);
		
		assertTrue(true);
	}

}
