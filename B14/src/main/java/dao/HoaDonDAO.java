package dao;

import entity.HoaDon;
import org.hibernate.Session;
import utils.ConnnectionUtils;
import utils.HibernateUtils;

import org.hibernate.query.Query;
import java.util.List;

public class HoaDonDAO {
    public static void addHoaDon(List<HoaDon> listHD){
        if (ConnnectionUtils.isEmpty(listHD)) {
            return;
        }
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {

            session.getTransaction().begin();
            for (HoaDon hd: listHD
                 ) {
                session.save(hd);
            }
            session.getTransaction().commit();


        }catch (Exception e){
            System.out.println(e);
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
    public  static List<HoaDon> getAllHoaDon() {
        String sql = "From HOADON";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<HoaDon> query = session.createQuery(sql);
            List<HoaDon> hoaDons = query.getResultList();
            session.getTransaction().commit();
            return hoaDons;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return null;

    }
}
