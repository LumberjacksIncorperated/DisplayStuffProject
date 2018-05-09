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
import java.awt.event.*;

public class JPanelWrapper extends BaseObject {

    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------
    private JPanel jPanel;

    public JPanelWrapper() {
    	this.monitorMethodCallWithNameAndObjects("GraphicWindowCanvas()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});

        this.jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                JPanelWrapper.this.paintComponent(GraphicWrapper.grafixFromGraphics(graphics));
            }
        };
    }

    public void repaint() {
    	this.monitorMethodCallWithNameAndObjects("repaint()", new BaseObject[] {
			ObjectDescription.descriptionOfInt(0)
		});

    	this.jPanel.repaint();
    }

    public JPanel giveWrappedFrame() {
        this.monitorMethodCallWithNameAndObjects("giveWrappedFrame()", new BaseObject[] {});

        return this.jPanel;
    }

    public void addMouseAdapter(MouseAdapter mouseAdapter) {
        this.monitorMethodCallWithNameAndObjects("addMouseAdapter()", new BaseObject[] {
            ObjectDescription.descriptionOfInt(0)
        });

        this.jPanel.addMouseListener(mouseAdapter);
        this.jPanel.addMouseMotionListener(mouseAdapter);
    }

    protected void paintComponent(GraphicWrapper graphics) {
    }
}