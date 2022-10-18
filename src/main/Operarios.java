package main;

import java.util.ArrayList;
import java.util.List;

public class Operarios {

	private ArrayList<Rueda> ruedas;
	private ArrayList<Marco> marcos;
	private ArrayList<Bicicleta> bicicletas;

	private int numBicicletas, numMaximoRuedas, numMaximoMarcos;
	private int numOperariosRuedas, numOperariosMarcos, numMontadores;

	public Operarios(int numBicicletas, int numOperariosRuedas, int numOperariosMarcos, int numMontadores,
			int numMaximoRuedas, int numMaximoMarcos) {
		super();
		this.ruedas = new ArrayList<Rueda>();
		this.marcos = new ArrayList<Marco>();
		this.bicicletas = new ArrayList<Bicicleta>();
		this.numBicicletas = numBicicletas;
		this.numOperariosRuedas = numOperariosRuedas;
		this.numOperariosMarcos = numOperariosMarcos;
		this.numMontadores = numMontadores;
		this.numMaximoRuedas = numMaximoRuedas;
		this.numMaximoMarcos = numMaximoMarcos;
	}

	public synchronized void construirMarco() throws InterruptedException {
		while (marcos.size() >= numMaximoMarcos) {
			System.out.println("Array marcos está llena");
			wait();
		}

		Thread.sleep(500);
		Marco nuevoMarco = new Marco();
		System.out.println("Ha creado un nuevo marco / " + nuevoMarco.getId());
		marcos.add(nuevoMarco);

		notifyAll();
	}

	public synchronized void construirRueda() throws InterruptedException {
		while (ruedas.size() >= numMaximoRuedas) {
			System.out.println("Array ruedas está llena");
			wait();
		}
		Thread.sleep(100);
		Rueda nuevaRueda = new Rueda();
		System.out.println("Ha creado una nueva rueda / " + nuevaRueda.getId());
		ruedas.add(nuevaRueda);
		notifyAll();
	}

	public synchronized void construirBicicleta() throws InterruptedException {
		while (ruedas.size() < 2 || marcos.size() < 1) {
			wait();
		}
		Thread.sleep(1000);

		List<Rueda> ruedasBicicleta = ruedas.subList(0, 2);
		List<Marco> marcosBicicleta = marcos.subList(0, 1);

		Bicicleta nuevaBicicleta = new Bicicleta(ruedasBicicleta, marcosBicicleta.get(0));
		System.out.println(nuevaBicicleta);
		bicicletas.add(nuevaBicicleta);

		ruedasBicicleta.clear();
		marcosBicicleta.clear();

		notifyAll();
	}

	public int getNumBicicletas() {
		return numBicicletas;
	}

	public void setNumBicicletas(int numBicicletas) {
		this.numBicicletas = numBicicletas;
	}

	public int getNumOperariosRuedas() {
		return numOperariosRuedas;
	}

	public void setNumOperariosRuedas(int numOperariosRuedas) {
		this.numOperariosRuedas = numOperariosRuedas;
	}

	public int getNumOperariosMarcos() {
		return numOperariosMarcos;
	}

	public void setNumOperariosMarcos(int numOperariosMarcos) {
		this.numOperariosMarcos = numOperariosMarcos;
	}

	public int getNumMontadores() {
		return numMontadores;
	}

	public void setNumMontadores(int numMontadores) {
		this.numMontadores = numMontadores;
	}

}
