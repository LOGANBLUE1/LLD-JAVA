package creationalPatterns.factory.example2;

public abstract class AnimalOptions implements Animal{
    public String milkType;

    public String getMilkType(){
        return this.milkType;
    }
    @Override
    public void setType(String type){
        this.milkType = type;
    }
}
