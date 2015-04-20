// Aaron Ao
// #48344474
// CSE 23 Lab 3

import java.util.ArrayList;

public class Vertex
{
	private int vertexNumber;
	private boolean visited;
	private ArrayList<Edge> edges;
	
	public Vertex(int vertexNumber)
	{
		this.vertexNumber = vertexNumber;
		visited = false;
		edges = new ArrayList<Edge>();
	}
	
	// Adds an outgoing edge to the vertex
	public void addEdge(int edgeNumber)
	{
		edges.add(new Edge(edgeNumber));
	}
	
	public void setVisit()
	{
		visited = true;
	}
	
	// Accessor methods
	public int getVertexNumber()
	{
		return vertexNumber;
	}
	
	public boolean getVisited()
	{
		return visited;
	}
	
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
	
	public int getEdgeCount()
	{
		return edges.size();
	}
}
