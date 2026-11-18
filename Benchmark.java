import java.util.Locale;
public class Benchmark {
  // Các kích thước N cần test
  // Quét từ mảng siêu nhỏ đến mảng khổng lồ
  private static final int[] N_VALUES = {
    10000,
    20000,     // 20K (Nhân đôi để test Doubling)
    50000,     // 50K
    100000,    // 100K
    250000,    // 250K
    500000,    // 500K
    1000000,   // 1 Triệu
    2000000,   // 2 Triệu
  };
  // Số lần chạy lặp lại để lấy trung bình (em để 5 lần )
  private static final int TRIALS = 5;

  public static void main(String[] args) {
    // In Header cho file CSV ạ
    System.out.println("N,CUTOFF,NgauNhien,DaoNguoc,GiongNhauHoanToan,ItGiaTriPhanBiet,XepMotPhan_Log,XepMotPhan_TuyenTinh,HinhOng,LechVong,ChuoiNgauNhien");
    // Quét qua các kích thước N bên trên
    for (int N : N_VALUES) {

      // Quét qua các giá trị CUTOFF
      for (int cutoff = 0; cutoff <= 30; cutoff++) {
        Merge.CUTOFF = cutoff;

        double tRandom = 0, tReverse = 0, tIdentical = 0, tFewDistinct = 0;
        double tPartialLog = 0, tPartialLin = 0, tOrganPipe = 0, tShifted = 0;
        double tString = 0;

        // Chạy để lấy trung bình cộng
        for (int t = 0; t < TRIALS; t++) {
          tRandom += timeSort(ArrayGenerator.generateRandom(N));
          tReverse += timeSort(ArrayGenerator.generateReverse(N));
          tIdentical += timeSort(ArrayGenerator.generateAllIdentical(N, 1));
          tFewDistinct += timeSort(ArrayGenerator.generateFewDistinct(N, 3));
          tPartialLog += timeSort(ArrayGenerator.generatePartiallySortedLogN(N));
          tPartialLin += timeSort(ArrayGenerator.generatePartiallySortedLinear(N));
          tOrganPipe += timeSort(ArrayGenerator.generateOrganPipe(N));
          tShifted += timeSort(ArrayGenerator.generateShifted(N));

          // Test riêng cho String
          tString += timeSort(ArrayGenerator.generateRandomStrings(N, 20));
        }

        // In một dòng kết quả ra CSV
        System.out.printf(Locale.US,"%d,%d,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f\n",
          N, cutoff,
          tRandom / TRIALS, tReverse / TRIALS, tIdentical / TRIALS, tFewDistinct / TRIALS,
          tPartialLog / TRIALS, tPartialLin / TRIALS, tOrganPipe / TRIALS, tShifted / TRIALS,
          tString / TRIALS
        );
      }
    }
  }

  // Hàm đo thời gian
  private static double timeSort(Comparable[] a) {
    long startTime = System.nanoTime();
    Merge.sort(a);
    long endTime = System.nanoTime();
    return (endTime - startTime) / 1_000_000.0;
  }
}