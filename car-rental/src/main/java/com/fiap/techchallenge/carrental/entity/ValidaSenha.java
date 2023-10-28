package com.fiap.techchallenge.carrental.entity;

public class ValidaSenha {

    public static boolean isValidPassword(String password) {
        boolean isValid = true;
        if (password.length() > 15 || password.length() < 8) {
            System.out.println("A senha deve conter mais de 8 e menos de 15 caracteres.");
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            System.out.println("A senha deve conter pelo menos 1 caractere maiúsculo.");
            isValid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            System.out.println("A senha deve conter pelo menos 1 caractere minúsculo.");
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            System.out.println("A senha deve conter pelo menos 1 número.");
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars)) {
            System.out.println("A senha deve conter pelo menos 1 caractere especial @#$%");
            isValid = false;
        }
        return isValid;
    }
}
