package City;

import java.util.ArrayList;

public class GetWay
{
	ArrayList<Graph> ways = new ArrayList<Graph>();
	ArrayList<Integer> distances = new ArrayList<Integer>();
	int limit = 3;
	int dist = 0;
	String start;
	String finish;

	public void way(Vertex start, String finish)
	{
		this.finish = finish;
		this.start = start.val;
		Graph way = new Graph();
		way.addVertex(start.val);
		getWay(way,start,0);
	}

	private void getWay(Graph way, Vertex from, int level)
	{
		if(level == limit || from.root == null || from.val == start && level != 0)
		{
			System.out.println(from.val + ","  + level);
			return;
		}

		Edge eg = from.root;
		Graph ww = null;

		while(eg != null)
		{
			if(eg.vr.val == finish)
			{
				way.addEdge(eg.val,from.val, eg.vr.val);
				way.delVertex(eg.vr.val);
				ways.add(way);
				dist += eg.val;
				distances.add(dist);
				dist-=eg.val;
				return;
			}
			way.addEdge(eg.val,from.val, eg.vr.val);
			dist += eg.val;
			try
			{  
				ww = (Graph) way.clone();    
			}
			catch (CloneNotSupportedException e)
			{
				e.printStackTrace();
			}
			getWay(ww,eg.vr,level+1);
			dist -= eg.val;	
			way.delEdge(from.val, eg.vr.val);
			way.delVertex(eg.vr.val);
			eg = eg.next;
		}
	}

	public void paintAllWay()
	{
		String str = "\n" + "From " + start + " to " + finish + " there are ways:";
		for(int i = 0; i < ways.size(); i++)
		{
			str += "\n\n"+"Way "+ (i + 1)  + " ( total length " + distances.get(i)+" )";
			str +="\n" + ways.get(i).toString();
		}	
		System.out.println(str);
	}

	public void paintMinWay()
	{
		String str = "From " + start + " to " + finish + " shortest way:";
		int tmp = 0;
		int index = 0;
		for(int i = 0; i < distances.size(); i++)
		{
			if(tmp == 0)
			{
				tmp = distances.get(i);
			}
			else if(distances.get(i) < tmp)
			{
				tmp = distances.get(i);
				index = i;
			}
		}
		System.out.println( str +="\n" + ways.get(index).toString()  + "(total length " + tmp+ ")");	
	}
}