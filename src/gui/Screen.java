package gui;

import driver.*;
import field.*;
import gamer.Gamer;
import gamer.PlayState;
import gamer.Transition;
import session.*;
import soldiers.*;
import testCase.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

public class Screen 
{
	private final JFrame gameScreen;
	private final BoardVisual boardVisual;
	private final Session currentSession;
	private JPanel sideBar;
	

	
	/**
	 * track which tiles to move
	 */
	private Tile startTile;
	private Tile endTile;
	private Piece grabbedPiece;
	
	
	/**
	 * Held players names
	 */
	private String p1Name;
	private String p2Name;
	
	/**
	 * Label for scoring
	 */
	
	private JLabel whiteScoreLabel;
	private JLabel blackScoreLabel;
	
	
	/**
	 * 
	 */
	private boolean whiteConsentGameOver;
	private boolean blackConsentGameOver;
	
	
	
	private static String imagePath = "..\\Assignment1.2\\piecesPictures\\";
	
	
	/**
	 * Dimension constants
	 */
	
	private static Dimension OUTSIDE_BORDER = new Dimension(640, 800);
	private static Dimension CHESSBOARD_SIZE = new Dimension(640, 640);
	private static Dimension TILE_DIMENSIONS = new Dimension(80, 80);
	private static Dimension SIDEBAR_SIZE = new Dimension(640, 160); 
	private static Dimension SIDEBAR_BUTTON_SIZE = new Dimension(160, 20);

	
	/**
	 * Gui wrapper for if the game can continue
	 * @return if a "game over" condition is met (more of that in the Session class)
	 */
	public boolean gameContinues()
	{
		return currentSession.gameContinues();
	}
	
	/**
	 * Displays the results if a game and increments the score when appropriate.
	 */
	public void displayResults()
	{
		if(this.currentSession.isWhiteVictory())
		{
			currentSession.incrementWhiteVictory();
			displayDialogueMessages("WHITE WINS", "WHITE WINS");
		}
		else if(this.currentSession.isBlackVictory())
		{
			currentSession.incrementBlackVictory();
			displayDialogueMessages("BLACK WINS", "BLACK WINS");
		}
		else if(this.currentSession.isAgreedEnd())
		{
			displayDialogueMessages("ARMISTICE", "ARMISTICE");
		}	
		else
			displayDialogueMessages("STALEMATE", "STALEMATE");

	}
	
	
	/**
	 * This function resets all variables except for the players' names and the scores.
	 */
	public void resetBoard()
	{
		whiteConsentGameOver = false;
		blackConsentGameOver = false;
		currentSession.resetSession();
		boardVisual.buildNewBoard();
		whiteScoreLabel.setText(p1Name + "   Score:   " + currentSession.getWhitePoints());
		blackScoreLabel.setText(p2Name + "   Score:   " + currentSession.getBlackPoints());
	}

	/**
	 * Constructor takes in players' names and initialized the board
	 * @param p1Name	Player 1's name
	 * @param p2Name	Player 2's name
	 */
	public Screen(String p1Name, String p2Name)
	{
		this.p1Name = p1Name;
		this.p2Name = p2Name;
		
		this.currentSession = new Session();
		this.gameScreen = new JFrame("My Chess Game");
		this.gameScreen.setLayout(new BorderLayout());
		
		final JMenuBar screenBar = new JMenuBar();
		
		this.describeScreenBar(screenBar);
		this.gameScreen.setJMenuBar(screenBar);
		this.gameScreen.setVisible(true);
		
		this.gameScreen.setSize(OUTSIDE_BORDER);
		
		this.boardVisual = new BoardVisual();
		
		whiteScoreLabel = new JLabel(p1Name + "   Score:   " + currentSession.getWhitePoints());
		blackScoreLabel = new JLabel (p2Name + "   Score:   " + currentSession.getBlackPoints());
		
		this.gameScreen.add(this.boardVisual, BorderLayout.CENTER);
		
		createSideBar();
		this.gameScreen.add(this.sideBar, BorderLayout.EAST);
		
		whiteConsentGameOver = false;
		blackConsentGameOver = false;
	}
	
	/**
	 * Initializes the sidebar and score labels
	 */
	private void createSideBar()
	{
        sideBar = new JPanel(new GridLayout(0, 1));
        sideBar.setSize(SIDEBAR_SIZE);
        
        sideBar.add (new sideOptionButton(1));
        sideBar.add (new sideOptionButton(2));
        sideBar.add (new sideOptionButton(3));
        sideBar.add (new sideOptionButton(4));
        sideBar.add (new sideOptionButton(5));
        sideBar.add (new sideOptionButton(6));
        
        sideBar.add (whiteScoreLabel);
        sideBar.add (blackScoreLabel);
       
        
        
        sideBar.setVisible(true);
	}
	
	
	/**
	 * Creates the upper bar and adds it to the largest JPanel
	 * @param screenBar
	 */
	void describeScreenBar(final JMenuBar screenBar)
	{
		screenBar.add(createFileOptions());
		return;
	}
	
	/**
	 * 
	 * @return JMenu on the top of the JPanel of Game
	 */
	private JMenu createFileOptions() 
	{
		final JMenu fileOption = new JMenu("File");
		final JMenuItem openPic = new JMenuItem("Load Picture");
		openPic.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("HELLO");		
			}
		}
		
		);
		
		fileOption.add(openPic);
		
		final JMenuItem leaveProgram = new JMenuItem("Exit");
		leaveProgram.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}		
		);
		
		fileOption.add(leaveProgram);
		
		return fileOption;
	}
	
	
	
	/**
	 * Jpanel for displaying the board
	 * @author mikeliu8492
	 *
	 */
	private class BoardVisual extends JPanel
	{
		final TileVisual [][] boardTiles;
		public BoardVisual()
		{
			super(new GridLayout(8, 8));
			boardTiles = new TileVisual[8][8];
			
			for(int row = 0; row < 8; row++)
			{
				for(int col = 0; col < 8; col++)
				{
					final TileVisual tile = new TileVisual(this, row, col);
					this.boardTiles[row][col] = tile;
					add(tile);
				}
			}
			
			setPreferredSize(CHESSBOARD_SIZE);
		}
		
		public void buildNewBoard()
		{
			removeAll();
			for(int row = 0; row < 8; row++)
			{
				for(int col = 0; col < 8; col++)
				{
					this.boardTiles[row][col].renderTile(currentSession.getBoard());
					add(boardTiles[row][col]);
				}
			}
			validate();
			repaint();
		}
	}
	
	
	/**
	 * JButton for the tiles
	 * @author mikeliu8492
	 *
	 */
	private class TileVisual extends JButton
	{
		private final int tileRow;
		private final int tileColumn;
		
		/**
		 * Ported from Java.util.SwingUtilities
		 * 
		 * @param arg0
		 * @return
		 */
		
		public TileVisual(BoardVisual boardVisual, final int tileRow, final int tileColumn)
		{
			super();
			this.tileRow = tileRow;
			this.tileColumn = tileColumn;
			setPreferredSize(TILE_DIMENSIONS);
			this.renderTile(currentSession.getBoard());
			
			addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) 
                {
                	Board currentBoard = currentSession.getBoard();
                	
                	if(isRightMouseButton(e))
                	{
                		startTile = null;
                		endTile = null;
                		grabbedPiece = null;
                	}
                	else if (isLeftMouseButton(e))
                	{
                		if(startTile == null)
                		{
                			startTile = currentBoard.getTile(tileRow, tileColumn);
                			grabbedPiece = startTile.holdPiece();
                			
                			if(grabbedPiece == null)
                				startTile = null;
                			else if(grabbedPiece.getColor() != currentSession.getCurrentPlayer().getColor())
                			{
                				startTile = null;
                				grabbedPiece = null;
                				displayDialogueMessages("Invalid Selection", "You do not control that piece.");
                			}
                				
                			
                		}
                		else
                		{
                			endTile = currentBoard.getTile(tileRow, tileColumn);
                			Play possiblePlay = new Play(currentBoard, grabbedPiece, tileRow, tileColumn);
                			
                			Gamer currentGamer = currentSession.getCurrentPlayer();
                			Gamer enemyGamer = currentGamer.getEnemy();
                			
                			Transition tempState = currentSession.makeMove(possiblePlay);
                			if(tempState.getPlayState() == PlayState.ILLEGAL)
                				displayDialogueMessages("Illegal Move", "Illegal Move.  Please try again");
                			else if (tempState.getPlayState() == PlayState.KING_STILL_VULNERABLE)
                				displayDialogueMessages("In Check", "Your King is Check");
                			else if(tempState.getPlayState() == PlayState.COMPLETE)
                			{
                				currentSession.setChessBoard();
                				currentSession.appendBoardHistory(tempState.materializeBoard());
                				currentSession.incrementTurns();
                				
                			}
                			
                			startTile = null;
                			endTile = null;
                			grabbedPiece = null;
                		}
                		
                		SwingUtilities.invokeLater(new Runnable()
        				{

							@Override
							public void run() 
							{
								boardVisual.buildNewBoard();			
							}
						});
                		
                	}
                		
                		
                }

                @Override
                public void mousePressed(MouseEvent e) { }

                @Override
                public void mouseReleased(MouseEvent e) { }

                @Override
                public void mouseEntered(MouseEvent e) {
      
                }

                @Override
                public void mouseExited(MouseEvent e) {
 
                }
            });
			
		}
		
		
		public void renderTile(Board chessBoard)
		{
			removeAll();
			setColor();
			setPieceIcon(chessBoard);
			validate();
			repaint();
		}



		private void setPieceIcon(final Board chessBoard)
		{

			if(chessBoard.getTile(tileRow, tileColumn).isFilled())
			{
				try
				{
					String pieceString = chessBoard.getTile(tileRow, tileColumn).holdPiece().toString();
					final BufferedImage myPiece = ImageIO.read(new File(imagePath + pieceString +".gif"));
					add(new JLabel(new ImageIcon(myPiece)));
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				
			}
		}
		
		
		private void setColor()
		{
			if(tileRow == 0 || tileRow == 2 || tileRow == 4 || tileRow == 6)
			{
				this.setBackground(tileColumn % 2 == 0 ? Color.WHITE : Color.GRAY);
			}
			else
			{
				this.setBackground(tileColumn % 2 != 0 ? Color.WHITE : Color.GRAY);
			}
				
		}
		
	}
	
	/**
	 * function for creating 
	 * @param Title			string in title bar
	 * @param Message		string in Jframe message box
	 */
	private void displayDialogueMessages(String Title, String Message)
	{
		JFrame frame = new JFrame(Title);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		JOptionPane.showMessageDialog(frame, Message);
	    frame.pack();
	    frame.setVisible(true);
	}
	
	/**
	 * class for creating sidebar buttons
	 * @author mikeliu8492
	 *
	 */
	
	private class sideOptionButton extends JButton
	{
		protected int optionVar;
		
		public sideOptionButton(int var)
		{
			
			super();
			optionVar = var;
    		switch(optionVar)
    		{
    			case 1:
    				this.setText("Black Surrender");
    				break;
    			case 2:
    				this.setText("White Surrender");
    				break;
    			case 3:
    				this.setText("Amicable End White");
    				break;
    			case 4:
    				this.setText("Amicable End Black");
    				break;
    			case 5:
    				this.setText("Undo");
    				break;
    			case 6:
    				this.setText("Reset Game");
    				break;
    				
    		}
			
			this.setPreferredSize(SIDEBAR_BUTTON_SIZE);
			
			
			addMouseListener(new MouseListener() {
	            @Override
	            public void mouseClicked(MouseEvent e) 
	            {
	            	
	            	if(isLeftMouseButton(e))
	            	{
	            		switch(optionVar)
	            		{
	            			case 1:
	            				currentSession.blackSurrender();
	            				break;
	            			case 2:
	            				currentSession.whiteSurrender();
	            				break;
	            			case 3:
	            				{
	            					if(!whiteConsentGameOver)
	            					{
	            						currentSession.agreedOver();
	            						whiteConsentGameOver = true;
	            					}
	            				}
	            				break;
	            			case 4:
	            				{
	            					if(!blackConsentGameOver)
	            					{
	            						currentSession.agreedOver();
	            						blackConsentGameOver = true;
	            					}
	            					
	            					
	            				}
	            				break;
	            			case 5:
	            			{
	            				currentSession.undoPlay();
	                    		SwingUtilities.invokeLater(new Runnable()
	            				{

	    							@Override
	    							public void run() 
	    							{
	    								// TODO Auto-generated method stub
	    								boardVisual.buildNewBoard();
	    								
	    							}
	    						});
	            				break;
	            			}
	            			case 6:
	            			{	
	            				
	            				if(!gameContinues())
	            					resetBoard();
	            				break;
	            			}
	            			
	            			default:
	            				System.out.println("NOT SUPPOSE TO BE HERE!");
	            				
	            				
	            		}
	            			
	            	}
	  
	            		
	            }

	            @Override
	            public void mousePressed(MouseEvent e) { }

	            @Override
	            public void mouseReleased(MouseEvent e) { }

	            @Override
	            public void mouseEntered(MouseEvent e) {
	  
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {

	            }
	        });
			
			
		}	}

		
	
		
	
	
	
}
