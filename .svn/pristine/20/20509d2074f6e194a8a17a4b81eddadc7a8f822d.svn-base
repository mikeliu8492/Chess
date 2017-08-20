package testCase;

import session.*;
import soldiers.*;

import java.util.Collection;

import field.Board;
import field.Play;
import field.Tile;
import gamer.Gamer;
import gamer.PlayState;
import gamer.Transition;
import junit.framework.TestCase;

public class SessionTest extends TestCase 
{

	/**
	 * Test if the player can change turn properly.
	 */
	
	public void testChangeTurn() 
	{
		//by default the session starts out as White player
		Session mySession = new Session();
		Gamer myGamer = mySession.getCurrentPlayer();
		assertTrue(myGamer.getColor() == Side.WHITE);
		assertTrue(myGamer == mySession.getWhiteGamer());
		
		mySession.changeTurn();
		myGamer = mySession.getCurrentPlayer();
		assertTrue(myGamer.getColor() == Side.BLACK);
		assertTrue(myGamer == mySession.getBlackGamer());
		
	}

	/**
	 * Make a valid move.  Then test to see if new board has correct positions.
	 * 
	 * */
	
	public void testMakeMoveValid() 
	{
		Session mySession = new Session();
		Board originalBoard = mySession.getBoard();
		Piece grabbedPiece = originalBoard.getTile(6, 0).holdPiece();
		Play makePlay = new Play(originalBoard, grabbedPiece, 4, 0);
		mySession.makeMove(makePlay);
		mySession.setChessBoard();
		Board newBoard = mySession.getBoard();
		
		Tile myTile = newBoard.getTile(4, 0);
		Tile oldTile = newBoard.getTile(6, 0);
		Piece myPiece = myTile.holdPiece();
		
		assertNotSame(originalBoard, newBoard);
		assertFalse(oldTile.isFilled());
		assertTrue(myTile.isFilled());
		assertTrue(myPiece instanceof Pawn);
	}
	
	

	/**
	 * Test to make sure a non-knight cannot jump over pieces
	 */
	
	public void testMakeMoveIllegal_one() 
	{
		Session mySession = new Session();
		Board originalBoard = mySession.getBoard();
		Piece grabbedPiece = originalBoard.getTile(7, 0).holdPiece();
		Play makePlay = new Play(originalBoard, grabbedPiece, 1, 0);
		Transition myTransit = mySession.makeMove(makePlay);
		assertTrue(myTransit.getPlayState() != PlayState.COMPLETE);
		assertTrue(myTransit.getPlayState() == PlayState.ILLEGAL);
	}
	

	/**
	 * Test to make sure pieces can only move in the pattern they are suppose to move.
	 */
	public void testMakeMoveIllegal_two() 
	{
		Session mySession = new Session();
		Board originalBoard = mySession.getBoard();
		Piece grabbedPiece = originalBoard.getTile(7, 1).holdPiece();
		Play makePlay = new Play(originalBoard, grabbedPiece, 5, 3);
		Transition myTransit = mySession.makeMove(makePlay);
		assertTrue(myTransit.getPlayState() != PlayState.COMPLETE);
		assertTrue(myTransit.getPlayState() == PlayState.ILLEGAL);
	}
	
	/**
	 * This makes a play for black to capture one of white's pieces.
	 * Now we examine if the inventory keeps track of the correct number of
	 * pieces on the board.
	 */
	
	public void testPieceCaptured()
	{
		Session mySession = new Session();
		
		Board currentBoard = mySession.getBoard();
		Piece grabbedPiece = currentBoard.getTile(6, 0).holdPiece();
		Play myPlay = new Play(currentBoard, grabbedPiece, 4, 0);
		mySession.makeMove(myPlay);
		mySession.setChessBoard();
		
		currentBoard = mySession.getBoard();
		grabbedPiece = currentBoard.getTile(1, 0).holdPiece();
		myPlay = new Play(currentBoard, grabbedPiece, 3, 0);
		mySession.makeMove(myPlay);
		mySession.setChessBoard();
		
		currentBoard = mySession.getBoard();
		grabbedPiece = currentBoard.getTile(6, 1).holdPiece();
		myPlay = new Play(currentBoard, grabbedPiece, 4, 1);
		mySession.makeMove(myPlay);
		mySession.setChessBoard();
		
		currentBoard = mySession.getBoard();
		grabbedPiece = currentBoard.getTile(3, 0).holdPiece();
		myPlay = new Play(currentBoard, grabbedPiece, 4, 1);
		mySession.makeMove(myPlay);
		mySession.setChessBoard();
		
		currentBoard = mySession.getBoard();
		Collection<Piece> white = currentBoard.yourActiveWhitePieces();
		Collection<Piece> black = currentBoard.yourActiveBlackPieces();
		
		assertEquals(15, white.size());
		assertEquals(16, black.size());
		
		Piece myPiece = currentBoard.getTile(4, 1).holdPiece();
		assertTrue(myPiece instanceof Pawn);
		assertTrue(myPiece.getColor() == Side.BLACK);
		

	}

	
}
