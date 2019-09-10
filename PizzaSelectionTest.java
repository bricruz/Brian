/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author B_Cru
 */

import javax.swing.JFrame;

public class PizzaSelectionTest
{
    public static void main(String[] args)
    {
        PizzaSelectionFrame pizzaFrame = new PizzaSelectionFrame();
        pizzaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pizzaFrame.setSize(325,300);
        pizzaFrame.setVisible(true);
        
        PaymentFrame payFrame = new PaymentFrame();
        payFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        payFrame.setSize(600,250);
        payFrame.setVisible(false);
       
        
    }
}

