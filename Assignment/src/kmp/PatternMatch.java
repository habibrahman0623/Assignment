package kmp;

public class PatternMatch {
	
	String text="bacbababaababacbab";
	static String pattern="ababacb";
	int n,m,q;
	int f[];
	
	public PatternMatch(Prefix p) {
		n=text.length();
		m=pattern.length();
		f=new int [m];
		f=p.prefixFunction();
		for(int i=0;i<n;i++){
			while(q>0 && pattern.charAt(q)!=text.charAt(i))
				q=f[q];
			if(pattern.charAt(q)==text.charAt(i))
				q=q+1;
			if(q==m){
				System.out.println("Pattern match with shift "+(i+1-m));
				q=f[q-1];
			}	
		}
	}

	public static void main(String[] args) {

		
		Prefix prefix=new Prefix(pattern);
		PatternMatch patternMatch=new PatternMatch(prefix);
	}

}
