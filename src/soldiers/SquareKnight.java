package soldiers;

import java.util.*;

import field.*;
import field.Play.*;

/**
 * 
 * @author mikeliu8492
 * Extended class of Piece.  Works like the Knight in that it can jump over pieces, but it jumps in units of 2
 */

public class SquareKnight extends Piece
{


	private static final MovePair[] POTENTIAL_POSITIONS = 
	{
		new MovePair(-2, -2), new MovePair(-2, 2), new MovePair(2, -2), new MovePair(2, 2)
	};
	
	public SquareKnight(final int pieceRow, final int pieceColumn, final Side pieceColor) 
	{
		super(pieceRow, pieceColumn, pieceColor);
	}

	
	@Override
	public List<Play> calculatePlays(Board chessBoard) 
	{
		
		int destinationRow;
		int destinationColumn;
		
		List<Play> validPlays = new ArrayList<Play>();
		
		for(final MovePair position: POTENTIAL_POSITIONS)
		{
			destinationRow = this.pieceRow + position.getRowChange();
			destinationColumn = this.pieceColumn + position.getColumnChange();
			
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
		
		return validPlays;
	}

	@Override
	public void printPiece()
	{
		printColor();
		System.out.print("SK ");
	}
	
	@Override
	public Piece copyPiece(int row, int column, Piece templatePiece)
	{
		Piece tempSquareKnight = new SquareKnight(row, column, templatePiece.getColor());
		tempSquareKnight.moveHistory = templatePiece.getMoveHistory();
		return tempSquareKnight;
	}

	public String toString()
	{
		return colorString() + "SK";
	}

}