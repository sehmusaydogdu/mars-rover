package com.mars.rover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ApplicationTest {

	@Test
	void givenInput_thenProcess_example_1() {
		Plateau plateau = new Plateau(5, 5);
		Rover rover = new Rover(1, 2, Direction.N);
		String command = "LMLMLMLMM";

		String expected = "1 3 N";
		Process process = new Process(plateau, rover, command);
		Rover actual = process.execute();
		assertThat(expected).isEqualTo(actual.toString());
	}
	
	@Test
	void givenInput_thenProcess_example_2() {
		Plateau plateau = new Plateau(5, 5);
		Rover rover = new Rover(3, 3, Direction.E);
		String command = "MMRMMRMRRM";

		String expected = "5 1 E";
		Process process = new Process(plateau, rover, command);
		Rover actual = process.execute();
		assertThat(expected).isEqualTo(actual.toString());
	}
}
