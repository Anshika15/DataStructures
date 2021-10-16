import java.util.*;
import java.io.*;

public class Main {
  /*
  1. You are provided with marks of N students in Physics, Chemistry and Maths.
  Perform the following 3 operations:
  a). Sort the students in Ascending order of their Physics marks.
  b). Once this is done, sort the students having same marks in Physics in the descending order of their Chemistry marks.
  c). Once this is also done, sort the students having same marks in Physics and Chemistry in the ascending order of their Maths marks.
  2. Your task is to complete the function customSort() which takes  phy[],  chem[],  math[] . The function sorts the marks in the described order and the final changes should be made in the given arrays only
  */
  static class Marks implements Comparable<Marks> {
    int phy;
    int chem;
    int math;
    Marks() {
    }

    Marks(int phy, int chem, int math)
    {
      this.phy = phy;
      this.chem = chem;
      this.math = math;
    }

    public int compareTo(Marks mark) {
      if (this.phy != mark.phy)
      {
        return this.phy - mark.phy;
      }
      else if (this.chem != mark.chem)
      {
        return mark.chem - this.chem;
      }
      else return this.math - mark.math;
    }
  }

  /*You have to complete the body of customSort function,
  after sorting final changes should be made in given arrays only. */
  public static void customSort(int[]phy, int[]chem, int[]math) {
    int n = phy.length;
    Marks[] arr = new Marks[n];

    for (int i = 0; i < n; i++)
    {
      arr[i] = new Marks(phy[i], chem[i], math[i]);
    }

    Arrays.sort(arr);

    for (int i = 0; i < n; i++)
    {
      phy[i] = arr[i].phy;
      chem[i] = arr[i].chem;
      math[i] = arr[i].math;
    }
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);

    //input work
    int N = scn.nextInt();

    int[]phy = new int[N];
    int[]chem = new int[N];
    int[]math = new int[N];

    for (int i = 0; i < N; i++) {
      phy[i] = scn.nextInt();
    }

    for (int i = 0; i < N; i++) {
      chem[i] = scn.nextInt();
    }

    for (int i = 0; i < N; i++) {
      math[i] = scn.nextInt();
    }

    customSort(phy, chem, math);

    //output
    for (int i = 0; i < N; i++) {
      System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
    }
  }
}
