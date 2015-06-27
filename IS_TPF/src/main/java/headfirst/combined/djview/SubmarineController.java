package main.java.headfirst.combined.djview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SubmarineController implements ControllerInterface{
	
	SubmarineModelInterface modelS;
	BeatModelInterface modeB;
	HeartModelInterface modelH;
	DJView view;
	SubmarineView vistaS;
	
    JFrame ventana;
	
	public SubmarineController(SubmarineModelInterface model_1)
	{
		modelS=model_1;
		vistaS= new SubmarineView(this,modelS);
		ventana= new Ventana(vistaS);
		vistaS.PasarFrame(ventana);
		        
	}
	
	public void start(){}
	public void stop(){}
	public void increaseBPM(){}
	public void decreaseBPM(){}
	public void setBPM(int bpm){}


}