package BUS;

import java.util.List;

import DAO.DichVuDAO;
import DTO.DichVuDTO;

public class DichVuBUS {
    private DichVuDAO dao;

    public DichVuBUS() {
        dao = new DichVuDAO();
    }

    public List<DichVuDTO> getAllDichVu() {
        return dao.getAll();
    }

    public DichVuDTO getDichVuById(String id) {
        return dao.getById(id);
    }

    public boolean addDichVu(DichVuDTO dv) {
        return dao.insert(dv);
    }

    public boolean updateDichVu(DichVuDTO dv) {
        return dao.update(dv);
    }

    public boolean deleteDichVuByName(String tenDV) {
        return dao.deleteByName(tenDV);
    }

    public boolean exists(String id) {
        return dao.exists(id);
    }
}
