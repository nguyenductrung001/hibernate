package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

@Entity(name = "NguoiMuaVe")
public class NguoiMuaVe implements Serializable {
//    private static int AUTO_ID = 100;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "soDienThoai")
    private int soDienThoai;

    @Column(name = "loaiNguoiMua")
    private String loaiNguoiMua;


    @OneToMany(mappedBy = "nguoiMuaVe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HoaDon> hoaDons;

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    private final static String MuaLe = "mua le";
    private final static String MuaTapThe= "mua tap the";
    private final static String MuaQuaMang= "mua qua mang";

    public NguoiMuaVe()  {
    }

    public NguoiMuaVe(int id, String ten, String diaChi, int soDienThoai, String loaiNguoiMua) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.loaiNguoiMua = loaiNguoiMua;
//        this.sc = sc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getLoaiNguoiMua() {
        return loaiNguoiMua;
    }

    public void setLoaiNguoiMua(String loaiNguoiMua) {
        this.loaiNguoiMua = loaiNguoiMua;
    }

//    public Scanner getSc() {
//        return sc;
//    }
//
//    public void setSc(Scanner sc) {
//        this.sc = sc;
//    }
    public void inputInfo(){
//        this.setId(NguoiMuaVe.AUTO_ID);
        System.out.println("Nhập họ tên khách hàng: ");
        this.ten = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        this.diaChi = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại khách hàng: ");
        this.soDienThoai = new Scanner(System.in).nextInt();
        System.out.println("Nhập loại ve muon mua: ");
        System.out.println("1. mua lẻ");
        System.out.println("2. mua tập thể");
        System.out.println("3. mua qua mạng");
        System.out.println("Nhập sự lựa chọn: ");
        boolean check = true;
        do {
            int choice = new Scanner(System.in).nextInt();
            if (choice <= 0 || choice > 3) {
                System.out.print("Nhập số từ 1 đến 3! Nhập lại: ");
                check = false;
                continue;
            }
            switch (choice) {
                case 1:
                    this.setLoaiNguoiMua(NguoiMuaVe.MuaLe);
                    System.out.println("Mua le");
                    check = true;
                    break;
                case 2:
                    this.setLoaiNguoiMua(NguoiMuaVe.MuaTapThe);
                    System.out.println("Mua Tap The");
                    check = true;
                    break;
                case 3:
                    this.setLoaiNguoiMua(NguoiMuaVe.MuaQuaMang);
                    System.out.println("Mua Qua Mang");
                    check = true;
                    break;
                default:
                    System.out.println("Nhập sai! Hãy nhập từ 1 đến 3!");
                    check = false;
                    break;
            }
        } while (!check);

//        NguoiMuaVe.AUTO_ID++;
    }
    @Override
    public String toString() {
        return "VeTau{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai=" + soDienThoai +
                ", loaiNguoiMua='" + loaiNguoiMua + '\'' +

                '}';
    }
//    public List<HoaDon> getBuyingRecords() {
//        return buyingRecords;
//    }

}
