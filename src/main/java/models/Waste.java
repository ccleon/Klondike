package models;

public class Waste extends CardStack{
	@Override
	public String toString(){
		if(this.cardStack.isEmpty()){
			return "<vacio>";
		}else{
			return super.toString();
		}
	}

}
