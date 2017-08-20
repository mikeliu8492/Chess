public class Player 
{
	private int playerColor;
	
	protected int activePawns;
	protected int activeBishops;
	protected int activeRooks;
	protected int activeKnights;
	protected int activeQueens;
	protected int activeKing;
	
	protected boolean inCheck;
	protected boolean checkMate;
	
	Player(int assignedColor)
	{
		playerColor = assignedColor;
		activePawns = 8;
		activeBishops = 2;
		activeRooks = 2;
		activeKnights = 2;
		activeQueens = 2;
		activeKing = 1;
		inCheck = false;
		checkMate = false;
		
	}
	
	public int getColor()
	{
		return playerColor;
	}
	
	
	public void removePiece(int pieceType)
	{
		switch(pieceType)
		{
			case 1:
				activePawns--;
				break;
			case 2:
				activeRooks--;
				break;
			case 3:
				activeBishops--;
				break;
			case 4:
				activeKnights--;
				break;
			case 5:
				activeQueens--;
				break;
		
		}
		
	}
	
	
	
	public Piece salvagePiece(int pieceType)
	{
		activePawns--;
		
		switch(pieceType)
		{
			case 1:
				activePawns++;
				return new Piece(1, playerColor);
			case 2:
				activeRooks++;
				return new Piece(2, playerColor);
			case 3:
				activeBishops++;
				return new Piece(3, playerColor);
			case 4:
				activeKnights++;
				return new Piece(4, playerColor);
			case 5:
				activeQueens++;
				return new Piece(5, playerColor);
			default:
				return null;
		
		}
		
	}

	
	
}
