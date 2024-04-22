package ejercicio20_CentroEducativo.controladores;

import ejercicio20_CentroEducativo.entities.TipologiaSexo;

public class ControladorTipologiaSexo extends SuperControlador {
	
	public ControladorTipologiaSexo() {
		super("tipologiaSexo", TipologiaSexo.class);
	}

	private static ControladorTipologiaSexo instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorTipologiaSexo getInstance() {
		if (instance == null) {
			instance = new ControladorTipologiaSexo();
		}
		return instance;
	}
	
}