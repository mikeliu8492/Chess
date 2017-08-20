package soldiers;


/**
 * This class is a helper to determine how much the piece moves relative to its current position
 * + means up for row, - means down for rows
 * + means right for column, - means left for column
 * 
 * */

public class MovePair 
{
	private final int rowChange;
	private final int columnChange;
	
	
	/**
	 * Constructor for movepair to be added to history.
	 * @param rowChange
	 * @param columnChange
	 */
	public MovePair(int rowChange, int columnChange)
	{
		this.rowChange = rowChange;
		this.columnChange = columnChange;
	}
	
	public int getRowChange()
	{
		return rowChange;
	}
	
	public int getColumnChange()
	{
		return columnChange;
	}
}
