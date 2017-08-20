package driver;

import field.*;
import gamer.*;
import soldiers.*;
import session.*;

import java.util.*;

import javax.swing.JOptionPane;

import gui.*;


/*
 * A simple test driver
 * */

public class Driver 
{
	static boolean playForever = true;
	static char restart = 'n';
	
	public static void main(String arg[])
	{
		
		String firstName = JOptionPane.showInputDialog("Please enter name for player 1: ");
		while(firstName.equals(""))
		{
			firstName = JOptionPane.showInputDialog("Please enter name for player 1: ");
		}
		
		String secondName = JOptionPane.showInputDialog("Please enter name for Player 2: ");
		
		while(firstName.equals(secondName) || secondName.equals(""))
		{
			secondName = JOptionPane.showInputDialog("Please enter name for Player 2: ");
		}
		
		Screen myScreen = new Screen(firstName, secondName);
		
		
		while (playForever)
		{
			while(myScreen.gameContinues()){;/*spin, spin spin*/}
			
			myScreen.displayResults();

			while(!myScreen.gameContinues()){;/*spin, spin spin*/}
			
		}

	}

	

}
