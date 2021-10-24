package com.mars.rover;

public class Application {

	public static void main(String[] args) {
		Plateau plateau = new Plateau(5, 5);

		Rover rover = new Rover(1, 2, Direction.N);
		String command = "LMLMLMLMM";
		Process process = new Process(plateau, rover, command);
		process.execute();

		rover = new Rover(3, 3, Direction.E);
		command = "MMRMMRMRRM";
		process = new Process(plateau, rover, command);
		process.execute();
	}
}
