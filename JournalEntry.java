public class JournalEntry 
{
	private String date;
	private Mood mood;
	private String note;

	public JournalEntry(String date, Mood mood, String note) 
	{
		this.date = date;
		this.mood = mood;
		this.note = note;
        }
	public String getDate() 
	{
		return date;
       	}
	public Mood getMood() 
	{
		return mood;
	}
	public String getNote() 
	{
        return note;
       	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public void setMood(Mood mood)
       	{
		this.mood = mood;
	}
	public void setNote(String note) 
	{
		this.note = note;
       	}
	
	public void displayEntry() 
	{
		String estyle = "\n° ❀ ⋆ ｡ ˚ 𓇼  ⋆ 𓆉    𓆝𓆡  ˚ ｡ ⋆ 𓇼 ⋆ ｡ ˚ ❀ °\n";
		System.out.println(estyle);
		System.out.println("📝 Date: " + date);
		System.out.println("🎨 Mood: " + mood);
	       	System.out.println("🪶 Note: " + note);
		System.out.println(estyle);
	}
}

