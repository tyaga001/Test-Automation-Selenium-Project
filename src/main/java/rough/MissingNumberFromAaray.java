package rough;

public class MissingNumberFromAaray {

    public static void main(String[] args) {

        int a[] = {2, 3, 4, 5, 6, 7, 8, 9, 10};

        //1+2+3+5= 11
        //1+2+3+4+5 = 15
        //15-11= 4

        int sum = 0;

        for (int i = 0; i < a.length; i++) {

            sum = sum + a[i];
        }
        System.out.println(sum);
        int sum1 = 0;

        for (int j = 1; j <= 10; j++) {

            sum1 = sum1 + j;

        }
        System.out.println(sum1);

        System.out.println("Missing Number is " + (sum1 - sum));

    }
}
