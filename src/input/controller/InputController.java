package input.controller;

import input.model.Thingy;
import input.view.PopupDisplay;

public class InputController
{
	private PopupDisplay myPopups;
	private Thingy myTestThing;
	
	public InputController()
	{
		myPopups = new PopupDisplay();
	}
	
	public void start()
	{
		String myName = myPopups.grabAnswer("Type in your name");
		myPopups.showResponse("You typed in: " + myName);
		
		String temp = myPopups.grabAnswer("Type in your age");
		int myAge;
		
		while(!isInteger(temp))
		{
			temp = myPopups.grabAnswer("Type in a positive integer for your age!");
		}
		
		if(isInteger(temp))
		{
			myAge = Integer.parseInt(temp);
		}
		else
		{
			myAge = -9999999;
		}
		
		myPopups.showResponse("You typed " + myAge);
		
		
		String tempWeight = myPopups.grabAnswer("Type in your weight");
		double myWeight;
		
		if(isDouble(tempWeight))
		{
			myWeight = Double.parseDouble(tempWeight);
		}
		else
		{
			myWeight = -.008;
		}
		
		myPopups.showResponse("You typed " + myWeight);
		
		
		myTestThing = new Thingy(myName, myAge, myWeight);
	}
	
	private boolean isInteger(String input)
	{
		boolean isInt = false;
		
		try
		{
			int temp = Integer.parseInt(input);
			isInt = true;
		}
		catch(NumberFormatException error)
		{
			myPopups.showResponse("not an int - bad value will be used");
		}
		
		return isInt;
	}
	
	private boolean isDouble(String input)
	{
		boolean isDouble = false;
		
		try
		{
			double temp = Double.parseDouble(input);
			isDouble = true;
		}
		catch(NumberFormatException error)
		{
			myPopups.showResponse("not a double - bad value will be used");
		}
		return isDouble;
	}
	
}
