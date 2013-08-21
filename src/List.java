import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Abstract Base class containing the declaration the method declarations
public abstract class List 
{
	//Returns the size of the List
	abstract int size();
	
	//Returns the element of the List having index as its position
	abstract int get(int index);
	
	//Removes the element present at the position index
	abstract void remove(int index);
	
	//Prints all the element currently present in the List and also writes them in a file
	abstract void print();
}


//Class derived from the abstract class List which implements the list using Array
class InputArray extends List
{
	//The array containing the List of elements
	int[] inputArray;
	
	//Default constructor of the class which instantiates the array to null reference
	public InputArray() 
	{
		inputArray = null;
	}
	
	//Derived constructor of the class which instantiates 
	//the array by parsing the input String
	public InputArray(String sInputList) 
	{
		//String array for storing each element after ectracting them from the input string
		String[] splitString = new String[sInputList.length()];
		
		//Gives the number of elements in the input List 
		int len = 0;
		
		//Checking the input string for presence of spaces
		for(int i=0; i < sInputList.length(); i++)
		{
			
			//Checking whether the character at the current position is a space or not
			if(sInputList.charAt(i) != ' ')
			{
				
				//Extracting each element from the string and storing them in a string array
				splitString[len] = sInputList.substring(i, sInputList.indexOf(' ', i) == -1 ? sInputList.length() : sInputList.indexOf(' ', i));
				
				//Updating the value of i
				i = sInputList.indexOf(' ', i) == -1 ? sInputList.length() : sInputList.indexOf(' ', i);
				
				//Incrementing len
				len++;
			}
		}
		
		//Instantiating the array with size equal to len
		inputArray=new int[len];
		
		//Getting the Integer value of the element which are stored as string 
		//in the string array and assigning them to the List array
		for(int i = 0; i < len; i++)
		{
			inputArray[i] = Integer.parseInt(splitString[i]);
		}
	}

	//Returns the size of the List implemented using array
	int size()
	{
		//If array is null then return -1
		if(inputArray == null)
		{
			return -1;
		}
		
		//If the array is not null then return the length of the array
		return inputArray.length;
	}

	//Returns the element of the List having index as its position 
	//from the array used for implementing the List
	int get(int index)
	{
		return inputArray[index];
	}
	
	//Removes the element present at the position index
	void remove(int index)
	{
		//Create a temporary array
		int[] temp=new int[inputArray.length-1];
		
		//Copy all the elements before the element at position index into the temporary array
		for(int i = 0; i < index; i++)
		{
			temp[i] = inputArray[i];
		}
		
		//Copy all the elements after the element at position index into the temporary array
		for(int i = index+1; i < inputArray.length; i++)
		{
			temp[i-1] = inputArray[i];
		}
		
		//Make the temporary array as the new array
		inputArray = temp;
	}

	//Prints all the element currently present in the List and also writes them in a file
	void print()
	{
		//Print the elements and also write them into a file if the array is initialized
		if(inputArray != null)
		{
			try 
			{
				//Create a file output.txt
				PrintWriter writer = new PrintWriter("output.txt");
				for(int i=0; i < inputArray.length; i++)
				{
					//Print the elements and also write them into a file
					System.out.print(inputArray[i] + " ");
					writer.print(inputArray[i] + " ");
				}
				
				//Close the file
				writer.close();
			} 
			catch (FileNotFoundException e) 
			{
				//Printing the Stack Trace if an exception has occurred
				e.printStackTrace();
			}
		}
		System.out.println();
	} 
}

//Class derived from the abstract class List which implements the list using Linked List
class InputLinkedList extends List
{
	//The reference to the head of the Linked List containing the List of elements
	Node head;

	//Default constructor of the class which instantiates the
	//head of the Linked List to null reference
	public InputLinkedList() 
	{
		head = null;
	}
	
	//Derived constructor of the class which instantiates 
	//the Linked List by parsing the input String
	public InputLinkedList(String sInputList) 
	{
		//String array for storing each element after ectracting them from the input string
		String[] splitString = new String[sInputList.length()];
		
		//Gives the number of elements in the input List 
		int len = 0;
		
		//Checking the input string for presence of spaces
		for(int i=0; i < sInputList.length(); i++)
		{
			
			//Checking whether the character at the current position is a space or not
			if(sInputList.charAt(i) != ' ')
			{
				
				//Extracting each element from the string and storing them in a string array
				splitString[len] = sInputList.substring(i, sInputList.indexOf(' ', i) == -1 ? sInputList.length() : sInputList.indexOf(' ', i));
				
				//Updating the value of i
				i = sInputList.indexOf(' ', i) == -1 ? sInputList.length() : sInputList.indexOf(' ', i);
				
				//Incrementing len
				len++;
			}
		}
		
		//Getting the reference of the head of the Linked List
		Node ref = head;
		for (int i = 0; i < len; i++)
		{
			if(i == 0)
			{
				//If it is the 1st element then create a new 
				//Node object and assign it to ref and head
				ref = new Node();
				head = ref;
			}
			
			//Create a temporary Node object
			Node temp = new Node();
			
			//Getting the Integer value of the element which are stored as string 
			//in the string array and assigning them to the value part of the temp Node
			temp.value = Integer.parseInt(splitString[i]);
			
			//Assigning the next reference of ref to temp 
			ref.next = temp;
			
			//Assigning the reference of temp to ref
			ref = temp;
		}
	}

	//Returns the size of the List implemented using Linked List
	int size()
	{
		//Get the reference of the head of the Linked list
		Node ref = head;
		
		//Initialize the counter to -1
		int count = -1;
		
		//Count the number of elements of the Linked List
		while(ref != null)
		{
			count++;
			ref = ref.next;
		}
		
		//Return the number of elements as the size of the Linked List
		return count;
	}
	
	//Returns the element of the List having index as its position 
	//from the Linked List used for implementing the List
	int get(int index)
	{
		//Get the reference of the head of the Linked list
		Node ref = head;
		
		//Initialize the counter to -1
		int count = -1;
		
		//Traverse the Linked List until the Node with position index is reached
		while(count != index)
		{
			count++;
			ref = ref.next;
		}
		
		//Return the value of the Node having position index
		return ref.value;
	}
	
	//Removes the element present at the position index
	void remove(int index)
	{
		//Get the reference of the head of the Linked list
		Node ref = head;
		
		//Initialize the counter to -1
		int count = -1;
		
		//Traverse the Linked List until the Node with position (index - 1) is reached
		while(count != index - 1)
		{
			count++;
			ref = ref.next;
		}
		
		//Assign the reference of the next Node after the Node at position index to refNext
		Node refNext = ref.next.next;
		
		//Assign the refNext as the next Node after the Node at position (index - 1) 
		ref.next = refNext;
	}

	//Prints all the element currently present in the List and also writes them in a file
	void print()
	{
		//Get the reference of the head of the Linked list
		Node ref = head;
		
		//Print the elements and also write them into a file if the head is initialized
		if(ref != null)
		{
			try 
			{
				//Create a file output.txt
				PrintWriter writer = new PrintWriter("output.txt");
				
				//Traverse till the end of the Linked List  
				while(ref != null)
				{
					ref = ref.next;
					if(ref != null)
					{
						//Print the elements and also write them into a file
						System.out.print(ref.value + " ");
						writer.print(ref.value + " ");
					}
				}
				
				//Close the file
				writer.close();
			} 
			catch (FileNotFoundException e) 
			{
				//Printing the Stack Trace if an exception has occurred
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}

//Class for each Node of the Linked List containing a value 
//and a reference to the next Node in the Linked List
class Node
{
	int value;
	Node next;
}