package genetic;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Squares set=new Squares();
		Scanner in=new Scanner(System.in);
		int choice=0;
		while(choice!=1){
		System.out.print("������� ������");
		int l=in.nextInt();
		System.out.print("������� ������");
		int w=in.nextInt();
		set.add(new Square(l,w));
		System.out.print("���������� y/n");
		choice=in.nextInt();
		}
		System.out.println("������� ������ ����������");
		int l=in.nextInt();
		System.out.println("������� ������ ����������");
		int w=in.nextInt();
		in.close();
		set.sort();
		ArrayList<LinkedList<Square>> first=new ArrayList<LinkedList<Square>>();
		first=set.search(w, l);
		System.out.println(first);
	}

}
