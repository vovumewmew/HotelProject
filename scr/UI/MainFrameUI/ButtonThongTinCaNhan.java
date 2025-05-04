package UI.MainFrameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonThongTinCaNhan extends JButton{
    public ButtonThongTinCaNhan()
    {
        super();
        init();
    }
    private void init()
    {
        ImageIcon canhanicon = new ImageIcon(ButtonThongTinCaNhan.class.getResource("/pic/canhanicon.png"));

        setPreferredSize(new Dimension(50,50));;
        setIcon(canhanicon);
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
