package com.embl.test;

import java.util.Scanner;
import java.io.*;


abstract class Car {
    protected boolean isSedan;
    protected String seats;
    
    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }
    
    public boolean getIsSedan() {
        return this.isSedan;
    }
    
    public String getSeats() {
        return this.seats;
    }
    
    abstract public String getMileage();
    
    public void printCar(String name) {
        System.out.println( 
          "A " + name + " is " + (this.getIsSedan() ? "" : "not ") 
            + "Sedan, is " + this.getSeats() + "-seater, and has a mileage of around "
            + this.getMileage() + ".");
    }
}

// Write your code here.

class WagonR extends Car {
	int mileage;
	public WagonR(int mileage) {
		super(false, "4");
		this.mileage = mileage;
		
	}

	@Override
	public String getMileage() {
		return mileage + " kmpl";
	}
	
}

class HondaCity extends Car {

	int mileage;
	
	public HondaCity(int mileage) {
		super(true, "4");
		this.mileage = mileage;
	}

	@Override
	public String getMileage() {
		return mileage + "";
	}
	
}



class InnovaCrysta extends Car {

	int mileage;
	
	public InnovaCrysta(int mileage) {
		super(false, "6");
		this.mileage = mileage;
	}

	@Override
	public String getMileage() {
		return mileage + "";
	}
	
}


public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int carType = Integer.parseInt(bufferedReader.readLine().trim());
        int carMileage = Integer.parseInt(bufferedReader.readLine().trim());
        
        if (carType == 0){
            Car wagonR = new WagonR(carMileage);
            wagonR.printCar("WagonR");
        }
        
        if(carType == 1){
            Car hondaCity = new HondaCity(carMileage);
            hondaCity.printCar("HondaCity");
        }
        
        if(carType == 2){
            Car innovaCrysta = new InnovaCrysta(carMileage);
            innovaCrysta.printCar("InnovaCrysta");
        }
    }
}

/* 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    // Complete the droppedRequests function below.
    static int droppedRequests(List<Integer> requestTime) {


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int requestTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> requestTime = new ArrayList<>();

        for (int i = 0; i < requestTimeCount; i++) {
            int requestTimeItem = Integer.parseInt(bufferedReader.readLine().trim());
            requestTime.add(requestTimeItem);
        }

        int res = droppedRequests(requestTime);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
*/