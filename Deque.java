package deques;

public class Deque<Item> /*implements Iterable<Item>*/{
	private int N = 0;
	private Node first, last;
	
	private class Node{
		Node next;
		Item item;
	}
	
	public Deque(){
		// construct an empty deque
	}
	
	public boolean isEmpty(){
		if(N == 0)
			return true;
		else 
			return false;
	}
	
	// return the number of items on the deque
	public int size(){
		return N;
	}
	
	// insert the item at the front
	public void addFirst(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		
		if(isEmpty())
			last = first;
		else
			first.next = oldFirst;
		
		N++;
	}
	
	// insert the item at the end
	public void addLast(Item item){
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(isEmpty())
			first = last;
		else
			oldLast.next = last;
		
		N++;
	}
	
	// delete and return the item at the front
	public Item removeFirst(){
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	// delete and return the item at the end
	public Item removeLast(){
		Item item = last.item;
		//need to delete last
		return item;
	}
	
	/*
	public Iterator<Item> iterator(){
		// return an iterator over items in order from front to end
		return ;
	}
*/
	public static void main(String[] args){
		// unit testing
		Deque<String> link = new Deque<String>();
		link.addFirst("hello");
		link.removeFirst();
	}
}
