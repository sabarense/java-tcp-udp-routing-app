import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Cliente extends JFrame {
    private JTextField txtIp, txtMensagem;

    public Cliente() {
        setTitle("Cliente de Redes - Trabalho Prático");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("IP do Servidor:"));
        txtIp = new JTextField("127.0.0.1"); // IP para teste local
        add(txtIp);

        add(new JLabel("Mensagem:"));
        txtMensagem = new JTextField("Teste de Rede");
        add(txtMensagem);

        JButton btnTcp = new JButton("Enviar via TCP");
        btnTcp.addActionListener(e -> enviarTCP());
        add(btnTcp);

        JButton btnUdp = new JButton("Enviar via UDP");
        btnUdp.addActionListener(e -> enviarUDP());
        add(btnUdp);

        setVisible(true);
    }

    private void enviarTCP() {
        new Thread(() -> {
            try (Socket socket = new Socket(txtIp.getText(), 5000);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                out.println(txtMensagem.getText());
                JOptionPane.showMessageDialog(this, "Mensagem TCP enviada!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro TCP: " + ex.getMessage());
            }
        }).start();
    }

    private void enviarUDP() {
        new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket()) {
                byte[] buffer = txtMensagem.getText().getBytes();
                InetAddress endereco = InetAddress.getByName(txtIp.getText());
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, endereco, 5001);
                socket.send(packet);
                JOptionPane.showMessageDialog(this, "Mensagem UDP enviada!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro UDP: " + ex.getMessage());
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Cliente());
    }
}
