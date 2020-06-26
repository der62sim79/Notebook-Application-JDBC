package at.ta.Notebook;

import java.util.List;
import java.util.Scanner;

public class TaskGUI {

    private Scanner scanner;
    private TaskDAO taskDAO;

    public TaskGUI (){
        this.scanner = new Scanner(System.in);
        this.taskDAO = new TaskDAO();
    }

    public void readInput(){
        System.out.println("Willkommen Ali in deinem Notizblock!");
        while (true){
            System.out.println();
            System.out.printf("Wähle a um Notizen einzufügen \nWähle p um deine Notizen anzuzeigen \nWähle u um deine Notizen zu bearbeiten \n" +
                    "Wähle d um deine Notiz zu löschen \n");
            System.out.println("Eingabe: ");
            String input = this.scanner.nextLine();

            if (input.equals("a")){

                addTask();
            }

            if (input.equals("p")){

                printAllTasks();
            }

            if (input.equals("u")){
                updateTask();
            }

            if (input.equals("d")){

                deleteTask();
            }
        }
    }

    public void printAllTasks() {
        List<TaskVO> taskDAOS = this.taskDAO.getAllTasks();
        for (TaskVO task : taskDAOS) {
            System.out.println("Notiz id: " + task.getId() + " deine Noitz: " + task.getNote());
        }
    }

    public void addTask(){
        System.out.println("Bitte gib deine notiz ein bis zu 500 Buchstaben: ");
        String input = this.scanner.nextLine();
        TaskVO taskVO = new TaskVO (0,input);
        taskDAO.insertTask(taskVO);
        printAllTasks();
    }

    public void updateTask() {
        System.out.println("Für Notiz änderung id wählen: ");
        String inputId = this.scanner.nextLine();
        int id = Integer.valueOf(inputId);
        System.out.println("Änderung: ");
        String inputString = this.scanner.nextLine();
        TaskVO taskVO = new TaskVO(id, inputString);
        taskDAO.upDate(taskVO);
        printAllTasks();
    }

    public void deleteTask(){
        System.out.println("Für Notiz löschen id wählen: ");
        String inputId = this.scanner.nextLine();
        int id = Integer.valueOf(inputId);
        TaskVO taskVO = new TaskVO(id, "");
        taskDAO.deleteNotice(taskVO);
    }
}
