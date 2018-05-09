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

public class GraphicsDelegate extends GraphicWrapper { 

	//-----------------------------------------------------------------------------------------------------------------------
	// FUNCTIONAL CODE
	//-----------------------------------------------------------------------------------------------------------------------
	private GraphicsDelegate(GraphicWrapper graphics) {
		super(graphics);
	}

	public static GraphicsDelegate graphicsDelegateFromGraphics(GraphicWrapper graphics) {
		GraphicsDelegate newGraphicsDelegate =  new GraphicsDelegate(graphics);
		return newGraphicsDelegate;
	}
}