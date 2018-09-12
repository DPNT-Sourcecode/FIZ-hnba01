package befaster.solutions.FIZ;

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
        return number % 3 == 0 || number.toString().contains("3");
    }

    private boolean isBuzz(Integer number) {
        return number % 3 == 0 || number.toString().contains("3");
    }
}
