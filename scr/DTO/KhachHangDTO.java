package DTO;

public class KhachHangDTO {
    private String ID_KH;
    private String TEN_KH;
    private String EMAIL_KH;
    private String SDT_KH;
    private String CCCD_KH;
    private String GIOITINH_KH;
    private String TRANGTHAI_KH;

    public KhachHangDTO() {}

    public KhachHangDTO(String ID_KH, String TEN_KH, String EMAIL_KH, String SDT_KH, String CCCD_KH, String GIOITINH_KH, String TRANGTHAI_KH)
    {
        this.ID_KH = ID_KH;
        this.TEN_KH = TEN_KH;
        this.EMAIL_KH = EMAIL_KH;
        this.CCCD_KH = CCCD_KH;
        this.SDT_KH = SDT_KH;
        this.GIOITINH_KH = GIOITINH_KH;
        this.TRANGTHAI_KH = TRANGTHAI_KH;
    }

    public String getID_KH() {
        return ID_KH;
    }
    public void setID_KH(String iD_KH) {
        ID_KH = iD_KH;
    }
    
    public String getTEN_KH() {
        return TEN_KH;
    }
    public void setTEN_KH(String tEN_KH) {
        TEN_KH = tEN_KH;
    }

    public String getEMAIL_KH() {
        return EMAIL_KH;
    }
    public void setEMAIL_KH(String eMAIL_KH) {
        EMAIL_KH = eMAIL_KH;
    }

    public String getGIOITINH_KH() {
        return GIOITINH_KH;
    }
    public void setGIOITINH_KH(String gIOITINH_KH) {
        if (!GIOITINH_KH.equalsIgnoreCase("nam") && !GIOITINH_KH.equalsIgnoreCase("nữ")) {
            throw new IllegalArgumentException("Giới tính chỉ được là 'nam' hoặc 'nữ'");
        }
        GIOITINH_KH = gIOITINH_KH;
    }

    public String getCCCD_KH() {
        return CCCD_KH;
    }
    public void setCCCD_KH(String cCCD_KH) {
        CCCD_KH = cCCD_KH;
    }

    public String getSDT_KH() {
        return SDT_KH;
    }
    public void setSDT_KH(String sDT_KH) {
        SDT_KH = sDT_KH;
    }

    public String getTRANGTHAI_KH() {
        return TRANGTHAI_KH;
    }
    public void setTRANGTHAI_KH(String tRANGTHAI_KH) {
        if (!TRANGTHAI_KH.equalsIgnoreCase("hoạt động") && !TRANGTHAI_KH.equalsIgnoreCase("ngưng hoạt động")) {
            throw new IllegalArgumentException("Trạng thái khách hàng chỉ được là 'hoạt động' hoặc 'ngưng hoạt động'");
        }
        TRANGTHAI_KH = tRANGTHAI_KH;
    }
}
