package Tests;


import junit.framework.*;
//import main.java.headfirst.combined.djview.BeatController;
import main.java.headfirst.combined.djview.HeartModel;
//import main.java.headfirst.combined.djview.BPMObserver;
//import main.java.headfirst.combined.djview.BeatObserver;


public class SingletonHeartModelTest extends TestCase {


private HeartModel heart01, heart02;

public void setObs() {
    
    heart01 = HeartModel.getInstancia();
    heart02 = HeartModel.getInstancia();
    
}

//testea que ambas sean las mismas
public void testHeart() {
	setObs();
    TestCase.assertEquals( heart01,heart02 );
    //TestCase.assertEquals( true, heart02== HeartModel.getInstancia());
}


	
}


