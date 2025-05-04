package DTO;

public class LoaiPhongDTO {
    private String ID_LOAIPHG;
    private String TEN_LOAIPHG;
    private int DONGIA_PHG;
    private String MOTA_LOAIPHG;
    private String TRANGTHAI_LOAIPHG;
    
    public LoaiPhongDTO() {}
    
    public LoaiPhongDTO(String ID_LOAIPHG, String TEN_LOAIPHG, int DONGIA_PHG, String MOTA_LOAIPHG, String TRANGTHAI_LOAIPHG)
    {
        this.ID_LOAIPHG = ID_LOAIPHG;
        this.TEN_LOAIPHG = TEN_LOAIPHG;
        this.DONGIA_PHG = DONGIA_PHG;
        this.MOTA_LOAIPHG = MOTA_LOAIPHG;
        this.TRANGTHAI_LOAIPHG = TRANGTHAI_LOAIPHG;
    }
    public String getID_LOAIPHG() {
        return ID_LOAIPHG;
    }
    public void setID_LOAIPHG(String iD_LOAIPHG) {
        ID_LOAIPHG = iD_LOAIPHG;
    }
    public String getTEN_LOAIPHG() {
        return TEN_LOAIPHG;
    }
    public void setTEN_LOAIPHG(String tEN_LOAIPHG) {
        TEN_LOAIPHG = tEN_LOAIPHG;
    }
    public int getDONGIA_PHG() {
        return DONGIA_PHG;
    }
    public void setDONGIA_PHG(int dONGIA_PHG) {
        DONGIA_PHG = dONGIA_PHG;
    }
    public String getMOTA_LOAIPHG() {
        return MOTA_LOAIPHG;
    }
    public void setMOTA_LOAIPHG(String mOTA_LOAIPHG) {
        MOTA_LOAIPHG = mOTA_LOAIPHG;
    }
    public String getTRANGTHAI_LOAIPHG() {
        return TRANGTHAI_LOAIPHG;
    }
    public void setTRANGTHAI_LOAIPHG(String tRANGTHAI_LOAIPHG) {
        if (!TRANGTHAI_LOAIPHG.equalsIgnoreCase("hoạt động") && !TRANGTHAI_LOAIPHG.equalsIgnoreCase("ngưng hoạt động")) {
            throw new IllegalArgumentException("Trạng thái loại phòng chỉ được là 'hoạt động' hoặc 'ngưng hoạt động'");
        }
        TRANGTHAI_LOAIPHG = tRANGTHAI_LOAIPHG;
    }
}
