package genetic;
import java.lang.*;
enum TypeOfStick{
	FlOOR,CEILING,NONE
}


public class Square implements Comparable<Square>{
	private static int num=0;
	public int id;
	public int l;
	public int w;
	public boolean isUsed=false;
	public TypeOfStick s=TypeOfStick.NONE; 
	Square(int l, int w){
		this.w=w;
		this.l=l;
		num++;
		id=num;
	}
	Square(){
		this.w=0;
		this.l=0;
	}
	public int CalcSq(){
		return l*w;
	}
	public int compareTo(Square obj){
		Integer w=(Integer)this.w;
		Integer ww=(Integer)obj.w;
		if (w==ww){
			Integer l=this.l;
			Integer ll=obj.l;
			return ll.compareTo(l);
		}
		return ww.compareTo(w);
		}
	public String toString(){
		String s="\r\n";
		for(int k=1;k<=w;k++){
		for(int i=1;i<=l;i++){
		s=s+"*";
		}
		s=s+"\r\n";
		}
		return s;
	}
	
}
