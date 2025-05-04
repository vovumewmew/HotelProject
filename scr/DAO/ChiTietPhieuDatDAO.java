package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChiTietPhieuDatDTO;
import DTO.PhieuDatPhongDTO;
import DTO.PhongDTO;

public class ChiTietPhieuDatDAO {
    private Connection conn;

    public ChiTietPhieuDatDAO()
    {
        try
        {
            conn = MySQLConnection.getConnection();
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

    public ArrayList<ChiTietPhieuDatDTO> getAllByPhieu(String id_pd) {
        ArrayList<ChiTietPhieuDatDTO> dsCT = new ArrayList<>();
        String sql = "SELECT * FROM CHITIETPHIEUDAT WHERE ID_PHIEUDAT = ?";
    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_pd);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ChiTietPhieuDatDTO ct = new ChiTietPhieuDatDTO();
    
                ct.setTONGTIEN_CTPD(rs.getFloat("TONGTIEN_CTPHIEUDAT"));
                ct.setTRANGTHAI_CTPD(rs.getString("TRANGTHAI"));
    
                PhieuDatPhongDTO pd = new PhieuDatPhongDAO().getById(rs.getString("ID_PHIEUDAT"));
                ct.setPhieuDat_CTPD(pd);
    
                PhongDTO phong = new PhongDAO().getById(rs.getString("ID_PHG")); // Cần có hàm này trong PhongDAO
                ct.setPhong_CTPD(phong);
    
                dsCT.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return dsCT;
    }
    
    public boolean insert(ChiTietPhieuDatDTO ct) {
        String sql = "INSERT INTO CHITIETPHIEUDAT(ID_PHIEUDAT, ID_PHG, TONGTIEN_CTPHIEUDAT, TRANGTHAI) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ct.getPhieuDat_CTPD().getID_PD());
            stmt.setString(2, ct.getPhong_CTPD().getID_PHG());
            stmt.setFloat(3, ct.getTONGTIEN_CTPD());
            stmt.setString(4, ct.getTRANGTHAI_CTPD());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ChiTietPhieuDatDTO> getById(String idPD) {
        ArrayList<ChiTietPhieuDatDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM CHITIETPHIEUDAT WHERE ID_PHIEUDAT = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idPD);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ChiTietPhieuDatDTO ct = new ChiTietPhieuDatDTO();
                    ct.setTONGTIEN_CTPD(rs.getInt("TONGTIEN_CTPHIEUDAT"));
                    ct.setTRANGTHAI_CTPD(rs.getString("TRANGTHAI"));

                    PhieuDatPhongDTO pd = new PhieuDatPhongDTO();
                    pd.setID_PD(rs.getString("ID_PHIEUDAT"));
                    ct.setPhieuDat_CTPD(pd);

                    PhongDTO phong = new PhongDAO().getById(rs.getString("ID_PHG"));
                    ct.setPhong_CTPD(phong);

                    list.add(ct);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean update(ChiTietPhieuDatDTO ct) {
        String sql = "UPDATE CHITIETPHIEUDAT SET TONGTIEN_CTPHIEUDAT = ?, TRANGTHAI = ? WHERE ID_PHIEUDAT = ? AND ID_PHG = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setFloat(1, ct.getTONGTIEN_CTPD());
            stmt.setString(2, ct.getTRANGTHAI_CTPD());
            stmt.setString(3, ct.getPhieuDat_CTPD().getID_PD());
            stmt.setString(4, ct.getPhong_CTPD().getID_PHG());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteByPhieuAndPhong(String id_pd, String id_phong) {
        String sql = "DELETE FROM CHITIETPHIEUDAT WHERE ID_PHIEUDAT = ? AND ID_PHG = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_pd);
            stmt.setString(2, id_phong);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAllByPhieu(String id_pd) {
        String sql = "DELETE FROM CHITIETPHIEUDAT WHERE ID_PHIEUDAT = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_pd);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
