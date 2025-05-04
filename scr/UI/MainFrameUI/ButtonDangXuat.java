package UI.MainFrameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.LoginUI.LoginUI;

public class ButtonDangXuat extends JButton{
    public ButtonDangXuat()
    {
        super();
        init();
    }
    private void init()
    {
        ImageIcon dangxuaticon = new ImageIcon(ButtonDangXuat.class.getResource("/pic/dangxuaticon.png"));

        setPreferredSize(new Dimension(50,50));;
        setIcon(dangxuaticon);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        ChangeColor();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        LogOut();
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
    public void LogOut()
    {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int result = JOptionPane.showConfirmDialog(
    null,
            "Bạn có chắc là muốn thoát chứ?",
              "Xác nhận thoát",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                if(result == JOptionPane.YES_OPTION)
                {
                    Window window = SwingUtilities.getWindowAncestor(ButtonDangXuat.this);
                    if (window != null) {
                    window.dispose();
                    }
                    JFrame lgf = new LoginUI();
                    lgf.setVisible(true);
                }
            }
        });
    }
}
