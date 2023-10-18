/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Clientes;
import java.util.LinkedList;

/**
 *
 * @author LuikFear
 */
public interface DAOCLientesInterface {

  

        public LinkedList<Clientes> listar();

        public Clientes obtener_cliente(int codigo);

        public void crear_cliente(Clientes cliente);

        public void modificar_cliente(Clientes cliente);

        public void eliminar_cliente(int codigo);
    }


