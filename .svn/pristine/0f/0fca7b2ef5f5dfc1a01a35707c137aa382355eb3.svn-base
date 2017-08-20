package soldiers;

import java.util.*;

import field.Board;
import field.BoardHelpers;
import field.Play;
import field.Tile;

public class Queen extends Piece
{
	public Queen(int pieceRow, int pieceColumn, Side pieceColor) 
	{
		super(pieceRow, pieceColumn, pieceColor);
	}

	//shows potential vectors where the queen can move
	private static final MovePair[] POTENTIAL_VECTORS = 
	{
		new MovePair(-1, -1), new MovePair(1, 1), new MovePair(-1, 1), new MovePair(1, -1),
		new MovePair(-1, 0), new MovePair(1, 0), new MovePair(0, -1), new MovePair(0, 1)
	};
	
	
	//calculate where the queen can move
	public Collection<Play> calculatePlays(Board chessBoard)
	{
		List<Play> validPlays = new ArrayList<Play>();
		calculateVectorPositions(validPlays, POTENTIAL_VECTORS ,chessBoard, 7);
		return validPlays;
	}

	public void printPiece()
	{
		printColor();
		System.out.print("Q ");
	}
	
	public Piece copyPiece(int row, int column, Piece templatePiece)
	{
		Piece tempQueen = new Queen(row, column, templatePiece.getColor());
		tempQueen.moveHistory = templatePiece.getMoveHistory();
		return tempQueen;
	}
	
	public String toString()
	{
		return colorString() + "Q";
	}
	
}