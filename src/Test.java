import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */

        //        String[] names = {"Abe", "Data", "Regina"};
        //        String[] names2  = Arrays.copyOf(names, 5);
        //
        //        System.out.println(Arrays.toString(names2));

        Scanner studentInput = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        do {
            System.out.println(UserQuestions.askToJoin);
            if (studentInput.nextLine().toLowerCase().startsWith("y")) {

                System.out.println(UserQuestions.askFirstName);
                String firstName = studentInput.nextLine();

                System.out.println(UserQuestions.askLastName);
                String lastName = studentInput.nextLine();

                System.out.println(UserQuestions.askAge);
                int age = studentInput.nextInt();
                studentInput.nextLine();

                try {
                    Permission.checkAge(age);

                    System.out.println(UserQuestions.askGender);
                    String gender = studentInput.nextLine();

                    System.out.println(UserQuestions.askClassName);
                    String className = studentInput.nextLine();

                    Permission.checkClassName(className);

                    studentList.add(
                            className.equalsIgnoreCase("Math") ?
                                    new MathStudent(firstName, lastName, age, gender, className) :
                                    new ScienceStudent(firstName, lastName, age, gender, className));

                    System.out.println("Congratulations! You are registered for " + className + " class.");

                } catch (Exception e) {
                    //        System.out.println(e.getMessage());
                    e.printStackTrace();
                }

            }
        }
            while (studentList.size() < 3) ;

            int mathClass = 0, scienceClass = 0;

            for (Student str : studentList) {
                if (str.getClassName().equalsIgnoreCase("Math")) mathClass++;
                else scienceClass++;
                System.out.println(str);
            }

            System.out.println("Math students = " + mathClass +
                    "\nScience students = " + scienceClass);


    }
}
