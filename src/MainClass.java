import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;


public class MainClass 
{
	public static void main(String[] args) 
	{	 
		try
		{
			//Printing the menu
			System.out.println("Removal of Duplicate numbers from a List");
			System.out.println("1. Array Implementation");
			System.out.println("2. Linked List Implementation");
			System.out.println("Enter an option: ");
			
			//Taking the input from the Input Buffer for the option			
			BufferedReader bufferReadOption = new BufferedReader(new InputStreamReader(System.in));
		    String sOption = bufferReadOption.readLine();
		    bufferReadOption.close();
		    
		    //Exiting the program if option is neither 1 nor 2
		    if(!sOption.equals("1") && !sOption.equals("2"))
		    {
		    	System.out.println("Exiting Program...");
		    	System.exit(0);
		    }
		    
		    //Taking the Input file name from the command line
	        String fileName = args[0];
	        
	        //Reading the first line of the Input file
	        FileReader fileReader = new FileReader(fileName);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String sInputList = bufferedReader.readLine();
	        bufferedReader.close();
	        
	        //Printing the list of numbers given as input
	        System.out.println(sInputList);
	        
	        //Reference variable of type List
			List inputList;
			
			//Instantiating the List type reference variable
			if(sInputList == null)
			{
				
				if(sOption.equals("1"))
				{
					//Implementation using Array
					inputList=new InputArray();
				}
				else
				{
					//Implementation using Linked List
					inputList=new InputLinkedList();
				}
			}
			else
			{
				if(sOption.equals("1"))
				{
					//Implementation using Array
					inputList=new InputArray(sInputList);
				}
				else
				{
					//Implementation using Linked List
					inputList=new InputLinkedList(sInputList);
				}
			}
			
			//Calling the RemDep method to remove the duplicates from the List
			inputList = RemDep(inputList);
			
			//Printing the List after removing the 
			//duplicate and also writing in file
			inputList.print();
		}
		catch(Exception e)
		{
			//Printing the Stack Trace if an exception has occurred
			e.printStackTrace();
		}
	}
	

/////////////////////////////////////////////////////////
//	Static Method for removing duplicates from a List  //	
//	Input: A List with duplicate elements              //
//	Output: The List after removal of the duplicates   //
/////////////////////////////////////////////////////////
	
	static List RemDep(List inputList)
	{
		//The index of the element in the list which is checked for possible duplicates
		int index;
		
		//The index of the element in the List which is being compared currently
		int compareIndex;
		
		//Scanning the List for duplicates starting from index 0 till (size of List - 2)
		for (index = 0; index < inputList.size() - 1; index++)
		{
			
			//Comparing index element with all the remaining 
			//elements from (index + 1) till (size of List - 1)
			for (compareIndex = index + 1; compareIndex < inputList.size(); compareIndex++)
			{
				
				//Comparing index element with compareIndex element
				if(inputList.get(index) == inputList.get(compareIndex))
				{
					//Remove duplicate element at compareIndex
					inputList.remove(compareIndex);
					
					//Point to the previous element
					compareIndex--;
				}
			}
		}
		
		//Return the List after removing all the duplicate elements
		return inputList;
	}

}
