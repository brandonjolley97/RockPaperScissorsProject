package slo.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

import slo.controller.SLOController;

public class SLOPanel extends JPanel
{
	private SLOController baseController;
	private SpringLayout baseLayout;
	private JLabel promptLabel;
	private JTextArea resultsDisplay;
	private JTextArea WLDisplay;
	private JButton SPButton;
	private JButton MPButton;
	private JButton rockButton;
	private JButton paperButton;
	private JButton scissorsButton;
	private boolean isSP = false;
	private int numWins = 0;
	private int numLosses = 0;
	private String pOneSelection = "";
	private String pTwoSelection = "";
	
	public SLOPanel(SLOController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		promptLabel = new JLabel ("Select 1 Player or 2 Players");
		WLDisplay = new JTextArea(10, 5);
		resultsDisplay = new JTextArea(10, 30);
		SPButton = new JButton("1 Player");
		MPButton = new JButton("2 Players");
		rockButton = new JButton("Rock");
		paperButton = new JButton("Paper");
		scissorsButton = new JButton("Scissors");
		
		
		setupSLOPane();
		setupLayout();
		setupPanel();
		setupListeners();
	}
	
	private void setupSLOPane()
	{
		resultsDisplay.setLineWrap(false);
		resultsDisplay.setWrapStyleWord(true);
		resultsDisplay.setEditable(false);
		WLDisplay.setLineWrap(true);
		WLDisplay.setWrapStyleWord(true);
		WLDisplay.setEditable(false);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, promptLabel, 5, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, resultsDisplay, 0, SpringLayout.NORTH, WLDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, resultsDisplay, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, WLDisplay, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 132, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, scissorsButton, -37, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, paperButton, -51, SpringLayout.WEST, scissorsButton);
		baseLayout.putConstraint(SpringLayout.NORTH, scissorsButton, 0, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.NORTH, paperButton, 0, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.WEST, rockButton, 53, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rockButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, MPButton, -5, SpringLayout.NORTH, promptLabel);
		baseLayout.putConstraint(SpringLayout.EAST, MPButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, SPButton, -5, SpringLayout.NORTH, promptLabel);
		baseLayout.putConstraint(SpringLayout.WEST, SPButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, WLDisplay, -30, SpringLayout.NORTH, scissorsButton);
		baseLayout.putConstraint(SpringLayout.NORTH, resultsDisplay, 0, SpringLayout.NORTH, WLDisplay);
		baseLayout.putConstraint(SpringLayout.EAST, resultsDisplay, -6, SpringLayout.WEST, WLDisplay);
		baseLayout.putConstraint(SpringLayout.NORTH, resultsDisplay, 0, SpringLayout.NORTH, WLDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, resultsDisplay, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, resultsDisplay, 0, SpringLayout.NORTH, WLDisplay);
		baseLayout.putConstraint(SpringLayout.EAST, resultsDisplay, -6, SpringLayout.WEST, WLDisplay);
		
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(promptLabel);
		this.add(WLDisplay);
		this.add(SPButton);
		this.add(MPButton);
		this.add(rockButton);
		this.add(paperButton);
		this.add(scissorsButton);
		this.add(resultsDisplay);
		baseLayout.putConstraint(SpringLayout.NORTH, resultsDisplay, 0, SpringLayout.NORTH, WLDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, resultsDisplay, 10, SpringLayout.WEST, this);
	}
	
	public void setupListeners()
	{
		SPButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				numWins = 0;
				isSP = true;
				promptLabel.setText("Choose Rock, Paper, or Scissors");
					
			}
		});
		
		MPButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent click)
			{
				numLosses = 0;
				isSP = false;
				promptLabel.setText("Choose Rock, Paper, or Scissors");
					
			}
		});

		rockButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
				if(isSP == true)
				{
					String result = baseController.outcomeSelector();
					if(result.equals("Rock"))
					{
						
						resultsDisplay.setText("Tie!");
						WLDisplay.setText("Wins: " + numWins + " Losses: " + numLosses);
						
					}
					else if(result.equals("Paper"))
					{
						numLosses++;
						resultsDisplay.setText("I Win!");
						WLDisplay.setText("Wins: " + numWins + " Losses: " + numLosses);
					}
					else if(result.equals("Scissors"))
					{
						numWins++;
						resultsDisplay.setText("You Win!");
						WLDisplay.setText("Wins: " + numWins + " Losses: " + numLosses);
					}
				}
				else
				{
					resultsDisplay.setText("Player 1 results saved.  Player 2 may now select");
					pOneSelection = "Rock";
				}
					
			}
		});
		
		paperButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(isSP == true)
				{
					String result = baseController.outcomeSelector();
					if(result.equals("Paper"))
					{
						
						resultsDisplay.setText("Tie!");
						WLDisplay.setText("Wins: " + numWins + " Losses: " + numLosses);
						
					}
					else if(result.equals("Scissors"))
					{
						numLosses++;
						resultsDisplay.setText("I Win!");
						WLDisplay.setText("Wins: " + numWins + " Losses: " + numLosses);
					}
					else if(result.equals("Rock"))
					{
						numWins++;
						resultsDisplay.setText("You Win!");
						WLDisplay.setText("Wins: " + numWins + " Losses: " + numLosses);
					}
				}
				else
				{
					pOneSelection = "Paper";
				}
					
			}
		});
		
		scissorsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(isSP == true)
				{
					String result = baseController.outcomeSelector();
					if(result.equals("Scissors"))
					{
						
						resultsDisplay.setText("Tie!");
						WLDisplay.setText("Wins: " + numWins + " Losses: " + numLosses);
						
					}
					else if(result.equals("Paper"))
					{
						numLosses++;
						resultsDisplay.setText("I Win!");
						WLDisplay.setText("Wins: " + numWins + " Losses: " + numLosses);
					}
					else if(result.equals("Rock"))
					{
						numWins++;
						resultsDisplay.setText("You Win!");
						WLDisplay.setText("Wins: " + numWins + " Losses: " + numLosses);
					}
				}
				else
				{
					pOneSelection = "Scissors";
				}
					
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
