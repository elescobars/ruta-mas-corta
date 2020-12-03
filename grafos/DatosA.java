package grafos;

public class DatosA {

	private float viaticos;
	private float tiempo;

	public DatosA(float tiempo) {
		this.tiempo = tiempo;
		viaticos = 0;
	}

	public DatosA(float tiempo, float viaticos) {
		this.viaticos = viaticos;
		this.tiempo = tiempo;
	}

	public float getViaticos() {
		return viaticos;
	}

	public void setViaticos(float viaticos) {
		this.viaticos = viaticos;
	}

	public float getTiempo() {
		return tiempo;
	}

	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}

}
