import java.util.*;
import java.io.*;
public class HuffmanEncoding1
{
  
  public static void main(String[]args) throws IOException
  {
    File inFile = new File("Huffman.txt");
    Scanner input = new Scanner(inFile);
    String text = "";
    while (input.hasNext())
    {
      text += input.nextLine();
    }
    int [] freq = frequency(text);
    Node tree = priority(freq);
    String [] codeword = code(tree,freq);
    String encoded = encode(codeword,text);
    File freqTable = new File("Huffman.feq");
    File compressed = new File("Huffman.zip");
    PrintWriter p = new PrintWriter(freqTable);
    p.println("Letter  Frequency");
    for (int i = 0;i<128;i++)
    {
      p.println((char)i+"    "+freq[i]);
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
    return encoded;
  }
  
  public static String[] code(Node root, int [] freq)
  {
    String [] codeword = new String [128];
    for (int i = 0;i<128;i++)
    {
      if (freq[i]==0)
        codeword[i] = "";
      else
      {
        String code = "";
        Node p = root;
        Node find = new Node(i,freq[i]);
        while (find.frequency!=p.frequency)
        {
          int x = find.compareTo(p);
          code += (x+"");
          if (x==0)
            p = p.left;
          if (x==1)
            p = p.right;
        }
        codeword[i] = code;
      }
    }
    return codeword;
  }
      
  
  public static Node priority(int [] freq)
  {
    PriorityQueue q = new PriorityQueue(128);
    for (int i = 0;i<128;i++)
    {
      if (freq[i]!=0)
      {
      Node n = new Node(i,freq[i]);
      q.add(n);
      
      }
    }
    Node root = null;
    while (q.size()!=0)
    {
      Node last = (Node)q.remove();
      System.out.println(last.frequency);
      Node next = (Node)q.remove();
      System.out.println(last.frequency);
      Node parent = new Node(last.frequency + next.frequency);
      parent.right = next;
      parent.left = last;
      last.parent = parent;
      next.parent = parent;
      q.add(parent);
      root = parent;
      //System.out.println(parent.frequency);
    }
    return root;
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