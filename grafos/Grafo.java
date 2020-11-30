package grafos;

import java.util.ArrayList;

public class Grafo {

	private ArrayList<Vertice<DatosV>> LVertices;
	private boolean Diri;

	public Grafo(boolean dirigido) {
		LVertices = new ArrayList<Vertice<DatosV>>();
		Diri = dirigido;
	}

	public void AddVertice(int Cve, DatosV datos) {
		LVertices.add(new Vertice<DatosV>(Cve, datos));
	}

	public void DelVertice(int cveVer) throws GrafoException {
		int index = IndexOfV(cveVer);
		if (index != -1) {
			LVertices.remove(index);
			for (int v = 0; v < LVertices.size(); v++) {
				for (int a = 0; a < LVertices.size(); a++) {
					if (LVertices.get(v).getAdyacentes().get(a).getCveV() == cveVer)
						LVertices.get(v).getAdyacentes().remove(a);
				}
			}
		} else
			throw new GrafoException("Vertice no encontrado");
	}

	public void AddArista(int cveVerOri, int cveVerDes, DatosA datos) {
		int indexO = IndexOfV(cveVerOri);
		int indexD = IndexOfV(cveVerDes);
		if (indexO != -1 && indexD != -1)
			LVertices.get(indexO).getAdyacentes().add(new Arista<DatosA>(cveVerDes, datos));
		if (!Diri)
			LVertices.get(indexD).getAdyacentes().add(new Arista<DatosA>(cveVerOri, datos));
	}

	public void DelArista(int cveVerOri, int cveVerDes) throws GrafoException {
		int indexO = IndexOfV(cveVerOri);
		if (indexO != -1) {
			int indexD = IndexOfA(LVertices.get(indexO).getAdyacentes(), cveVerDes);
			if (indexD != -1) {
				LVertices.get(indexO).getAdyacentes().remove(indexD);
				if (!Diri) {
					indexO = IndexOfV(cveVerDes);
					if (indexO != -1) {
						indexD = IndexOfA(LVertices.get(indexO).getAdyacentes(), cveVerOri);
						if (indexD != -1)
							LVertices.get(indexO).getAdyacentes().remove(indexD);
					} else
						throw new GrafoException("El vertice no existe");
				}
			}
		} else
			throw new GrafoException("El vertice no existe");
	}

	public void Recorrido(char tipo_A_P) throws GrafoException {
		switch (tipo_A_P) {
			case 'a':
			case 'A':
				RPA();
				break;
			case 'p':
			case 'P':
				RPP();
				break;
			case 'v':
			case 'V':
				CaminoMenosViaticos();
				break;
			default:
				throw new GrafoException("Tipo de recorrido invalido");
		}
	}

	private void RPA() {
		PreparaInicioDeRecorrido();
		if (LVertices.size() > 0) {
			Visitar(LVertices.get(0).getDatos());
			LVertices.get(0).setVisitado(true);
			ColaAdd(LVertices.get(0).getCve());
			int v = ColaRet(), indexV = 0, NumAdy = 0, indexVA = 0;
			while (v > 0) {
				indexV = IndexOfV(v);
				if (indexV == -1) {
					System.out.println("A ver cuando sale esto");
					return;
				}
				ArrayList<Arista<DatosA>> Ady = LVertices.get(indexV).getAdyacentes();
				NumAdy = Ady.size();
				for (int a = 0; a < NumAdy; a++) {
					indexVA = IndexOfV(Ady.get(a).getCveV());
					if (!LVertices.get(indexVA).isVisitado()) {
						ColaAdd(Ady.get(a).getCveV());
						Visitar(LVertices.get(indexVA).getDatos());
						LVertices.get(indexVA).setVisitado(true);
					}
				}
				v = ColaRet();
			}
			System.out.println();
		} else
			System.out.println("Grafo vacio");
	}

	private void RPP() {
		PreparaInicioDeRecorrido();
		if (LVertices.size() > 0) {
			RPP(0);
			System.out.println();
		} else
			System.out.println("Grafo vacio");
	}

	private void RPP(int index) {
		Visitar(LVertices.get(index).getDatos());
		LVertices.get(index).setVisitado(true);
		for (int i = 0; i < LVertices.get(index).getAdyacentes().size(); i++) {
			int SigIndex = IndexOfV(LVertices.get(index).getAdyacentes().get(i).getCveV());
			if (!LVertices.get(SigIndex).isVisitado())
				RPP(SigIndex);
		}
	}

	private void CaminoMenosViaticos() {

		ArrayList<Vertice<DatosV>> caminoMasBarato = new ArrayList<Vertice<DatosV>>();
		float acumuladorViaticos = 0;

		PreparaInicioDeRecorrido();
		if (LVertices.size() > 0) {
			Visitar(LVertices.get(0).getDatos());
			LVertices.get(0).setVisitado(true);

			caminoMasBarato.add(LVertices.get(0));

		} else
			System.out.println("Grafo vacio");

	}

	private int IndexOfV(int cve) {
		for (int i = 0; i < LVertices.size(); i++)
			if (LVertices.get(i).getCve() == cve)
				return i;
		return -1;// aqui
	}

	private int IndexOfA(ArrayList<Arista<DatosA>> LA, int cve) {
		for (int i = 0; i < LA.size(); i++)
			if (LA.get(i).getCveV() == cve)
				return i;
		return -1;
	}

	private ArrayList<Integer> cola = new ArrayList<Integer>();

	private void ColaAdd(int vertice) {
		cola.add(vertice);
	}

	private int ColaRet() {
		if (cola.size() > 0) {
			int SigCve = cola.get(0);
			cola.remove(0);
			return SigCve;
		}
		return 0;
	}

	private void PreparaInicioDeRecorrido() {
		for (int i = 0; i < LVertices.size(); i++) {
			LVertices.get(i).setVisitado(false);
		}
	}

	private static void Visitar(DatosV vertice) {
		System.out.println(vertice.getCiudad() + ", ");
	}

}
