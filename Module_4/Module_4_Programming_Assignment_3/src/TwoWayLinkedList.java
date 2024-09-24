/* Program name: TwoWayLinkedList.java
 * Authors: Kyle Ingersoll and Pearson 
 * Date last updated: 9/24/2024
 * Purpose: To create a linked list that can be transversed forwards and backwards. 
 */

import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayLinkedList<E> implements MyList<E> {
    protected Node<E> head, tail;
    protected int size = 0; // Number of elements in the list


     /** Create an empty list */
     public TwoWayLinkedList() {
    }
  
    /** Create a list from an array of objects */
    public TwoWayLinkedList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
        add(objects[i]); 
    }
  
    /** Return the head element in the list */
    public E getFirst() {
      if (size == 0) {
        return null;
      }
      else {
        return head.element;
      }
    }
  
    /** Return the last element in the list */
    public E getLast() {
      if (size == 0) {
        return null;
      }
      else {
        return tail.element;
      }
    }
  
    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        if(size > 0) {
            head.previous = newNode; // newNode is inserted before the head, since it is the first in the list
        }
        newNode.next = head; // link the new node with the head
        newNode.previous = null; // there is no node before the first one
        head = newNode; // head points to the new node
        head.previous = null; // there is no node before the first one
        size++; // Increase list size
    
        if (tail == null) // the new node is the only node in list
            tail = head;
    }
  
    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new for element e
    
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        }
        else {
            tail.next = newNode; // Make a new node for tail.next
            newNode.next = null; // There is no element after the last one
            newNode.previous = tail; // the old tail is now the element before the last
            tail = tail.next; // tail is shifted right one place
        }
    
        size++; // Increase size
    }
  
    @Override /** Add a new element at the specified index 
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
      if (index == 0) {
        addFirst(e);
      }
      else if (index >= size) {
        addLast(e);
      }
      else {
        // basically we are setting up the previous and next nodes for the added
        Node<E> current = head;
        for (int i = 1; i < index; i++) {
          current = current.next;
        }
        Node<E> temp1 = current.next;
        Node<E> temp2 = current;   
        current.next = new Node<>(e);
        (current.next).next = temp1;
        (current.next).previous = temp2;
        temp1.previous = current.next;
        temp2.next = current.next;
        size++;
      }
    }
  
    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public E removeFirst() {
      if (size == 0) {
        return null;
      }
      else {
        E temp = head.element;
        head = head.next;
        size--;
        if (head == null) {
          tail = null;
        }
        
        return temp;
      }
    }
  
    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
      if (size == 0) {
        return null;
      }
      else if (size == 1) {
        E temp = head.element;
        head = tail = null;
        size = 0;
        return temp;
      }
      else {
        Node<E> current = head;
  
        for (int i = 0; i < size - 2; i++) {
          current = current.next;
        }
  
        E temp = tail.element;
        tail = current;
        tail.next = null;
        size--;
        return temp;
      }
    }
  
    @Override /** Remove the element at the specified position in this 
     *  list. Return the element that was removed from the list. */
    public E remove(int index) {   
      if (index < 0 || index >= size) {
        return null;
      }
      else if (index == 0) {
        return removeFirst();
      }
      else if (index == size - 1) {
        return removeLast();
      }
      else {
        Node<E> current = head.next;
  
        for (int i = 1; i < index; i++) {
          current = current.next;
        }
  
        Node<E> previous = current.previous;
        previous.next = current.next;
        current.next.previous = previous;
        size--;
        return current.element;
      }
    }
  
    @Override /** Override toString() to return elements in the list */
    public String toString() {
      StringBuilder result = new StringBuilder("[");
  
      Node<E> current = head;
      for (int i = 0; i < size; i++) {
        result.append(current.element);
        current = current.next;
        if (current != null) {
          result.append(", "); // Separate two elements with a comma
        }
        else {
          result.append("]"); // Insert the closing ] in the string
        }
      }
  
      return result.toString();
    }
  
    @Override /** Clear the list */
    public void clear() {
      size = 0;
      head = tail = null;
    }
  
    @Override /** Return true if this list contains the element e */
    public boolean contains(Object e) {
        // initialize iterator
        ListIterator<E> iterator = listIterator();

        // loop across TwoWayLinkedList to find element
        for (int i = 0; i < size; i++) {
            if (((LinkedListIterator)iterator).current.element.equals(e)) {
                return true;
            }
            else {
                ((LinkedListIterator)iterator).current = ((LinkedListIterator)iterator).current.next;
            }
            
        }

        // if element is not here, return false

        return false;
    }
  
    @Override /** Return the element at the specified index */
    public E get(int index) {
        // if the index isn't in the collection, return null, else return element
        if (index < 0 || index >= size)
        {
            return null;
        }
        else {
            // initialize iterator
        ListIterator<E> iterator = listIterator(index);

        // return element
        return ((LinkedListIterator)iterator).current.element;
        }
        
    }
  
    @Override /** Return the index of the first matching element in 
     *  this list. Return -1 if no match. */
    public int indexOf(Object e) {
        // initialize iterator
        ListIterator<E> iterator = listIterator();

        // loop across TwoWayLinkedList to find element
        for (int i = 0; i < size; i++) {
            if (((LinkedListIterator)iterator).current.element.equals(e)) {
                return i;
            }
            else {
                ((LinkedListIterator)iterator).current = ((LinkedListIterator)iterator).current.next;
            }
            
        }

        // no match, so return -1
        return -1;
    }
  
    @Override /** Return the index of the last matching element in 
     *  this list. Return -1 if no match. */
    public int lastIndexOf(E e) {
       // initialize iterator
       ListIterator<E> iterator = listIterator((size - 1));

       // loop across TwoWayLinkedList to find element
       for (int i = (size - 1); i > 0; i--) {
           if (((LinkedListIterator)iterator).current.element.equals(e)) {
               return i;
           }
           else {
            ((LinkedListIterator)iterator).current = ((LinkedListIterator)iterator).current.previous;
           }
           
       }

       // no match, so return -1
       return -1;
    }
  
    @Override /** Replace the element at the specified position 
     *  in this list with the specified element. */
    public E set(int index, E e) {
       // initialize iterator
       ListIterator<E> iterator = listIterator(index);

       // set e as current element
       ((LinkedListIterator)iterator).current.element = e;
       
       // return element
       return ((LinkedListIterator)iterator).current.element;
    }

    private class LinkedListIterator 
        implements java.util.ListIterator<E> {
        private Node<E> current = head; // Current index 
        private boolean nextOrPreviousCalled = false;
      
        /* No arg constructor */
        public LinkedListIterator() {

        }

        /* Constructor with index */
        public LinkedListIterator(int index) {

            if (index < 0 || index >= size)
              throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                + size);
            
            // we go forwards throughout the list, setting up the current.nexts
            for (int nextIndex = 0; nextIndex < index; nextIndex++) {
                current = current.next;
            }
            
              
        }

        @Override
        public boolean hasNext() {
            return (current.next != null);
        }
    
        @Override
        public E next() {
            current = current.next;
            E e = current.element;
            nextOrPreviousCalled = true;
            return e;
        }

        @Override
        public E previous() {
            current = current.previous;
            E e = current.element;
            nextOrPreviousCalled = true;
            return e;
        }

        @Override
        public boolean hasPrevious() {
            return (current.previous != null);
        }
    
        @Override
        public void remove() {
            if (nextOrPreviousCalled == true)
            {
                // we set the pointers so that they bypass the current element, and then we set element to null
                current.previous.next = current.next;
                current.next.previous = current.previous;
                current = null;

                // we then set nextOrPreviousCalled to false, since remove can only be called once per Next or Previous operation
                nextOrPreviousCalled = false;

                // then we decrease size
                size--;

            }
            else {
                System.out.println("Next or Previous have to be called before this operation and Add cannot be called directly before this operation.");
            }
            
        }

        @Override
        public void add(E e) {
            // initialize new node
            Node<E> newNode = new Node<>(e);

            // link new node right before current node
            newNode.previous = current.previous.previous;
            newNode.next = current;
            current.previous = null;

            nextOrPreviousCalled = false;
            size++;
        }

        @Override
        public int nextIndex() {
            System.out.println("Implementation left as an exercise");
            return 0;
        }
    
        @Override
        public int previousIndex() {
            // return -1 if the index is at the beginning of the list
            if (current == head) {
                return -1;
            }

            E previousIndexElement = current.previous.element;


            for (int i = 0; i < size; i++) {
                // check memory location to see if previousIndexElement is the same as current element
                if (previousIndexElement == current.element) {
                    return i;
                }
                current = current.next;
            }

            // return an error code if previous index was not found 
            return -2;

        }
    
        @Override
        public void set(E e) {
            if (nextOrPreviousCalled == true) {
                current.element = e;
                nextOrPreviousCalled = false;
            }
            else {
                System.out.println("Next or Previous have to be called before this method, and remove or add cannot be directly before it.");
            }
             
        }
    }

    public class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e) {
            element = e;
        }
    }

    @Override /** Return the number of elements in this list */
    public int size() {
      return size;
    }

    ListIterator<E> listIterator() {
        return new LinkedListIterator(); 
    }

    ListIterator<E> listIterator(int index) {
        return new LinkedListIterator(index);

    }
    @Override
    public Iterator<E> iterator() {
        // return the same thing as listIterator, since we are still iterating over a linked list
        return new LinkedListIterator();
    }

    
}
