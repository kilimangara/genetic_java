package genetic;
import java.util.*;

class MyInteger implements Comparable<MyInteger>{
	
	private	Integer i;
	
	public int getI(){
		return this.i;
	}
	
	MyInteger(Integer i){
		this.i=i;
	}
	@Override
	public boolean equals(Object obj){
		MyInteger integ=(MyInteger) obj;
		return(this.i==integ.i);
	}
	@Override
	public int hashCode(){
		return this.getI();
	}
	@Override
	public int compareTo(MyInteger arg0) {
		
		return i.compareTo(arg0.i);
	}
	@Override
	public String toString(){
		return ""+i;
	}
	
}
public class Main {

	public static void main(String[] args) {
		ArrayList<Square> in=new ArrayList<>();
		in.add(new Square(4,5));
		in.add(new Square(2,3));
		in.add(new Square(1,1));
		in.add(new Square(4,5));
		in.add(new Square(3,4));
		in.add(new Square(2,2));
		in.add(new Square(1,1));
		in.add(new Square(1,1));
		in.add(new Square(3,3));
		in.add(new Square(2,2));
		in.add(new Square(1,1));
		in.add(new Square(2,1));
		in.add(new Square(1,2));
		in.add(new Square(1,3));
		in.add(new Square(3,2));
		in.add(new Square(4,4));
		in.add(new Square(3,2));
		in.add(new Square(1,1));
		in.add(new Square(2,2));
		in.add(new Square(3,3));
		Pool pool=new Pool(in, 7, 7);
		pool.start();
		
		System.out.println(pool.pool.last().sin.ksur);
		
	}

}
