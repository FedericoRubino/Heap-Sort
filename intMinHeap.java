/*
  Federico Rubino
  frubino
  federico.rubino8@gmail.com
  intMinHeap class
  Assignment #2
  working/ tested
*/

import java.lang.StringBuilder;

//class that builds and manipulates a heap
class intMinHeap{

    //constructor
    public intMinHeap(int capacity){ 
	A = new int[capacity]; 
	size = 0;
	this.capacity = capacity; 
    }

    //sorts the members of the heap
    public int[] heapsort(){ 
	int copySize = size; //preserve size
	int sortedA[] = new int[copySize];
	int[] tempA = A; // preserve original A
	for(int i = 0; i < size; i++){
	    sortedA[i] = A[i];
	} //makes a copy of current array, but at the exact size
	A = sortedA;
	for(int i = size - 1; i > 0; i--) {
	    swap(i, 0);
	    size--;
	    heapify(0);
	}
	sortedA = A;
	A = tempA; // regain original A
	size = copySize; //regain original size
	return sortedA;
    }

    //toString soley for the sorted version!
    public String sortToString(int[] sortedArray){
	StringBuilder heapString = new StringBuilder();
	heapString.append("[");
	for(int i = 0; i < size ; i++){
	    heapString.append(sortedArray[i]);
	    heapString.append(", ");
	} 
	if(size != 0){
	    heapString.delete(heapString.length() -2, heapString.length());
	}
	heapString.append("]");
	return heapString.toString();
    }

    //this is the generic toString
    public String toString(){ 
	StringBuilder heapString = new StringBuilder();
	for(int i = 0; i < size ; i++){
	    heapString.append(A[i]);
	    heapString.append(", ");
	} 
	if(size != 0){
	    heapString.delete(heapString.length() -2, heapString.length());
	}
	return heapString.toString();
    }

    //inserts an integer into the heap in the correct place
    public boolean heapinsert(int k){
	if(isFull()){ return false;}
	size++;
	A[size - 1] = k + 1;
	decreaseKey(size - 1, k);
	return true;
    }  

    //returns the root
    public int minimum(){
	if(size > 0) return A[0];
	else {return 0;}
    }
    
    //returns the root and removes it from the heap
    public int extractMin(){
	if(size > 0){
	    int min = A[0];
	    A[0] = A[size - 1];
	    size--;
	    heapify(0);
	    return min;
	} else {
	    return 0;
	}
    }

    //decreases the key of a variable in the heap
    public void decreaseKey(int i, int k){ 
	if( i < 0 || i > size){
	    return;
	} else{
	    if(A[i] > k){
		A[i] = k;
		while(i > 0 && A[parent(i)] > A[i]){
		    swap(i, parent(i));
		    i = parent(i);		    
		}//while
	    }//if
	}//else
    }//method

    public boolean isEmpty(){ return size <= 0; }

    public int getSize(){ return size; }

    public boolean isFull(){ return size >= capacity; }

    private void buildheap(){ 
	for(int i = (size-2)/2; i > 0; i--){
	    heapify(i);
	}
    }

    //method that returns the smallest value of three members
    private int minOf3(int i, int left, int right){
	if(left >= size){
	    return i;
	} else if (right >= size){
	    if(A[i] <= A[left]){
		return i;
	    } else {
		return left;
	    }
	} else {
	    if (A[i] <= A[left] && A[i] <= A[right]){
		return i;
	    } else if (A[left] <= A[i] && A[left] <= A[right]){
		return left;
	    } else {
		return right;
	    }
	}// end of else
    }

    //swaps two members of the array
    private void swap(int i, int n){
	int temp = A[i];
	A[i] = A[n];
	A[n] = temp;
    }

    private int left(int n){ return (2 * n + 1);}

    private int right(int n){ return (2 * n + 2);}

    private int parent(int n){ return ((n - 1) / 2);}

    //the coolest function of the heap!
    private void heapify(int i){
	int n = minOf3(i, left(i), right(i));
	if(n != i){
	    swap(i, n);
	    heapify(n);
	}
    }   

    private int [] A; // our heap!
    private int capacity; // size of array A
    private int size; // size of data in array A
}
