package Backend;


public class Variable {

    private String name;
    private double value;

    public Variable(String name, double value){
        this(value);
        this.name = name.toLowerCase();

    }

    public Variable(double value){
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
