import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("Servidor iniciado...");

        // Thread para TCP
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(5000)) {
                System.out.println("Servidor TCP escutando na porta 5000...");
                while (true) {
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String mensagem = in.readLine();
                    System.out.println("[TCP Recebido]: " + mensagem);
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Thread para UDP
        new Thread(() -> {
            try (DatagramSocket udpSocket = new DatagramSocket(5001)) {
                System.out.println("Servidor UDP escutando na porta 5001...");
                byte[] buffer = new byte[1024];
                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    udpSocket.receive(packet);
                    String mensagem = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("[UDP Recebido]: " + mensagem);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
