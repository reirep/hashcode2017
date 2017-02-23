package hashcode;

import java.util.LinkedList;

import org.apache.commons.collections4.bidimap.DualTreeBidiMap;
/**
 * Created by pierre on 23/02/17
 */
public class Cache {
    public LinkedList<Integer> videos = new LinkedList<>();
    public double remainingMemory;
    
    public DualTreeBidiMap<Integer, Integer> poplist = new DualTreeBidiMap<>();
    
    
    public LinkedList<Integer> videos = new LinkedList<>();// List of the videos available int the cache
    public double remainingMemory;// Space available in the cache
    
    /*
    @pre -
    @post: take the first element from pq and add ths element to the list of videos in the cache
     */
    public boolean addCache() {
        if (pq.isEmpty || remainingMemory == 0)
            return false; // if the RequestList is empty or the cache is full return false

        // Delete video that are too big for the buffer
        while (Parser.videos.get(element.max.key) > remainingmMemory) {
            pq.delMax();
        }
        int videoAdd = (pq.delMax()).key;// Get the key of the video to add to the buffer
        videos.add(videoAdd);
        remaining -= Parser.videos.get(videoAdd); // reduce de size of remainingMemory
        return true;
    }
}
