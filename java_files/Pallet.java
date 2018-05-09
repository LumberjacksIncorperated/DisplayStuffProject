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
import java.util.Scanner;

public class Pallet extends BaseObject {

	//-----------------------------------------------------------------------------------------------------------------------
	// FUNCTIONAL CODE
	//-----------------------------------------------------------------------------------------------------------------------
	private Colour currentColourChoice;
	private Scanner commandLineInputReader;

	private Pallet() {
		this.currentColourChoice = Colour.davesColour();
		this.commandLineInputReader = new Scanner(System.in);
	}

	public static Pallet startReceivingUserActionsOnNewPallet() {
		Pallet newPallet = new Pallet();
		newPallet.startCommandLineUserInteractionOnNewThread();
		return newPallet;
	}

	public BrushStroke brushStrokeAtPosition(Coordinate brushStrokePosition) {
		return BrushStroke.simpleStrokeWithColourAtPosition(this.currentColourChoice, brushStrokePosition);
	}

	public boolean thisPalletWasStrewnAlongTheGroundInAnger() {
		return false;
	}

		private void startCommandLineUserInteractionOnNewThread() {
			Thread commandLineUserInteractionThread = new Thread(new Runnable() {
				@Override
				public void run() {
        			Pallet.this.startCommandLineUserInteraction();
    			}
			});
			commandLineUserInteractionThread.start();
		}

		private void startCommandLineUserInteraction() {
			while(true) {
				printUserInteractionMessage();
				String userColourRequest = getUserColourRequest();
				this.currentColourChoice = Colour.fromStringToColour(userColourRequest);
			}
		}

		private void printUserInteractionMessage() {
			System.out.println("*** Enter A Colour Choice ***");
			System.out.println("(Red, Green, Blue)");
		}

		private String getUserColourRequest() {
			String userInputString = this.commandLineInputReader.nextLine();
       	 	return userInputString;
		}
}