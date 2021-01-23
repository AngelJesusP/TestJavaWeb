/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  angel
 * Created: 16-ene-2021
 */

DROP DATABASE IF EXISTS test_html_jquery;
CREATE DATABASE IF NOT EXISTS test_html_jquery;
USE test_html_jquery;

CREATE TABLE IF NOT EXISTS thom_cliente(
    nm_cliente INTEGER PRIMARY KEY,
    cd_cliente VARCHAR(15),
    dn_nombre VARCHAR(120) NOT NULL,
    dn_direccion VARCHAR(120),
    dn_email VARCHAR(150) NOT NULL,
    fecha_registro TIMESTAMP NOT NULL DEFAULT current_timestamp,
    fecha_baja TIMESTAMP NOT NULL,
    cd_usuario VARCHAR(120) NOT NULL,
    s_activo VARCHAR(1),
    cd_telefono VARCHAR(60),
    ds_contacto VARCHAR(120),
    ds_logo VARCHAR(50)
);