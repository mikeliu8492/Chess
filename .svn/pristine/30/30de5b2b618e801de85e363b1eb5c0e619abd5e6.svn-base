package field;

import soldiers.*;
import gamer.*;
import java.util.*;

/**
 * 
 * @author mikeliu8492
 *
 */

public class Board 
{
	/**
	 * the board itself represented by tile objects
	 * 
	 */
	private Tile[][] chessBoard;
	
	private int DIMENSION = 8;
	
	/**
	 * list to track the active pieces of both sides
	 * */
	private Collection<Piece> livingWhitePieces;
	private Collection<Piece> livingBlackPieces;
	
	/**
	 * list to track the valid moves of both sides
	 * */

	private Collection<Play> whiteValidMoves;
	private Collection<Play> blackValidMoves;
	
	/**
	 * internal helper function to count up the pieces on the board
	 * @param passedInColor		the color of the side you want to get the active pieces of (WHITE/BLACK)
	 * @return 					a Collection of pieces for a specific side
	 */
	
	private Collection<Piece> pieceCensus(Side passedInColor)
	{
		List<Piece> active = new ArrayList<Piece>();
		for(int i = 0; i < DIMENSION; i++)
		{
			for(int m = 0; m < DIMENSION; m++)
			{
				if(chessBoard[i][m].isFilled())
				{
					Piece yourPiece = chessBoard[i][m].holdPiece();
					if(yourPiece.getColor() == passedInColor)
					{
						active.add(yourPiece);
					}
				}
					
			}
		}
		
		return active;
	}
	

	/**
	 * function to get a specific tile on the board
	 * @param row = the row on the board (0 to 7)
	 * @param column = the column on the board (0 to 7)
	 * @return
	 */
	public Tile getTile(int row, int column)
	{
		return chessBoard[row][column];
	}

	/**
	 * This initializes the chessboard to the default starting configuration
	 * 
	 * */
	public Board()
	{
		chessBoard = new Tile[DIMENSION][DIMENSION];
		
		for(int row = 0; row < DIMENSION; row++)
		{
			for (int col = 0; col < DIMENSION; col++)
			{
				if(row > 1 && row < 6)
					chessBoard[row][col] = new Tile.BlankTile(row, col);
			}
				
		}
		
		setValidPieces();
		
		livingWhitePieces = pieceCensus(Side.WHITE);
		livingBlackPieces = pieceCensus(Side.BLACK);
		
		whiteValidMoves = getAllValidPlays(this.livingWhitePieces);
		blackValidMoves = getAllValidPlays(this.livingBlackPieces);

	}
	
	
	
	
	/**
	 * different constructor to create empty board, used for unit testing AND for reorienting the board after transitions 
	 * @param filler	put any integer here to construct an empty board
	 */
	
	public Board(int filler)
	{
		chessBoard = new Tile[DIMENSION][DIMENSION];
		
		for(int row = 0; row < DIMENSION; row++)
		{
			for (int col = 0; col < DIMENSION; col++)
			{
					chessBoard[row][col] = new Tile.BlankTile(row, col);
			}
				
		}
		
		livingWhitePieces = pieceCensus(Side.WHITE);
		livingBlackPieces = pieceCensus(Side.BLACK);
		
		whiteValidMoves = getAllValidPlays(this.livingWhitePieces);
		blackValidMoves = getAllValidPlays(this.livingBlackPieces);
		
	}
	
	/**
	 * Get collection of active pieces on white side
	 * @return	Collection of Pieces on white side
	 */
	
	public Collection<Piece> yourActiveWhitePieces()
	{
		return livingWhitePieces;
	}
	
	/**
	 * Get collection of active pieces on black side
	 * @return	Collection of Pieces on black side
	 */
	
	public Collection<Piece> yourActiveBlackPieces()
	{
		return livingBlackPieces;
	}

	/**
	 * Get collection of valid moves on white side
	 * */
	
	public Collection<Play> getWhiteValidMove()
	{ 
		return whiteValidMoves;
	}
	
	/**
	 * Get collection of valid moves on black side
	 * */
	
	public Collection<Play> getBlackValidMove()
	{ 
		return blackValidMoves;
	}
	
	
	
	/*
	 * Large function to initialize a standard chess board
	 * */
	
	void setValidPieces()
	{
		for(int i = 0; i < DIMENSION; i++)
		{
			chessBoard[1][i] = new Tile.FilledTile(1, i, new Pawn(1, i, Side.BLACK));
			chessBoard[6][i] = new Tile.FilledTile(6, i, new Pawn(6, i, Side.WHITE));
		}

		chessBoard[0][0] = new Tile.FilledTile(0, 0, new Rook(0, 0, Side.BLACK));
		chessBoard[0][7] = new Tile.FilledTile(0, 7, new Rook(0, 7, Side.BLACK));
		chessBoard[7][0] = new Tile.FilledTile(7, 0, new Rook(7, 0, Side.WHITE));
		chessBoard[7][7] = new Tile.FilledTile(7, 7, new Rook(7, 7, Side.WHITE));
		
		chessBoard[0][1] = new Tile.FilledTile(0, 1, new Knight(0, 1, Side.BLACK));
		chessBoard[0][6] = new Tile.FilledTile(0, 6, new Knight(0, 6, Side.BLACK));
		chessBoard[7][1] = new Tile.FilledTile(7, 1, new Knight(7, 1, Side.WHITE));
		chessBoard[7][6] = new Tile.FilledTile(7, 6, new Knight(7, 6, Side.WHITE));
		
		chessBoard[0][2] = new Tile.FilledTile(0, 2, new Bishop(0, 2, Side.BLACK));
		chessBoard[0][5] = new Tile.FilledTile(0, 5, new Bishop(0, 5, Side.BLACK));
		chessBoard[7][2] = new Tile.FilledTile(7, 2, new Bishop(7, 2, Side.WHITE));
		chessBoard[7][5] = new Tile.FilledTile(7, 5, new Bishop(7, 5, Side.WHITE));
	
		chessBoard[0][3] = new Tile.FilledTile(0, 3, new Queen(0, 3, Side.BLACK)); 
		chessBoard[0][4] = new Tile.FilledTile(0, 4, new King(0, 4, Side.BLACK));
		chessBoard[7][3] = new Tile.FilledTile(7, 3, new Queen(7, 3, Side.WHITE)); 
		chessBoard[7][4] = new Tile.FilledTile(7, 4, new King(7, 4, Side.WHITE));
		
			
	}
	
	
	/**
	 * Display the board in Eclipse console
	 * */
	
	public void displayBoard()
	{
		for (int i = 0; i < DIMENSION; i++)
		{
			for (int m = 0; m< DIMENSION; m++)
			{
				chessBoard[i][m].printTileStatus();	
			}
			System.out.println("");
		}
		
	}

	
	
	
	/**
	 * get all valid plays for a specific color(as referenced by pieceGallery)
	 * */
	private Collection<Play> getAllValidPlays(final Collection<Piece> pieceGallery)
	{
		final List<Play> validPlays= new ArrayList<Play>();
		for(final Piece currentPiece : pieceGallery)
		{
			validPlays.addAll(currentPiece.calculatePlays(this));	
		}

		return validPlays;
	}
	
	
	/**
	 * Set a tile to a specific new piece.
	 * TODO:  Make this valid for pawn promotion
	 * @param row				tile row
	 * @param column			tile column
	 * @param templateCopy		copy the original piece, place it in new tile, and copy over its move history
	 */
	public void setFilled(int row, int column, Piece templateCopy)
	{
		if(BoardHelpers.presentOnBoard(row, column, DIMENSION))
		{
			if(templateCopy != null)
				chessBoard[row][column] = new Tile.FilledTile(row, column, templateCopy);
			updateLists();
		}
		
		
	}
	
	
	/**
	 * Set a tile to empty
	 * @param row		tile row
	 * @param column	tile column
	 */

	public void setEmpty(int row, int column)
	{
		if(BoardHelpers.presentOnBoard(row, column, DIMENSION))
		{
			chessBoard[row][column] = new Tile.BlankTile(row, column);
		}
		
		updateLists();
	}
	
	
	/**
	 * Wrapper function for keeping track of accounting and valid moves for a given board.  
	 * This is used to update the board after every move is completed
	 */
	
	public void updateLists()
	{
		livingWhitePieces = pieceCensus(Side.WHITE);
		livingBlackPieces = pieceCensus(Side.BLACK);
		
		whiteValidMoves = getAllValidPlays(this.livingWhitePieces);
		blackValidMoves = getAllValidPlays(this.livingBlackPieces);
		
	}
	
	/**
	 * Retrieves the dimension for row & column of board
	 * @return		an INT representing the dimension
	 */
	public int getDimension()
	{
		return this.DIMENSION;
	}
	
}


