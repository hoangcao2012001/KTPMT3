package redis2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import org.json.JSONObject;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;
import entity.User;

public class UI2 extends JFrame {

    private JPanel contentPane;
    private JTextField txt_send;
    private JTextArea txt_noiDung;
    private Jedis jedis;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UI2 frame = new UI2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UI2() {
        jedis = new Jedis("redis://default:C98yuZu6LgZa0yR67fN9b2c8IEZAUVhE@redis-16530.c16.us-east-1-3.ec2.cloud.redislabs.com:16530");
        Connection connection = jedis.getConnection();
        setTitle("ACCOUNT2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btn_send = new JButton("send");
        btn_send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = txt_send.getText();
                sendMessage(message);
                txt_send.setText("");
            }
        });
        btn_send.setBounds(323, 227, 89, 23);
        contentPane.add(btn_send);

        txt_send = new JTextField();
        txt_send.setBounds(20, 227, 238, 21);
        contentPane.add(txt_send);
        txt_send.setColumns(10);

        txt_noiDung = new JTextArea();
        txt_noiDung.setBounds(20, 11, 404, 205);
        contentPane.add(txt_noiDung);

        displayMessage();

        // Tạo một luồng riêng để cập nhật tin nhắn mới liên tục
        Thread updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000); // Đợi 1 giây
                        updateMessage();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        updateThread.start();
    }

    private void sendMessage(String message) {
        String userName = jedis.get("User2");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("UserName", userName);
        jsonObject.put("Messager", message);
        jsonObject.put("age", 25);

        jedis.set("send2", jsonObject.toString());
    }

    private void displayMessage() {
        String jsonString = jedis.get("send2");
        Gson gson = new Gson();
        User user2 = gson.fromJson(jsonString, User.class);

        if (user2 != null) {
            String userName = user2.getUserName();
            String messager = user2.getMessager();
            int age = user2.getAge();

            txt_noiDung.append("UserName: " + userName + "\n");
            txt_noiDung.append("Age: " + age + "\n");
            txt_noiDung.append("Message: " + messager + "\n");
            txt_noiDung.append("----------------\n");
        }
    }

    private void updateMessage() {
        String jsonString = jedis.get("send1");
        Gson gson = new Gson();
        User user = gson.fromJson(jsonString, User.class);
        
        if (user != null) {
            String userName = user.getUserName();
            String messager = user.getMessager();
            int age = user.getAge();

            txt_noiDung.setText(""); // Xóa nội dung cũ trong JTextArea

            txt_noiDung.append("UserName: " + userName + "\n");
            txt_noiDung.append("Age: " + age + "\n");
            txt_noiDung.append("Message: " + messager + "\n");
           
            txt_noiDung.append("----------------\n");
        }
    }
}
