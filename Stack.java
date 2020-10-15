import java.util.*;

class Stack<E>

{

   private class Node
   
   {
   
      private E data;
   
      private Node next;
   
      public Node()
      
      {
      
         data = null;
      
         next = null;
      
      }
   
      public Node(E x)
      
      {
      
         data = x;
      
         next = null;
      
      }
   
   }

   Node top;

   int stackSize;

   public Stack()   // default constructor; creates an empty stack
   
   {
   
      top = null;
   
      stackSize = 0;
   
   }

   public void push(E x)
   
   {
   
      Node p = new Node(x);
   
      p.next = top;
   
      top = p;
   
      stackSize++;
   
   }

   public E pop()
   
   {
   
      if (stackSize == 0)
      
      {
      
         System.out.println("Stack Underflow");
      
         System.exit(0);
      
      }
   
      E topItem = top.data;
   
      top = top.next;
   
      stackSize--;
   
      return topItem;
   
   }

   public E peek()
   
   {
   
      if (stackSize == 0)
      
      {
      
         System.out.println("Stack Underflow");
      
         System.exit(0);
      
      }
   
      E topItem = top.data;
   
      return topItem;
   
   }

   public boolean empty()
   
   {
   
      return stackSize == 0;
   
   }

   public int size()
   
   {
   
      return stackSize;
   
   }

}