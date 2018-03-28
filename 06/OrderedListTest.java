//                              -*- Mode: Java -*- 
// OrderedListTest.java --- OrderedList Test Program
// Author          : Marcel Turcotte
// Created On      : Wed Mar 24 16:43:09 2004
// Last Modified By: Marcel Turcotte
// Last Modified On: Fri Mar  9 14:29:28 2007

// Produces an empty output if all the tests are successful

class OrderedListTest {

    public static void main( String[] args ) {

        OrderedList<Integer> a = new OrderedList<Integer>();

        if ( a.size() != 0 )
            System.out.println( "test 000: failed, empty list" );

        for ( int i=1; i<=10; i++ ) { // add last
            a.add( new Integer( i ) );

            if ( a.size() != i )
                System.out.println( "test 00: failed, i = " + i );
        }

        a = new OrderedList<Integer>();

        for ( int i=10; i>=1; i-- ) { // add first
            a.add( new Integer( i ) );

            if ( a.size() != 10 - i + 1 )
                System.out.println("test 01: failed, i = " + i);
        }

        a = new OrderedList<Integer>();

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

        a = new OrderedList<Integer>();

        for ( int i=0; i<10; i++ ) {
            a.add( new Integer( i ) );
        }

        for ( int i=0; i<10 && a.size() > 0; i++ ) {
            int v = ( (Integer) a.get( 0 ) ).intValue();
            if ( v != i ) {
                System.out.println("test 03: failed, i = " + i);
            }
            a.remove( 0 );
        }
                 
        if ( a.size() > 0 )
            System.out.println("test 03: failed");

        a = new OrderedList<Integer>();

        for ( int i=0; i<10; i++ ) {
            a.add( new Integer( i ) );
        }

        for ( int i=0; i<10 && a.size() > 0; i++ ) {
            int v = ( (Integer) a.get( a.size()-1 ) ).intValue();
            if ( v != ( 10 - i - 1 ) ) {
                System.out.println( "test 04: failed, i = " + i );
            }
            a.remove( a.size()-1 );
        }
                 
        if ( a.size() > 0 )
            System.out.println( "test 04: failed" );

        a = new OrderedList<Integer>();

        for ( int i=0; i<10; i=i+2 ) {
            a.add( new Integer( i ) );
        }

        OrderedList<Integer> b = new OrderedList<Integer>();

        for ( int i=1; i<10; i=i+2 ) {
            b.add( new Integer( i ) );
        }

        a.merge( b );

        for ( int i=0; i<10; i++ ) {
            int v = ( (Integer) a.get( i ) ).intValue();
            if (v != i) {
                System.out.println("test 05: failed, i = " + i);
            }
        }

        a = new OrderedList<Integer>();

        for ( int i=0; i<5; i++ ) {
            a.add( new Integer( i ) );
        }

        b = new OrderedList<Integer>();

        for ( int i=5; i<10; i++ ) {
            b.add( new Integer( i ) );
        }

        a.merge( b );

        for ( int i=0; i<10; i++ ) {
            int v = ( (Integer) a.get( i ) ).intValue();
            if ( v != i ) {
                System.out.println( "test 06: failed, i = " + i );
            }
        }

        System.out.println( "done!" );
    }
}
