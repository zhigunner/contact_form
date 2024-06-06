package com.itproger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    JTextField firstName_field, lastName_field, age_field, phoneNumber_field, email_field;
    JRadioButton male, female;
    JCheckBox check;

    public ContactForm() {
        super("Application to join FIGHT CLUB");
        super.setBounds(200, 100, 500, 250);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(8, 2, 2, 10));

        JLabel firstName = new JLabel(" first name: ");
        firstName_field = new JTextField("",1);
        JLabel lastName = new JLabel(" last name: ");
        lastName_field = new JTextField("",1);
        JLabel age = new JLabel(" age: ");
        age_field = new JTextField("",1);
        JLabel phoneNumber = new JLabel(" phone number: ");
        phoneNumber_field = new JTextField("",1);
        JLabel email = new JLabel(" email address: ");
        email_field = new JTextField("",1);
        male = new JRadioButton("male");
        female = new JRadioButton("female");
        check = new JCheckBox("Agreement", false);
        JButton send_button = new JButton("Submit the form");

        container.add(firstName);
        container.add(firstName_field);
        container.add(lastName);
        container.add(lastName_field);
        container.add(age);
        container.add(age_field);
        container.add(phoneNumber);
        container.add(phoneNumber_field);
        container.add(email);
        container.add(email_field);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(send_button);

        send_button.addActionListener(new ButtonEventManager());
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String firstName = firstName_field.getText();
            String lastName = lastName_field.getText();
            String age = age_field.getText();
            String phoneNumber = phoneNumber_field.getText();
            String email = email_field.getText();

            String gender = "Male";
            if(!male.isSelected()) {
                gender = "Female";
            }
            String agreementMessage = "";

            if(check.isSelected()) {
                agreementMessage = "You agree with our rules";
            } else {
                agreementMessage = "You don't agree with our rules";
            }

            String finalMessage = "";
            if(agreementMessage.equals("You agree with our rules")) {
                finalMessage = "Your application is being reviewed, if you're a good fit we'll get back to you. And remember \"The first rule about fight club is you don’t talk about fight club.\"";
            } else if(agreementMessage.equals("You don't agree with our rules")) {
                finalMessage = "Our rules are very important to us, fill out the application again";
            } else {
                finalMessage = "Error";
            }

            JOptionPane.showMessageDialog(null,
                    "first name: " + firstName +
                            "\nlast name: " + lastName +
                            "\nage: " + age +
                            "\nphone number: " + phoneNumber +
                            "\nemail: " + email +
                            "\ngender " + gender +
                            "\n" + agreementMessage +
                            "\n" + finalMessage,
                    "Fighter Data", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
