package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;

public class TaiKhoanDAO {
    private Connection conn;

    public TaiKhoanDAO() {
        try {
            conn = MySQLConnection.getConnection();
            if (conn != null) {
                System.out.println("Kết nối CSDL thành công (TaiKhoanDAO)");
            } else {
                System.err.println("Kết nối CSDL thất bại (TaiKhoanDAO)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TaiKhoanDTO> getAll() {
        List<TaiKhoanDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM TAIKHOAN";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setID_TK(rs.getString("ID_TK"));
                tk.setUSERNAME(rs.getString("USERNAME"));
                tk.setPASSWORD(rs.getString("PASSWORD"));

                String id_nv = rs.getString("ID_NV");
                String id_kh = rs.getString("ID_KH");

                if (id_nv != null) {
                    tk.setNhanVien_TK(new NhanVienDAO().getById(id_nv));
                } else if (id_kh != null) {
                    tk.setKhachHang_TK(new KhachHangDAO().getById(id_kh));
                }

                list.add(tk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public TaiKhoanDTO getByUsername(String username) {
        String sql = "SELECT * FROM TAIKHOAN WHERE USERNAME = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setID_TK(rs.getString("ID_TK"));
                tk.setUSERNAME(rs.getString("USERNAME"));
                tk.setPASSWORD(rs.getString("PASSWORD"));

                String id_nv = rs.getString("ID_NV");
                String id_kh = rs.getString("ID_KH");

                if (id_nv != null) {
                    tk.setNhanVien_TK(new NhanVienDAO().getById(id_nv));
                } else if (id_kh != null) {
                    tk.setKhachHang_TK(new KhachHangDAO().getById(id_kh));
                }

                return tk;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TaiKhoanDTO checkLogin(String username, String password) {
        String sql = "SELECT * FROM TAIKHOAN WHERE USERNAME = ? AND PASSWORD = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setID_TK(rs.getString("ID_TK"));
                tk.setUSERNAME(rs.getString("USERNAME"));
                tk.setPASSWORD(rs.getString("PASSWORD"));
    
                String id_nv = rs.getString("ID_NV");
                String id_kh = rs.getString("ID_KH");
    
                if (id_nv != null) {
                    tk.setNhanVien_TK(new NhanVienDAO().getById(id_nv));
                } else if (id_kh != null) {
                    tk.setKhachHang_TK(new KhachHangDAO().getById(id_kh));
                }
    
                return tk;  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  
    }
    
    public boolean insert(TaiKhoanDTO tk) {
        String sql = "INSERT INTO TAIKHOAN(ID_TK, USERNAME, PASSWORD, ID_NV, ID_KH) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tk.getID_TK());
            stmt.setString(2, tk.getUSERNAME());
            stmt.setString(3, tk.getPASSWORD());

            if (tk.getNhanVien_TK() != null) {
                stmt.setString(4, tk.getNhanVien_TK().getID_NV());
                stmt.setNull(5, java.sql.Types.VARCHAR);
            } else if (tk.getKhachHang_TK() != null) {
                stmt.setNull(4, java.sql.Types.VARCHAR);
                stmt.setString(5, tk.getKhachHang_TK().getID_KH());
            } else {
                stmt.setNull(4, java.sql.Types.VARCHAR);
                stmt.setNull(5, java.sql.Types.VARCHAR);
            }

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(TaiKhoanDTO tk) {
        String sql = "UPDATE TAIKHOAN SET USERNAME = ?, PASSWORD = ?, ID_NV = ?, ID_KH = ? WHERE ID_TK = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tk.getUSERNAME());
            stmt.setString(2, tk.getPASSWORD());

            if (tk.getNhanVien_TK() != null) {
                stmt.setString(3, tk.getNhanVien_TK().getID_NV());
                stmt.setNull(4, java.sql.Types.VARCHAR);
            } else if (tk.getKhachHang_TK() != null) {
                stmt.setNull(3, java.sql.Types.VARCHAR);
                stmt.setString(4, tk.getKhachHang_TK().getID_KH());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
                stmt.setNull(4, java.sql.Types.VARCHAR);
            }

            stmt.setString(5, tk.getID_TK());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM TAIKHOAN WHERE ID_TK = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

