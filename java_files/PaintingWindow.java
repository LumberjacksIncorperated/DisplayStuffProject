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
import java.awt.event.*;
import java.util.*;

public class PaintingWindow extends BaseObject implements CanvasActionListener {
	
	//-----------------------------------------------------------------------------------------------------------------------
	// FUNCTIONAL CODE
	//-----------------------------------------------------------------------------------------------------------------------
	private final Canvas canvasOnThisWindow;
	private WindowActionListener windowActionListener = null;
	private JPanelWrapper thisWindowsDisplayPanel;
	private MouseAdapter mouseAdapter;

	private PaintingWindow() {
		setupMouseAdapterToSendEventsToWindowActionListener();
		this.canvasOnThisWindow = Canvas.newBlankCanvasWithCanvasActionListener(this);
		this.thisWindowsDisplayPanel = this.createJPanelForThisPaintingWindow();
		this.thisWindowsDisplayPanel.addMouseAdapter(this.mouseAdapter);
		setupFrameForWindowWithPanel(this.thisWindowsDisplayPanel);
	}

	private MouseAdapter setupMouseAdapterToSendEventsToWindowActionListener() {
		MouseAdapter newMouseAdapter = new MouseAdapter() {
     		@Override
     		public void mouseDragged(MouseEvent mouseEvent) {
     			PaintingWindow.this.sendMouseEventCoordinatesToWindowActionListener(mouseEvent);
     		}
  		};
  		this.mouseAdapter = newMouseAdapter;
	}

		private void sendMouseEventCoordinatesToWindowActionListener(MouseEvent mouseEvent) {
				double mouseEventXPosition = (double) mouseEvent.getX();
     			double mouseEventYPosition = (double) mouseEvent.getY();
     			Coordinate coordinateOfMouseDraggingEvent = new Coordinate(mouseEventXPosition, mouseEventYPosition);
        		this.windowActionListener.receivedMouseActionFromWindowWithCoordinate(coordinateOfMouseDraggingEvent); 	
		}

		private void setupFrameForWindowWithPanel(JPanelWrapper panel) {
			JFrameWrapper thisWindowsFrame = new JFrameWrapper();
			thisWindowsFrame.setDefaultCloseOperation();
			thisWindowsFrame.setSize(612,418);
			thisWindowsFrame.setContentPane(panel);
			thisWindowsFrame.setVisible(true);
		}

	public void canvasWasPainted() {
		this.thisWindowsDisplayPanel.repaint();
	}

	public static PaintingWindow openNewEmptyPaintingWindow() {
		return new PaintingWindow();
	}

	public Canvas getCanvasOfThisPaintingWindow() {
		return this.canvasOnThisWindow;
	}

	public void setWindowActionListener(WindowActionListener windowActionListener) {
		this.windowActionListener = windowActionListener;
	}

		private JPanelWrapper createJPanelForThisPaintingWindow() {
			JPanelWrapper newJPanelWrapper =  new JPanelWrapper() {
				@Override
    			protected void paintComponent(GraphicWrapper graphics) {
        			super.paintComponent(graphics);
        			GraphicsDelegate graphicsDelegate = GraphicsDelegate.graphicsDelegateFromGraphics(graphics);
        			PaintingWindow.this.canvasOnThisWindow.giveCanvasImageToGraphicsDelegate(graphicsDelegate);
				}
			};
			return newJPanelWrapper;
		}
}