import mymatome.*;

public class test {
    public static void main(String args[]) {
        int a[] = { 10, 25, 18, 2 };
        Sort.sortA(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}