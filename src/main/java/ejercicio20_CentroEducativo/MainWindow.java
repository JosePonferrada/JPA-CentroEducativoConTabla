package ejercicio20_CentroEducativo;

import javax.swing.JFrame;
import ejercicio20_CentroEducativo.view.PanelTablaEstudiante;
import utils.Apariencia;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MainWindow instance = null;
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	/**
	 * Constructor.
	 */
	public MainWindow() {
		super("Centro Educativo - Datos Estudiantes");
		
		this.setBounds(100, 100, 700, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelTablaEstudiante panel = new PanelTablaEstudiante();
		
		this.getContentPane().add(panel);
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static MainWindow getInstance() {
		if (instance == null) {
			instance = new MainWindow();
		}
		return instance;
	}

	/**
	 * Método Principal.
	 * @param args
	 */
	public static void main(String[] args) {
		getInstance().setVisible(true);
	}

}