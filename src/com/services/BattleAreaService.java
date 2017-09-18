package com.services;

import com.entities.BattleArea;
import com.entities.Ship;

public interface BattleAreaService {
	BattleArea create(int columns, char rows);
	void place(BattleArea battleArea, Ship ship);
	boolean isOccupiedbyShip(BattleArea battleArea, String cell);
	Ship getShiponCell(BattleArea battleArea, String cell);
	void removeShipOnCell(BattleArea battleArea, String cell);
	void plot(BattleArea battleArea);
	boolean onAttack(BattleArea battleArea, String cell);
	boolean hasAnyShip(BattleArea battleArea);
}
