package lotto.validate;

import lotto.domain.LottoNumber;

import java.util.List;

public class NumberValidation {

    public static void checkNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
        }
    }

    public static void checkLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }
}
