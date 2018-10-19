package MamaRama;
public class Graph 
{
	String [] ar = null;
	boolean[] visit = null;
	LList lst = new LList();

	public Graph(String str)
	{
		String [] ar = str.split(" ");
		this.ar = ar;
		visit = new boolean[ar.length];
	}

	public void findWay(boolean[]visit, LList lst)
	{
		if(lst.size() == visit.length)
		{
			String res = "";
			for(int q = 0;q < lst.size();q++)
			{
				res+= ar[lst.get(q)] + " ";				
			}
			System.out.println(res);
			return;
		}
		for(int i = 0; i < visit.length; i++)
		{
			if(visit[i] == false)
			{
				lst.addEnd(i);
				visit[i] = true;
				findWay(visit, lst);
				visit[i] = false;
				lst.delEnd();
			}
		}
	}
}
