/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author AdrianoBenelliBastos
 */
public class ClientesDAO {

    public Boolean Cadastrar(Cliente obj) throws ClassNotFoundException {
        Boolean retorno = false;

        String sql = "INSERT INTO clientes (nome, rua, bairro, numero, cep, cidade, celular) "
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst = ConectaBancoDados.getPreparedStatement(sql);
        
        try {

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRua());
            pst.setString(3, obj.getBairro());
            pst.setString(4, obj.getNro());
            pst.setString(5, obj.getCep());
            pst.setString(6, obj.getCidade());
            pst.setString(7, obj.getCelular());

            Integer resultado = pst.executeUpdate();
            if (resultado > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao acessar banco" + ex.getMessage().toLowerCase());
        }

        return retorno;

    }
}
