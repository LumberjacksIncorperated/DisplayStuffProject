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

public class BrushStroke extends BaseObject {

	//-----------------------------------------------------------------------------------------------------------------------
	// FUNCTIONAL CODE
	//-----------------------------------------------------------------------------------------------------------------------
	private final Colour strokeColour; 
	private final Coordinate strokePosition;

	private BrushStroke(Colour strokeColour, Coordinate strokePosition) {
		this.strokeColour = strokeColour;
		this.strokePosition = strokePosition;
	}

	public void giveStrokeToGraphicsDelegate(GraphicsDelegate graphicsDelegate) {
		CircularBrushStroke newCircularStroke = CircularBrushStroke.parseStrokePositionAndColourIntoCircularBrushStroke(this.strokeColour, this.strokePosition);
		newCircularStroke.giveStrokeToGraphicsDelegate(graphicsDelegate);
	}

	public static BrushStroke simpleStrokeWithColourAtPosition(Colour colour, Coordinate position) { 
		return new BrushStroke(colour, position);
	}

	public static class CircularBrushStroke {

		private final static int CIRCULAR_STROKE_HEIGHT = 6;
		private final static int CIRCULAR_STROKE_WIDTH = 22;

		private Colour strokeColour; 
		private int leftMostPositionOfStrokeCircle;
		private int topMostPositionOfStrokeCircle;

		private CircularBrushStroke() {}

		public static CircularBrushStroke parseStrokePositionAndColourIntoCircularBrushStroke(Colour strokeColour, Coordinate strokePosition) {	
			CircularBrushStroke newCircularStroke = new CircularBrushStroke();
			newCircularStroke.strokeColour = strokeColour;
			newCircularStroke.leftMostPositionOfStrokeCircle = (int) strokePosition.getXPosition() - CircularBrushStroke.CIRCULAR_STROKE_WIDTH/2;
			newCircularStroke.topMostPositionOfStrokeCircle = (int) strokePosition.getYPosition() - CircularBrushStroke.CIRCULAR_STROKE_HEIGHT/2;
			return newCircularStroke;
		}

		public void giveStrokeToGraphicsDelegate(GraphicsDelegate graphicsDelegate) {
			graphicsDelegate.setColour(this.strokeColour);
			graphicsDelegate.fillOval(this.leftMostPositionOfStrokeCircle, this.topMostPositionOfStrokeCircle, CircularBrushStroke.CIRCULAR_STROKE_HEIGHT, CircularBrushStroke.CIRCULAR_STROKE_WIDTH);
		}
	}
}