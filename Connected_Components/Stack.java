// Aaron Ao
// #48344474
// CSE 23 Lab 3

// This class was originally written for Professor Thornton's Spring '10 CSE 22 lab 3 assignment
// by Aaron Ao
public class Stack<E>
{

	// Private Node class for Stack class
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
	
	private Node<E> head;
	private int count;
	
	// The constructor initializes the stack to be empty.
	public Stack()
	{
		head = null;
		count = 0;
	}
	

	// push() takes an element of the appropriate type and pushes it on to
	// the stack.
	public void push(E e)
	{
		Node<E> node = new Node<E>(e, null);
		if(head == null)
		{
			head = node;
		}
		else
		{
			node.next = head;
			head = node;
		}
		count++;
	}


	// pop() removes the element at the top of the stack.  If the stack is
	// empty, there are no elements to be removed, so a StackEmptyException
	// is thrown instead.
	public void pop()
	throws StackEmptyException
	{
		if(head == null)
		{
			throw new StackEmptyException();
		}
		else
		{
			head = head.next;
			count--;
		}
	}


	// top() returns the element at the top of the stack without removing it.
	// If the stack is empty, there is no element to be returned, so a
	// StackEmptyException is thrown instead.
	public E top()
	throws StackEmptyException
	{
		if(head != null)
		{
			return head.data;
		}
		throw new StackEmptyException();
	}


	// isEmpty() returns true if the stack is empty and false if it's not.
	public boolean isEmpty()
	{
		return count == 0;
	}
}