package testCase;

import junit.framework.TestCase;
import soldiers.*;
import field.*;
import gamer.*;

import java.util.*;

public class PieceTest extends TestCase 
{

	/**
	 * Determine if the Piece can calculate its proper valid plays.
	 */
	public void testCalculatePlays() 
	{
		Board blank = new Board(1);
		blank.setFilled(6, 0, new Pawn(6, 0, Side.WHITE));
		blank.setFilled(5, 1, new Pawn(5, 1, Side.BLACK));
		
		Piece targetPawn = blank.getTile(6, 0).holdPiece();
		Collection<Play> pawnPlays = targetPawn.calculatePlays(blank);
		
		assertEquals(pawnPlays.size(), 3);
		assertTrue(BoardHelpers.locateProperPlay(pawnPlays, 4, 0));
		assertTrue(BoardHelpers.locateProperPlay(pawnPlays, 5, 0));
		assertTrue(BoardHelpers.locateProperPlay(pawnPlays, 5, 1));
		
	}
	
	/**
	 * check to determine if a Piece can be copied successfully, including its move history
	 */
	
	public void testCopyPiece() 
	{
		Pawn originalPawn = new Pawn(1, 3, Side.WHITE);
		Piece copiedPawn = originalPawn.copyPiece(1, 3, originalPawn);
		
		assertTrue(copiedPawn instanceof Pawn);
		assertEquals(copiedPawn.getPieceRow(), 1);
		assertEquals(copiedPawn.getPieceColumn(), 3);
		assertNotSame(copiedPawn, originalPawn);
		assertEquals(copiedPawn.getMoveHistory(), originalPawn.getMoveHistory());
	}
	
	/**
	 * Pawn and all other have the same logic.  Tests if the Piece calculates the approrpiate number of
	 * valid moves and what those moves are.
	 */
	
	public void testPawnValidMoves()
	{
		Board blank = new Board(1);
		blank.setFilled(6, 0, new Pawn(6, 0, Side.WHITE));
		blank.setFilled(5, 1, new Pawn(5, 1, Side.BLACK));
		
		Piece targetPawn = blank.getTile(6, 0).holdPiece();
		Collection<Play> pawnPlays = targetPawn.calculatePlays(blank);
		
		assertEquals(pawnPlays.size(), 3);
		assertTrue(BoardHelpers.locateProperPlay(pawnPlays, 4, 0));
		assertTrue(BoardHelpers.locateProperPlay(pawnPlays, 5, 0));
		assertTrue(BoardHelpers.locateProperPlay(pawnPlays, 5, 1));
		
		targetPawn = blank.getTile(5, 1).holdPiece();
		pawnPlays = targetPawn.calculatePlays(blank);
		
		assertEquals(pawnPlays.size(), 2);
		assertTrue(BoardHelpers.locateProperPlay(pawnPlays, 6, 0));
		assertTrue(BoardHelpers.locateProperPlay(pawnPlays, 6, 1));
		
	}
	
	public void testBishopValidMoves()
	{
		Board blank = new Board(1);
		blank.setFilled(4, 4, new Bishop(4, 4, Side.WHITE));
		blank.setFilled(3, 3, new Bishop(3, 3, Side.BLACK));
		
		Piece targetBishop = blank.getTile(4,4).holdPiece();
		Collection<Play> bishopPlays = targetBishop.calculatePlays(blank);
		
		assertEquals(bishopPlays.size(), 10);
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 3, 5));
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 2, 6));
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 1, 7));
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 5, 3));
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 6, 2));
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 7, 1));
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 3, 3));
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 5, 5));
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 6, 6));
		assertTrue(BoardHelpers.locateProperPlay(bishopPlays, 7, 7));
		
		
	}
	
	
	public void testRookValidMoves()
	{
		Board blank = new Board(1);
		blank.setFilled(4, 4, new Rook(4, 4, Side.WHITE));
		blank.setFilled(4, 3, new Rook(4, 3, Side.BLACK));
		
		Piece targetRook = blank.getTile(4,4).holdPiece();
		Collection<Play> rookPlays = targetRook.calculatePlays(blank);
		
		assertEquals(rookPlays.size(), 11);
		assertTrue(BoardHelpers.locateProperPlay(rookPlays, 4, 5));
		assertTrue(BoardHelpers.locateProperPlay(rookPlays, 4, 6));
		assertTrue(BoardHelpers.locateProperPlay(rookPlays, 4, 7));
		assertTrue(BoardHelpers.locateProperPlay(rookPlays, 0, 4));
		assertTrue(BoardHelpers.locateProperPlay(rookPlays, 1, 4));
		assertTrue(BoardHelpers.locateProperPlay(rookPlays, 2, 4));
		assertTrue(BoardHelpers.locateProperPlay(rookPlays, 3, 4));
		assertTrue(BoardHelpers.locateProperPlay(rookPlays, 5, 4));
		assertTrue(BoardHelpers.locateProperPlay(rookPlays, 7, 4));
		
		
	}
	
	
	public void testKnightMoves()
	{
		Board blank = new Board(1);
		blank.setFilled(4, 4, new Knight(4, 4, Side.WHITE));
		blank.setFilled(4, 3, new Knight(4, 3, Side.BLACK));
		
		Piece targetKnight = blank.getTile(4,4).holdPiece();
		Collection<Play> knightPlays = targetKnight.calculatePlays(blank);
		
		assertEquals(knightPlays.size(), 8);
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 2, 3));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 3, 2));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 6, 3));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 3, 6));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 2, 5));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 5, 2));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 6, 5));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 5, 6));

		
		
	}
	
	
	public void testQueenMoves()
	{
		Board blank = new Board(1);
		blank.setFilled(4, 4, new Queen(4, 4, Side.WHITE));
		blank.setFilled(4, 3, new Queen(4, 3, Side.BLACK));
		blank.setFilled(3, 4, new Rook(3, 4, Side.BLACK));
		blank.setFilled(6, 6, new Bishop(6, 6, Side.WHITE));
		
		
		Piece targetQueen = blank.getTile(4,4).holdPiece();
		Collection<Play> queenPlays = targetQueen.calculatePlays(blank);
		
		assertEquals(queenPlays.size(), 19);
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 0, 0));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 1, 1));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 2, 2));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 3, 3));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 5, 5));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 5, 3));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 3, 5));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 6, 2));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 2, 6));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 7, 1));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 1, 7));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 3, 4));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 5, 4));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 6, 4));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 7, 4));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 4, 3));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 4, 5));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 4, 6));
		assertTrue(BoardHelpers.locateProperPlay(queenPlays, 4, 7));
		

		
		
	}
	
	
	public void testKingMoves()
	{
		Board blank = new Board(1);
		blank.setFilled(4, 4, new King(4, 4, Side.WHITE));
		blank.setFilled(4, 3, new Knight(4, 3, Side.WHITE));
		
		Piece targetKnight = blank.getTile(4,4).holdPiece();
		Collection<Play> knightPlays = targetKnight.calculatePlays(blank);
		
		assertEquals(knightPlays.size(), 7);
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 3, 3));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 3, 4));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 3, 5));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 4, 5));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 5, 3));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 5, 4));
		assertTrue(BoardHelpers.locateProperPlay(knightPlays, 5, 5));

		
		
	}
	
	
	public void testShortRookMoves()
	{
		Board blank = new Board(1);
		blank.setFilled(6, 2, new ShortRook(6, 2, Side.WHITE));
		blank.setFilled(6, 3, new Knight(6, 3, Side.WHITE));
		blank.setFilled(6, 1, new Knight(6, 1, Side.BLACK));
		
		Piece targetShortRook = blank.getTile(6,2).holdPiece();
		Collection<Play> shortRookPlays = targetShortRook.calculatePlays(blank);
		
		assertEquals(6, shortRookPlays.size());
		assertTrue(BoardHelpers.locateProperPlay(shortRookPlays, 6, 1));
		assertFalse(BoardHelpers.locateProperPlay(shortRookPlays, 6, 3));
		assertTrue(BoardHelpers.locateProperPlay(shortRookPlays, 5, 2));
		assertTrue(BoardHelpers.locateProperPlay(shortRookPlays, 4, 2));
		assertTrue(BoardHelpers.locateProperPlay(shortRookPlays, 3, 2));
		assertTrue(BoardHelpers.locateProperPlay(shortRookPlays, 2, 2));
		assertTrue(BoardHelpers.locateProperPlay(shortRookPlays, 7, 2));

		
		
	}
	
	
	public void testSquareKnightMoves()
	{
		Board blank = new Board(1);
		blank.setFilled(4, 4, new SquareKnight(4, 4, Side.WHITE));
		blank.setFilled(2, 2, new Knight(2, 2, Side.WHITE));
		blank.setFilled(6, 6, new Knight(6, 6, Side.BLACK));
		
		Piece targetShortRook = blank.getTile(4,4).holdPiece();
		Collection<Play> shortRookPlays = targetShortRook.calculatePlays(blank);
		
		assertEquals(3, shortRookPlays.size());
		assertTrue(BoardHelpers.locateProperPlay(shortRookPlays, 6, 6));
		assertTrue(BoardHelpers.locateProperPlay(shortRookPlays, 6, 2));
		assertTrue(BoardHelpers.locateProperPlay(shortRookPlays, 2, 6));
		assertFalse(BoardHelpers.locateProperPlay(shortRookPlays, 2, 2));

		
		
	}
	
	
	


}
