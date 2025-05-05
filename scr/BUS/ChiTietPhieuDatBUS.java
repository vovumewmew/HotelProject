package BUS;

import java.util.ArrayList;

import DAO.ChiTietPhieuDatDAO;
import DTO.ChiTietPhieuDatDTO;

public class ChiTietPhieuDatBUS {
    private ChiTietPhieuDatDAO dao;

    public ChiTietPhieuDatBUS() {
        dao = new ChiTietPhieuDatDAO();
    }

    public ArrayList<ChiTietPhieuDatDTO> getAllByPhieu(String idPhieuDat) {
        return dao.getAllByPhieu(idPhieuDat);
    }

    public ArrayList<ChiTietPhieuDatDTO> getById(String idPhieuDat) {
        return dao.getById(idPhieuDat);
    }

    public boolean add(ChiTietPhieuDatDTO ct) {
        if (ct == null || ct.getPhieuDat_CTPD() == null || ct.getPhong_CTPD() == null) {
            System.err.println("Chi tiết phiếu đặt không hợp lệ!");
            return false;
        }
        return dao.insert(ct);
    }

    public boolean update(ChiTietPhieuDatDTO ct) {
        if (ct == null || ct.getPhieuDat_CTPD() == null || ct.getPhong_CTPD() == null) {
            System.err.println("Không thể cập nhật chi tiết phiếu đặt không hợp lệ.");
            return false;
        }
        return dao.update(ct);
    }

    public boolean deleteByPhieuAndPhong(String idPhieuDat, String idPhong) {
        return dao.deleteByPhieuAndPhong(idPhieuDat, idPhong);
    }

    public boolean deleteAllByPhieu(String idPhieuDat) {
        return dao.deleteAllByPhieu(idPhieuDat);
    }
}
