package towerofhanoi;

import java.util.EmptyStackException;

import stack.StackInterface;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
* The implementing the LinkedStack class
*
* @author Angel Ochieng
* @version 03.17.2025
*  @param <T> The type of elements stored in the stack.
*/
public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;
    private int size;
    /**
     * Initializing node and size.        
     */
    public LinkedStack() {
        this.topNode = null;
        this.size = 0;
    }
    /**
     * Clears the stack.        
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;

    }
    /**
     * checking if stack is empty
     * @return an empty stack
     */
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }
    /**
     * returns element at top of stack 
     * making no modifications
     * @return topNodes data  
     * @throws EmptyStackException if empty.      
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }
    /**
     * removes element at top of stack 
     * @return element at top  
     * @throws EmptyStackException if empty.   
     */

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T topData = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return topData;
    }
    /**
     * adds element to stack
     * @param anEntry The element to be added   
     */
    @Override
    public void push(T anEntry) {
        Node newNode = new Node(anEntry, topNode);
        newNode.setNextNode(topNode);
        topNode = newNode;
        size++;
    }
    /**
     * @return stack size       
     */
    public int size() {
        return size;
    }
    /**
     * @return elements as a string 
     * separated by commas
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node current = topNode;
        
        while (current != null) {
            builder.append(current.getData());
            if (current.getNextNode() != null) {
                builder.append(", ");
            }
            current = current.getNextNode();
        }
        builder.append("]");
        return builder.toString();
    }
    /**
     * implementing node class        
     */
    private class Node {
        private T data;
        private Node nextNode;
        /**
         * constructor for Node    
         */
        public Node(T entry, Node node) { 
            this(entry); 
            this.setNextNode(node); 
        }
        /**
         * second node constructor.        
         */
        public Node(T data) { 
            this.data = data; 
        }
        /**
         * @return data      
         */
        public T getData() {
            return data;
        }
        /**
         * @return nextNode     
         */
        public Node getNextNode() {
            return nextNode;
        }
        /**
         *sets next node
         *@param node, next node to be set   
         */
        public void setNextNode(Node node) {
            this.nextNode = node;
        }
         
        
    }

}
