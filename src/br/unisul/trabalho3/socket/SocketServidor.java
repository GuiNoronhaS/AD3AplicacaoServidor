package br.unisul.trabalho3.socket;

import br.unisul.trabalho3.model.JogosEletronicos;
import java.net.*;
import java.io.*;

/**
 * Classe que faz a conexão com a Aplicação CLiente que ira enviar os Objetos
 * que serão recebidos e lidos no console
 *
 * @author Guilherme Noronha
 */
public class SocketServidor {

    ServerSocket servidor;

    /**
     * Cria o Socket Servidor que vai ser utilizado no Trabalho
     *
     */
    public SocketServidor() {
        try {
            servidor = new ServerSocket(4444);
        } catch (IOException io) {
            System.err.println("Problema de IO");
        }
    }

    /**
     * Abre a conexão do servidor, esperando pelo Cliente para poder receber e
     * ler os objetos.
     *
     */
    public void execute() {
        try {
            System.out.println("Aguardando Cliente Conectar!");
            Socket cliente = servidor.accept();
            System.out.println("Cliente: " + cliente.getInetAddress().getHostAddress() + " se Conectou!");
            ObjectInputStream oIS = new ObjectInputStream(cliente.getInputStream());
            JogosEletronicos recebido = (JogosEletronicos) oIS.readObject();
            while (recebido.getId() != 0) {
                System.out.println(recebido.showDados());
                recebido = (JogosEletronicos) oIS.readObject();
            }
            if (recebido.getId() == 0) {
                System.out.println("Conexão esta sendo terminada!");
                oIS.close();
                cliente.close();
                servidor.close();
            }
        } catch (IOException io) {
            System.err.println("Problema de IO");
        } catch (ClassNotFoundException e) {
            System.err.println("Problema de Classe");
        }
    }

}
