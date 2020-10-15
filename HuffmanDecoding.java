import java.util.*;
import java.io.*;
public class HuffmanDecoding
{
   private static int size;
   static Node root = null;
  
   public static void main(String[]args) throws IOException
   {
      Scanner user = new Scanner(System.in);
      System.out.println("Compressed file name:");
      String compressedfile = user.nextLine();
      System.out.println("Output Text file name:");
      String textfile = user.nextLine();
      System.out.println("Frequency file name:");
      String freqfile = user.nextLine();
      File inFile = new File(freqfile);
      Scanner inputstream = new Scanner(inFile);
      int [] freq = new int[128];
      inputstream.nextLine();
      int  counter = 0;
      
      while(inputstream.hasNext())
      {
         String s = inputstream.nextLine();
         int z = Integer.parseInt(s);
         freq[counter] = z;
         counter++;
      }// end while
      
      Node tree = priority(freq);
      String code = "";
      String [] codeword = new String[128];
      code(tree,code,codeword);
      File zipfile = new File(compressedfile);
      Scanner input = new Scanner(zipfile);
      String encoded = input.nextLine();
      String letter ="";
      File textfiles = new File(textfile);
      PrintWriter p = new PrintWriter(textfiles);
      for(int i = 0; i < encoded.length(); i++)
      {
         letter = letter + encoded.charAt(i);
         for(int j = 0; j < 128; j++)
         {
            if(letter.equals(codeword[j]))
            {
               System.out.print((char)j);
               p.print((char)j);
               letter = "";
            }//end if
         }//end inside forloop
      }//end outside for loop
      p.close();
      System.out.println();
   }//end main
   
   
   
   public static void code(Node r, String code, String [] codeword)
   {
      if (r!=null)
      {
         if (r.data!=0)
         {
            codeword[r.data] = code;
         }
         code(r.left, code+'0',codeword);
         code(r.right, code+'1',codeword);
      }
   } 
   
   
   public static void insert(Node p)
   {
      size++;
      Node r = root;
      if (r==null)
      {
         root = p;
         return;
      }
      Node q = null;
      while (r!=null&&r.frequency<=p.frequency)
      {
         q = r;
         r = r.next;
      }
      if (q == null)
      {
         root = p;
         p.next = r;
      }
      else if (r != null)
      {
         q.next = p;
         p.next = r;
      }
      else
         q.next = p;
   }
  
   public static Node remove()
   {
      Node temp = root;
      root = root.next;
      size--;
      return temp;
   }
  
   public static Node priority(int [] freq)
   {
      for (int i = 0;i<128;i++)
      {
         if (freq[i]!=0)
         {
            Node g = new Node(i,freq[i]);
            insert(g);
         }
      }
      Node r = null;
      while (size!=1)
      {
         Node last = remove();
         Node last2 = remove();
         Node parent = new Node(0,last.frequency + last2.frequency);
         parent.left = last;
         parent.right = last2;
         insert(parent);
      }
      r = remove();
      return r;
   }
  
   public static int[] frequency(String text)
   {
      int [] freq = new int [128];
      for (int j = 0;j<text.length();j++)
      {
         char x = text.charAt(j);
         for (int i = 0;i<128;i++)
         {
            if (x == i)
               freq[i]++;
         }
      }
      return freq;
   }
    
}//end class
    
