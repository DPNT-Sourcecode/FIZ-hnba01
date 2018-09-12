package befaster.solutions.FIZ;

import static java.lang.Integer.valueOf;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FizzBuzzSolution {

    public String fizzBuzz(Integer number) {
        if (isFizz(number) && isBuzz(number) && isDeluxe(number)) {
            return "fizz buzz deluxe";
        } else if (isFizz(number) && isBuzz(number)) {
            return "fizz buzz";
        } else if (isFizz(number)) {
            return (isDeluxe(number)) ? "fizz deluxe" : "fizz";
        } else if (isBuzz(number)) {
            return (isDeluxe(number)) ? "buzz deluxe" : "buzz";
        } else if (isDeluxe(number)) {
            return "deluxe";
        } else {
            return number.toString();
        }

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

    private boolean isDeluxe(Integer number) {

        // no need to process stream if number is less than 10
        if (number < 10) {
            return false;
        }

        final Map<String, List<String>> collect = Arrays.stream(number.toString().split("")).collect(Collectors.groupingBy(e -> e));
        return collect.entrySet().size() == 1;
    }
}
