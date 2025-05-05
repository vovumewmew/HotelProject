package BUS;

import java.util.List;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;

public class KhachHangBUS {
    private KhachHangDAO khachHangDAO;

    public KhachHangBUS() {
        khachHangDAO = new KhachHangDAO();
    }

    public List<KhachHangDTO> getAllKhachHang() {
        return khachHangDAO.getAll();
    }

    public List<KhachHangDTO> getKhachHangByName(String name) {
        return khachHangDAO.getByName(name);
    }

    public KhachHangDTO getKhachHangById(String id) {
        return khachHangDAO.getById(id);
    }

    public boolean addKhachHang(KhachHangDTO kh) {
        return khachHangDAO.insert(kh);
    }

    public boolean updateKhachHang(KhachHangDTO kh) {
        return khachHangDAO.update(kh);
    }

    public boolean deleteKhachHangById(String id) {
        return khachHangDAO.deleteByID(id);
    }

    public boolean exists(String id) {
        return khachHangDAO.exists(id);
    }
}
