public class Node implements Comparable<Node> 
{
    Node left;
    Node right;
    Node next;
    int data;
    int frequency;

    public Node(int x, int y) 
    {
      left = right = next = null;
        data = x;
        frequency = y;
    }

    public Node(int y) 
    {
      left = right = next = null;
        data = 0;
        frequency = y;
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
    
      public static void inorder(Node root) // helper

      {
         if( root != null)
         {

            inorder (root.left);
            System.out.println(root.data);
            inorder(root.right);
         }
      }
}