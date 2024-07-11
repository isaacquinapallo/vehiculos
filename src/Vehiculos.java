import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class Vehiculos {

    public JPanel mainPanel;
    public JTextField placaTxt;
    public JTextField marcaTxt;
    public JTextField cilindrajeTxt;
    public JTextField combustibleTxt;
    public JTextField colorTxt;
    public JTextField propietarioTxt;
    public JTextField placaBusquedaTxt;
    public JButton ButtonRegistro;
    public JButton buttonBuscar;
    public JLabel informacionVehiculoTxt;
    public JButton borrarButton;

    public Vehiculos() {
        ButtonRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/vehiculos";
                String user="root";
                String password="123456";

                VariableVehiculos v1=new VariableVehiculos(placaTxt.getText(),marcaTxt.getText(),cilindrajeTxt.getText(),combustibleTxt.getText(),colorTxt.getText(),propietarioTxt.getText());
                //Insertar Datos

                String sql = "INSERT INTO datosvehiculo (Placa,Marca,Cilindraje,TipoDeCombustible,Color,Propietario) values(?,?,?,?,?,?)";

                try(Connection connection= DriverManager.getConnection(url,user,password)){
                    PreparedStatement cadenaPreparada= connection.prepareStatement(sql);
                    cadenaPreparada.setString(1, v1.getPlaca());
                    cadenaPreparada.setString(2, v1.getMarca());
                    cadenaPreparada.setString(3, v1.getCilindraje());
                    cadenaPreparada.setString(4, v1.getCombustible());
                    cadenaPreparada.setString(5, v1.getColor());
                    cadenaPreparada.setString(6, v1.getPropietario());
                    cadenaPreparada.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Registro actualizado exitosamente");

                }catch(SQLException a) {
                    System.out.println(a.getMessage());
                }

            }
        });

        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/vehiculos";
                String user="root";
                String password="123456";

                try(Connection connection= DriverManager.getConnection(url,user,password)) {
                    System.out.println("Conectado a Base de Datos");
                    String query = "select * from datosvehiculo where Placa='"+placaBusquedaTxt.getText()+"'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        informacionVehiculoTxt.setText(String.valueOf("Segun el regitro de la placa: "+resultSet.getString("Placa")+" de la marca: "+resultSet.getString("Marca")+" con cilindraje: "+resultSet.getString("Cilindraje")+", de color: "+resultSet.getString("Color")+", con tipo de Combustible"+resultSet.getString("TipoDeCombustible")+", del propietario: "+resultSet.getString("Propietario")));
                    }
                }catch(SQLException a) {
                    System.out.println(a.getMessage());
                }
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placaTxt.setText("");
                marcaTxt.setText("");
                cilindrajeTxt.setText("");
                combustibleTxt.setText("");
                colorTxt.setText("");
                propietarioTxt.setText("");
            }
        });
    }
}
