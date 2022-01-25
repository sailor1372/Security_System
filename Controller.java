public class Controller {
	
	private boolean mselect = false;

	Controller(boolean mselect){
		this.mselect = mselect;
	}	 
	
	public boolean getselect(){
		return this.mselect; 
		
	}
	public boolean sel(boolean mcselect){ 
		if(this.mselect = mcselect){
			return true;
		}else{
			return false;
		}
		
	}	
}

