package hashcode;

import java.util.LinkedList;

import org.apache.commons.collections4.bidimap.DualTreeBidiMap;
import util.RequestComparator;
import util.RequestMaxPQ;

/**
 * Created by pierre on 23/02/17
 */
public class Cache {
    public LinkedList<Integer> videos = new LinkedList<>();
    public double remainingMemory;
    
    public DualTreeBidiMap<Integer, Integer> poplist = new DualTreeBidiMap<>();
    
    
    RequestMaxPQ<Request> pq = new RequestMaxPQ<Request>(1000, new RequestComparator());
    
    
}
