package BUS;

import java.util.List;

import DAO.PhongDAO;
import DTO.PhongDTO;

public class PhongBUS {
    private PhongDAO phongDAO;

    public PhongBUS() {
        phongDAO = new PhongDAO();
    }

    public List<PhongDTO> getAll() {
        return phongDAO.getAll();
    }

    public PhongDTO getById(String id) {
        return phongDAO.getById(id);
    }

    public List<PhongDTO> getByTrangThai(String trangThai) {
        return phongDAO.getByTrangThai(trangThai);
    }

    public boolean addPhong(PhongDTO phong) {
        if (phongDAO.exists(phong.getID_PHG())) {
            System.out.println("Phòng đã tồn tại!");
            return false;
        }
        return phongDAO.insert(phong);
    }

    public boolean updatePhong(PhongDTO phong) {
        return phongDAO.update(phong);
    }

    public boolean deleteByName(String tenPhong) {
        return phongDAO.deletebyName(tenPhong);
    }
}

