package DTO;

public class PhongDTO{
    private String ID_PHG;
    private String TEN_PHG;
    private String TINHTRANG_PHG;
    private LoaiPhongDTO LOAIPHONG;

    public PhongDTO(){}

    public PhongDTO(String ID_PHG, String TEN_PHG, String TINHTRANG_PHG, LoaiPhongDTO LOAIPHONG)
    {
        this.ID_PHG = ID_PHG;
        this.TEN_PHG = TEN_PHG;
        this.TINHTRANG_PHG = TINHTRANG_PHG;
        this.LOAIPHONG = LOAIPHONG;
    }
    public String getID_PHG() {
        return ID_PHG;
    }
    public void setID_PHG(String iD_PHG) {
        ID_PHG = iD_PHG;
    }
    public String getTEN_PHG() {
        return TEN_PHG;
    }
    public void setTEN_PHG(String tEN_PHG) {
        TEN_PHG = tEN_PHG;
    }
    public String getTINHTRANG_PHG() {
        return TINHTRANG_PHG;
    }
    public void setTINHTRANG_PHG(String tINHTRANG_PHG) {
        if (!TINHTRANG_PHG.equalsIgnoreCase("trống") && !TINHTRANG_PHG.equalsIgnoreCase("đã đặt")&&!TINHTRANG_PHG.equalsIgnoreCase("bảo trì")&&!TINHTRANG_PHG.equalsIgnoreCase("ngừng kinh doanh")) {
            throw new IllegalArgumentException("Trạng thái nhân viên chỉ được là 'trống','đã đặt','bảo trì','ngừng kinh doanh'");
        }
        TINHTRANG_PHG = tINHTRANG_PHG;
    }
    public LoaiPhongDTO getLOAIPHONG() {
        return LOAIPHONG;
    }
    public void setLOAIPHONG(LoaiPhongDTO lOAIPHONG) {
        LOAIPHONG = lOAIPHONG;
    }
}
