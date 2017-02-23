package util;

import java.util.Comparator;

import hashcode.Request;

public class RequestComparator implements Comparator<Request> {

	@Override
	public int compare(Request o1, Request o2) {
		
		if(!(o1 instanceof Request) || !(o2 instanceof Request)){
			System.err.println("Compare error");
			return -1;
		}
		
		o1 = (Request) o1;
		o2 = (Request) o2;
		
		//if (o1.key == o2.key) return 0;
		if (o1.key > o2.key) return 1;
		if (o1.key < o2.key) return -1;
		return 0;
	}
	
	public RequestComparator(){
		
	}
}
