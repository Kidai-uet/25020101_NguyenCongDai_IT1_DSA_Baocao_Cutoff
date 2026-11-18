/*
  Sử dụng cài đặt chuẩn của giáo trình chỉ sửa API theo đa hình của hàm sort
 */
public class Insertion {
  //code giáo trình
  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++)
      for (int j = i; j > 0; j--)
        if (less(a[j], a[j - 1]))
          exch(a, j, j - 1);
        else break;
  }
  // Sửa API theo lời gọi hàm Merge
  public static void sort(Comparable[] a, int lo , int hi) {
    for (int i = lo; i < hi+1; i++)
      for (int j = i; j > lo; j--)
        if (less(a[j], a[j - 1]))
          exch(a, j, j - 1);
        else break;
  }

  public static boolean less(Comparable v, Comparable w)
  {  return v.compareTo(w) < 0;}

  private static void exch(Comparable[] a, int i, int j)
  {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
}