package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum RankLotto {

    FIRST(6, 2_000_000_000, (matchCount, matchBonus) -> matchCount == 6),
    SECOND(5, 30_000_000, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    THIRD(5, 1_500_000, (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    FOURTH(4, 50_000, (matchCount, matchBonus) -> matchCount == 4),
    FIFTH(3, 5_000, (matchCount, matchBonus) -> matchCount == 3),
    MISS(0, 0, (matchCount, matchBonus) -> matchCount <= 2);

    private final int matchCount;
    private final int winningMoney;
    private final BiFunction<Integer, Boolean, Boolean> condition;

    RankLotto(int matchCount, int winningMoney, BiFunction<Integer, Boolean, Boolean> condition) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.condition = condition;
    }

    public static RankLotto findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(RankLotto.values())
                .filter(rank -> rank.condition.apply(matchCount, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    int matchCount() {
        return matchCount;
    }

    int winningMoney() {
        return winningMoney;
    }

    int calculateWinningMoney(int count) {
        return winningMoney * count;
    }

    @Override
    public String toString() {
        if (this != SECOND) {
            return String.format("%d개 일치 (%d원)", matchCount, winningMoney);
        }
        return String.format("%d개 일치, 보너스 볼 일치 (%d원)", matchCount, winningMoney);
    }
}
