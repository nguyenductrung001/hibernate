package org.example;

import dao.*;
import dto.NguoiMuaVeDto;
import entity.HoaDon;
import entity.NguoiMuaVe;
import entity.VeTau;
import receiptTable.Receipt;
import receiptTable.TicketTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App {
    private static NguoiMuaVeImpl nmvIplm = new NguoiMuaVeImpl();
    private static VeTauImpl vtImpl = new VeTauImpl();
    private static  List<VeTau> listVt =  VeTauImpl.getAllTicket();
    private static List<NguoiMuaVe> listUser = NguoiMuaVeImpl.getAllUser();

    private static List<Receipt> receipts = new ArrayList<>();
    private static HoaDonDAO hdDao = new HoaDonDAO();
    public static void main( String[] args ) {

//        NguoiMuaVeDAO nguoiMuaVeDAO = new NguoiMuaVeImpl();
//
//        List<NguoiMuaVe> nguoiMuaVes= nguoiMuaVeDAO.getAll();
//        System.out.println(nguoiMuaVes);
        menu();
    }
    private static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createTrainTickets();
                    break;
                case 2:
                    createNewCustomer();
                    break;
                case 3:
                    displaycustomer();
                    break;
                case 4:
                    displayTrainTickets();
                    break;
                case 5:
                    createHD();
                    break;
                case 6:
                    System.exit(0);
            }

        } while (true);
    }

    private static void createTrainTickets() {
        VeTau veTau = new VeTau();
        VeTauImpl vt = new VeTauImpl();

        System.out.println("Moi ban nhap so loai ve:");
        int countTrainTickets =0;
        boolean checkTrainTickets = true;
        do {
            try {
                countTrainTickets = new Scanner(System.in).nextInt();
                checkTrainTickets = true;


            }catch (Exception e){
                System.out.println("Khong duoc nhap ki tu nao ngoai so: ");
                checkTrainTickets = false;
                continue;

            }
            if(countTrainTickets<=0){
                System.out.println("So loai ve phai  lớn hơn 0! vui long nhap lai.");
                    checkTrainTickets = false;
            }
        }while (!checkTrainTickets);
        for (int i = 0; i < countTrainTickets ; i++) {

            VeTau veTau1 = new VeTau();

            veTau1.input();
//            listUser.add(nguoiMuaVe);
            listVt.add(veTau1);
        }
        vtImpl.addNew(listVt);

    }

    private static void createNewCustomer() {
        NguoiMuaVe customer = new NguoiMuaVe();
        NguoiMuaVeImpl ng = new NguoiMuaVeImpl();
        ArrayList<NguoiMuaVe> listUser = new ArrayList<>();
        System.out.println("Nhap so luong khach hang muon mua ve ");
        int customerCount = 0;
        boolean check = true;
        do {
            try {
                customerCount = new Scanner(System.in).nextInt();
                check = true;
            }catch (Exception e){
                System.out.println("Khong duoc nhap ki tu nao ngoai so: ");
                check = false;
                continue;
            }
            if(customerCount<=0){
                System.out.println("So luong khach hang phai lon hon 0! Vui long nhap lai. ");
                check = false;
            }
        }while (!check);
        for (int i = 0; i < customerCount ; i++) {
            NguoiMuaVe nguoiMuaVe = new NguoiMuaVe();
            nguoiMuaVe.inputInfo();
//            listUser.add(nguoiMuaVe);
            listUser.add(nguoiMuaVe);

        }
        nmvIplm.addNew(listUser);


    }

    public static void displaycustomer(){
        NguoiMuaVeDAO nguoiMuaVeDAO = new NguoiMuaVeImpl();
        List<NguoiMuaVe> nguoiMuaVes= nguoiMuaVeDAO.getAll();

        if (!(nguoiMuaVes == null || nguoiMuaVes.isEmpty())) {
            System.out.println("Danh sách khách hàng: ");
//            nguoiMuaVes.forEach(System.out::println);
            for (NguoiMuaVe nguoiMuaVe: nguoiMuaVes
                 ) {
                System.out.println(nguoiMuaVe);
            }
        } else {
            System.out.println("Không có bản ghi nào trong CSDL");
        }
    }
    public static void displayTrainTickets(){
        VeTauImpl vtImpl = new VeTauImpl();
        List<VeTau> veTaus= vtImpl.getAll();
        if (!(veTaus == null || veTaus.isEmpty())) {
            System.out.println("Danh sách khách hàng: ");
//            nguoiMuaVes.forEach(System.out::println);
            for (VeTau veTau: veTaus
            ) {
                System.out.println(veTau);
            }
        } else {
            System.out.println("Không có bản ghi nào trong CSDL");
        }
    }
    private static boolean kiemTraNull(){
        return  !listUser.isEmpty() && !listVt.isEmpty();
    }
    public static void createHD(){
        if(!kiemTraNull()){
            System.out.println("Can nhap khach hang va ve tau truoc khi tao hoa don:");
            return;
        }
        boolean check = true;
        int n =0;
        do {
            try {
                System.out.println("Nhap so luong khach hang muon mua ve: ");
                 n = new Scanner(System.in).nextInt();
                 check = true;
            }catch (Exception e){
                System.out.println("khong duoc nhap ki tu khac ngoai so: ");
                check = false;
                continue;
            }
            if(n<=0|| n>listUser.size()){
                System.out.println("So luong khach hang phai lown hon khong va nho hon tong so khach hang! Vui long nhap lai");
                check = false;
            }
        }while (!check);
       List<Receipt> receiptList = new ArrayList<>();
       List<HoaDon> hoaDonList = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            int customer_id;
            NguoiMuaVe nguoiMuaVe;
            do {
                try {
                    System.out.println("Nhap Id khach hang thu " + (i+1)+ "muon mua ve: ");
                    customer_id = new  Scanner(System.in).nextInt();
                    check = true;

                }catch (Exception e){
                    System.out.println("Khong duoc nhap ki tu khac ngoai so! Nhap Lai.");
                    check  = false;
                    continue;

                }
                nguoiMuaVe = searchCustomer(customer_id);
                if(nguoiMuaVe !=null || nguoiMuaVe.getId() == customer_id){
                    int number = 0 ;
                    do {
                        try {
                            System.out.println("Nhap so luong ve khach hang mouon mua: ");
                            number = new Scanner(System.in).nextInt();
                            check =true;

                        }catch (Exception e){
                            System.out.println("khong duoc nhap ki tu khac ngoai so! Nhap lai");
                            check = false;
                            continue;
                        }
                        if(number<0 || number>4 || number>listVt.size()){
                            System.out.println("So ve phai lon hon 0  va nho hon 4 va phia nho hon tong so ve ! Nhsp Lai");
                            check = false;

                        }
                    }while (!check);
                    int veTau_Id;
                    VeTau veTau ;
                    List<TicketTable> ticketTables = new ArrayList<>();
                    int ticketTotle =0;
                    float price = 0;
                    for (int j=0; j < number; j++){
                        do {
                            try {
                                System.out.println("Nhập id vé thứ " +(j+1)+ " khách muốn mua:");
                                veTau_Id = new Scanner(System.in).nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                                check = false;
                                continue;
                            }
                            veTau = searchVeTau(veTau_Id);
                            if (veTau != null && veTau.getId() == veTau_Id) {
                                System.out.println("Nhập số lượng vé của loại "+ veTau.getLoaiGhe()+ " khách muốn mua: ");
                                int ticketNum = 0;
                                do {
                                    try {
                                        ticketNum = new Scanner(System.in).nextInt();
                                        check = true;
                                    } catch (Exception e) {
                                        System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                                        check = false;
                                        continue;
                                    }
                                    if (ticketNum<=0 || ticketNum > 20){
                                        System.out.println(" 0 < Số lượng vé <= 20! Nhập lại:");
                                        check = false;
                                    }
                                }while (!check);
                                price += ticketNum * veTau.getDonGia();
                                ticketTotle += ticketNum;
                                ticketTables.add(new TicketTable(veTau, ticketNum));
                                hoaDonList.add(new HoaDon(nguoiMuaVe, veTau, ticketNum));
                                break;
                            }
                            System.out.print("Không có vé nào có ID vừa nhập, vui lòng nhập lại: ");
                        } while (true);
                    }
                    Receipt receipt = new Receipt(nguoiMuaVe, ticketTables);
                    receipt.setSum(ticketTotle);
                    receipt.setPriceTotal(price);
                    receiptList.add(receipt);
                    break;
                }
                System.out.print("Không có khách hàng nào có ID vừa nhập, vui lòng nhập lại: ");
            }while (true);

        }
        receipts.addAll(receiptList);
        hdDao.addHoaDon(hoaDonList);


    }
    private static VeTau searchVeTau(int ticketId) {
        for (VeTau veTau : listVt) {
            if (veTau.getId() == ticketId) {
                return veTau;
            }
        }
        return null;
    }

    private static NguoiMuaVe searchCustomer(int customerId) {
        for (NguoiMuaVe nguoiMuaVe : listUser) {
            if (nguoiMuaVe.getId() == customerId) {
                return nguoiMuaVe;
            }
        }
        return null;
    }
//    public static void bill(){
//        for (NguoiMuaVe nguoiMuaVe: listUser
//             ) {
//            double total = nguoiMuaVe.getHoaDons().stream().mapToDouble(hd -> hd.getVeTau().getDonGia()*hd.getQuantity()).sum();
//
//        }
//    }



    private static int functionChoice() {
        System.out.println("--------Quản lý phòng khách sạn--------");
        System.out.println("1.Nhập danh sách ve:");
        System.out.println("2.Nhập danh sách Nguoi mua ve:");
        System.out.println("3.in ra danh sach nguoi mua ve:");
        System.out.println("4.in ra danh sach ve:");
        System.out.println("5.Nhap hoa don.");
        System.out.println("6.Thoát");
        int functionChoice = 0;
        boolean check = true;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }
            if (functionChoice < 1 || functionChoice > 6) {
                System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
                check = false;
            }
        } while (!check);
        return functionChoice;
    }
}
