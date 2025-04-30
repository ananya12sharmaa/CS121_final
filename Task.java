// Task.java
// Class to store the details of each task

public class Task
{//class starts
    //for encapsulation, the attributes are private
	
    private String title;//adding the main short title
    private String description;  //optional tiny description of the task in hand
    private String category;  //maybe it can be school work, personal project, fun etc
    private String date;  // format would be our usual: MM-DD-YYYY
    private String time;  // format for this will again be our usual HH:MM
    private DayOfWeek dayOfWeek;  //just our basic string type day of the week
    private int priority;  //used to determine the urgency of the task, that will be used in priorty: 1 = high, 5 = low
    private Mood mood;  // again our any String type

    //Constructor for setting our objects with their initial values
    public Task(String title, String description, String category, String date, String time, DayOfWeek dayOfWeek,  int priority, Mood mood) 
    {
	//this keyword is used to refer currect object in this class
        this.title = title;
	this.description = description;
        this.category = category;
        this.date = date;
        this.time = time;
	this.dayOfWeek = dayOfWeek;
        this.priority = priority;
        this.mood = mood;
	//this.mood = Mood.valueOf(mood.toUpperCase());
    }//constructor ends

    //getters
    public String getTitle() 
    {
    return title;
    }
    public String getDescription()
    {
	    return description; 
    }
    public String getCategory() 
    {
	    return category;
    }
    public String getDate()
    {
	    return date;
    }
    public String getTime()
    {
	    return time;
    }
    public DayOfWeek getDayOfWeek()
    {
	    return dayOfWeek;
    }
    public int getPriority()
    {
	    return priority;
    }
    public Mood getMood()
    {
	    return mood;
    }

    //setters for all attributes
    
    public void setTitle(String title)
    {
            this.title = title;
    }
    public void setDescription(String description) 
    {
	    this.description = description; 
    }
    public void setCategory(String category) 
    {
	    this.category = category;
    }
    public void setDate(String date)
    {
	    this.date = date;
    }
    public void setTime(String time)
    {
	    this.time = time;
    }
    public void setDayOfWeek(DayOfWeek dayOfWeek) 
    {
	    this.dayOfWeek = dayOfWeek;
    }

    public void setPriority(int priority)
    {
	    this.priority = priority;
    }
    public void setMood(Mood mood) 
    {
	    this.mood = mood;
    }
   
    //display method for a structured screen display
    public void displayTask() 
    {//method starts
	    String estyle = "\n° ❀ ⋆ ｡ ˚ 𓇼  ⋆ 𓆉    𓆝  𓆡  ˚ ｡ ⋆ 𓇼 ⋆ ｡ ˚ ❀ °\n";
	    System.out.println(estyle);
	    System.out.println("📌 " + title + " (" + category + ")");
	    System.out.println("🗒  " + description);
	    System.out.println("🗓 " + dayOfWeek + ", " + date + " ⏰ " + time);
	    System.out.println("🎯 Priority: " + priority + " | Mood: " + mood);
	    System.out.println(estyle + "\n");
    }//method ends

}//class ends
