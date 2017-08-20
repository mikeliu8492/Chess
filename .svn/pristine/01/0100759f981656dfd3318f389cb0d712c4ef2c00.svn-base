package soldiers;

import java.util.*;



import field.Board;
import field.BoardHelpers;
import field.Play;
import field.Tile;

public class Pawn extends Piece
{

	public Pawn(int pieceRow, int pieceColumn, Side pieceColor) 
	{
		super(pieceRow, pieceColumn, pieceColor);
	}
	
	
	//potential ways a pawn can move relative to original position
	private static final MovePair[] POTENTIAL_POSITIONS = 
	{
		new MovePair(1, 0), new MovePair(2, 0), new MovePair(1, 1), new MovePair(1, -1)
	};
	
	
	
	public List<Play> calculatePlays(Board chessBoard) 
	{
		
		int destinationRow;
		int destinationColumn;
		
		List<Play> validPlays = new ArrayList<Play>();
		
		for(final MovePair position: POTENTIAL_POSITIONS)
		{
			Side currentColor = this.getColor();
			int directionality = currentColor.pawnMovePath();
			
			destinationRow = this.pieceRow + directionality*position.getRowChange();
			destinationColumn = this.pieceColumn + directionality*position.getColumnChange();
			
			
			if(!BoardHelpers.presentOnBoard(destinationRow, destinationColumn, chessBoard.getDimension()))
			{
				continue;
			}
			
			Tile endTile= chessBoard.getTile(destinationRow, destinationColumn);
			
			if(position.getRowChange() == 1 && position.getColumnChange() == 0 && !endTile.isFilled() )
			{
				validPlays.add(new Play(chessBoard, this, destinationRow, destinationColumn));
			}
			
			
			//TO DO correct the pawn piece history to determine legality
			else if (position.getRowChange() == 2 && position.getColumnChange() == 0 && /*this.isInitialMove()*/ isPawnAtStart())
			{
				int precedeDestinationRow = this.pieceRow + directionality*1;
				
				Tile precedingTile = chessBoard.getTile(precedeDestinationRow, destinationColumn);
				
				if(!endTile.isFilled() && !precedingTile.isFilled())
				{
					validPlays.add(new Play(chessBoard, this, destinationRow, destinationColumn));
				}	
			}
			
			else if((position.getRowChange() == 1 && position.getColumnChange() == -1 || position.getRowChange() == 1 && position.getColumnChange() == 1))
			{
				if(endTile.isFilled())
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
	
		
		
	//determine if the pawn is at the start position so that it can just 2 squares
	public boolean isPawnAtStart()
	{
		return this.pieceRow == 1 && this.getColor().isBlack() || this.pieceRow == 6 && this.getColor().isWhite();		
	}
	
	public void printPiece()
	{
		printColor();
		System.out.print("P ");
	}
	
	public Piece copyPiece(int row, int column, Piece templatePiece)
	{
		Piece tempPawn = new Pawn(row, column, templatePiece.getColor());
		tempPawn.moveHistory = templatePiece.getMoveHistory();
		return tempPawn;
	}
	
	public String toString()
	{
		return colorString() + "P";
	}
	

}
