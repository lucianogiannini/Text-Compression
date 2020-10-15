+-import java.io.*;
import java.util.*;
public class RealLifeCompression
{
   public static void main(String[]args)throws IOException
   {
      Scanner input = new Scanner(System.in);
     
      System.out.println("Ented Compressed File");
      String  encodedFile = input.nextLine();
      File inFile = new File(encodedFile);
      Scanner inputstream = new Scanner(inFile);
      int count = 1;
      int index = 0;
      String encoded  = inputstream.nextLine();
      int stringlength = encoded.length();
      byte [] array = new byte[stringlength/8];
      byte temp = 0;
      for(int j = 1; j <= stringlength; j++)
      {
         char b = encoded.charAt(j-1);
         if(b == '0')
         {
            temp = (byte)(temp*2 + 0);
         }
         else if(b == '1')
         {
            temp = (byte)(temp*2 + 1);
         }
         if(j%8 == 0)
         {
            array[index] = temp;
            index++;
            temp = 0;
         
         
         }
      
      }//end for loop
      System.out.println("Enter the output file name");
      String out = input.nextLine();
      FileOutputStream fos = new FileOutputStream(out);
      fos.write(array);
      fos.close();
      // while(inputstream.hasNext())
      // {
         // byte temp = 0;
         // for(int i= 1; i <= 8; i++)
         // {
            // if(inputstream.hasNext())
            // {  String a = inputstream.next();
               // if(a.equals("0"))
               // {
                  // byte b = (byte)0;
                  // temp =  (byte)(temp*2 + b);
               // }
               // if(a.equals("1"))
               // {
                  // byte b = (byte)1;
                  // temp =  (byte)(temp*2 + b);
               // }
            // // }
            // else
            // {
               // byte b = (byte)0;
               // temp =  (byte)(temp*2 + b);
            // }
         // }
         // array[count] = temp; 
         // count++;
      // }// end while
   
   }//end main
}//end class
// While there are more 0/1 characters (bytes)
// {
//     byte temp = 0;
//      for i = 1 to 8  //  This loop calculates the decimal value of 8 zeros and ones and stores it in temp.  If the number of bytes in the file is not divisible by 8, just pad the file with a few extra bytes.  
//     {
//         b = getnext_0_or_1_character();  // get the next bit (stored in a byte)
//         temp = temp* 2 + b;                    // note that b should be 0 or 1 (not the ascii value of b which would be 48 or 49)
// 
//           // Note that to do this correctly in Java, you will need to cast the expressions to bytes, since Java automatically up-casts bytes to int when doing arithmetic
//      } 
//     // store temp in a byte array
// }