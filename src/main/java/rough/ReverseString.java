package rough;

public class ReverseString {

    public static void main(String[] args) {
        String s = "Automation";
     /*   //1. General coding way to reverse the string
        System.out.println(s);
        int len = s.length();
        String rev = "";
        for(int i = len-1; i >= 0; i--){
           rev =  rev + s.charAt(i);//noitamotuA
            System.out.println(rev);
        }
        System.out.println(rev);*/

        //2. Using String Buffer Class

        StringBuffer sf = new StringBuffer(s);
        System.out.println(sf.reverse());

    }
}
