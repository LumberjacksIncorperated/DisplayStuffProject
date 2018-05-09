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

public class PaintingApplication extends BaseObject {

	//-----------------------------------------------------------------------------------------------------------------------
	// FUNCTIONAL CODE
	//-----------------------------------------------------------------------------------------------------------------------
	public PaintingApplication() {}

	public void run() {
		PaintingWindow paintingWindow = PaintingWindow.openNewEmptyPaintingWindow();
		Artist artist = Artist.wakeUpSomeRandomBumOnTheStreet();
		
		paintingWindow.setWindowActionListener(artist.getTheWindowActionListenerForThisArtist());
		Canvas canvasFromTheWindow = paintingWindow.getCanvasOfThisPaintingWindow();
		artist.handThisArtistACanvasToDrawOn(canvasFromTheWindow);
	}
}