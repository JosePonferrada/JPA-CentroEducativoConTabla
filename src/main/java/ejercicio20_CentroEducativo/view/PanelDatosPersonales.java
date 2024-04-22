package ejercicio20_CentroEducativo.view;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import ejercicio20_CentroEducativo.entities.TipologiaSexo;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;

public class PanelDatosPersonales extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JLabel lblTitulo; 
	private Runnable runnableMostrarPrimerRegistro;
	private Runnable runnableMostrarAnteriorRegistro;
	private Runnable runnableMostrarSiguienteRegistro;
	private Runnable runnableMostrarUltimoRegistro;
	private Runnable runnableCreaNuevo;
	private Runnable runnableModifica;
	private Runnable runnableElimina;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JComboBox<TipologiaSexo> jcbSexo;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JScrollPane jscrollPane;
	public byte[] imagenEnArrayDeBytes;
	private JTextField jtfColorPreferido;
	JColorChooser jColorChooser;
	JButton btnCambioColor;
	JPanel panel;

	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		setLayout(new BorderLayout(0, 0));
				
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runnableMostrarPrimerRegistro.run();
			}
		});
		
		
		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runnableMostrarAnteriorRegistro.run();
			}
		});

		
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarSiguienteRegistro.run();
			}
		});

		
		
		JButton btnGoLast = new JButton("");
		btnGoLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarUltimoRegistro.run();
			}
		});

		
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableCreaNuevo.run();
			}
		});

		
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableModifica.run();
			}
		});

		
	
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableElimina.run();
			}
		});

		
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblTitulo = new JLabel("Titulo del Componente");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridwidth = 4;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panel.add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		jscrollPane = new JScrollPane();
		jscrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				showPopUpMenu(e);
			}
			@Override
			public void mouseReleased(MouseEvent e){
				showPopUpMenu(e);
			}
			
			private void showPopUpMenu(MouseEvent e) {
				// Inicializo el menú de popup
				JPopupMenu popup = getPopUpMenu();
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
			
		});
		GridBagConstraints gbc_jscrollPane = new GridBagConstraints();
		gbc_jscrollPane.gridheight = 6;
		gbc_jscrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_jscrollPane.fill = GridBagConstraints.BOTH;
		gbc_jscrollPane.gridx = 3;
		gbc_jscrollPane.gridy = 1;
		panel.add(jscrollPane, gbc_jscrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 1:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.gridwidth = 2;
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 3;
		panel.add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 2:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.gridwidth = 2;
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 4;
		panel.add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 5;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jcbSexo = new JComboBox<TipologiaSexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.gridwidth = 2;
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 5;
		panel.add(jcbSexo, gbc_jcbSexo);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.gridwidth = 2;
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 6;
		panel.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.gridwidth = 2;
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 7;
		panel.add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JButton btnCargarImagen = new JButton("Cargar imagen");
		btnCargarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnCargarImagen = new GridBagConstraints();
		gbc_btnCargarImagen.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarImagen.gridx = 3;
		gbc_btnCargarImagen.gridy = 7;
		panel.add(btnCargarImagen, gbc_btnCargarImagen);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.gridwidth = 2;
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 8;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 9;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.gridwidth = 2;
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 9;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		JLabel lblColorPreferido = new JLabel("Color preferido:");
		GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
		gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
		gbc_lblColorPreferido.insets = new Insets(0, 0, 0, 5);
		gbc_lblColorPreferido.gridx = 0;
		gbc_lblColorPreferido.gridy = 10;
		panel.add(lblColorPreferido, gbc_lblColorPreferido);
		
		jtfColorPreferido = new JTextField();
		jtfColorPreferido.setEnabled(false);
		GridBagConstraints gbc_jtfColorPreferido = new GridBagConstraints();
		gbc_jtfColorPreferido.gridwidth = 2;
		gbc_jtfColorPreferido.insets = new Insets(0, 0, 0, 5);
		gbc_jtfColorPreferido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColorPreferido.gridx = 1;
		gbc_jtfColorPreferido.gridy = 10;
		panel.add(jtfColorPreferido, gbc_jtfColorPreferido);
		jtfColorPreferido.setColumns(10);
		
		btnCambioColor = new JButton("Cambiar Color");
		btnCambioColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnCambioColor = new GridBagConstraints();
		gbc_btnCambioColor.gridx = 3;
		gbc_btnCambioColor.gridy = 10;
		panel.add(btnCambioColor, gbc_btnCambioColor);

	}

	
	public void setTitulo(String newTitle) {
		this.lblTitulo.setText(newTitle);
	}


	public Runnable getRunnableMostrarPrimerRegistro() {
		return runnableMostrarPrimerRegistro;
	}


	public void setRunnableMostrarPrimerRegistro(Runnable runnableMostrarPrimerRegistro) {
		this.runnableMostrarPrimerRegistro = runnableMostrarPrimerRegistro;
	}


	public String getJtfId() {
		return this.jtfId.getText();
	}


	public void setJtfId(String newJtfId) {
		this.jtfId.setText(newJtfId);;
	}


	public String getJtfNombre() {
		return jtfNombre.getText();
	}


	public void setJtfNombre(String newJtfNombre) {
		this.jtfNombre.setText(newJtfNombre);;
	}


	public JComboBox<TipologiaSexo> getJcbSexo() {
		return jcbSexo;
	}


	public void setJcbSexo(JComboBox<TipologiaSexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}


	public JLabel getLblTitulo() {
		return lblTitulo;
	}


	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}


	public String getJtfColorPreferido() {
		return jtfColorPreferido.getText();
	}


	public void setJtfColorPreferido(String jtfColorPreferido) {
		this.jtfColorPreferido.setText(jtfColorPreferido);
	}


	public Runnable getRunnableMostrarAnteriorRegistro() {
		return runnableMostrarAnteriorRegistro;
	}


	public void setRunnableMostrarAnteriorRegistro(Runnable runnableMostrarAnteriorRegistro) {
		this.runnableMostrarAnteriorRegistro = runnableMostrarAnteriorRegistro;
	}


	public Runnable getRunnableMostrarSiguienteRegistro() {
		return runnableMostrarSiguienteRegistro;
	}


	public void setRunnableMostrarSiguienteRegistro(Runnable runnableMostrarSiguienteRegistro) {
		this.runnableMostrarSiguienteRegistro = runnableMostrarSiguienteRegistro;
	}


	public Runnable getRunnableMostrarUltimoRegistro() {
		return runnableMostrarUltimoRegistro;
	}


	public void setRunnableMostrarUltimoRegistro(Runnable runnableMostrarUltimoRegistro) {
		this.runnableMostrarUltimoRegistro = runnableMostrarUltimoRegistro;
	}


	public Runnable getRunnableCreaNuevo() {
		return runnableCreaNuevo;
	}


	public void setRunnableCreaNuevo(Runnable runnableCreaNuevo) {
		this.runnableCreaNuevo = runnableCreaNuevo;
	}


	public Runnable getRunnableModifica() {
		return runnableModifica;
	}


	public void setRunnableModifica(Runnable runnableModifica) {
		this.runnableModifica = runnableModifica;
	}


	public Runnable getRunnableElimina() {
		return runnableElimina;
	}


	public void setRunnableElimina(Runnable runnableElimina) {
		this.runnableElimina = runnableElimina;
	}


	public String getJtfApellido1() {
		return jtfApellido1.getText();
	}


	public void setJtfApellido1(String newJtfApellido1) {
		this.jtfApellido1.setText(newJtfApellido1);;
	}


	public String getJtfApellido2() {
		return jtfApellido2.getText();
	}


	public void setJtfApellido2(String newJtfApellido2) {
		this.jtfApellido2.setText(newJtfApellido2);;
	}


	public String getJtfDni() {
		return this.jtfDni.getText();
	}


	public void setJtfDni(String newJtfDni) {
		this.jtfDni.setText(newJtfDni);;
	}


	public String getJtfDireccion() {
		return this.jtfDireccion.getText();
	}


	public void setJtfDireccion(String newJtfDireccion) {
		this.jtfDireccion.setText(newJtfDireccion);
	}


	public String getJtfEmail() {
		return this.jtfEmail.getText();
	}


	public void setJtfEmail(String newJtfEmail) {
		this.jtfEmail.setText(newJtfEmail);
	}


	public String getJtfTelefono() {
		return jtfTelefono.getText();
	}


	public void setJtfTelefono(String newJtfTelefono) {
		this.jtfTelefono.setText(newJtfTelefono);
	}


	public JScrollPane getJscrollPane() {
		return jscrollPane;
	}


	public void setJscrollPane(JScrollPane jscrollPane) {
		this.jscrollPane = jscrollPane;
	}


	public byte[] getImagenEnArrayDeBytes() {
		return imagenEnArrayDeBytes;
	}


	public void setImagenEnArrayDeBytes(byte[] imagenEnArrayDeBytes) {
		this.imagenEnArrayDeBytes = imagenEnArrayDeBytes;
	}



	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public void mostrarImagen (byte[] imagen) {
		if (imagen != null && imagen.length > 0) {
			this.imagenEnArrayDeBytes = imagen;
			ImageIcon icono = new ImageIcon(imagen);
			
			if(icono.getIconHeight() > 100 || icono.getIconWidth() > 100) {
				JOptionPane.showMessageDialog(null, "La imagen introducida no cumple los requisitos."
						+ " (Debe ser de 100x100px o inferior");
				
				// Si la imagen introducida no es válido establezco una por defecto.
				
				icono = new ImageIcon("src/capitulo08/ejemploCentroEducativo/resources/pfp.png");
				JLabel lblIcono = new JLabel(icono);
				jscrollPane.setViewportView(lblIcono);
				  
				return;
			}
			
			JLabel lblIcono = new JLabel(icono);
			jscrollPane.setViewportView(lblIcono);
		}
		else {
			JLabel lblIcono = new JLabel("Sin imagen");
			jscrollPane.setViewportView(lblIcono);
			this.imagenEnArrayDeBytes = null; //"Reiniciamos" el array  
		}

	}
	
	
	private void seleccionaImagen () {
		JFileChooser jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().toLowerCase().endsWith(".jpg") || 
								f.getAbsolutePath().toLowerCase().endsWith(".jpeg")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".png")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".gif")))) 
					return true;
				return false;
			}
		});
		
		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			
			if (fichero.isFile()) {
				try {
					this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
					mostrarImagen(this.imagenEnArrayDeBytes);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
		
	private void seleccionaColor () {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColorPreferido.setText(strColor);
			setColor(color);
			
		}
	}
	
	public void setColor(Color color) {
		this.panel.setBackground(color);
	}
	
	public JPopupMenu getPopUpMenu () {
		JPopupMenu menu = new JPopupMenu();
		
		if(imagenEnArrayDeBytes != null) {
			ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);
			
			menu.add("Dimensiones: " + icono.getIconHeight() + 
					"x " + icono.getIconWidth() + "píxeles");

			menu.addSeparator();
			
		}
		
//		menu.add(crearNuevoMenuItem("Dimensiones: " + icono));
		menu.add(crearNuevoMenuItem("Cambiar imagen"));
		
		return menu;
	}
	
	private JMenuItem crearNuevoMenuItem (String titulo) {
        JMenuItem item = new JMenuItem(titulo);
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionaImagen();
            }
        });
        
        return item;
	}
	
}
