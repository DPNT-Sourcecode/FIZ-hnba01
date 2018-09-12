package befaster.solutions.FIZ;

import static java.lang.Integer.valueOf;

import java.util.Optional;

public class FizzBuzzSolution {

    public String fizzBuzz(Integer number) {
        if (isFizz(number) && isBuzz(number)) {
            return "fizz buzz";
        } else if (isFizz(number)) {
            return getDelux(number, valueOf(3)).map(s -> "fizz " + s).orElse("fizz");
        } else if (isBuzz(number)) {
            return getDelux(number, valueOf(5)).map(s -> "buzz " + s).orElse("buzz");
        } else return number.toString();

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

    private boolean containsAndIsMultipleOf(Integer number, Integer expectedNumber) {
        return number % expectedNumber == 0 && number.toString().contains(expectedNumber.toString());
    }

    private Optional<String> getDelux(Integer number, Integer expectedNumber) {

//        // no need to process stream if number is less than 10
////        if (number < 10) {
////            return Optional.empty();
////        }
////
////        final Map<String, List<String>> collect = Arrays.stream(number.toString().split("")).collect(Collectors.groupingBy(e -> e));
////        if (collect.entrySet().size() == 1 && number % 2 == 0) {
////            return Optional.empty();
////        } else if (collect.entrySet().size() == 1) {
////            return Optional.of("fake deluxe");
////        } else {
////            return Optional.empty();
////        }

        if (number % expectedNumber == 0 && number.toString().contains(expectedNumber.toString()) && number % 2 == 0) {
            return Optional.of("deluxe");
        } else if (number % expectedNumber == 0 && number.toString().contains(expectedNumber.toString())) {
            return Optional.of("fake deluxe");
        } else {
            return Optional.empty();
        }
    }
}
