package slo.model;

import java.util.ArrayList;
import java.util.Random;

public class SLOModel 
{
	private ArrayList<String> outcomeList;
	Random outcomeGenerator = new Random();
	
	public SLOModel()
	{
		this.outcomeList = new ArrayList<String>();
		
		buildOutcomeList();
	}
	
	private void buildOutcomeList()
	{
		this.outcomeList.add("Rock");
		this.outcomeList.add("Paper");
		this.outcomeList.add("Scissors");
	}
	
	public String outcomeSelector()
	{
		String random = outcomeList.get(outcomeGenerator.nextInt(outcomeList.size()));
		return random;
		
	}
	
}
