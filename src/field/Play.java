package field;

import soldiers.*;

public class Play 
{
	
	final Board chessBoard;
	final Piece targetPiece;
	final int targetRow;
	final int targetColumn;
	
	/**
	 * Constructor to create a play
	 * 
	 * @param chessBoard		The chessboard we reference the play on
	 * @param targetPiece		The piece selected
	 * @param targetRow			The destination row
	 * @param targetColumn		The destination column
	 */
	public Play(final Board chessBoard, final Piece targetPiece, final int targetRow, final int targetColumn)
	{
		this.chessBoard= chessBoard;
		this.targetPiece = targetPiece;
		this.targetRow = targetRow;
		this.targetColumn = targetColumn;
		
	}
	
	/**
	 * 
	 * @return the destination row
	 */
	
	public int getTargetRow()
	{
		return targetRow;
	}
	
	
	/**
	 * 
	 * @return the destination column
	 */
	public int getTargetColumn()
	{
		return targetColumn;
	}
	
	/**
	 * 
	 * @return Reference to the Piece we used to make a potential play
	 */
	
	public Piece getPiece()
	{
		return targetPiece;
	}
	

	
}
