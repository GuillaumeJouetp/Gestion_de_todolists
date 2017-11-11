package Seance2;

import java.util.ArrayList;

public class Agenda
{
    private String Name;
    ArrayList<Todolist> TodolistList = new ArrayList<>(); // liste de Todolist

    public Agenda(String name)
    {
        Name = name;
    }

    public void add(Todolist actualT)
    {
        TodolistList.add(actualT);
    }

    public void remove(Todolist actualTodolist)
    {
        TodolistList.remove(actualTodolist);
    }

    public ArrayList<Todolist> getTodolistList() {
        return TodolistList;
    }


    public void displaytTodolists ()
    {
        System.out.println("Voici la liste de vos ToDoListes : \n");
        TodolistList.forEach(Todolist -> System.out.println("Nom : " + Todolist.getName()) );
        System.out.println("");
    }
}
