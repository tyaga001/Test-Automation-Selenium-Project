package rough;

public class RemoveJunkFromString {

    public static void main(String[] args) {
        String s = "@#@#%$$%&*&*71626Ankur Tyagi ";
        System.out.println(s);
        //Use regular expression: [^a-zA-Z0-9]
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s);
    }
}
