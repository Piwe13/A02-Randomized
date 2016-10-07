package A02RandomizedQueuesAndDeques;

import edu.princeton.cs.introcs.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by adgardner on 10/5/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    int size = 0;

    public Deque() {

    }

    private class Node{
        Item item;
        Node next;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException("The item passed as argument cannot be null");
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            last = first;
        }else {
            first.next = oldFirst;
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException("The item passed as argument cannot be null");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
           first = last;
        }else {
            oldLast.next = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no element in this Deque");
        }
        Item item = first.item;
        first = first.next;
        size--;
        return item;

    }

    public Item removeLast() {
        if (isEmpty()) {
           throw new NoSuchElementException("There is no element in this Deque");
        }
        Item item = last.item;
        Node thisNode = first;
        if (isEmpty()) {
           throw new NoSuchElementException("There is no element in this Deque");
        }
        while (thisNode != null) {
            if (last.equals(thisNode.next)) {
                thisNode.next = null;
                last = thisNode;
                break;
            }
            thisNode = thisNode.next;
        }
        size--;
        return item;

    }

    @Override
    public Iterator<Item> iterator() {
        return new listIterator();
    }

    private class listIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This method is unsupported");
        }
    }

    public static void main(String[] args) {
        Deque<String> link = new Deque<>();
        link.addFirst("a");
        link.addFirst("bb");
        link.addFirst("ccc");
        link.addFirst("dddd");
        link.addLast("bb");
        link.addLast("ccc");
        link.addLast("dddd");
        link.removeLast();
        link.removeFirst();

        for (String el : link) {
            StdOut.println(el);
        }
    }
}
