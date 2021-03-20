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
		System.out.println(h.top());
		System.out.println(h.list);
	}

}

