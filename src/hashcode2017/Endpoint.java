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
    *
    */
    
    public boolean braseCaches(){
        Set<Integer> s = anticipations.keySet();
        Iterator<Integer> i = s.iterator();
        while(i.hasNext()){
            for(Cache c : caches){
                int current = i.next();
                if(c.videos.get(current) != null && isCached.get(current) == null) {//la vidéo est contenue dans le cache et c'est nouveau
                    //retirer la vidéo de la demande des autres cache si la demande existe encore
                    
                    
                }
            }
        }
        
        
        //TODO
        return false;
    }
    
    
    public void sendRequests(){
    	for(Cache c : this.caches){
    		for(int i = 0; i < anticipations.size(); i++){
    			if(c.poplist.containsKey(i)){
    				Integer popularity = c.poplist.remove(i);
    				popularity += anticipations.get(i);
    				c.poplist.put(i, popularity);
    			} else {
    				c.poplist.put(i, anticipations.get(i));
    			}
    		}
    	}
    }
}
