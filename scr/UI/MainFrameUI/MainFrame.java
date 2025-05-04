package UI.MainFrameUI;

import UI.MainFrameUI.DatPhongUI.*;
import UI.MainFrameUI.KhachHangUI.*;
import UI.MainFrameUI.LichSuUI.*;
import UI.MainFrameUI.NhanVienUI.*;
import UI.MainFrameUI.PhongUI.*;
import UI.MainFrameUI.ThongKeUI.*; 

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    public MainFrame()
    {
        super("Màn hình chính");
        init();
    }
    private Color mainColor = new Color(237, 253, 252);
    private void init() {
        setSize(600, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(false);
    
        ImageIcon backgroundIcon = new ImageIcon(MainFrame.class.getResource("/pic/mf.jpg")); 
        JLabel background = new JLabel(backgroundIcon);
        background.setLayout(new GridBagLayout());
        setContentPane(background);
    
        JPanel panel = SupPanel();
        background.add(panel);

    }
    
    JPanel SupPanel()
    {
        JPanel SupPanel = new JPanel(new BorderLayout());
        SupPanel.setPreferredSize(new Dimension(415,600));
        SupPanel.setBackground(Color.WHITE);
        SupPanel.setVisible(true);

        SupPanel.add(TopPanel(),BorderLayout.NORTH);

        JPanel mainButtonPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        mainButtonPanel.setBackground(mainColor);
        mainButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font buttonFont = new Font("Segoe UI", Font.PLAIN, 16);

        JButton btnDatPhong = new ButtonDatPhong();
        JButton btnPhong = new ButtonPhong();
        JButton btnKhachHang = new ButtonKhachHang();
        JButton btnNhanVien = new ButtonNhanVien();
        JButton btnThongKe = new ButtonThongKe();
        JButton btnLichSu = new ButtonLichSu();

        JButton[] buttons = {
            btnDatPhong, btnPhong, btnKhachHang,
            btnNhanVien, btnThongKe, btnLichSu
        };

        for (JButton btn : buttons) {
            btn.setFont(buttonFont);
            mainButtonPanel.add(btn);
        }

        SupPanel.add(mainButtonPanel, BorderLayout.CENTER);

        return SupPanel;
    }
    JPanel TopPanel()
    {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(mainColor);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnTaiKhoan = new ButtonThongTinCaNhan();
        JButton btnDangXuatTop = new ButtonDangXuat();

        Font topFont = new Font("Segoe UI", Font.PLAIN, 16);
        btnTaiKhoan.setFont(topFont);
        btnDangXuatTop.setFont(topFont);

        topPanel.add(btnTaiKhoan, BorderLayout.WEST);
        topPanel.add(btnDangXuatTop, BorderLayout.EAST);
        return topPanel;
    }
}
