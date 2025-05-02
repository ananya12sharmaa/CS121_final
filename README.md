# CS121_final
# PRYSM 
## UML
![image](prysm_uml.png)
command for terminal to execute:
```bash run``` 
## Mood-Based Schedule Maker with Journaling Reflection
### Why I Wanted to Do This Project:

As a student, I often struggle with managing multiple tasks, and I wanted a system that could help me prioritize them in a way that aligns with my mood and mental state. Sometimes, I feel highly focused and productive, while other times, I’m overwhelmed or distracted. I realized that a mood-based scheduling tool could not only help me prioritize tasks but also give me insights into how my mood influences my productivity.

### Intended Purpose:

This project is intended to provide a more personalized approach to task management by taking mood into account. By categorizing tasks based on mood, I hope to improve my ability to plan tasks that match my current state of mind, making it easier to complete them without feeling too stressed or overburdened. Additionally, the journaling feature allows me to reflect on my productivity and mental state, helping me identify patterns over time. This tool will not only serve as an efficient task manager but also as a tool for self-reflection and growth.

## Algorithm

### Import libraries like Scanner for user input and Gson for JSON data handling.
Beginning Class:

Starting with the Prysm class, which serves as the entry point for the application.

Beginning Main Method for Menu Display:
Creating an object of Scanner, using 3 switch cases for giving choices for exit, task manager, and journal manager.
Using break to avoid fall-through.
Closing the Scanner object after use.
Beginning TaskManager with Scanner as Parameter:
Managing tasks like adding, editing, and removing tasks.
Using TaskDataManager to load and save tasks from the JSON file.
Beginning JournalManager with Scanner as Parameter:
Managing journaling reflections for tasks, keeping track of mood and productivity.
Using JournalDataManager to load and save journal entries.

for Generating Random Mood:
For each task, allowing the user to select a mood (like happy, stressed, focused, etc.).
The task will be categorized by this mood and saved accordingly.
Task and Journal Entry Reflection:
After completing tasks, users will write reflections, which will be stored in the system for future reference.
Using Gson for Data Persistence:
Saving tasks and journal entries in tasks.json and journals.json files for persistence.
Closing Method, Closing  Class:
Ensure all resources (files, scanners, etc.) are closed properly.

## Learning output :tada:
- [x] Java Basics: Learned how to manage user input, work with classes, and implement file I/O operations.
- [x] Data Persistence: Gained experience using Gson to save and load JSON data for tasks and journal entries.
- [x] Object-Oriented Design: Improved my understanding of OOP principles by designing classes like TaskManager, JournalManager, and TaskDataManager.

Document created with <3 and little stress by Ananya Sharma.

