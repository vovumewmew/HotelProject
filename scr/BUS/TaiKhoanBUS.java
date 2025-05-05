package BUS;

import java.util.List;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;

public class TaiKhoanBUS {
    private TaiKhoanDAO dao;

    public TaiKhoanBUS() {
        dao = new TaiKhoanDAO();
    }

    public List<TaiKhoanDTO> getAll() {
        return dao.getAll();
    }

    public TaiKhoanDTO getByUsername(String username) {
        return dao.getByUsername(username);
    }

    public TaiKhoanDTO checkLogin(String username, String password) {
        return dao.checkLogin(username, password);
    }

    public boolean add(TaiKhoanDTO tk) {
        if (tk == null || tk.getUSERNAME() == null || tk.getPASSWORD() == null) {
            System.err.println("Du lieu tai khoan khong hop le");
            return false;
        }
        return dao.insert(tk);
    }

    public boolean update(TaiKhoanDTO tk) {
        if (tk == null || tk.getID_TK() == null) {
            System.err.println("Khong the cap nhat tai khoan khong hop le.");
            return false;
        }
        return dao.update(tk);
    }

    public boolean delete(String id) {
        return dao.delete(id);
    }
}
