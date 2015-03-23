package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import ctrlayer.*;

public class ProductGUI extends JFrame {

	private ProductCtr pCtr;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPurchasePrice;
	private JTextField txtSalesPrice;
	private JTextField txtRentPrice;
	private JTextField txtCountryOfOrigin;
	private JTextField txtMinStock;
	private JTextField txtSupplierID;

	private JLabel lblMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductGUI frame = new ProductGUI();
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
	public ProductGUI() {
		pCtr = new ProductCtr();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Navn");
		lblName.setBounds(6, 19, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblPurchasePrice = new JLabel("Indkøbspris");
		lblPurchasePrice.setBounds(6, 47, 81, 16);
		contentPane.add(lblPurchasePrice);
		
		JLabel lblSalesPrice = new JLabel("Salgspris");
		lblSalesPrice.setBounds(6, 75, 81, 16);
		contentPane.add(lblSalesPrice);
		
		JLabel lblRentPrice = new JLabel("Lejepris");
		lblRentPrice.setBounds(6, 103, 61, 16);
		contentPane.add(lblRentPrice);
		
		JLabel lblCountryOfOrigin = new JLabel("Oprindelsesland");
		lblCountryOfOrigin.setBounds(6, 131, 102, 16);
		contentPane.add(lblCountryOfOrigin);
		
		JLabel lblMinStock = new JLabel("Mindstebeholdning");
		lblMinStock.setBounds(6, 159, 121, 16);
		contentPane.add(lblMinStock);
		
		JLabel lblSupplierID = new JLabel("Forhandler ID");
		lblSupplierID.setBounds(6, 187, 102, 16);
		contentPane.add(lblSupplierID);
		
		JButton btnBack = new JButton("Tilbage");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(6, 258, 102, 29);
		contentPane.add(btnBack);
		
		JButton btnCreateProduct = new JButton("Opret Produkt");
		btnCreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				double purchasePrice = Double.parseDouble(txtPurchasePrice.getText());
				double salesPrice = Double.parseDouble(txtSalesPrice.getText());
				double rentPrice = Double.parseDouble(txtRentPrice.getText());
				String countryOfOrigin = txtCountryOfOrigin.getText();
				int minStock = Integer.parseInt(txtMinStock.getText());
				int supplierID = Integer.parseInt(txtSupplierID.getText());
				
				
				try {
					pCtr.insertNewProduct(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, supplierID);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Fejl på e1!");
				}
				lblMessage.setVisible(true);
				lblMessage.setText("Produktet er oprettet.");
			}
		});
		btnCreateProduct.setBounds(107, 260, 121, 25);
		contentPane.add(btnCreateProduct);
		
		JButton btnFindProduct = new JButton("Find Produkt");
		btnFindProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pCtr.findByName(txtName.getText());
			}
		});
		btnFindProduct.setBounds(226, 260, 121, 25);
		contentPane.add(btnFindProduct);
		
		JButton btnDeleteProduct = new JButton("Slet Produkt");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pCtr.deleteProduct(txtName.getText()) > 0)
				{
				clearFields();
				lblMessage.setVisible(true);
				lblMessage.setText("Produktet er slettet.");
				}
				else
				{
					lblMessage.setVisible(true);
					lblMessage.setText("Produktet kunne ikke slettes.");
				}
			}
		});
		btnDeleteProduct.setBounds(353, 262, 121, 25);
		contentPane.add(btnDeleteProduct);
		
		JButton btnUpdateProduct = new JButton("Opdatér Produkt");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				double purchasePrice = Double.parseDouble(txtPurchasePrice.getText());
				double salesPrice = Double.parseDouble(txtSalesPrice.getText());
				double rentPrice = Double.parseDouble(txtRentPrice.getText());
				String countryOfOrigin = txtCountryOfOrigin.getText();
				int minStock = Integer.parseInt(txtMinStock.getText());
				int supplierID = Integer.parseInt(txtSupplierID.getText());
				
				int result = pCtr.updateProduct(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, supplierID);
				if(result == 1)
				{
					clearFields();
					lblMessage.setText("Produktet blev opdateret");
					lblMessage.setVisible(true);
				}
				else
				{
					lblMessage.setText("Produktet blev ikke opdateret");
					lblMessage.setVisible(true);
				}
			}
		});
		btnUpdateProduct.setBounds(353, 231, 121, 25);
		contentPane.add(btnUpdateProduct);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnClear.setBounds(379, 106, 121, 25);
		contentPane.add(btnClear);
		
		txtName = new JTextField();
		txtName.setBounds(132, 13, 150, 29);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPurchasePrice = new JTextField();
		txtPurchasePrice.setColumns(10);
		txtPurchasePrice.setBounds(132, 41, 150, 29);
		contentPane.add(txtPurchasePrice);
		
		txtSalesPrice = new JTextField();
		txtSalesPrice.setColumns(10);
		txtSalesPrice.setBounds(132, 69, 150, 29);
		contentPane.add(txtSalesPrice);
		
		txtRentPrice = new JTextField();
		txtRentPrice.setColumns(10);
		txtRentPrice.setBounds(132, 97, 150, 29);
		contentPane.add(txtRentPrice);
		
		txtCountryOfOrigin = new JTextField();
		txtCountryOfOrigin.setColumns(10);
		txtCountryOfOrigin.setBounds(132, 125, 150, 29);
		contentPane.add(txtCountryOfOrigin);
		
		txtMinStock = new JTextField();
		txtMinStock.setColumns(10);
		txtMinStock.setBounds(132, 153, 150, 29);
		contentPane.add(txtMinStock);
		
		txtSupplierID = new JTextField();
		txtSupplierID.setColumns(10);
		txtSupplierID.setBounds(132, 181, 150, 29);
		contentPane.add(txtSupplierID);
		
		lblMessage = new JLabel("Message");
		lblMessage.setBounds(6, 299, 102, 16);
		contentPane.add(lblMessage);
		lblMessage.setVisible(false);
		
		
	}
	
	private void clearFields()
	{
		txtName.setText("");
		txtPurchasePrice.setText("");
		txtSalesPrice.setText("");
		txtRentPrice.setText("");
		txtMinStock.setText("");
		txtSupplierID.setText("");
		lblMessage.setVisible(false);
	}
	
	
}
