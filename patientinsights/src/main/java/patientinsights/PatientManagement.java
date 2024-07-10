package patientinsights;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class PatientManagement
{
    
    public static void main( String[] args ) throws FileNotFoundException
    {
         HashMap<Integer, Patients> newPatients = new HashMap<>();
         String [] arrOfString = new String[6];
         File myObj = new File("/Users/mridinikulkarni/PatientData/PatientData.txt");
         
         Scanner input = new Scanner(System.in);
         System.out.println("What would you like to access? 1: One Patient, 2: All Patients, 3: Update User, 4: Delete a User");
         int x = input.nextInt();

        if(x==1){
            try{
            Scanner num = new Scanner(System.in);
            System.out.println("Please input your security number, so that information can be retrieved");
            String y = num.nextLine();
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                arrOfString = data.split(",", 6);
                if (arrOfString[0].equals(y)){
                    System.out.println(data);
                }
            }
            myReader.close();
            } catch(FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else if (x == 2){
            try {
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                arrOfString = data.split(",", 6); 
                System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else if (x==3){
            Scanner num = new Scanner(System.in);
            System.out.println("Please input your security number, so that information can be retrieved");
            String y = num.nextLine();
            List<String> content = new ArrayList<>();
            Scanner myReader = new Scanner(myObj);
            boolean found = false;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                arrOfString = data.split(",", 6);
                if (arrOfString[0].equals(y)) {
                    found = true;
                    Scanner type = new Scanner(System.in);
                    System.out.println("Please choose what you would like to change, 1: First Name, 2: Last Name, 3: DOB, 4: Email, 5: Phone #");
                    int z = type.nextInt();
                    type.nextLine(); 
                    System.out.println("What would you like to change it to?");
                    String l = type.nextLine();

                    if (z == 1) {
                        arrOfString[1] = " " +l;
                    } else if (z == 2) {
                        arrOfString[2] = " " +l;
                    } else if (z == 3) {
                        arrOfString[3] = " " +l;
                    } else if (z == 4) {
                        arrOfString[4] = " " +l;
                    } else if (z == 5) {
                        arrOfString[5] = " " +l;
                    } else {
                        System.out.println("Please try again");
                        break;
                    }
                    data = String.join(",", arrOfString);
                }
                content.add(data);
            }
            myReader.close();
            if (found) {
                try (PrintWriter finder = new PrintWriter(myObj)) {
                    for (String line : content) {
                        finder.println(line);
                    }
                }
                System.out.println("Worked!");
            } else {
                System.out.println("Not found.");
            }

        }
        else if (x==4){
            try{
            Scanner recieve = new Scanner(System.in);
            System.out.println("Which patient would you like to delete? (Enter security number)");
            String value = recieve.nextLine();
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                arrOfString = data.split(",", 6);
                if (arrOfString[0].equals(value)){
                    //Add code to delete user
                }
            }
            myReader.close();
            } catch(FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }

        newPatients.put(1, new Patients(arrOfString[0], arrOfString[1], arrOfString[2], arrOfString[3], arrOfString[4], arrOfString[5]));
    }

}
