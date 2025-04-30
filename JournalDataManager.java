import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JournalDataManager 
{
	public static ArrayList<JournalEntry> readFromFile(String filename) 
	{
		ArrayList<JournalEntry> result = new ArrayList<>();
		try 
		{
			FileReader reader = new FileReader(filename);
			Gson gson = new Gson();
			Type type = new TypeToken<ArrayList<JournalEntry>>() {}.getType();
			result = gson.fromJson(reader, type);
			reader.close();
		}
	       	catch(IOException e)
	       	{
			System.out.println("No existing journal file found — starting fresh.");
		}
		return result;
	}
	
	public static void writeToFile(String filename, ArrayList<JournalEntry> entries) 
	{
		try
	        {
            		FileWriter writer = new FileWriter(filename);
            		Gson gson = new Gson();
            		gson.toJson(entries, writer);
            		writer.close();
       		} 
		catch(IOException e)
		{
            		System.out.println("Could not write journal entries.");
        	}
    	}
}//class ends

