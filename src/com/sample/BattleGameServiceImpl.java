package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.entities.BattleArea;
import com.entities.Player;
import com.entities.Ship;
import com.entities.ShipType;
import com.services.BattleAreaService;
import com.services.GameService;
import com.services.PlayerService;
import com.services.impl.BattleAreaServiceImpl;
import com.services.impl.GameServiceImpl;
import com.services.impl.PlayerServiceImpl;
import com.services.impl.ShipServiceImpl;

public class BattleGameServiceImpl {

	public static void main(String[] args) throws InterruptedException {
		ShipServiceImpl shipService = new ShipServiceImpl();
		PlayerService playerService = new PlayerServiceImpl();
		BattleAreaService battleAreaService = new BattleAreaServiceImpl();
		GameService gameService = new GameServiceImpl();
		List<String> battleAreas = getTokens("Battle Area width height (5 E)");
		BattleArea battleArea1 = battleAreaService.create(Integer.parseInt(battleAreas.get(0)),
				battleAreas.get(1).charAt(0));
		// battleArea1.plot();
		System.out.println("====================");
		BattleArea battleArea2 = battleAreaService.create(Integer.parseInt(battleAreas.get(0)),
				battleAreas.get(1).charAt(0));
		battleArea2.plot();

		List<String> numberOfBattleShips = getTokens(" Number of Battle Ships (2)");

		for (int i = 0; i < Integer.parseInt(numberOfBattleShips.get(0)); i++) {
			List<String> shipTypesAndLocations = getTokens(" Battleship type, width, height, player 1 location, player 2 location (Q 1 1 A1 B2) (P 2 1 D4 C3) ");
			placeShips(shipService, battleAreaService, battleArea1, battleArea2, numberOfBattleShips,
					shipTypesAndLocations);
		}

		System.out.println("====================");
		// battleArea1.plot();
		System.out.println("====================");
		battleArea2.plot();

		Player player1 = playerService.initialize("player 1", battleArea1);
		Player player2 = playerService.initialize("player 2", battleArea2);

		player1.setSequenceofAttacks(getTokens(" Player1 sequence of Attacks (A1 B2 B2 B3)"));
		player2.setSequenceofAttacks(getTokens(" Player1 sequence of Attacks (A1 B2 B3 A1 D1 E1 D4 D4 D5 D5)"));

		while (gameService.isGameOn(player1, player2)  ) {
			gameService.playTurn(player1, player2);
			gameService.playTurn(player2, player1);
		}

		if (playerService.hasLost(player1))
			System.out.println( player2.getName() + " is the winner");
		if (playerService.hasLost(player2))	
			System.out.println( player1.getName() + " is the winner");
		if (!playerService.hasLost(player1) && (!playerService.hasLost(player1)))
			System.out.println(" TRUCE ");
	}

	private static void placeShips(ShipServiceImpl shipService, BattleAreaService battleAreaService,
			BattleArea battleArea1, BattleArea battleArea2, List<String> numberOfBattleShips,
			List<String> shipTypesAndLocations) {

		Ship ship1 = shipService.create(ShipType.valueOf(shipTypesAndLocations.get(0)),
				Integer.parseInt(shipTypesAndLocations.get(1)), Integer.parseInt(shipTypesAndLocations.get(2)),
				shipTypesAndLocations.get(3));
		battleAreaService.place(battleArea1, ship1);
		Ship ship2 = shipService.create(ShipType.valueOf(shipTypesAndLocations.get(0)),
				Integer.parseInt(shipTypesAndLocations.get(1)), Integer.parseInt(shipTypesAndLocations.get(2)),
				shipTypesAndLocations.get(4));
		battleAreaService.place(battleArea2, ship2);

	}

	public static List<String> getTokens(String output) {
		System.out.println(output + " : ");
		Scanner scanner = new Scanner(System.in);
		List<String> tokens = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(scanner.nextLine());
		while (st.hasMoreTokens()) {
			tokens.add(st.nextToken());
		}
		return tokens;
	}
}
