package grafos;

import java.util.ArrayList;

public class Vertice<DatosV> {

	private int Cve;
	private boolean Visitado;
	private DatosV Datos;
	private ArrayList<Arista<DatosA>> Adyacentes;
	private ArrayList<Vertice<DatosV>> path;

	public Vertice(int cve, DatosV datos) {
		Cve = cve;
		Datos = datos;
		Visitado = false;
		Adyacentes = new ArrayList<Arista<DatosA>>();
	}

	public boolean isVisitado() {
		return Visitado;
	}

	public void setVisitado(boolean visitado) {
		Visitado = visitado;
	}

	public int getCve() {
		return Cve;
	}

	public void setCve(int cve) {
		Cve = cve;
	}

	public DatosV getDatos() {
		return Datos;
	}

	public void setDatos(DatosV datos) {
		Datos = datos;
	}

	public ArrayList<Arista<DatosA>> getAdyacentes() {
		return Adyacentes;
	}

	public void setAdyacentes(ArrayList<Arista<DatosA>> adyacentes) {
		Adyacentes = adyacentes;
	}

	public ArrayList<Vertice<DatosV>> getPath() {
		return path;
	}

	public void setPath(ArrayList<Vertice<DatosV>> path) {
		this.path = new ArrayList<Vertice<DatosV>>();
		this.path.addAll(path);
		this.path.add(this);
	}

}
