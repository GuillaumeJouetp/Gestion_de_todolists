package Seance2;

import java.util.ArrayList;

public class Todolist
{
    private String Name;
    private ArrayList<Task> TaskList = new ArrayList<>(); // liste des taches

    public ArrayList<Task> getTaskList() {
        return TaskList;
    }

    public Todolist(String name)
    {
        Name = name;
    }

    public String getName()
    {
        return Name;
    }

    public void add(Task actualT)
    {
        TaskList.add(actualT);
    }

    public void remove(Task ActualTask)
    {
        TaskList.remove(ActualTask);
    }

    public void displayTasks ()
    {
        System.out.println("La liste des taches de votre TodoList est la suivante : \n");
        TaskList.forEach(Task -> System.out.println("Nom : " + Task.getName() + "\nDescription : " + Task.getDescription() + "\nDeadline : " + Task.getDeadline() + "\n" ) );
    }
}
