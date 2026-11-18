import java.util.Random;

public class ArrayGenerator {
  private static final Random rand = new Random();

  // 1. Mảng ngẫu nhiên hoàn toàn
  public static Integer[] generateRandom(int N) {
    Integer[] a = new Integer[N];
    for (int i = 0; i < N; i++) {
      a[i] = rand.nextInt(N);
    }
    return a;
  }

  // 2. Mảng ngược hoàn toàn
  public static Integer[] generateReverse(int N) {
    Integer[] a = new Integer[N];
    for (int i = 0; i < N; i++) {
      a[i] = N - i;
    }
    return a;
  }

  // 3. Mảng trùng lặp 100%
  public static Integer[] generateAllIdentical(int N, int value) {
    Integer[] a = new Integer[N];
    for (int i = 0; i < N; i++) {
      a[i] = value;
    }
    return a;
  }

  // 4. Mảng trùng lặp cao / Hữu hạn khóa
  public static Integer[] generateFewDistinct(int N, int numberOfDistinctValues) {
    Integer[] a = new Integer[N];
    for (int i = 0; i < N; i++) {
      a[i] = rand.nextInt(numberOfDistinctValues);
    }
    return a;
  }

  // 5. Mảng sắp xếp một phần - sai lệch log(N)
  public static Integer[] generatePartiallySortedLogN(int N) {
    Integer[] a = generateSorted(N);
    int swaps = (int) Math.log(N);
    shufflePairs(a, swaps);
    return a;
  }

  // 6. Mảng sai lệch tuyến tính N/10
  public static Integer[] generatePartiallySortedLinear(int N) {
    Integer[] a = generateSorted(N);
    int swaps = N / 10;
    shufflePairs(a, swaps);
    return a;
  }

  // 7. Mảng hình ống (Organ-pipe) - Tăng dần đến N/2 rồi giảm dần
  public static Integer[] generateOrganPipe(int N) {
    Integer[] a = new Integer[N];
    int mid = N / 2;
    for (int i = 0; i < mid; i++) {
      a[i] = i;
    }
    for (int i = mid; i < N; i++) {
      a[i] = N - i;
    }
    return a;
  }

  // 8. Mảng lệch vòng - Ví dụ: lớn nhất lên đầu
  public static Integer[] generateShifted(int N) {
    Integer[] a = new Integer[N];
    a[0] = N;
    for (int i = 1; i < N; i++) {
      a[i] = i;
    }
    return a;
  }
  // 9. Mảng String ngẫu nhiên
  public static String[] generateRandomStrings(int N, int length) {
    String[] a = new String[N];
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    for (int i = 0; i < N; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < length; j++) {
        sb.append(chars.charAt(rand.nextInt(chars.length())));
      }
      a[i] = sb.toString();
    }
    return a;
  }
  // --- CÁC HÀM BỔ TRỢ ---

  // Sinh mảng đã sắp xếp chuẩn
  private static Integer[] generateSorted(int N) {
    Integer[] a = new Integer[N];
    for (int i = 0; i < N; i++) {
      a[i] = i;
    }return a;
  }
  // Tráo đổi ngẫu nhiên số lượng cặp nhất định
  private static void shufflePairs(Integer[] a, int numberOfSwaps) {
    int N = a.length;
    for (int i = 0; i < numberOfSwaps; i++) {
      int idx1 = rand.nextInt(N);
      int idx2 = rand.nextInt(N);
      int temp = a[idx1];
      a[idx1] = a[idx2];
      a[idx2] = temp;
    }
  }

}