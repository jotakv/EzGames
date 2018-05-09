package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javafx.scene.layout.BorderWidths;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.sun.javafx.scene.layout.region.BorderStyleConverter;
import com.sun.scenario.effect.impl.sw.java.JSWInvertMaskPeer;

public class VentanaPrincipal {

	private JFrame frame;
	private final String[] plataforma = { "PC", "XONE", "PS4", "Switch"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();

					window.frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.frame.getContentPane().setLayout(new FlowLayout());
		this.frame.setTitle("Tienda EZ-GAMES");
		this.frame.setVisible(true);
		this.frame.setPreferredSize(new Dimension(810, 660));
		
		crearPanelSuperior();
		creaPanelBusqueda();
		creaPanelPlataforma();
		creaPanelTienda();
		
		
	}


	private void crearPanelSuperior() {
		JPanel panelPrincipal = new JPanel(new GridLayout(1, 3));
		
		JButton botonLogin = new JButton("LOGIN");
		JButton botonPerfil = new JButton("PERFIL");
		JLabel etiq = new JLabel("EZGames",SwingConstants.CENTER);
		
		panelPrincipal.add(etiq);
		panelPrincipal.add(botonPerfil);
		panelPrincipal.add(botonLogin);
		
		panelPrincipal.setPreferredSize(new Dimension(800, 30));
		frame.getContentPane().add(panelPrincipal);
	}
	

	private void creaPanelBusqueda() {
		JPanel panelPrincipal = new JPanel(new FlowLayout());
		
		JButton botonBusca = new JButton("Buscar");
		botonBusca.setPreferredSize(new Dimension(100, 30));
		
		JTextField texto = new JTextField();
		texto.setEditable(true);
		texto.setPreferredSize(new Dimension(500,25));
		
		JComboBox box = new JComboBox(plataforma);
		box.setPreferredSize(new Dimension(80,30));
		
		panelPrincipal.add(texto);
		panelPrincipal.add(box);
		panelPrincipal.add(botonBusca);
	
		panelPrincipal.setPreferredSize(new Dimension(800,40));
		frame.getContentPane().add(panelPrincipal);
	}

	private <E> void creaPanelPlataforma(){
		JPanel panelPrincipal = new JPanel(new FlowLayout());
		panelPrincipal.setPreferredSize(new Dimension(800,100));
		
		String[] food = {"Pizza", "Burger", "Pasta", "Hot Dog", "etc"};

		JCheckBox[] boxes = new JCheckBox[food.length]; //  Each checkbox will get a name of food from food array.  
		JCheckBox box1 = new JCheckBox("PC");
		JCheckBox box2 = new JCheckBox("PS4");
		JCheckBox box3 = new JCheckBox("XONE");
		JCheckBox box4 = new JCheckBox("Switch");
		JLabel etiq = new JLabel("Plataforma:");
		panelPrincipal.add(etiq);
		panelPrincipal.add(box1);
		panelPrincipal.add(box2);
		panelPrincipal.add(box3);
		panelPrincipal.add(box4);
		frame.getContentPane().add(panelPrincipal);
	}
	
	private void creaPanelTienda(){
		JPanel panelPrincipal = new JPanel(new GridLayout(1, 3));
		panelPrincipal.setPreferredSize(new Dimension(790,430));
		
		//LISTA PRODUCTOS
		String[] items = new String[]
		        {
		                "COD", "MINECRAFT", "GTA", "FIFA"
		        };
		
		JList lista = new JList(items);
		lista.setBorder(BorderFactory.createTitledBorder("PRODUCTOS"));
		
		//LISTA BOTONES
		JPanel panelTotal = new JPanel(new FlowLayout());
		JPanel panel1 = new JPanel(new FlowLayout());
		panelTotal.setPreferredSize(new Dimension(263,430));
		panel1.setPreferredSize(new Dimension(263, 80));
		JButton cesta = new JButton("Añadir a Cesta");
		panel1.add(cesta);
		
		
		JTextArea informacion = new JTextArea(10,20);
		informacion.setText("COD 2006 2players");
		informacion.setSize(263, 100);
		informacion.setEditable(false);
		
		JTextArea valoraciones = new JTextArea(10,20);
		valoraciones.setText("LLENO DE HACKERS HIJOS D PUTA");
		valoraciones.setSize(263, 100);
		valoraciones.setEditable(false);
		
		
		panelTotal.add(panel1);
		panelTotal.add(informacion);
		panelTotal.add(valoraciones);
		//LISTA CESTA
		JPanel panel2 = new JPanel(new BorderLayout());
		String[] items2 = new String[]
		        {
		                "MINECRAFT", "GTA", "FIFA"
		        };
		
		JList lista2 = new JList(items);
		lista2.setBorder(BorderFactory.createTitledBorder("CESTA"));
		lista2.setPreferredSize(new Dimension(263,410));
		panel2.add(lista2,BorderLayout.CENTER);
		JButton confirmar = new JButton("Confirmar Compra");
		panel2.add(confirmar,BorderLayout.PAGE_END);
		
		
		
		
	    panelPrincipal.add(lista, BorderLayout.CENTER);
		panelPrincipal.add(panelTotal);
		panelPrincipal.add(panel2);
	    
	    
	    
	    
	    
	    frame.getContentPane().add(panelPrincipal);
	}
}
