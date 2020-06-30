package br.unisul.trabalho3.main;

import br.unisul.trabalho3.socket.SocketServidor;

/**
 * Main da Aplicação Servidor
 *
 * @author Guilherme Noronha
 */
public class Trabalho3TopicosAvancadosServidor {

    public static void main(String[] args) {
        SocketServidor servidor = new SocketServidor();
        servidor.execute();
    }
    
}
