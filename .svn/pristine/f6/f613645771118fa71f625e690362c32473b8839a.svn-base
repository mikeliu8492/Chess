package gamer;

import gamer.*;

/**
 * 
 * @author mikeliu8492
 * Shows if a play can be completed
 * @COMPLETE:				play is legal
 * @ILLEGAL:				play is not legal because of physical constraint(e.g. not following Piece rules,
 * 							non-Knight jumping over other Pieces, moving off grid, etc.)
 * @KING_STILL_VULNERABLE:	play would put user's King in check
 */

public enum PlayState 
{
	COMPLETE
	{
		public boolean isComplete()
		{
			return true;
		}
	},
	
	ILLEGAL
	{
		public boolean isComplete()
		{
			return false;
		}
	},
	
	KING_STILL_VULNERABLE
	{
		public boolean isComplete()
		{
			return false;
		}
	};
	
	abstract boolean isComplete();
}
