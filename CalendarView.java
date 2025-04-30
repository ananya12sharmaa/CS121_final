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
			DayOfWeek dow = task.getDayOfWeek();
        		int index = dow.ordinal(); // 0 = MONDAY, 6 = SUNDAY
        		String title = task.getTitle();

        		if (title.length() > 12) 
			{
           			 title = title.substring(0, 10) + "…";
        		}
			dayTasks.get(index).add(title);
    		}

    		int maxRows = 0;
    		for(ArrayList<String> col : dayTasks) 
		{
        		if (col.size() > maxRows) 
			{
            			maxRows = col.size();
        		}
    		}	

    		System.out.println("\n=================== WEEKLY TASK CALENDAR ===================");
    		System.out.print("| ");
    		for(String day : days) 
		{
        		System.out.printf("%-10s | ", day.substring(0, 3)); // MON, TUE, ...
    		}
    		System.out.println();
    		System.out.println("+------------+------------+------------+------------+------------+------------+------------+");

    		for(int row = 0; row < maxRows; row++) 
		{
        		System.out.print("| ");
        		for(int col = 0; col < 7; col++) 
			{
            			ArrayList<String> column = dayTasks.get(col);
            			String cell = (row < column.size()) ? column.get(row) : "";
            			System.out.printf("%-10s | ", cell);
        		}
        		System.out.println();
    		}

    		System.out.println("+------------+------------+------------+------------+------------+------------+------------+\n");
	}

	
}

