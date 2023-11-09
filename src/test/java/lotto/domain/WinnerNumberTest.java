package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerNumberTest {

    private WinnerNumber winnerNumber;

    void setup(String lottoNumbers) {
        this.winnerNumber = new WinnerNumber(lottoNumbers);
    }

    @Test
    void 당첨_번호_생성() {
        // given
        String lottoNumbers = "1,2,3,4,5,6";
        // when
        setup(lottoNumbers);
        Lotto result = winnerNumber.resultLotto();
        // then
        assertThat(result.lottoNumbers()).hasSize(6);
    }

    @DisplayName("당첨 번호 생성 실패")
    @Nested
    class 생성_실패 {

        @Test
        void 당첨_번호_이탈_생성_실패() {
            // given
            String lottoNumbers = "1,2,3,46,5,6";
            // when
            // then
            assertThatThrownBy(() -> {
                setup(lottoNumbers);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 당첨_번호_7개_입력_생성_실패() {
            // given
            String lottoNumbers = "1,2,3,7,5,6,7";
            // when
            // then
            assertThatThrownBy(() -> {
                setup(lottoNumbers);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 당첨_번호_4개_입력_생성_실패() {
            // given
            String lottoNumbers = "1,2,3,4,5";
            // when
            // then
            assertThatThrownBy(() -> {
                setup(lottoNumbers);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 당첨_번호_입력_오류() {
            // given
            String lottoNumbers = "1,2,q,4,5";
            // when
            // then
            assertThatThrownBy(() -> {
                setup(lottoNumbers);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
