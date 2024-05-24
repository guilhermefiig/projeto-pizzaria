package Aplicacao;

import java.sql.*;

public class Conta {

    private int idPedido;
    private double valor;

    private int idCliente;
    private int idConta;

    private int matricula;

    //contrutor para criação de conta
    public Conta(int idPedido, double valor) {
        this.idPedido = idPedido;
        this.valor = valor;
    }

    //contrutor para pagamento do cliente
    public Conta (int idCliente, int idConta){
        this.idCliente = idCliente;
        this.idConta = idConta;
    }

    //construtor para impressao
    public Conta (int matricula, int idConta, int nada){
        this.matricula = matricula;
        this.idConta = idConta;
    }

    public void criarConta(Connection connection){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO conta (ID_Pedido, Valor) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, idPedido);
            preparedStatement.setDouble(2, valor);

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                int idPedidoGerado = resultSet.getInt(1);
                System.out.println("\nID da conta: " + idPedidoGerado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pagarConta(Connection connection){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

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

        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE conta SET Matricula_Funcionario = ?, Status_Impressao = 'Impresso' WHERE ID = ?");

            preparedStatement.setInt(1, matricula);
            preparedStatement.setInt(2, idConta);
            preparedStatement.executeUpdate();


            preparedStatement = connection.prepareStatement("SELECT * from conta WHERE ID = ?;");
            preparedStatement.setInt(1, idConta);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("\n   ID: " + resultSet.getInt("ID") +
                        "\n   Data: " + resultSet.getDate("Data_Conta") +
                        "\n   Valor: " + resultSet.getDouble("Valor") +
                        "\n   Cliente: " + resultSet.getString("ID_Cliente") +
                        "\n   Impressão feita pelo funcionário: " + resultSet.getString("Matricula_Funcionario") +
                        "\n   Status: " + resultSet.getString("Status") +
                        "\n   Status da impressão: " + resultSet.getString("Status_Impressao"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
