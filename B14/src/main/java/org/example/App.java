package org.example;

import dao.*;
import dto.NguoiMuaVeDto;
import entity.HoaDon;
import entity.NguoiMuaVe;
import entity.VeTau;
import receiptTable.Receipt;
import receiptTable.TicketTable;

import java.sql.Connection;
import java.util.*;

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
                    sortName();
                    break;
                case 7:
                    sortQuantity();
                    break;
                case 8:
                    System.exit(0);
            }

        } while (true);
    }

    private static void sortName() {
        List<HoaDon> allListHD = HoaDonDAO.getAllHoaDon();
        Collections.sort(allListHD, new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return o1.getNguoiMuaVe().getTen().compareTo(o2.getNguoiMuaVe().getTen());
            }
        });
        for (HoaDon hoaDon: allListHD
             ) {
            System.out.println(hoaDon.toString());
        }

    }
    private static void sortQuantity() {
        List<HoaDon> allListHD = HoaDonDAO.getAllHoaDon();
        Collections.sort(allListHD, new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return o2.getQuantity()-o1.getQuantity();
            }
        });
        for (HoaDon hoaDon: allListHD
        ) {
            System.out.println(hoaDon.toString());
        }

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
                System.out.println("So loai ve phai  l???n h??n 0! vui long nhap lai.");
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
            System.out.println("Danh s??ch kh??ch h??ng: ");
//            nguoiMuaVes.forEach(System.out::println);
            for (NguoiMuaVe nguoiMuaVe: nguoiMuaVes
                 ) {
                System.out.println(nguoiMuaVe);
            }
        } else {
            System.out.println("Kh??ng c?? b???n ghi n??o trong CSDL");
        }
    }
    public static void displayTrainTickets(){
        VeTauImpl vtImpl = new VeTauImpl();
        List<VeTau> veTaus= vtImpl.getAll();
        if (!(veTaus == null || veTaus.isEmpty())) {
            System.out.println("Danh s??ch kh??ch h??ng: ");
//            nguoiMuaVes.forEach(System.out::println);
            for (VeTau veTau: veTaus
            ) {
                System.out.println(veTau);
            }
        } else {
            System.out.println("Kh??ng c?? b???n ghi n??o trong CSDL");
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
                                System.out.println("Nh???p id v?? th??? " +(j+1)+ " kh??ch mu???n mua:");
                                veTau_Id = new Scanner(System.in).nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println("Kh??ng ???????c nh???p k?? t??? kh??c ngo??i s???! Nh???p l???i: ");
                                check = false;
                                continue;
                            }
                            veTau = searchVeTau(veTau_Id);
                            if (veTau != null && veTau.getId() == veTau_Id) {
                                System.out.println("Nh???p s??? l?????ng v?? c???a lo???i "+ veTau.getLoaiGhe()+ " kh??ch mu???n mua: ");
                                int ticketNum = 0;
                                do {
                                    try {
                                        ticketNum = new Scanner(System.in).nextInt();
                                        check = true;
                                    } catch (Exception e) {
                                        System.out.println("Kh??ng ???????c nh???p k?? t??? kh??c ngo??i s???! Nh???p l???i: ");
                                        check = false;
                                        continue;
                                    }
                                    if (ticketNum<=0 || ticketNum > 20){
                                        System.out.println(" 0 < S??? l?????ng v?? <= 20! Nh???p l???i:");
                                        check = false;
                                    }
                                }while (!check);
                                price += ticketNum * veTau.getDonGia();
                                ticketTotle += ticketNum;
                                ticketTables.add(new TicketTable(veTau, ticketNum));
                                HoaDon hoaDon = new HoaDon();
                                hoaDon.setVeTauId(veTau.getId());
                                hoaDon.setUserId(nguoiMuaVe.getId());
                                hoaDon.setQuantity(ticketNum);
                                hoaDonList.add(hoaDon);
                                break;
                            }
                            System.out.print("Kh??ng c?? v?? n??o c?? ID v???a nh???p, vui l??ng nh???p l???i: ");
                        } while (true);
                    }
                    Receipt receipt = new Receipt(nguoiMuaVe, ticketTables);
                    receipt.setSum(ticketTotle);
                    receipt.setPriceTotal(price);
                    receiptList.add(receipt);
                    break;
                }
                System.out.print("Kh??ng c?? kh??ch h??ng n??o c?? ID v???a nh???p, vui l??ng nh???p l???i: ");
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
        System.out.println("--------Qu???n l?? ph??ng kh??ch s???n--------");
        System.out.println("1.Nh???p danh s??ch ve:");
        System.out.println("2.Nh???p danh s??ch Nguoi mua ve:");
        System.out.println("3.in ra danh sach nguoi mua ve:");
        System.out.println("4.in ra danh sach ve:");
        System.out.println("5.Nhap hoa don.");
        System.out.println("6.Sap xep theo ten .");
        System.out.println("6.Sap xep theo so luong giam dan.");
        System.out.println("7.Tho??t");
        int functionChoice = 0;
        boolean check = true;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Kh??ng ???????c nh???p k?? t??? kh??c ngo??i s???! Nh???p l???i: ");
                check = false;
                continue;
            }
            if (functionChoice < 1 || functionChoice > 6) {
                System.out.print("Ch???c n??ng ch???n kh??ng h???p l???, vui l??ng ch???n l???i: ");
                check = false;
            }
        } while (!check);
        return functionChoice;
    }
}
