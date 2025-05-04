package UI.MainFrameUI.NhanVienUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonNhanVien extends JButton{

    public ButtonNhanVien()
    {
        super();
        init();
    }
    private void init()
    {
        ImageIcon nhanvienicon = new ImageIcon(ButtonNhanVien.class.getResource("/pic/nhanvienicon.png"));

        setPreferredSize(new Dimension(50,50));;
        setText("Nhân viên");
        setIcon(nhanvienicon);
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


