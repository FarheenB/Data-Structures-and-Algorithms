/*
https://leetcode.com/problems/peeking-iterator
*/

import java.util.*;
import java.lang.*;
import java.io.*;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> iter;
    int peekedElem;
    boolean hasPeeked;
    
	public PeekingIterator(Iterator<Integer> iterator) {
        iter=iterator;
        hasPeeked=false;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!hasPeeked){
            peekedElem=iter.next();
            hasPeeked=true;            
        }
        return peekedElem;
    }
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(!hasPeeked){
            return iter.next();
        }
        hasPeeked=false;
        return peekedElem;
	}
	
	@Override
	public boolean hasNext() {
	    return hasPeeked || iter.hasNext();
	}
}