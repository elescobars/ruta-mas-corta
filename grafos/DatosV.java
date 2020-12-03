package grafos;

public class DatosV {

	private String Ciudad;
	private float acumuladorTiempo;
	private float acumuladorViaticos;

	public DatosV(String ciudad) {
		Ciudad = ciudad;
		acumuladorTiempo = 0;
	}

	public DatosV(String ciudad, float acumuladorTiempo) {
		Ciudad = ciudad;
		this.acumuladorTiempo = acumuladorTiempo;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public float getAcumuladorTiempo() {
		return acumuladorTiempo;
	}

	public void setAcumuladorTiempo(float acumuladorTiempo) {
		this.acumuladorTiempo = acumuladorTiempo;
	}

	public float getAcumuladorViaticos() {
		return acumuladorViaticos;
	}

	public void setAcumuladorViaticos(float acumuladorViaticos) {
		this.acumuladorViaticos = acumuladorViaticos;
	}

}
