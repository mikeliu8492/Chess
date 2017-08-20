package gamer;

import java.util.*;

import field.Board;
import field.Play;
import soldiers.Piece;
import soldiers.Side;
import session.*;

public class BlackGamer extends Gamer
{
	public BlackGamer(final Board passInBoard, Session currentSession, Collection<Play> ownMoves, Collection<Play> opponentMoves)
	{
		super(passInBoard, currentSession, ownMoves, opponentMoves);
	}
	
	
	
	/*
	 * Get the active pieces for yourself
	 * */
	
	public Collection<Piece> findLivingPieces()
	{
		return this.chessBoard.yourActiveBlackPieces();

	}
	
	
	
	public Side getColor()
	{
		return Side.BLACK;
	}
	
	public Gamer getEnemy()
	{
		return this.currentSession.getWhiteGamer();
	}

}
