package Aplicacao;


import db.DB;

import java.sql.*;

public class Cliente {
    private String nome;
    private int idCliente;

    public Cliente(String nome) {
        this.nome = nome;
    }
    public Cliente() {
    }
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }


    public void addCliente(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO cliente (Nome) VALUES (?)");

            preparedStatement.setString(1, nome);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarClientes(Connection connection){
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM cliente");

            while (resultSet.next()){
                System.out.println("    ID: " + resultSet.getInt("ID") + " | " + "Nome: " + resultSet.getString("Nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarCliente(Connection connection) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM cliente WHERE ID = ?");

            preparedStatement.setInt(1, idCliente);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
