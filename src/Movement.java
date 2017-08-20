public class Movement 
{
	
	
	public void showMoveList(Tile initialTile)
	{
		int ruleType = initialTile.heldPiece.pieceType;
		switch(ruleType)
		{
			case 1:
				pawnLogic(initialTile);
			case 2:
				rookLogic();
			case 3:
				bishopLogic();
			case4:
				knightLogic();
			case5:
				queenLogic();
			case6:
				kingLogic();
		
		}
		
	}
	
	public void pawnLogic(Tile initialTile)
	{
		Piece accessPiece = initialTile.heldPiece;
		if(accessPiece.getColor() == 1)
		{
			if
			
		}
		else
		{
			
		}
		
		
	}
	
	
	

}
