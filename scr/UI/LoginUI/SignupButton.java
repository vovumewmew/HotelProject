package UI.LoginUI;

import javax.swing.*;
import java.awt.*;

public class SignupButton extends JButton {
    public SignupButton()
    {
        super("Đăng kí");
        init();
    }
    protected void init()
    {
        Font font = new Font("Segoe UI", Font.BOLD, 16);

        setBounds(130, 350, 125, 35);
        setFont(font);
        setBorderPainted(false); 
        setFocusPainted(false); 
        setOpaque(true); 
        setBackground(new Color(118, 209, 207));
        setForeground(Color.WHITE);

        ChangeColor();

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
