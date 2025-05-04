package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.LoaiPhongDTO;
import DTO.PhongDTO;


public class PhongDAO {
    private Connection conn;

    public PhongDAO()
    {
        try
        {
            conn = MySQLConnection.getConnection();
            if(conn!=null)
            {
                System.out.println("ket noi co so du lieu cho lop PhongDAO thanh cong");
            }
            else
            {
                System.err.println("ket noi du lieu cho lop PhongDAO that bai");
            }
        }
        catch(Exception e)
        {
            System.err.println("loi khi ket noi co so du lieu cho PhongDAO");
            e.printStackTrace();
        }
    }

    public List<PhongDTO> getAll()
    {
        List<PhongDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM PHONG";

        try(PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
            {
                while (rs.next()) {
                    PhongDTO p = new PhongDTO();
                    p.setID_PHG(rs.getString("ID_PHG"));
                    p.setTEN_PHG(rs.getString("TEN_PHG"));
                    p.setTINHTRANG_PHG(rs.getString("TINHTRANG_PHG"));

                    LoaiPhongDTO loai = new LoaiPhongDTO();
                    loai.setID_LOAIPHG(rs.getString("ID_LOAIPHG"));
                    loai.setTEN_LOAIPHG(rs.getString("TEN_LOAIHG"));
                    loai.setDONGIA_PHG(rs.getInt("DONGIA_PHG"));
                    loai.setMOTA_LOAIPHG(rs.getString("MOTA_PHG"));
                    loai.setTRANGTHAI_LOAIPHG(rs.getString("TRANGTHAI_LOAIPHG"));

                    p.setLOAIPHONG(loai);
                    list.add(p);
                }
            }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public PhongDTO getById(String id)
    {
        String sql = "SELECT p.*, lp.* FROM PHONG p JOIN LOAIPHONG lp ON p.ID_LP = lp.ID_LP WHERE p.ID_PHG = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            stmt.setString(1, id);
            if (rs.next()) {
                LoaiPhongDTO lp = new LoaiPhongDTO();
                lp.setID_LOAIPHG(rs.getString("ID_LOAIPHG"));
                lp.setTEN_LOAIPHG(rs.getString("TEN_LOAIPHG"));
                lp.setDONGIA_PHG(rs.getInt("DONGIA_PHG"));
                lp.setMOTA_LOAIPHG(rs.getString("MOTA_PHG"));
                lp.setTRANGTHAI_LOAIPHG(rs.getString("TRANGTHAI_LOAIHG"));
    
                PhongDTO phong = new PhongDTO();
                phong.setID_PHG(rs.getString("ID_PHG"));
                phong.setTEN_PHG(rs.getString("TEN_PHG"));
                phong.setTINHTRANG_PHG(rs.getString("TINHTRANG_PHG"));
                phong.setLOAIPHONG(lp);
                return phong;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean exists(String id) {
        String sql = "SELECT ID_PHG FROM PHONG WHERE ID_PHG = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insert(PhongDTO phong)
    {
        if (exists(phong.getID_PHG())) {
            System.out.println("Ma Phong da ton tai!");
            return false;
        }
        String sql = "INSERT INTO PHONG(ID_PHG, TEN_PHG, TINHTRANG_PHG, ID_LP) VALUES (?, ?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1,phong.getID_PHG());
            stmt.setString(2,phong.getTEN_PHG());
            stmt.setString(3,phong.getTINHTRANG_PHG());
            stmt.setString(4,phong.getLOAIPHONG().getID_LOAIPHG());
            return stmt.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(PhongDTO phong)
    {
        String sql = "UPDATE PHONG SET TEN_PHG = ?, TINHTRANG_PHG = ?, ID_LP = ? WHERE ID_PHG = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, phong.getTEN_PHG());
            stmt.setString(2, phong.getTINHTRANG_PHG());
            stmt.setString(3, phong.getLOAIPHONG().getID_LOAIPHG());
            stmt.setString(4, phong.getID_PHG()); 

            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deletebyName(String TEN_PHG)
    {
        String sql = "DELETE FROM PHONG WHERE TEN_PHG = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, TEN_PHG);
            return stmt.executeUpdate()>0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
