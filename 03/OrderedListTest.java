//                              -*- Mode: Java -*- 
// OrderedListTest.java --- OrderedList Test Program
// Author          : Marcel Turcotte
// Created On      : Wed Mar 24 16:43:09 2004
// Last Modified By: Vahdat Abdelzad 
// Last Modified On: Thur Mar 17 11:36:41 2016

// Produces an empty output if all the tests are successful
class OrderedListTest {

    public static void main( String[] args ) {

	OrderedList a = new OrderedList();
	
	if ( a.size() != 0 )
	    System.out.println( "test 000: failed, empty list" );

	for ( int i=1; i<=10; i++ ) { // add last
	    a.add( new Integer( i ) );

	    if ( a.size() != i )
		System.out.println( "test 00: failed, i = " + i );
	}


	a = new OrderedList();

	for ( int i=10; i>=1; i-- ) { // add first
	    a.add( new Integer( i ) );

	    if ( a.size() != 10 - i + 1 )
		System.out.println("test 01: failed, i = " + i);
	}

	a = new OrderedList();

	for ( int i=0; i<10; i=i+2 ) {
	    a.add( new Integer( i ) );
	}
	 
	
	for ( int i=1; i<10; i=i+2 ) {
	    a.add( new Integer( i ) );
	}

	for ( int i=0; i<10; i++ ) {
	    int v = ( (Integer) a.get( i ) ).intValue();
	    if ( v != i ) {
		System.out.println( "test 02: failed, i = " + i );
	    }
	}

	System.out.println( "done!" );
    }
}
