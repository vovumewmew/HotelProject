package DTO;

public class TaiKhoanDTO {
    private String ID_TK;
    protected String USERNAME;
    protected String PASSWORD;
    private KhachHangDTO KhachHang_TK;
    private NhanVienDTO NhanVien_TK;

    public TaiKhoanDTO() {}

    public TaiKhoanDTO(String ID_TK, String USERNAME, String PASSWORD, KhachHangDTO kh, NhanVienDTO nv) {
        if (kh != null && nv != null) {
            throw new IllegalArgumentException("Tài khoản không được liên kết với cả Khách Hàng và Nhân Viên.");
        }
        this.ID_TK = ID_TK;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.KhachHang_TK = kh;
        this.NhanVien_TK = nv;
    }


    public String getID_TK() {
        return ID_TK;
    }
    public void setID_TK(String iD_TK) {
        ID_TK = iD_TK;
    }

    public String getUSERNAME() {
        return USERNAME;
    }
    public void setUSERNAME(String uSERNAME) {
        USERNAME = uSERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
    public void setPASSWORD(String pASSWORD) {
        PASSWORD = pASSWORD;
    }
    
    public KhachHangDTO getKhachHang_TK() {
        return KhachHang_TK;
    }
    public void setKhachHang_TK(KhachHangDTO khachHang_TK) {
        if (khachHang_TK != null && this.NhanVien_TK != null) {
            throw new IllegalArgumentException("Tài khoản không được liên kết với cả Khách Hàng và Nhân Viên cùng lúc.");
        }
        this.KhachHang_TK = khachHang_TK;
    }

    public NhanVienDTO getNhanVien_TK() {
        return NhanVien_TK;
    }
    public void setNhanVien_TK(NhanVienDTO nhanVien_TK) {
        if (nhanVien_TK != null && this.KhachHang_TK != null) {
            throw new IllegalArgumentException("Tài khoản không được liên kết với cả Nhân Viên và Khách Hàng cùng lúc.");
        }
        this.NhanVien_TK = nhanVien_TK;
    }
}
