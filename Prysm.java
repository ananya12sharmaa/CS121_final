import java.util.Scanner;
import java.util.ArrayList;

public class Prysm 
{
   // private static TaskManager taskManager = new TaskManager();
    private static TaskManager taskManager = new TaskManager(TaskDataManager.loadTasks());
    private static JournalManager journalManager = new JournalManager();
    private static CalendarView calendarView = new CalendarView();

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        printWelcome();

        while (running) 
        {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) 
            {
                case "1" -> addTask(scanner);
                case "2" -> addJournalEntry(scanner);
                case "3" -> viewAllTasks();
                case "4" -> viewAllJournalEntries();
                case "5" -> showCalendarMenu(scanner);
                case "6" -> {
                    System.out.println("🌙 Exiting Prysm... Stay radiant.");
                    running = false;
                }
                default -> System.out.println("⚠️ Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void printWelcome() 
    {
        System.out.println("━━━━━━━━━━ ❖ 𝙋𝙍𝙔𝙎𝙈 ❖ ━━━━━━━━━━");
        System.out.println("A reflection-based task + journal system.");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    private static void printMenu() 
    {
        System.out.println("\nMenu:");
        System.out.println("1. ➕ Add Task");
        System.out.println("2. 📝 Add Journal Entry");
        System.out.println("3. 📋 View All Tasks");
        System.out.println("4. 📓 View All Journal Entries");
        System.out.println("5. 📆 View Calendar");
        System.out.println("6. 🚪 Exit");
        System.out.print("Choose an option: ");
    }
    private static void addTask(Scanner scanner)
    {
	    System.out.print("Enter task title: ");
    	    String title = scanner.nextLine();

            System.out.print("Add a description? (yes/no): ");
            String addDesc = scanner.nextLine().trim().toLowerCase();
            String description = "";
            if(addDesc.equals("yes") || addDesc.equals("y")) 
	    {
		    System.out.print("Enter task description: ");
		    description = scanner.nextLine();
    	    }
	    System.out.println("Choose category:");
	    System.out.println("1. School");
	    System.out.println("2. Hobby");
	    System.out.println("3. Work");
	    System.out.println("4. Self-Care");
	    System.out.print("Enter number: ");
	    String category = switch (scanner.nextLine()) 
	    {
		    case "1" -> "School";
		    case "2" -> "Hobby";
		    case "3" -> "Work";
		    case "4" -> "Self-Care";
			    default -> "Other";
    	    };
	    System.out.print("Enter date (MMDD): ");
	    String mmdd = scanner.nextLine();
	    String date = mmdd.substring(0, 2) + "-" + mmdd.substring(2) + "-2025";
	    System.out.print("Enter time (HH:MM): ");
	    String time = scanner.nextLine();
	    System.out.println("Choose day of week:");
    	    String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
    	    for(int i = 0; i < days.length; i++) 
	    {
		    System.out.println((i + 1) + ". " + days[i]);
    	    }
	    System.out.print("Enter number: ");
	    int dayIndex = Integer.parseInt(scanner.nextLine()) - 1;
	    DayOfWeek day = DayOfWeek.valueOf(days[dayIndex]);
	    
	    System.out.print("Enter priority (1 = high → 5 = low): ");
	    int priority = Integer.parseInt(scanner.nextLine());
	    
	    System.out.println("Choose mood:");
	    Mood[] moods = Mood.values();
	    for(int i = 0; i < moods.length; i++) 
	    {
		    System.out.println((i + 1) + ". " + moods[i]);
	    }
	    System.out.print("Enter number: ");
	    int moodIndex = Integer.parseInt(scanner.nextLine()) - 1;
	    Mood mood = moods[moodIndex];

	    Task newTask = new Task(title, description, category, date, time, day, priority, mood);
	    taskManager.addTask(newTask);
	    TaskDataManager.saveTasks(taskManager.getTasks());
	    System.out.println("✅ Task added and saved!");
    }

    private static void addJournalEntry(Scanner scanner) 
    {
        System.out.print("Enter date (MM-DD-YYYY): ");
        String date = scanner.nextLine();

        System.out.print("Enter mood (e.g., REFLECTIVE, OVERWHELMED): ");
        Mood mood = Mood.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Write your journal note: ");
        String note = scanner.nextLine();

        journalManager.writeEntry(date, mood, note);
    }

    private static void viewAllTasks() 
    {
        System.out.println("\n📋 All Tasks:");
        taskManager.viewAllTasks();
    }

    private static void viewAllJournalEntries() 
    {
        System.out.println("\n📓 All Journal Entries:");
        for (JournalEntry entry : journalManager.getAllEntries()) 
        {
            entry.displayEntry();  // aesthetic journal display
        }
    }

    private static void showCalendarMenu(Scanner scanner) 
    {
        System.out.println("📆 Calendar View:");
        System.out.println("1. View by Priority");
        System.out.println("2. View by Mood");
        System.out.println("3. View by Day of Week");
	System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        ArrayList<Task> allTasks = taskManager.getTasks();

        switch (choice) {
            case "1" -> calendarView.displayByPriority(allTasks);
            case "2" -> calendarView.displayByMood(allTasks);
	    case "3" -> calendarView.displayByDay(allTasks);
            default -> System.out.println("⚠️ Invalid calendar view choice.");
        }
    }
}

