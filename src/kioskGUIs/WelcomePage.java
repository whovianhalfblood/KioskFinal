/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kioskGUIs;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author durlicla000
 */
public class WelcomePage {
    public static void show() {

    JFrame f = new JFrame("Pizza Pie Cafe Text Program");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(250, 250);
    f.setLocation(300,200);
    
    JTextArea textArea = new JTextArea();
    textArea.setBounds(5, 5, 250, 20);
    textArea.append("Welcome to Pizza Pie Cafe.");
    
    JButton checkIn = new JButton("Rewards Check-in");
        checkIn.setMnemonic(KeyEvent.VK_S);
        checkIn.setBounds(50, 60, 195, 50);
        checkIn.addActionListener((ActionEvent e) -> {
            CheckInPage.show();
        });
    
    f.add(textArea);
    f.add(checkIn);
    
    f.setLayout(null);
    f.setVisible(true);

  }
  
}
