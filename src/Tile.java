public abstract class Tile 
{
	
	/*
	 * coordinates of piece on board (0 index)
	 * */
	
	protected final int row;
	protected final int column;
	
	
	
	Tile(int yourRow, int yourColumn)
	{
		this.row = yourRow;
		this.column = yourColumn;
	}
	
	public static Tile makeTile(final int yourRow, final int yourColumn, Piece passedInPiece)
	{
		if(passedInPiece != null)
			return new FilledTile(yourRow, yourColumn, passedInPiece);
		else
			return new BlankTile(yourRow, yourColumn);
	}
	
	
	public abstract boolean isFilled();
	
	public abstract Piece holdPiece();
	

	
	public static final class BlankTile extends Tile
	{
		private BlankTile(final int yourRow, final int yourColumn)
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
		
	}
	
	
	
	public static final class FilledTile extends Tile
	{
		private final Piece heldPiece;
		
		private FilledTile(int yourRow, int yourColumn, Piece passedInPiece)
		{
			super(yourRow, yourColumn);
			this.heldPiece = passedInPiece;
		}
		
		@Override
		public boolean isFilled()
		{
			return true;
		}
		
		@Override
		public Piece holdPiece()
		{
			return heldPiece;
		}
		
	}
	
	
}
