public class TestTask {
    public static void main(String[] args) {
        Task t = new Task(
            "Finish Java UML",
            "School",
            "04-22-2025",
            "23:59",
            DayOfWeek.TUESDAY,
            1,
            Mood.FOCUSED
        );

        t.displayTask();
    }
}

