package Aplicacao;


import java.sql.*;

public class Conta {

    private int idPedido;
    private double valor;

    private int idCliente;
    private int idConta;

    private int matricula;


    public Conta(int idPedido, double valor) {
        this.idPedido = idPedido;
        this.valor = valor;
    }

    public Conta (int idCliente, int idConta){
        this.idCliente = idCliente;
        this.idConta = idConta;
    }

    public Conta (int matricula, int idConta, int nada){
        this.matricula = matricula;
        this.idConta = idConta;
    }

    public void criarConta(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO conta (ID_Pedido, Valor) VALUES (?, ?)");

            preparedStatement.setInt(1, idPedido);
            preparedStatement.setDouble(2, valor);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pagarConta(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE conta SET ID_Cliente = ?, Status = 'Pago' WHERE ID = ?");

            preparedStatement.setInt(1, idCliente);
            preparedStatement.setInt(2, idConta);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void imprimirConta(Connection connection){
        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;
        Statement statement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE conta SET Matricula_Funcionario = ?, Status_Impressao = 'Impresso' WHERE ID = ?");

            preparedStatement.setInt(1, matricula);
            preparedStatement.setInt(2, idConta);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("SELECT * FROM conta WHERE ID = ?");

            preparedStatement.setInt(1, idConta);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getInt("ID") + ", " + resultSet.getDouble("Valor")
                        + ", "+ resultSet.getString("Status") + ", " + resultSet.getString("Status_Impressao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
