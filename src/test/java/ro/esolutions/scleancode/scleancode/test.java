package ro.esolutions.scleancode.scleancode;

public class test {

    public static void main(String[] args){
        Integer l = 0;
        Integer a = l;
        if (0 == l)
            a = 1;
        else
            l = 1;
        System.out.println(a + " " +l);
    }
}
