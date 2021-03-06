package slo.view;

import slo.controller.SLOController;
import slo.view.SLOPanel;

import javax.swing.JFrame;

public class SLOFrame extends JFrame
{
	private SLOController baseController;
	private SLOPanel basePanel;
	
	public SLOFrame(SLOController baseController)
	{
		this.baseController = baseController;
		basePanel = new SLOPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);               //Must be the first line of the setupFrame! - Installs the panel in the frame
		this.setSize(400, 400);                       //Find a good size for the app
		this.setTitle("Rock, Paper, Scissors");       //Sets the title of the window
		this.setResizable(false);       			  //Advisable not required
		this.setVisible(true);          			  //Must be the last line of the setupFrame!
	}
	
	public SLOController getBaseController()
	{
		return baseController;
	}
}
