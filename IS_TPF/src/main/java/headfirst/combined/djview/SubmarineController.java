package main.java.headfirst.combined.djview;

public class SubmarineController implements ControllerInterface{
	
	SubmarineModelInterface modelS;
	BeatModelInterface modeB;
	HeartModelInterface modelH;
	DJView view;
	SubmarineView vistaS;
	
	public SubmarineController(SubmarineModelInterface model_1)
	{
		modelS=model_1;
		vistaS= new SubmarineView(this,modelS);
		new Ventana(vistaS);
	}
	
	public void start(){}
	public void stop(){}
	public void increaseBPM(){}
	public void decreaseBPM(){}
	public void setBPM(int bpm){}

}
