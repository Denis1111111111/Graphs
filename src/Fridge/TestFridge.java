package Fridge;

public class TestFridge
{
	static boolean [][] init =  { {true,true,false,true}, {true,true,true,true}, {true,true,true,true}, {true,true,true,true} };
	//static boolean [][] init =  { {false,false,false,false}, {false,true,true,true}, {false,true,true,true}, {false,true,true,true} };
	//static boolean[][] init =   { {true, true,  false,  false}, {false,  true, false, true}, {true,  true, true, false}, {false,  false,  true,  false}};
	//static boolean[][] init =   { {true,false,true,false},{false,true,true,false}, {false,false, false, false}, {false,false, false, true}};
	
	public static void main(String []args)
	{
		Fridge fr = new Fridge();
		fr.init(init);
		fr.open();
//		String s = fr.toString();
//		System.out.println(s);
	}
}