public class Pass {
	
	//アクセス可能な勤務者情報のカプセル化
	private String KEY;
	private String PASS; 

	Pass(String KEY,String PASS){
		this.KEY = KEY;
	    this.PASS = PASS;
	}	 
	
	public String getKey(){
		return this.KEY; 
		
	}
	public String getPass(){
		return this.PASS; 
		
	}	
	public boolean Start_certify (String name, String pass){ 
		if(this.KEY.equals(name) && this.PASS.equals(pass)){
				return true;
			}else{
				return false;
			}
	}
	public boolean Master_certify (String name, String pass){ 
		if(this.KEY.equals(name) && this.PASS.equals(pass)){
				return true;
			}else{
				return false;
			}
	}
}
