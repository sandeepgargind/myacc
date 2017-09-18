package com.services.impl;

import java.util.HashSet;

import com.entities.Ship;
import com.entities.ShipType;
import com.services.ShipService;

public class ShipServiceImpl implements ShipService {

	public Ship create(ShipType shipType, int width, int height, String place) {
		HashSet<String> cells = new HashSet<>();
		char shipStarty = place.charAt(0);
		int shipStartx = Character.getNumericValue(place.charAt(1));
		String s = "";
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int tempx = shipStartx + i;
				char tempy = (char) (shipStarty + j);
				s = "";
				cells.add(s + tempy + tempx);
			}
		}
		return Ship.create(cells, shipType);
	}

	@Override
	public void update(Ship ship, String cell) {
		if (ship.getCellType(cell) == ShipType.Q)
			ship.update(cell);
		else
			ship.remove(cell);
	}

}
