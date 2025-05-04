package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.DichVuDTO;

public class DichVuDAO {
    private Connection conn;

    public DichVuDAO()
    {
        conn = MySQLConnection.getConnection();
        try {
            if(conn!=null)
        {
            System.out.println("ket noi co so du lieu cho DichVuDAO thanh cong");
        }
        else
        {
            System.err.println("ket noi co so du lieu cho DichVuDAO that bai");
        }
        } catch (Exception e) {
            System.out.println("loi khi ket noi co so du lieu cho DichVuDAO");
            e.printStackTrace();
        }
    }

    public List<DichVuDTO> getAll()
    {
        List<DichVuDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM DICHVU";

        try(PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    DichVuDTO dv = new DichVuDTO();
                    dv.setID_DV(rs.getString("ID_DV"));
                    dv.setTEN_DV(rs.getString("TEN_DV"));
                    dv.setDONGIA_DV(rs.getFloat("DONGIA_DV"));
                    dv.setMOTA_DV(rs.getString("MOTA_DV"));
                    
                    list.add(dv);
                }
            }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public DichVuDTO getById(String id)
    {
        String sql = "SELECT * FROM DICHVU WHERE ID_DV = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
                if(rs.next())
                {
                    DichVuDTO dv = new DichVuDTO();
                    dv.setID_DV(rs.getString("ID_DV"));
                    dv.setTEN_DV(rs.getString("TEN_DV"));
                    dv.setDONGIA_DV(rs.getFloat("DONGIA_DV"));
                    dv.setMOTA_DV(rs.getString("MOTA_DV"));
                    return dv;
                }
            } 
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return null;
    }

    public boolean exists(String id) {
        String sql = "SELECT ID_DV FROM DICHVU WHERE ID_DV = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insert(DichVuDTO dv)
    {
        if (exists(dv.getID_DV())) {
            System.out.println("Ma Dich Vu da ton tai!");
            return false;
        }
        String sql = "INSERT INTO DICHVU(ID_DV, TEN_DV, DONGIA_DV, MOTA_DV) VALUES (?, ?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, dv.getID_DV());
            stmt.setString(2, dv.getTEN_DV());
            stmt.setFloat(3, dv.getDONGIA_DV());
            stmt.setString(4, dv.getMOTA_DV());
            return stmt.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(DichVuDTO dv)
    {
        String sql = "UPDATE DICHVU SET TEN_DV = ?, DONGIA_DV = ?, MOTA_DV = ? WHERE ID_DV = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, dv.getTEN_DV());
            stmt.setFloat(2, dv.getDONGIA_DV()); 
            stmt.setString(3, dv.getMOTA_DV());
            stmt.setString(4, dv.getID_DV());

            return stmt.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteByName(String tenDV) {
        String sql = "DELETE FROM DICHVU WHERE TEN_DV = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tenDV);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
