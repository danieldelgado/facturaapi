/**
 * AdvanswsdlPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dev.advans.wsdl;

public interface AdvanswsdlPortType extends java.rmi.Remote {

    /**
     * Método para timbrado de CFDI's
     */
    public dev.advans.wsdl.RespuestaTimbre timbrar(java.lang.String credential, java.lang.String cfdi) throws java.rmi.RemoteException;

    /**
     * Método alternativo para timbrado de CFDI's en el que regresa
     * el CFDI completo en vez de solo el timbre.
     */
    public dev.advans.wsdl.RespuestaTimbre2 timbrar2(java.lang.String credential, java.lang.String cfdi) throws java.rmi.RemoteException;

    /**
     * Método para cancelación de CFDI's
     */
    public dev.advans.wsdl.RespuestaCancelacion cancelar(java.lang.String credential, java.lang.String rfc_emisor, java.lang.String uuid, java.lang.String key, java.lang.String cer) throws java.rmi.RemoteException;

    /**
     * Método para cancelación de CFDI's
     */
    public dev.advans.wsdl.RespuestaCancelacion cancelarPFXSync(java.lang.String credential, java.lang.String rfc_emisor, java.lang.String uuid, java.lang.String pfx, java.lang.String pfx_password) throws java.rmi.RemoteException;

    /**
     * Método para consultar estado de los timbres
     */
    public dev.advans.wsdl.RespuestaConsulta consultar(java.lang.String credential, java.lang.String uuid) throws java.rmi.RemoteException;

    /**
     * Método para consultar estado de los timbres (Responde CFDI
     * completo)
     */
    public dev.advans.wsdl.RespuestaConsulta consultar_cfdi(java.lang.String credential, java.lang.String uuid) throws java.rmi.RemoteException;
}
