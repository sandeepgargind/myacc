package com.services;
import com.entities.*;

public interface ShipService {
	Ship create(ShipType shipType, int width, int height, String place);
	void update(Ship ship, String Cell);
}
