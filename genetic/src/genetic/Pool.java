package genetic;

import java.util.ArrayList;

public class Pool {
	static public final int MAX_GENERATIONS=2000;
	static public ArrayList<Square> allsquares;
	public ArrayList<Chromosome> pool;
	Pool(ArrayList<Square> in,int maxl, int maxw){
		allsquares=in;
		boolean usemap[]=new boolean[in.size()-1];
		boolean flag=true;
		while(flag){
			Chromosome ch=new Chromosome(maxl, maxw);
			pool.add(ch);
			flag=false;
			for (int i=0; i<usemap.length;i++){
				usemap[i]=usemap[i]|ch.map[i];
				if (usemap[i]==false){
					flag=true;
				}
			}
			
		}
	}
	public void nextgen(){
		double med=0;
    	for (Chromosome ch:pool){
    		med=med+ch.sin.ksur;
    	}
    	med=med/(double)pool.size();
    	for(Chromosome ch:pool)
    	{
    		if(ch.sin.ksur<med){
    			for(Chromosome ch1:pool){
    				
    			}
    		}
    	}
    	
	}
    public void start(){
    	
    	
    }
}
