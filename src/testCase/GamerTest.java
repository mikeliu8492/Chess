package testCase;

import java.util.Collection;

import field.Board;
import field.Play;
import gamer.*;
import junit.framework.TestCase;
import session.Session;
import soldiers.*;

public class GamerTest extends TestCase 
{
	
	/**
	 * Test to determine if both player can acquire a new set of active pieces and valid moves when the board configuration changes.
	 */
	
	public void testChangeStatus() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		Board chessBoard = new Board();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		assertEquals(white.getMoveOptions().size(), 20);
		assertEquals(black.getMoveOptions().size(), 20);
		assertFalse(black.inCheck());
		
		Board changedBoard = new Board(1);
		
		changedBoard.setFilled(7, 7, new King(7, 7, Side.BLACK));
		changedBoard.setFilled(0, 0, new King(0, 0, Side.WHITE));
		changedBoard.setFilled(5, 5, new Bishop(5, 5, Side.WHITE));
		
		changedBoard.updateLists();
		
		white.changeStatus(changedBoard, changedBoard.getWhiteValidMove(), changedBoard.getBlackValidMove());
		black.changeStatus(changedBoard, changedBoard.getBlackValidMove(), changedBoard.getWhiteValidMove());
		
		assertEquals(black.getMoveOptions().size(), 3);
		assertTrue(black.inCheck());
		
	}

	/**
	 * Test if the player can be placed in check.
	 */
	public void testInCheck() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board(1);
		
		chessBoard.setFilled(7, 7, new King(7, 7, Side.BLACK));
		chessBoard.setFilled(0, 0, new King(0, 0, Side.WHITE));
		chessBoard.setFilled(5, 5, new Bishop(5, 5, Side.WHITE));
		
		chessBoard.updateLists();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		assertTrue(black.inCheck());
	}

	/**
	 * check if a player can be placed in Checkmate
	 * 
	 */
	public void testInCheckmate() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board(1);
		
		chessBoard.setFilled(7, 7, new King(7, 7, Side.BLACK));
		chessBoard.setFilled(7, 0, new Rook(7, 0, Side.WHITE));
		chessBoard.setFilled(0, 7, new Rook(0, 7, Side.WHITE));
		chessBoard.setFilled(0, 0, new King(0, 0, Side.WHITE));
		chessBoard.setFilled(5, 5, new Bishop(5, 5, Side.WHITE));
		
		chessBoard.updateLists();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		assertTrue(black.inCheckmate());
	}
	
	/**
	 * check if the player can be placed in Stalemate
	 */

	public void testReachedStalemate() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board(1);
		
		chessBoard.setFilled(0, 7, new King(0, 7, Side.BLACK));
		chessBoard.setFilled(1, 5, new King(1, 5, Side.WHITE));
		chessBoard.setFilled(2, 6, new Queen(2, 6, Side.WHITE));
		
		chessBoard.updateLists();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		assertTrue(black.reachedStalemate());
	}
	
	/**
	 * Test to determine if the player can escape given a "check" situation
	 */

	public void testCanEscape() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board(1);
		
		chessBoard.setFilled(0, 7, new King(0, 7, Side.BLACK));
		chessBoard.setFilled(1, 5, new King(1, 5, Side.WHITE));
		chessBoard.setFilled(2, 6, new Queen(2, 6, Side.WHITE));
		chessBoard.setFilled(6, 6, new Queen(6, 6, Side.BLACK));
		
		chessBoard.updateLists();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		assertTrue(black.canEscape(chessBoard.getWhiteValidMove()));
	}

	
	/**
	 * Evaluate to determine a play can be complete given it is legal and does not put King in Check.
	 */
	public void testRequestPlayValid() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board(1);
		
		chessBoard.setFilled(0, 7, new King(0, 7, Side.BLACK));
		chessBoard.setFilled(1, 5, new King(1, 5, Side.WHITE));
		chessBoard.setFilled(2, 6, new Queen(2, 6, Side.WHITE));
		chessBoard.setFilled(6, 6, new Queen(6, 6, Side.BLACK));
		
		chessBoard.updateLists();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		Piece targetPiece = chessBoard.getTile(6, 6).holdPiece();
		Play targetPlay = new Play(chessBoard, targetPiece, 2, 6);
		
		Transition yourChange = black.requestPlay(targetPlay, white.getMoveOptions());
		
		assertEquals(yourChange.getPlayState(), PlayState.COMPLETE);
		
		
	}
	
	
	/**
	 * Evaluate if game can determine an illegal play.
	 */
	public void testRequestPlayInvalid() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board(1);
		
		chessBoard.setFilled(0, 7, new King(0, 7, Side.BLACK));
		chessBoard.setFilled(1, 5, new King(1, 5, Side.WHITE));
		chessBoard.setFilled(2, 6, new Queen(2, 6, Side.WHITE));
		chessBoard.setFilled(6, 6, new Queen(6, 6, Side.BLACK));
		
		chessBoard.updateLists();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		Piece targetPiece = chessBoard.getTile(6, 6).holdPiece();
		Play targetPlay = new Play(chessBoard, targetPiece, 8, 8);
		
		Transition yourChange = black.requestPlay(targetPlay, white.getMoveOptions());
		
		assertEquals(yourChange.getPlayState(), PlayState.ILLEGAL);
	}
	
	
	/**
	 * Evaluate if the King cannot be put in Check deliberate by its player.
	 */
	public void testRequestPlayCheck() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board(1);
		
		chessBoard.setFilled(0, 7, new King(0, 7, Side.BLACK));
		chessBoard.setFilled(1, 5, new King(1, 5, Side.WHITE));
		chessBoard.setFilled(2, 6, new Queen(2, 6, Side.WHITE));
		chessBoard.setFilled(6, 6, new Queen(6, 6, Side.BLACK));
		
		chessBoard.updateLists();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		Piece targetPiece = chessBoard.getTile(0, 7).holdPiece();
		Play targetPlay = new Play(chessBoard, targetPiece, 1, 6);
		
		Transition yourChange = black.requestPlay(targetPlay, white.getMoveOptions());
		
		assertEquals(yourChange.getPlayState(), PlayState.KING_STILL_VULNERABLE);
	}


	/**
	 * Test if you can get the enemy player so the game can know their valid 
	 */
	public void testGetEnemy() 
	{
		Session mySession = new Session();
		Gamer extWhite = mySession.getWhiteGamer();
		assertEquals(extWhite.getEnemy(), mySession.getBlackGamer());
		
	}

}
