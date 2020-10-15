import java.util.*;
public class PriorityQueueHuffman<E>
{
  // inserts data into the queue in order of priority
 // so the element with highest priority (lowest number) is first
 // remove() takes the  first element from queue

 
    public class Node implements Comparable<Node> 
{
    Node left;
    Node right;
    Node next;
    int data;
    int frequency;

    public Node() 
    {
        left = null;
        right = null;
        next = null;
        data = 0;
        frequency = 0;
    }
public Node(int frequency)
{
this.frequency = frequency;
data  = 0;

}
    public Node(int data, int frequency) 
    {
        this.data = data;
        this.frequency = frequency;
        left = null;
        right = null;
        next = null;
    }

    public int compareTo(Node n) 
    {
        if (frequency < n.frequency) 
        {
            return 0;
        }
        else if(frequency > n.frequency) 
        {
            return 1;
        }
        return -1;
    }
}
        Node front;
        int size;

        public PriorityQueueHuffman()
        {
            front = null;
            size = 0;
        }
        public void insert(int data, int frequency)
        {
            // finds the proper place for x and insets there
            Node p = new Node(data, frequency);

            Node q = front;
            Node r = null; // r follows q 
            while (q != null && (q.frequency <= frequency)) 
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
    public int size()
    {
    
    return size;
    }
   public Node remove()
    {
            if (size == 0)
           {
                System.out.println("Priority Queue underflow");
                System.exit(0);
            }
         //  PriorityData<E> temp = new PriorityData<E>();
           //temp.setData(front.data);
           //temp.setPriority(front.frequency);
           Node temp = front;
           front = front.next;
           size--;
            return temp;

    }
}
