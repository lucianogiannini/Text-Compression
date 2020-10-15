import java.util.*;
import java.io.*;
public class HuffmanEncodingForRealLifeCompression
{
   
   private static int size;
   private static Node root = null;
   
   public static void main(String[]args) throws IOException
   {
      Scanner user = new Scanner(System.in);
      System.out.println("Input file name:");
      String inputfile = user.nextLine();
      System.out.println("Output file name:");
      String outputfile = user.nextLine();
      System.out.println("Frequency file name:");
      String freqfile = user.nextLine();
      File inFile = new File(inputfile);
      Scanner input = new Scanner(inFile);
      String text = "";
      while (input.hasNext())
      {
         text += input.nextLine();
      }
      int [] freq = frequency(text);//need these two, to decode the message
      Node tree = priority(freq);//here
      String [] codeword = new String[128];
      String code = "";
      code(tree,code,codeword);
      String encoded = encode(codeword,text);
      File freqTable = new File(freqfile);
      File compressed = new File(outputfile);
      PrintWriter p = new PrintWriter(freqTable);
      p.println("Letter  Frequency");
      for (int i = 0;i<128;i++)
      {
         if(i>31)
         {
            p.println(freq[i]);
         }
         else
         {
            p.println(freq[i]);
         }
      }
      p.close();
      PrintWriter pw = new PrintWriter(compressed);
      pw.println(encoded);
      pw.close();
   }
   
   public static String encode(String [] codeword, String text)
   {
      String encoded = "";
      for (int i = 0;i<text.length();i++)
      {
         char x = text.charAt(i);
         for (int j = 0;j<128;j++)
         {
            if (x == j)
               encoded += codeword[j];
         }
      }
      System.out.println(encoded);
      return encoded;
   }
   
   public static void code(Node r, String code, String [] codeword)
   {
      if (r!=null)
      {
         if (r.data!=0)
         {
            codeword[r.data] = code;
          //System.out.println(r.data);
          //System.out.println(code);
         }
         //if (r.left.data == 0)
         code(r.left, code+'0',codeword);
         //if (r.right.data == 0)
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
      //System.out.println(p.frequency);
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
}