package MamaRama;
public class MamaRama
{
	static String str = "���� ���� ���� ";
	static	Graph graph = new Graph(str);

	public static void main(String [] args)
	{
		graph.findWay(graph.visit, graph.lst);
	}
}

