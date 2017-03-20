import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Snake {
	private Node head=null;
	private Node tail=null;
	private yard s;
	private int size=3;
	public Snake(yard y)
	{
		
		head=tail=new Node();
		this.s = y;
	}
	public void addtotail()
	{
		Node s=null;
		switch(tail.dir){
		   case R: 
			   s=new Node(tail.row,tail.col-1,tail.dir);
			   break;
		   case L: 
			   s=new Node(tail.row,tail.col+1,tail.dir);
			   break;
		   case U: 
			   s=new Node(tail.row+1,tail.col,tail.dir);
			   break;
		   case D: 
			   s=new Node(tail.row-1,tail.col,tail.dir);
			   break;
		}
		tail.next=s;
		s.prev=tail;
		tail=s;
		size++;
	}
	public void addtohead()
	{
		Node s=null;
		switch(head.dir){
		   case R: 
			   s=new Node(head.row,head.col+1,head.dir);
			   break;
		   case L: 
			   s=new Node(head.row,head.col-1,head.dir);
			   break;
		   case U: 
			   s=new Node(head.row-1,head.col,head.dir);
			   break;
		   case D: 
			   s=new Node(head.row+1,head.col,head.dir);
			   break;
		}
		head.prev=s;
		s.next=head;
		head=s;
		size++;
	}
	public void deltetftail()
	{
		if(size==0) return;
		tail=tail.prev;
		tail.next=null;
	}
	public void move()
	{
		this.addtohead();
		this.deltetftail();
	}
	public void draw(Graphics g)
	{
		if(size<=0) return;
		move();
		for(Node n=head;n!=null;n=n.next)
		{
			n.draw(g);
		}
	}
	public void eat(Egg e)
	{
		if(head.col==e.getCol()&&head.row==e.getRow())
		{
			this.addtotail();
			e.reApper();
		}
		s.setScore(s.getScore()+5);
		
	}
	public void keyPressed(KeyEvent e)
	{
		int key=e.getKeyCode();
		switch(key)
		{
			case KeyEvent.VK_UP:
					if(head.dir!=Dir.D)
					{
						head.dir=Dir.U;
					}
					break;
			case KeyEvent.VK_DOWN:
				if(head.dir!=Dir.U)
				{
					head.dir=Dir.D;
				}
				break;
			case KeyEvent.VK_LEFT:
				if(head.dir!=Dir.R)
				{
					head.dir=Dir.L;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(head.dir!=Dir.L)
				{
					head.dir=Dir.R;
				}
				break;
		}
	}
	private class Node
	{
		int w=yard.BLOCK_SIZE;
		int h=yard.BLOCK_SIZE;
		int row,col;
		Dir dir=Dir.R; 
		Node next=null;
		Node prev=null;
		Node()
		{
			this.row=yard.HIGH/2;
			this.col=yard.WIDTH/2;
			
		}
		Node(int row, int col,Dir dir) {
			this.row = row;
			this.col = col;
			this.dir =dir;
		}
		void draw(Graphics e)
		{
			Color c=e.getColor();
			e.setColor(Color.BLACK);
			e.fillRect(col*yard.BLOCK_SIZE, row*yard.BLOCK_SIZE, w, h);
			e.setColor(c);
		}
		
	}
}
