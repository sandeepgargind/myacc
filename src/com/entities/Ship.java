package com.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ship {

	private Map<String, ShipType> cellsWithType = null ;


	private Ship(Map<String, ShipType> cellsWithType) {
		this.cellsWithType = cellsWithType;
	}

	public ShipType getCellType(String cell) {
		return cellsWithType.get(cell);
	}

	public boolean isAlive() {
		return (cellsWithType.size() > 0 ? true : false);
	}

	public static Ship create(Set<String> cells, ShipType type) {
		Map<String, ShipType> cellsWithType = new HashMap<>();
		for (String cell: cells)
			cellsWithType.put(cell, type);
		return new Ship(cellsWithType);
	}

	@Override
	public String toString() {
		return cellsWithType.toString();
	}

	public boolean contains(String cell) {
		return cellsWithType.keySet().contains(cell);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellsWithType == null) ? 0 : cellsWithType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (cellsWithType == null) {
			if (other.cellsWithType != null)
				return false;
		} else if (!cellsWithType.equals(other.cellsWithType))
			return false;
		return true;
	}

	public void update(String cell) {
		cellsWithType.put(cell, ShipType.P);
	}
	
	public void remove(String cell) {
		cellsWithType.remove(cell);
	}
	

}
