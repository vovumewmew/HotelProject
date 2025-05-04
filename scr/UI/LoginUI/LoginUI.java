package UI.LoginUI;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    public LoginUI() {
        setTitle("Đăng nhập");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(false);
        setLayout(null);

        ImageIcon backgroundIcon = new ImageIcon(LoginUI.class.getResource("/pic/pg.jpg")); 
        JLabel background = new JLabel(backgroundIcon);
        background.setBounds(0, 0, 400, 500);
        background.setLayout(null);
        setContentPane(background);


        Font font = new Font("Segoe UI", Font.PLAIN, 16);

        JLabel userLabel = new JLabel("Tài Khoản");
        userLabel.setBounds(50, 140, 300, 30);
        userLabel.setFont(font);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(50, 170, 300, 30);
        userField.setFont(font);
        userField.setBorder(null);
        userField.setOpaque(false);
        userField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        add(userField);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(50, 200, 300, 1);
        add(sep1);

        JLabel passLabel = new JLabel("Mật Khẩu");
        passLabel.setBounds(50, 220, 300, 30);
        passLabel.setFont(font);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(50, 250, 300, 30);
        passField.setFont(font);
        passField.setBorder(null);
        passField.setOpaque(false);
        passField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        add(passField);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(50, 280, 300, 1);
        add(sep2);

        LoginButton Lb = new LoginButton();
        Lb.Login(userField, passField);
        add(Lb);

        SignupButton Sb = new SignupButton();
        add(Sb);
    }
}

