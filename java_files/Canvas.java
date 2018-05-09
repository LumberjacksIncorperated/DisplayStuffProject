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
import java.util.*;

public class Canvas extends BaseObject {

	//-----------------------------------------------------------------------------------------------------------------------
	// FUNCTIONAL CODE
	//-----------------------------------------------------------------------------------------------------------------------
	private ArrayList<BrushStroke> brushStrokes;
	private CanvasActionListener canvasActionListener;

	private Canvas(CanvasActionListener canvasActionListener) {
		this.brushStrokes = new ArrayList<BrushStroke>();
		this.canvasActionListener = canvasActionListener;
	}

	public static Canvas newBlankCanvas() {
		return new Canvas(null);
	}

	public static Canvas newBlankCanvasWithCanvasActionListener(CanvasActionListener canvasActionListener) {
		return new Canvas(canvasActionListener);
	}

	public void clearCanvas() {
		this.brushStrokes = new ArrayList<BrushStroke>();
		this.notifyListenerThatCanvasWasPainted();
	}

	public void drawBrushStroke(BrushStroke brushStroke) {
		this.brushStrokes.add(brushStroke);
		this.notifyListenerThatCanvasWasPainted();
	}

	public void giveCanvasImageToGraphicsDelegate(GraphicsDelegate graphicsDelegate) {
		for (BrushStroke brushStroke : this.brushStrokes) {
			brushStroke.giveStrokeToGraphicsDelegate(graphicsDelegate);
		}
	}

		private void notifyListenerThatCanvasWasPainted() {
			if (this.canvasActionListener != null) {
				this.canvasActionListener.canvasWasPainted();
			}
		}
}