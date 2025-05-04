package UI.MainFrameUI.ThongKeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonThongKe extends JButton{

    public ButtonThongKe()
    {
        super();
        init();
    }
    private void init()
    {
        ImageIcon thongkeicon = new ImageIcon(ButtonThongKe.class.getResource("/pic/thongkeicon.png"));

        setPreferredSize(new Dimension(50,50));;
        setText("Thống Kê");
        setIcon(thongkeicon);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        ChangeColor();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public void ChangeColor() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setContentAreaFilled(true);
                setBackground(new Color(184, 226, 224));
            }
    
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setContentAreaFilled(false);
            }
        });
    }
}

