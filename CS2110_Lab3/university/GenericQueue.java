package university;
//package Labs.Lab3Fall2020.StudentFiles;

/**
This class tests the code for Lab2: Exercise4. It describes a simple
GenericQueue class using generics.
It expands upon a framework provided by Srini.

Alexander Gates | B00837129
*/

import java.util.ArrayList;

public class GenericQueue<T>{
    // declare all required fields
    private ArrayList<T> queue;
    private int cursor;

    /**
    Constructor 1
    No args.
    */
    public GenericQueue(){
        queue = new ArrayList<>();
        cursor = 0;
    }

    public int size() {
    	return queue.size();
    }
    
    //returns front element of queue
    public T peek() {
    	if(!this.isEmpty()) 
    		return queue.get(0);
    	else return null;
    }
    
    //removes and returns the front element of queue
    public T dequeue() {
    	if(!this.isEmpty()) 
    		return queue.remove(0);
    	else return null;
    }
    
    //adds T element to back of queue
    public void enqueue (T element) {
    	queue.add(element);
    }
    
    //returns true if queue is empty
    public boolean isEmpty() {
    	return queue.size() == 0;
    }
    
    public void clear() {
    	queue.clear();
    }
    
    public int positionOf(T item) {
    	return queue.indexOf(item);
    }
    
    public void remove(T item) {
    	queue.remove(item);
    }
    
    //returns the first element of queue and resets cursor to 0
    public T first() {
    	cursor = 0;
    	if (!queue.isEmpty())
    		return queue.get(cursor);
    	return null;
    }
    
    //iterates cursor and returns element in queue at new cursor position
    public T next() {
    	cursor++;
    	if(cursor < queue.size())
    		return(queue.get(cursor));
    	return null;
    }
    
}
