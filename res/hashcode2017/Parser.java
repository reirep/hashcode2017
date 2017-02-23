package hashcode2017;


import java.io.*;
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
        build("/home/pierre/Téléchargements/kittens.in");
        
        for(Endpoint e  : endpoints)
            e.sendRequests();
        
        boolean marqueur = true;
        while(marqueur){
            marqueur = false;
            for(Cache c : caches) {
                if(c.addCache())
                    marqueur = true;
            }
            for(Endpoint e : endpoints)
                e.braseCaches();
        }
        
        write("kitten.out");
        //build list
        //while alexis methods return true on one cache
            //iterrate all the endpoint
        
        //serialise
        
    }
    
    //consrtire la liste de requetes des caches
    
    //--st loop
    
    //parser tt les caches et charger la video #1 de la liste de pop dans le cache et pop la vidéo de la liste
    
    // parser tt les users pr vois quels viéos ont été acceptés et les deload deqs autres caches
    
    //-- end loop
    
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
            //System.out.println(nbreVideos+"\t"+nbreEndpoint+"\t"+nbreAnticipatedrequest+"\t"+nbreCache+"\t"+tailleCache);
            //System.out.flush();
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
                    endpoints.add(e);
                }
            }
            
            //on parse les request
            for(int i = 0; i < nbreAnticipatedrequest; i++){
                split = rb.readLine().split(" ");
                Endpoint  e = endpoints.get(Integer.parseInt(split[1]));
                e.anticipations.put(Integer.parseInt(split[0]), Integer.parseInt(split[2]));
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
    
    public static void write(String s){
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(s));
            bw.write(getNbreCacheUsed()+"\n");
            for(int i = 0; i < caches.size(); i++) {
                bw.write(i + " ");
                Cache c = caches.get(i);
                for(int j = 0; j < c.videos.size(); j++)
                    bw.write(c.videos.get(j)+"");
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
    
    public static int getNbreCacheUsed(){
        int ret = 0;
        for(Cache c : caches)
            if(c.videos.size() != 0)
                ret ++;
        return ret;
    }
}
