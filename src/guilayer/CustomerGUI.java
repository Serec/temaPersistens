package guilayer;
import ctrlayer.*;
import dblayer.*;
import modellayer.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerGUI extends JFrame {

	private CustomerCtr cCtr;

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtZipCode;
	private JTextField txtCity;
	private JTextField txtPhoneNo;
	private JLabel lblMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGUI frame = new CustomerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerGUI() {
		cCtr = new CustomerCtr();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNavn = new JLabel("Navn");
		lblNavn.setBounds(39, 67, 46, 14);
		contentPane.add(lblNavn);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(39, 92, 71, 14);
		contentPane.add(lblAdresse);

		JLabel lblPostnr = new JLabel("Postnr.");
		lblPostnr.setBounds(39, 117, 46, 14);
		contentPane.add(lblPostnr);

		JLabel lblBy = new JLabel("By");
		lblBy.setBounds(39, 146, 46, 14);
		contentPane.add(lblBy);

		JLabel lblTelefonNr = new JLabel("Telefon nr.");
		lblTelefonNr.setBounds(39, 170, 71, 14);
		contentPane.add(lblTelefonNr);

		txtName = new JTextField();
		txtName.setBounds(147, 64, 156, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(147, 89, 156, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		txtZipCode = new JTextField();
		txtZipCode.setBounds(147, 117, 156, 20);
		contentPane.add(txtZipCode);
		txtZipCode.setColumns(10);

		txtCity = new JTextField();
		txtCity.setBounds(147, 143, 156, 20);
		contentPane.add(txtCity);
		txtCity.setColumns(10);

		txtPhoneNo = new JTextField();
		txtPhoneNo.setBounds(147, 167, 156, 20);
		contentPane.add(txtPhoneNo);
		txtPhoneNo.setColumns(10);

		JButton btnOpretKunde = new JButton("Opret kunde");
		btnOpretKunde.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				String address = txtAddress.getText();
				String zipCode = txtZipCode.getText();
				String phoneNo = txtPhoneNo.getText();
				try {
					cCtr.insertNewCustomer(name, address, zipCode, phoneNo);
					lblMessage.setVisible(true);
					lblMessage.setText("Kunden er oprettet.");
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnOpretKunde.setBounds(147, 196, 104, 23);
		contentPane.add(btnOpretKunde);

		JButton btnTilbage = new JButton("Tilbage");
		btnTilbage.setBounds(39, 196, 89, 23);
		contentPane.add(btnTilbage);

		JButton btnFindKunde = new JButton("Find kunde");
		btnFindKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String phoneNo = txtPhoneNo.getText();
				Customer cus = cCtr.findByPhoneNo(phoneNo);
				txtName.setText(cus.getName());
				txtAddress.setText(cus.getAddress());
				txtZipCode.setText(cus.getZipCode());
			}
		});
		btnFindKunde.setBounds(261, 196, 98, 23);
		contentPane.add(btnFindKunde);

		JButton btnOpdaterKunde = new JButton("Opdater kunde");
		btnOpdaterKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String address = txtAddress.getText();
				String zipCode = txtZipCode.getText();
				String phoneNo = txtPhoneNo.getText();
				
				int result = cCtr.updateCustomer(name, address, zipCode, phoneNo);
				if(result == 1)
				{
					clearFields();
				}
				else
				{
					lblMessage.setText("Kunden blev ikke opdateret");
					lblMessage.setVisible(true);
				}
				
			}
		});
		btnOpdaterKunde.setBounds(369, 196, 124, 23);
		contentPane.add(btnOpdaterKunde);

		JButton btnSletKunde = new JButton("Slet kunde");
		btnSletKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phoneNo = txtPhoneNo.getText();
				cCtr.deleteCustomer(phoneNo);
				clearFields();
				lblMessage.setVisible(true);
				lblMessage.setText("Kunden er slettet.");
				
			}
		});
		btnSletKunde.setBounds(503, 196, 104, 23);
		contentPane.add(btnSletKunde);
		
		lblMessage = new JLabel("Message");
		lblMessage.setBounds(39, 240, 524, 14);
		contentPane.add(lblMessage);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnClear.setBounds(369, 166, 89, 23);
		contentPane.add(btnClear);
		lblMessage.setVisible(false);
	}

	private void clearFields()
	{
		txtName.setText("");
		txtAddress.setText("");
		txtZipCode.setText("");
		txtCity.setText("");
		txtPhoneNo.setText("");
		lblMessage.setVisible(false);
	}





















}
