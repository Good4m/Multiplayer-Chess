package pieces;

import com.satecha.chessgame.Piece;
import com.satecha.chessgame.PieceType;

public class Bishop extends Piece
{
	public Bishop(int x, int y, int pieceType, int colour)
	{
		super(x, y, pieceType, colour);
	}

	public boolean move(int toX, int toY, boolean attacking) 
	{
		if(checkMove(toX, toY)) 
		{

		}
		return false;
	}

	public boolean checkMove(int toX, int toY) 
	{
		//If moving to the same spot as the piece is already at, return false
		if(toX == this.getXPosition() && toY == this.getYPosition())
		{
			return false;
		}
		return false;
	}

}
