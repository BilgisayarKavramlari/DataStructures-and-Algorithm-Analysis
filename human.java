

public class human {


    //properties
    private int weight;

    public int getWeight(){
        return this.weight;
    }
    public void setWeight(int weight){
        if(weight > 0)
            this.weight = weight;
        else
            this.weight = 0;
    }
    String name;

    //constructor
    public human(){
        name = "somebody";
        weight = 0;
    }
    public human(String name){
        this.name = name;
    }
    // methods
    public void eat(){
        weight ++;
    }

    public String toString(){
        return "Name : "+ name + " Weight : " + weight;
    }


}
