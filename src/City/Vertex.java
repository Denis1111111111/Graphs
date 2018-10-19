package City;

public class Vertex 
{
	String val = null;
	Vertex next = null;
	Edge root = null;

	public Vertex(String val)
	{
		this.val = val;
	}

	public String toString()
	{
		String str = "from " + val;
		Edge e = root;
		
		if(e == null)
		{
			return "No way out of " + val;
		}
		str += "\n" + e.toString();
		while(e.next != null)
		{
			e = e.next;
			str += "\n" + e.toString();
		}
		return str;
	}	
}