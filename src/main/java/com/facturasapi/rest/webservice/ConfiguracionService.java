package com.facturasapi.rest.webservice;

import com.facturasapi.rest.bean.Usuario;
import com.facturasapi.rest.service.UsuarioService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

@Path("/config")
public class ConfiguracionService {

    @RolesAllowed("ADMIN")
    @POST
    @Path("/keys")
    @Consumes("*/*")
    public Response createFactura(MultipartFormDataInput input) {
        try {

            Map<String, List<InputPart>> uploadForm = input.getFormDataMap();

            if (!uploadForm.containsKey("username")) {
                return Response.status(400).entity("Atributo 'username' no especificado").build();
            }
            if (!uploadForm.containsKey("clave")) {
                return Response.status(400).entity("Atributo 'clave' no especificado").build();
            }
            if (!uploadForm.containsKey("key")) {
                return Response.status(400).entity("Atributo 'key' no especificado").build();
            }
            if (!uploadForm.containsKey("cert")) {
                return Response.status(400).entity("Atributo 'cert' no especificado").build();
            }

            String clave = uploadForm.get("clave").get(0).getBodyAsString();
            String username = uploadForm.get("username").get(0).getBodyAsString();
            InputStream inputStreamKey = uploadForm.get("key").get(0).getBody(InputStream.class, null);
            InputStream inputStreamCert = uploadForm.get("cert").get(0).getBody(InputStream.class, null);

            byte[] bytesKey = IOUtils.toByteArray(inputStreamKey);
            byte[] bytesCer = IOUtils.toByteArray(inputStreamCert);

            ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
            UsuarioService usuarioService = (UsuarioService) ctx.getBean(UsuarioService.class);
            Usuario usuario = usuarioService.getByUserName(username);
            usuario.setCert(bytesCer);
            usuario.setKey(bytesKey);
            usuario.setClave(clave);
            usuarioService.saveOrUpdate(usuario);
        } catch (IOException ex) {
            Logger.getLogger(ConfiguracionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(200).build();
    }

}
