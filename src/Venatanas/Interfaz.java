package Venatanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import AnalizadorLex_Sem.Generador;
import AnalizadorLex_Sem.Lex;
import AnalizadorLex_Sem.Semantico;

import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Window.Type;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.TextArea;
import java.awt.Scrollbar;


public class Interfaz extends JFrame {

	private JPanel contentPane;
	private Lex obl;
	private String Ruta=""; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(SystemColor.controlText);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnSalir.setBounds(430, 530, 89, 27);
		contentPane.add(btnSalir);
		
		JButton btnArchG = new JButton("Guardar Archivo");		
		btnArchG.setForeground(Color.WHITE);
		btnArchG.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnArchG.setBackground(Color.BLACK);
		btnArchG.setBounds(400, 350, 146, 27);
		contentPane.add(btnArchG);
		
		JButton btnArch = new JButton("Cargar Archivo");		
		btnArch.setForeground(Color.WHITE);
		btnArch.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnArch.setBackground(Color.BLACK);
		btnArch.setBounds(400, 400, 146, 27);
		contentPane.add(btnArch);
		
		TextArea textin = new TextArea();
		textin.setBounds(10, 60, 925, 200);
		contentPane.add(textin);
		
		JButton btnAnalizar = new JButton("Analizar");	
		btnAnalizar.setForeground(Color.WHITE);
		btnAnalizar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnAnalizar.setBackground(Color.BLACK);
		btnAnalizar.setBounds(400, 450, 146, 27);
		contentPane.add(btnAnalizar);
		
		JLabel lblC = new JLabel("Codigo C");
		lblC.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblC.setForeground(Color.WHITE);
		lblC.setBounds(150, 315, 153, 14);
		contentPane.add(lblC);
		
		JLabel lblPilaSintactica = new JLabel("Pila Semantica");
		lblPilaSintactica.setForeground(Color.WHITE);
		lblPilaSintactica.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblPilaSintactica.setBounds(730, 315, 153, 14);
		contentPane.add(lblPilaSintactica);
		
		TextArea textC = new TextArea();
		textC.setBounds(10, 335, 350, 214);
		contentPane.add(textC);
		
		TextArea textSin = new TextArea();
		textSin.setBounds(590, 335, 350, 214);
		contentPane.add(textSin);
		
		JLabel lblLeer = new JLabel("Lectura");
		lblLeer.setForeground(Color.WHITE);
		lblLeer.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblLeer.setBounds(10, 10, 50, 14);
		contentPane.add(lblLeer);
		
		TextArea textlee = new TextArea();
		textlee.setBounds(70, 10, 870, 40);
		contentPane.add(textlee);
		
		JLabel lblNewLabel_1 = new JLabel("Componentes Lexicos");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 270, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		TextArea textLex = new TextArea();
		textLex.setBounds(160, 270, 780, 40);
		contentPane.add(textLex);
		
		
		JLabel lblNewLabel = new JLabel("");		
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/dark3.jpg")));
		lblNewLabel.setBounds(0, 0, 950, 560);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
	    this.setLocationRelativeTo(null);
	    
	    
	    
	    //Acciones de botones
	    
	    btnArch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File obf = null;
				 JFileChooser chooser = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "TXT","txt","JAC","jac");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(getParent());
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	textin.setText("");
				    	obf=chooser.getSelectedFile();
				    	Txt obx=new Txt(obf.getAbsolutePath());// abrimos el contenido del archivo
				    	//System.out.println(obf);
				    	Ruta=obf+"";
						textin.setText(obx.getTexto());	// se lo asignamos al control
				    }
				    else{
				    	textin.setText("");
				    	textin.setText("---------------------------------------------No se cargo ningún archivo--------------------------------");
				    	
				    }
			   			
			}
		});
	    
	    btnArchG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					FileWriter f=new FileWriter(Ruta);
					f.write(textin.getText());
					f.close();
				}catch(IOException e1) 
				{
				}
			}
	    });
	    btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	    
	    btnAnalizar.addActionListener(new ActionListener() {// analizarrr
			public void actionPerformed(ActionEvent e) {
				
				Lex ob=new Lex();
				textLex.setText("");
				textSin.setText("");
				ob.Analizar(textin.getText());
				obl=ob;
				textLex.setText(obl.getCodigo());
				if(obl.getCodigo().indexOf("Error")==-1)
				{
					Semantico ts=new Semantico();
					textSin.setText(ts.metodo(obl.getComponentesLexicos()));
					if(textSin.getText().indexOf("Error")==-1)
					{
						Generador ge=new Generador();
						ge.Analizar(textin.getText(),textlee.getText());
						textC.setText(ge.getCodigo());
					}
				}
			}
		});
	}
}
