package ru_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import ru_network.TCPConnection;
import ru_network.TCPConnectionListener;

public class ChatServer implements TCPConnectionListener{

    public static void main(String[] args) {
        new ChatServer();
    }

    private final ArrayList<TCPConnection> connections = new ArrayList<>();
    private ChatServer() {
        System.out.println("Server running...");
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            while (true) {
                try {
                    new TCPConnection(this, serverSocket.accept());
                } catch (IOException e) {
                    System.err.println("TCPConnection exception: " + e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {

    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {

    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {

    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {

    }

}
