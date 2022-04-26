/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

/**
 *
 * @author Josh
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
       //Array for Cars storage
       ArrayList<Car>cars=new ArrayList<Car>();
       //
       Car[] carsArray = new Car[20];
       //Get menu1
       
       int opt=getMenu();
       //If menu not exit
       while(opt!=7) {
           //Add a new car
           if(opt==1) {
               getCar(cars);
           }
           //Change a car feature
           else if(opt==2) {
               getChange(cars);
           }
           //Display a car details
           //Prompt for vin match with cars in array then display
           else if(opt==3) {
               Boolean check=false;
               Scanner sc=new Scanner(System.in);
               System.out.println("\nEnter car vin to change: ");
               String vin=sc.nextLine();
               for(int i=0;i<cars.size();i++) {
                   if(cars.get(i).getVin().equals(vin)) {
                       System.out.println(cars.get(i));
                       check=true;
                       break;
                   }
               }
               if(!check) {
                   System.out.println("Not found!!!");
               }
           }
           //Display all cars in the shop
           else if(opt==4) {
               System.out.println("\nCar details:");
               for(int i=0;i<cars.size();i++) {
                   System.out.println(cars.get(i));
               }
           }
           //Display average of cars shop
           else if(opt==5) {
               double mileage=0;
               System.out.println("\nCar details:");
               for(int i=0;i<cars.size();i++) {
                   mileage+=cars.get(i).getMileage();
               }
               System.out.println("Average Mileage = "+String.format("%.2f",(mileage/cars.size())));
           }
           //Display all cars in lowest price
           else if(opt==6) {
               System.out.println();
               float lowest=getLowest(cars);
               for(int i=0;i<cars.size();i++) {
                   if(lowest==cars.get(i).getPrice()) {
                       System.out.println((cars.get(i)));
                   }
               }
           }
           opt=getMenu();
       }
       //End
       System.out.println("\nExiting application....");
   }
  
   /*
   * Display user menu///////////////////////
   * Check error entry in option and return correct option
   */
   public static int getMenu() {
       Scanner sc=new Scanner(System.in);
       System.out.println("User Options: ");
       System.out.println("1. Add a new car\n2. Change existing car feauture\n3. Display a car\n"
               + "4. Display data of all cars\n5. Display average mileage of all cras\n6. Display cars using lowest price\n7. Exit");
       System.out.print("Enter option: ");
       int opt=sc.nextInt();
       while(opt<1 || opt>7) {
           System.out.println("Error!!!Enter correct option 1-7");
           System.out.print("Enter option: ");
           opt=sc.nextInt();
       }
       return opt;
   }
  
   /*
   * Method to add a new car into shop
   * Display message
   * Error check in user input
   */
   public static void getCar(ArrayList<Car>cars) {
       Scanner sc=new Scanner(System.in);
       System.out.println("\nEnter Vin: ");
       String vin=sc.nextLine();
       while(vin.equals("") || vin.length()!=17){
           System.out.println("Error!!Worng vin format.Please re-enter");
           System.out.println("Enter Vin: ");
           vin=sc.nextLine();
       }
       System.out.println("Enter make: ");
       String make=sc.nextLine();
               
       while(make.equals("") ){
           System.out.println("Error!!Worng make");
           System.out.println("Enter make: ");
           make=sc.nextLine();
       }
       System.out.println("Enter model: ");
       String model=sc.nextLine();
       while(model.equals("") ){
           System.out.println("Error!!Worng model");
           System.out.println("Enter model: ");
           model=sc.nextLine();
       }
       System.out.println("Enter year: ");
       int year=sc.nextInt();
       while(year<=1970){
           System.out.println("Error!!Year must be greater than 1970");
           System.out.println("Enter year: ");
           year=sc.nextInt();
       }
       System.out.println("Enter mileage: ");
       int mileage=sc.nextInt();
       while(mileage<=0){
           System.out.println("Error!!Mileage must be positive");
           System.out.println("Enter mileage: ");
           mileage=sc.nextInt();
       }
       System.out.println("Enter price: ");
       float price=sc.nextFloat();
       while(price<=1000){
           System.out.println("Error!!Price should be greater than 1000");
           System.out.println("Enter price: ");
           price=sc.nextFloat();
       }
       Car car=new Car(vin,make,model,year,mileage,price);
       //Check already present in shop
       for(int i=0;i<cars.size();i++) {
           if(cars.get(i).equals(car)) {
               System.out.println("Car already present in the shop!!!");
               return;
           }
       }
       //Otherwise add
       cars.add(car);
       System.out.println("New Car successfully Added!!!");
   }
  
   /*
   * Method to change a car feature
   * Prompt for vin
   * Check if it is present in array
   * If then only ask for change property
   */
   public static void getChange(ArrayList<Car>cars) {
       Scanner sc=new Scanner(System.in);
       System.out.println("\nEnter car vin to change: ");
       String vin=sc.nextLine();
       for(int i=0;i<cars.size();i++) {
           if(cars.get(i).getVin().equals(vin)) {
               while(true) {
                   System.out.println("\nWhich feaature you want to change, Options: ");
                   System.out.println("1. change make\n2. Change model\n3. Change year\n4. Change mileage\n5. Change price\n6. Exit");
                   System.out.print("Enter choice: ");
                   int opt=sc.nextInt();
                   while(opt<1 || opt>6) {
                       System.out.println("Error!!!Option should be 1-6");
                       System.out.print("Enter choice: ");
                       opt=sc.nextInt();
                   }
                   sc.nextLine();
                   if(opt==1) {
                       System.out.print("Enter make: ");
                       String make=sc.nextLine();
                       while(make.equals("") ){
                           System.out.println("Error!!Worng make");
                           System.out.println("Enter make: ");
                           make=sc.nextLine();
                       }
                       cars.get(i).setMake(make);
                   }
                   else if(opt==2) {
                       System.out.print("Enter model: ");
                       String model=sc.nextLine();
                       while(model.equals("") ){
                           System.out.println("Error!!Worng model");
                           System.out.println("Enter make: ");
                           model=sc.nextLine();
                       }
                       cars.get(i).setMake(model);
                   }
                   else if(opt==3) {
                       System.out.println("Enter year: ");
                       int year=sc.nextInt();
                       while(year<=1970){
                           System.out.println("Error!!Year must be greater than 1970");
                           System.out.println("Enter year: ");
                           year=sc.nextInt();
                       }
                       cars.get(i).setYear(year);
                   }
                   else if(opt==4) {
                       System.out.println("Enter mileage: ");
                       int mileage=sc.nextInt();
                       while(mileage<=0){
                           System.out.println("Error!!Mileage must be positive");
                           System.out.println("Enter mileage: ");
                           mileage=sc.nextInt();
                       }
                       cars.get(i).setMileage(mileage);
                   }
                   else if(opt==5) {
                       System.out.println("Enter price: ");
                       float price=sc.nextFloat();
                       while(price<=1000){
                           System.out.println("Error!!Price should be greater tahn 1000");
                           System.out.println("Enter price: ");
                           price=sc.nextFloat();
                       }
                       cars.get(i).setPrice(price);
                   }
                   else if(opt==6) {
                       break;
                   }
               }
              
               return;
           }
       }
       System.out.println("That car not present inb Shop!!!");
   }
  
   
   public static float getLowest(ArrayList<Car>cars) {
       float lowest=0;
       for(int i=0;i<cars.size();i++) {
           if(lowest<cars.get(i).getPrice()) {
               lowest=cars.get(i).getPrice();
           }
       }
       return lowest;
   }
    
}
