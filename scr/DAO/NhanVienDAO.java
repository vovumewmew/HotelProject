package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.NhanVienDTO;
import DTO.ChucVuDTO;

public class NhanVienDAO {
    private Connection conn;

    public NhanVienDAO()
    {
        conn = MySQLConnection.getConnection();
        try {
            if(conn!=null)
        {
            System.out.println("ket noi co so du lieu cho NhanVienDAO thanh cong");
        }
        else
        {
            System.err.println("ket noi co so du lieu cho NhanVienDAO that bai");
        }
        } catch (Exception e) {
            System.err.println("loi khi ket noi co so du lieu cho NhanVienDAO");
            e.printStackTrace();
        }
    }

    public List<NhanVienDTO> getAll()
    {
        List<NhanVienDTO> list = new ArrayList<>();
        String sql = "SELECT nv.*, cv.* FROM NHANVIEN nv JOIN CHUCVU cv ON nv.ID_CV = cv.ID_CV";

        try(PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    NhanVienDTO nv = new NhanVienDTO();
                    nv.setID_NV(rs.getString("ID_NV"));
                    nv.setTEN_NV(rs.getString("TEN_NV"));
                    nv.setSDT_NV(rs.getString("SDT_NV"));
                    nv.setCCCD_NV(rs.getString("CCCD_NV"));
                    nv.setEMAIL_NV(rs.getString("EMAIL"));
                    nv.setGIOITINH_NV(rs.getString("GIOITINH"));
                    nv.setTRANGTHAI_NV(rs.getString("TRANGTHAI_NV"));

                    ChucVuDTO cv = new ChucVuDTO();
                    cv.setID_CV(rs.getString("ID_CHUCVU"));
                    cv.setTEN_CV(rs.getString("TEN_CHUCVU"));

                    nv.setCHUCVU(cv);
                    list.add(nv);
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return list;
    }

    public List<NhanVienDTO> getByName(String name) {
        List<NhanVienDTO> list = new ArrayList<>();
        String sql = "SELECT nv.*, cv.* FROM NHANVIEN nv JOIN CHUCVU cv ON nv.ID_CV = cv.ID_CV WHERE TEN_NV LIKE ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setID_NV(rs.getString("ID_NV"));
                nv.setTEN_NV(rs.getString("TEN_NV"));
                nv.setSDT_NV(rs.getString("SDT_NV"));
                nv.setCCCD_NV(rs.getString("CCCD_NV"));
                nv.setEMAIL_NV(rs.getString("EMAIL"));
                nv.setGIOITINH_NV(rs.getString("GIOITINH"));
                nv.setTRANGTHAI_NV(rs.getString("TRANGTHAI_NV"));
                
                ChucVuDTO cv = new ChucVuDTO();
                cv.setID_CV(rs.getString("ID_CV"));
                cv.setTEN_CV(rs.getString("TEN_CV"));
    
                nv.setCHUCVU(cv); 
    
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public NhanVienDTO getById(String id) {
        String sql = "SELECT nv.*, cv.* FROM NHANVIEN nv JOIN CHUCVU cv ON nv.ID_CV = cv.ID_CV WHERE ID_NV = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setID_NV(rs.getString("ID_NV"));
                nv.setTEN_NV(rs.getString("TEN_NV"));
                nv.setSDT_NV(rs.getString("SDT_NV"));
                nv.setCCCD_NV(rs.getString("CCCD_NV"));
                nv.setEMAIL_NV(rs.getString("EMAIL"));
                nv.setGIOITINH_NV(rs.getString("GIOITINH"));
                nv.setTRANGTHAI_NV(rs.getString("TRANGTHAI_NV"));
    
                ChucVuDTO cv = new ChucVuDTO();
                cv.setID_CV(rs.getString("ID_CV"));
                cv.setTEN_CV(rs.getString("TEN_CV"));
                nv.setCHUCVU(cv);
    
                return nv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public boolean exists(String id) {
        String sql = "SELECT ID_NV FROM NHANVIEN WHERE ID_NV = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insert(NhanVienDTO nhanvien)
    {
        if (exists(nhanvien.getID_NV())) {
            System.out.println("Nhan vien da ton tai!");
            return false;
        }
        String sql = "INSERT INTO NHANVIEN(ID_NV, TEN_NV, EMAIL, SDT_NV, CCCD_NV, GIOITINH, TRANGTHAI_NV, ID_CHUCVU) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1,nhanvien.getID_NV());
            stmt.setString(2,nhanvien.getTEN_NV());
            stmt.setString(3, nhanvien.getEMAIL_NV());
            stmt.setString(4, nhanvien.getSDT_NV());
            stmt.setString(5, nhanvien.getCCCD_NV());
            stmt.setString(6, nhanvien.getGIOITINH_NV());
            stmt.setString(7,nhanvien.getTRANGTHAI_NV());
            stmt.setString(8,nhanvien.getCHUCVU().getID_CV());

            return stmt.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(NhanVienDTO nhanvien)
    {
        String sql = "UPDATE NHANVIEN SET TEN_NV = ?, EMAIL = ?, SDT_NV = ?, CCCD_NV = ?, GIOITINH = ?, TRANGTHAI_NV = ?, ID_CHUCVU = ? WHERE ID_NV = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, nhanvien.getTEN_NV());
            stmt.setString(2, nhanvien.getEMAIL_NV());
            stmt.setString(3, nhanvien.getSDT_NV());
            stmt.setString(4, nhanvien.getCCCD_NV());
            stmt.setString(5, nhanvien.getGIOITINH_NV());
            stmt.setString(6, nhanvien.getTRANGTHAI_NV());
            stmt.setString(7, nhanvien.getCHUCVU().getID_CV());
            stmt.setString(8, nhanvien.getID_NV());

            return stmt.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteByName(String TEN_NV)
    {
        String sql = "DELETE FROM NHANVIEN WHERE TEN_NV = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, TEN_NV);
            return stmt.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteById(String id_nv) {
        try {
            String sql = "DELETE FROM NHANVIEN WHERE ID_NV = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id_nv);
    
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    
}
