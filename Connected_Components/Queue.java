// Aaron Ao
// #48344474
// CSE 23 Lab 3

// This class was originally written for Professor Thornton's Spring '10 CSE 22 lab 4 assignment
// by Aaron Ao
public class Queue<E>
{
	private Node<E> head;
	private Node<E> tail;
	private int count;
	
	// Private Node class for Queue class
	private static class Node<E>
	{
		public E data;
		public Node<E> next;
		
		public Node(E data, Node<E> next)
		{
			this.data = data;
			this.next = next;
		}
	}

	// Constructor for Queue class
	public Queue()
	{
		head = null;
		tail = null;
		count = 0;
	}
	
	// Adds an element to the end of the queue
	public void enqueue(E e)
	{
		Node<E> node = new Node<E>(e, null);
		if(head == null)
		{
			head = node;
			tail = node;
		}
		else
		{
			tail.next = node;
			tail = node;
		}
		count++;
	}
	
	// Removes the first element from the queue
	public void dequeue()
	throws StackEmptyException
	{
		if(head == null)
		{
			throw new StackEmptyException();
		}
		else if(head == tail)
		{
			tail = null;
		}
		head = head.next;
		count--;
	}
	
	// Returns the data in the first element of the queue
	public E front()
	throws StackEmptyException
	{
		if(head == null)
		{
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	// Returns true if queue is empty
	public boolean isEmpty()
	{
		return count == 0;
	}
	
	// Returns the number of nodes in the queue
	public int getCount()
	{
		return count;
	}
	
	// ITERATOR CREATOR
	public Iterator iterator()
	{
		return new Iterator();
	}
	
	// ITERATOR CLASS
	public class Iterator
	{
		// Current node of iteration
		public Node<E> iter;
		
		// Iterator constructor
		public Iterator()
		{
			iter = head;
		}
		
		// Checks to see if the queue has another node
		// Returns true if the current node is null
		public boolean hasNext()
		{
			return iter != null;
		}
		
		// Returns the current element and continues to
		// the next element
		public E next()
		{
			E temp = iter.data;
			iter = iter.next;
			return temp;
		}
	}
}