package field;

import soldiers.*;
import field.*;
import gamer.*;

import java.util.*;


/**
 * 
 * @author mikeliu8492
 *  
 *  This class creates some utility functions for unit testing and board functioning.
 */
public class BoardHelpers 
{
	
	/**
	 * This function makes sure your 
	 * @param row		the row number
	 * @param column	the column number
	 * @return			boolean whether it is in bounds of the board
	 */
	
	public static boolean presentOnBoard(int row, int column, int maxDim) 
	{
		if(row >= 0 && row < maxDim && column >= 0 && column < maxDim)
			return true;
		return false;
	}
	
	/**
	 * Makes sure a piece is in a specific collection
	 * @param myCollection		Collection of pieces
	 * @param comparison		Type of piece to be compared to
	 * @param row				Original row of the piece
	 * @param column			Original column of the piece
	 * @param mySide			Color of the piece
	 * @return					boolean whether a specific piece is in the player's current Piece collection
	 */
	
	public static boolean locateProperPiece(Collection<Piece> myCollection, Piece comparison,int row, int column, Side mySide)
	{
		for(Piece piece : myCollection)
		{
			if(verifyProperPiece(piece, comparison, row, column, mySide))
				return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param original
	 * @param comparison
	 * @param row
	 * @param column
	 * @param mySide
	 * @return
	 */
	
	public static boolean verifyProperPiece(Piece original, Piece comparison, int row, int column, Side mySide)
	{
		if(original.getClass() == comparison.getClass() && row == original.getPieceRow()  && column == original.getPieceColumn())
		{
			if(original.getColor() == mySide)
				return true;
		}
		
		return false;
	}
	
	
	/*
	 * makes sure a particular play is in a collection of plays
	 * */
	
	public static boolean locateProperPlay(Collection<Play> myCollection, int row, int column)
	{
		for(Play play : myCollection)
		{
			if(verifyProperPlay(play, row, column))
				return true;
		}
		
		return false;
	}
	
	public static boolean verifyProperPlay(Play original, int row, int column)
	{
		if(row == original.getTargetRow()  && column == original.getTargetColumn())
		{
			return true;
		}
		
		return false;
	}
	

}
