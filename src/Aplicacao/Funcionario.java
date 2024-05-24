package Aplicacao;

import java.sql.*;

public class Funcionario {
    private String nome;
    private int matriculaFuncionario;

    public Funcionario(String nome) {
        this.nome = nome;
    }
    public Funcionario(){

    }
    public Funcionario(int matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }

    public void addFuncionario(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO funcionario (Nome) VALUES (?)");

            preparedStatement.setString(1, nome);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarFuncionarios(Connection connection){
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM funcionario");

            while (resultSet.next()){
                System.out.println("    Matricula: " + resultSet.getInt("Matricula") + " | " + "Nome: " + resultSet.getString("Nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarFuncionario(Connection connection) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM funcionario WHERE Matricula = ?");

            preparedStatement.setInt(1, matriculaFuncionario);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
