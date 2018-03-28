/**
 * 
 * @Modified Vahdat Abdelzad
 */
import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

	private Comparable value;

	private Node previous;
	private Node next;

	private Node ( Comparable value, Node previous, Node next ) {
	    this.value = value;
	    this.previous = previous;
	    this.next = next;
	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
    	// a dummy node is created and set with proper links.
        head = new Node(null, null,null);
        head.next = head;
        head.previous = head;
    }

    // Calculates the size of the list
    
    public int size() {
    	Node p = head;
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
    
    public Object get( int pos ) {
    	if (pos < 0) 
    	    throw new IndexOutOfBoundsException( Integer.toString( pos ) );

    	Node p = head.next;
    	
    	for ( int i=0; i<pos; i++ )
    	    if ( p.next == head )
    		throw new IndexOutOfBoundsException( Integer.toString( pos ) );
    	    else
    		p = p.next;

    	return p.value;
    }

    // Adding an element while preserving the order
    
    public boolean add( Comparable o ) {
    	if ( o == null )
    	    throw new IllegalArgumentException( "null" );

    	if ( head.next == head ) { // special case: empty list

    	    head.next = new Node( o, head, head.next );

    	} else { 
    	    
    	    Node p = head;

    	    // i)  there is at least one node
    	    // ii) o is greater than p

    	    while ( p.next != head && p.next.value.compareTo( o ) < 0 ) {
    	    	p = p.next;
    	    }

    		Node q = p.next; // the node that follows

    		p.next = new Node( o, p, q );

    		q.previous = p.next;
    	}

    	return true;
    }
	
	//Removes one item from the position pos.

    public void remove( int pos ) {
    	if ( pos < 0 ) 
    	    throw new IndexOutOfBoundsException( Integer.toString( pos ) );

    	Node p = head.next;
    	for ( int i=0; i<pos; i++ ) // traversing pos nodes
    		if ( p.next == head )
    		    throw new IndexOutOfBoundsException(Integer.toString(pos));
    		else
    		    p = p.next;
    	    
    	    Node del = p;  // the node to delete

    	    p = p.previous; // p designates de previous node

    	    Node q = del.next; // q designates the node that follows

    	    p.next = q;
    	    
    		q.previous = p;

    	    del.value = null;
    	    del.next = null;
    	    del.previous = null;
    }
}
