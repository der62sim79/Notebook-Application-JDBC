package at.ta.Notebook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    public List<TaskVO> getAllTasks() {
        List<TaskVO> tasks = new ArrayList<>();

        try {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/notebook?user=root";
            //Verbindung zur Datenbank
            connection = DriverManager.getConnection(url);
            System.out.println("Connectet to DB!");

            //Statment für MYSQL befehl
            String sql = "Select * from note";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            //einzelne Zeilen ausgabe
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("notiz");

                TaskVO taskVO = new TaskVO(id, name);
                tasks.add(taskVO);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tasks;
    }

    public void insertTask(TaskVO taskVO) {
        String sql = "INSERT INTO `note`( `notiz`) VALUES ('" + taskVO.getNote() + "')";

        try {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/notebook?user=root";
            //Verbindung zur Datenbank
            connection = DriverManager.getConnection(url);
            System.out.println("Connectet to DB!");


            Statement statement = connection.createStatement();
            statement.execute(sql);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void upDate(TaskVO taskVO) {
        String sql = "UPDATE note SET notiz = '" + taskVO.getNote() + "' WHERE id = " + taskVO.getId() + "";

        try {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/notebook?user=root";

            connection = DriverManager.getConnection(url);
            System.out.println("Connectet to DB!");


            Statement statement = connection.createStatement();
            statement.execute(sql);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteNotice(TaskVO taskVO) {
        String sql = "DELETE FROM note WHERE id = " + taskVO.getId() + "";

        try {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/notebook?user=root";

            connection = DriverManager.getConnection(url);
            System.out.println("Connectet to DB!");


            Statement statement = connection.createStatement();
            statement.execute(sql);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
