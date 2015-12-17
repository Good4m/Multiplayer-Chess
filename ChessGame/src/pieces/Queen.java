package pieces;

import com.satecha.chessgame.Piece;
import com.satecha.chessgame.PieceType;
import java.lang.Math;

public class Queen extends Piece
{
	public Queen(int x, int y, int pieceType, int colour)
	{
		super(x, y, pieceType, colour);
	}

	public boolean move(int toX, int toY, boolean attacking) 
	{
		if(checkMove(toX, toY)) 
		{
			this.setXPosition(toX);
			this.setYPosition(toY);
			return true;
		}
		return false;
	}

	public boolean checkMove(int toX, int toY)
	{
		if(toX < 0 || toX >= 8 || toY < 0 || toY >= 8)
		{
			return false;
		}
		if(toX == this.getXPosition() && toY == this.getYPosition())
		{
			return false;
		}
		if(Math.abs(toX - this.getXPosition()) > 1 && Math.abs(toY - this.getYPosition()) > 1)
		{
			if(Math.abs(toX - this.getXPosition()) != Math.abs(toY - this.getYPosition()))
			{
				return false;
			}
		}
		return true;
	}
}
