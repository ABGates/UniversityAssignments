package university;

import java.util.ArrayList;

/**
 * A class which stores items with unique identifiers
 * @param <T> is the item that is stored
 * @param <U> is the identifier of the item stored
 * @author Alexander Gates | B00837129
 * CSCI2110 Assignment 2 | October 3rd, 2020
 */
public class StorageBin<T,U> {

    private ArrayList<T> itemsStored;
    private ArrayList<U> itemIDs;

    public StorageBin(){
    	itemsStored = new ArrayList<T>();
    	itemIDs = new ArrayList<U>();
    }
    
    public int sizeOfBin() {
    	return itemsStored.size();
    }
    
    /* @param item = item name to add
     * @param id = unique id of item to be added
     * throws an error if item id is not unique */
    public void addItem(T item, U id) {
    	if (itemIDs.contains(id))
    		System.out.println("Error: an item with that ID already exists");
    	else {
    		itemsStored.add(item);
    		itemIDs.add(id);
    	}
    }
    
    /* @param id = id of item being removed
     * @return T = item that as been removed
     * method removes id & item from bin based on given id */
    public T removeItem(U id) {
    	T returnItem = itemsStored.remove(itemIDs.indexOf(id));
    	itemIDs.remove(itemIDs.indexOf(id));
    	return returnItem;
    }
    
    //Displays items in form Item:[Name] ID:[id]
    public void displayItems() {
    	for(int i=0; i<itemsStored.size(); i++) {
    		System.out.println("Item:" + itemsStored.get(i) + " ID:" + itemIDs.get(i) );
    	}
    	System.out.println("");
    }
}
