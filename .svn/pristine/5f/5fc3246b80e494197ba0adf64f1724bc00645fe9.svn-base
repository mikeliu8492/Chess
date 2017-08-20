package soldiers;


import java.util.*;

import field.Board;
import field.BoardHelpers;
import field.Play;
import field.Tile;
import field.Play.*;

public class Bishop extends Piece
{
	
	/*
	 * Basic constructor
	 * */
	public Bishop(int pieceRow, int pieceColumn, Side pieceColor) 
	{
		super(pieceRow, pieceColumn, pieceColor);
	}
	
	
	/*
	 * Vectors that indicate diagonal directions bishop can move
	 * */

	private static final MovePair[] POTENTIAL_VECTORS = 
	{
		new MovePair(-1, -1), new MovePair(1, 1), new MovePair(-1, 1), new MovePair(1, -1)
	};
	
	
	/*
	 * Calculate legal moves for Bishop.  Bishop stops when it hits a friendly or enemy piece.  Whether that final move
	 * is included depends on color of said piece.
	 * */
	
	public Collection<Play> calculatePlays(Board chessBoard)
	{
		List<Play> validPlays = new ArrayList<Play>();
		calculateVectorPositions(validPlays, POTENTIAL_VECTORS ,chessBoard, chessBoard.getDimension()-1);
		return validPlays;
	}
	

	/*
	 * print out the color and type of piece
	 * */
	public void printPiece()
	{
		printColor();
		System.out.print("B ");
	}
	
	/*
	 * Copy piece for other purposes
	 * */
	
	public String toString()
	{
		return colorString() + "B";
	}
	
	public Piece copyPiece(int row, int column, Piece templatePiece)
	{
		Piece tempBishop = new Bishop(row, column, templatePiece.getColor());
		tempBishop.moveHistory = templatePiece.getMoveHistory();
		return tempBishop;
	}
}

