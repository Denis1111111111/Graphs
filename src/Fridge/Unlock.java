package Fridge;

import java.util.ArrayList;

public class Unlock
{
	ArrayList<ArrayList<Integer>> ways = new ArrayList<ArrayList<Integer>>();
	int limit = 7;

	public void unlock (Fridge fr)
	{
		action(fr,limit);
		print();
	}

	private void action(Fridge fr,int level )
	{
		if( level == 0 || fr.check())
		{return;}

		for(int i = 0; i < 16; i++)
		{
			if(fr.history.contains(i))
			{
				continue;
			}
			try 
			{
				Fridge clone = (Fridge)fr.clone();
				clone.turn(i); 
				if(clone.check() == true)
				{
					if(equalsHistory(clone.history) )
					{
						ways.add(clone.history);
						continue;     
					}
					continue;
				}
				action(clone,level-1);
			}
			catch (CloneNotSupportedException e)
			{e.printStackTrace();}
		}
	}

	public void print()
	{
		for(int i = 0; i < ways.size(); i++)
		{
			for(int j = 0; j < ways.get(i).size(); j++)
			{
				if(j == 0)
				{
					System.out.println("\n"+ (i+1) + " way:");
				}
				System.out.println(ways.get(i).get(j));
			}
		}
	}

	private boolean	equalsHistory(ArrayList<Integer> history)
	{
		for(int i = 0; i < ways.size(); i++)
		{
			if(ways.get(i).size() != history.size())
			{
				continue;
			}
			for(int j = 0; j < history.size(); j++ )
			{
				if(ways.get(i).get(j) != history.get(j))
				{
					continue;
				}
				if(ways.get(i).get(j) == history.get(j) && j == history.size() - 1)
				{
					return false;
				}
			}
		}
		return true;
	}
}