package soldiers;


import java.util.*;

import field.Board;
import field.BoardHelpers;
import field.Play;
import field.Tile;


/**
 * 
 * @author mikeliu8492
 * New class extended from Piece.  Works similarly to the rook in that it can move horizantally and vertically.
 * However, it can only move 4 spaces at most at any given time.
 */

public class ShortRook extends Piece
{

	public ShortRook(int pieceRow, int pieceColumn, Side pieceColor) 
	{
		super(pieceRow, pieceColumn, pieceColor);
	}

	//calculates vectors where the rook can move
	private static final MovePair[] POTENTIAL_VECTORS = 
	{
		new MovePair(-1, 0), new MovePair(1, 0), new MovePair(0, -1), new MovePair(0, 1)
	};
	
	
	//calculates places where the rook can move
	public Collection<Play> calculatePlays(Board chessBoard)
	{
		List<Play> validPlays = new ArrayList<Play>();
		calculateVectorPositions(validPlays, POTENTIAL_VECTORS ,chessBoard, 4);		
		return validPlays;
	}

	public void printPiece()
	{
		printColor();
		System.out.print("SR ");
	}
	
	public Piece copyPiece(int row, int column, Piece templatePiece)
	{
		Piece tempShortRook = new ShortRook(row, column, templatePiece.getColor());
		tempShortRook.moveHistory = templatePiece.getMoveHistory();
		return tempShortRook;
	}
	
	public String toString()
	{
		return colorString() + "SR";
	}
	
}
