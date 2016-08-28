package genetic;

import java.util.Random;
public class Chromosome implements Comparable<Chromosome> {
	static public int maxl;
	static public int maxw;
	public Squares sin;
	public boolean[] map;
	Chromosome(int l, int w){
		Random r=new Random();
		map=new boolean[Pool.allsquares.size()];
		for(int i=0; i<Pool.allsquares.size();i++){
			map[i]=r.nextBoolean();
		}
		sin=new Squares(Pool.allsquares,map);
		sin.search(w, l);
		maxl=l;
		maxw=w;
	}
	Chromosome(boolean[] map1,boolean[] map2){
		map=new boolean[map1.length];
		for(int i=0;i<map1.length;i++){
			if(i%2==0){
				map[i]=map1[i];
			}
			else{
				map[i]=map2[i];
			}
		}
		sin=new Squares(Pool.allsquares,map);
		sin.search(maxw, maxl);
	}
	public Chromosome crossover(Chromosome ch){
		return new Chromosome(this.map,ch.map);
	}
	@Override
	public int compareTo(Chromosome ch) {
		Double firstel=this.sin.ksur;
		if(firstel.compareTo((Double)ch.sin.ksur)==0){
		if(this.equals(ch)){
			return 0;
		}
		else{
			return 1;
		}
		}
		else{
			return firstel.compareTo((Double)ch.sin.ksur);
		}
		}
	
	
	
	
}
