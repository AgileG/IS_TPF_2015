package main.java.headfirst.combined.djview;

public interface SubmarineModelInterface {

	int getSegundos();
	
	int getCentesimas();
	
	int getX();
	
	int getY();
	
	void setX(int xx);
	
	void setY(int xx);
	
	void iniciarHilo();
	
	void setPausar(boolean b);
	
	boolean getVivo();
	
	void PasarBeatModel(BeatModel modelB);
	
	void registerObserver(BeatObserver o);
  
	void removeObserver(BeatObserver o);
  
	void registerObserver(BPMObserver o);
  
	void removeObserver(BPMObserver o);

}