public
class Main {
    public static
    void main (String[] args) {

        Car car = new Car ();

        car.setBrand ("Chevrolet");
        car.setModel ("Impala");
        car.setHorsepower (390);

        car.increaseHP (7);

        System.out.printf ("The car is: %s %s - %d HP%n",car.getBrand (),car.getModel () ,car.getHorsepower ());
    }
}
