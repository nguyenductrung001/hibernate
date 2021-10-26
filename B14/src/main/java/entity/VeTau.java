package entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
@Data
@Entity(name = "VETAU")
public class VeTau implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "LoaiGhe")
    private String loaiGhe;
    @ToString.Exclude
    @OneToMany(mappedBy = "veTau", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HoaDon> hoaDons;
    @Column(name = "DonGia")
    private double donGia;

    @Transient
    Scanner sc = new Scanner(System.in);
    private final static String GheVip = "mua le";
    private final static String GheThuong= "mua tap the";

    public VeTau() {

    }

    public VeTau(int id, String loaiGhe, String donGía) {

        this.id = id;
        this.loaiGhe = loaiGhe;
      this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(String loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }



    @Override
    public String toString() {
        return "VeTau{" +
                "id=" + id +
                ", loaiGhe='" + loaiGhe + '\'' +
                ", donGía='" + donGia + '\'' +
                '}';
    }

    public void input() {
        System.out.println("Nhap loai ghe ban muon dat: ");
        System.out.println("1. mua lẻ");
        System.out.println("2. mua tập thể");
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
                    this.setLoaiGhe(VeTau.GheThuong);
                    System.out.println("Ghe Thuong");
                    check = true;
                    break;
                case 2:
                    this.setLoaiGhe(VeTau.GheVip);
                    System.out.println("Ghe vip");
                    check = true;
                    break;
                default:
                    System.out.println("Nhập sai! Hãy nhập từ 1 đến 3!");
                    check = false;
                    break;
            }
        } while (!check);
        System.out.println("Moi ban nhap dơn giá: ");
        this.donGia = sc.nextDouble();
    }
    //    public List<HoaDon> getBuyingRecords() {
//        return buyingRecords;
//    }

}
