package DTO;

public class DichVuDTO {
    private String ID_DV;
    private String TEN_DV;
    private int DONGIA_DV;
    private String MOTA_DV;

    public DichVuDTO() {}

    public DichVuDTO(String ID_DV, String TEN_DV, int DONGIA_DV, String MOTA_DV)
    {
        this.ID_DV = ID_DV;
        this.TEN_DV = TEN_DV;
        this.DONGIA_DV = DONGIA_DV;
        this.MOTA_DV = MOTA_DV;
    }

    public String getID_DV() {
        return ID_DV;
    }
    public void setID_DV(String iD_DV) {
        ID_DV = iD_DV;
    }

    public String getTEN_DV() {
        return TEN_DV;
    }
    public void setTEN_DV(String tEN_DV) {
        TEN_DV = tEN_DV;
    }

    public int getDONGIA_DV() {
        return DONGIA_DV;
    }
    public void setDONGIA_DV(int dONGIA_DV) {
        DONGIA_DV = dONGIA_DV;
    }

    public String getMOTA_DV() {
        return MOTA_DV;
    }
    public void setMOTA_DV(String mOTA_DV) {
        MOTA_DV = mOTA_DV;
    }
}
