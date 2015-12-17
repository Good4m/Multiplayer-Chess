package pieces;

import com.satecha.chessgame.Piece;
import com.satecha.chessgame.PieceType;

public class King extends Piece
{
	public King(int x, int y, int pieceType, int colour)
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
		//If inside gameboard bounds.
		if(toX >= 0 && toX < 8 && toY >= 0 && toY < 8)
		{
			if(Math.abs(this.getXPosition() - toX) == 1 || Math.abs(this.getXPosition() - toX) == 0)
			{
				if(Math.abs(this.getYPosition() - toY) == 1 || Math.abs(this.getYPosition() - toY) == 0)
				{
					return true;
				}
			}
		}

		return false;
	}
}
