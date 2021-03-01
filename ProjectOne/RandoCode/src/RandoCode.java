public class RandoCode {


    public static void main(String [] args) {
        /*
        int row;
        int col;

        for(row = 2; row <= 3; row++){
            for (col = 0; col <= 1; col++){
                System.out.println(row + "" + col);
            }
        }
        */
        char l1;
        char l2;

        l1 = 'y';
        while(l1 <= 'z'){
            l2 = 'a';
            while(l2 <= 'c'){
                System.out.println(l1 + "" + l2);
                l2++;
            }//Inner while.
            l1++;
        }//While.

    }//Main
}//Class
