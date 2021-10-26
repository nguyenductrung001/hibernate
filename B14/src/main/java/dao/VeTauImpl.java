package dao;

import dto.NguoiMuaVeDto;
import dto.VeTauDTO;
import entity.NguoiMuaVe;
import entity.VeTau;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class VeTauImpl implements VeTauDAO{

    @Override
    public ArrayList<VeTau> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            List<VeTau> listvt = (List<VeTau>) session.createQuery("from VETAU").list();
            return (ArrayList<VeTau>) listvt;
        } catch (HibernateException e){

        }finally {
            session.close();
        }


        return null;
    }
    public static ArrayList<VeTau> getAllTicket() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            List<VeTau> listvt = (List<VeTau>) session.createQuery("from VETAU").list();
            return (ArrayList<VeTau>) listvt;
        } catch (HibernateException e){

        }finally {
            session.close();
        }


        return null;
    }

    @Override
    public VeTau findById(int id) {
        return null;
    }

    @Override
    public boolean addNew(List<VeTau> veTaus) {
        Session session = HibernateUtils.getSessionFactory().openSession();


        try {
            session.beginTransaction();
            for ( VeTau vt: veTaus

            ) {
                session.save(vt);
            }
            session.getTransaction().commit();
            return true;

        }catch (HibernateException e){
            session.getTransaction().rollback();

        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateVeTau(VeTau veTau) {
        return false;
    }

    @Override
    public boolean deleteVeTau(VeTau veTau) {
        return false;
    }

    @Override
    public List<VeTauDTO> getAllVeTauDTO() {
        return null;
    }


}
