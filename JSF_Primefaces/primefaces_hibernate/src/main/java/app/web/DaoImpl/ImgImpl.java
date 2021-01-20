/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.DaoImpl;

import app.web.DAO.imgDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author angel
 */
@Stateless
public class ImgImpl implements imgDao {
    
    @Override
    public void setGuardarArchivos(InputStream inputStream, File file) {
        try {
            OutputStream output = new FileOutputStream(file);
            IOUtils.copy(inputStream, output);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImgImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImgImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
