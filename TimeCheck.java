class TimeCheck{
	int time;
	public int Check(int oldMinute, int newMinute){   
		if(oldMinute > newMinute){ 
			this.time = 60 - ((60- oldMinute) + newMinute);
		}else if(newMinute > oldMinute){
			this.time = 60 - (newMinute - oldMinute);
		}else if(oldMinute == newMinute){
			this.time = 60;
		} 
		return time;
	}
}

