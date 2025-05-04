package DTO;

public class ChiTietPhieuDatDTO {
    private float TONGTIEN_CTPD;
    private String TRANGTHAI_CTPD;
    private PhieuDatPhongDTO PhieuDat_CTPD;
    private PhongDTO Phong_CTPD;

    public ChiTietPhieuDatDTO() {}

    public ChiTietPhieuDatDTO(int TONGTIEN_CTPD, String TRANGTHAI_CTPD, PhieuDatPhongDTO PhieuDat_CTPD, PhongDTO Phong_CTPD)
    {
        this.TONGTIEN_CTPD = TONGTIEN_CTPD;
        this.TRANGTHAI_CTPD = TRANGTHAI_CTPD;
        this.PhieuDat_CTPD = PhieuDat_CTPD;
        this.Phong_CTPD = Phong_CTPD;
    }

    public float getTONGTIEN_CTPD() {
        return TONGTIEN_CTPD;
    }
    public void setTONGTIEN_CTPD(float tONGTIEN_CTPD) {
        TONGTIEN_CTPD = tONGTIEN_CTPD;
    }

    public String getTRANGTHAI_CTPD() {
        return TRANGTHAI_CTPD;
    }
    public void setTRANGTHAI_CTPD(String tRANGTHAI_CTPD) {
        if (!TRANGTHAI_CTPD.equalsIgnoreCase("chưa checkout") && !TRANGTHAI_CTPD.equalsIgnoreCase("đã checkout")) {
            throw new IllegalArgumentException("Trạng thái chi tiết đặt phòng chỉ được là 'chưa checkout' hoặc 'đã checkout'");
        }
        TRANGTHAI_CTPD = tRANGTHAI_CTPD;
    }

    public PhieuDatPhongDTO getPhieuDat_CTPD() {
        return PhieuDat_CTPD;
    }
    public void setPhieuDat_CTPD(PhieuDatPhongDTO phieuDat_CTPD) {
        PhieuDat_CTPD = phieuDat_CTPD;
    }

    public PhongDTO getPhong_CTPD() {
        return Phong_CTPD;
    }
    public void setPhong_CTPD(PhongDTO phong_CTPD) {
        Phong_CTPD = phong_CTPD;
    }
}
