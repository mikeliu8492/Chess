public class Board 
{
	protected Tile[][] chessBoard; 
	
	
	
	Board()
	{
		chessBoard = new Tile[8][8];
		for(int row = 0; row < 8; row++)
		{
			for (int col = 0; col < 8; col++)
			{
				chessBoard[row][col] = new Tile(row, col);
			}
		}
		
		placePawns();
		placeRooks();
		placeBishops();
		placeKnights();
		placeRoyalty();
		
	}
	
	public void displayCurrentBoard()
	{
		for(int row = 0; row < 8; row++)
		{
			for (int col = 0; col < 8; col++)
			{
				Tile currentTile = chessBoard[row][col];
				if (currentTile.heldPiece == null)
					System.out.print("__ ");
				else
				{
					Piece currentPiece = currentTile.heldPiece;
					currentPiece.displayPiece();
				}
					
			}
			System.out.print("\n");
		}
		
		
	}
	
	
	
	
	
	
	
	public void placePawns()
	{
		for(int i = 0; i < 8; i++)
		{
			for (int m = 0; m < 8; m++)
			{
				if(i == 1)
				{
					chessBoard[i][m].placePiece(1, 2);	
				}
				
				else if(i == 6)
				{
					chessBoard[i][m].placePiece(1, 1);
				}	
			}	
		}
	}
	
	
	
	public void placeRooks()
	{
		chessBoard[0][0].heldPiece = new Piece(2, 2);	
		chessBoard[0][7].heldPiece = new Piece(2, 2);
		chessBoard[7][0].heldPiece = new Piece(2, 1);
		chessBoard[7][7].heldPiece = new Piece(2, 1);
	}
	
	
	protected void placeBishops()
	{
		chessBoard[0][6].heldPiece = new Piece(3, 2);
		chessBoard[0][1].heldPiece = new Piece(3, 2);
		chessBoard[7][1].heldPiece = new Piece(3, 1);
		chessBoard[7][6].heldPiece = new Piece(3, 1);
		
	}
	
	protected void placeKnights()
	{
		chessBoard[0][5].heldPiece = new Piece(4, 2);
		chessBoard[0][2].heldPiece = new Piece(4, 2);
		chessBoard[7][2].heldPiece = new Piece(4, 1);
		chessBoard[7][5].heldPiece = new Piece(4, 1);
	}
	
	
	protected void placeRoyalty()
	{
		chessBoard[0][3].heldPiece = new Piece(5, 2);
		chessBoard[0][4].heldPiece = new Piece(6, 2);
		chessBoard[7][3].heldPiece = new Piece(5, 1);
		chessBoard[7][4].heldPiece = new Piece(6, 1);
	}
}
