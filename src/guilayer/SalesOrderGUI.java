package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ctrlayer.CustomerCtr;
import ctrlayer.ProductCtr;
import modellayer.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;

public class SalesOrderGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtZipCode;
	private JTextField txtAddress;
	private JTextField txtPhoneNo;
	private JTextField txtSearchProduct;
	private JTable table;
	private JTable table_1;
	private CustomerCtr cCtr;
	private ProductCtr pCtr;
	private DefaultTableModel model;
	private DefaultTableModel model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesOrderGUI frame = new SalesOrderGUI();
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
	public SalesOrderGUI() {
		cCtr = new CustomerCtr();
		pCtr = new ProductCtr();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDato = new JLabel("Dato");
		lblDato.setBounds(10, 11, 145, 14);
		contentPane.add(lblDato);
		
		JLabel lblKundeoplysninger = new JLabel("Kundeoplysninger");
		lblKundeoplysninger.setBounds(10, 55, 169, 14);
		contentPane.add(lblKundeoplysninger);
		
		txtName = new JTextField();
		txtName.setBounds(10, 80, 125, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtZipCode = new JTextField();
		txtZipCode.setBounds(10, 111, 125, 20);
		contentPane.add(txtZipCode);
		txtZipCode.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(145, 80, 169, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(155, 114, 79, 14);
		contentPane.add(lblCity);
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.setBounds(324, 80, 114, 20);
		contentPane.add(txtPhoneNo);
		txtPhoneNo.setColumns(10);
		
		JButton btnSearchCustomer = new JButton("S\u00F8g");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phoneNo = txtPhoneNo.getText();
				Customer cus = cCtr.findByPhoneNo(phoneNo);				
				txtName.setText(cus.getName());
				txtAddress.setText(cus.getAddress());
				txtZipCode.setText(cus.getZipCode());
				lblCity.setText(cus.getLoc().getCity());
			}
		});
		btnSearchCustomer.setBounds(324, 110, 89, 23);
		contentPane.add(btnSearchCustomer);
		
		txtSearchProduct = new JTextField();
		txtSearchProduct.setBounds(10, 180, 125, 20);
		contentPane.add(txtSearchProduct);
		txtSearchProduct.setColumns(10);
		
		JButton btnSearchProduct = new JButton("S\u00F8g");
		btnSearchProduct.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String productName = txtSearchProduct.getText();
				Product pro = pCtr.findByName(productName);
				sletTabel();
				model.addRow(new Object[]{pro.getName(),pro.getSalesPrice(),pro.getRentPrice(),pro.getMinStock(), false});
				System.out.println(pro.getName() + String.valueOf(pro.getSalesPrice()) +String.valueOf(pro.getRentPrice()) + String.valueOf(pro.getMinStock()));
			}
		});
		btnSearchProduct.setBounds(145, 179, 89, 23);
		contentPane.add(btnSearchProduct);
		
		JLabel lblVare = new JLabel("Vare");
		lblVare.setBounds(10, 155, 46, 14);
		contentPane.add(lblVare);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 382, 350);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel(new Object[][] {},new String[] {	"Produktnavn", "Pris", "Lejepris", "P\u00E5 lager", "Leje"	});
		
		table = new JTable(model)
		{
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Double.class, Integer.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(545, 209, 413, 350);
		contentPane.add(scrollPane_1);
		
		model1 = new DefaultTableModel(new Object[][] {},new String[] {	"Produktnavn", "Pris", "Lejepris", "Antal"	});
		
		table_1 = new JTable(model1)
		 {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		
//		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();		
//		rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//		for(int i = 0; i < table.getColumnCount(); i++)
//		{
//			table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
//		}
//		
//		DefaultTableCellRenderer rightRenderer1 = new DefaultTableCellRenderer();		
//		rightRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
//		for(int i = 0; i < table_1.getColumnCount(); i++)
//		{
//			table_1.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
//		}
		scrollPane_1.setViewportView(table_1);
		
		
		JButton btnAddProduct = new JButton("->");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String prodName = (String) model.getValueAt(0, 0);
				Product prod = pCtr.findByName(prodName);
				model1.addRow(new Object[]{prod.getName(), prod.getSalesPrice(), prod.getRentPrice(), 1});
			}
		});
		btnAddProduct.setBounds(424, 339, 82, 39);
		contentPane.add(btnAddProduct);
		
		JButton btnWithdrawProduct = new JButton("<-");
		btnWithdrawProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model1.removeRow(0);
			}
		});
		btnWithdrawProduct.setBounds(424, 415, 82, 39);
		contentPane.add(btnWithdrawProduct);
		
		JButton btnTilBetaling = new JButton("Til betaling");
		btnTilBetaling.setBounds(826, 570, 132, 31);
		contentPane.add(btnTilBetaling);
		
		JButton btnTilbage = new JButton("Tilbage");
		btnTilbage.setBounds(688, 570, 132, 31);
		contentPane.add(btnTilbage);
		
		JLabel lblIndkbskurv = new JLabel("Indk\u00F8bskurv");
		lblIndkbskurv.setBounds(545, 180, 82, 20);
		contentPane.add(lblIndkbskurv);
		
		// vare tabel
	}
	
	
	private void sletTabel()
	{
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}	
	}
}
