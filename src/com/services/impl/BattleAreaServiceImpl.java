package com.services.impl;

import java.util.HashSet;

import com.entities.BattleArea;
import com.entities.Ship;
import com.entities.ShipType;
import com.services.BattleAreaService;
import com.services.ShipService;

public class BattleAreaServiceImpl implements BattleAreaService {

	ShipService shipService = new ShipServiceImpl();
	
	@Override
	public void place(BattleArea battlesArea, Ship ship) {
		HashSet<String> locations = new HashSet<>();
		for (char i = 'A'; i <= battlesArea.getRows(); i++) {
			for (int c = 1; c <= battlesArea.getColumns(); c++) {
				String cell = "" + i + c;
				if (ship.contains(cell))
					locations.add(cell);
			}
			battlesArea.put(locations, ship);
		}
	}

	@Override
	public void plot(BattleArea battleArea) {
		battleArea.plot();
	}

	@Override
	public BattleArea create(int columns, char rows) {
		return new BattleArea(columns, rows);

	}
	
	@Override
	public boolean onAttack(BattleArea battleArea, String cell) {
		if (this.isOccupiedbyShip(battleArea, cell)) {
			Ship ship = this.getShiponCell(battleArea, cell);
			if (ship.getCellType(cell).equals(ShipType.P))
				this.removeShipOnCell(battleArea, cell);
			shipService.update(ship, cell);
			return true;
		}
		return false;
	}

	@Override
	public void removeShipOnCell(BattleArea battleArea, String cell) {
		battleArea.removeShipOn(cell);
	}

	@Override
	public boolean isOccupiedbyShip(BattleArea battleArea, String cell) {
		return battleArea.hasShipOn(cell);
	}

	@Override
	public Ship getShiponCell(BattleArea battleArea, String cell) {
		return battleArea.getShipOnCell(cell);
	}

	@Override
	public boolean hasAnyShip(BattleArea battleArea) {
		return battleArea.containsAnyShip();
	}


}
