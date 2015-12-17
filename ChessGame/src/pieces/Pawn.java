package pieces;

import com.satecha.chessgame.Piece;
import com.satecha.chessgame.PieceType;

public class Pawn extends Piece
{
	public Pawn(int x, int y, int pieceType, int colour)
	{
		super(x, y, pieceType, colour);
	}

	public boolean move(int toX, int toY, boolean attacking) 
	{
		this.setAttacking(attacking);
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
		if(toX < 0 || toX >= 8 || toY < 0 || toX >= 8)
		{
			return false;
		}
		if(Math.abs(this.getYPosition() - toY) > 2 || Math.abs(this.getXPosition() - toX) > 1)
		{
			return false;
		}
		if(toX == this.getXPosition() && toY == this.getYPosition())
		{
			return false;
		}
		if(!this.getAttacking())
		{
			if(Math.abs(this.getXPosition() - toX) != 0)
			{
				return false;
			}
		}
		if(!this.getFirstStep() && Math.abs(this.getYPosition() - toY) > 1)
		{
			return false;
		}
		return true;
	}
}
