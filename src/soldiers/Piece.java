package soldiers;

import java.util.*;

import field.*;

public abstract class Piece 
{
	protected int pieceRow;
	protected int pieceColumn;
	protected final Side pieceColor;
	protected boolean isInitialMove;
	protected ArrayList<MovePair> moveHistory;
	
	/**
	 * Basic constructor for Piece
	 * @param pieceRow
	 * @param pieceColumn
	 * @param pieceColor
	 */
	public Piece(int pieceRow,  int pieceColumn, final Side pieceColor)
	{
		this.moveHistory = new ArrayList<MovePair>();
		this.pieceRow = pieceRow;
		this.pieceColumn = pieceColumn;
		this.pieceColor = pieceColor;
		this.isInitialMove = true;
	}
	
	public void setCoordinates(int row, int col)
	{
		this.pieceRow = row;
		this.pieceColumn = col;
	}
	
	/**
	 * Get the valid plays the Piece could make
	 * @param chessBoard		chessBoard to evaluate the current piece on
	 * @return					Collection of Plays the Piece could make
	 */
	public abstract Collection<Play> calculatePlays(final Board chessBoard);
	
	/**
	 * copy the old Piece to a new location on the new Board
	 * @param row
	 * @param column
	 * @param templatePiece
	 * @return
	 */
	public abstract Piece copyPiece(int row, int column, Piece templatePiece);
	
	/**
	 * print the Piece information
	 */
	public abstract void printPiece();
	
	/**
	 * print the Piece color
	 */	
	public void printColor()
	{
		if(this.pieceColor == Side.WHITE)
			System.out.print("W");
		else
			System.out.print("B");
	}
	
	/**
	 * Boolean on whether the piece has had an initial move
	 * @return
	 */
	public boolean isInitialMove()
	{
		return moveHistory.isEmpty();
	}
	
	/**
	 * 
	 * @return Color of the Piece
	 */
	public Side getColor()
	{
		return pieceColor;
	}
	
	public int getPieceRow()
	{
		return pieceRow;
	}
	
	public int getPieceColumn()
	{
		return pieceColumn;
	}
	
	/**
	 * 
	 * @return the move history of the Piece
	 */
	public ArrayList<MovePair> getMoveHistory()
	{
		return moveHistory;
	}
	
	public String colorString()
	{
		if(this.pieceColor == Side.WHITE)
			return "W";
		else
			return "B";
	}
	
	public abstract String toString();
	
	/**
	 * 
	 * @param validPlays
	 * @param POTENTIAL_POSITIONS
	 * @param chessBoard
	 */
	
	protected void calculateFixedPositions(List<Play> validPlays, MovePair [] POTENTIAL_POSITIONS, Board chessBoard)
	{		
		
		for(final MovePair position: POTENTIAL_POSITIONS)
		{
			int destinationRow = this.pieceRow + position.getRowChange();
			int destinationColumn = this.pieceColumn + position.getColumnChange();
			
			if(BoardHelpers.presentOnBoard(destinationRow, destinationColumn, chessBoard.getDimension()))
			{
				Tile endTile= chessBoard.getTile(destinationRow, destinationColumn);
				if(!endTile.isFilled())
				{
					validPlays.add(new Play(chessBoard, this, destinationRow, destinationColumn));
				}
				else
				{
					Piece standingPiece = endTile.holdPiece();
					Side standingColor = standingPiece.pieceColor;
					
					if(this.getColor() != standingColor)
					{
						validPlays.add(new Play(chessBoard, this, destinationRow, destinationColumn));
					}
				}
			}
		}
		
	}

	protected void calculateVectorPositions(List<Play> validPlays, MovePair[] POTENTIAL_VECTORS,  Board chessBoard, int longestDistance)
	{
		for(final MovePair position: POTENTIAL_VECTORS)
		{ 
			int destinationRow = this.pieceRow;
			int destinationColumn = this.pieceColumn;
			
			int distanceTraveled = 0;
			
			while(BoardHelpers.presentOnBoard(destinationRow, destinationColumn, chessBoard.getDimension()) 
					&& distanceTraveled < longestDistance)
			{
				destinationRow += position.getRowChange();
				destinationColumn += position.getColumnChange();
				
				if(BoardHelpers.presentOnBoard(destinationRow, destinationColumn, chessBoard.getDimension()))
				{
					Tile endTile= chessBoard.getTile(destinationRow, destinationColumn);
					if(!endTile.isFilled())
					{
						validPlays.add(new Play(chessBoard, this, destinationRow, destinationColumn));
					}
					
					else
					{
						Piece standingPiece = endTile.holdPiece();
						Side standingColor = standingPiece.pieceColor;
						
						if(this.getColor() != standingColor)
						{
							validPlays.add(new Play(chessBoard, this, destinationRow, destinationColumn));
						}
						break;
					}
					
				}
				distanceTraveled++;

			}
		}
		
	}
	
}

