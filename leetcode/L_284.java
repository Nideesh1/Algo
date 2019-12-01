// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    public Iterator<Integer> iter;
    public Integer next;
    public boolean hasNext;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
        next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer n = next;
        this.hasNext = iter.hasNext();
        if(iter.hasNext()){
            this.next = iter.next();
        }
        return n;
	}

	@Override
	public boolean hasNext() {
	    return this.hasNext;   
	}
}

//https://leetcode.com/problems/peeking-iterator/discuss/72558/Concise-Java-Solution
