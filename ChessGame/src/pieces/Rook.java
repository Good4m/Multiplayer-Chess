package pieces;

import com.satecha.chessgame.Piece;
import com.satecha.chessgame.PieceType;

public class Rook extends Piece
{
	public Rook(int x, int y, int pieceType, int colour)
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
		if(toX >= 8 || toX < 0 || toY >= 8 || toY < 0)
		{
			return false;
		}
		if(toX == this.getXPosition() && toY == this.getYPosition())
		{
			return false;
		}
		if(Math.abs(toX - this.getXPosition()) != 0 && Math.abs(toY - this.getXPosition()) != 0)
		{
			return false;
		}
		return true;
	}
}
