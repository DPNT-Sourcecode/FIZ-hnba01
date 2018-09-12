package befaster.solutions.FIZ;

import static java.lang.Integer.valueOf;

public class FizzBuzzSolution {

    public String fizzBuzz(Integer number) {
        if (isFizz(number) && isBuzz(number)) {
            return "fizz buzz";
        } else if (isFizz(number)) {
            return "fizz";
        } else if (isBuzz(number)) {
            return "buzz";
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
        number.toString().
    }
}
