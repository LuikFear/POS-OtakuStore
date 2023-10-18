/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Vendedores;
import java.util.LinkedList;


public interface DAOVendedoresInterface {
    
        public LinkedList<Vendedores> listarV();

        public Vendedores obtener_vendedor(int codigo);

        public void crear_vendedor(Vendedores vendedor);

        public void modificar_vendedor(Vendedores vendedor);

        public void eliminar_vendedor(int codigo);
}
