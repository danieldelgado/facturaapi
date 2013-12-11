/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facturasapi.rest.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Addenda;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Conceptos;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Conceptos.Concepto;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Emisor;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Emisor.RegimenFiscal;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Impuestos;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Impuestos.Traslados;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Impuestos.Traslados.Traslado;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Receptor;
import mx.bigdata.sat.cfdi.v32.schema.ObjectFactory;
import mx.bigdata.sat.cfdi.v32.schema.TUbicacion;
import mx.bigdata.sat.cfdi.v32.schema.TUbicacionFiscal;

/**
 *
 * @author Javier
 */
public class FacturaUtil {

    public static Comprobante createComprobante(ObjectFactory of, Emisor emisor, Receptor receptor, Conceptos conceptos, Impuestos impuestos, BigDecimal subtotal, BigDecimal total, String metodoPago) throws Exception {
        Comprobante comprobante = of.createComprobante();
        comprobante.setVersion("3.2");

        comprobante.setFecha(new Date());
        comprobante.setFormaDePago("PAGO EN UNA SOLA EXHIBICION");
        comprobante.setLugarExpedicion("Mexico");
        comprobante.setTipoDeComprobante("ingreso");

        comprobante.setSubTotal(subtotal);
        comprobante.setTotal(total);
        comprobante.setMetodoDePago(metodoPago);

        comprobante.setEmisor(emisor);
        comprobante.setReceptor(receptor);
        comprobante.setConceptos(conceptos);
        comprobante.setImpuestos(impuestos);
//        comprobante.setAddenda(createAddenda(of));
        return comprobante;
    }

    public static Emisor createEmisor(ObjectFactory of) {
        Emisor emisor = of.createComprobanteEmisor();
//        emisor.setNombre(UnicodeUtil.unicodeCadenaString(datosFacturacion.getRazonSocial()));
//        emisor.setRfc(UnicodeUtil.unicodeCadenaString(datosFacturacion.getRfc()));
//        TUbicacionFiscal uf = of.createTUbicacionFiscal();
//
//        Direccion direccion = datosFacturacion.getDireccionFiscal();
//
//        uf.setCalle(UnicodeUtil.unicodeCadenaString(direccion.getCalle()));
//
//        if (!direccion.getNumeroInterior().isEmpty()) {
//            uf.setNoInterior(UnicodeUtil.unicodeCadenaString(direccion.getNumeroInterior()));
//        }
//        uf.setNoExterior(UnicodeUtil.unicodeCadenaString(direccion.getNumeroExterior()));
//        uf.setColonia(UnicodeUtil.unicodeCadenaString(direccion.getColonia()));
//        uf.setCodigoPostal(direccion.getCodigoPostal());
//        uf.setPais(UnicodeUtil.unicodeCadenaString(direccion.getPais()));
//        uf.setEstado(UnicodeUtil.unicodeCadenaString(direccion.getEstado().getNombreEstado()));
//        uf.setMunicipio(UnicodeUtil.unicodeCadenaString(direccion.getMunicipio().getNombrePoblacion()));
//        if (!direccion.getLocalidad().isEmpty()) {
//            uf.setLocalidad(UnicodeUtil.unicodeCadenaString(direccion.getLocalidad()));
//        }
//        if (direccion.getReferencia() != null && !direccion.getReferencia().isEmpty()) {
//            uf.setReferencia(UnicodeUtil.unicodeCadenaString(direccion.getReferencia()));
//        }
//        emisor.setDomicilioFiscal(uf);
//
//        if (!Constantes.getBooleanFromByte(datosFacturacion.getMismaDireccion())) {
//            direccion = datosFacturacion.getDireccionFactura();
//        }
//
//        TUbicacion u = of.createTUbicacion();
//        u.setCalle(UnicodeUtil.unicodeCadenaString(direccion.getCalle()));
//
//        if (!direccion.getNumeroInterior().isEmpty()) {
//            u.setNoInterior(UnicodeUtil.unicodeCadenaString(direccion.getNumeroInterior()));
//        }
//        if (!direccion.getNumeroExterior().isEmpty()) {
//            u.setNoExterior(UnicodeUtil.unicodeCadenaString(direccion.getNumeroExterior()));
//        }
//        u.setColonia(UnicodeUtil.unicodeCadenaString(direccion.getColonia()));
//        u.setCodigoPostal(UnicodeUtil.unicodeCadenaString(direccion.getCodigoPostal()));
//        u.setPais(UnicodeUtil.unicodeCadenaString(direccion.getPais()));
//        u.setEstado(UnicodeUtil.unicodeCadenaString(direccion.getEstado().getNombreEstado()));
//        u.setMunicipio(UnicodeUtil.unicodeCadenaString(direccion.getMunicipio().getNombrePoblacion()));
//        if (!direccion.getLocalidad().isEmpty()) {
//            u.setLocalidad(UnicodeUtil.unicodeCadenaString(direccion.getLocalidad()));
//        }
//        if (direccion.getReferencia() != null && !direccion.getReferencia().isEmpty()) {
//            u.setReferencia(UnicodeUtil.unicodeCadenaString(direccion.getReferencia()));
//        }
//        emisor.setExpedidoEn(u);
//        RegimenFiscal rf = of.createComprobanteEmisorRegimenFiscal();
//        rf.setRegimen(UnicodeUtil.unicodeCadenaString(datosFacturacion.getRegimen()));
//        emisor.getRegimenFiscal().add(rf);
        return emisor;
    }

    public static Receptor createReceptor(ObjectFactory of) {
        Receptor receptor = of.createComprobanteReceptor();
//        receptor.setNombre(UnicodeUtil.unicodeCadenaString(cliente.getNombreCliente()));
//        receptor.setRfc(UnicodeUtil.unicodeCadenaString(cliente.getDatosFiscales().getRfc()));
//        TUbicacion uf = of.createTUbicacion();
//        if (!cliente.getDatosFiscales().getCalle().isEmpty()) {
//            uf.setCalle(UnicodeUtil.unicodeCadenaString(cliente.getDatosFiscales().getCalle()));
//        }
//        if (!cliente.getDatosFiscales().getNumeroInterior().isEmpty()) {
//            uf.setNoInterior(UnicodeUtil.unicodeCadenaString(cliente.getDatosFiscales().getNumeroInterior()));
//        }
//        if (!cliente.getDatosFiscales().getNumeroExterior().isEmpty()) {
//            uf.setNoExterior(UnicodeUtil.unicodeCadenaString(cliente.getDatosFiscales().getNumeroExterior()));
//        }
//        if (!cliente.getDatosFiscales().getColonia().isEmpty()) {
//            uf.setColonia(UnicodeUtil.unicodeCadenaString(cliente.getDatosFiscales().getColonia()));
//        }
//        if (!cliente.getDatosFiscales().getCodigoPostal().isEmpty()) {
//            uf.setCodigoPostal(UnicodeUtil.unicodeCadenaString(cliente.getDatosFiscales().getCodigoPostal()));
//        }
//        if (!cliente.getDatosFiscales().getPais().isEmpty()) {
//            uf.setPais(UnicodeUtil.unicodeCadenaString(cliente.getDatosFiscales().getPais()));
//        }
//        if (!cliente.getDatosFiscales().getEstadoFiscal().isEmpty()) {
//            uf.setEstado(UnicodeUtil.unicodeCadenaString(cliente.getDatosFiscales().getEstadoFiscal()));
//        }
//        if (!cliente.getDatosFiscales().getMunicipioFiscal().isEmpty()) {
//            uf.setMunicipio(UnicodeUtil.unicodeCadenaString(cliente.getDatosFiscales().getMunicipioFiscal()));
//        }
//        receptor.setDomicilio(uf);
        return receptor;
    }

    public static Conceptos createConceptos(ObjectFactory of, BigDecimal montoHonorarios, BigDecimal montoGastos) {
        Conceptos cps = of.createComprobanteConceptos();
        List<Concepto> list = cps.getConcepto();
        Concepto c1 = of.createComprobanteConceptosConcepto();
        c1.setUnidad("N/A");
        c1.setDescripcion("Honorario");
        c1.setCantidad(new BigDecimal("1.0"));
        c1.setImporte(montoHonorarios);
        c1.setValorUnitario(montoHonorarios);
        list.add(c1);
        if (montoGastos.compareTo(new BigDecimal("0")) == 1) {
            Concepto c2 = of.createComprobanteConceptosConcepto();
            c2.setUnidad("N/A");
            c2.setDescripcion("Gastos");
            c2.setCantidad(new BigDecimal("1.0"));
            c2.setImporte(montoGastos);
            c2.setValorUnitario(montoGastos);
            list.add(c2);
        }

        return cps;
    }

    public static Impuestos createImpuestos(ObjectFactory of, BigDecimal impuesto, BigDecimal tasa) {
        Impuestos imps = of.createComprobanteImpuestos();
        Traslados trs = of.createComprobanteImpuestosTraslados();
        List<Traslado> list = trs.getTraslado();
        Traslado t1 = of.createComprobanteImpuestosTrasladosTraslado();
        t1.setImporte(impuesto);
        t1.setImpuesto("IVA");
        t1.setTasa(tasa);
        list.add(t1);
        imps.setTraslados(trs);
        return imps;
    }

    public static Addenda createAddenda(ObjectFactory of) {
        Addenda addenda = of.createComprobanteAddenda();
        Company2 c = new Company2();
        c.transaction = new Transaction2();
        c.transaction.purchaseOrder = "4600364283";
        addenda.getAny().add(c);
        return addenda;
    }

    @XmlRootElement(name = "Company2")
    private final static class Company2 {

        @XmlElement(name = "Transaction2")
        Transaction2 transaction;
    }

    @XmlRootElement
    private final static class Transaction2 {

        @SuppressWarnings("unused")
        @XmlAttribute(name = "PurchaseOrder2")
        String purchaseOrder;
    }

}
