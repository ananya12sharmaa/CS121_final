public class TestJournalManager {
    public static void main(String[] args) {
        // Create the manager
        JournalManager jm = new JournalManager();

        // Add a journal entry
        jm.writeEntry("04-24-2025", Mood.REFLECTIVE, "Had a peaceful day and wrote some code.");

        // View that entry
        jm.viewEntry("04-24-2025");

        // Get the mood by date
        Mood mood = jm.getMoodByDate("04-24-2025");
        if (mood != null) {
            System.out.println("Mood on 04-24-2025: " + mood);
        } else {
            System.out.println("No mood data found.");
        }
    }
}

