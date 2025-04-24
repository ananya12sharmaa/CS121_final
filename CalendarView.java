import java.util.ArrayList;
import java.util.Comparator;

public class CalendarView {

    // Display all tasks sorted by priority using displayTask()
    public void displayByPriority(ArrayList<Task> tasks) {
        tasks.sort(Comparator.comparingInt(Task::getPriority));
        System.out.println("\n🗂️  Calendar View: Sorted by Priority");

        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
            return;
        }

        for (Task task : tasks) {
            task.displayTask(); // uses your aesthetic design
        }
    }

    // Display tasks grouped by mood using displayTask()
    public void displayByMood(ArrayList<Task> tasks) {
        System.out.println("\n🗂️  Calendar View: Grouped by Mood");

        for (Mood mood : Mood.values()) {
            System.out.println("\n━━━━━━━━━━ Mood: " + mood + " ━━━━━━━━━━");
            boolean found = false;

            for (Task task : tasks) {
                if (task.getMood() == mood) {
                    task.displayTask(); // fairy-core layout
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No tasks found for this mood.");
            }
        }
    }
}

