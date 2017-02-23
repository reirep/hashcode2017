package res.hashcode;

import java.util.LinkedList;

/**
 * Created by pierre on 23/02/17
 */
public class Endpoint {
    
    public double delay = 0;
    
    LinkedList<Integer> video = new LinkedList<>();
    LinkedList<Integer> prevu = new LinkedList<>();
    
    LinkedList<Cache> caches = new LinkedList<>();
    LinkedList<Integer> delayCache = new LinkedList<>();

}
