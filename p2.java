/*
  Federico Rubino
  frubino
  federico.rubino8@gmail.com
  main
  Assignment #2
  working/ tested
*/

import java.util.Scanner;

public class p2 {

    public static void main(String args[]){
	int MAXCAPPACITY = 2400000;   
	intMinHeap heap = new intMinHeap(MAXCAPPACITY);
	Scanner input = new Scanner(System.in);
	int tempInt;
	while(input.hasNextInt()){
	    tempInt = input.nextInt();
	    if(tempInt > 0){
		if(heap.heapinsert(tempInt)){
		    System.out.printf("insert: %d%n", tempInt);
		}
	    }
	    else if(tempInt == 0){
		System.out.printf("heap size %d: %s%n", heap.getSize(), heap.toString());
	    } else if(tempInt == -1){
		System.out.printf("extract min: %d%n", heap.extractMin());
	    } else if(tempInt == -2){
		System.out.printf("sorted array: %s%n",heap.sortToString(heap.heapsort()));
	    }
	}
	input.close();
    }
}//end of main

