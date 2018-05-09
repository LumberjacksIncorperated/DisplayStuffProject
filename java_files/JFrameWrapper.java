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
import javax.swing.*;
import java.util.*;

public class JFrameWrapper extends BaseObject {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
	private final JFrame jFrame;

	public JFrameWrapper() {
		this.jFrame = new JFrame();
    }

    public void setContentPane(JPanelWrapper contentPane) {
    	this.monitorMethodCallWithNameAndObjects("setContentPane()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});

    	this.jFrame.setContentPane(contentPane.giveWrappedFrame());
    }

    public void setDefaultCloseOperation() {
    	this.monitorMethodCallWithNameAndObjects("setContentPane()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});
		
    	this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setSize(int width, int height) {
    	this.monitorMethodCallWithNameAndObjects("setContentPane()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(width),
			ObjectDescription.descriptionOfInt(height)
		});
		
    	this.jFrame.setSize(width, height);
    }
    
    public void setVisible(boolean visibility) {
    	this.monitorMethodCallWithNameAndObjects("setContentPane()", new BaseObject[] {
			ObjectDescription.descriptionOfBoolean(visibility)
		});
		
    	this.jFrame.setVisible(visibility);
    }

    public void dispose() {
    	this.jFrame.dispose();
    }
}