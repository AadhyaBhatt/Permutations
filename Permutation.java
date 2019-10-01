/**
 * 
 */

/*
File Name: Permutation.java
Author: Aadhya Bhatt
Date: 25-Jan-2019 12:49:37 PM
Description:
*/



import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Permutation
 {
static char[] op=new char[6];
static char[] plain_text=new char[6];
static int m=6;
static int[] array= {0,1,2,3,4,5};
static int [] key;
static String cp;

static int[] shuffle(int[] array)
{
  Random rnd = ThreadLocalRandom.current();
  for (int i =0; i<array.length; i++)
  {
    int index = rnd.nextInt(i + 1);
    // We have performed basic swap operation
    int a = array[index];
   array[index] = array[i];
   array[i] = a;
  }
  return array;
}

public static String encrypt(String plainText, int [] key )
{
String[] g=plainText.split("(?<=\\G.{6})");
int blkNo= g.length;
String last= g[blkNo-1];
if (last.length()< 6)
{
	for(int i=last.length();i<6;i++)
	{
		last += '$';
	}
}

g[blkNo-1]=last;
String c="" ;


for(int i=0;i <g.length;i++)
{   
	String blk= g[i].toString();
	char [] b= blk.toCharArray();
	int j,k;
	for(j=0,k=0;j<blk.length()&&k<key.length;j++,k++)
	{
		
		int position= key[k];
		op[position]=b[j];
	}	
	
    for(int e=0;e<op.length;e++)
    {
    	c +=op[e];
    	
    }
	for (int l=0; l<op.length;l++)
	{
		System.out.print(op[l]);
	}
	}	
return c;
}


public static void decrypt(String cipherText, int [] key )
{

     
     String[] g=cipherText.split("(?<=\\G.{6})");


for(int c=0;c <g.length;c++)
{   
	
	String blk= g[c].toString();
	char [] b= blk.toCharArray();
	int m,k;
	for(m=0,k=0;m<blk.length() && k<key.length;m++,k++)
	{
		
		int position= key[k];
		plain_text[position]=b[m];
	}
	for (int i=0; i<plain_text.length;i++)
	{
		System.out.print(plain_text[i]);
	}
	}
	
}


public static int[] inverse_key(int [] key)
{
	int [] iv=new int[6]; 
	int position;
for(int i=0,j=0; i<key.length && j<key.length;i++,j++)
	{
	 
	position = key[i];
    iv [position]= j;
   
     
}
System.out.println("\nTHE INVERSE OF KEY IS:" );
for (int l = 0; l < iv.length; l++)
{
  System.out.print(iv[l]+" ");
}
return iv;
}

public static void main(String args[])
{
	key= shuffle(array);
	System.out.println("THE VALUE OF KEY :" );
    for (int i = 0; i < key.length; i++)
    {
      System.out.print(key[i]+" ");
    }
    System.out.println();
	String s;
	
    Scanner sc= new Scanner(System.in);
                System.out.println("\nPLEASE ENTER PLAIN TEXT");
                s = sc.nextLine();
                System.out.println("ENCRYPTED TEXT IS:");
                String c= encrypt(s, key);
                
                
                System.out.println("\nTHE CIPHER IS AS FOLLOWS: " + c);
                int[] key2;
                key2 =inverse_key(key);
            	System.out.println("\nDECRYPTED TEXT IS: ");
                decrypt(c, key2);
             
          sc.close(); 
        }
    }