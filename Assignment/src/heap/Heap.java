package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	public Node root,current;
	public int heapSize=0;
	List<Integer>binaryOfHeapSize;
	
	public void buildHeap(int key){
		heapSize++;
		current=root;
		if(root==null){
			root=new Node(key);
		}
		else {
			buidBinary(heapSize);
			for(int i=binaryOfHeapSize.size()-2;i>=0;i--){
				if(i!=0){
					if(binaryOfHeapSize.get(i)==0){
						current=current.leftNode;
					}
					else {
						current=current.rightNode;
					}
				}
				else {
					 if(binaryOfHeapSize.get(i)==0){
						 current.leftNode=new Node(key);
						 current.leftNode.parent=current;
						 current=current.leftNode;
						 while(current!=root){
							 if(current.key<current.parent.key){
								 int temp=current.key;
								 current.key=current.parent.key;
								 current.parent.key=temp;
								 current=current.parent;
							 }
							 else {
								break;
							}
						 }
					 }
					 else {
						current.rightNode=new Node(key);
						current.rightNode.parent=current;
						current=current.rightNode;
						while(current!=root){
							 if(current.key<current.parent.key){
								 int temp=current.key;
								 current.key=current.parent.key;
								 current.parent.key=temp;
								 current=current.parent;
							 }
							 else {
								break;
							}
						 }
					}
				}
			}
		}
		
	}
	
	public void buidBinary(int heapSize){
		binaryOfHeapSize=new ArrayList<>();
		int reminder;
		while(true){
			reminder=heapSize%2;
			binaryOfHeapSize.add(reminder);
			heapSize=heapSize/2;
			if(heapSize==0)
				break;
		}
	}
	
	public void deleteMin(){
		
		buidBinary(heapSize);
		current=root;
		for(int i=binaryOfHeapSize.size()-2;i>=0;i--){
			
			if(binaryOfHeapSize.get(i)==0){
				current=current.leftNode;
			}
			else {
				current=current.rightNode;
						
			}
			
		}
		
		root.key=current.key;
		current=current.parent;
		if(current.rightNode!=null){
			current.rightNode=null;
		}
		else {
			current.leftNode=null;
		}
		current=root;
		int temp;
		while(current.leftNode!=null){
			
			if( current.rightNode==null||current.leftNode.key<current.rightNode.key){
				if(current.key>current.leftNode.key){
					temp=current.key;
					current.key=current.leftNode.key;
					current.leftNode.key=temp;
					current=current.leftNode;
				}
				else {
					break;
				}
			}
			else {
				if(current.key>current.rightNode.key){
					temp=current.key;
					current.key=current.rightNode.key;
					current.rightNode.key=temp;
					current=current.rightNode;
				}
				else {
					break;
				}
			}
				
		}
		heapSize--;
	}
}
