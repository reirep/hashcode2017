package hashcode2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;

/**
 * Created by pierre on 23/02/17
 */
public class Parser {
    
    public static double nbreVideos, nbreEndpoint, nbreAnticipatedrequest, nbreCache, tailleCache;
    
    public static LinkedList<Integer> videos = new LinkedList<>();
    public static LinkedList<Cache> caches = new LinkedList<>();
    public static  LinkedList<Endpoint> endpoints = new LinkedList<>();
    
    
    
    
    public static void main(String ... args){
        
    }
    
    
    
    public static void build(String in){
        BufferedReader rb;
        try {
            rb = new BufferedReader(new FileReader(in));
            String read = rb.readLine();
            String [] split = read.split(" ");
            
            //getting all the numbers
            nbreVideos = Integer.parseInt(split[0]);
            nbreEndpoint = Integer.parseInt(split[1]);
            nbreAnticipatedrequest = Integer.parseInt(split[2]);
            nbreCache = Integer.parseInt(split[3]);
            tailleCache = Integer.parseInt(split[4]);
    
            //créer les caches ici
            for(int i = 0; i < nbreCache; i++) {
                Cache c = new Cache();
                c.remainingMemory = tailleCache;
                caches.add(c);
            }
            
            //on parse les videos
            read = rb.readLine();
            split = read.split(" ");
            for(int i = 0; i < nbreVideos; i++)
                videos.add(Integer.parseInt(split[i]));
            
            //on parse les enpoints
            for(int i = 0; i < nbreEndpoint; i++){
                split = rb.readLine().split(" ");
                Endpoint e = new Endpoint();
                e.delay = Integer.parseInt(split[0]);
                int nbCache = Integer.parseInt(split[1]);
                for(int j = 0; j < nbCache; j++){
                    //on lit les caches des endpoints
                    split = rb.readLine().split(" ");
                    e.caches.add(caches.get(Integer.parseInt(split[0])));
                    e.delayCache.add(Integer.parseInt(split[1]));
                }
            }
            
            //on parse les request
            for(int i = 0; i < nbreAnticipatedrequest; i++){
                split = rb.readLine().split("");
                Endpoint  e = endpoints.get(Integer.parseInt(split[1]));
                e.video.add(Integer.parseInt(split[0]));
                e.prevu.add(Integer.parseInt(split[2]));
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
