//using ArrayList to be able to use array as keeping a jounal diary in continuation
import java.util.ArrayList;

//class definition
public class JournalManager 
{
	//generic to have only be able to hold JournalEntry
	private ArrayList<JournalEntry> entries;
	
	//contructor to intitalise where the entries will be stored
	public JournalManager()
	{
		entries = new ArrayList<>();
	}//contructor ends

	//to write a new journal entry
	public void writeEntry(String date, Mood mood, String note) 
	{
		JournalEntry newEntry = new JournalEntry(date, mood, note);
		entries.add(newEntry);
		System.out.println("Journal entry added for " + date + ".");
	}//method ended

	//to view an entry by date
	public void viewEntry(String date) 
	{
		boolean found = false;
		//enhanced for loop to avaoid going into counting
		//to rather go into each entry and work with it
		for(JournalEntry entry : entries) 
		{
			if(entry.getDate().equals(date))
		       	{
				entry.displayEntry();
				found = true;
				break;//amateur way to exit a loop lol
			}//if block endss
		}//for block ends
		
		//if no entry for a particular date
		if(!found)
		{
			System.out.println("No journal entry found for " + date + ".");
		}//if block ends
        }//method ends

	//to get mood for a specific date
	public Mood getMoodByDate(String date)
	{
		for(JournalEntry entry : entries)
	       	{
			if(entry.getDate().equals(date)) 
			{
				return entry.getMood();
			}
		}
		return null; // No entry found
        }//method ends

	// Get all entries (useful for calendar or archive display)
	public ArrayList<JournalEntry> getAllEntries()
	{
		return entries;
	}
}//class ends

