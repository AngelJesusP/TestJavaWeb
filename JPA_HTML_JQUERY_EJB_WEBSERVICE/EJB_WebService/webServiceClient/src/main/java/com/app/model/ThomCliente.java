/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.util.Date;

/**
 *
 * @author angel
 */
public class ThomCliente {

    private Integer nmCliente;
    private String cdCliente;
    private String dnNombre;
    private String dnDireccion;
    private String dnEmail;
    private Date fechaRegistro;
    private Date fechaBaja;
    private String cdUsuario;
    private String sActivo;
    private String cdTelefono;
    private String dsContacto;
    private String dsLogo;

    public ThomCliente() {
    }

    public ThomCliente(Integer nmCliente) {
        this.nmCliente = nmCliente;
    }

    public ThomCliente(Integer nmCliente, String dnNombre, String dnEmail, Date fechaRegistro, Date fechaBaja, String cdUsuario) {
        this.nmCliente = nmCliente;
        this.dnNombre = dnNombre;
        this.dnEmail = dnEmail;
        this.fechaRegistro = fechaRegistro;
        this.fechaBaja = fechaBaja;
        this.cdUsuario = cdUsuario;
    }

    
    
    public Integer getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(Integer nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(String cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getDnNombre() {
        return dnNombre;
    }

    public void setDnNombre(String dnNombre) {
        this.dnNombre = dnNombre;
    }

    public String getDnDireccion() {
        return dnDireccion;
    }

    public void setDnDireccion(String dnDireccion) {
        this.dnDireccion = dnDireccion;
    }

    public String getDnEmail() {
        return dnEmail;
    }

    public void setDnEmail(String dnEmail) {
        this.dnEmail = dnEmail;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(String cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getSActivo() {
        return sActivo;
    }

    public void setSActivo(String sActivo) {
        this.sActivo = sActivo;
    }

    public String getCdTelefono() {
        return cdTelefono;
    }

    public void setCdTelefono(String cdTelefono) {
        this.cdTelefono = cdTelefono;
    }

    public String getDsContacto() {
        return dsContacto;
    }

    public void setDsContacto(String dsContacto) {
        this.dsContacto = dsContacto;
    }

    public String getDsLogo() {
        return dsLogo;
    }

    public void setDsLogo(String dsLogo) {
        this.dsLogo = dsLogo;
    }

}
