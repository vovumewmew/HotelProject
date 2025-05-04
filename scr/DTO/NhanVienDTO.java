package DTO;

public class NhanVienDTO {
    private String ID_NV;
    private String TEN_NV;
    private String EMAIL_NV;
    private String SDT_NV;
    private String CCCD_NV;
    private String GIOITINH_NV;
    private String TRANGTHAI_NV;
    private ChucVuDTO CHUCVU;

    public NhanVienDTO() {}

    public NhanVienDTO(String ID_NV, String TEN_NV, String EMAIL_NV, String SDT_NV, String CCCD_NV, String GIOITINH_NV, String TRANGTHAI_NV, ChucVuDTO CHUCVU)
    {
        this.ID_NV = ID_NV;
        this.TEN_NV = TEN_NV;
        this.EMAIL_NV = EMAIL_NV;
        this.SDT_NV = SDT_NV;
        this.CCCD_NV = CCCD_NV;
        this.GIOITINH_NV = GIOITINH_NV;
        this.TRANGTHAI_NV = TRANGTHAI_NV;
        this.CHUCVU = CHUCVU;
    }

    public String getID_NV() {
        return ID_NV;
    }
    public void setID_NV(String iD_NV) {
        ID_NV = iD_NV;
    }

    public String getTEN_NV() {
        return TEN_NV;
    }
    public void setTEN_NV(String tEN_NV) {
        TEN_NV = tEN_NV;
    }
    
    public String getCCCD_NV() {
        return CCCD_NV;
    }
    public void setCCCD_NV(String cCCD_NV) {
        CCCD_NV = cCCD_NV;
    }

    public String getSDT_NV() {
        return SDT_NV;
    }
    public void setSDT_NV(String sDT_NV) {
        SDT_NV = sDT_NV;
    }
    
    public String getEMAIL_NV() {
        return EMAIL_NV;
    }
    public void setEMAIL_NV(String eMAIL) {
        EMAIL_NV = eMAIL;
    }

    public String getTRANGTHAI_NV() {
        return TRANGTHAI_NV;
    }
    public void setTRANGTHAI_NV(String tRANGTHAI_NV) {
        if (!TRANGTHAI_NV.equalsIgnoreCase("hoạt động") && !TRANGTHAI_NV.equalsIgnoreCase("ngưng hoạt động")) {
            throw new IllegalArgumentException("Trạng thái nhân viên chỉ được là 'hoạt động' hoặc 'ngưng hoạt động'");
        }
        TRANGTHAI_NV = tRANGTHAI_NV;
    }
    
    public String getGIOITINH_NV() {
        return GIOITINH_NV;
    }
    public void setGIOITINH_NV(String gIOITINH) {
        if (!GIOITINH_NV.equalsIgnoreCase("nam") && !GIOITINH_NV.equalsIgnoreCase("nữ")) {
            throw new IllegalArgumentException("Giới tính chỉ được là 'nam' hoặc 'nữ'");
        }
        GIOITINH_NV = gIOITINH;
    }

    public ChucVuDTO getCHUCVU() {
        return CHUCVU;
    }
    public void setCHUCVU(ChucVuDTO cHUCVU) {
        CHUCVU = cHUCVU;
    }
}
