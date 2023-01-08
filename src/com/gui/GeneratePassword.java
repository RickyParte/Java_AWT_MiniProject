package com.gui;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Random;


public class GeneratePassword{
	
	/*
	 * length- password length
	 */
 	public String generatePassword(int length) {
 
		String generatedPassword="";
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
  
        // Concate all string which is declare upper
        String values = Capital_chars + Small_chars +
                        numbers + symbols;
  
        // Using random method
        Random random = new Random();
  
        char[] password = new char[length];
  
        for (int i = 0; i < length; i++)
        {
            password[i]=values.charAt(random.nextInt(values.length()));
  
        }
        generatedPassword=new String(password);
		return generatedPassword;
		
	}

	public static void main(String[] args) throws UnsupportedFlavorException,IOException{

		// Login Frame
		Frame login=new Frame("Login Page");
		Label loginLable,loginUser,loginPass;
		Font f=new Font("Serif",Font.BOLD,14);
		TextField loginUsername,loginPassword;
		loginLable=new Label("Login");
		
		// Generate Password Frame
		Frame frame = new Frame("Generate Password");
		Label label, user, pass;
		Font f1 = new Font("Serif", Font.BOLD, 20);
		Font f2 = new Font("", Font.BOLD,20);
		TextField password;
		
		loginLable.setFont(f);
	    loginLable.setBounds(50, 50, 200, 30);    
	    login.add(loginLable);
	    loginLable.setAlignment(Label.CENTER);
	    
	    // Label for username and password
	    loginUser=new Label("Enter The Username");
	    loginPass=new Label("Enter The Password");
	    loginUser.setBounds(50, 70, 200, 30);    
	    loginPass.setBounds(50, 140, 200, 30);   
	    login.add(loginUser);
	    login.add(loginPass);
	    
	    // TextFields of Username and password
	    loginUsername=new TextField();
	    loginPassword=new TextField();
	    loginUsername.setBounds(50, 100, 200, 30);    
	    loginPassword.setBounds(50, 170, 200, 30);    
	    login.add(loginUsername);
	    login.add(loginPassword);
	    
	    // button for login
	    Button loginButton=new Button("Click To Login");
	    loginButton.setBounds(50,220,200,20);
	    login.add(loginButton);
	    
	    // button action perform
	    loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String textFieldUser=loginUsername.getText();
				String textFieldPass=loginPassword.getText();
				String loginUsernameLogin="Test";
				String passwordLogin="Test";
				Button ok=new Button("Ok");
				
				// password and username matching
				if(loginUsernameLogin.equals(textFieldUser) && passwordLogin.equals(textFieldPass)) {
					login.setVisible(false);
//					d.setVisible(false);
					frame.setSize(400, 400);
					frame.setLayout(null);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							System.exit(0);
						}
					});
				}
				else {
					Dialog d=new Dialog(login,"Login Status");
					d.setLayout(new FlowLayout());
					d.add(new Label("Login Failed!!!! Please Enter Correct Credentials"));
					d.add(ok);
					loginUsername.setText("");
					loginPassword.setText("");
//					d.setVisible(false);
					ok.addActionListener(new ActionListener()  
			        {  
			            public void actionPerformed(ActionEvent e)  
			            {  
			                d.setVisible(false);  
			            }  
			        }); 
					
					d.setSize(300,300);    
			        d.setVisible(true);
				}
				
				
				
			}
		});
	    
	    
	    
		

		
		
		
		label = new Label("Password Generator");
		GeneratePassword gn=new GeneratePassword();

		label.setFont(f1);
		label.setBounds(50, 50, 200, 30);
		frame.add(label);
		label.setAlignment(Label.CENTER);

		pass = new Label("Enter The Password");
		pass.setBounds(50, 140, 200, 30);
		frame.add(pass);

		password = new TextField();
		password.setEnabled(false);
		password.setFont(f2);
		
//		password.setEditable(true);
		password.setBounds(50, 170, 200, 30);
		frame.add(password);
		
		Choice choice=new Choice();
		choice.setBounds(50,210,200,30);
		choice.add("8");
		choice.add("9");
		choice.add("10");
		choice.add("11");
		choice.add("12");
		choice.add("13");
		frame.add(choice);

		Button b = new Button("Generate Password");
		b.setBounds(50, 280, 200, 20);
		frame.add(b);
		Button copy = new Button("Copy Password");
		copy.setBounds(50, 320, 200, 20);
		frame.add(copy);
		
		
		

		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int len=8;
				if(choice.getSelectedItem().equals("8")) {
					len=Integer.parseInt(choice.getSelectedItem());
				}
				else if(choice.getSelectedItem().equals("9")) {
					len=Integer.parseInt(choice.getSelectedItem());
				}
				else if(choice.getSelectedItem().equals("10")) {
					len=Integer.parseInt(choice.getSelectedItem());
				}
				else if(choice.getSelectedItem().equals("10")) {
					len=Integer.parseInt(choice.getSelectedItem());
				}
				else if(choice.getSelectedItem().equals("11")) {
					len=Integer.parseInt(choice.getSelectedItem());
				}
				else if(choice.getSelectedItem().equals("12")) {
					len=Integer.parseInt(choice.getSelectedItem());
				}
				else if(choice.getSelectedItem().equals("13")) {
					len=Integer.parseInt(choice.getSelectedItem());
				}
				String getPass=gn.generatePassword(len);	
				password.setText(getPass);
				Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection str=new StringSelection(getPass);
				c.setContents(str, str);
			}
		});
		
		
		Button ok=new Button("Ok!! Please Click ");
		
		copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Dialog d=new Dialog(login,"Text Copied!!!!");
				d.setLayout(new FlowLayout());
				d.add(new Label("Text Copiedd......!!!!!!"));
				d.add(ok);
				loginUsername.setText("");
				loginPassword.setText("");
//				d.setVisible(false);
				ok.addActionListener(new ActionListener()  
		        {  
		            public void actionPerformed(ActionEvent e)  
		            {  
		                d.setVisible(false);  
		            }  
		        }); 
				
				d.setSize(300,300);    
		        d.setVisible(true);
				
			}
		});
		

		login.setSize(400,400);
	    login.setLayout(null);
	    login.setVisible(true);
	    login.addWindowListener(new WindowAdapter(){
	    	  public void windowClosing(WindowEvent we){
	    	    System.exit(0);
	    	  }
	    	});

	}

}
