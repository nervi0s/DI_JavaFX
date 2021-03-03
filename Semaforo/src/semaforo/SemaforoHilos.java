package semaforo;

//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SemaforoHilos extends Thread {

    private static SemaforoHilos singleton;

    private final Circle circleTop;
    private final Circle circleMiddle;
    private final Circle circleBotton;

    private SemaforoHilos(Circle circleTop, Circle circleMiddle, Circle circleBotton) {
        this.circleTop = circleTop;
        this.circleMiddle = circleMiddle;
        this.circleBotton = circleBotton;
    }

    @Override
    public void run() {

        while (true) {
            try {
                circleBotton.setFill(Color.GREEN);
                Thread.sleep(2000);
                circleBotton.setFill(Color.BLACK);
                circleMiddle.setFill(Color.YELLOW);
                Thread.sleep(2000);
                circleMiddle.setFill(Color.BLACK);
                circleTop.setFill(Color.RED);
                Thread.sleep(2000);
                circleTop.setFill(Color.BLACK);
            } catch (InterruptedException ex) {
                //Logger.getLogger(SemaforoMain.class.getName()).log(Level.SEVERE, null, ex);
                circleTop.setFill(Color.BLACK);
                circleMiddle.setFill(Color.BLACK);
                circleBotton.setFill(Color.BLACK);
                singleton = null;
                return;
            }
        }

    }

    public static SemaforoHilos getInstance(Circle circleTop, Circle circleMiddle, Circle circleBotton) {
        if (singleton == null) {
            singleton = new SemaforoHilos(circleTop, circleMiddle, circleBotton);
        }
        return singleton;
    }

}
