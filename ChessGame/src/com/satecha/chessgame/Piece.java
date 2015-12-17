package com.satecha.chessgame;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public abstract class Piece extends Drawable
{
	public static final int WHITE = 0; 
	public static final int BLACK = 1;
	public static final int DEAD  = 0; 
	public static final int ALIVE = 1;
	
	/**
	 * Colour of the chess piece. Only use the 
	 * WHITE or BLACK constants.
	 */
	private int colour;

	private int xPosition;
	private int yPosition;

	private int type;

	/**
	 * Status of piece
	 * Use DEAD/ALIVE constant.
	 */
	private int status;
	private boolean attacking;
	private boolean firstStep;

    /**
     * Piece constructor
     * @param x coordinate
     * @param y coordinate
     * @param pieceType is the type of the chess piece
     * @param colour of the chess piece -  Piece.WHITE or Piece.BLACK
     */
    public Piece(int x, int y, int pieceType, int colour) 
    {
    	super(x * Settings.getMaxTileWidth(), y * Settings.getMaxTileHeight(),
    	        new AtlasRegion(graphics_textures.findRegion(Integer.toString(pieceType) + Integer.toString(colour))));
    	this.type      = pieceType;
    	this.xPosition = x;
		this.yPosition = y;
		status         = ALIVE;
		this.colour    = colour;
		firstStep = true;
	}

    /** Set piece type. **/
    public void setPieceType(int pieceType) 
    {
    	this.type = pieceType;
    }

    /** Get piece type. **/
    public int getPieceType() 
    {
    	return this.type;
    }

    /**
     * Draw piece.
     * This gets called when the rendering loop iterates over this piece
     */
    public void drawMe() 
    {
        getSprite().setPosition(getX(), getY());
        getSprite().draw(ChessGame.batch);
    }

    /**
     * Move chess piece.
     * @return true if move a success
     */
    public abstract boolean move(int toX, int toY, boolean attacking);

    /**
     * Check if piece can make requested move.
     * @return true if move a success
     */
    public abstract boolean checkMove(int toX, int toY);

	/**
	 * Sets the horizontal position of the chess piece.
	 * @param x is the horizontal position.
	 */
	public void setXPosition(int x)
	{
		xPosition = x;
	}

	/**
	 * Returns the horizontal position of the chess piece.
	 * @return The horizontal position.
	 */
	public int getXPosition()
	{
		return xPosition;
	}

	/**
	 * Sets the vertical position of the chess piece.
	 * @param y is the vertical position.
	 */
	public void setYPosition(int y)
	{
		yPosition = y;
	}

	/**
	 * Returns the vertical position of the chess piece.
	 * @return The vertical position.
	 */
	public int getYPosition()
	{
		return yPosition;
	}

	/**
	 * Sets the current status of the chess piece.
	 * Use DEAD/ALIVE constant.
	 * @param status to set the chess piece to.
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}

	/**
	 * Returns status of the chess piece.
	 * DEAD=0 / ALIVE=1
	 * @return The status of the chess piece.
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * Returns the colour of the chess piece.
	 * @return The colour of the chess piece.
	 */
	public int getColour()
	{
		return colour;
	}
	/**
	 * Returns the type of the chess piece
	 * @return The type of the chess piece
	 */
	public int getType()
	{
		return type;
	}
	public void setAttacking(boolean attacking)
	{
		this.attacking = attacking;
	}
	public boolean getAttacking()
	{
		return attacking;
	}
	public boolean getFirstStep()
	{
		return firstStep;
	}
}
