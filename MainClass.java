import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;


public class MainClass 
{
	public static void main(String[] args) 
	{	 
		try
		{
			System.out.println("Removal of Duplicate numbers from a List");
			System.out.println("1. Array Implementation");
			System.out.println("2. Linked List Implementation");
			System.out.println("Enter an option: ");
			BufferedReader bufferReadOption = new BufferedReader(new InputStreamReader(System.in));
		    String sOption = bufferReadOption.readLine();
		    bufferReadOption.close();
		    if(!sOption.equals("1") && !sOption.equals("2"))
		    {
		    	System.out.println("Exiting Program...");
		    	System.exit(0);
		    }
	        String fileName = args[0];
	        FileReader fileReader = new FileReader(fileName);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String sInputList = bufferedReader.readLine();
	        bufferedReader.close();
	        System.out.println(sInputList);
	        bufferedReader.close();
			List inputList;
			if(sInputList.isEmpty())
			{
				if(sOption.equals("1"))
				{
					inputList=new InputArray();
				}
				else
				{
					inputList=new InputLinkedList();
				}
			}
			else
			{
				if(sOption.equals("1"))
				{
					inputList=new InputArray(sInputList);
				}
				else
				{
					inputList=new InputLinkedList(sInputList);
				}
			}
			inputList = RemDep(inputList);
			inputList.print();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static List RemDep(List inputList)
	{
		int index;
		int compareIndex;
		for (index = 0; index < inputList.size() - 1; index++)
		{
			for (compareIndex = index + 1; compareIndex < inputList.size(); compareIndex++)
			{
				if(inputList.get(index) == inputList.get(compareIndex))
				{
					inputList.remove(compareIndex);
					compareIndex--;
				}
			}
		}
		return inputList;
	}

}
