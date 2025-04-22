// TestTaskManager.java

public class TestTaskManager {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Create tasks
        Task t1 = new Task("Finish Java Homework", "School", "04-22-2025", "23:59", "Tuesday", 1, "focused");
        Task t2 = new Task("Call Grandma", "Personal", "04-23-2025", "18:00", "Wednesday", 3, "happy");
        Task t3 = new Task("Clean Room", "Chores", "04-24-2025", "16:00", "Thursday", 2, "tired");

        // Add tasks
        manager.addTask(t1);
        manager.addTask(t2);
        manager.addTask(t3);

        // View all tasks
        manager.viewAllTasks();

        // Test getByPriority
        manager.getByPriority(1);  // Should show only t1
        manager.getByPriority(5);  // Should say no tasks found

        // Optional: test delete and view again
        manager.deleteTask(2);     // Deletes "Call Grandma"
        manager.viewAllTasks();
    }
}

