// Aaron Ao
// #48344474
// CSE 23 Lab 3

import java.io.FileNotFoundException;

public class ConnectedComponents
{
	public static void main(String[] args)
	{
		try
		{
			if(args.length > 1)
			{
				String searchType = args[0];
				String fileName = args[1];
				Graph graph = new Graph(fileName);
				graph.search(searchType);
			}
			else
			{
				System.out.println("INSUFFICENT INPUT ARGUMENTS.");
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch(StackEmptyException e)
		{
			System.out.println(e.getMessage());
		}
	}
}