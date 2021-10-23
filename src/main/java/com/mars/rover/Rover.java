package com.mars.rover;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * It holds the rover's information.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */

@Getter
@Setter
@AllArgsConstructor
public class Rover {

	/** Specifies the X-axis in the coordinate system. */
	private int positionX;
	
	/** Specifies the Y-axis in the coordinate system. */
	private int positionY;
	
	/** Indicates the compass direction of the rover.  */
	private Direction direction;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(positionX).append(" ");
		builder.append(positionY).append(" ");
		builder.append(direction.name());
		return builder.toString();
	}
}
