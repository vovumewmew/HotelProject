package DTO;

public class ChucVuDTO {
    private String ID_CV;
    private String TEN_CV;
    
    public ChucVuDTO() {}

    public ChucVuDTO(String ID_CV, String TEN_CV)
    {
        this.ID_CV = ID_CV;
        this.TEN_CV = TEN_CV;
    }
    
    public String getID_CV() {
        return ID_CV;
    }
    public void setID_CV(String iD_CV) {
        ID_CV = iD_CV;
    }

    public String getTEN_CV() {
        return TEN_CV;
    }
    public void setTEN_CV(String tEN_CV) {
        if (!TEN_CV.equalsIgnoreCase("quản lý") && !TEN_CV.equalsIgnoreCase("nhân viên")) {
            throw new IllegalArgumentException("Chức vụ chỉ được là 'quản lý' hoặc 'nhân viên'");
        }
        TEN_CV = tEN_CV;
    }
}
