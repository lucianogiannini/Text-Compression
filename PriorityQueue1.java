import java.util.*;
public class PriorityQueue1<E>
{
  // inserts data into the queue in order of priority
 // so the element with highest priority (lowest number) is first
 // remove() takes the  first element from queue

 
    private class Node
    {
        E data;
        int priority;
        Node next;
        public Node()  //default constr
        {
            data = null;
            priority = 0;
            next = null;
        }
        public Node (E data,int priority) // one arg con
        {
            this.data = data;
            this.priority = priority;
            next = null;
            }
        }

        Node front;
        int size;

        public PriorityQueue1()
        {
            front = null;
            size = 0;
        }
        public void insert(E data, int priority)
        {
            // finds the proper place for x and insets there
            Node p = new Node(data, priority);

            Node q = front;
            Node r = null; // r follows q 
            while (q != null && (q.priority <= priority)) 
                // stops when a q priority is larger or exhausts the list
            {
                r = q; // behind q
                q = q.next;
            }
            if (r == null) // insert at front
            {
                p.next = front;
                front = p;
            }
            else // insert Node r into its proper place
            {
                r.next = p;
                p.next = q;
            }

            size++;
    }
   public E remove()
    {
            if (size == 0)
           {
                System.out.println("Priority Queue underflow");
                System.exit(0);
            }
           PriorityData<E> temp = new PriorityData<E>();
           temp.setData(front.data);
           temp.setPriority(front.priority);

           front = front.next;
           size--;
            return temp;

    }
}
