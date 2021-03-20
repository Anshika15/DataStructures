import java.util.*;

public class HeapImplementation {
	
		ArrayList<Integer> list = new ArrayList<>();
		boolean minHeap;
		public HeapImplementation(boolean val){
			// configuration of heap
			minHeap = val;
			// block the zero'th index as we are indexing starts from
			list.add(-1);
		}
		
		boolean compare(int a, int b)
		{
			if(minHeap)
			{
				return a < b;
			}
			return a > b;
			
		}
		
		void push(int data)
		{
			//add the element at last.
			list.add(data);
			
			// restore heap property
			int index = list.size() - 1; // last index at which we inserted the element.
			int parent = index / 2;
			while(index > 1 && compare(list.get(index), list.get(parent)))//list.get(index) < list.get(parent)) // second condition is for min or max heap
			{
				// swap(list.get(index), list.get(parent))
				int temp = list.get(index);
				list.set(index, list.get(parent));
				list.set(parent, temp);
				index = parent;
				parent = parent/2;
			}
		}
		
		void pop()
		{
			// remove the top element
			
			// swap(list.get(1), list.get(last))
			int lastIndex = list.size()-1;
			int temp = list.get(1);
			list.set(1, list.get(lastIndex));
			list.set(lastIndex, temp);
			
			list.remove(lastIndex); // remove the last element
			
			heapify(1); // index of the node from which we want to start heapify
		}
		
		void heapify(int index)
		{
			int left = 2*index;
			int right = 2*index + 1;
			
			int minIndex = index;
			// find the minimum element from child nodes as we have to swap with min elemeny.
			//left < list.size() ==> element is in list and second cond. is to check minimum  element
			if(left < list.size() && compare(list.get(left), list.get(index))) 
			{
				minIndex = left;
			}
			//right < list.size() ==> element is in list and second cond. is to check minimum  element
			if(right < list.size() && compare(list.get(right), list.get(minIndex)))
			{
				minIndex = right;
			}
			
			if(minIndex != index) // => we have to swap
			{
				// swap list[index] with list[minIndex];
				
				int temp = list.get(index);
				list.set(index, list.get(minIndex));
				list.set(minIndex, temp);
				
				heapify(minIndex);  // now heapify the swapped node.
			}
		}
		
		boolean empty()
		{
			return list.size() == 1;
		}
		
		int top() {
			return list.get(1);
		}

	public static void main(String[] args) {
		
		HeapImplementation h = new HeapImplementation(true); // true for min heap, false for max heap
		h.push(5);
		h.push(15);
		h.push(2);
		h.push(20);
		h.push(3);
		
		System.out.println(h.list);
		
		while(!h.empty())
		{
			System.out.print(h.top() + " ");
			h.pop();
		}
		
		
	}

}

