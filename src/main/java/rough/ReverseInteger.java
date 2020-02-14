package rough;

public class ReverseInteger {

    public static void main(String[] args) {

        // 1. using algo
        long num = 69988888;
        long rev = 0;

        while (num != 0) {

            rev = rev * 10 + num % 10;
            num = num / 10;

        }
        System.out.println("Reverse Integer Number is :" + rev);

        //2. using StringBuffer method
        int num1 = 7868;
        System.out.println(new StringBuffer(String.valueOf(num1)).reverse());

    }

}
