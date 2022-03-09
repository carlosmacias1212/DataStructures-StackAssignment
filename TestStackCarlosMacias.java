// Class:		Data Structures 02
// Term:		Spring-2022
// Name:		Carlos Macias
// Program Number:	Assignment 3
// IDE: 		IntelliJ JDK 15.0.1

import java.util.Scanner;

public class TestStackCarlosMacias {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        MyStackCarlosMacias<String> stack = new MyStackCarlosMacias<>();

        int choice = -1;

        while (choice != 0) {
            System.out.println("-----MAIN MENU-----\n" +
                    "0 - Exit Program\n" +
                    "1 – Push\n" +
                    "2 - Pop\n" +
                    "3 – Peek (Top)\n" +
                    "4 - Size\n" +
                    "5 – Is Empty?\n" +
                    "6 – Print Stack\n" +
                    "Choose menu: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    // add user input to stack

                    System.out.println("String to push: ");
                    String addString = input.nextLine();
                    stack.push(addString);
                    break;
                case 2:
                    // remove most recently added element

                    String removed = stack.pop();
                    System.out.println("Removed: " + removed);
                    break;
                case 3:
                    // return most recently added element without removing

                    System.out.println("Top of stack: " + stack.peek());
                    break;
                case 4:
                    // return number of elements in stack/linked list

                    System.out.println("Size of stack: " + stack.size());
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Stack is NOT empty");
                    }
                    break;
                case 6:
                    // show all elements in stack/linked list

                    System.out.println(stack.toString());
                    break;

            }

        }
    }
}
