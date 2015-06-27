package main.java.headfirst.combined.djview;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SubmarineModel implements SubmarineModelInterface, Runnable{
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	private Thread hilo;
	BeatModel modelB;

	private Timer timer, tiempo;
	private boolean vivo, pausar;
	private int x, y, contador, segundos, centesimas, descargas;
	
	public SubmarineModel()
	{
		contador = 0;

		descargas =10;
		contador = 0;
		segundos = 0;
		descargas =10;
		pausar =false;
		
		x=0;
		y=250;
		vivo=true;
		
	}

	public void run() {
		tiempo = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centesimas++;
			}
		});
		
		while (vivo)
		{
			int bpm=1;
			while(pausar == false){
			if(y>500)
			{
				tiempo.start();
				if(centesimas==10)
				{
					centesimas=0;
					segundos+=1;
					if(segundos <= 5){
					bpm = modelB.getBPM() + 20;
					if(bpm < 60 && segundos<5){modelB.setBPM(bpm);}
					else{modelB.setBPM(60);}
					modelB.notifyBeatObservers();}
				}
				
				if(segundos>=5 && (centesimas%2==0))
				{
					modelB.notifyBeatObservers();
				}
				
				if(segundos==60)
				{
					segundos=0;
					centesimas=0;
				}
			}
			else
			{
				tiempo.stop();
				centesimas=0;
				segundos=0;
				if(bpm > 10){modelB.setBPM(10); bpm=1;}
			}
			}
			tiempo.stop();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void print(String cadena)
	{
		System.out.println(cadena);
	}

	public void terminarJuego() {
		vivo = false;
	}
	
	public void PasarBeatModel(BeatModel model)
	{
		modelB=model;
	}
	
	public void setPausar(boolean b)
	{
		if(b==true){pausar=true;}
		else{pausar=false;}
	}
	
	public boolean getVivo(){return vivo;} 
	
	public int getSegundos(){return segundos;}
	
	public int getCentesimas(){return centesimas;}
	
	public int getX(){return x;}
	
	public int getY(){return y;}
	
	public void setX(int xx){x=xx;}
	
	public void setY(int yy){y=yy;}
	
	public void iniciarHilo()
	{
		hilo = new Thread(this);
		hilo.start();
	}
  
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
  
	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}
  
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
  
	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}


	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}


	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}

}