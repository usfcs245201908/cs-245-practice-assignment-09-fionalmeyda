import java.util.Arrays;
import java.util.EmptyStackException;
public class BinaryHeap{
	protected int[]data;
	int size;
	int max_size;
	public BinaryHeap(){
		data = new int[10];
		size = 0;
		max_size= data.length -1 ;
	}

	public void add(int item){
		if(size>=max_size){
			growarray();
			max_size = max_size * 2;
		}
		data[size++]=item;
		int child = size-1;
		int parent = (child-1)/2;
		size++;
		while(parent>0 && data[parent]>data[child]){
			swap(data,parent,child);
			child = parent;
			parent =(child-1)/2;
			

		}
	}
	public int remove(){
		if(size < 0 ){
			throw new EmptyStackException();
		}
		int remo = data[0];
		int last_e = data[max_size];
		data[0]=last_e;
		size--;
		siftdown(0);
		return remo;
	}
	private void siftdown(int i){
		int leftChild = 2*i + 1;
		int rightChild = 2*i + 2;
		int largerChild=i;
		if(rightChild<size&&data[rightChild]>data[largerChild]){
			largerChild = rightChild;
		}if(leftChild<size&&data[leftChild]>data[largerChild]){
			largerChild = leftChild;
		}
		if(largerChild != i) {
			int temp = data[i];
			data[i] = data[largerChild];
			data[largerChild] = temp;
			siftdown(largerChild);
		}
	}

	public void growarray(){
		int[]array1 = new int [data.length*2];
		for(int i=0;i<data.length ; i ++){
			array1[i] = data[i];
		}
		data= array1;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
  		array[i] = array[j];
  		array[j] = temp;
	}
}