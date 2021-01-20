/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.MangedBean;

import app.web.DAO.imgDao;
import app.web.DaoImpl.ImgImpl;
import app.web.Utils.JsfUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named(value = "uploadFileBean")
@ManagedBean(name = "uploadFileBean")
@RequestScoped
@ViewScoped
public class UploadFileBean {

    @EJB
    private imgDao imgImpl;

    private JsfUtils jsfUtils = new JsfUtils();

    public UploadFileBean() {
    }

    public void upload(FileUploadEvent event) {
        try {
            UploadedFile archivoSubido = event.getFile();
            String nombreArchivo = archivoSubido.getFileName();

            /* Asignamos la ruta donde queremos que se guarden los archivos */
            File rutaArchivo = new File("/home/angel/Escritorio", nombreArchivo);

            InputStream inputStream = archivoSubido.getInputstream();
            this.imgImpl.setGuardarArchivos(inputStream, rutaArchivo);
            this.jsfUtils.getMessageDialog(true, "ACCION COMPLETADA", "Archivos transferidos de manera exitosa !!");
        } catch (IOException e) {
            this.jsfUtils.getMessageDialog(false, "Ocurrio un fallo", "Proceso NO completado, Fallo inesperado.");
            Logger.getLogger(UploadedFile.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
