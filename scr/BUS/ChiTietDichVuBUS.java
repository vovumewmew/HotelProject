package BUS;

import java.util.ArrayList;
import java.util.List;

import DAO.ChiTietDichVuDAO;
import DTO.ChiTietDichVuDTO;

public class ChiTietDichVuBUS {
    private ChiTietDichVuDAO dao;

    public ChiTietDichVuBUS() {
        dao = new ChiTietDichVuDAO();
    }

    public List<ChiTietDichVuDTO> getAll() {
        return dao.getAll();
    }

    public boolean add(ChiTietDichVuDTO ct) {
        return dao.insert(ct);
    }

    public boolean update(ChiTietDichVuDTO ct) {
        return dao.update(ct);
    }

    public boolean delete(String idDV, String idPhieuDat) {
        return dao.delete(idDV, idPhieuDat);
    }

    public List<ChiTietDichVuDTO> getByPhieuDatID(String idPhieuDat) {
        List<ChiTietDichVuDTO> all = dao.getAll();
        List<ChiTietDichVuDTO> filtered = new ArrayList<>();

        for (ChiTietDichVuDTO ct : all) {
            if (ct.getPD_CTDV().getID_PD().equalsIgnoreCase(idPhieuDat)) {
                filtered.add(ct);
            }
        }

        return filtered;
    }

    public float tinhTongTienDichVuTheoPhieu(String idPhieuDat) {
        float tong = 0f;
        for (ChiTietDichVuDTO ct : getByPhieuDatID(idPhieuDat)) {
            tong += ct.getTONGTIENDV_CTDV();
        }
        return tong;
    }
}

