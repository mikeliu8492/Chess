package testCase;

import java.util.Collection;

import field.*;
import soldiers.*;
import gamer.*;
import session.*;

import junit.framework.TestCase;

public class BoardTest extends TestCase 
{

	/**
	 * Test to see if initial configuration of board is correct per our understanding of chess.
	 */
	public void testBoard() 
	{
		//ignore this it is only for connecting our gamers so we can test the board
		
		Session filler = new Session();
		
		Board chessBoard = new Board();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		assertFalse(white.inCheck());
		assertFalse(black.inCheck());
		
		assertEquals(chessBoard.getBlackValidMove().size(), 20);
		assertEquals(chessBoard.getWhiteValidMove().size(), 20);
		
		assertEquals(chessBoard.yourActiveWhitePieces().size(), 16);
		assertEquals(chessBoard.yourActiveBlackPieces().size(), 16);
		
	}
	
	/**
	 * Test if your board contains the appropriate number of white Pieces
	 */

	public void testYourActiveWhitePieces() 
	{
		Board blankBoard = new Board(1);
		
		blankBoard.setFilled(1, 2, new Rook(1,2, Side.WHITE));
		blankBoard.setFilled(3, 5, new Bishop(3,5, Side.WHITE));
		
		assertEquals(blankBoard.yourActiveWhitePieces().size(), 2);
		assertEquals(blankBoard.yourActiveBlackPieces().size(), 0);
		
		Rook tempRook = new Rook(1, 2, Side.WHITE);
		Bishop tempBishop = new Bishop(3, 5, Side.WHITE);
		
		assertTrue(BoardHelpers.locateProperPiece(blankBoard.yourActiveWhitePieces(), tempRook, 1, 2, Side.WHITE));
		assertTrue(BoardHelpers.locateProperPiece(blankBoard.yourActiveWhitePieces(), tempBishop, 3, 5, Side.WHITE));
		
	}

	/**
	 * Test if the number of Black pieces are appropriate.
	 */
	
	public void testYourActiveBlackPieces() {
		
		Board blankBoard = new Board(1);
		
		blankBoard.setFilled(1, 2, new Knight(1,2, Side.BLACK));
		blankBoard.setFilled(3, 5, new Queen(3,5, Side.BLACK));
		
		
		assertEquals(blankBoard.yourActiveBlackPieces().size(), 2);
		assertEquals(blankBoard.yourActiveWhitePieces().size(), 0);
		
		Knight tempKnight = new Knight(1, 2, Side.BLACK);
		Queen tempQueen = new Queen(3, 5, Side.BLACK);
		
		assertTrue(BoardHelpers.locateProperPiece(blankBoard.yourActiveBlackPieces(), tempKnight, 1, 2, Side.BLACK));
		assertTrue(BoardHelpers.locateProperPiece(blankBoard.yourActiveBlackPieces(), tempQueen, 3, 5, Side.BLACK));
		
	}
	
	/**
	 * gets all legal moves that a white piece is PHYSICALLY capable of moving to... does not test for "check" conditions
	 */

	public void testGetWhiteValidMove() 
	{
		
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board(1);//initiate empty board
		
		chessBoard.setFilled(2, 2, new Rook(2,2, Side.WHITE));
		chessBoard.setFilled(2, 5, new Queen(2,5, Side.BLACK));
		chessBoard.setFilled(5, 2, new Knight(5,2, Side.WHITE));
		
		chessBoard.updateLists();
		
		assertEquals(chessBoard.getWhiteValidMove().size(), 17);
		
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getWhiteValidMove(), 0, 2));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getWhiteValidMove(), 2, 0));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getWhiteValidMove(), 2, 1));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getWhiteValidMove(), 1, 2));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getWhiteValidMove(), 3, 2));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getWhiteValidMove(), 2, 3));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getWhiteValidMove(), 4, 2));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getWhiteValidMove(), 2, 4));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getWhiteValidMove(), 2, 5));
	}

	/**
	 * gets all legal moves that a black piece is PHYSICALLY capable of moving to... does not test for "check" conditions
	 */
	public void testGetBlackValidMove() 
	{
		
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board(1);//initiate empty board
		
		chessBoard.setFilled(2, 2, new Rook(2,2, Side.WHITE));
		chessBoard.setFilled(2, 5, new Queen(2,5, Side.BLACK));
		chessBoard.setFilled(5, 2, new Knight(5,2, Side.WHITE));
		
		chessBoard.updateLists();
		
		assertEquals(chessBoard.getBlackValidMove().size(), 21);
		
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 2, 6));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 2, 7));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 2, 4));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 2, 3));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 2, 2));
		
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 1, 5));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 0, 5));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 3, 5));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 4, 5));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 5, 5));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 6, 5));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 7, 5));
		
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 1, 6));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 0, 7));
		
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 3, 4));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 4, 3));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 5, 2));
		
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 0, 3));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 1, 4));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 3, 6));
		assertTrue(BoardHelpers.locateProperPlay(chessBoard.getBlackValidMove(), 4, 7));

		
	}

	/**
	 * verifies that in the default board all pieces are in the proper location
	 * */
	public void testSetValidPieces() 
	{
		

		Board temp = new Board();
		
		
		for (int i = 0; i < 8; i++)
		{
			for(int col = 0; col < 8; col++)
			{
				if(i > 1 && i < 6)
					assertFalse(temp.getTile(i, col).isFilled());
			}
			
		}
		
		Piece blackTest;
		for (int i = 0; i < 8; i++)
		{
			blackTest = temp.getTile(1, i).holdPiece();
			assertTrue(blackTest != null);
			assertTrue(blackTest instanceof Pawn);
			assertTrue(blackTest.getColor() == Side.BLACK);
			assertEquals(blackTest.getPieceRow(), 1);
			assertEquals(blackTest.getPieceColumn(), i);
		}

		
		blackTest = temp.getTile(0, 0).holdPiece();
		assertTrue(blackTest != null);
		assertTrue(blackTest instanceof Rook);
		assertTrue(blackTest.getColor() == Side.BLACK);
		assertEquals(blackTest.getPieceRow(), 0);
		assertEquals(blackTest.getPieceColumn(), 0);
		
		blackTest = temp.getTile(0, 7).holdPiece();
		assertTrue(blackTest != null);
		assertTrue(blackTest instanceof Rook);
		assertTrue(blackTest.getColor() == Side.BLACK);
		assertEquals(blackTest.getPieceRow(), 0);
		assertEquals(blackTest.getPieceColumn(), 7);
		
		blackTest = temp.getTile(0, 1).holdPiece();
		assertTrue(blackTest != null);
		assertTrue(blackTest instanceof Knight);
		assertTrue(blackTest.getColor() == Side.BLACK);
		assertEquals(blackTest.getPieceRow(), 0);
		assertEquals(blackTest.getPieceColumn(), 1);
		
		blackTest = temp.getTile(0, 6).holdPiece();
		assertTrue(blackTest != null);
		assertTrue(blackTest instanceof Knight);
		assertTrue(blackTest.getColor() == Side.BLACK);
		assertEquals(blackTest.getPieceRow(), 0);
		assertEquals(blackTest.getPieceColumn(), 6);
		
		blackTest = temp.getTile(0, 2).holdPiece();
		assertTrue(blackTest != null);
		assertTrue(blackTest instanceof Bishop);
		assertTrue(blackTest.getColor() == Side.BLACK);
		assertEquals(blackTest.getPieceRow(), 0);
		assertEquals(blackTest.getPieceColumn(), 2);
		
		blackTest = temp.getTile(0, 5).holdPiece();
		assertTrue(blackTest != null);
		assertTrue(blackTest instanceof Bishop);
		assertTrue(blackTest.getColor() == Side.BLACK);
		assertEquals(blackTest.getPieceRow(), 0);
		assertEquals(blackTest.getPieceColumn(), 5);
		
		blackTest = temp.getTile(0, 3).holdPiece();
		assertTrue(blackTest != null);
		assertTrue(blackTest instanceof Queen);
		assertTrue(blackTest.getColor() == Side.BLACK);
		assertEquals(blackTest.getPieceRow(), 0);
		assertEquals(blackTest.getPieceColumn(), 3);
		
		blackTest = temp.getTile(0, 4).holdPiece();
		assertTrue(blackTest != null);
		assertTrue(blackTest instanceof King);
		assertTrue(blackTest.getColor() == Side.BLACK);
		assertEquals(blackTest.getPieceRow(), 0);
		assertEquals(blackTest.getPieceColumn(), 4);
		
		
		Piece whiteTest;
		for (int i = 0; i < 8; i++)
		{
			whiteTest = temp.getTile(6, i).holdPiece();
			assertTrue(whiteTest != null);
			assertTrue(whiteTest instanceof Pawn);
			assertTrue(whiteTest.getColor() == Side.WHITE);
			assertEquals(whiteTest.getPieceRow(), 6);
			assertEquals(whiteTest.getPieceColumn(), i);
		}
		
		
		whiteTest = temp.getTile(7, 0).holdPiece();
		assertTrue(whiteTest != null);
		assertTrue(whiteTest instanceof Rook);
		assertTrue(whiteTest.getColor() == Side.WHITE);
		assertEquals(whiteTest.getPieceRow(), 7);
		assertEquals(whiteTest.getPieceColumn(), 0);
		
		whiteTest = temp.getTile(7, 7).holdPiece();
		assertTrue(whiteTest != null);
		assertTrue(whiteTest instanceof Rook);
		assertTrue(whiteTest.getColor() == Side.WHITE);
		assertEquals(whiteTest.getPieceRow(), 7);
		assertEquals(whiteTest.getPieceColumn(), 7);
		
		whiteTest = temp.getTile(7, 1).holdPiece();
		assertTrue(whiteTest != null);
		assertTrue(whiteTest instanceof Knight);
		assertTrue(whiteTest.getColor() == Side.WHITE);
		assertEquals(whiteTest.getPieceRow(), 7);
		assertEquals(whiteTest.getPieceColumn(), 1);
		
		whiteTest = temp.getTile(7, 6).holdPiece();
		assertTrue(whiteTest != null);
		assertTrue(whiteTest instanceof Knight);
		assertTrue(whiteTest.getColor() == Side.WHITE);
		assertEquals(whiteTest.getPieceRow(), 7);
		assertEquals(whiteTest.getPieceColumn(), 6);
		
		whiteTest = temp.getTile(7, 2).holdPiece();
		assertTrue(whiteTest != null);
		assertTrue(whiteTest instanceof Bishop);
		assertTrue(whiteTest.getColor() == Side.WHITE);
		assertEquals(whiteTest.getPieceRow(), 7);
		assertEquals(whiteTest.getPieceColumn(), 2);
		
		whiteTest = temp.getTile(7, 5).holdPiece();
		assertTrue(whiteTest != null);
		assertTrue(whiteTest instanceof Bishop);
		assertTrue(whiteTest.getColor() == Side.WHITE);
		assertEquals(whiteTest.getPieceRow(), 7);
		assertEquals(whiteTest.getPieceColumn(), 5);
		
		whiteTest = temp.getTile(7, 3).holdPiece();
		assertTrue(whiteTest != null);
		assertTrue(whiteTest instanceof Queen);
		assertTrue(whiteTest.getColor() == Side.WHITE);
		assertEquals(whiteTest.getPieceRow(), 7);
		assertEquals(whiteTest.getPieceColumn(), 3);
		
		whiteTest = temp.getTile(7, 4).holdPiece();
		assertTrue(whiteTest != null);
		assertTrue(whiteTest instanceof King);
		assertTrue(whiteTest.getColor() == Side.WHITE);
		assertEquals(whiteTest.getPieceRow(), 7);
		assertEquals(whiteTest.getPieceColumn(), 4);
	}

	/**
	 * Test to determine if the field tiles can be filled appropriately with the right Piece type and the right color.
	 */
	public void testSetFilled() 
	{
		Board chessBoard = new Board(1);//initiate empty board
		
		//verify initial board is empty
		for(int i = 0; i < 8; i++)
		{
			for(int m = 0; m < 8; m++)
			{
				Tile current = chessBoard.getTile(i, m);
				assertFalse(current.isFilled());
			}
			
		}
		
		chessBoard.setFilled(2, 3, new Rook(2,3, Side.WHITE));
		
		Tile testTile = chessBoard.getTile(2, 3);
		Piece testPiece = testTile.holdPiece();
		
		assertTrue(testPiece instanceof Rook);
		assertEquals(testPiece.getColor(), Side.WHITE);
		assertEquals(testPiece.getPieceRow(), 2);
		assertEquals(testPiece.getPieceColumn(), 3);
	}

	
	/**
	 * Test to determine if a tile can be set to empty properly
	 */
	
	public void testEmpty()
	{
		Board chessBoard = new Board(1);//initiate empty board
		
		//verify initial board is empty
		for(int i = 0; i < 8; i++)
		{
			for(int m = 0; m < 8; m++)
			{
				Tile current = chessBoard.getTile(i, m);
				assertFalse(current.isFilled());
			}
			
		}
		
		chessBoard.setFilled(2, 3, new Rook(2,3, Side.WHITE));
		
		Tile testTile = chessBoard.getTile(2, 3);
		Piece testPiece = testTile.holdPiece();
		
		assertTrue(testPiece instanceof Rook);
		assertEquals(testPiece.getColor(), Side.WHITE);
		assertEquals(testPiece.getPieceRow(), 2);
		assertEquals(testPiece.getPieceColumn(), 3);
		
		chessBoard.setEmpty(2, 3);
		
		testTile = chessBoard.getTile(2, 3);
		assertFalse(testTile.isFilled());
		
	}
	
	/**
	 * Test to determine if a piece can acquire an appropriate "move history".
	 */
	
	public void testValidMoveHistory() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		Piece heldKnight =  chessBoard.getTile(7, 1).holdPiece();
		
		assertTrue(heldKnight.isInitialMove());
		
		Play tempPlay = new Play(chessBoard, heldKnight, 5, 2);
		
		Board currentBoard = white.requestPlay(tempPlay, black.getMoveOptions()).materializeBoard();
		
		Tile movedLocation = currentBoard.getTile(5, 2);
		assertTrue(movedLocation.isFilled());
		
		Piece movedPiece = movedLocation.holdPiece(); 
		assertTrue(movedPiece instanceof Knight);
		
		assertEquals(movedPiece.getMoveHistory().size(), 1);
		MovePair currentMovePair = movedPiece.getMoveHistory().get(0);
		assertEquals(currentMovePair.getRowChange(), -2);
		assertEquals(currentMovePair.getColumnChange(), 1);
		assertFalse(movedPiece.isInitialMove());
		
		
	}
	
	/**
	 * Determine if "move history" can incorporate more than one move.
	 * 
	 */
	
	public void testValidMoveHistoryTwo() 
	{
		Session filler = new Session();//ignore this it is only for connecting our gamers so we can test the board
		
		Board chessBoard = new Board();
		
		WhiteGamer white = new WhiteGamer(chessBoard, filler, chessBoard.getWhiteValidMove(), chessBoard.getBlackValidMove());
		BlackGamer black = new BlackGamer(chessBoard, filler, chessBoard.getBlackValidMove(), chessBoard.getWhiteValidMove());
		
		Piece heldPawn =  chessBoard.getTile(6, 1).holdPiece();
		
		assertTrue(heldPawn.isInitialMove());
		
		Play tempPlay = new Play(chessBoard, heldPawn, 5, 1);
		
		Board firstIterationBoard = white.requestPlay(tempPlay, black.getMoveOptions()).materializeBoard();
		
		Tile movedLocation = firstIterationBoard.getTile(5, 1);
		assertTrue(movedLocation.isFilled());
		
		Piece movedPiece = movedLocation.holdPiece(); 
		assertTrue(movedPiece instanceof Pawn);
		
		assertEquals(movedPiece.getMoveHistory().size(), 1);
		MovePair currentMovePair = movedPiece.getMoveHistory().get(0);
		assertEquals(currentMovePair.getRowChange(), -1);
		assertEquals(currentMovePair.getColumnChange(), 0);
		assertFalse(movedPiece.isInitialMove());
		
		heldPawn = firstIterationBoard.getTile(5, 1).holdPiece();
		
		assertFalse(heldPawn.isInitialMove());
		
		tempPlay = new Play(firstIterationBoard, heldPawn, 4, 1);
		
		Board currentBoard = white.requestPlay(tempPlay, black.getMoveOptions()).materializeBoard();
		
		movedLocation = currentBoard.getTile(4, 1);
		assertTrue(movedLocation.isFilled());
		
		movedPiece = movedLocation.holdPiece(); 
		assertTrue(movedPiece instanceof Pawn);
		
		assertEquals(movedPiece.getMoveHistory().size(), 2);
		currentMovePair = movedPiece.getMoveHistory().get(1);
		assertEquals(currentMovePair.getRowChange(), -1);
		assertEquals(currentMovePair.getColumnChange(), 0);
		assertFalse(movedPiece.isInitialMove());
		
		
	}
	
}
