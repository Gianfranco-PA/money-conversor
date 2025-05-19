package org.gianfranco.view;

import java.util.Scanner;
import java.util.function.Predicate;

public class Request {

    private static final Scanner scanner = new Scanner(System.in);

    public static String stringResponse(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static double doubleResponse(String message, String error, Predicate<String> predicate){
        double response;
        while(true){
            System.out.println(message);
            try {
                String input = scanner.nextLine();
                if(predicate.test(input)) {
                    response = Double.parseDouble(input);
                    break;
                }
                else System.out.println(error);
            } catch (Exception e) {
                System.out.println(error);
            }
        }
        return response;
    }

    public static int intResponse(String message, String error, Predicate<String> predicate){
        int response;
        while(true){
            System.out.println(message);
            try {
                String input = scanner.nextLine();
                if(predicate.test(input)) {
                    response = Integer.parseInt(input);
                    break;
                }
                else System.out.println(error);
            }catch (Exception e){
                System.out.println(error);
            }
        }
        return response;
    }
}
