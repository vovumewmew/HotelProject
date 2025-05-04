package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.PhieuDatPhongDTO;

public class PhieuDatPhongDAO {
    private Connection conn;
    public PhieuDatPhongDAO()
    {
        conn = MySQLConnection.getConnection();
        try
        {
            if(conn!=null)
            {
                System.out.println("ket noi co so du lieu cho PhieuDatPhongDAO thanh cong");
            }
            else
            {
                System.err.println("ket noi co so du lieu cho PhieuDatPhongDAO that bai");
            }
        }
        catch(Exception e)
        {
            System.err.println("loi khi ket noi co so du lieu");
            e.printStackTrace();
        }
    }

    public ArrayList<PhieuDatPhongDTO> getAll() {
        ArrayList<PhieuDatPhongDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM PHIEUDATPHONG";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PhieuDatPhongDTO pd = new PhieuDatPhongDTO();
                pd.setID_PD(rs.getString("ID_PHIEUDAT"));
                pd.setNGAYDAT(rs.getDate("NGAYDAT"));
                pd.setNGAYTRA(rs.getDate("NGAYTRA"));

                KhachHangDTO kh = new KhachHangDAO().getById(rs.getString("ID_KH"));
                pd.setKhachHangPD(kh);

                NhanVienDTO nv = new NhanVienDAO().getById(rs.getString("ID_NV"));
                pd.setNhanVienPD(nv);

                list.add(pd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean exists(String id) {
        String sql = "SELECT ID_PHIEUDAT FROM PHIEUDATPHONG WHERE ID_PHIEUDAT = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insert(PhieuDatPhongDTO pd) {

        if (exists(pd.getID_PD())) {
            System.out.println("Phieu dat phong da ton tai!");
            return false;
        }
        
        if (pd.getNhanVienPD() == null || pd.getKhachHangPD() == null) {
            System.err.println("Nhan vien hoac khach hang bi null");
            return false;
        }

        String sql = "INSERT INTO PHIEUDATPHONG(ID_PHIEUDAT, NGAYDAT, NGAYTRA, ID_KH, ID_NV) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pd.getID_PD());
            stmt.setDate(2, new java.sql.Date(pd.getNGAYDAT().getTime()));
            stmt.setDate(3, new java.sql.Date(pd.getNGAYTRA().getTime()));
            stmt.setString(4, pd.getKhachHangPD().getID_KH());
            stmt.setString(5, pd.getNhanVienPD().getID_NV());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(PhieuDatPhongDTO pd) {
        if (pd.getNhanVienPD() == null || pd.getKhachHangPD() == null) {
            System.err.println("Nhan vien hoac khach hang bi null");
            return false;
        }

        String sql = "UPDATE PHIEUDATPHONG SET NGAYDAT = ?, NGAYTRA = ?, ID_KH = ?, ID_NV = ? WHERE ID_PHIEUDAT = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(pd.getNGAYDAT().getTime()));
            stmt.setDate(2, new java.sql.Date(pd.getNGAYTRA().getTime()));
            stmt.setString(3, pd.getKhachHangPD().getID_KH());
            stmt.setString(4, pd.getNhanVienPD().getID_NV());
            stmt.setString(5, pd.getID_PD());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id_pd) {
        String sql = "DELETE FROM PHIEUDATPHONG WHERE ID_PHIEUDAT = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_pd);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public PhieuDatPhongDTO getById(String id) {
        String sql = "SELECT * FROM PHIEUDATPHONG WHERE ID_PHIEUDAT = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                PhieuDatPhongDTO pd = new PhieuDatPhongDTO();
                pd.setID_PD(rs.getString("ID_PHIEUDAT"));
                pd.setNGAYDAT(rs.getDate("NGAYDAT"));
                pd.setNGAYTRA(rs.getDate("NGAYTRA"));
    
                String id_kh = rs.getString("ID_KH");
                KhachHangDTO kh = new KhachHangDAO().getById(id_kh); 
                pd.setKhachHangPD(kh);

                String id_nv = rs.getString("ID_NV");
                NhanVienDTO nv = new NhanVienDAO().getById(id_nv); 
                pd.setNhanVienPD(nv);
    
                return pd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
