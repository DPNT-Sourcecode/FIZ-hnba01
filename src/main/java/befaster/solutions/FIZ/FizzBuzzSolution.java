package befaster.solutions.FIZ;

import static java.lang.Integer.valueOf;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FizzBuzzSolution {

    public String fizzBuzz(Integer number) {
        final Optional<String> deluxWord = getDelux(number);
        if (isFizz(number) && isBuzz(number) && deluxWord.isPresent()) {
            return "fizz buzz " + deluxWord.get();
        } else if (isFizz(number) && isBuzz(number)) {
            return "fizz buzz";
        } else if (isFizz(number)) {
            return deluxWord.map(s -> "fizz " + s).orElse("fizz");
        } else if (isBuzz(number)) {
            return deluxWord.map(s -> "buzz " + s).orElse("buzz");
        } else return deluxWord.orElseGet(number::toString);

    }

    private boolean isFizz(Integer number) {
        return containsOrIsMultipleOf(number, valueOf(3));

    }

    private boolean isBuzz(Integer number) {
        return containsOrIsMultipleOf(number, valueOf(5));
    }

    private boolean containsOrIsMultipleOf(Integer number, Integer expectedNumber) {
        return number % expectedNumber == 0 || number.toString().contains(expectedNumber.toString());
    }

    private Optional<String> getDelux(Integer number) {

        // no need to process stream if number is less than 10
        if (number < 10) {
            return Optional.empty();
        }

        final Map<String, List<String>> collect = Arrays.stream(number.toString().split("")).collect(Collectors.groupingBy(e -> e));
        if (collect.entrySet().size() == 1 && number % 2 == 0) {
            return Optional.of("deluxe");
        } else if (collect.entrySet().size() == 1) {
            return Optional.of("fake deluxe");
        } else {
            return Optional.empty();
        }
    }
}
