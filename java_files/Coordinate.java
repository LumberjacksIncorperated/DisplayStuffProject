//-----------------------------------------------------------------------------------------------------------------------
//
// PROJECT
// -------
// "Display Project"
//
// AUTHOR
// ------
// Lumberjacks Incorperated (2018)
//
//-----------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------
// IMPORTS
//-----------------------------------------------------------------------------------------------------------------------
import chain_testing.*; // Chain Testing Framework

public class Coordinate extends BaseObject {

	//-----------------------------------------------------------------------------------------------------------------------
	// FUNCTIONAL CODE
	//-----------------------------------------------------------------------------------------------------------------------
	private final double xPosition;
	private final double yPosition;

	public Coordinate(double xPosition, double yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public double getXPosition() {
		return this.xPosition;
	}

	public double getYPosition() {
		return this.yPosition;
	}
}