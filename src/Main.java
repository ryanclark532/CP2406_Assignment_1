public class Main {
    public static void main(String[] args) {
        Road road=new Road(30,1,1,"horizontal");
        int spaceleft=road.length;
        Car car=new Car("Car",60,1,1);
        while (spaceleft>=0){
            car.updatePositon(road,car.currentSpeed);
            System.out.println(car.x+" "+car.y);
            if(spaceleft<10){
                car.currentSpeed-=6;
            }
            System.out.println(car.currentSpeed+" "+spaceleft);
            spaceleft-=1;
        }


    }
}