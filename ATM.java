package CODSOFT;

import java.util.HashMap;
import java.util.Scanner;

class Data
{
    float balance;
}

class ATMOP
{
    Scanner sc = new Scanner(System.in);
    HashMap<Integer,Data> map = new HashMap<>();

    public ATMOP()
    {
        System.out.println("WELCOME TO OUR ATM");
        op();
    }

    public void op()
    {
        System.out.println("------------------------------------------------------");
        System.out.println(" ENTER YOUR PIN :");
        int pincode = sc.nextInt();

        if(map.containsKey(pincode))
        {
            Data obj = map.get(pincode);
            menu(obj);
        }
        else {
            System.out.println(" PLEASE CREATE ACCOUNT FIRST");
            System.out.println(" SET YOUR PIN CODE");
            int pin = sc.nextInt();
            Data obj = new Data();
            map.put(pin,obj);
            menu(obj);

        }
    }

    public void check_balance(Data obj)
    {
        System.out.println("----------------------------------------------------------");
        System.out.println(" YOUR BALANCE :" + obj.balance);
        menu(obj);
    }

    public void deposit(Data obj)
    {
        System.out.println("----------------------------------------------------------");
        System.out.println(" ENTER AMOUNT TO BE DEPOSITED :");
        float a =sc.nextFloat();
        if(a>0)
        {
            obj.balance += a;
            System.out.println("AVAILABLE BALANCE = " + obj.balance);
        }
        else
        {
            System.out.println(" ENTER VALID AMOUNT");
        }
        menu(obj);
    }

    public void withdraw(Data obj)
    {
        System.out.println("----------------------------------------------------------");
        System.out.println(" ENTER AMOUNT TO BE WITHDRAWN :");
        int b = sc.nextInt();
        if(b > obj.balance)
        {
            System.out.println("INSUFFICIENT AMOUNT ");
        }
        else
        {
            obj.balance -= b;
            System.out.println(" AVAILABLE BALANCE :" + obj.balance);
        }
        menu(obj);
    }

    public void menu(Data obj)
    {
        System.out.println("-----------------------------------------------------------");
        System.out.println(" ENTER YOUR CHOICE :");
        System.out.println(" 1 : CHECK BALANCE");
        System.out.println(" 2 : DEPOSIT MONEY");
        System.out.println(" 3 : WITHDRAW MONEY");
        System.out.println(" 4 : ANOTHER ACCOUNT");
        System.out.println(" 5 : EXIT");

        int x = sc.nextInt();

        if(x == 1)
        {
            check_balance(obj);
        }
        else if(x ==2)
        {
            deposit(obj);
        }
        else if(x==3)
        {
            withdraw(obj);
        }
        else if (x ==4)
        {
            op();
        }
        else if (x ==5)
        {
            System.out.println(" THANK YOU !");
        }
        else
        {
            System.out.println(" ENTER A VALID CHOICE :");
            menu(obj);
        }
    }
}

public class ATM {
    public static void main(String[] args)
    {
     ATMOP obj = new ATMOP();
    }
}
