package ejercicio20_CentroEducativo.view;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ejercicio20_CentroEducativo.controladores.ControladorEstudiante;
import ejercicio20_CentroEducativo.controladores.ControladorTipologiaSexo;
import ejercicio20_CentroEducativo.entities.Estudiante;
import ejercicio20_CentroEducativo.entities.TipologiaSexo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDatosPersonales panelDatos = new PanelDatosPersonales();
	JComboBox<TipologiaSexo> jCBSexo = this.panelDatos.getJcbSexo();
	
	// Referencia del PanelTabla.
	// Se usará para actualizar los datos de la tabla.
	private PanelTabla panelTabla;
	
	/**
	 * Método setter que establece una referencia al JPanel PanelTabla 
	 * actual.
	 * @return 
	 */
	public PanelTabla setPanelTabla(PanelTabla panelTabla) {
		return this.panelTabla = panelTabla;
	}
	
	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		setLayout(new BorderLayout(0, 0));
		this.add(panelDatos, BorderLayout.CENTER);
		
		panelDatos.setTitulo("Gestión de Estudiante");
		
		// Cargamos todos los elementos del jComboBox.
		loadAllTipologiaSexo();
	
		this.panelDatos.setRunnableCreaNuevo(new Runnable() {
			@Override
			public void run() {
				nuevo();
			}
		});
		
		this.panelDatos.setRunnableModifica(new Runnable() {
			@Override
			public void run() {
				guardar();
			}
		});
		
		this.panelDatos.setRunnableElimina(new Runnable() {
			@Override
			public void run() {
				eliminar();
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 12;
		panelDatos.getPanel().add(btnGuardar, gbc_btnGuardar);
		
		
	}
	
	/**
	 * 
	 */
	private void loadAllTipologiaSexo() {
		List<TipologiaSexo> lista = (List<TipologiaSexo>) ControladorTipologiaSexo
				.getInstance().findAll();
		for (TipologiaSexo ts : lista) {
			this.jCBSexo.addItem(ts);
		}
	}
	
	/**
	 * 
	 */
	private void eliminar() {
		String respuestas[] = new String[] { "Sí", "No" };
		int opcionElegida = JOptionPane.showOptionDialog(null,
				"¿Realmente desea eliminar el registro?",
				"Eliminación de Estudiante", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null,
				respuestas, respuestas[1]);
		
		// Puntero para seleccionar el posible siguiente o anterior
		// registro a mostrar.
		Estudiante actual = null;

		if (opcionElegida == 0) {	// Si la opción es 0 (= Si).
			
			String str = this.panelDatos.getJtfId();
			if (!str.trim().equals("")) {
				int idActual = Integer.parseInt(str);
				ControladorEstudiante.getInstance()
					.deleteEstudiante(idActual);
				
				// Actualizamos los datos de la Tabla Estudiante.
				panelTabla.updateTable();
				
				// A continuación, mostraremos en pantalla el registro
				// siguiente.
				actual = (Estudiante) ControladorEstudiante
						.getInstance().findNext(idActual);
				
				// Si hay registro, es decir, el registro borrado es
				// ocupado por su siguiente registro (id).
				if (actual != null) {
					// Seleccionamos el registro.
					this.panelTabla.selectRowById(actual);
				} else {
					// Si hay no registro, miramos si hay registro anterior
					// al registro borrado.
					actual = (Estudiante) ControladorEstudiante
							.getInstance().findPrevious(idActual);
					if (actual != null) {
						// Seleccionamos el registro.
						this.panelTabla.selectRowById(actual);
					} else {
						// Llegados a este punto, no hay registros previos
						// ni posteriores.
						nuevo();
					}
					
				}
			}
		}
	}
	
	/**
	 * 
	 */
	private void guardar() {

		Estudiante o = new Estudiante();
		o.setNombre(this.panelDatos.getJtfNombre());
		o.setApellido1(this.panelDatos.getJtfApellido1());
		o.setApellido2(this.panelDatos.getJtfApellido2());
		o.setDni(this.panelDatos.getJtfDni());
		o.setDireccion(this.panelDatos.getJtfDireccion());
		o.setEmail(this.panelDatos.getJtfEmail());
		o.setTelefono(this.panelDatos.getJtfTelefono());

		o.setImagen(this.panelDatos.imagenEnArrayDeBytes);
		
		// Guardamos el color.
		if (!this.panelDatos.getJtfColorPreferido().trim().equals("")) {
			o.setColorPreferido(this.panelDatos.getJtfColorPreferido());
		} else {
			o.setColorPreferido(null);
		}
		
		// Como el item seleccionado del comboBox es tipo Object, realizamos
		// un casteo TipologiaSexo para obtener un objeto TipologiaSexo.
		// A continuación, obtenemos el id TipologiaSexo respectivo.
		int tipologiaSexoId = ((TipologiaSexo) jCBSexo.getSelectedItem()).getId();
		o.setIdTipologiaSexo(tipologiaSexoId);
		
		String str = this.panelDatos.getJtfId();
		if (!str.trim().equals("")) {
			
			o.setId(Integer.parseInt(str));
			ControladorEstudiante.getInstance()
				.updateEstudiante(o);
		} else {
			ControladorEstudiante.getInstance()
				.insertEstudiante(o);
			muestraEnPantalla(o);
		}
		
		// Actualizamos los datos de la Tabla Estudiante.
		panelTabla.updateTable();
		
		// Seleccionamos el registro insertado o modificado.
		this.panelTabla.selectRowById(o);
	}
	
	/**
	 * 
	 */
	private void nuevo() {
		this.panelDatos.setJtfId("");
		this.panelDatos.setJtfNombre("");
		this.panelDatos.setJtfApellido1("");
		this.panelDatos.setJtfApellido2("");
		this.panelDatos.setJtfDni("");
		this.panelDatos.setJtfDireccion("");
		this.panelDatos.setJtfEmail("");
		this.panelDatos.setJtfTelefono("");
		this.panelDatos.setImagenEnArrayDeBytes(null);
		this.panelDatos.setJtfColorPreferido("");
		this.panelDatos.setColor(null);
	}
	
	/**
	 * 
	 * @param o
	 */
	public void muestraEnPantalla(Estudiante o) {
		if (o != null) {
			this.panelDatos.setJtfId(String.valueOf(o.getId()));
			this.panelDatos.setJtfNombre(o.getNombre());
			this.panelDatos.setJtfApellido1(o.getApellido1());
			this.panelDatos.setJtfApellido2(o.getApellido2());
			this.panelDatos.setJtfDni(o.getDni());
			this.panelDatos.setJtfDireccion(o.getDireccion());
			this.panelDatos.setJtfEmail(o.getEmail());
			this.panelDatos.setJtfTelefono(o.getTelefono());
			this.panelDatos.setJtfColorPreferido(o.getColorPreferido());
			
			// Si el id del elemento jcombobox en la posición i es igual a
			// el id del objeto TipologiaSexo, seleccionamos dicho item.
			for (int i = 0; i < jCBSexo.getItemCount(); i++) {
				if (jCBSexo.getItemAt(i).getId() == o.getIdTipologiaSexo()) {
					jCBSexo.setSelectedIndex(i);
				}
			}
			
			// Mostramos la posible imagen del registro actual.
			this.panelDatos.setImagenEnArrayDeBytes(o.getImagen());
			
			// Mostramos el posible color preferido del registro actual.
			try {
				if (o.getColorPreferido() != null) {
					Color color = Color.decode(o.getColorPreferido());
					this.panelDatos.setColor(color);
				} else {
					this.panelDatos.setColor(null);
					this.panelDatos.setJtfColorPreferido("");
				}
			} catch (NumberFormatException e) {
				this.panelDatos.setColor(null);
				this.panelDatos.setJtfColorPreferido("");
			}
		}
	}

}