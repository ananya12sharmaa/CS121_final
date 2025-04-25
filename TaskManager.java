//TaskManager.java class now
//to create, store and manage task objects we have 
//& to manage a list of tasks
//using generics
//6 methods, 1)to add, 2)display, 3)delete, 4)change description, 5)sorting by urgency, 6)get the list of tasks

import java.util.ArrayList;

public class TaskManager 
{//class starts

    //private access modifier, so that it encapsulates the tasks only here and can only be accessed by the above class
    private ArrayList<Task> tasks;
    
    public TaskManager() 
    {
	    tasks = new ArrayList<>();
    }

    public TaskManager(ArrayList<Task> tasks) 
    {
    this.tasks = tasks;
    }

    //to add a new task to our list
    public void addTask(Task task)
    {
        tasks.add(task);
        System.out.println("~~~~~~~  ✅Task added successfully! ~~~~~~~\n");//confirmation print statement
    }

    //to view all tasks
    public void viewAllTasks() 
    {
        if(tasks.isEmpty())//condition to check if our task list is empty
       	{
            System.out.println("~~~~~~ No tasks to display ~~~~~~ ");
            return;//to exit out of method without the execution of following block and print garbage values
        }

        System.out.println("You have " + tasks.size() + " task(s):");
        for(int i = 0; i < tasks.size(); i++) {
            System.out.println("Task #" + (i + 1));
            tasks.get(i).displayTask();
        }
    }//view method ends

    //to delete a task
    public void deleteTask(int taskNo) 
    {
        int i = taskNo - 1;
        if(i >= 0 && i < tasks.size()) 
	{
            tasks.remove(i);
            System.out.println("~~~~~~ 🗑️Task deleted successfully! ~~~~~~");
        }
       	else 
	{
            System.out.println("~~~~~~ ⚠️ Invalid task number! ~~~~~~");
        }
    }//deleting method ends

    //to customise a task description(editting)
    public void editTaskDescription(int taskNo, String newDescription) 
    {
        int i = taskNo - 1;

        if(i >= 0 && i < tasks.size()) 
	{
            tasks.get(i).setDescription(newDescription);
            System.out.println("~~~~~~ 📝 Task description updated! ~~~~~~");
        } 
	else
       	{
            System.out.println("~~~~~~ ⚠️ Invalid task number! ~~~~~~");
        }
    }//edit method ends


    public void getByPriority(int level) 
    {
	    boolean found = false;
	    for(int i = 0; i < tasks.size(); i++) 
	    {
		    if(tasks.get(i).getPriority() == level)
		    {
			    if(!found) 
			    {
				    System.out.println("Tasks with priority " + level + ":");
				    found = true; 
			    }
			    System.out.println("Task #" + (i + 1));
			    tasks.get(i).displayTask();
		    }
	    }
	    if(!found) 
	    {
		    System.out.println("No tasks found with priority " + level + ".");
            }
     }
    public void getByMood(Mood mood)
    {
	    boolean found = false;
	    for(int i = 0; i < tasks.size(); i++)
	    {
		    if(tasks.get(i).getMood() == mood)
		    {
			    if(!found)
			    {
				    System.out.println("Tasks with mood " + mood + ":");
				    found = true;
			    }
			    System.out.println("Task #" + (i + 1));
			    tasks.get(i).displayTask();
		    }
            }
	    if(!found)
	    {
		    System.out.println("No tasks found with mood " + mood + ".");
	    }
    }


    public ArrayList<Task> getTasks() 
    {
        return tasks;
    }
}//class ends

