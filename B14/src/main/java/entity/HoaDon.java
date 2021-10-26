package entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "HOADON")
public class HoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Integer id;
    @Column(name = "NGUOIMUAVE_ID")
    private Integer userId;
    @Column(name = "VETAU_ID")
    private Integer veTauId;
    private int  quantity;
@ManyToOne
    @JoinColumn(name = "NGUOIMUAVE_ID",insertable = false,updatable = false)
    NguoiMuaVe nguoiMuaVe;
@ManyToOne
    @JoinColumn(name = "VETAU_ID",insertable = false,updatable = false)
    VeTau veTau;

//    public void addHoaDon(NguoiMuaVe nguoiMuaVe , VeTau veTau){
//        this.nguoiMuaVe = nguoiMuaVe;
//        this.veTau = veTau;
//        nguoiMuaVe.getBuyingRecords().add(this);
//        veTau.getBuyingRecords().add(this);
//
//
//    }
}
