package soldiers;

/*
 * Enum to determine which side a piece is on
 * */

public enum Side {
	WHITE
	{
		public int pawnMovePath()
		{
			return -1;
		}
		
		public boolean isBlack()
		{ 
			return false; 
		}
		
		public boolean isWhite()
		{ 
			return true; 
		}
	},
	
	BLACK
	{
		public int pawnMovePath()
		{
			return 1;
		}
		
		public boolean isBlack()
		{ 
			return true; 
		}
		
		public boolean isWhite()
		{ 
			return false; 
		}
		
	};
	
	
	
	
	public abstract int pawnMovePath();
	public abstract boolean isBlack();
	public abstract boolean isWhite();
}
