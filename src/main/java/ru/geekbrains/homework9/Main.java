package ru.geekbrains.homework9;

import javax.naming.Name;
import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private static String tableCreate = "CREATE TABLE if not exists Cats(CatID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name TEXT NOT NULL, Type NOT NULL, Age INTEGER NOT NULL);";
    private static String dataAddFromObject = "insert into Cats(Name, Type, Age) values (?, ?, ?)";
    private static String deleteStrFromDB = "delete from Cats where CatID > 10";
    private static String changeStr = "update Cats set Age = 6 where Age > 6;";

    public static void main(String[] args) {

        try {
            //statement.execute(tableCreate); //таблица создана

            connect();
            statement = connection.createStatement();

            Cat cat = new Cat(2, "Министр", "Сфинкс", 6);
            //addCat(cat); //метод добавления кота
            //deleteCat(); //метод удаления котов
            //changeCat(); //метод изменения кота

            printObjetsFromDB();//метод извлечения котов
            close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public static void printObjetsFromDB() throws SQLException {
        int n = 0;
        ResultSet result2 = statement.executeQuery("select * from Cats;");
        while (result2.next()) {
            n++;
        }
        Cat[] cats = new Cat[n];
        int i = 0;
        ResultSet result = statement.executeQuery("select * from Cats;");
        while (result.next()) {
            Cat s = new Cat(result.getInt(1), result.getString(2),
                    result.getString(3), result.getInt(4));
            cats[i++] = s;
        }
        for (Cat c : cats) {
            System.out.println(c);
        }
    }

    public static void addCat(Cat cat) throws SQLException {
        ps = connection.prepareStatement(dataAddFromObject);
        ps.setString(1, cat.getName());
        ps.setString(2, cat.getType());
        ps.setInt(3, cat.getAge());
        ps.execute();
    }

    public static void deleteCat() throws SQLException {
        ps = connection.prepareStatement(deleteStrFromDB);
        ps.execute();
    }

    public static void changeCat() throws SQLException {
        ps = connection.prepareStatement(changeStr);
        ps.execute();
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:cat.db");
    }

    private static void close() throws SQLException {
        connection.close();
    }

}
