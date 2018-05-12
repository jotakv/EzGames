package com.ezgames.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.ezgames.model.ModeloTabla;

public class PanelTabla<T> extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ModeloTabla<T> modelo;

	public PanelTabla(String bordeId, ModeloTabla<T> modelo) {
		this.setLayout(new GridLayout(1, 1));
		this.setBorder(BorderFactory.createTitledBorder(bordeId));
		this.modelo = modelo;
		JTable tabla = new JTable(this.modelo);
		this.add(new JScrollPane(tabla));
	}
}
