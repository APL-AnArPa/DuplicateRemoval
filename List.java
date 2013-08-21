import java.io.FileNotFoundException;
import java.io.PrintWriter;


public abstract class List 
{
	abstract int size();
	abstract int get(int index);
	abstract void remove(int index);
	abstract void print();
}

class InputArray extends List
{
	int[] inputArray;
	
	public InputArray() 
	{
		inputArray = null;
	}
	
	public InputArray(String sInputList) 
	{
		String[] splitString = new String[sInputList.length()];
		int len = 0;
		for(int i=0; i < sInputList.length(); i++)
		{
			if(sInputList.charAt(i) != ' ')
			{
				splitString[len] = sInputList.substring(i, sInputList.indexOf(' ', i) == -1 ? sInputList.length() : sInputList.indexOf(' ', i));
				i = sInputList.indexOf(' ', i) == -1 ? sInputList.length() : sInputList.indexOf(' ', i);
				len++;
			}
		}
		inputArray=new int[len];
		for(int i = 0; i < len; i++)
		{
			inputArray[i] = Integer.parseInt(splitString[i]);
		}
	}

	int size()
	{
		if(inputArray == null)
		{
			return -1;
		}
		return inputArray.length;
	}
	
	int get(int index)
	{
		return inputArray[index];
	}
	
	void remove(int index)
	{
		int[] temp=new int[inputArray.length-1];
		for(int i = 0; i < index; i++)
		{
			temp[i] = inputArray[i];
		}
		for(int i = index+1; i < inputArray.length; i++)
		{
			temp[i-1] = inputArray[i];
		}
		inputArray = temp;
	}

	void print()
	{
		if(inputArray != null)
		{
			try 
			{
				PrintWriter writer = new PrintWriter("output.txt");
				for(int i=0; i < inputArray.length; i++)
				{
					System.out.print(inputArray[i] + " ");
					writer.print(inputArray[i] + " ");
				}
				writer.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println();
	} 
}

class InputLinkedList extends List
{
	Node head;
	
	public InputLinkedList(String sInputList) 
	{
		String[] splitString = new String[sInputList.length()];
		int len = 0;
		for(int i=0; i < sInputList.length(); i++)
		{
			if(sInputList.charAt(i) != ' ')
			{
				splitString[len] = sInputList.substring(i, sInputList.indexOf(' ', i) == -1 ? sInputList.length() : sInputList.indexOf(' ', i));
				i = sInputList.indexOf(' ', i) == -1 ? sInputList.length() : sInputList.indexOf(' ', i);
				len++;
			}
		}
		Node ref = head;
		for (int i = 0; i < len; i++)
		{
			if(i == 0)
			{
				ref = new Node();
				head = ref;
			}
			Node temp = new Node();
			temp.value = Integer.parseInt(splitString[i]);
			ref.next = temp;
			ref = temp;
		}
	}
	
	public InputLinkedList() 
	{
		head = null;
	}

	int size()
	{
		Node ref = head;
		int count = -1;
		while(ref != null)
		{
			count++;
			ref = ref.next;
		}
		return count;
	}
	
	int get(int index)
	{
		Node ref = head;
		int count = -1;
		while(count != index)
		{
			count++;
			ref = ref.next;
		}
		return ref.value;
	}
	

	void remove(int index)
	{
		Node ref = head;
		int count = -1;
		while(count != index - 1)
		{
			count++;
			ref = ref.next;
		}
		Node refNext = ref.next.next;
		ref.next = refNext;
	}


	void print()
	{
		Node ref = head;
		if(ref != null)
		{
			try 
			{
				PrintWriter writer = new PrintWriter("output.txt");
				while(ref != null)
				{
					ref = ref.next;
					if(ref != null)
					{
						System.out.print(ref.value + " ");
						writer.print(ref.value + " ");
					}
				}				
				writer.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}

class Node
{
	int value;
	Node next;
}