
import java.sql.*;
import java.util.Scanner;

public class jdbc2 {

    private static final String url ="jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String username="root";
    private static final String password= "Akhtar@04";


    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();

            Scanner sc = new Scanner(System.in);

            while(true)
            {
                System.out.println("Enter Name : ");
                String name = sc.next();
                System.out.println("Enter age : ");
                int age = sc.nextInt();
                System.out.println("Enter Marks : ");
                double marks = sc.nextDouble();
                System.out.println("Enter more data (Y/N) : ");
                String choice = sc.next();
                String query = String.format("INSERT INTO students(name,age,marks) VALUES('%s',%d,%f)",name,age,marks);

                statement.addBatch(query);
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int[] arr = statement.executeBatch();

            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] == 0){
                    System.out.println("Query :"+i+ " not executed Successfully !!");
                }
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
