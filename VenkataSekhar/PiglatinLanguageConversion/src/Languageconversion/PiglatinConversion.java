package Languageconversion;

	import java.util.Arrays;
	import java.util.Scanner;

	public class PiglatinConversion {
		
		
		public static boolean isVowelpresent(char ch) { 
		    return (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || 
		            ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'); 
		} 
		  
		public static String pigLatin(String str) { 
		  
		    int indexpos = 0;
		    int punctcheck = 0;
		    String strvc = "";
		    String newstring = "";
		    int indexposition = -1;
		    String newconvstring = "";
		    Integer siz = str.length();
		    int hypCharacter = str.indexOf('-');
		  
		    // The index of the first vowel in the text is stored.
		    for (int i = 0; i < siz; i++) 
		    { 
		        if (isVowelpresent(str.charAt(i))) { 
		        indexposition = i; 
		        break; 
		    } 
		    } 
		    
		    for (int count = 0; count < siz; count++) 
		    { 
		        if (!Character.isLetter(str.charAt(count))) { 
		        punctcheck++; 
		        break; 
		    } 
		    } 
		    
		    int convlength;
		    Integer relpos = 0;
		    boolean nonwch = false;
		    String convertedString;
		    String preconvertString;
		    char punctchar = '\0';
		    Integer nonwchar = 0;
		    String outputstring="";
		    char[] a = str.toCharArray();
		   
		    // Pig Latin conversion if vowels are present 
		    if (indexposition == -1) 
		    {
		        strvc= "-1";
		        return strvc;
		    }
		    
		    char ch,f;
			String outputstr;
			outputstr = str;
			String outputmanstring = "";
			newstring=str.substring(1,str.length()) +str.substring(0,1);
			
			// Working with capitalization of words
		    if (indexposition !=0 && !str.endsWith("way") )
		    {	
		    if(hypCharacter == -1 && punctcheck == 0) 
		    {
			for(int i = 0; i < newstring.length(); i++) {
			ch = str.charAt(i);
			if (Character.isUpperCase(ch) && Character.isLetter(ch))
			{
				f=newstring.charAt(i);
				outputmanstring += Character.toUpperCase(f);
			}
			else
			{
				f=newstring.charAt(i);
				outputmanstring += Character.toLowerCase(f);
			}
			}
			outputstring = outputmanstring;
		    }
		            // Working with words which have a hyphen
		 			if(hypCharacter > 0)
		 			{
		 			    	String firststring = str.substring(0,hypCharacter);
		 			    	String secondstring = str.substring(hypCharacter+1,(str.length()));
		 			    	int size = secondstring.length();
		 			    	for (int count = 0; count < size; count++) 
		 				    { 
		 				        if (isVowelpresent(secondstring.charAt(count))) { 
		 				        indexpos = count; 
		 				        break; 
		 				    } 
		 				    }
		 			    	if(indexpos!=0 && indexposition!=0)
		 			    	{
		 			    	return firststring.substring(1,hypCharacter)+firststring.substring(0,1)+"ay"+"-"+secondstring.substring(1,size)+secondstring.substring(0,1)+"ay";
		 			    	}
		 			    	else
		 			    	{
		 			    		if(indexpos!=0 && indexposition ==0 )
			 			    	{
			 			    	return firststring.substring(indexposition)+firststring.substring(0,indexposition)+"ay"+"-"+secondstring.substring(1,size)+secondstring.substring(0,1)+"ay";
			 			    	}
		 			    		if(indexpos == 0 && indexposition!=0)
			 			    	{
			 			    	return firststring.substring(1,hypCharacter)+firststring.substring(0,1)+"ay"+"-"+secondstring.substring(indexpos)+secondstring.substring(0,indexpos)+"ay";
			 			    	}
		 			    		if(str.endsWith("way"))
			 			    	{
			 			    	return str;
			 			    	}
		 			    	}    	
		 			}
		 			// Working with punctuation characters
		 			if(punctcheck !=0)
		 			{
		 			for (char c : a) {
				        if (!Character.isLetter(c)) {
				        	nonwch=true;
				        	punctchar = c;
				            nonwchar = str.indexOf(c);
				                  
				        }
				    }
				    if(nonwch)
				    {
				    preconvertString=str.substring(0,nonwchar)+str.substring(nonwchar+1);
				    convertedString = preconvertString.substring(indexposition) +preconvertString.substring(0, indexposition) + "ay";  
				    convlength = convertedString.length();
				    relpos = convlength-nonwchar+1;
				    
				    if(punctchar!='\0')
				    {
				    return convertedString.substring(0,relpos+1)+punctchar+convertedString.substring(relpos+1);
				    }
				    }
				    }
		    
		    }
			else
			{
			// Returning the word as it is if has "way" appended at the last
			if (str.endsWith("way"))
			{
			    	return str; 	
			    	
			}
			// Adding way at the last for the words with start with a vowel
			if (indexposition == 0)
			{
				if(punctcheck !=0)
	 			{
	 			for (char cr : a) {
			        if (!Character.isLetter(cr)) {
			        	nonwch=true;
			        	punctchar = cr;
			            nonwchar = str.indexOf(cr);
			                  
			        }
			    }
			    if(nonwch)
			    {
			    preconvertString=str.substring(0,nonwchar)+str.substring(nonwchar+1);
			    convertedString = preconvertString.substring(indexposition) +preconvertString.substring(0, indexposition) + "ay";  
			    convlength = convertedString.length();
			    relpos = convlength-nonwchar+1;
			    
			    if(punctchar!='\0')
			    {
			    return convertedString.substring(0,relpos)+"way"+punctchar;
			    }
			    }
			    }    
				else
				{
			    return str+"way";
				}
			}
		    }
		    outputstring = outputstring+"ay";
		    return outputstring;
		    }
		
		public static void main (String[] args)
		{
			String text;
			String resPigLstring = " ";
			System.out.print("Enter the text input : ");
	        Scanner scanner = new Scanner(System. in);
	        // Take the input string from the user
	        String inputString = scanner. nextLine();
	        System.out.println("Text input entered is : \n"+inputString);
	        String []s = inputString.split(" ");
	        for (int inc=0;inc<s.length ;inc++)
	        {
	        text = pigLatin(s[inc]);
	        if (text != "-1") 
	        resPigLstring = resPigLstring+" "+text;
	        }
		        System.out.println("The pig latin converted text is "+resPigLstring); 
			
		}
		
		
		
}


