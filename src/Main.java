import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Datos Vehiculos");
        frame.setContentPane(new Vehiculos().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(20000, 1000);
        frame.pack();
        frame.setVisible(true);
    }
}