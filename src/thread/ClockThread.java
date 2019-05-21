package thread;

import java.time.LocalDateTime;
import observer.MySubject;

/**
 *
 * @author Laura Pein
 */
public class ClockThread extends MySubject implements Runnable{
    private Thread t;
    private LocalDateTime ldt;
    private long counter;
    
    /**
     * Standard constructor for the ClockThread
     * @param name Name of the Thread.
     */
    public ClockThread(String name){
        this.t = new Thread(this, name);
    }
    
    public void start(){
        this.t.setDaemon(true);
        this.counter = 1;
        this.t.start();
    }
    
    @Override
    public void run() {
        while(!this.t.isInterrupted()){
            //Uhrzeit wird immer um eine Sekunde erhöht.
            this.ldt = LocalDateTime.now().plusSeconds(counter);
            this.counter++;
            //Observer bekommt den neuen Wert
            super.info(ldt);
            if (this.t.isInterrupted()) {
                break;
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                this.t.interrupt();
                break;
            }
        }
    }
    
    public void join() throws InterruptedException {
        this.t.join();
    }

    public void interrupt() {
        this.t.interrupt();
    }
}
