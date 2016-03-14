package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class ItemGui extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemGui frame = new ItemGui();
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
	public ItemGui() {
		setTitle("Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeItens = new JLabel("Cadastro de Itens");
		lblCadastroDeItens.setBounds(27, 36, 180, 14);
		contentPane.add(lblCadastroDeItens);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(27, 83, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblExterior = new JLabel("Exterior:");
		lblExterior.setBounds(27, 140, 66, 14);
		contentPane.add(lblExterior);
		
		JComboBox cbExterior = new JComboBox();
		cbExterior.setToolTipText("");
		cbExterior.setBounds(103, 137, 135, 20);
		contentPane.add(cbExterior);
		
		JCheckBox chckbxStattrak = new JCheckBox("StatTrak");
		chckbxStattrak.setBounds(280, 136, 97, 23);
		contentPane.add(chckbxStattrak);
		
		JComboBox cbPhase = new JComboBox();
		cbPhase.setBounds(103, 269, 135, 20);
		contentPane.add(cbPhase);
		
		JLabel lblPhase = new JLabel("Phase:");
		lblPhase.setBounds(27, 272, 46, 14);
		contentPane.add(lblPhase);
		
		tfNome = new JTextField();
		tfNome.setBounds(77, 80, 310, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		//Cadastra novo item
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = tfNome.getText();
				Enum exterior = (Enum) cbExterior.getSelectedItem();
				Enum phase = (Enum) cbPhase.getSelectedItem();
				Boolean st = chckbxStattrak.isSelected();
				
			}
		});
		btnCadastrar.setBounds(759, 579, 109, 23);
		contentPane.add(btnCadastrar);
		
		//Limpa dados cadastro
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tfNome.setText("");
				chckbxStattrak.setSelected(false);
				
			}
		});
		btnLimpar.setBounds(621, 579, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnTeste = new JButton("Teste");
		btnTeste.setBounds(708, 268, 89, 23);
		contentPane.add(btnTeste);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(593, 29, 284, 228);
		contentPane.add(scrollPane);
		
		
		//Insere nova image ao cadastro
	
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png", "bmp");
				fileChooser.addChoosableFileFilter(filter);
			
				JLabel jlab = new JLabel();
					if (fileChooser.showOpenDialog(btnInserir) == JFileChooser.APPROVE_OPTION){
					java.io.File f = fileChooser.getSelectedFile();
					jlab.setIcon(new ImageIcon(f.toString()));
					jlab.setHorizontalAlignment(JLabel.CENTER);
					scrollPane.setViewportView(jlab);
					}
			//	}else if(resultado == JFileChooser.CANCEL_OPTION){
					
			//	}
				
			}
		});
		btnInserir.setBounds(593, 268, 89, 23);
		contentPane.add(btnInserir);
		
		
		
	
	
	}
}
