package os;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Best_Fit {
	List<Integer>segments=new ArrayList<>();
	List<Integer>jobs=new ArrayList<>();
	List<Pair>pairList=new ArrayList<Pair>();
	
	public Best_Fit(List<Integer>list1,List<Integer>list2) {
		
		segments=list1;
		jobs=list2;
		
		for(int i=1;i<=jobs.size();i++){
			Boolean flag=false;
			int diff=Integer.MAX_VALUE;
			int index=0;
			for(int j=1;j<=segments.size();j++){
				if(segments.get(j-1)>=jobs.get(i-1)){
					int remain=segments.get(j-1)-jobs.get(i-1);
					if(remain<diff){
						diff=remain;
						index=j;
					}
					flag=true;
					
				}
			}
			if(!flag){
				System.out.println("There is no available segment for job "+i);
			}
			else {  
				System.out.println("segment "+index+" is best fit for job "+i);
				pairList.add(new Pair(index, i,jobs.get(i-1)));
				segments.set(index-1, segments.get(index-1)-jobs.get(i-1));
			}	
				
		}
	}
	public void printMemory(){
		
		Collections.sort(pairList, new PairComarator());
		System.out.println("MEMORY ALLOCATION\n==================");
		for(int i=0;i<segments.size();i++){
			System.out.printf("SEGMENT :%d\n",i+1);
			for(int j=0;j<pairList.size();j++){
				if(i==pairList.get(j).segmentNumber-1){
					System.out.printf("job %d,job size %dKb\n",pairList.get(j).jobNumber,pairList.get(j).jobSize);
				}
			}
			if(segments.get(i)!=0){
				System.out.println("unused "+segments.get(i)+"Kb\n==================");
			}
			else System.out.println("==================");
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>segment=new ArrayList<>();
		List<Integer>job=new ArrayList<>();
		Integer numberOfSegments,numberOfJobs;
		Scanner input=new Scanner(System.in);
		
		System.out.println("how many memory segments you want to create?");
		numberOfSegments=input.nextInt();
		System.out.println("how many jobs you have?");
		numberOfJobs=input.nextInt();
		
		System.out.println("Input your segments size:");
		for(int i=0;i<numberOfSegments;i++){
			segment.add(input.nextInt());
		}
		System.out.println("Input your jobs size:");
		for(int j=0;j<numberOfJobs;j++){
			job.add(input.nextInt());
		}
		Best_Fit bestFit=new Best_Fit(segment, job);
		bestFit.printMemory();

	}

}
