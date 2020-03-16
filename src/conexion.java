
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class conexion {
    static Connection conexion = null;
    static Statement sentencia;
    
    public static void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservacion","root","");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }
    }
    public static ArrayList<String> llcombo(){
        String fecha1=reserva.fecha;
        System.out.println(fecha1);
        String hora1=reserva.hora;
        System.out.println(hora1);
        ArrayList<String> Espac= new ArrayList<String>();
        ArrayList<String> ress= new ArrayList<String>();
        String q= "SELECT * FROM espacios";
        String p= "SELECT * FROM reserva WHERE FechaRes='"+fecha1+"' AND Horario='"+hora1+"'";
        try{
            PreparedStatement pst=conexion.prepareStatement(q);
            ResultSet res=pst.executeQuery();
            while(res.next()){
                Espac.add(res.getString(2));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            PreparedStatement pst1=conexion.prepareStatement(p);
            ResultSet rsE=pst1.executeQuery();
            while(rsE.next()){
                ress.add(rsE.getString(2));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        for(int i=0;i<Espac.size();i++){
            for(int j=0;j<ress.size();j++){
                if(Espac.get(i).equals(ress.get(j))){
                    Espac.remove(i);
                }
            }
        }
        return Espac;
    }
    
    public static void guardar(champs x){
        String ultimo = null;
        try{
            String sql= "INSERT INTO reserva (Espacio, Usuario, FechaRes, Horario) VALUES ('"+x.getEspacio()+"', '"+x.getId()+"', '"+x.getFecha()+"', '"+x.getHora()+"')";
            java.sql.Statement res= conexion.createStatement();
            
            res.executeUpdate(sql);
            
            PreparedStatement stmtr = conexion.prepareStatement("SELECT * FROM reserva ORDER BY id_reserva DESC");
            ResultSet rsr = stmtr.executeQuery();
            if(rsr.next()){
                ultimo = rsr.getString(1);
            }
            JOptionPane.showMessageDialog(null, "Tu número de reservación es: "+ultimo+"\n Es muy importante que anotes este número\n si deseas cancelar la reservación");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static ArrayList<String> llbjs(){
        ArrayList<String> Espac= new ArrayList<String>();
        String q= "SELECT Nombre_espacio FROM espacios ORDER BY Nombre_espacio ASC";
        try{
            PreparedStatement pst=conexion.prepareStatement(q);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                Espac.add(rs.getString("Nombre_espacio"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return Espac;
    }
    
}
