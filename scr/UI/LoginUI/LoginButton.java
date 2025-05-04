package UI.LoginUI;

import UI.MainFrameUI.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButton extends JButton{
    public LoginButton()
    {
        super("Đăng nhập");
        init();
    }
    protected void init()
    {

        Font font = new Font("Segoe UI", Font.BOLD, 16);

        setBounds(130, 400, 125, 35);
        setFont(font);
        setBorderPainted(false); 
        setFocusPainted(false); 
        setOpaque(true); 
        setBackground(new Color(118, 209, 207));
        setForeground(Color.WHITE);

        ChangeColor();
        
    }
    public void Login(JTextField userField, JPasswordField passField)
    {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setBounds(130,0,100,300);
                add(panel);
                String username = userField.getText();
                String password = new String(passField.getPassword());
                
                if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane optionPane = new JOptionPane("Login successful", JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Thông báo");
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                    Window window = SwingUtilities.getWindowAncestor(LoginButton.this);
                    if (window != null) {
                    window.dispose();
                    }
                    MainFrame MF = new MainFrame();
                    MF.setVisible(true);
                } else {
                    JOptionPane optionPane = new JOptionPane("Invalid username or password", JOptionPane.ERROR_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Thông báo");
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
            }
        });
    }
    public void ChangeColor()
    {
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(69, 186, 183));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(118, 209, 207));
            }
        });
    }
}
