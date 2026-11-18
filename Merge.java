/*
  Sử dụng bản Merge sort chuẩn chỉ chọn code tối ưu chỗ CUTOFF
  ở trong phần này em muốn là lấy thuật toán merge sort gốc làm mốc để so sánh
  nên em đã thêm điểm kiện  if (hi <= lo) return; vào đầu để cho phép cả giá trị null
  khi cutoff=0 thì đây chính là thuật toán merge sort gốc ban đầu
 */
public class Merge {
  public static int CUTOFF=10;
  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
  {

    for (int k = lo; k <= hi; k++)
      aux[k] = a[k];
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++)
    {
      if      (i > mid)               a[k] = aux[j++];
      else if (j > hi)                a[k] = aux[i++];
      else if (Insertion.less(aux[j], aux[i])) a[k] = aux[j++];
      else                            a[k] = aux[i++];
    }
  }

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
  {
    if (hi <= lo) return;// phần điều kiện em thêm vài để chấp nhận cutoff=0
    if (hi <= lo + CUTOFF - 1)
    {
      Insertion.sort(a, lo, hi);
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort (a, aux, lo, mid);
    sort (a, aux, mid+1, hi);
    merge(a, aux, lo, mid, hi);
  }

  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }
}