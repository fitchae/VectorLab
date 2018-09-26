package data_structures;
import java.lang.IndexOutOfBoundsException;

import javax.sound.midi.Sequence;
/**
 * StringArray: An implementation of a dynamic-sized string array.
 * 
 * @author TODO: Alicia Fitch, fitchae
 *Collaborated with Steven Bower and Adetayo/Alex Oladele
 */

public class StringVector extends Sequence  {

	/**
	 * A: Contains the actual array.
	 */
	private String[] A;
	
	/**
	 * n: Size of array
	 */
	int n;

	
	/**
	 * Basic constructor: Creates an "empty" list.
	 */
	public StringVector() {
		A = new String[1];
		n = 0;
	}

	/**
	 * Return the number of strings contained in the list.
	 * @return int
	 */
	public int size() {
		return n;
	}
	
	/**
	 * Get the string i.
	 * @param i Number of accessed element (from 0).
	 * @return string
	 * @throws IndexOutOfBoundsException if index out of bounds
	 */
	public String get(int i) {
		if (i < 0 || i >= size())
			throw new IndexOutOfBoundsException();
		numOps++;
		return A[i];
	}

	/**
	 * Set the string at element i to value.
	 * @param i Number of accessed element (from 0).
	 * @param value String value being put in the array
	 * @return string
	 * @throws IndexOutOfBoundsException if index out of bounds
	 */
	public String set(int i, String value) {
		if (i < 0 || i >= size())
			throw new IndexOutOfBoundsException();
		String y = A[i];
		A[i] = value;
		numOps+=2;
		return y;
	}
	
	/**
	 * Insert a new value at index i (bumping elements i - size() up one).
	 * @param i Number of inserted element
	 * @param value String valueb eing inserted
	 * @throws IndexOutOfBoundsException if index out of bounds
	 */
	//_____________________________FIX ME
	public void add(int i, String value) {
		if (i < 0 || i > size())
			throw new IndexOutOfBoundsException();		

		resize();  // This will make sure A is large enough to hold the new element
		// TODO: Now you need to shift the elements, add the new element,
		// and change n.  (And ***please*** remove the TODO comments in your submission.)
		for(int j = n-1;j>=i;j--){
			A[j+1]=A[j];
			numOps++;
		}
		A[i]=value;
		n++;
		
		
	}
	
	/**
	 * Add an element to the back of the string.
	 * @param value String being added
	 */
	public void push_back(String value) {
		add(n, value);
	}
	
	/**
	 * Add an element to the front of the string.
	 * @param value String being added.
	 */
	public void push_front(String value) {
		add(0, value);
	}
	
	/**
	 * Remove element i from the array (renumbering everything past it)
	 * @param i  element being removed
	 * @return   value that was removed
	 * @throws IndexOutOfBoundsException if index out of bounds
	 */
	//_____________________________FIX ME
	public String remove(int i) {
		if (i < 0 || i >= size())
			throw new IndexOutOfBoundsException();		
		String value = A[i];
		
		// TODO: Now you need to shift all the elements over and change n.
		// (Note: We are not resizing A.  Will just keep it the same size so
		// we have the space the next time we need it.)
		for(int j = i;j<size()-1;j++){
			A[j]=A[j+1];
		}
		this.n =n-1;
		return value;
	}
	
	/**
	 * Remove last element
	 * @return value of last element
	 */
	public String pop_back() {
		return remove(size()-1);
	}
	
	/**
	 * Remove first element
	 * @return value of first element
	 */
	public String pop_front() {
		return remove(0);
	}
	
	/**
	 * If the array is full (that is: A.length == n), resize it so it can hold one more element.
	 */
	//_____________________________FIX ME
	private void resize() {
		// TODO: If n < A.length, do nothing.
		// Otherwise: A needs to be resized.  This means changing the
		// A reference to a new array.  Notice that n will not change;
		// we are changing the size of A, but not the number of elements
		// being held in the container.
		if(n>=A.length){
			String [] temp = new String[n*2];
			for(int i = 0;i<n;i++){
				temp[i]=A[i];
				numOps++;
			}
			
			A=temp;
			
		}
		
		
		
	}
	
	/**
	 * Search for a query string in the array.
	 * @param query String being seqrched for
	 * @return boolean
	 */
	//_____________________________FIX ME
	public boolean in(String query) {
		// TODO: Write this method.  It should return true if any
		// element in the sequence is equal to query.  (Remember:
		// you need to use String.equals to compare, ot ==.  Make sure
		// you know why.)
		for(int i = 0; i<A.length;i++){
			if(query.equals(A[i])){
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Remove all elements.
	 */
	public void clear() {
		A = new String[1];
		n = 0;
	}
	
	/**
	 * Return True if the container is empty.
	 */
	public boolean isEmpty() {
		return n==0;
	}
}
