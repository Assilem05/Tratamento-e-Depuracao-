package Tratamento_Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BancoDeDados  {
     public static Connection getConexao(){
         Connection conn = null;
         try{
             
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/Banco","root","");
             System.out.println("conectado com sucesso!! Yeiiii :3");
         }
            catch(SQLException e){
                
             System.err.println(e);
         }
            return conn;
     }
     
     public static void inserir(int val1, int val2){
         
         int resultado = val1+val2;
         Connection conn = BancoDeDados .getConexao();
         PreparedStatement ins = null;
         try {
             
             ins = conn.prepareStatement("INSERT INTO adicao VALUES(?,?,?,?)");
             ins.setInt(1, 0);
             ins.setInt(2, val1);
             ins.setInt(3, val2);
             ins.setInt(4, resultado);
             
             ins.executeUpdate();
             System.out.println("salvo com sucesso!! Yeiiii :3");
             
         } catch (SQLException ex) 
         {
             System.out.println(ex);
         }
     }
     public static ArrayList<String> getResults()
     {
         PreparedStatement sel = null;
         try{
             Connection conn = BancoDeDados .getConexao();
             sel = conn.prepareStatement("SELECT * FROM adicao");
             ResultSet res = sel.executeQuery();
             
             ArrayList<String> arr =  new ArrayList<String>();
             while(res.next())
             {
                 System.out.println("Val 1:"+res.getInt("val1"));
                 System.out.println("\r\n Val 2:"+res.getInt("val2"));
                 System.out.println("\r\n Adição:"+res.getInt("res"));
                 System.out.println("\r\n -------------------------------");
            }
             System.out.println("todos foram selecionados");
             return arr;
            }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return null;
     }
     public static void main(String[] args)
     {
        //Conexao.inserir("Izuku Midoriya",16);
        //Conexao.getUsers();
        BancoDeDados .getConexao();
     }
}
