package Aplicacao;

import db.DB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DB.getConnection();

//        Funcionario funcionario = new Funcionario("Arthur Figueirêdo");
//        funcionario.addFuncionario();
//     --------------------------------------------------------------

//        Cliente cliente = new Cliente("José Vitor");
//        cliente.addCliente(connection);
//     --------------------------------------------------------------

//        Pedido pedido = new Pedido(3);
//        pedido.addPedido();
////     --------------------------------------------------------------
//
//
//        Pizza pizza = new Pizza("Camarão com Cream Cheese", 65.0, 3);
//        pizza.addPizza();
////     --------------------------------------------------------------
//
//
//        PedidoPizza pedidoPizza = new PedidoPizza(5, 3, 1);
//        pedidoPizza.addPedidoPizza();
////     --------------------------------------------------------------
//
//        Conta criarConta = new Conta(3, 70.0);
//        criarConta.criarConta();
//
//        Conta pagarConta = new Conta(3, 5);
//        pagarConta.pagarConta();

        Conta imprimirConta = new Conta(3, 5, 0);
        imprimirConta.imprimirConta(connection);
    }
}