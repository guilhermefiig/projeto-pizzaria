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
}




//SELECT Pizza.Valor AS valor_pizza
//FROM PedidoPizza
//INNER JOIN Pizza ON PedidoPizza.ID_Pizza = Pizza.ID
//WHERE ID_Pedido = 2 and PedidoPizza.ID_Pizza IN (
//        SELECT ID_Pizza
//    FROM PedidoPizza
//            WHERE Valor = (SELECT Valor FROM Pizza WHERE ID = PedidoPizza.ID_Pizza)
//);