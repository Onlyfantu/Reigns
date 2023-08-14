package model;

public class King extends Character{

    private String[] nameKing = {"x", "y", "z"};
    private int yearsPower = 0;
    private int startValue = 50;

    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 100;

    public King(String nome) {
        super(nome, null, null);
    
    }

    public boolean dead(){
        if(startValue == MAX_VALUE || startValue == MIN_VALUE){
            return true;
        }
        else{
            return false;
        }

    }

    public void nextKing(){
        if(dead()){
            

        }

    }
    

    public void choose(){

    }
    
}
