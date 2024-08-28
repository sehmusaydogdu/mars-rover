package com.mars.rover;

import lombok.extern.slf4j.Slf4j;

import java.util.EnumMap;

@Slf4j
public class Process {

	private static final EnumMap<Direction, Direction> leftDirections = new EnumMap<>(Direction.class);
	private static final EnumMap<Direction, Direction> rightDirections = new EnumMap<>(Direction.class);

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

	/** Plateau info */
	private Plateau plateau;

	/** Specifies how the rover should move. */
	private String command;

	/** Rover info */
	private Rover rover;

	public Process(Plateau plateau, Rover rover, String command) {
		this.plateau = plateau;
		this.rover = rover;
		this.command = command;
	}

	public Rover execute() {
		log.info("input  [{}]", rover.toString());
		char[] commands = command.toCharArray();
		for (char direction : commands) {
			switch (direction) {
			case 'L' -> turnLeftDirection();
			case 'R' -> turnRightDirection();
			case 'M' -> move();
			default -> throw new IllegalArgumentException("Unexpected command value: " + command);
			}
		}
		log.info("output [{}]", rover.toString());
		return rover;
	}

	private void turnLeftDirection() {
		rover.setDirection(leftDirections.get(rover.getDirection()));
	}

	private void turnRightDirection() {
		rover.setDirection(rightDirections.get(rover.getDirection()));
	}

	private void move() {
		Direction direction = rover.getDirection();
		if (direction.equals(Direction.N) && (rover.getPositionY() + 1) <= plateau.getHeight()) {
			rover.setPositionY(rover.getPositionY() + 1);
		} else if (direction.equals(Direction.E) && (rover.getPositionX() + 1) <= plateau.getWidth()) {
			rover.setPositionX(rover.getPositionX() + 1);
		} else if (direction.equals(Direction.S) && (rover.getPositionY() - 1) >= 0) {
			rover.setPositionY(rover.getPositionY() - 1);
		} else if (direction.equals(Direction.W) && (rover.getPositionX() - 1) >= 0) {
			rover.setPositionX(rover.getPositionX() - 1);
		} else {
			log.warn("Can't go on.");
		}
	}
}
