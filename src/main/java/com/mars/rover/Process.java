package com.mars.rover;

import java.util.EnumMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Process {

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

	/** Specifies how the rover should move. */
	private String command;

	/** Rover info */
	private Rover rover;

	public Process(Rover rover, String command) {
		this.rover = rover;
		this.command = command;
	}

	public Rover process() {
		log.info("input [{}]", rover.toString());

		char[] commands = command.toCharArray();
		for (char direction : commands) {
			switch (direction) {
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
		log.info("output [{}]", rover.toString());
		return rover;
	}

	private Rover move(Rover rover) {
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
