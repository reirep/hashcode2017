package hashcode2017;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by pierre on 23/02/17
 */
public class Endpoint {
    
    public double delay = 0;
    
    // dans l'odre id video, demande
    HashMap<Integer, Integer> anticipations = new HashMap<>();
    HashMap<Integer, Boolean> isCached = new HashMap<>();
    
    LinkedList<Cache> caches = new LinkedList<>();
    
    
    LinkedList<Integer> delayCache = new LinkedList<>();
    
    /*
    * pour touts les caches:
    *   - obtenir la liste des vidéos cachées
    *   - filtrer cette liste pour uniquement les vidéos de cet endpoint
    *   - pour touts les vidéos obtenues
    *       - parcourir touts les caches
    *       - si ils ont la vidéo dans leur liste, diminuer son score de la demande de cet endpoint
    *
    *
    * retourne true si
    */
    
    public void braseCaches(){
        Set<Integer> s = anticipations.keySet();
        for ( Integer idVideo : s ) {
            for ( Cache c : caches ) {
                if ( c.videos.get(idVideo) != null && isCached.get(idVideo) == null ) {//la vidéo est contenue dans le cache et c'est nouveau
                    //retirer la vidéo de la demande des autres cache si la demande existe encore
                    int val = c.poplist.get(idVideo);
                    c.poplist.removeValue(val);
                    
                    if ( val - anticipations.get(idVideo) > 0 )//readd the video if the score is bigger than 0
                        c.poplist.put(val - anticipations.get(idVideo), idVideo);
                    
                    isCached.put(idVideo, true);
                }
            }
            
        }
    }
    
    
    public void sendRequests(){
    	//System.out.println("->      " + this.caches);
    	for(Cache c : this.caches){
    		Iterator<Integer> iter = anticipations.keySet().iterator();
    		Integer i = 0;
    		while(iter.hasNext()){
    			i = iter.next();
    			if(c.poplist.containsKey(i)){
    				//System.out.println("check");
    				//System.out.println(anticipations);
    				//System.out.println(i);
    				if(anticipations.containsKey(i)){
	    				Integer popularity = c.poplist.remove(i);
	    			//	System.out.println(i);
	    			//	System.out.println(popularity);
	    				popularity += anticipations.get(i);
	    				c.poplist.put(i, popularity);
    				}
    			} else {
    				if(anticipations.containsKey(i)){
    					c.poplist.put(i, anticipations.get(i));
    				}
    			}
    		}
    		
    		
    		
    		
    		/*for(int i = 0; i < anticipations.size(); i++){
    			int index = anticipations.get(i);
    			System.out.println("    bite");
    			if(c.poplist.containsKey(i)){
    				System.out.println("check");
    				System.out.println(anticipations);
    				System.out.println(i);
    				if(anticipations.containsKey(i)){
	    				Integer popularity = c.poplist.remove(i);
	    				System.out.println(i);
	    				System.out.println(popularity);
	    				popularity += anticipations.get(i);
	    				c.poplist.put(i, popularity);
    				}
    			} else {
    				if(anticipations.containsKey(i)){
    					c.poplist.put(i, anticipations.get(i));
    				}
    			}
    		}*/
    	}
    }
}
