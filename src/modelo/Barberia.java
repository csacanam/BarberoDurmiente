package modelo;

import java.util.Random;

public class Barberia {
	

	private Silla [] sillasDeEspera;
	private Barbero barbero;
	private Silla sillaDeBarberia;
	
	public Barberia(){
		inicializar();
		
	}
	
	public void inicializar(){
		//Igualar sillas de espera
		//No están ocupadas al iniciar
		sillasDeEspera = new Silla[5];
		for(int i=0;i<sillasDeEspera.length;i++){
			sillasDeEspera[i] = new Silla(false);
		}
		
		//La silla de barbería no está ocupada al iniciar
		sillaDeBarberia = new Silla(false);
		
		//Iniciar al barbero
		barbero = new Barbero(this);
		barbero.setDormido(true);
	}


	public boolean hayClienteNuevo(){
		Random ran = new Random();
		return ran.nextBoolean();		
	}
	
	public void llegaCliente(){

		//LlEGA UN NUEVO CLIENTE
		if(getBarbero().isDormido()==true){
			getBarbero().setDormido(false);
			getSillaDeBarberia().setOcupada(true);
		}else{
				if(haySillasDeEsperaDisponibles()==true){
					ocuparSillaEspera();
				}
		

		}
		
	}
	
	public boolean sillasDeEsperaVacias(){
		for(int i = 0;i<getSillasDeEspera().length;i++){
			if(getSillasDeEspera()[i].isOcupada()==true){
				return false;
			}
		}
		return true;
	}
	
	public boolean haySillasDeEsperaDisponibles(){
		for(int i = 0;i<getSillasDeEspera().length;i++){
			if(getSillasDeEspera()[i].isOcupada()==false){
				return true;
			}
		}
		return false;
	}
	
	public void ocuparSillaEspera(){
		for(int i = 0;i<getSillasDeEspera().length;i++){
			if(getSillasDeEspera()[i].isOcupada()==false){
				getSillasDeEspera()[i].setOcupada(true);
				return;
			}
		}
	}
	
	public void desocuparSillaEspera(){
		for(int i = getSillasDeEspera().length-1;i>=0;i--){
			if(getSillasDeEspera()[i].isOcupada()==true){
				getSillasDeEspera()[i].setOcupada(false);
				return;
			}
		}
	}

	public Silla[] getSillasDeEspera() {
		return sillasDeEspera;
	}

	public void setSillasDeEspera(Silla[] sillasDeEspera) {
		this.sillasDeEspera = sillasDeEspera;
	}

	public Barbero getBarbero() {
		return barbero;
	}

	public void setBarbero(Barbero barbero) {
		this.barbero = barbero;
	}

	public Silla getSillaDeBarberia() {
		return sillaDeBarberia;
	}

	public void setSillaDeBarberia(Silla sillaDeBarberia) {
		this.sillaDeBarberia = sillaDeBarberia;
	}

}
