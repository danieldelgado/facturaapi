package com.facturasapi.rest.webservice;

import com.facturasapi.rest.util.UnicodeUtil;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante;

@Path("/factura")
public class FacturaService {

    @RolesAllowed("ADMIN")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/")
    public Response createFactura(String comprobante) {
        try {
            File file = new File("facturaTemporal" + new Date().getTime() + ".xml");
            UnicodeUtil.xMLStringToFile(comprobante, file);
            JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Comprobante comp = (Comprobante) jaxbUnmarshaller.unmarshal(file);
            file.delete();
            return Response.status(200).build();
        } catch (IOException ex) {
            Logger.getLogger(FacturaService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(400).build();
        } catch (JAXBException ex) {
            Logger.getLogger(FacturaService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(400).build();
        }
    }

}
