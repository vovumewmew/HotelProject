package BUS;

import java.util.List;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;

public class NhanVienBUS {
    private NhanVienDAO nhanVienDAO;

    public NhanVienBUS() {
        nhanVienDAO = new NhanVienDAO();
    }

    public List<NhanVienDTO> getAllNhanVien() {
        return nhanVienDAO.getAll();
    }

    public List<NhanVienDTO> getNhanVienByName(String ten) {
        return nhanVienDAO.getByName(ten);
    }

    public NhanVienDTO getNhanVienById(String id) {
        return nhanVienDAO.getById(id);
    }

    public boolean exists(String id) {
        return nhanVienDAO.exists(id);
    }

    public boolean addNhanVien(NhanVienDTO nv) {
        return nhanVienDAO.insert(nv);
    }

    public boolean updateNhanVien(NhanVienDTO nv) {
        return nhanVienDAO.update(nv);
    }

    public boolean deleteNhanVienById(String id) {
        return nhanVienDAO.deleteById(id);
    }

    public boolean deleteNhanVienByName(String ten) {
        return nhanVienDAO.deleteByName(ten);
    }
}

