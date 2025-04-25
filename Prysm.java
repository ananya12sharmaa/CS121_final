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
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter category (school, fun, personal): ");
        String category = scanner.nextLine();
        System.out.print("Enter date (MM-DD-YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Enter time (HH:MM): ");
        String time = scanner.nextLine();

        System.out.print("Enter day of week (e.g., MONDAY): ");
        DayOfWeek day = DayOfWeek.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Enter priority (1 = high → 5 = low): ");
        int priority = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter mood (e.g., FOCUSED, TIRED, EXCITED): ");
        Mood mood = Mood.valueOf(scanner.nextLine().toUpperCase());

    	Task newTask = new Task(description, category, date, time, day, priority, mood);
	taskManager.addTask(newTask);
	TaskDataManager.saveTasks(taskManager.getTasks());  // 💾 autosave after adding
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
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        ArrayList<Task> allTasks = taskManager.getTasks();

        switch (choice) {
            case "1" -> calendarView.displayByPriority(allTasks);
            case "2" -> calendarView.displayByMood(allTasks);
            default -> System.out.println("⚠️ Invalid calendar view choice.");
        }
    }
}

