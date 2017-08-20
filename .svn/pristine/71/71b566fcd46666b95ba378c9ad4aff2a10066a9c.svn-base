package gamer;

import java.util.*;

import field.Board;
import field.Play;
import session.Session;
import soldiers.Piece;
import soldiers.Side;

public class WhiteGamer extends Gamer
{
	public WhiteGamer(final Board passInBoard, Session currentSession, Collection<Play> ownMoves, Collection<Play> opponentMoves)
	{
		super(passInBoard, currentSession, ownMoves, opponentMoves);
	}
	
	
	@Override
	public Collection<Piece> findLivingPieces()
	{
		return this.chessBoard.yourActiveWhitePieces();
	}
	
	public Side getColor()
	{
		return Side.WHITE;
	}
	
	public Gamer getEnemy()
	{
		return this.currentSession.getBlackGamer();
	}
	
}
