/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facturasapi.rest.service;

import com.facturasapi.rest.bean.Usuario;
import com.facturasapi.rest.dao.UsuarioDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Servicio para las operaciones con usuarios
 *
 * @author javier
 */
@Service
public class UsuarioService {

    @Resource
    private UsuarioDao usuarioDao;

    /**
     * Metodo para guardar o actualizar una usuario
     *
     * @param usuario a actualizar o guardar
     */
    public void saveOrUpdate(Usuario usuario) {
        usuarioDao.saveOrUpdate(usuario);
    }

    /**
     * Metodo para obtener todos las usuarios de la base de datos
     *
     * @return la lista de usuarios
     */
    public List<Usuario> getAll() {
        return usuarioDao.getAll(getFetchs());
    }

    /**
     * Metodo para obtener un usuario por id
     *
     * @param id del usuario obtener
     * @return el usuario encontrada
     */
    public Usuario getById(Integer id) {
        return usuarioDao.getByAtribute("id", id, getFetchs());
    }

    /**
     * Metodo para obtener un usuario por su username
     *
     * @param username del usuario
     * @return el usuario encontrada
     */
    public Usuario getByUserName(String username) {
        return usuarioDao.getByAtribute("usuario", username, getFetchs());
    }

    private List<String> getFetchs() {
        List<String> fetchs = new ArrayList<String>();
        return fetchs;
    }

}
