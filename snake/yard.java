import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class yard extends Frame{
	public static final int HIGH = 50;
	public static final int WIDTH = 50;
	public static final int BLOCK_SIZE = 10;
	private PaintThread pt = new PaintThread();
	private Font fontGameOver = new Font("ËÎÌו",Font.BOLD,20);
	private Snake s = new Snake(this);
	private Egg e = new Egg();
	private int score = 0;
	public yard(String s)
	{
		super(s);
		this.setLayout(new GridLayout());
		this.setBounds(200, 200, WIDTH*BLOCK_SIZE, HIGH*BLOCK_SIZE);
		this.setBackground(new Color(80,80,100));
		this.addWindowListener(new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				
				});
		this.addKeyListener(new keyboardListener());
		//this.pack();
		this.setVisible(true);
		new Thread(pt).start();
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score=score;
	}
	public void paint(Graphics g)
	{
		Color c=g.getColor();
		s.eat(e);
		s.draw(g);
		e.draw(g);
		g.setColor(Color.BLACK);
		g.setFont(fontGameOver);
		g.drawString("Score:", 10, 80);
		g.setColor(c);
	}
	public void pause()
	{
		//this.pause=true;
	}
	public void reStart()
	{
		//this.pause=false;
		s=new Snake(yard.this);
	}
	public class keyboardListener extends KeyAdapter
	{

		@Override
		public void keyPressed(KeyEvent e) {
			int key=e.getKeyCode();
			s.keyPressed(e);
			if(key==KeyEvent.VK_F2)
			{
				//pt.reStart();
			}
		}
		
	}
	private class PaintThread implements Runnable
	{
		public void run()
		{
			while(true)
			{	
			repaint();
			try{Thread.sleep(100);}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			}
		}
	}
	
	public static void main(String []args)
	{
		new yard("Greed Snake");
		
	}
	
}
