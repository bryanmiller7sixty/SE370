package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Con_1 {
        public static void main(String[] args)throws Exception{
            getConnection();
            get();
        }
        public static String get() throws Exception{
            try{
                Connection con = getConnection();
                PreparedStatement statement = con.prepareStatement("SELECT name,company FROM data");
                ResultSet result = statement.executeQuery();
                String str = " ";
                ArrayList<String> array = new ArrayList<String>();
                while ((result.next())){
                    str += "Name: ";
                    str += result.getString("name");
                    str += "Company: ";
                    str += result.getString("company");
                    //array.add(result.getString("Name"));
                }
                System.out.println("All records have been selected");
                return str;
            }catch(Exception e){
                System.out.println(e);
                return null;
            }
        }
        public static Connection getConnection() throws Exception{
            try{
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/d_app"; //server can be seen as local host followed by the name of the schema
                String username = "root"; //username goes here
                String password = ""; //your password goes here
                Connection connect = DriverManager.getConnection(url, username, password);
                System.out.println("Connected!");
                return connect;
            }catch(Exception e){
                System.out.println(e);
            }
            return null;
        }
    }
