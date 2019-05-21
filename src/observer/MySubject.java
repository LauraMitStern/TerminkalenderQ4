package observer;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Laura Pein
 */
public class MySubject {

    private List<MyObserver> observers = new ArrayList();
    
    public void register(MyObserver o){
        observers.add(o);
    }
    
    public void deregister(MyObserver o){
        observers.remove(o);
    }
    
    public void info(Object o){
        for (MyObserver observer : observers) {
            observer.update(o);
        }
    }
}

