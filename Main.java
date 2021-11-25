import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Main {

    public static List<Object> personalFit= new ArrayList<>();

    public static SpinningBike readFromStringSpinning(String s)
    {
        String[] data= s.split("; ");
        String[] name= data[0].split(" ");
        List<String> muscle= new ArrayList<>();
        int i=2;
        while(!data[i].equals("TRUE")&&!data[i].equals("FALSE"))
        {
            muscle.add(data[i]);
            i++;
        }
        boolean display;
        display= data[i].equals("TRUE");

        return new SpinningBike(name[1], data[1], muscle, display, data[i+1],data[i+2],data[i+3]);
    }

    public static HomeTrainerBike readFromStringHome(String s)
    {
        String[] data= s.split("; ");
        String[] name= data[0].split(" ");
        List<String> muscle= new ArrayList<>();
        int i=2;
        while(!data[i].equals("TRUE")&&!data[i].equals("FALSE"))
        {
            muscle.add(data[i]);
            i++;
        }
        boolean display;
        display= data[i].equals("TRUE");

        return new HomeTrainerBike(name[1], data[1], muscle, display,data[i+1]);
    }

    public static ProteinShake readFromStringShake(String s)
    {
        String[] data= s.split("; ");
        String[] name= data[0].split(" ");


        return new ProteinShake(name[1], data[1], data[2], data[3]);
    }

    public static void Read(String fileName) throws FileNotFoundException {
        Scanner scanner= new Scanner(new File(fileName));
        String line;
        line=scanner.nextLine();

        while(scanner.hasNextLine())
        {
            Scanner lineScanner= new Scanner(line);
            lineScanner.useDelimiter(" ");

            String product=lineScanner.next();
            switch(product)
            {
                case "HomeTrainerBike":
                    personalFit.add(readFromStringHome(line));
                    break;
                case "SpinningBike":
                    personalFit.add(readFromStringSpinning(line));
                    break;
                case "ProteinShake":
                    personalFit.add(readFromStringShake(line));
            }
            line=scanner.nextLine();
        }
    }

    public static void printAll()
    {
        for (Object o: personalFit)
        {
            System.out.println(o.toString());
        }
    }

    public static void writeAll(String fileName) throws IOException {
        File myFile= new File(fileName);
        myFile.createNewFile();
        FileWriter writer= new FileWriter(fileName);
        for (Object o: personalFit)
        {
            writer.write(o.toString()+"\n");
        }
        writer.close();
    }

    public static void filterMuscle(String match)
    {
        List<HomeTrainerBike> result= new ArrayList<>();

        for(Object o: personalFit) {
            if (o instanceof HomeTrainerBike) {
                HomeTrainerBike helper = (HomeTrainerBike) o;
                result.add(helper);
            }
        }

        List<HomeTrainerBike> xd= result.stream().filter(bike-> bike.getMuscleGroups().stream().anyMatch(s->s.contains(match))).collect(toList());
        for(HomeTrainerBike bike: xd)
        {
            System.out.println(bike);
        }
    }



    public static void textInterface() throws IOException {
        boolean enabled= true;
        Scanner scanner= new Scanner(System.in);
        while(enabled)
        {
            System.out.println("Please make your choice:\n" +
                    "1 – Print all bikes & protein shakes\n" +
                    "2 – Add a new protein shake\n" +
                    "3 – Propose a random protein shake to the customer\n" +
                    "4 – Show bikes that train a specific muscle group\n" +
                    "5 – Write to file\n" +
                    "6 – Stop the program");
            String choice= scanner.next();
            switch(choice)
            {
                case "1":
                    printAll();
                    break;
                case "2":
                    String brand= scanner.next();
                    String flavour= scanner.next();
                    String size= scanner.next();
                    String price= scanner.next();
                    personalFit.add(new ProteinShake(brand, flavour, size,price));
                    break;
                case "3":
                    MyThread proteinThread= new MyThread("1");
                    proteinThread.start();
                    break;
                case "4":
                    String match= scanner.next();
                    filterMuscle(match);
                    break;
                case "5":
                    String fileName= scanner.next();
                    writeAll(fileName);
                    break;
                case "6":
                    enabled= false;
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Read("test2.txt");
        textInterface();
    }


}
