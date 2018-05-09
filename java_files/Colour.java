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

public class Colour extends BaseObject {

	//-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private static int RED_COLOUR = 0;
	private static int BLUE_COLOUR = 1;
	private static int GREEN_COLOUR = 2;

	private Color color;

	public String getStringDescriptionOfMonitoredInformation() {
		return "[is a trash dave colour]";
	}

	private Colour(int colourSpecification) {
		this.monitorMethodCallWithNameAndObjects("Colour()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(colourSpecification),
		});

		if(colourSpecification == Colour.RED_COLOUR) {
			this.color = Color.red;
		} else
		if(colourSpecification == Colour.BLUE_COLOUR) {
			this.color = Color.blue;
		} else
		if(colourSpecification == Colour.GREEN_COLOUR) {
			this.color = Color.green;
		} else {} 
	}

	public static Colour davesColour() {
		Colour davesColour = new Colour(Colour.RED_COLOUR);
		return davesColour;
	}

	public Color toColor() {
		this.monitorMethodCallWithNameAndObjects("toColor()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0),
		});

		return this.color;
	}

	public static Colour fromStringToColour(String colourAsString) {
		Colour colourChoice;
		switch (colourAsString) {
			case "Blue":
				colourChoice = new Colour(Colour.BLUE_COLOUR);
				break;
			case "Red":
				colourChoice = new Colour(Colour.RED_COLOUR);
				break;
			case "Green":
				colourChoice = new Colour(Colour.GREEN_COLOUR);
				break;
			default:
			{
				colourChoice = davesColour();
				System.out.println("INVALID COLOR CODE");
			}
		}
		return colourChoice;
	}

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    private static int TEST_COLOR = Colour.RED_COLOUR;

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
    	daveColourTest();
    }

    private static void daveColourTest() {

    	MonitorAssistant.compareNonThreadedMonitoredCallsWithCallbackAndTestDescription(new MonitorAssistantDelegate() {
    		
    		public void executeTestCalls() {
				Colour newColour = Colour.davesColour();
    		}

    		public void executeExpectedCalls() {
    			Colour newColour = new Colour(TEST_COLOR);
    		}

    	}, "Daves Colour");
    }
}