/*

Task Completion


1. You are given two integers N and M, and an array(arr) of numbers with length M.
2. N represents the total number of tasks assigned to a group of 5 students.
3. Out of these five students, three students completed M number of tasks of their choices and left the group.
4. Tasks completed by these students are represented by the given array.
5. Now, the remaining two students(s1 and s2) have to complete all the remaining tasks.
6. They decided to complete the remaining tasks in an alternate way -
   First of the remaining tasks will be completed by s1
   Second of the remaining tasks will be completed by s2
   Third of the remaining tasks will be completed by s1.. and so on.    
7. You have to find the tasks that s1 and s2 have to complete.

*/

import java.util.*;

public class Main {
	
    public static void completeTask(int n, int m, int[] arr) {
		
		HashSet<Integer> taskCompleted = new HashSet<>();
		for(int i = 0; i < arr.length; i++)
		    taskCompleted.add(arr[i]);
		ArrayList<Integer> s1 = new ArrayList<>(); // task for student 1
		ArrayList<Integer> s2 = new ArrayList<>(); // task for student 2
		
		boolean flag = true;
		for(int i = 1; i <= n; i++)
		{
		    if(!taskCompleted.contains(i))
		    {
		        if(flag)
		        {
		            s1.add(i);
		        }
		        else
		        {
		            s2.add(i);
		        }
		        flag = !flag;
		    }
		}

        for(int i = 0; i < s1.size(); i++)
        {
            System.out.print(s1.get(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < s2.size(); i++)
        {
            System.out.print(s2.get(i) + " ");
        }
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
	}

}
