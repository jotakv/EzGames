package conectabd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.text.View;

import com.ezgames.model.Bd;

public class ControllerUsamosElotro implements ActionListener, MouseListener {
	private View view;

	// CONSTRUCTOR
	ControllerUsamosElotro(View view) {
		this.view = view;
		cargarTabla();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Objeto para ejecutar los procedimientos almacenados
		// en la base de datos
		CallableStatement cs;

		// COMANDO EJECTUADO
		String comando = arg0.getActionCommand();

		// Deber� coincidir con alguno de los par�metros
		// indicados en setActionCommand invocado en la
		// clase View
		switch (comando) {
		case "INSERTAR":
			try {
				// Preparar la llamada
				cs = Bd.getConexion().prepareCall(
						"{CALL insertarCliente(?,?,?)}");
				// Indicar qu� informaci�n se pasa al
				// procedimiento
				// cs.setString(1, this.view.txtNombre.getText());
				// cs.setString(2, this.view.txtApellido.getText());
				// cs.setString(3, this.view.txtNIF.getText());
				// Ejecutar el procedimiento
				cs.execute();
			} catch (SQLException e) {
				System.err.println("Error en la INSERCI�N");
			}

			break;

		case "BORRAR":
			// Recoger qu� fila se ha pulsado
			// int filaPulsada = this.view.tabla.getSelectedRow();
			// Si se ha pulsado una fila
			// if (filaPulsada >= 0) {
			// Se recoge el id de la fila marcada
			// int identificador = (int) this.view.dtm.getValueAt(filaPulsada,
			// 0);
			try {
				// Preparar la llamada
				cs = Bd.getConexion().prepareCall("{CALL borrarCliente(?)}");
				// Indicar qu� informaci�n se pasa al procedimiento
				// cs.setInt(1, identificador);
				// Ejecutar el procedimiento
				cs.execute();
				// System.out.println(this.view.dtm.getValueAt(filaPulsada,
				// 0));
			} catch (SQLException e) {
				System.err.println("Error en el BORRADO");
			}
			// }

			break;

		case "MODIFICAR":
			// Recoger qu� fila se ha pulsadao en la tabla
			// filaPulsada = this.view.tabla.getSelectedRow();
			// Si se ha pulsado una fila
			// if (filaPulsada >= 0) {
			// Se recoge el id de la fila marcada
			// int identificador = (int)
			// this.view.dtm.getValueAt(filaPulsada,
			// 0);
			try {
				// Preparar la llamada
				cs = Bd.getConexion().prepareCall(
						"{CALL modificarCliente(?,?,?,?)}");
				// Indicar qu� informaci�n se pasa al procedimiento
				// cs.setInt(1, identificador);
				// cs.setString(2, this.view.txtNombre.getText());
				// cs.setString(3, this.view.txtApellido.getText());
				// cs.setString(4, this.view.txtNIF.getText());
				// Ejecutar el procedimiento
				cs.execute();
				// System.out.println(this.view.dtm.getValueAt(filaPulsada,
				// 0));
			} catch (SQLException e) {
				System.err.println("Error en la MODIFICACION");
			}
			// }
			break;

		default:
			System.err.println("Comando no definido");
			break;
		}
		// limpiar el formulario
		limpia();

		// refrescar la tabla
		cargarTabla();
	}

	// M�todo para limpiar los campos de la ventana
	private void limpia() {
		// this.view.txtNombre.setText("");
		// this.view.txtApellido.setText("");
		// this.view.txtNIF.setText("");
	}

	// M�todo que recarga los datos de la tabla de la base de datos
	// en la tabla de la clase View
	protected void cargarTabla() {
		// Objeto para ejecutar los procedimientos almacenados en la base de
		// datos
		CallableStatement cs;
		// Objeto para recoger los datos devueltos por el procedimiento
		// almacenado
		ResultSet rs;
		// Objeto para recorrer el resultado del procedimiento almacenado y
		// a�adirlo a la tabla definida en la clase View
		Vector<Object> fila;

		// Limpiar los datos de la tabla
		// for (int i = this.view.dtm.getRowCount(); i > 0; i--) {
		// this.view.dtm.removeRow(i - 1);
		// }

		// Cargar datos en la tabla
		try {
			// Preparar la llamada
			cs = Bd.getConexion().prepareCall("{CALL getClientes()}");
			// Ejecutarla y recoger el resultado
			rs = cs.executeQuery();
			// Recorrer el resultado
			while (rs.next()) {
				// A�adir registro a registro en el vector
				fila = new Vector<Object>();
				fila.add(rs.getInt("id"));
				fila.add(rs.getString("nombre"));
				fila.add(rs.getString("nif"));
				// A�adir el vector a la tabla de la clase View
				// this.view.dtm.addRow(fila);
			}

		} catch (SQLException e) {
			System.err.println("Error al CARGAR DATOS");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Objeto para ejecutar los procedimientos almacenados en la base de
		// datos
		CallableStatement cs;
		// Objeto para recoger los datos devueltos por el procedimiento
		// almacenado
		ResultSet rs;

		// Recoger qu� fila se ha pulsadao en la tabla
		// int filaPulsada = this.view.tabla.getSelectedRow();
		// Si se ha pulsado una fila
		// if (filaPulsada >= 0) {
		// Se recoge el id de la fila marcada
		// int identificador = (int) this.view.dtm.getValueAt(filaPulsada, 0);
		try {
			// Preparar la llamada
			cs = Bd.getConexion().prepareCall("{CALL getCliente(?)}");
			// Indicar qu� informaci�n se pasa al procedimiento
			// cs.setInt(1, identificador);
			// Ejecutar el procedimiento
			rs = cs.executeQuery();
			// Cargar los datos devueltos en los cuadros de texto
			if (rs.next()) {
				// this.view.txtNombre.setText(rs.getString(1));
				// this.view.txtApellido.setText(rs.getString(2));
				// this.view.txtNIF.setText(rs.getString(3));
			}
			// System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
		} catch (SQLException e) {
			System.err.println("Error al CARGAR UN CLIENTE");
		}
		// }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}