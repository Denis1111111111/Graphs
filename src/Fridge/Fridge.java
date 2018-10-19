package Fridge;
import java.util.ArrayList;

public class Fridge implements Cloneable
{
	boolean [][]fr = new boolean [4][4];
	ArrayList<Integer> history = new ArrayList<Integer>();

	public Fridge()
	{}

	public Fridge(boolean [][]ini)
	{
		init(ini);
	}
	
	public void open()
	{
		new Unlock().unlock(this);
	}

	public void init(boolean[][]ini)
	{
		for(int i = 0; i < 16; i++)
		{
			fr[i/4][i%4] = ini[i/4][i%4];
		}
	}

	public void turn(int x)
	{
		for(int i = 0; i < 16; i++)
		{
			if(i/4 == x/4 || i%4 == x%4 )
			{
				fr[i/4][i%4]  = ! fr[i/4][i%4];
			}
		}
		history.add(x);
	}

	public boolean check()
	{
		for(int i = 0; i < 16; i++)
		{
			if(fr[i/4][i%4] == false)
			{
				return false;
			}
		}
		return true;
	}

	public String toString()
	{
		String s="";

		for(int i=0; i < 16; i++)
		{
			s += fr[i/4][i%4] + "\t";

			if(i%4 == 3)
			{
				s += "\n";
			}
		}
		return s;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		Fridge copy = new Fridge();
		copy.init(fr);
		
		for(int i = 0; i < history.size(); i++)
		{
			copy.history.add(history.get(i));
		}
		return copy;
	}
}