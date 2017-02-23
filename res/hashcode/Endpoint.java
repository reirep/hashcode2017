package res.hashcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by pierre on 23/02/17
 */
public class Endpoint {
    
    public double delay = 0;
    
    // dans l'odre id video, demande
    HashMap<Integer, Integer> anticipations = new HashMap<>();
    
    LinkedList<Cache> caches = new LinkedList<>();
    LinkedList<Integer> delayCache = new LinkedList<>();
    
    /*
    * pour touts les caches:
    *   - obtenir la liste des vidéos cachées
    *   - filtrer cette liste pour uniquement les vidéos de cet endpoint
    *   - pour touts les vidéos obtenues
    *       - parcourir touts les caches
    *
    *
    *
    */
    
    public boolean braseCaches(){
        
        return false;
    }

}
