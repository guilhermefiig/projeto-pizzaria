package Aplicacao;


import java.sql.*;

public class PedidoPizza {
    private int idPedido;
    private int idPizza;
    private int quantidade;

    public PedidoPizza(int idPedido, int idPizza, int quantidade) {
        this.idPedido = idPedido;
        this.idPizza = idPizza;
        this.quantidade = quantidade;
    }

    public void addPedidoPizza(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO pedidopizza (ID_Pedido, ID_Pizza, quantidade_pizza) VALUES (?, ?, ?)");

            preparedStatement.setInt(1, idPedido);
            preparedStatement.setInt(2, idPizza);
            preparedStatement.setInt(3, quantidade);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void valorPizzas(Connection connection){
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT Pizza.Valor AS valor_pizza\n" +
                            "FROM PedidoPizza\n" +
                            "INNER JOIN Pizza ON PedidoPizza.ID_Pizza = Pizza.ID\n" +
                            "WHERE ID_Pedido = ? and PedidoPizza.ID_Pizza IN (\n" +
                            "    SELECT ID_Pizza\n" +
                            "    FROM PedidoPizza\n" +
                            "    WHERE Valor = (SELECT Valor FROM Pizza WHERE ID = PedidoPizza.ID_Pizza)\n" +
                            ");"
            );

            preparedStatement.setInt(1, 1);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
