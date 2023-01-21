import java.util.List;

public class FP01SFunctional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,4,13,6,446,44);

        System.out.println("All Numbers: ");
        printAllNumbersInListFunctional(numbers);
        System.out.println("Even Numbers: ");
        printEvenNumbersInListFunctional(numbers);
        System.out.println("Square of Numbers: ");
        printSquareNumbersInListFunctional(numbers);
    }

//    public static void print(int number){
//        System.out.println(number);
//    }

//    public static boolean isEvent(int number) {
//        return number%2 == 0;
//    }


    private static void printAllNumbersInListFunctional(List<Integer> numbers) {

//        numbers.stream().forEach(FP01SFunctional::print);
        numbers.stream().forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {

//        numbers
//                .stream()
//                .filter(FP01SFunctional::isEven)
//                .forEach(System.out::println);

        numbers
                .stream()
                .filter(number -> number %2 ==0 )
                .forEach(System.out::println);
    }

    private static void printSquareNumbersInListFunctional(List<Integer> numbers) {

        numbers
                .stream()
                .map(number -> number * number )
                .forEach(System.out::println);
    }
}
