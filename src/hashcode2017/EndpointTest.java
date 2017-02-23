package hashcode2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

public class EndpointTest {
	public static void main(String[] args) {
		ArrayList<Endpoint> elist = new ArrayList<Endpoint>();
		
		Cache e1c1 = new Cache();
		e1c1.poplist = new DualTreeBidiMap<Integer, Integer>();
		Cache e1c2 = new Cache();
		e1c2.poplist = new DualTreeBidiMap<Integer, Integer>();
		
		Endpoint e1 = new Endpoint();
		e1.caches = new LinkedList<Cache>();
		e1.anticipations = new HashMap<Integer, Integer>();
		Endpoint e2 = new Endpoint();
		e2.caches = new LinkedList<Cache>();
		e2.anticipations = new HashMap<Integer, Integer>();
		
		e1.caches.add(e1c1);
		
		e2.caches.add(e1c1);
		e2.caches.add(e1c2);
		
		e1.anticipations.put(0, 100);
		e2.anticipations.put(1, 150);
		e1.anticipations.put(1, 30);
		
		elist.add(e1);
		elist.add(e2);
	
		
		for(Endpoint e : elist){
			e.sendRequests();
		}
		
		System.out.println(e1c1.poplist);
		System.out.println(e1c2.poplist);
		
	}
}
