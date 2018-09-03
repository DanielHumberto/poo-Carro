public class Carro {
	public float gas = 0; 
	public float gasMax = 10; 
	public int pass = 0; 
	int passMax = 2; 
	public float km = 0;
	public boolean in(){
		if(pass<passMax){			
			pass += 1;
			return true;
		}else{
			return false;
		}	
	}
	public boolean out() {
		if(pass>0){
			pass -= 1;
			return true;
		}else{
			return false;
		}
	}
	public void fuel(float value){
		gas += value;
		if(gas>gasMax) gas=gasMax;
	}
	public boolean drive(float distance) {
		if(pass>0) {
			if(distance/gasMax<=gas) {
				gas -= distance/gasMax;
				km += distance;
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}	
	}
	public String show() {
		return "pass: "+pass+", gas: "+gas+", km: "+km; 
	}
}