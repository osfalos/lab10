class OrderedListTest {

    public static void main( String[] args ) {

	OrderedList a = new OrderedList();
	
	if ( a.size() != 0 )
	    System.out.println( "test 000: failed, empty list" );
	
	System.out.println( "done!" );
    }
}
