package university;
//package Labs.Lab3Fall2020.StudentFiles;

import java.util.ArrayList;

/**
 * basic stack example
 * References: https://en.wikipedia.org/wiki/Stack_(abstract_data_type), Class notes
 * @param <T>
 * Alexander Gates | B00837129
 */
public class GenericStack<T> {

    private ArrayList<T> storage;

    public GenericStack(){

        storage = new ArrayList<T>();
    }

    public int size() {
    	return storage.size();
    }
    
    public T peek() {
    	if(!this.isEmpty()) 
    		return storage.get(storage.size()-1);
    	else return null;
    }
    
    public T pop() {
    	if(!this.isEmpty()) 
    		return storage.remove(storage.size()-1);
    	else return null;
    }
    
    public void push(T element) {
    	storage.add(element);
    }
    
    public boolean isEmpty() {
    	return storage.size() == 0;
    }
}
