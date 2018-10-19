package City;

public class Graph implements Cloneable
{
	public Vertex root;

	public void addVertex( String val)
	{
		Vertex v = new Vertex(val);

		if(root == null)
		{	
			root = v;
			return;
		}
		Vertex tmp = root;

		while(tmp.next != null)
		{
			tmp = tmp.next;

			if(tmp.val == v.val)
			{
				return;
			}
		}
		tmp.next = v;
	}

//	public void delVertex(Vertex vr, String val)
//	{
//		if(vr == null)
//		{
//			throw new IllegalArgumentException("There is no such city in the list");
//		}
//		if(vr.next.val == val && vr.next.next != null)
//		{
//			vr.next = vr.next.next;
//			return;
//		}
//		if(vr.next.val == val && vr.next.next == null)
//		{
//			vr.next = null;
//			return;
//		}
//		else 
//		{
//			delVertex(vr.next,val);
//		}
//	}

	void delVertex(String val)
	{
		if(searchVertex(val) == root)
			root = root.next;
		else
		{
			Vertex tmp = root;

			while(tmp.next != null)
			{
				Vertex prew = tmp;
				tmp = tmp.next;
				if(tmp.val == val)
				{
					prew.next = tmp.next;
					return;
				}
			}
		}

		checkEdge();
	}

	private void checkEdge() 
	{
		if(root == null)
			return;

		Vertex tmp = root;
		while(tmp != null)
		{
			Edge tmpE = tmp.root;
			while(tmpE != null)
			{
				if(tmpE.vr == null)
				{
					Edge forDelete = tmpE;
					tmpE = tmpE.next;
					delEdge(forDelete, tmp);
				}
				else 
					tmpE = tmpE.next;
			}
			tmp = tmp.next;
		}
	}
	
	public void addEdge(int val, String a, String b)
	{
		Vertex start = null;
		Vertex finish = null;
		Edge e = new Edge(val);

		Vertex vtmp = root;

		if(root.val == a)
		{
			start = root;
		}

		if(root.val == b)
		{
			finish = root;
		}

		while(vtmp.next != null)
		{
			vtmp = vtmp.next;

			if(vtmp.val == a)
			{
				start = vtmp;
			}

			if(vtmp.val == b)
			{
				finish = vtmp;
			}
		}

		if(start == null )
		{
			addVertex(a);
			addEdge(val,a,b);
			return;
		}

		if( finish == null)
		{
			addVertex(b);
			addEdge(val,a,b);
			return;
		}

		e.vr = finish;
		if(start.root == null)
		{
			start.root = e;
		}
		else
		{
			Edge tmp = start.root;
			while(tmp.next != null)
			{
				tmp = tmp.next;
			}
			tmp.next = e;
		}
	}

//	public void delEdge(String from,String to, int val)
//	{
//		Vertex vtmp = root;
//		
//		if(root.val == from)
//		{
//			vtmp = root;
//		}
//
//	label:	while(vtmp.next != null)
//		{
//			vtmp = vtmp.next;
//
//			if(vtmp.val == from)
//			{
//				break label ;
//			}
//		}
//		Edge etmp = vtmp.root;
//		if(etmp == null)
//		{
//			System.out.println("No way from this city");
//			return;
//		}
//		
//		if(etmp != null)
//		{
//			if(etmp.vr.val == to && etmp.val == val && etmp.next != null)
//			{
//				etmp = etmp.next;
//				System.out.println(1);
//				return;
//			}
//
//			if(etmp.vr.val == to && etmp.val == val && etmp.next == null)
//			{
//				etmp = null;
//				vtmp.root = null;
//				System.out.println(2);
//		//		System.out.println(vtmp.root.val);
//				return;
//			}
//		}
//		
//		
//		while(etmp.next != null)
//		{
//			etmp = etmp.next;
//			
//			if(etmp.next.vr.val == to && etmp.next.val == val && etmp.next.next != null)
//			{
//				System.out.println(3);
//				etmp.next = etmp.next.next;
//				return;
//			}
//			
//			if(etmp.next.vr.val == to && etmp.next.val == val && etmp.next.next == null)
//			{
//				etmp.next = null;
//				System.out.println(4);
//				return;
//			}
//		}
//	}
	
	void delEdge(String from, String to)
	{
		Vertex From = searchVertex(from);
		Vertex To = searchVertex(to);
		Edge tmp = From.root;

		while(tmp != null)
		{
			if(tmp.vr == To)
			{
				delEdge(tmp, From);
				return;
			}
			tmp = tmp.next;
		}

		throw new IllegalArgumentException();
	}

	void delEdge(Edge del, Vertex from)
	{
		if(del == from.root)
			from.root = from.root.next;
		else
		{
			Edge tmp = from.root;

			while(tmp.next != null)
			{
				Edge prew = tmp;
				tmp = tmp.next;
				if(tmp == del)
				{
					prew.next = tmp.next;
					return;
				}
			}
		}
	}
	
	Vertex searchVertex(String val)
	{
		Vertex tmp = root;

		Vertex result = null;

		while(tmp != null)
		{
			if(tmp.val.equals(val))
			{
				result = tmp;
			}
			tmp = tmp.next;
		}

		if(result == null)
			throw new IllegalArgumentException();
		else 
			return result;
	}

	public String toString()
	{
		String str = "";
		Vertex v = root;

		if(v == null)
		{
			return"Cities are not listed";
		}

		str += v.toString()+"\n";
		while(v.next != null)
		{
			v = v.next;
			str += 	v.toString() +"\n";
		}
		return str;
	}

	public void findWay(String a, String b)
	{
		Vertex start = null;
		Vertex finish = null;
		Vertex vtmp = root;
		String res = "No way";

		while(vtmp.next != null)
		{
			if(vtmp.val == a)
			{
				start = vtmp;
			}

			if(vtmp.val == b)
			{
				finish = vtmp;
			}
			vtmp = vtmp.next;
		}
		if(start == null || finish == null || start.root == null)
		{
			System.out.println(res);
			return;
		}
		else
		{
			GetWay gw = new GetWay();
			gw.way(start, finish.val);
			gw.paintAllWay();
			gw.paintMinWay();
		}
	}

	public int size(Vertex root)
	{
		int count = 1;
		while(root.next != null)
		{
			count++;
		}
		return count;
	}

	public boolean equals(Graph graph1, Graph graph2)
	{
		Vertex tmp1 = graph1.root;
		Vertex tmp2 = graph2.root;
		
		while(tmp1 != null)
		{
			if(tmp1.next == null && tmp2.next != null)
			{
				return false;
			}
			if(tmp1.val.equals(tmp2.val) == false)
			{
				return false;
			}
			Edge etmp1 = tmp1.root;
			Edge etmp2 = tmp2.root;
			
			while(etmp1 != null)
			{
				if(etmp1.next == null && etmp2.next != null)
				{
					return false;
				}
				if(etmp1.val != etmp2.val && etmp1.vr.val.equals(etmp2.vr.val)  == false)
				{
					return false;
				}
				etmp1 = etmp1.next;
				etmp2 = etmp2.next;
			}
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		return true;
	}

//	public void sort(Graph graph)
//	{
//		try 
//		{
//			Graph clone = graph.clone();
//		} 
//		catch (CloneNotSupportedException e) 
//		{
//			e.printStackTrace();
//		}
//
//		ArrayList<Vertex> ar1 = new ArrayList<Vertex>();
//		ArrayList<Vertex> ar2 = new ArrayList<Vertex>();
//		Vertex tmp = graph.root;
//
//		while(tmp != null)
//		{
//			graph.delVertex(tmp.val);
//			ar1.add(tmp);
//			tmp = tmp.next;
//		}
//		for(int i = 0; i < ar1.size(); i++)
//		{
//			char[] arch = (ar1.get(i).val).toCharArray();
//			for( int j = 0; j < ar1.size(); j++)
//			{
//				char[] arch = (ar1.get(i).val).toCharArray();
//			}
//		}
//	}
	

	@Override
	protected Graph clone() throws CloneNotSupportedException 
	{
		Graph copy = new Graph();
		Vertex tmp = root;
		Edge etmp = root.root;

		while(tmp != null)
		{
			copy.addVertex(tmp.val);
			etmp = tmp.root;

			while(etmp != null)
			{
				copy.addEdge(etmp.val,tmp.val,etmp.vr.val);
				etmp = etmp.next;
			}
			tmp = tmp.next;
		}
		return copy;
	}
}