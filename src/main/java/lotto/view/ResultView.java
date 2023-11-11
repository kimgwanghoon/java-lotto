package lotto.view;

public class ResultView {

    public static void print(String result) {
        System.out.println(result);
    }

    public static void resultPrint(double rateOfReturn) {
        print(String.format("총 수익률은 %.2f 입니다.", rateOfReturn));
    }
}
