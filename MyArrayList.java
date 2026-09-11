import java.util.*;

@SuppressWarnings("unchecked")

public class MyArrayList<E> implements MyList<E> {
    
    public static final int INITIAL_CAPACITY = 5;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];
    private int size = 0;

    //Constructor:  Create a default list 
    public MyArrayList() { }

    //Constructor: Create a list from an array of objects  
    public MyArrayList(E[] objects) {
       for (int i = 0; i < objects.length; i++)
           add(objects[i]); // Warning: don't use super(objects)!
    }

    /** Create a new larger array, double the current size + 1 */
    //PRE: none (this is a helper method)
    //POST: checks if the size of the array is at capacity
    //      if so, it doubles the size of the array & copies data to new array   
    private void ensureCapacity() {
        //if the current size exceeds the data size
        if (size >= data.length) {
            E[] newData = (E[])(new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
    
    //verify the index (helper method)
    //PRE: none
    //POST:throw out of bounds if index is invalid 
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                ("index " + index + " out of bounds");
    }

    @Override 
    //Add a new element at the specified index   
    //PRE: Accepts the index & value to add
    //POST:Verify the index is valid, if not, throw exception
    //     use ensureCapacity to add additional space if there is not enough capacity in the array
    //     shift elements in array to the right following the location
    //     add data item at the index position
    //     increase size    
    public void add(int index, E e) {
        System.out.println("Need to write: add");

    }

    @Override
    //PRE: Accepts a list of items 'c'
    //POST Adds all the elements in the collection c 
    //     returns true if data was updated 

    public boolean addAll(Collection<? extends E> c) {
        System.out.println("Need to write: addAll");
        return false;
    }


    @Override 
    //Clear the list
    //PRE: none
    //POST:allocate an empty array of objects
    //     sets size to 0
    public void clear() {
        data = (E[])new Object[INITIAL_CAPACITY];
        size = 0;
    }


    @Override 
    //Return true if this list contains the element 
    //PRE: accepts the object
    //POST:checks data elements if found, returns true
    //     else returns false
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++)
            if (e.equals(data[i])) return true;

        return false;
    }

    @Override
    //Returns true if the collection contains all the elements in c.
    //PRE: accepts a generic collection of objects
    //POST:if these are the same, return true
    //     else returm false  
    public boolean containsAll(Collection<?> c) {
        System.out.println("Need to write: containsAll");
        return false;
    }

    @Override  
    //Retrieve the element at the index position
    //PRE: accepts the index
    //POST:verify the index & throw out of bounds if invalid
    //     return the element 
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override 
    //Abstract Method: Return the index of the first matching object or -1 if not found
    //PRE: accepts an object
    //POST:returns the index if found or -1 if not 
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++)
           if (e.equals(data[i])) return i;

        return -1;
    }

    @Override  
    //Returns the last index of the matching object or -1 if not found
    //PRE: accepts an object
    //POST:returns the last index if found or -1 if not 
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--)
        if (e.equals(data[i])) return i;

        return -1;
    }

    @Override 
    //Remove the element at the specified position in this list
    //PRE: accepts the index value
    //POST:verifies the value (will throw an exception if invalid)
    //     shift any subsequent elements to the left of the index
    //     Return the element that was removed from the list.  
    //     decrement size
    public E remove(int index) {
        System.out.println("Need to write: remove");
        return null;
    }

    @Override
    //Removes all the elements in c from this collection.
    //PRE: Accepts a list of items 'c'
    //POST Adds all the elements in the collection c 
    //     returns true if data was updated 
    public boolean removeAll(Collection<?> c) {
        System.out.println("Need to write: removeAll");
        return false;
    }

    @Override
    //Retains the elements that are both in c and in this collection.
    public boolean retainAll(Collection<?> c) {
        // not implementing at this time
        return false;
    }

    @Override 
    //Replace the element at the specified position with new element
    //PRE: accepts the index value & new element
    //POST:verifies the value (will throw an exception if invalid)
    //     saves old value at the index
    //     sets index value to new element  
    //     returns element
    public E set(int index, E e) {
        System.out.println("Need to write: set");
        return null;
    }
    
    @Override
    //get the size of the array
    //PRE: none
    //POST:return the size of the array
    public int size(){
        return size;
    }

    @Override
    //Returns an array of Object for the elements in this collection.
    //PRE: none
    //POST: creates an array of objects, 
    //      copies elements from array to new array & returns new array
    public Object[] toArray() {
        System.out.println("Need to write: toArray");
        return null;
    } 

    @Override
    public <T> T[] toArray(T[] array) {
        // not implementing at this time
        return null;
    }

    @Override
    //Create a string that holds values in the array
    //PRE: none
    //POST:creates a string with array values & returns string
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }

        return result.toString() + "]";
    }

    //Trims the capacity to current size 
    //PRE: none
    //POST:cuts the array to the number of elements in the array (size)
    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[])(new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        } // If size == capacity, no need to trim
    }
    
    @Override 
    //Override iterator() defined in Iterable 
    //PRE: none
    //POST return a new array list iterator
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E> {
        private int current = 0; // Current index

        @Override
        public boolean hasNext() {
            return (current < size);
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }

}