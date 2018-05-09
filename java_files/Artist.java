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

public class Artist extends BaseObject {
	
	//-----------------------------------------------------------------------------------------------------------------------
	// FUNCTIONAL CODE
	//-----------------------------------------------------------------------------------------------------------------------
	private Pallet pallet;
	private Canvas canvas;
	private WindowActionListener windowActionListener; 

	private Artist() {
		this.pallet = Pallet.startReceivingUserActionsOnNewPallet();
		this.canvas = Canvas.newBlankCanvas(); // This default canvas is not connected to anything
		this.windowActionListener = createWindowActionListenerForThisArtist();
	}

	public static Artist wakeUpSomeRandomBumOnTheStreet() {
		return new Artist();
	}

		private WindowActionListener createWindowActionListenerForThisArtist() {
			WindowActionListener windowActionListener =  new WindowActionListener() {
				public void receivedMouseActionFromWindowWithCoordinate(Coordinate mouseActionPosition) {
					Artist.this.parseMouseEventIntoArtistAction(mouseActionPosition);
				}
			};
			return windowActionListener;
		}

		private void parseMouseEventIntoArtistAction(Coordinate mouseActionPosition) {
			if (this.artistWantsToScrapCanvas()) {
				this.canvas.clearCanvas();
			} else {
				BrushStroke brushStrokeToDrawOnCanvas = this.pallet.brushStrokeAtPosition(mouseActionPosition);
				this.canvas.drawBrushStroke(brushStrokeToDrawOnCanvas);
			}
		}

	public WindowActionListener getTheWindowActionListenerForThisArtist() {
		return this.windowActionListener;
	}

	public void handThisArtistACanvasToDrawOn(Canvas canvas) {
		this.canvas = canvas;
	}

		private boolean artistWantsToScrapCanvas() {
			return this.pallet.thisPalletWasStrewnAlongTheGroundInAnger();
		}	
}