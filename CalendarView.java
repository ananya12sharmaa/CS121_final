import java.util.ArrayList;
import java.util.Comparator;

public class CalendarView 
{
       	// Display all tasks sorted by priority using displayTask()
    	public void displayByPriority(ArrayList<Task> tasks) 
	{
        	tasks.sort(Comparator.comparingInt(Task::getPriority));
        	System.out.println("\n🗂️  Calendar View: Sorted by Priority");

        	if (tasks.isEmpty())
	       	{
            	System.out.println("No tasks to display.");
            	return;
        	}

        	for (Task task : tasks) 
		{
            		task.displayTask(); // uses your aesthetic design
        	}
    	}

    	// Display tasks grouped by mood using displayTask()
    	public void displayByMood(ArrayList<Task> tasks) 
	{
        	System.out.println("\n🗂️  Calendar View: Grouped by Mood");

        	for (Mood mood : Mood.values())
	       	{
            		System.out.println("\n━━━━━━━━━━ Mood: " + mood + " ━━━━━━━━━━");
            		boolean found = false;

            		for (Task task : tasks) 
			{
                		if (task.getMood() == mood) 
				{
                    			task.displayTask(); // fairy-core layout
                    			found = true;
                		}
            		}

            		if(!found) 
			{
                		System.out.println("No tasks found for this mood.");
            		}
        	}
	}
	public void displayByDay(ArrayList<Task> tasks)
	{
    		String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
    		ArrayList<ArrayList<String>> dayTasks = new ArrayList<>();

    		// prepare empty lists for each day
    		for(int i = 0; i < 7; i++) 
		{
        		dayTasks.add(new ArrayList<>());
    		}

    		// fill in task descriptions per day
    		for(Task task : tasks)
	       	{
        		String day = task.getDayOfWeek().toString();
        		System.out.println("DEBUG: Task '" + task.getTitle() + "' is scheduled for " + day);
			for (int i = 0; i < days.length; i++) 
			{
            			if (days[i].equals(day)) 
				{
                		dayTasks.get(i).add(task.getDescription());
            			}
        		}
    		}

    		//to print our  header
    		System.out.println("\n=================== WEEKLY TASK CALENDAR ===================");
    		for(String day : days)
	       	{
        		System.out.print("| " + String.format("%-10s", day));
    		}
    		System.out.println("|");

    		//to print a simple separator
    		for(int i = 0; i < 7; i++) 
		{
        		System.out.print("+------------");
    		}
    		System.out.println("+");

    		//print up to 4 tasks per day in rows
    		for(int row = 0; row < 4; row++) 
		{
			for(int col = 0; col < 7; col++) 
			{
				ArrayList<String> list = dayTasks.get(col);
            			if(row < list.size()) 
				{
                			System.out.print("| " + String.format("%-10s", list.get(row)));
            			}
			       	else 
				{
               				 System.out.print("| " + " ".repeat(10));
            			}
        		}
        		System.out.println("|");
    		}

    		// final bottom border
    		for(int i = 0; i < 7; i++) 
		{
        		System.out.print("+------------");
    		}
    		System.out.println("+\n");
	}
	
}

