package DTO;

import java.sql.Date;

public class HoaDonDTO {
    private String ID_HD;
    private int TONGTIEN_HD;
    private Date NGAYLAP_HD;
    private PhieuDatPhongDTO PD_HD;

    public HoaDonDTO() {}

    public HoaDonDTO(String ID_HD, int TONGTIEN_HD, Date NGAYLAP_HD, PhieuDatPhongDTO PD_HD)
    {
        this.ID_HD = ID_HD;
        this.TONGTIEN_HD = TONGTIEN_HD;
        this.NGAYLAP_HD = NGAYLAP_HD;
        this.PD_HD = PD_HD;
    }

    public String getID_HD() {
        return ID_HD;
    }
    public void setID_HD(String iD_HD) {
        ID_HD = iD_HD;
    }

    public Date getNGAYLAP_HD() {
        return NGAYLAP_HD;
    }
    public void setNGAYLAP_HD(Date nGAYLAP_HD) {
        NGAYLAP_HD = nGAYLAP_HD;
    }

    public PhieuDatPhongDTO getPD_HD() {
        return PD_HD;
    }
    public void setPD_HD(PhieuDatPhongDTO pD_HD) {
        PD_HD = pD_HD;
    }

    public int getTONGTIEN_HD() {
        return TONGTIEN_HD;
    }
    public void setTONGTIEN_HD(int tONGTIEN_HD) {
        TONGTIEN_HD = tONGTIEN_HD;
    }
}
