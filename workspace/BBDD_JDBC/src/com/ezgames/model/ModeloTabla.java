package com.ezgames.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla<T> extends DefaultTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String[] columnIds;
	protected List<T> lista;

	public ModeloTabla(String[] columnIdEventos) {
		this.lista = null;
		columnIds = columnIdEventos;
	}

	@Override
	public String getColumnName(int col) {
		return this.columnIds[col];
	}

	@Override
	public int getColumnCount() {
		return this.columnIds.length;
	}

	@Override
	public int getRowCount() {
		return this.lista == null ? 0 : this.lista.size();
	}

}
