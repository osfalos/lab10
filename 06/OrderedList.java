/**
 * 
 * @Modified Vahdat Abdelzad
 */
import java.util.NoSuchElementException;

public class OrderedList< T extends Comparable< T > > implements OrderedStructure<T>{

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node<E> {

	private E value;

	private Node<E> previous;
	private Node<E> next;

	private Node ( E value, Node<E> previous, Node<E> next ) {
	    this.value = value;
	    this.previous = previous;
	    this.next = next;
	}
    }

    // Instance variables

    private Node<T> head;

    // Representation of the empty list.

    public OrderedList() {
    	// a dummy node is created and set with proper links.
        head = new Node<T>(null, null,null);
        head.next = head;
        head.previous = head;
    }

    // Calculates the size of the list
    
    public int size() {
    	Node<T> p = head;
    	int count = 0;
    	while ( p.next!=head ) {
    	    p = p.next;
    	    count++;
    	}
    	return count;
    }

    // This implementation does not call size() to determine
    // if pos is valid; therefore, the list is only traversed
    // once.
    //The first position is 1;
    
    public T get( int pos ) {
    	if (pos < 0) 
    	    throw new IndexOutOfBoundsException( Integer.toString( pos ) );

    	Node<T> p = head.next;
    	
    	for ( int i=0; i<pos; i++ )
    	    if ( p.next == head )
    		throw new IndexOutOfBoundsException( Integer.toString( pos ) );
    	    else
    		p = p.next;

    	return p.value;
    }

    // Adding an element while preserving the order
    
    public boolean add( T o ) {
    	if ( o == null )
    	    throw new IllegalArgumentException( "null" );

    	if ( head.next == head ) { // special case: empty list

    	    head.next = new Node<T>( o, head, head.next );

    	} else { 
    	    
    	    Node<T> p = head;

    	    // i)  there is at least one node
    	    // ii) o is greater than p

    	    while ( p.next != head && p.next.value.compareTo( o ) < 0 ) {
    	    	p = p.next;
    	    }

    		Node<T> q = p.next; // the node that follows

    		p.next = new Node<T>( o, p, q );

    		q.previous = p.next;
    	}

    	return true;
    }

    //Removes one item from the position pos.
    
    public void remove( int pos ) {
    	if ( pos < 0 ) 
    	    throw new IndexOutOfBoundsException( Integer.toString( pos ) );

    	Node<T> p = head.next;
    	for ( int i=0; i<pos; i++ ) // traversing pos nodes
    		if ( p.next == head )
    		    throw new IndexOutOfBoundsException(Integer.toString(pos));
    		else
    		    p = p.next;
    	    
    	    Node<T> del = p;  // the node to delete

    	    p = p.previous; // p designates de previous node

    	    Node<T> q = del.next; // q designates the node that follows

    	    p.next = q;
    	    
    		q.previous = p;

    	    del.value = null;
    	    del.next = null;
    	    del.previous = null;
    }
    
    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList<T> other ) {
    	Node<T> p = head.next;
        Node<T> q = other.head.next;
        while(q!=other.head){
        	if ( p == head ) {  
                p.next = new Node<T>( q.value, p, p.next );
                p = p.next;
                q = q.next;
            } else if (q.value.compareTo(p.value) < 0){
				//insert before
            	p.previous = new Node<T>( q.value, p.previous, p );
            	p.previous.previous.next = p.previous;
            	q = q.next;
            } else if (p.next==head){
				//insert after
            	p.next = new Node<T>( q.value, p,head );
            	p = p.next;
            	q = q.next;
            } else {
            	p=p.next;
            }
        }
    }
}
