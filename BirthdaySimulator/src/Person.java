import java.util.Random;
import java.util.ArrayList;


public class Person {

    private int day;
    private double count = 0;

    //Removed global ArrayList<Integer> birthdays variable since the local variable is all that is used

    public double birthdayCheck(double runs, int classSize) {
        for (int i = 0; i < runs; i++) {

            //Method call to variable creates a new list of birthdays everytime the loop starts again
            ArrayList<Integer> birthdays = generateBirthdays(classSize);

            for (int k = 0; k < birthdays.size() - 1; k++) {
                for (int l = k + 1; l < birthdays.size(); l++) {
                    if (birthdays.get(k).equals(birthdays.get(l))) {
                        count++;
                        k = birthdays.size();
                        break;
                    }
                }
            }
        }
        return (double) count / runs;
    }

    /**
     * The generateBirthdays method creates a random list of birthdays.
     * @param classSize The amount of students in the class
     * @return An ArrayList of Integers of all the randomly created birthdays.
     */
    public ArrayList<Integer> generateBirthdays(int classSize) {

        //Initialized the ArrayList that will hold the list of random birthdays
        ArrayList<Integer> birthdays = new ArrayList<>();

        //Create a random object to use the randomInt() method
        Random rand = new Random();

        //Add the same amount of birthdays to the list as students in the class
        for (int j = 0; j < classSize; j++) {

            //Initializes the variable that holds the random integer between 1 and 365
            day = rand.nextInt(1, 366);

            //Adds the birthday to the ArrayList
            birthdays.add(day);
        }

        //Returns the ArrayList of random birthdays
        return birthdays;
    }
}
