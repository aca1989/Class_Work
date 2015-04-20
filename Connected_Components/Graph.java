// Aaron Ao
// #48344474
// CSE 23 Lab 3

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph
{
	private static final String BREADTH_SEARCH = "BFS";
	private static final String DEPTH_SEARCH = "DFS";
	private ArrayList<Vertex> vertices;
	private int numberOfVertices;
	
	public Graph(String fileName)
	throws FileNotFoundException
	{
		FileReader reader = new FileReader(fileName);
		Scanner scanner = new Scanner(reader);
		vertices = new ArrayList<Vertex>();

		if(scanner.hasNext())
		{
			numberOfVertices = scanner.nextInt();

			// Adds the vertices to the ArrayList
			for(int i = 0; i < numberOfVertices; i++)
			{
				vertices.add(new Vertex(i));
			}

			while(scanner.hasNext())
			{
				int vertex = scanner.nextInt();
				int edge = scanner.nextInt();
				boolean exists = false;

				vertices.get(vertex).addEdge(edge);
				
				for(int j = 0; j < vertices.get(edge).getEdgeCount(); j++)
				{
					if(vertices.get(edge).getEdges().get(j).getVertex() == vertex)
						exists = true;
				}

				if(exists == false)
				{
					vertices.get(edge).addEdge(vertex);
				}
			}
		}
		else
		{
			System.out.println("THE INPUT FILE IS EMPTY.");
		}
	}
	
	// Determines the appropriate search for the graph
	public void search(String searchType)
	throws StackEmptyException
	{
		if(searchType.equals(Graph.BREADTH_SEARCH))
		{
			breadthFirstSearch();
		}
		else if(searchType.equals(Graph.DEPTH_SEARCH))
		{
			depthFirstSearch();
		}
	}
	
	// Performs a breadth first search
	public void breadthFirstSearch()
	throws StackEmptyException
	{
		// Initializes the queue
		Queue<Vertex> queue = new Queue<Vertex>();
		
		// For each unvisited vertex, find all its connections
		for(int i = 0; i < numberOfVertices; i++)
		{
			if(!vertices.get(i).getVisited())
			{
				// Enqueues the first vertex, then prints it and sets visited to true.
				queue.enqueue(vertices.get(i));
				System.out.print(queue.front().getVertexNumber() + " ");
				queue.front().setVisit();

				// While the queue is not empty, get the children of the vertex at the front of the queue, print them,
				// then enqueue the vertices.
				while(!queue.isEmpty())
				{
					Vertex v = queue.front();
					queue.dequeue();

					for(int j = 0; j < v.getEdgeCount(); j++)
					{
						if(!vertices.get(v.getEdges().get(j).getVertex()).getVisited())
						{
							System.out.print(vertices.get(v.getEdges().get(j).getVertex()).getVertexNumber() + " ");
							vertices.get(v.getEdges().get(j).getVertex()).setVisit();
							queue.enqueue(vertices.get(v.getEdges().get(j).getVertex()));
						}
					}
				}

				// Starts a newline if the component ends
				System.out.println();
			}
		}
	}
	
	// Performs a depth first search
	public void depthFirstSearch()
	throws StackEmptyException
	{
		// Initializes a new stack
		Stack<Vertex> stack = new Stack<Vertex>();

		// For each unvisited vertex, find all its connections
		for(int i = 0; i < numberOfVertices; i++)
		{
			if(!vertices.get(i).getVisited())
			{
				// Pushes the first unvisited vertex to the stack
				stack.push(vertices.get(i));
				
				// While the stack is not empty, print the vertex to console if it is unvisited,
				// Then pop the vertex and push all of the vertex's edges in reverse order
				while(!stack.isEmpty())
				{
					Vertex v = stack.top();

					if(!v.getVisited())
					{
						v.setVisit();
						System.out.print(v.getVertexNumber() + " ");
					}

					stack.pop();

					for(int j = v.getEdgeCount() - 1; j >= 0; j--)
					{
						// If the vertex on vertex v's Jth edge is not visited
						// then push that vertex onto the stack
						if(!vertices.get(v.getEdges().get(j).getVertex()).getVisited())
						{
							stack.push(vertices.get(v.getEdges().get(j).getVertex()));
						}
					}
				}

				// Start a newline if the component ends
				System.out.println();
			}
		}
	}
}