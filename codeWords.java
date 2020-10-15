import java.util.*;

public class codeWords
{
   private String text;
   private String temp;
   private char encoded[];
   
   public codeWords()
   {
      text = "";
      temp = "";
   }
   
   //puts string into an array of Char
   public void code1()
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter Text: ");
      text = input.next();
      
      encoded = new char[text.length()];
      
      for(int i = 0; i < text.length(); i++)
      {
         encoded[i] = text.charAt(i);
      }
      
      for(int j = 0; j < text.length(); j++)
      {
         temp = temp + encoded[j];
         //System.out.println(temp);
         
         if(temp.equals("0000"))
         {
            System.out.print("A");
            temp = "";
         }else if(temp.equals("0001"))
         {
            System.out.print("H");
            temp = "";
         }else if(temp.equals("001"))
         {
            System.out.print("-");
            temp = "";
         }else if(temp.equals("01"))
         {
            System.out.print("S");
            temp = "";
         }else if(temp.equals("10"))
         {
            System.out.print("E");
            temp = "";
         }else if(temp.equals("11"))
         {
            System.out.print("L");
            temp = "";
         } 
      }
   }
   
   public void code2()
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter Text: ");
      text = input.next();
      
      encoded = new char[text.length()];
      
      for(int i = 0; i < text.length(); i++)
      {
         encoded[i] = text.charAt(i);
      }
         
      for(int j = 0; j < text.length(); j++)
      {
         temp = temp + encoded[j];
         //System.out.println(temp);
         
         if(temp.equals("00"))
         {
            System.out.print("E");
            temp = "";
         }else if(temp.equals("01"))
         {
            System.out.print("H");
            temp = "";
         }else if(temp.equals("0"))
         {
            System.out.print("S");
            temp = "";
         }else if(temp.equals("11"))
         {
            System.out.print("-");
            temp = "";
         }else if(temp.equals("10"))
         {
            System.out.print("A");
            temp = "";
         }else if(temp.equals("1"))
         {
            System.out.print("L");
            temp = "";
         } 
      }
   }  
   public static void main(String[]args)
   {
      codeWords c = new codeWords();
      Scanner input = new Scanner(System.in);
      System.out.println("Code 1 (Enter 1) or Code 2: (Enter 0)");
      int num = input.nextInt();
      
      if(num == 1)
         c.code1();
      else 
         c.code2();
   }
}