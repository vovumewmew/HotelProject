package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.KhachHangDTO;
public class KhachHangDAO {
    private Connection conn;

    public KhachHangDAO()
    {
        try
        {
            conn = MySQLConnection.getConnection();
            if(conn!=null)
            {
                System.out.println("ket noi co so du lieu cho KhachHangDAO thang cong");
            }
            else
            {
                System.err.println("ket noi co so du lieu cho KhachHangDAO that bai");
            }
        }
        catch(Exception e)
        {
            System.err.println("Loi ket noi co so du lieu");
            e.printStackTrace();
        }
    }

    public List<KhachHangDTO> getAll()
    {
        List<KhachHangDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG";

        try(PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
        {
            while(rs.next())
            {
                KhachHangDTO k = new KhachHangDTO();
                k.setID_KH(rs.getString("ID_KH"));
                k.setTEN_KH(rs.getString("TEN_KH"));
                k.setGIOITINH_KH(rs.getString("GIOITINH"));
                k.setSDT_KH(rs.getString("SDT_KH"));
                k.setCCCD_KH(rs.getString("CCCD_KH"));
                k.setEMAIL_KH(rs.getString("EMAIL_KH"));
                k.setTRANGTHAI_KH(rs.getString("TRANGTHAI_KH"));

                list.add(k);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public List<KhachHangDTO> getByName(String tenKhachHang) {
        List<KhachHangDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG WHERE TEN_KH LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + tenKhachHang + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                KhachHangDTO k = new KhachHangDTO();
                k.setID_KH(rs.getString("ID_KH"));
                k.setTEN_KH(rs.getString("TEN_KH"));
                k.setGIOITINH_KH(rs.getString("GIOITINH"));
                k.setSDT_KH(rs.getString("SDT_KH"));
                k.setCCCD_KH(rs.getString("CCCD_KH"));
                k.setEMAIL_KH(rs.getString("EMAIL_KH"));
                k.setTRANGTHAI_KH(rs.getString("TRANGTHAI_KH"));
                list.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhachHangDTO getById(String id) {
        String sql = "SELECT * FROM KHACHHANG WHERE ID_KH = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                KhachHangDTO k = new KhachHangDTO();
                k.setID_KH(rs.getString("ID_KH"));
                k.setTEN_KH(rs.getString("TEN_KH"));
                k.setGIOITINH_KH(rs.getString("GIOITINH"));
                k.setSDT_KH(rs.getString("SDT_KH"));
                k.setCCCD_KH(rs.getString("CCCD_KH"));
                k.setEMAIL_KH(rs.getString("EMAIL_KH"));
                k.setTRANGTHAI_KH(rs.getString("TRANGTHAI_KH"));
                return k;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean exists(String id) {
        String sql = "SELECT ID_KH FROM KHACHHANG WHERE ID_KH = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insert(KhachHangDTO khachhang)
    {
        if (exists(khachhang.getID_KH())) {
            System.out.println("Ma Khach hang da ton tai!");
            return false;
        }
        String sql = "INSERT INTO KHACHHANG(ID_KH, TEN_KH, EMAIL_KH, SDT_KH, CCCD_KH, GIOITINH_KH, TRANGTHAI_KH) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1,khachhang.getID_KH());
            stmt.setString(2,khachhang.getTEN_KH());
            stmt.setString(3, khachhang.getEMAIL_KH());
            stmt.setString(4, khachhang.getSDT_KH());
            stmt.setString(5, khachhang.getCCCD_KH());
            stmt.setString(6, khachhang.getGIOITINH_KH());
            stmt.setString(7,khachhang.getTRANGTHAI_KH());
            return stmt.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(KhachHangDTO khachhang)
    {
        String sql = "UPDATE KHACHHANG SET TEN_KH = ?, GIOITINH = ?, SDT_KH = ?, CCCD_KH = ?, EMAIL_KH = ?, TRANGTHAI_KH = ? WHERE ID_KH = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, khachhang.getTEN_KH());
            stmt.setString(2, khachhang.getGIOITINH_KH());
            stmt.setString(3, khachhang.getSDT_KH());
            stmt.setString(4, khachhang.getCCCD_KH());
            stmt.setString(5, khachhang.getEMAIL_KH());
            stmt.setString(6, khachhang.getTRANGTHAI_KH());
            stmt.setString(7, khachhang.getID_KH());
            return stmt.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteByID(String id) {
        String sql = "DELETE FROM KHACHHANG WHERE ID_KH = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
