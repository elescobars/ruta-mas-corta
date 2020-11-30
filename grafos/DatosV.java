package grafos;

public class DatosV {

	private String Ciudad;
	private float Tiempo;

	public DatosV(String ciudad) {
		Ciudad = ciudad;
		Tiempo = 0;
	}

	public DatosV(String ciudad, float tiempo) {
		Ciudad = ciudad;
		Tiempo = tiempo;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public float getTiempo() {
		return Tiempo;
	}

	public void setTiempo(float tiempo) {
		Tiempo = tiempo;
	}

}
