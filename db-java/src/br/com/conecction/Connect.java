package br.com.conecction;

import java.sql.*;

public class Connect {

    public static void main (String[] args) {
        String url = "jdbc:postgresql://localhost:5432/FIAP";
        String user = "postgres";
        String password = "";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Success connection");

            // Statement statement = connection.createStatement();
//            statement.executeQuery("INSERT INTO public.\"PRODUCTS\" (NAME, PRICE, QUANTITY) VALUES ('Cereja', '14.00', 3)");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.\"PRODUCTS\" (NAME, PRICE, QUANTITY) VALUES (?, ?, ?)");

            // java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

//            preparedStatement.setString(1, "Amora");
//            preparedStatement.setString(2, "15,00");
//            preparedStatement.setInt(3, 4);

//            preparedStatement.setString(1, "Melão");
//            preparedStatement.setString(2, "15,00");
//            preparedStatement.setInt(3, 4);
//            preparedStatement.executeUpdate();


            // ResultSet result = statement.executeQuery("SELECT * FROM public.\"PRODUCTS\" ORDER BY id ASC ");

//            preparedStatement = connection.prepareStatement("DELETE FROM public.\"PRODUCTS\" WHERE ID = ?");
//            preparedStatement.setInt(1, 5);
//            preparedStatement.executeUpdate();

            // preparedStatement = connection.prepareStatement("SELECT * FROM public.\"PRODUCTS\" WHERE ID = ?");
            // coloca no parâmetro 1 o valor 2
            // preparedStatement.setInt(1, 2);
            // ResultSet result = preparedStatement.executeQuery();

            CallableStatement cs = connection.prepareCall("CALL insert_product(?, ?, ?)");
            cs.setString(1, "Abacaxi");
            cs.setString(2, "15.00");
            cs.setInt(3, 18);
            cs.executeUpdate();

            preparedStatement = connection.prepareStatement("SELECT * FROM public.\"PRODUCTS\"");
            // coloca no parâmetro 1 o valor 2
            // preparedStatement.setInt(1, 2);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                System.out.println(result.getInt("id") + " " + result.getString("name") + " " + result.getString("price") + " " + result.getInt("quantity"));
            }

            connection.close();
        } catch (ClassNotFoundException e) {
            // Erro caso o driver JDBC não foi instalado
            e.printStackTrace();
        } catch (SQLException e) {
            // Erro caso haja problemas para se conectar ao banco de dados
            e.printStackTrace();
        }
    }

}
