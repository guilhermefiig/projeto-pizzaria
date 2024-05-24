package Aplicacao;

import java.sql.*;

public class Pizza {
    private int idPizza;
    private String sabor;
    private double valor;
    private int matriculaFunc;

    public Pizza(String sabor, double valor, int matriculaFunc) {
        this.sabor = sabor;
        this.valor = valor;
        this.matriculaFunc = matriculaFunc;
    }

    public Pizza() {
    }

    public Pizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public void addPizza(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO pizza (Sabor ,Valor, Matricula_Funcionario) VALUES (?, ?, ?)");

            preparedStatement.setString(1, sabor);
            preparedStatement.setDouble(2, valor);
            preparedStatement.setInt(3, matriculaFunc);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPizzas(Connection connection){
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT pizza.ID, pizza.Sabor, pizza.Valor, funcionario.nome AS Funcionario " +
                    "FROM pizza " +
                    "LEFT JOIN funcionario ON pizza.Matricula_Funcionario = funcionario.Matricula");

            while (resultSet.next()) {
                String funcionario = resultSet.getString("Funcionario");
                System.out.print("    ID: " + resultSet.getInt("ID") + " | " +
                        "Sabor: " + resultSet.getString("Sabor") + " | " +
                        "Valor: " + resultSet.getDouble("Valor") + " | " +
                        "Funcionário que cadastrou: ");
                if (funcionario != null) {
                    System.out.println(funcionario);
                } else {
                    System.out.println("Apagado");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPizza(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM pizza WHERE ID = ?");

            preparedStatement.setInt(1, idPizza);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double valorPizzas(Connection connection) {
        double valor = 0.0;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select Valor from pizza where ID = ?"
            );

            preparedStatement.setInt(1, idPizza);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                valor = resultSet.getDouble("Valor");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valor;
    }
}


