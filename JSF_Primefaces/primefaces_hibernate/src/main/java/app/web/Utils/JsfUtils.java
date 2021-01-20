/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.Utils;

import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

public class JsfUtils {

    private FacesMessage message;
    
    public void getMessageDialog(boolean opcion, String titulo, String mensaje) {
        message = new FacesMessage((opcion)? FacesMessage.SEVERITY_INFO : FacesMessage.SEVERITY_ERROR, titulo, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
}
