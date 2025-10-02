import java.util.Scanner;

abstract class Transport{
    protected String marka;
    protected int release_year;
    protected double engine_capacity;
    private static int objectCount = 0;

    public Transport(){
        this.marka = "Unknown";
        this.release_year = 0;
        this.engine_capacity = 5;
        objectCount++;
    }

    public Transport(String marka, int release_year, double engine_capacity){
        this.marka = marka;
        this.release_year = release_year;
        this.engine_capacity = engine_capacity;
        objectCount++;
    }

    public String getMarka(){
        return marka;
    }
    
    public void setMarka(String newMarka){
        this.marka = newMarka;
    }

    public int getRelease_year(){
        return release_year;
    }

    public void setRelease_year(int newYear){
        this.release_year = newYear;
    }

    public double getEngine_capacity(){
        return engine_capacity;
    }

    public void setEngine_capacity(double  NewCapacity){
        this.engine_capacity = NewCapacity;
    }

    public void StartEngine(){
        System.out.println("Двигатель запущен.");
    }

    public void StopEngine(){
        System.out.println("Двигатель заглушен.");
    }

    public void Out(){
    }

    public void Info(){
        System.out.println("Марка авто: " + marka);
        System.out.println("Год выпуска авто: " + release_year);
        System.out.println("Объем двигателя авто: " + engine_capacity);
    }

    public int getObject(){
        return objectCount;
    }
}

class Car extends Transport{
    protected int number_of_seats;
    protected String body_type;

    public Car(){
        super();
        this.number_of_seats = 5;
        this.body_type = "Unknown";
    }

    public Car(String marka, int release_year, double engine_capacity, int number_of_seats, String body_type){
        super(marka, release_year, engine_capacity);
        this.number_of_seats = number_of_seats;
        this.body_type = body_type;
    }

    @Override
    public void Out(){
        System.out.println("Это легковой автомобиль.");
    }

    @Override
    public void Info(){
        super.Info();
        System.out.println("Количество посадочных мест: " + number_of_seats);
        System.out.println("Тип кузова: " + body_type);
    }

    public void setNumber_of_seats(int number){
        this.number_of_seats = number;
    }

    public int getNumber_of_seats(){
        return number_of_seats;
    }

    public void setBody_type(String type){
        this.body_type = type;
    }

    public String getBody_type(){
        return body_type;
    }

    public void Open_trunk(){
        System.out.println("Багажник открыт.");
    }

    public void Close_trunk(){
        System.out.println("Багажник закрыт.");
    }
}

class Tank extends Car{
    public Tank(){
        super();
        this.marka = "TANK";
    }
    public Tank(String marka, int release_year, double engine_capacity, int number_of_seats, String body_type){
        super(marka, release_year, engine_capacity, number_of_seats, body_type);
    }

    public void Out(){
        super.Out();
    }

    public void Info(){
        super.Info();;
    }

    public void setNumber_of_seats(int number){
        this.number_of_seats = number;
    }

    public int getNumber_of_seats(){
        return number_of_seats;
    }

    public void setBody_type(String type){
        this.body_type = type;
    }

    public String getBody_type(){
        return body_type;
    }

    public void Open_trunk(){
        System.out.println("Багажник открыт.");
    }

    public void Close_trunk(){
        System.out.println("Багажник закрыт.");
    }
}

class Truck extends Transport{
    protected int wheels_count;

    public Truck(){
        super();
        this.wheels_count = 4;
    }

    public Truck(String marka, int release_year, double engine_capacity, int wheelCount){
        super(marka, release_year, engine_capacity);
        this.wheels_count = wheelCount;
    }

    @Override
    public void Out(){
        System.out.println("Это грузовой автомобиль.");
    }

    @Override
    public void Info(){
        super.Info();
        System.out.println("Количество колес: " + wheels_count);
    }

    public int getWheels_count(){
        return wheels_count;
    }

    public void setEhwwls_count(int count){
        this.wheels_count = count;
    }

    public void Signal(){
        System.out.println("Тууууу Тууууу");
    }
}

class Bicy extends Transport{
    protected int max_speed;
    
    public Bicy(){
        super();
        this.max_speed = 100;
    }

    public Bicy(String marka, int release_year, double engine_capacity, int max_speed){
        super(marka, release_year, engine_capacity);
        this.max_speed = max_speed;
    }

    @Override
    public void Info(){
        super.Info();
        System.out.println("Максимальная скорость: " + max_speed);
    }

    @Override
    public void Out(){
        System.out.println("Это мотоцикл.");
    }

    public int getMax_speed(){
        return max_speed;
    }

    public void setMax_speed(int speed){
        this.max_speed = speed;
    }

    public void Helmet(){
        System.err.println("Шлем надет.");
    }
}

public class Indicator{
    public static void main(String[] args) {
        Tank test1 = new Tank();
        test1.Info();
        
        Scanner sc = new Scanner(System.in);
        Car MERS = new Car("Mersedes",2023, 2.0, 5, "coupe");
        MERS.Info();
        System.out.print("Введите марку грузовика: ");
        String mr = sc.nextLine();

        System.out.print("Введите год выпуска грузовика: ");
        int ye = sc.nextInt();

        System.out.print("Введите объем двигателя грузовика через ,: ");
        double en = sc.nextDouble();

        System.out.print("Введите количество колес: ");
        int nu = sc.nextInt();

        Truck user = new Truck(mr, ye, en, nu);
        user.Info();
        user.Out();
        System.out.print("введите новое количество колес: ");
        int nenu = sc.nextInt();
        user.setEhwwls_count(nenu);
        System.out.println("Количество колес: " + user.getWheels_count());
        user.Signal();
        System.out.println("Количество транспортных средств: " + user.getObject());
        Bicy pokaSz = new Bicy();
        System.out.println("Количество транспортных средств: " + user.getObject());
    }
}
