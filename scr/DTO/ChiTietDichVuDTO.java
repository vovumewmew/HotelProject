package DTO;

public class ChiTietDichVuDTO {
    private int SOLUONGDV_CTDV;
    private float TONGTIENDV_CTDV;
    private DichVuDTO DV_CTDV;
    private PhieuDatPhongDTO PD_CTDV;

    public ChiTietDichVuDTO() {}

    public ChiTietDichVuDTO(int SOLUONGDV_CTDV, int TONGTIENDV_CTDV, DichVuDTO DV_CTDV, PhieuDatPhongDTO PD_CTDV)
    {
        this.SOLUONGDV_CTDV = SOLUONGDV_CTDV;
        this.TONGTIENDV_CTDV = TONGTIENDV_CTDV;
        this.DV_CTDV = DV_CTDV;
        this.PD_CTDV = PD_CTDV;
    }

    public float getTONGTIENDV_CTDV() {
        return TONGTIENDV_CTDV;
    }
    public void setTONGTIENDV_CTDV(float tONGTIENDV_CTDV) {
        TONGTIENDV_CTDV = tONGTIENDV_CTDV;
    }

    public int getSOLUONGDV_CTDV() {
        return SOLUONGDV_CTDV;
    }
    public void setSOLUONGDV_CTDV(int sOLUONGDV_CTDV) {
        SOLUONGDV_CTDV = sOLUONGDV_CTDV;
    }

    public DichVuDTO getDV_CTDV() {
        return DV_CTDV;
    }
    public void setDV_CTDV(DichVuDTO dV_CTDV) {
        DV_CTDV = dV_CTDV;
    }
    
    public PhieuDatPhongDTO getPD_CTDV() {
        return PD_CTDV;
    }
    public void setPD_CTDV(PhieuDatPhongDTO pD_CTDV) {
        PD_CTDV = pD_CTDV;
    }
}
