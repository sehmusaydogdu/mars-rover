package com.mars.rover;

import java.util.EnumMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

	private static EnumMap<Direction, Direction> leftDirections = new EnumMap<>(Direction.class);
	private static EnumMap<Direction, Direction> rightDirections = new EnumMap<>(Direction.class);

	static {
		/* turn left direction */
		leftDirections.put(Direction.N, Direction.W);
		leftDirections.put(Direction.W, Direction.S);
		leftDirections.put(Direction.S, Direction.E);
		leftDirections.put(Direction.E, Direction.N);

		/* turn right direction */
		rightDirections.put(Direction.N, Direction.E);
		rightDirections.put(Direction.E, Direction.S);
		rightDirections.put(Direction.S, Direction.W);
		rightDirections.put(Direction.W, Direction.N);
	}

	public static void main(String[] args) {
		Rover rover1 = new Rover(1, 2, Direction.N);
		List<Character> commands1 = List.of('L', 'M', 'L', 'M', 'L', 'M', 'L', 'M', 'M');
		execute(rover1, commands1);

		Rover rover2 = new Rover(3, 3, Direction.E);
		List<Character> commands2 = List.of('M', 'M', 'R', 'M', 'M', 'R', 'M', 'R', 'R', 'M');
		execute(rover2, commands2);
	}

	private static void execute(Rover rover, List<Character> commands) {
		log.info("Before = [{}]", rover.toString());
		
		for (Character command : commands) {
			switch (command) {
			case 'L' -> rover.setDirection(leftDirections.get(rover.getDirection()));
			case 'R' -> rover.setDirection(rightDirections.get(rover.getDirection()));
			case 'M' -> {
				Rover newRover = move(rover);
				rover.setPositionX(newRover.getPositionX());
				rover.setPositionY(newRover.getPositionY());
			}
			default -> throw new IllegalArgumentException("Unexpected command value: " + command);
			}
		}
		
		log.info("After = [{}]", rover.toString());
	}

	private static Rover move(Rover rover) {
		Direction direction = rover.getDirection();
		switch (direction) {
		case N -> rover.setPositionY(rover.getPositionY() + 1);
		case E -> rover.setPositionX(rover.getPositionX() + 1);
		case S -> rover.setPositionY(rover.getPositionY() - 1);
		case W -> rover.setPositionX(rover.getPositionX() - 1);
		default -> throw new IllegalArgumentException("Unexpected direction value: " + direction);
		}
		return rover;
	}
}
