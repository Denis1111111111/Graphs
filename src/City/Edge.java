package City;

public class Edge
{
	int val;
	Edge next;
	Vertex vr = null;

	public Edge(int val)
	{
		this.val = val;	
	}

	public String toString()
	{
		return val + " to " + vr.val;
	}
}