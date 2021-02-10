package Threeuple;

public
class Threeuple<U,V,T> {
   private U first;
   private V second;
   private T third;

    public
    Threeuple (U first, V second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public
    T getThird () {
        return third;
    }

    public
    void drunk(String third) {
        switch (third){
            case "drunk":
               this.third = (T) "true";break;
            case "not":
                this.third = (T) "false";break;
        }
    }

    @Override
    public
    String toString () {
        return String.format ("%s -> %s -> %s",this.first,this.second,this.third);
    }
}
