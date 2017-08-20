public class Game 
{
	private int currentTurn;
	private Board initialGameBoard;
	Player gamerWhite;
	Player gamerBlack;
	
	public void initiateGame()//(Player player1, Player player2)
	{
		initialGameBoard = new Board();
		gamerWhite = new Player(1);
		gamerBlack = new Player(2);
	}
	
	
	Game()
	{
		currentTurn = 1;
		initiateGame();
	}
	
	public int getCurrentTurn()
	{
		return currentTurn;
	}
	
	
	public void changeTurn()
	{
		if(currentTurn == 1)
		{
			currentTurn = 2;
		}
		else
		{
			currentTurn = 1;
		}
			
	}
	
	public void display()
	{
		initialGameBoard.displayCurrentBoard();
	}
	
	void movePiece(int row, int column) 
	{
		
	}
	
	
	
}
