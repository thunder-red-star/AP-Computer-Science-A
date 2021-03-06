// William Vongphanith
// APCS pd6
// HW53 -- implementing insertion sort
// 2022-01-06r
// time spent: 0.3 hrs

/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO:
 * 1. check if the array's first two elements are in order, if not, swap them
 * 2. for the third element in the array, check if it's in order with the second. if not, swap it with the second, then check with first. (walk the value to it's position)
 * 3. repeat with bigger and bigger array length until the array is sorted
 * DISCO
 * 1. The algorithm is pretty simple.
 * 2. The algorithm is O(n^2)
 * QCC
 * q0: How many passes to sort n elements?
 * a0: To sort n elements, we need to make n-1 passes.
 * q1: What do you know after pass p?
 * a1: After pass p, the first p + 1 elements are sorted.
 * q2: How will you know when sorted?
 * a2: We will know that the array is sorted when we have made length - 1 passes.
 * q3: What constitues a pass?
 * a3: A pass is a traversal of the first p + 1 elements.
 * q4: What must you track?
 * a4: How many passes were made and which elements were swapped.
 ******************************/


import java.util.ArrayList;

public class InsertionSort
{
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
        ArrayList<Integer> retAL = new ArrayList<Integer>();
        while( size > 0 ) {
            //     offset + rand int on interval [lo,hi]
            retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
            size--;
        }
        return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
        int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
            //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
            //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



    public static ArrayList<Comparable> insertionSort ( ArrayList<Comparable> data )
    {
        ArrayList<Comparable> sorted = new ArrayList<Comparable>();
        for( int i = 0; i < data.size(); i++ )
        {
            Comparable temp = data.get(i);
            int j = i;
            while( j > 0 && temp.compareTo(sorted.get(j-1)) < 0 )
            {
                sorted.set(j, sorted.get(j-1));
                j--;
            }
        }
        return sorted;
    }//end insertionSortV


    // ArrayList-returning insertionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input )
    {
        //declare and initialize empty ArrayList for copying
        ArrayList<Comparable> data = new ArrayList<Comparable>();

        //copy input ArrayList into working ArrayList
        for( Comparable o : input )
            data.add( o );

        //sort working ArrayList
        insertionSortV( data );

        //return working ArrayList
        return data;
    }//end insertionSort


    public static void main( String [] args )
    {
        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        insertionSortV(glen);
        System.out.println( "ArrayList glen after sorting:\n" + glen );
        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        insertionSortV(coco);
        System.out.println( "ArrayList coco after sorting:\n" + coco );

        ArrayList chris = new ArrayList<Integer>();
        chris.add(7);
        chris.add(1);
        chris.add(5);
        chris.add(12);
        chris.add(3);
        System.out.println( "ArrayList chris before sorting:\n" + chris );
        ArrayList chrisSorted = insertionSort( chris );
        System.out.println( "ArrayList chris after sorting:\n" + chrisSorted );
        ArrayList nick = populate( 10, 1, 1000 );
        System.out.println( "ArrayList nick before sorting:\n" + nick );
        ArrayList nickSorted = insertionSort( nick );
        System.out.println( "ArrayList nick after sorting:\n" + nickSorted );

    }//end main

}//end class InsertionSort