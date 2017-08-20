package soldiers;

import java.util.*;

import field.*;
import field.Play.*;

public class Knight extends Piece
{

	/*
	 * Positions knight can move to relative to original position
	 * */
	private static final MovePair[] POTENTIAL_POSITIONS = 
	{
		new MovePair(-2, -1), new MovePair(-1, -2), new MovePair(-2, 1), new MovePair(-1, 2), 
		new MovePair(2, -1), new MovePair(1, -2), new MovePair(2, 1), new MovePair(1, 2)
	};
	
	public Knight(final int pieceRow, final int pieceColumn, final Side pieceColor) 
	{
		super(pieceRow, pieceColumn, pieceColor);
	}

	
	//calculate the valid moves the knight could go to
	@Override
	public List<Play> calculatePlays(Board chessBoard) 
	{
		
		List<Play> validPlays = new ArrayList<Play>();
		calculateFixedPositions(validPlays, POTENTIAL_POSITIONS, chessBoard);
		
		return validPlays;
	}

	public void printPiece()
	{
		printColor();
		System.out.print("N ");
	}
	
	public Piece copyPiece(int row, int column, Piece templatePiece)
	{
		Piece tempKnight = new Knight(row, column, templatePiece.getColor());
		tempKnight.moveHistory = templatePiece.getMoveHistory();
		return tempKnight;
	}
	
	public String toString()
	{
		return colorString() + "N";
	}

	

}
