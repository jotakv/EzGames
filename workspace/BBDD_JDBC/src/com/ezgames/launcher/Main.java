package com.ezgames.launcher;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import com.ezgames.controller.Controller;
import com.ezgames.model.Gestion;
import com.ezgames.view.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {

		Gestion virtualStore = new Gestion();
		Controller ctrl = new Controller(virtualStore);
		// ctrl.setData(gestion);

		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					new VentanaPrincipal(ctrl);
				}
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
