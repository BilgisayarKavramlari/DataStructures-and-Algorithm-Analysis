
class Box { int value; }

public class basic{
    public static int first(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        return arr[0];
    }


    int f(int a){ // methods 
        return a * a + 5;

    }

    public static void change(Box b) {
        b.value = 50;
    }
    public static void main(String [] args){
        System.out.println("Hello CS 3345");
        int score ;
        score = 85;
        // int score = 85;
        double average = 87.5;
        boolean passed = score >= 60;
        System.out.println("score : " + score + " average : "+average + " passed :" + passed);
        score = score / 2;
        score += 5; // score = score + 5;
        score = (int)average + score;
        int result = score % 3; // modulo , remainder 
        System.out.println(" result " + result);
        if ( result == 5){
            System.out.println("it is two");
        }
        else if( result > 2){
            System.out.println("greater");
        }
        else {
            System.out.println("else");
        }
        for (int i = 0; i<10 ;i++){ // initialization, condition, iteration 
            System.out.println("i : "+ i);
        }

        int a [] = { 3,4,5,6,8};
        System.out.println("a[3] : " + a[3]);

        int [] b = new int[10]; // memory allocation
        b[2] = 5;
        System.out.println("b[2] : " + b[2]);

        
        basic xyz = new basic();
        System.out.println(" value of f : "+ xyz.f(3));

        String s = "CS3345 Algorithms Data Structure"; // array of chars + end of string char /0
        System.out.println(" output "+ s);

        // int, float, double, char <<<<< primitive data types 
        // Integer , Floaf , Double 
        // Class 

        Integer x = new Integer(5);
        // int x = 5;
        System.out.println(x);
        System.out.println(x.max(14,15));
        // score.max(14,15);

        System.out.println(s.indexOf("Algo"));
        System.out.println(s.length());





        String s1 = new String("Algo");
        String s2 = new String("Algo");
        String s3 = s1;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(" == " + s1 == s2);
        System.out.println(" == " + s1 == s3);
        System.out.println(" == " + s1.equals(s2));
        System.out.println(" == " + s1.equals(s3));

        human aa = new human();
        aa.name ="John";
        //aa.weight= 150;
        aa.setWeight(150);
        aa.eat();
        System.out.println(aa.getWeight());

        human xx = new human("Joshua");
        System.out.println(xx.name);

        System.out.println(aa); //serialization -> converting into text / string


        Box box = new Box();
        box.value = 10;
        change(box);
        System.out.println(box.value);

        int[] values = {};
        try{
            System.out.println(first(values));
        }  //  catch (IllegalArgumentException e ){
        catch(Exception e){
            System.out.println("Exception catched");
        }

        int n = 10_000_000;
        long start = System.nanoTime();

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        long end = System.nanoTime();
        System.out.println("Sum = " + sum);
        System.out.println("Time = " + (end - start));


    }
}