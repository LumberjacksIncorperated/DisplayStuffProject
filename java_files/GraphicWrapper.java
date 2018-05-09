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
import java.awt.*;
import java.util.*;

public class GraphicWrapper extends BaseObject {
	
	//-----------------------------------------------------------------------------------------------------------------------
	// FUNCTIONAL CODE
	//-----------------------------------------------------------------------------------------------------------------------
	private Graphics graphics = null;

	private GraphicWrapper(Graphics graphics) {
		this.graphics = graphics;
	}

	public GraphicWrapper(GraphicWrapper graphicsWrapper) {
		this.graphics = graphicsWrapper.graphics;
	}

	public static GraphicWrapper facadeGrafixObject() {
		return new GraphicWrapper((Graphics)null);
	}

	public static GraphicWrapper grafixFromGraphics(Graphics graphics) {
		return new GraphicWrapper(graphics);
	}

	public void fillOval(int leftMostPosition, int topMostPosition, int height, int width) {
		this.monitorMethodCallWithNameAndObjects("fillOval", new BaseObject[] {
			ObjectDescription.descriptionOfInt(leftMostPosition),
			ObjectDescription.descriptionOfInt(topMostPosition),
			ObjectDescription.descriptionOfInt(height),
			ObjectDescription.descriptionOfInt(width)
		});

		if (this.graphics != null) {
			this.graphics.fillOval(leftMostPosition, topMostPosition, width, height);
		}
	}

	public void setColour(Colour colour) {
		this.monitorMethodCallWithNameAndObjects("setColour", new BaseObject[] {colour});
		
		if (this.graphics != null) {
			this.graphics.setColor(colour.toColor());
		}
	}

	public void clear() {
		this.monitorMethodCallWithNameAndObjects("clear", new BaseObject[] {});
	}
}