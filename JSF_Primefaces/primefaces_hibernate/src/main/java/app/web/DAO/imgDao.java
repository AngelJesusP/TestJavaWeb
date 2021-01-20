/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.DAO;

import java.io.InputStream;
import java.io.File;

/**
 *
 * @author angel
 */
public interface imgDao {
    
    public void setGuardarArchivos(InputStream inputStream, File file);
    
}
