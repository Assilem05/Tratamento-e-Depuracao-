package Tratamento_Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
     public static Connection getConexao(){
         Connection conn = null;
         try{
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
             System.out.println("conectado com sucesso!! Yeiiii :3");
         }
         catch(SQLException e){
             System.err.println(e);
         }
         return conn;
     }
     public static void inserir(String nome, int idade){
         Connection conn = Conexao.getConexao();
         PreparedStatement ins = null;
         try {
             ins = conn.prepareStatement("INSERT INTO tb_user VALUES(?,?,?)");
             ins.setInt(1, 0);
             ins.setString(2, nome);
             ins.setInt(3,idade);
             
             ins.executeUpdate();
             System.out.println("salvo com sucesso!! Yeiiii :3");
             
         } catch (SQLException ex) {
             System.out.println(ex);
         }
     }
     public static ArrayList<String> getUsers(){
         PreparedStatement sel = null;
         try{
             Connection conn = Conexao.getConexao();
             sel = conn.prepareStatement("SELECT * FROM tb_user");
             ResultSet res = sel.executeQuery();
             
             ArrayList<String> arr =  new ArrayList<String>();
             while(res.next()){
                 System.out.println("Nome:"+res.getString("nome"));
                 System.out.println("\r\n idade:"+res.getString("idade"));
                 System.out.println("\r\n -------------------------------");
                 
                 arr.add(res.getString("nome"));
             }
             System.out.println("todos foram selecionados");
             return arr;
         }
         catch(Exception e){
             System.out.println(e);
         }
         return null;
     }
     public static void main(String[] args){
        //Conexao.inserir("Izuku Midoriya ",16);
        //Conexao.getUsers();
        Conexao.getConexao();
    }
}
