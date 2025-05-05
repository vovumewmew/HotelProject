package BUS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;

public class HoaDonBUS {
    private HoaDonDAO dao;

    public HoaDonBUS() {
        dao = new HoaDonDAO();
    }

    public ArrayList<HoaDonDTO> getAllHoaDon() {
        return dao.getAll();
    }

    public HoaDonDTO getHoaDonById(String id) {
        return dao.getById(id);
    }

    public List<HoaDonDTO> getHoaDonByDate(Date ngayLap) {
        return dao.getByDate(ngayLap);
    }

    public boolean addHoaDon(HoaDonDTO hd) {
        return dao.insert(hd);
    }

    public boolean updateHoaDon(HoaDonDTO hd) {
        return dao.update(hd);
    }

    public boolean deleteHoaDon(String id_hd) {
        return dao.delete(id_hd);
    }
}
