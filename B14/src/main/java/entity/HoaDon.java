package entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Entity(name = "HOADON")
public class HoaDon implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private NguoiMuaVe nguoiMuaVe;
    @Id
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private VeTau veTau;
    private int  quantity;

    public HoaDon() {
    }

    public HoaDon(NguoiMuaVe nguoiMuaVe, VeTau veTau, int quantity) {
        this.nguoiMuaVe = nguoiMuaVe;
        this.veTau = veTau;
        this.quantity = quantity;
    }

    public NguoiMuaVe getNguoiMuaVe() {
        return nguoiMuaVe;
    }

    public void setNguoiMuaVe(NguoiMuaVe nguoiMuaVe) {
        this.nguoiMuaVe = nguoiMuaVe;
    }

    public VeTau getVeTau() {
        return veTau;
    }

    public void setVeTau(VeTau veTau) {
        this.veTau = veTau;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
//    public void addHoaDon(NguoiMuaVe nguoiMuaVe , VeTau veTau){
//        this.nguoiMuaVe = nguoiMuaVe;
//        this.veTau = veTau;
//        nguoiMuaVe.getBuyingRecords().add(this);
//        veTau.getBuyingRecords().add(this);
//
//
//    }
}
