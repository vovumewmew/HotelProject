package BUS;

import java.util.ArrayList;
import DAO.PhieuDatPhongDAO;
import DTO.PhieuDatPhongDTO;

public class PhieuDatPhongBUS {
    private PhieuDatPhongDAO dao;

    public PhieuDatPhongBUS() {
        dao = new PhieuDatPhongDAO();
    }

    public ArrayList<PhieuDatPhongDTO> getAllPhieuDatPhong() {
        return dao.getAll();
    }

    public PhieuDatPhongDTO getById(String id) {
        return dao.getById(id);
    }

    public boolean exists(String id) {
        return dao.exists(id);
    }

    public boolean addPhieuDatPhong(PhieuDatPhongDTO pd) {
        return dao.insert(pd);
    }

    public boolean updatePhieuDatPhong(PhieuDatPhongDTO pd) {
        return dao.update(pd);
    }

    public boolean deletePhieuDatPhong(String id) {
        return dao.delete(id);
    }
}

