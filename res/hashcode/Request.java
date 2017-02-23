package res.hashcode;

public class Request {

	/**
	 * @author sdo
	 * */
	
	int videoId;
	int requests;
	int endpointId;
	int vidSize;
	
	public Request(){
		
	}
	
	public Request(int vId, int req, int endId, int vsize){
		this.videoId = vId;
		this.requests = req;
		this.endpointId = endId;
		this.vidSize = vsize;
	}
	
	
}
