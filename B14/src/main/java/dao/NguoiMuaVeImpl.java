package dao;

import dto.NguoiMuaVeDto;
import entity.NguoiMuaVe;
import org.hibernate.query.NativeQuery;
import utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import java.util.ArrayList;
import java.util.List;

public class NguoiMuaVeImpl implements NguoiMuaVeDAO {
    @Override
    public  List<NguoiMuaVe> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<NguoiMuaVe> nguoiMuaVes =  session.createQuery("from NguoiMuaVe").list();
            return nguoiMuaVes;
        } catch (HibernateException e) {
//            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<NguoiMuaVe> getAllUser() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
//            session.beginTransaction();
            List<NguoiMuaVe> nguoiMuaVes = (List<NguoiMuaVe>) session.createQuery("from NguoiMuaVe").list();
//            session.getTransaction().commit();
            return nguoiMuaVes;
        } catch (HibernateException e) {
//            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public NguoiMuaVe findById(int id) {
        return null;
    }

    @Override
    public  boolean addNew(List<NguoiMuaVe> nguoiMuaVes) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            for ( NguoiMuaVe nmv: nguoiMuaVes) {
                session.save(nmv);
            }
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateNguoiMuaVe(NguoiMuaVe nguoiMuaVe) {
        return false;
    }

    @Override
    public boolean deleteNguoiMuaVe(NguoiMuaVe nguoiMuaVe) {
        return false;
    }

    @Override
    public List<NguoiMuaVeDto> getAllNguoiMuaVeDto() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String sql = "select * from NguoiMuaHang ";
            NativeQuery sqlQuery = session.createSQLQuery(sql);

            sqlQuery
                    .addScalar("id", new IntegerType())
                    .addScalar("name", new StringType())

                    .setResultTransformer(Transformers.aliasToBean(NguoiMuaVeDto.class));

            return sqlQuery.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }
}
