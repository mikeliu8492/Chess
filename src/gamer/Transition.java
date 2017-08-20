package gamer;

import field.*;

public class Transition 
{
	private final Board tempBoard;
	private final Play play;
	private final PlayState playState;
	
	/**
	 * Creates a transition state to determine what board looks like after the move
	 * @param tempBoard			temporary board to show how move would change the board
	 * @param play				the play that changed to board to the temporary condition
	 * @param playState			the legality of the previous play
	 */
	Transition(Board tempBoard, Play play, PlayState playState)
	{
		this.tempBoard = tempBoard;
		this.play = play;
		this.playState = playState;
	}
	
	/** 
	 * Shows the kind of play if it can be completed
	 * @return		boolean on whether play can be completed
	 */
	
	public PlayState getPlayState()
	{
		return this.playState;
	}
	
	/**
	 * materialize the new board and substitute it for the old one
	 * @return temporary state board
	 */
	
	public Board materializeBoard()
	{
		return tempBoard;
	}
	
	/**
	 * 
	 * @return the play that resulted in the new board
	 */
	public Play getPlay()
	{
		return play;
	}
}
