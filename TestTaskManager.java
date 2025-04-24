public class TestTaskManager {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task t1 = new Task("Finish Java Homework", "School", "04-22-2025", "23:59", DayOfWeek.TUESDAY, 1, Mood.FOCUSED);
        Task t2 = new Task("Call Grandma", "Personal", "04-23-2025", "18:00", DayOfWeek.WEDNESDAY, 3, Mood.REFLECTIVE);
        Task t3 = new Task("Clean Room", "Chores", "04-24-2025", "16:00", DayOfWeek.THURSDAY, 2, Mood.TIRED);

        manager.addTask(t1);
        manager.addTask(t2);
        manager.addTask(t3);

        manager.viewAllTasks();
    }
}

