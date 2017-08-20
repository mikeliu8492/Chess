package soldiers;


import java.util.*;

import field.Board;
import field.BoardHelpers;
import field.Play;
import field.Tile;

public class Rook extends Piece
{
	public Rook(int pieceRow, int pieceColumn, Side pieceColor) 
	{
		super(pieceRow, pieceColumn, pieceColor);
	}

	/**
	 * calculate vector where the Rook can move
	 */
	private static final MovePair[] POTENTIAL_VECTORS = 
	{
		new MovePair(-1, 0), new MovePair(1, 0), new MovePair(0, -1), new MovePair(0, 1)
	};
	
	
	//calculates places where the rook can move
	public Collection<Play> calculatePlays(Board chessBoard)
	{
		List<Play> validPlays = new ArrayList<Play>();
		calculateVectorPositions(validPlays, POTENTIAL_VECTORS ,chessBoard, chessBoard.getDimension()-1);
		return validPlays;
	}

	public void printPiece()
	{
		printColor();
		System.out.print("R ");
	}
	
	public Piece copyPiece(int row, int column, Piece templatePiece)
	{
		Piece tempRook = new Rook(row, column, templatePiece.getColor());
		tempRook.moveHistory = templatePiece.getMoveHistory();
		return tempRook;
	}
	
	public String toString()
	{
		return colorString() + "R";
	}
	
}
