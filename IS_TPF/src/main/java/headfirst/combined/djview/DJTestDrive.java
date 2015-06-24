package main.java.headfirst.combined.djview;
  
public class DJTestDrive {

	public static void main (String[] args) {
    	BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    	
    	HeartModelInterface model2 = HeartModel.getInstancia();
		controller = new HeartController(model2);
    }
}
