package DTO;

import java.sql.Date;

public class PhieuDatPhongDTO {
    private String ID_PD;
    private Date NGAYDAT;
    private Date NGAYTRA;
    private KhachHangDTO KhachHangPD;
    private NhanVienDTO NhanVienPD;

    public PhieuDatPhongDTO() {}

    public PhieuDatPhongDTO(String ID_PD, Date NGAYDAT, Date NGAYTRA, KhachHangDTO KhachHangPD, NhanVienDTO NhanVienPD)
    {
        this.ID_PD = ID_PD;
        this.NGAYDAT = NGAYDAT;
        this.NGAYTRA = NGAYTRA;
        this.KhachHangPD = KhachHangPD;
        this.NhanVienPD = NhanVienPD;
    }

    public String getID_PD() {
        return ID_PD;
    }
    public void setID_PD(String iD_PD) {
        ID_PD = iD_PD;
    }

    public Date getNGAYDAT() {
        return NGAYDAT;
    }
    public void setNGAYDAT(Date nGAYDAT) {
        NGAYDAT = nGAYDAT;
    }

    public Date getNGAYTRA() {
        return NGAYTRA;
    }
    public void setNGAYTRA(Date nGAYTRA) {
        NGAYTRA = nGAYTRA;
    }

    public KhachHangDTO getKhachHangPD() {
        return KhachHangPD;
    }
    public void setKhachHangPD(KhachHangDTO khachHang) {
        KhachHangPD = khachHang;
    }

    public NhanVienDTO getNhanVienPD() {
        return NhanVienPD;
    }
    public void setNhanVienPD(NhanVienDTO nhanVien) {
        NhanVienPD = nhanVien;
    }
}
