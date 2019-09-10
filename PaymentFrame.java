/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author B_Cru
 */
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.JPanel;


public class PaymentFrame extends JFrame 
{
    
    //declare variables
    private final JTextField name;
    private final JTextField address;
    private final JTextField creditcard;
    private final JTextField expdate;
    private final JTextField cvc;
    
    private final JLabel nameLabel;
    private final JLabel addressLabel;
    private final JLabel creditcardLabel;
    private final JLabel expdateLabel;
    private final JLabel cvcLabel;
    
    private final Color[] colorValues = {Color.LIGHT_GRAY};
    private final JButton payButton;
    
    public PaymentFrame(){
        //payframe name background flowlayout
        super("Payment");
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2,5,5));
        
        //labels and textfields
        nameLabel = new JLabel("Name and Surname:");
        add(nameLabel);
        name = new JTextField(20); 
        add(name); 
        
        addressLabel = new JLabel("Address:");
        add(addressLabel);
        address = new JTextField(20);
        add(address);
        
        
        creditcardLabel = new JLabel("Credit Card Number:");
        add(creditcardLabel);
        creditcard = new JTextField(20);
        add(creditcard);
        
        expdateLabel = new JLabel("Expiration Date:");
        add(expdateLabel);
        expdate = new JTextField(20);
        add(expdate);
        
        cvcLabel = new JLabel("CVC:");
        add(cvcLabel);
        cvc = new JTextField(20);
        add(cvc);
        
        //panels for gridlayout
        panel.add(nameLabel);
        panel.add(name);
        panel.add(addressLabel);
        panel.add(address);
        panel.add(creditcardLabel);
        panel.add(creditcard);
        panel.add(expdateLabel);
        panel.add(expdate);
        panel.add(cvcLabel);
        panel.add(cvc);
        //paybutton
        payButton = new JButton("Pay");
        
        
        panel.add(payButton);
        super.add(panel);
       
   //button handler and button handler inner class implements actionlistener overrides action performed
        ButtonHandler payButtonHandler = new ButtonHandler();
        payButton.addActionListener(payButtonHandler);
    }
        private class ButtonHandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event){
                
                JOptionPane.showMessageDialog(PaymentFrame.this, String.format("Your order will be delivered in 30 minutes", event.getActionCommand()));
                if(JOptionPane.OK_OPTION == 0 || JOptionPane.CLOSED_OPTION == 0){
                  System.exit(0);  
                }
                
    }
}
}
