package Nivel1;

import Nivel1.observer.*;

public class Main {
    public static void main(String[] args) {


        AgentBorsa agent = new AgentBorsa();
        new Agencia1Observador(agent);
        new Agencia2Observador(agent);
        new Agencia3Observador(agent);



        System.out.println("La bolsa sube!!!!! ");
        agent.setEstado("subido");
        System.out.println("-----------------");
        System.out.println("La bolsa bajaaaa!!!!! ");
        agent.setEstado("bajado");
    }
}