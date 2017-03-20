import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Egg {
	private int row,col;
	int w=yard.BLOCK_SIZE;
	int h=yard.BLOCK_SIZE;
	private Color color=Color.cyan;
	private static Random r=new Random();
	public Egg()
	{
		row=r.nextInt(yard.WIDTH-3)+3;
		col=r.nextInt(yard.HIGH-3)+3;
	}
	public Egg(int row,int col)
	{
		this.row=row;
		this.col=col;
	}
	public void reApper()
	{
		row=r.nextInt(yard.WIDTH-3)+3;
		col=r.nextInt(yard.HIGH-3)+3;
	}
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(col*yard.BLOCK_SIZE, row*yard.BLOCK_SIZE, w, h);
		g.setColor(c);
	
	}
	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

}
