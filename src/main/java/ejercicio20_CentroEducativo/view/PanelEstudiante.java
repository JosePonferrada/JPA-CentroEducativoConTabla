package ejercicio20_CentroEducativo.view;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ejercicio20_CentroEducativo.controladores.ControladorTipologiaSexo;
import ejercicio20_CentroEducativo.entities.Estudiante;
import ejercicio20_CentroEducativo.entities.TipologiaSexo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDatosPersonales panelDatos = new PanelDatosPersonales();
	JComboBox<TipologiaSexo> jcbSexo = this.panelDatos.getJcbSexo();
//	byte[] imagenEnArrayDeBytes;
	
	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		setLayout(new BorderLayout(0, 0));
		this.add(panelDatos, BorderLayout.CENTER);
		
		loadAllTipologiaSexo();
		
		mostrarPrimero();
		
		panelDatos.setTitulo("Gestión del Estudiante");
//		panelDatos.setId(3);
		
		this.panelDatos.setRunnableMostrarPrimerRegistro(new Runnable() {
			
			@Override
			public void run() {
				mostrarPrimero();
			}
		});
		
		this.panelDatos.setRunnableMostrarSiguienteRegistro(new Runnable() {
			
			@Override
			public void run() {
				mostrarNext();
			}
		});
		
		this.panelDatos.setRunnableMostrarAnteriorRegistro(new Runnable() {
			
			@Override
			public void run() {
				mostrarPrevious();
			}
		});
		
		this.panelDatos.setRunnableMostrarUltimoRegistro(new Runnable() {
			
			@Override
			public void run() {
				mostrarLast();
			}
		});
		
		this.panelDatos.setRunnableElimina(new Runnable() {
			
			@Override
			public void run() {
				eliminar();
			}
		});
		
		this.panelDatos.setRunnableModifica(new Runnable() {
			
			@Override
			public void run() {
				guardar();
			}
		});
		
		this.panelDatos.setRunnableCreaNuevo(new Runnable() {
			
			@Override
			public void run() {
				creaNuevo();
			}
		});
		
	}

	private void mostrarPrimero() {
		
		
		
	}
	
	private void mostrarLast() {
		
	}
	
	private void mostrarNext() {
		
	}
	
	private void mostrarPrevious() {
		
	}
	
	private void loadAllTipologiaSexo() {
		
	
		
	}
	
	private void guardar() {
		
	}
	
	private void eliminar () {
		
	}
	
	private void creaNuevo() {
		this.panelDatos.setJtfId("");
		this.panelDatos.setJtfNombre("");
		this.panelDatos.setJtfApellido1("");
		this.panelDatos.setJtfApellido2("");
		this.panelDatos.setJtfDni("");
		this.panelDatos.setJtfDireccion("");
		this.panelDatos.setJtfEmail("");
		this.panelDatos.setJtfTelefono("");
		this.panelDatos.setJscrollPane(null);
		this.panelDatos.setJtfColorPreferido("");
		
	}
	
	private void muestraEnPantalla(Estudiante o) {
		
	}
	
	

	
	
}
