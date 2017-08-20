package soldiers;

import java.util.*;

import field.*;

public class King extends Piece
{

	/*
	 * Tiles relevant to home tile of the king that the king can move to
	 * */
	private static final MovePair[] POTENTIAL_POSITIONS = 
	{
		new MovePair(-1, -1), new MovePair(-1, 0), new MovePair(-1, 1), new MovePair(0, -1), 
		new MovePair(0, 1), new MovePair(1, -1), new MovePair(1, 0), new MovePair(1, 1)
	};
	
	public King(final int pieceRow, final int pieceColumn, final Side pieceColor) 
	{
		super(pieceRow, pieceColumn, pieceColor);
	}

	
	
	/**
	 * Calculate where the king can move to
	 * */
	
	@Override
	public List<Play> calculatePlays(Board chessBoard) 
	{
		List<Play> validPlays = new ArrayList<Play>();
		calculateFixedPositions(validPlays, POTENTIAL_POSITIONS ,chessBoard);	
		return validPlays;
	}
	
	
	public void printPiece()
	{
		printColor();
		System.out.print("K ");
	}

	public Piece copyPiece(int row, int column, Piece templatePiece)
	{
		Piece tempKing = new King(row, column, templatePiece.getColor());
		tempKing.moveHistory = templatePiece.getMoveHistory();
		return tempKing;
	}
	
	public String toString()
	{
		return colorString() + "K";
	}

}