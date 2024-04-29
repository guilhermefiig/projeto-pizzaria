package Aplicacao;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????
//????????????????????????????????????????????


public class Conta {
    private Date data;

    public static void criarConta(int idPedido, double valor){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO conta (ID_Pedido, Valor) VALUES (?, ?)");

            preparedStatement.setInt(1, idPedido);
            preparedStatement.setDouble(1, valor);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
        }
    }

    public static void pagarConta(int idCliente, int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE conta SET ID_Cliente = ?, Status = 'Pago' WHERE ID = ?");

            preparedStatement.setInt(1, idCliente);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
        }
    }

    public static void imprimirConta(int matricula, int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE conta SET Matricula_Funcionario = ?, Status_Impressao = 'Impresso' WHERE ID = ?");

            preparedStatement.setInt(1, matricula);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
        }
    }
}
