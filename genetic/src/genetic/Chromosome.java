package genetic;

import java.util.Random;
public class Chromosome {
	static public int maxl;
	static public int maxw;
	public Squares sin;
	public boolean[] map;
	Chromosome(int l, int w){
		Random r=new Random();
		map=new boolean[Pool.allsquares.size()-1];
		for(int i=0; i<Pool.allsquares.size()-1;i++){
			map[i]=r.nextBoolean();
		}
		sin=new Squares(Pool.allsquares,map);
		sin.sort();
		maxl=l;
		maxw=w;
	}
	Chromosome(boolean[] map1,boolean[] map2){
		int med=map1.length/2;
		map=new boolean[map1.length-1];
		for(int i=0;i<map1.length;i++){
			if(i%2==0){
				map[i]=map1[i];
			}
			else{
				map[i]=map2[i];
			}
		}
		sin=new Squares(Pool.allsquares,map);
		sin.sort();
	}
	public Chromosome crossover(Chromosome ch){
		return new Chromosome(this.map,ch.map);
	}
	
	
	
}
