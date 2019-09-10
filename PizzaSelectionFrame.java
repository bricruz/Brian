/,*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author B_Cru
 */
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class PizzaSelectionFrame extends JFrame
{
    //declare variables
    private final JLabel radioLabel;
    private final JRadioButton small;
    private final JRadioButton medium;
    private final JRadioButton large;
    private final ButtonGroup radioGroup;
    private final JLabel label;
    private final JComboBox<String> imagesJComboBox;
    private final JLabel checkboxLabel;
    private final JCheckBox mushroom;
    private final JCheckBox bacon;
    private final JButton orderButton;
    private String sizeSelected;
    private final Color[] colorValues = {Color.LIGHT_GRAY};
    int confirm = 0;
    //array with image names and array to rename images
    private static final String[] names = {"chicken.PNG", "pepperoni.PNG", "veggie.PNG"};
    private static final String[] namenames ={"Chicken","Pepperoni","Veggie"};
    private final Icon[] icons = {
        //gets images from array containing image names
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])),
        new ImageIcon(getClass().getResource(names[2]))};
            //pizzaframe
        public PizzaSelectionFrame()
        {
            //name pizza frame
            super("Pizza Selection");
            setLayout(new FlowLayout());

            //combo box with pizza image names
            imagesJComboBox = new JComboBox<String>(namenames);
            imagesJComboBox.setMaximumRowCount(3);

            //combo box item listener
            imagesJComboBox.addItemListener(
            new ItemListener()
            {
                @Override
                public void itemStateChanged(ItemEvent event)
                {

                    if(event.getStateChange() == ItemEvent.SELECTED)
                        label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
                }
            }
            );
            label = new JLabel(icons[0]);
            add(label);
            add(imagesJComboBox);
            getContentPane().setBackground(Color.LIGHT_GRAY);

            //radio buttons, radio button group
            radioLabel = new JLabel("Select Size:");
            add(radioLabel);
            small = new JRadioButton("Small", true);
            medium = new JRadioButton("Medium", false);
            large = new JRadioButton("Large", false);
            add(small);
            add(medium);
            add(large);

            radioGroup = new ButtonGroup();
            radioGroup.add(small);
            radioGroup.add(medium);
            radioGroup.add(large);



            //check box buttons

            checkboxLabel = new JLabel("Select Topping(s):");
            add(checkboxLabel);


            mushroom = new JCheckBox("mushroom");
            bacon = new JCheckBox("bacon");
            add(mushroom);
            add(bacon);


            //order button
            orderButton = new JButton("Submit Order");
            add(orderButton);

            ButtonHandler orderbuttonHandler = new ButtonHandler();
            orderButton.addActionListener(orderbuttonHandler);
        }
            //order button handler class
            private class ButtonHandler implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent event){

                PaymentFrame payFrame = new PaymentFrame();
                //payFrame.setVisible(true);

                if(small.isSelected()){
                sizeSelected = "Small";
            }
                else if(medium.isSelected()){
                        sizeSelected = "Medium";
                        }
                else {
                        sizeSelected = "Large";
            }

            if(mushroom.isSelected() == true && bacon.isSelected() == true){
                String mushroom = "mushrooms";
                String bacon = "bacon";
                JOptionPane.showOptionDialog(PizzaSelectionFrame.this,String.format("%s %s with %s and %s", sizeSelected,imagesJComboBox.getSelectedItem(),bacon,mushroom),"Order Summary",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);



            }


                else if(bacon.isSelected() == true){
                        String bacon = "bacon";
                        JOptionPane.showOptionDialog(PizzaSelectionFrame.this,String.format("%s %s with %s", sizeSelected,imagesJComboBox.getSelectedItem(),bacon),"Order Summary",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);

                        /*if(JOptionPane.CLOSED_OPTION == 0){


                        }
                        if(JOptionPane.CANCEL_OPTION == 0){

                        }
                        else{
                            PaymentFrame payFrame = new PaymentFrame();
                            payFrame.setVisible(true);
                            payFrame.setSize(600,250); //this was a test to see if I could make the JOptionPane close without opening the PayFrame but it did not work
                        }*/
                }


                else if(mushroom.isSelected() == true){
                        String mushroom = "mushroom";
                        confirm = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, String.format("%s %s with %s", sizeSelected,imagesJComboBox.getSelectedItem(),mushroom),"Order Summary",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
                        }
                        else{
                        confirm = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, String.format("%s %s", sizeSelected,imagesJComboBox.getSelectedItem()),"Order Summary",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
                        }
            //I tried putting various versions of the below if else statements within the other if else statements so that the payframe would not pop up if the user clicks cancel on the JOptionPane like you showed me after class but it still didn't work.

             if(confirm == JOptionPane.OK_OPTION){
                payFrame.setVisible(true);
                payFrame.setSize(600,250);
              }
            }
            }
}
