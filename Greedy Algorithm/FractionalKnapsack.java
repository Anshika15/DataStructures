import java.util.*;
import java.lang.Math;

public class FractionalKnapsack {
	
	double knapsack(int[] w, int[] val, int n, int cap)
	{
		int[] arr = new int[n]; // Amount of each item we are adding in the knapsack
		double V = 0;
		
		Map<Double, Integer> map = new TreeMap<Double, Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++)
		{
			if(w[i] > 0)
			{
				map.put((double)val[i] / (double)w[i], w[i]);
			}
		}
		
		Set<Double> keys = map.keySet();
		Collection<Integer> vals = map.values();
		
		
		Double[] vperw = keys.toArray( new Double[keys.size()] );
		Integer[] weight = vals.toArray( new Integer[vals.size()] );
		
		
		for(int i = 0; i < n; i++)
		{
			if(cap == 0)
			{
				return V;
			}
			int a = Math.min(weight[i], cap);
			double a1 = a;
			V = V + a1 * vperw[i];
			weight[i] = weight[i] - a;
			arr[i] = arr[i] + a;
			cap = cap - a;
		}
		return V;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FractionalKnapsack obj = new FractionalKnapsack();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Total number of items we have: ");
		int n = s.nextInt();
		
		System.out.print("Enter the capacity of knapsack: ");
		int capacity = s.nextInt();
		
		System.out.print("Enter the weights: ");
		int w[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			w[i] = s.nextInt();
		}
		
		System.out.println("Enter the values: ");
		int val[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			val[i] = s.nextInt();
		}

		double totalval = obj.knapsack(w, val, n, capacity);
		
		System.out.println("Total Value: " + String.format("%.3f", totalval));
		

	}

}

