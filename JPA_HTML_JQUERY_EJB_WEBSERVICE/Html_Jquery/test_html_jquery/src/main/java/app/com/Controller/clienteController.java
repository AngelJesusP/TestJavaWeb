/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.com.Controller;

import app.com.Entity.ThomClienteEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.com.DAO.ClienteImp;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

/**
 *
 * @author angel
 */
@WebServlet(name = "clienteController", urlPatterns = {"/clienteController"})
public class clienteController extends HttpServlet {

    private ThomClienteEntity cliente;
    private ClienteImp clienteImpl = new ClienteImp();
    private List<ThomClienteEntity> lista;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        this.lista = this.clienteImpl.getListarClientes();
        int cantidad = this.lista.size();

        JSONObject objetos;
        JSONArray array = new JSONArray();
        for (int i = 0; i < cantidad; i++) {
            objetos = new JSONObject();
            objetos.put("nm_cliente", this.lista.get(i).getNmCliente());
            objetos.put("cd_cliente", this.lista.get(i).getCdCliente());
            objetos.put("dn_nombre", this.lista.get(i).getDnNombre());
            objetos.put("dn_direccion", this.lista.get(i).getDnDireccion());
            objetos.put("dn_email", this.lista.get(i).getDnEmail());
            objetos.put("fecha_registro", this.lista.get(i).getFechaRegistro());
            objetos.put("fecha_baja", this.lista.get(i).getFechaBaja());
            objetos.put("cd_usuario", this.lista.get(i).getCdUsuario());
            objetos.put("s_activo", this.lista.get(i).getSActivo());
            objetos.put("cd_telefono", this.lista.get(i).getCdTelefono());
            objetos.put("ds_contacto", this.lista.get(i).getDsContacto());
            objetos.put("ds_logo", this.lista.get(i).getDsLogo());

            array.put(objetos);
        }
        out.print(array.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            /* Objeto JSON para crear un Json que retorne un message y status */
            JSONObject objetos = new JSONObject();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate;
            Timestamp timestamp;
            Date fecha = new Date();
            boolean respuesta;
            switch (accion) {
                case "add": { /* Metodo para agregar un nuevo cliente a la base de datos */
                    parsedDate = dateFormat.parse(request.getParameter("fecha_baja"));
                    timestamp = new Timestamp(parsedDate.getTime());

                    Timestamp timeActual = new Timestamp(fecha.getTime());
                    Timestamp myTimeStamp = timeActual;

                    this.cliente = new ThomClienteEntity();
                    this.setLlenarObjetoCliente(request);
                    this.cliente.setFechaBaja(timestamp);
                    this.cliente.setFechaRegistro(myTimeStamp);

                    respuesta = this.clienteImpl.setRegistroCliente(cliente);
                    objetos.put("message", (respuesta) ? "Registro completado" : "Ocurrio un fallo");
                    objetos.put("status", (respuesta) ? 200 : 500);

                    out.print(objetos.toString());
                }
                break;
                case "remove": { /* Metodo para eliminar un cliente de la base de datos */
                    Integer nm_cliente = Integer.parseInt(request.getParameter("nm_cliente"));
                    respuesta = this.clienteImpl.setEliminarCliente(nm_cliente);
                    objetos.put("message", (respuesta) ? "Eliminacion completa" : "Ocurrio un fallo");
                    objetos.put("status", (respuesta) ? 200 : 500);
                    out.print(objetos.toString());
                }
                break;
                case "update": { /* Metodo para realizar una actualizacion del cliente */
                    this.cliente = new ThomClienteEntity();
                    ThomClienteEntity clienteTemp = this.clienteImpl.setBuscarCliente(Integer.parseInt(request.getParameter("nm_cliente")));

                    if (!request.getParameter("fecha_baja").equals("")) {
                        parsedDate = dateFormat.parse(request.getParameter("fecha_baja"));
                        timestamp = new Timestamp(parsedDate.getTime());
                        this.cliente.setFechaBaja(timestamp);
                    } else {
                        this.cliente.setFechaBaja(clienteTemp.getFechaBaja());
                    }
                    this.cliente.setFechaRegistro(clienteTemp.getFechaRegistro());
                    this.setLlenarObjetoCliente(request);
                    respuesta = this.clienteImpl.setActualizarCliente(cliente);
                    objetos.put("message", (respuesta) ? "Actualizacion completado" : "Ocurrio un fallo");
                    objetos.put("status", (respuesta) ? 200 : 500);

                    out.print(objetos.toString());
                }
                break;
                default:
                    throw new AssertionError();
            }
        } catch (ParseException ex) {
            Logger.getLogger(clienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setLlenarObjetoCliente(HttpServletRequest request) {
        this.cliente.setNmCliente(Integer.parseInt(request.getParameter("nm_cliente")));
        this.cliente.setCdCliente(request.getParameter("cd_cliente"));
        this.cliente.setDnNombre(request.getParameter("dn_nombre"));
        this.cliente.setDnDireccion(request.getParameter("dn_direccion"));
        this.cliente.setDnEmail(request.getParameter("dn_email"));
        this.cliente.setCdUsuario(request.getParameter("cd_usuario"));
        this.cliente.setSActivo(request.getParameter("s_activo"));
        this.cliente.setCdTelefono(request.getParameter("cd_telefono"));
        this.cliente.setDsContacto(request.getParameter("ds_contacto"));
        this.cliente.setDsLogo(request.getParameter("ds_logo"));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
