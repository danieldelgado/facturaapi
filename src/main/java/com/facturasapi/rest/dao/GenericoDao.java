/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facturasapi.rest.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase que ayuda como generica para las transacciones comunes
 *
 * @author Javier
 * @param <T>
 */
public class GenericoDao<T> {

    /**
     * Session para las transacciones de hibernate
     */
    public SessionFactory sessionFactory;

    /**
     * Regresa la session actual del hibernate
     *
     * @return
     */
    public SessionFactory getSession() {
        return this.sessionFactory;
    }

    /**
     * Instancia la session de hibernate dentro de generic
     *
     * @param sessionFactory
     */
    @Autowired
    public void anyMethodName(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Metodo que tiene la funcion guardar el objeto en la base de datos
     *
     * @param data objeto a guardar en la base de datos
     */
    public void save(T data) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(data);
        tx.commit();
        session.close();
    }

    /**
     * Metodo que tiene funcion guardar o actualizar en la base de datos
     *
     * @param data objeto a guardar en la base de datos
     */
    public void saveOrUpdate(T data) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(data);
        tx.commit();
        session.close();
    }

    /**
     * Metodo que tiene funcion actualizar en la base de datos
     *
     * @param data objeto a guardar en la base de datos
     */
    public void update(T data) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(data);
        tx.commit();
        session.close();
    }

    /**
     * Metodo que tiene funcion eleminar de la base de datos
     *
     * @param data objeto a guardar en la base de datos
     */
    public void delete(T data) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(data);
        tx.commit();
        session.close();
    }

    /**
     * Metodo que obtiene todos los elementos relacionados al objeto de la base
     * de datos
     *
     * @param fetchs relaciones que se obtendran al momento de realizar la
     * consulta
     * @return lista de elementos encontrados en la base de datos
     */
    public List<T> getAll(List<String> fetchs) {
        try {
            Session session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(this.getClase());
            if (fetchs != null) {
                for (String fetch : fetchs) {
                    criteria.setFetchMode(fetch, FetchMode.JOIN);
                }
            }
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List<T> result = criteria.list();
            session.close();
            return result;
        } catch (Exception ex) {
            Logger.getLogger(GenericoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Metodo que busca por id en la base de datos
     *
     * @param atributeId es el nombre de la columna en la base de datos por cual
     * se busca
     * @param atribute es el valor el cual debe tener la columna
     * @param fetchs relaciones que se obtendran al momento de realizar la
     * consulta
     * @return elemento encontrado con el atributo
     */
    public T getByAtribute(String atributeId, Object atribute, List<String> fetchs) {
        try {
            Session session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(this.getClase());
            if (fetchs != null) {
                for (String fetch : fetchs) {
                    criteria.setFetchMode(fetch, FetchMode.JOIN);
                }
            }
            criteria.add(Restrictions.eq(atributeId, atribute));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            T object = (T) criteria.uniqueResult();
            session.close();
            return object;
        } catch (Exception ex) {
            Logger.getLogger(GenericoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Metodo para especificar que clase es la que esta implementando el metodo
     * para realizar las operaciones relacionadas a ese objeto
     *
     * @return @throws Exception
     */
    public Class<T> getClase() throws Exception {
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) superclass.getActualTypeArguments()[0];
    }
}
