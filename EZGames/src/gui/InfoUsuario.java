package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class InfoUsuario extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public InfoUsuario(String nombre, String apellido, String correo, String tipo) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformacionDelUsuario = new JLabel("Informacion del usuario");
		lblInformacionDelUsuario.setBounds(122, 39, 190, 15);
		contentPane.add(lblInformacionDelUsuario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(37, 79, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(37, 119, 70, 15);
		contentPane.add(lblApellido);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(37, 166, 70, 15);
		contentPane.add(lblCorreo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(37, 212, 70, 15);
		contentPane.add(lblTipo);
		
		JLabel etiqNombre = new JLabel(nombre);
		etiqNombre.setBounds(166, 79, 70, 15);
		contentPane.add(etiqNombre);
		
		JLabel etiqApellido = new JLabel(apellido);
		etiqApellido.setBounds(166, 119, 70, 15);
		contentPane.add(etiqApellido);
		
		JLabel etiqCorreo = new JLabel(correo);
		etiqCorreo.setBounds(166, 166, 140, 15);
		contentPane.add(etiqCorreo);
		
		JLabel etiqTipo = new JLabel(tipo);
		etiqTipo.setBounds(166, 212, 70, 15);
		contentPane.add(etiqTipo);
	}
}
