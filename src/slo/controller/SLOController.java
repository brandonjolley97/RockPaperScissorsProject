package slo.controller;

import slo.model.SLOModel;
import slo.view.SLOFrame;

public class SLOController 
{
	SLOModel baseModel;
	SLOFrame baseFrame;
	
	
	
	public SLOController()
	{
		baseFrame = new SLOFrame(this);
		baseModel = new SLOModel();
	}
	
	public void start()
	{
		
	}
	
	public String outcomeSelector()
	{
		return baseModel.outcomeSelector();
		
	}
	
	
}