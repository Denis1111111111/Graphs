package City;

public class Test 
{
	public static void main(String[] args)
	{
		Graph graph = new Graph();
	//	Graph graph2 = new Graph();
		String [] cities = {"Kyiv", "Dnipro", "Kharkiv", "Lviv"};
		for(int i = 0; i < cities.length; i++)
		{
			graph.addVertex(cities[i]);
		}
		graph.addEdge(200,"Dnipro", "Kyiv" );
		graph.addEdge(150,"Kyiv", "Kharkiv" );
		graph.addEdge(100,"Dnipro", "Lviv");
		graph.addEdge(200,"Lviv", "Kharkiv" );
		graph.findWay("Dnipro", "Kharkiv");
		
//		String [] citiess = {"Kyiv", "Dnipro", "Kharkiv", "Lviv"};
//		for(int i = 0; i < cities.length; i++)
//		{
//			graph2.addVertex(cities[i]);
//		}
//		
//		graph2.addEdge(150,"Kyiv", "Dnipro" );
//		graph2.addEdge(100,"Kyiv", "Lviv");
//		
//		System.out.println(graph.equals(graph, graph2));
//		for(int i = 0; i < cities.length; i++)
//		{
//			if(!cities[i].equals("Kyiv"))
//			graph.addEdge((int)(Math.random()*500 + 100),"Kyiv", cities[i] );
//			
//			if(!cities[i].equals("Dnipro"))
//				graph.addEdge((int)(Math.random()*500 + 100),"Dnipro", cities[i]);
//			
//			if(!cities[i].equals("Kharkiv"))
//				graph.addEdge((int)(Math.random()*500 + 100),"Kharkiv", cities[i]);
//			
//			if(!cities[i].equals("Lviv"))
//				graph.addEdge((int)(Math.random()*500 + 100),"Lviv", cities[i]);	
//		}
//		graph.addEdge(200,"Kyiv", "Dnipro" );
//		graph.addEdge(100,"Kharkiv", "Lviv");
//		graph.delEdge("Kyiv", "Dnipro", 200);
//		System.out.println(graph.toString());
//		
//		Edge tmp = graph.root.next.next.next.root;
//		System.out.println(tmp.toString());
//		
//		while(tmp.next != null)
//		{
//			tmp = tmp.next;
//			System.out.println(tmp.toString());
//		}
	}
}