package lotto.validate;

import lotto.domain.Lotto;
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

    public static void checkBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        checkNumberRange(bonusNumber.number());
        if (lotto.matchBonus(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }
}
