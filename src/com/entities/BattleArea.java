package com.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BattleArea {

	char rows;
	int columns;
	Map<String, Ship> cellToShipMap = null;

	public char getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public BattleArea(int columns, char rows) {
		super();
		this.rows = rows;
		this.columns = columns;
		cellToShipMap = new HashMap<>();

	}

	public void plot() {
		for (char i = 'A'; i <= rows; i++) {
			for (int c = 1; c <= columns; c++) {
				String cell = "" + i + c;
				if (cellToShipMap.keySet().contains(cell)) {
					Ship ship = cellToShipMap.get(cell);
					System.out.print(ship.getCellType(cell) + "*" + " ");
				} else
					System.out.print(cell + " ");
			}
			System.out.println();
		}

	}

	public void put(HashSet<String> locations, Ship ship) {
		for (String location : locations)
			cellToShipMap.put(location, ship);

	}

	public String getShipLocations() {
		return cellToShipMap.keySet().toString();
	}

	public boolean hasShipOn(String cell) {
		return cellToShipMap.keySet().contains(cell);
	}

	public Ship getShipOnCell(String cell) {
		return cellToShipMap.get(cell);
	}

	public void removeShipOn(String cell) {
		cellToShipMap.remove(cell);
	}

	public boolean containsAnyShip() {
		return cellToShipMap.size() > 0 ? true : false;
	}

}
