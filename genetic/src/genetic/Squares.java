package genetic;
import java.util.ArrayList;
import java.util.*;

public class Squares {
	private ArrayList<Square> set;
	public Squares(){
		set=new ArrayList<>();
	}
	public Squares(ArrayList<Square> in, boolean[] map){
		for(int i=0;i<map.length;i++){
			if(map[i]==true){
				set.add(in.get(i));
			}
		}
	}
	public void add(Square in ){
		set.add(in);
	}
	public double ksur=0;
	public ArrayList<LinkedList<Square>> search(int maxw, int maxl){
		int sp=0;
		int mw=maxw;
		int level=0;
		int mew=0;
		int mml=0;
		int mel=0;
		ArrayList<LinkedList<Square>> l=new ArrayList<LinkedList<Square>>();
		l.add(new LinkedList<Square>());
		LinkedList<Square> lev;
		for(Square s:set){
				lev=l.get(level);
				if(lev.isEmpty()){
					if((s.w<=mw)&(s.l<=maxl)){
					s.s=TypeOfStick.FlOOR;
					lev.add(s);
					sp=sp+s.CalcSq();
					mw=maxw-s.w;
					mml=maxl-s.l;
					mew=s.w;
					}
					else{
						continue;
					}
				}
				else{
					if(s.l<=mml){
						s.s=TypeOfStick.FlOOR;
						lev.add(s);
						sp=sp+s.CalcSq();
						mml=mml-s.l;
						if((lev.getFirst().w-s.w)<=mew){
							mew=lev.getFirst().w-s.w;
							mel=mel+s.l;
						}
					}
					else{
						if((s.l<=mel)&(s.w<=mew)){
							s.s=TypeOfStick.CEILING;
							lev.add(s);
							sp=sp+s.CalcSq();
							mel=mel-s.l;
							if(mel==0){
								if(mw==0){
									break;
								}
								l.add(new LinkedList<Square>());
								level++;
								mel=0;
							}
						}
						else{
							if(mw!=0){
							l.add(new LinkedList<Square>());
							level++;
							mel=0;
							}
							else{
								break;
							}
						}
					}
				}
		}
		this.ksur=((double)sp/(double)(maxl*maxw))*100.0;
		return l;
	}
	
	public void sort(){ 
		
		Collections.sort(set);
	}
	public String toString(){
		return set.toString();
	}

}
