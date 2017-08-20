package field;
import soldiers.Piece;

/**
 * 
 * @author mikeliu8492
 *
 * Class for the tiles the board is made of
 *
 */

public abstract class Tile 
{
	
	/**
	 * Coordinates of piece on board (0 index)
	 */
	
	public int row;
	public int column;
	
	
	/**
	 * Constructor for basic Tile
	 * @param yourRow		basic row number
	 * @param yourColumn	basic column number
	 */
	
	Tile(int yourRow, int yourColumn)
	{
		this.row = yourRow;
		this.column = yourColumn;
	}
	
	
	/**
	 * 
	 * @return whether the tile is filled with a Piece
	 */
	public abstract boolean isFilled(); // whether tile has a piece on it
	
	/**
	 * 
	 * @return the Piece held on a filled tile
	 */
	public abstract Piece holdPiece();
	
	
	/**
	 * wrapper function for printing piece type and color on tile, or if empty printing a filler symbol on console
	 */
	public abstract void printTileStatus();
	
	
	
	
	 
	/**
	 * 
	 * @author mikeliu8492
	 * child class for blank tile
	 */
	public static final class BlankTile extends Tile
	{
		public BlankTile(int yourRow, int yourColumn)
		{
			super(yourRow, yourColumn);
		}
		
		@Override
		public boolean isFilled()
		{
			return false;
		}
		
		@Override
		public Piece holdPiece()
		{
			return null;
		}
		
		@Override
		public void printTileStatus()
		{
			System.out.print("-- ");
		}
		
	}
	
	/**
	 * 
	 * @author mikeliu8492
	 *
	 * child class for occupied tile
	 */
	
	public static final class FilledTile extends Tile
	{
		private Piece heldPiece;
		
		
		public FilledTile(int yourRow, int yourColumn, Piece passedInPiece)
		{
			super(yourRow, yourColumn);
			Piece temp = passedInPiece;
			this.heldPiece = temp.copyPiece(yourRow, yourColumn, passedInPiece);
			
		}
		
		
		@Override
		public boolean isFilled()
		{
			return true;
		}
		
		
		
		@Override
		/**
		 * @return returns the held piece in filled tile
		 */
		public Piece holdPiece()
		{
			return heldPiece;
		}
		
		@Override
		public void printTileStatus()
		{
			heldPiece.printPiece();
		}
		
	}
	
	
}