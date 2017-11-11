package Seance2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        Agenda agenda1 = new Agenda("Mon agenda");
        System.out.println("Bienvenue dans votre agenda");

        /* creating todolists templates */
        Todolist Todolist1 = new Todolist("Vie privée");
        Task Task1 = new Task("Chien","Promener le chien","Lundi 18h");
        Task Task2 = new Task("Pain","Acheter du pain","Mardi soir");
        Todolist1.add(Task1);
        Todolist1.add(Task2);

        Todolist Todolist2 = new Todolist("Vie étudiante");
        Task Task3 = new Task("Projet java","Terminer le projet java","Samedi");
        Task Task4 = new Task("E-learning","Lire le chapitre 5 d'E-learning","Dimanche soir");
        Todolist2.add(Task3);
        Todolist2.add(Task4);

        agenda1.add(Todolist1);
        agenda1.add(Todolist2);

        /* Menu principal */
        boolean Power = true;
        while(Power)
        {
            System.out.println("---------------------------------------------------------------------------");
            agenda1.displaytTodolists();

            System.out.println("Que voulez vous faire? (Entrez 1, 2, 3, 4 ou 5)");
            System.out.println("1. Ajouter une ToDoListe");
            System.out.println("2. Supprimer une ToDoListe");
            System.out.println("3. Modifier une ToDoListe");
            System.out.println("4. Consulter les taches d'une ToDoListe");
            System.out.println("5. Arreter le programme");


            int choix1;
            /*Securite utilisateur*/
            do {
                 choix1 = scan.nextInt();
                 if(choix1 !=1 && choix1 !=2 && choix1 !=3 && choix1 !=4 && choix1 !=5){
                     System.out.println("Veuillez entrer un chiffre valide");
                 }
            }while(choix1 !=1 && choix1 !=2 && choix1 !=3 && choix1 !=4 && choix1 !=5);

                switch (choix1) {

                    case 1:
                /*Todolist creation*/
                        System.out.println("Comment voulez vous appeler votre Todoliste?");
                        String name = scan2.nextLine();
                        Todolist myTodolist1 = new Todolist(name);
                        agenda1.add(myTodolist1);
                        System.out.println("Todolist ajoutée avec succes !");
                        break;

                    case 2:
                /*ToDoList suppression*/
                        ArrayList<Todolist> ToRemoveList = new ArrayList<>(); // liste des todolistes à supprimer
                        System.out.println("Quelle Todoliste voulez-vous supprimer?");
                        String nameTodolistDeleted = scan2.nextLine();
                /*Test si la valeur de l'utilisateur correspond a une todoliste existente*/
                        agenda1.getTodolistList().forEach(Todolist ->
                        {
                            if (Todolist.getName().equals(nameTodolistDeleted)) {
                                ToRemoveList.add(Todolist);
                                System.out.println(Todolist.getName() + " a ete supprime avec succes");
                            }
                        });
                        agenda1.getTodolistList().removeAll(ToRemoveList);
                        break;

                    case 3:
                /*Todolist Modification*/
                        System.out.println("Quelle Todoliste voulez-vous modifier?");
                        String nameTodolistModified = scan2.nextLine();

                /*Menu 2*/
                        System.out.println("Que voulez vous faire? (Entrez 1 ou 2)");
                        System.out.println("1. Ajouter une tache");
                        System.out.println("2. Supprimer une tache");

                        int choix2;
                        /*Securite utilisateur*/
                        do {
                            choix2 = scan.nextInt();
                            if(choix2 !=1 && choix2 !=2){
                                System.out.println("Veuillez entrer un chiffre valide");
                            }
                        }while(choix2 !=1 && choix2 !=2);

                        switch (choix2) {
                            case 1:
                        /*Task creation*/
                        /*Test si la valeur de l'utilisateur correspond a une todoliste existente*/
                                agenda1.getTodolistList().forEach(Todolist ->
                                {
                                    if (Todolist.getName().equals(nameTodolistModified)) {
                                /*Asking user for params of his task*/
                                        System.out.println("Quel est le nom de votre tache ?");
                                        String nameTask1 = scan2.nextLine();
                                        System.out.println("quel est la description de votre tache ?");
                                        String descriptionTask1 = scan2.nextLine();
                                        System.out.println("quel est le deadline de votre tache?");
                                        String deadlineTask1 = scan2.nextLine();
                                        Task myTask1 = new Task(nameTask1, descriptionTask1, deadlineTask1);
                                        Todolist.add(myTask1);
                                        System.out.println("Tache ajoutée avec succes !");
                                    }

                                });
                                break;
                            case 2:
                        /*Task suppression*/
                                ArrayList<Task> ToRemoveList2 = new ArrayList<>(); // liste des taches à supprimer
                        /*Test si la valeur de l'utilisateur correspond a une tache existente*/
                                agenda1.getTodolistList().forEach(Todolist ->
                                {
                                    if (Todolist.getName().equals(nameTodolistModified)) {
                                        Todolist.displayTasks();
                                        System.out.println("Quelle tache voulez-vous supprimer?");
                                        String nameTaskDeleted = scan2.nextLine();
                                        Todolist.getTaskList().forEach(Task ->
                                        {
                                            if (Task.getName().equals(nameTaskDeleted)) {
                                                ToRemoveList2.add(Task);
                                                System.out.println(Task.getName() + " a ete supprime avec succes");
                                            }
                                        });
                                        Todolist.getTaskList().removeAll(ToRemoveList2);

                                    }
                                });
                                break;
                        }
                        break;
                    case 4:
                /*Todolist Consultation*/
                        System.out.println("Quelle Todoliste voulez-vous consulter?");
                        String nameTodolistConsulted4 = scan2.nextLine();
                /*Test si la valeur de l'utilisateur correspond a une todoliste existante*/
                        agenda1.getTodolistList().forEach(Todolist ->
                        {
                            if (Todolist.getName().equals(nameTodolistConsulted4)) {
                                Todolist.displayTasks();
                            }

                        });
                        break;

                    case 5:
                        Power = false;
                }



        }
    }
}



