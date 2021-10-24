package com.mars.rover;

public class Application {

	public static void main(String[] args) {
		Plateau plateau = new Plateau(5, 5);
		new Process(plateau, new Rover(1, 2, Direction.N), "LMLMLMLMM").process();
		new Process(plateau, new Rover(3, 3, Direction.E), "MMRMMRMRRM").process();
	}
}
