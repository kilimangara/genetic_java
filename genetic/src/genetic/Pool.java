package genetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class Pool {
	static public final int MAX_GENERATIONS=2000;
	static public ArrayList<Square> allsquares;
	public TreeSet<Chromosome> pool;
	public boolean findsol=false;
	Pool(ArrayList<Square> in,int maxl, int maxw){
		allsquares=in;
		Collections.sort(allsquares);
		pool=new TreeSet<>();
		boolean usemap[]=new boolean[in.size()];
		boolean flag=true;
		while(flag){
			int trues=0;
			Chromosome ch=new Chromosome(maxl, maxw);
			ch.sin.search(maxw, maxl);
			if(ch.sin.ksur <= 100.0){
				pool.add(ch);
				for (int i=0; i<usemap.length;i++){
					usemap[i]=usemap[i]|ch.map[i];
					if(usemap[i]==true){
						trues++;
					}
				}
				if(trues==usemap.length){
					flag=false;
				}
			}
		}
	}
	public void nextgen(){
			Random r= new Random();
			int randomNumb=r.nextInt(2)+3;
			int border=r.nextInt(100);
			boolean parentmap[]= new boolean[pool.size()];
			TreeSet<Chromosome> newpool=new TreeSet<>();
			Chromosome massch[]=pool.toArray(new Chromosome[pool.size()]);
			int k=0;
			for(int i=k;i<pool.size();i++){
				if(parentmap[i]==false){
					if((massch[i].sin.ksur > border)&&(i%randomNumb != 0)){
						for(int j=i+1;j<pool.size();j++){
							if(parentmap[j]==false){
								Chromosome newch= new Chromosome(massch[i].map, massch[j].map);
								if(newch.sin.ksur == 100.0){
									findsol=true;
								}
								if((newch.sin.ksur > massch[i].sin.ksur)&&(newch.sin.ksur > massch[j].sin.ksur)){
									if(newch.sin.ksur <= 100.0){
										newpool.add(newch);
									}
								}
								else{
									newpool.add(massch[i]);
									newpool.add(massch[j]);
								}
							}
							else{
								continue;
							}
						}
					}
				}
				else{
					continue;
				}
				
			}
			
			if(newpool.size()!=0){
				pool=newpool;
			};
		}
    public void start(){
    	int i=0;
    	while((i<=Pool.MAX_GENERATIONS)&&(!findsol)){
    		this.nextgen();
    		i++;
    	}
    	
    }
}
