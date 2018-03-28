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

    public int size() {
	throw new UnsupportedOperationException( "not implemented yet!" );
    }

    public Object get( int pos ) {
	throw new UnsupportedOperationException( "not implemented yet!" );
    }

    public boolean add( Comparable o ) {
	throw new UnsupportedOperationException( "not implemented yet!" );
    }

    public void remove( int pos ) {
	throw new UnsupportedOperationException( "not implemented yet!" );
    }
}
