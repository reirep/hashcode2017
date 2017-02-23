package hashcode;

import java.util.LinkedList;

import util.RequestComparator;
import util.RequestMaxPQ;

/**
 * Created by pierre on 23/02/17
 */
public class Cache {
    public LinkedList<Integer> videos = new LinkedList<>();
    public double remainingMemory;
    
    
    RequestMaxPQ<Request> pq = new RequestMaxPQ<Request>(1000, new RequestComparator());
    
    
}
