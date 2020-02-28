package generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {
    private static final List<Integer> numbers;
    private static final int LOTTO_UNDER_BOUND = 1;
    private static final int LOTTO_UPPER_BOUND = 45;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 6;

    static {
        numbers = IntStream.rangeClosed(LOTTO_UNDER_BOUND, LOTTO_UPPER_BOUND)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> create() {
        Collections.shuffle(numbers);
        return numbers.subList(START_INDEX, END_INDEX);
    }
}