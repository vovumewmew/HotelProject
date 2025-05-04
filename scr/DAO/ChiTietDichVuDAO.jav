package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.ChiTietDichVuDTO;
import DTO.DichVuDTO;
import DTO.PhieuDatPhongDTO;

public class ChiTietDichVuDAO {
    private Connection conn;

    public ChiTietDichVuDAO() {
        try {
            conn = MySQLConnection.getConnection();
            if (conn != null) {
                System.out.println("ket noi csdl ChiTietDichVuDAO thanh cong");
            } else {
                System.err.println("ket noi csdl ChiTietDichVuDAO that bai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ChiTietDichVuDTO> getAll() {
        List<ChiTietDichVuDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM CHITIETDICHVU";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ChiTietDichVuDTO ct = new ChiTietDichVuDTO();

                DichVuDTO dv = new DichVuDTO();
                dv.setID_DV(rs.getString("ID_DV"));

                PhieuDatPhongDTO pd = new PhieuDatPhongDTO();
                pd.setID_PD(rs.getString("ID_PHIEUDAT"));

                ct.setDV_CTDV(dv);
                ct.setPD_CTDV(pd);
                ct.setSOLUONGDV_CTDV(rs.getInt("SOLUONG_DV"));
                ct.setTONGTIENDV_CTDV(rs.getFloat("TONGTIEN_DV"));

                list.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(ChiTietDichVuDTO ct) {
        String sql = "INSERT INTO CHITIETDICHVU(ID_DV, ID_PHIEUDAT, SOLUONG_DV, TONGTIEN_DV) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ct.getDV_CTDV().getID_DV());
            stmt.setString(2, ct.getPD_CTDV().getID_PD());
            stmt.setInt(3, ct.getSOLUONGDV_CTDV());
            stmt.setFloat(4, ct.getTONGTIENDV_CTDV());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(ChiTietDichVuDTO ct) {
        String sql = "UPDATE CHITIETDICHVU SET SOLUONG_DV = ?, TONGTIEN_DV = ? WHERE ID_DV = ? AND ID_PHIEUDAT = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ct.getSOLUONGDV_CTDV());
            stmt.setFloat(2, ct.getTONGTIENDV_CTDV());
            stmt.setString(3, ct.getDV_CTDV().getID_DV());
            stmt.setString(4, ct.getPD_CTDV().getID_PD());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String idDV, String idPhieuDat) {
        String sql = "DELETE FROM CHITIETDICHVU WHERE ID_DV = ? AND ID_PHIEUDAT = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idDV);
            stmt.setString(2, idPhieuDat);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
