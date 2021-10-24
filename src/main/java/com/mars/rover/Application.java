package com.mars.rover;

public class Application {

	public static void main(String[] args) {
		new Process(new Rover(1, 2, Direction.N), "LMLMLMLMM").process();
		new Process(new Rover(3, 3, Direction.E), "MMRMMRMRRM").process();
	}
}
