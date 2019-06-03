package kmp;

public class Prefix {
	
	int m,k=0;
	int f[];
	String p;

	public Prefix(String pattern) {
	
		p=pattern;
		m=p.length();
		 f=new int[m];
		 f[0]=0;
		
	}	
	
	public int[] prefixFunction(){
		
		for(int i=1;i<m;i++){
			
			while(k>0 && p.charAt(k)!=p.charAt(i)){
				
				k=f[k];
			}
			
			if(p.charAt(k)==p.charAt(i))
				k=k+1;
			
			f[i]=k;
		}
		
		return f;
	}
	
}
