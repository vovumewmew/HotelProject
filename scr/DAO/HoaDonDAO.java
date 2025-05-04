package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import DTO.HoaDonDTO;
import DTO.PhieuDatPhongDTO;

public class HoaDonDAO {
    private Connection conn;

    public HoaDonDAO() {
        try {
            conn = MySQLConnection.getConnection();
            if (conn != null) {
                System.out.println("Kết nối cơ sở dữ liệu cho HoaDonDAO thành công.");
            } else {
                System.err.println("Kết nối cơ sở dữ liệu cho HoaDonDAO thất bại.");
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi kết nối CSDL:");
            e.printStackTrace();
        }
    }

    public ArrayList<HoaDonDTO> getAll() {
        ArrayList<HoaDonDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM HOADON";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setID_HD(rs.getString("ID_HD"));
                hd.setTONGTIEN_HD(rs.getFloat("TONGTIEN_HD"));
                hd.setNGAYLAP_HD(rs.getDate("NGAYLAP_HD"));

                PhieuDatPhongDTO pd = new PhieuDatPhongDAO().getById(rs.getString("ID_PHIEUDAT"));
                hd.setPD_HD(pd);

                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public HoaDonDTO getById(String id_hd) {
        String sql = "SELECT * FROM HOADON WHERE ID_HD = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_hd);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setID_HD(rs.getString("ID_HD"));
                hd.setTONGTIEN_HD(rs.getFloat("TONGTIEN_HD"));
                hd.setNGAYLAP_HD(rs.getDate("NGAYLAP_HD"));

                PhieuDatPhongDTO pd = new PhieuDatPhongDAO().getById(rs.getString("ID_PHIEUDAT"));
                hd.setPD_HD(pd);

                return hd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDonDTO> getByDate(Date ngay) {
    List<HoaDonDTO> list = new ArrayList<>();
    String sql = "SELECT * FROM HOADON WHERE NGAYLAP_HD = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setDate(1, new java.sql.Date(ngay.getTime()));
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            HoaDonDTO hd = new HoaDonDTO();
            hd.setID_HD(rs.getString("ID_HD"));
            hd.setTONGTIEN_HD(rs.getFloat("TONGTIEN_HD"));
            hd.setNGAYLAP_HD(rs.getDate("NGAYLAP_HD"));

            PhieuDatPhongDTO pd = new PhieuDatPhongDAO().getById(rs.getString("ID_PHIEUDAT"));
            hd.setPD_HD(pd);

            list.add(hd);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
    }

    public boolean insert(HoaDonDTO hd) {
        String sql = "INSERT INTO HOADON(ID_HD, TONGTIEN_HD, NGAYLAP_HD, ID_PHIEUDAT) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hd.getID_HD());
            stmt.setFloat(2, hd.getTONGTIEN_HD());
            stmt.setDate(3, new java.sql.Date(hd.getNGAYLAP_HD().getTime()));
            stmt.setString(4, hd.getPD_HD().getID_PD());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(HoaDonDTO hd) {
        String sql = "UPDATE HOADON SET TONGTIEN_HD = ?, NGAYLAP_HD = ?, ID_PHIEUDAT = ? WHERE ID_HD = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setFloat(1, hd.getTONGTIEN_HD());
            stmt.setDate(2, new java.sql.Date(hd.getNGAYLAP_HD().getTime()));
            stmt.setString(3, hd.getPD_HD().getID_PD());
            stmt.setString(4, hd.getID_HD());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id_hd) {
        String sql = "DELETE FROM HOADON WHERE ID_HD = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_hd);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

