import java.sql.*;
import java.util.Scanner;

public class jdbc4 {

    private static final String url ="jdbc:mysql://127.0.0.1:3306/LENDEN";
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
            connection.setAutoCommit(false);
            String debit_query = "UPDATE accounts SET balance = balance - ? WHERE account_num = ?";
            String credit_query = "UPDATE accounts SET balance = balance + ? WHERE account_num = ?";

            PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Account Number : ");
            int account_num = scanner.nextInt();

            System.out.println("Enter Amount : ");
            double amount = scanner.nextDouble();

            debitPreparedStatement.setDouble(1,amount);
            debitPreparedStatement.setInt(2,account_num);

            creditPreparedStatement.setDouble(1,amount);
            creditPreparedStatement.setInt(2,101);

            debitPreparedStatement.executeUpdate();
            creditPreparedStatement.executeUpdate();

            if(isSufficient(connection,account_num,amount)){
                connection.commit();
                System.out.println("Transition Successful ");
            }else{
                connection.rollback();
                System.out.println("Transition Failed !! ");
            }
            debitPreparedStatement.close();
            creditPreparedStatement.close();
            scanner.close();
            connection.close();

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    static boolean isSufficient(Connection connection , int account_num ,double amount){

        try
        {
            String query = "SELECT balance FROM accounts WHERE account_num = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,account_num);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                double current_bal = resultSet.getDouble("balance");
                if(amount > current_bal){
                    return false;
                }else {
                    return true;
                }
            }
            resultSet.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }



}