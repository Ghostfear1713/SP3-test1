import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Account extends User {


    public Account(String nameOfUser, String lastName, String userName, String password, ArrayList<User> users) {
        super(nameOfUser, lastName, userName, password, users);
    }
}



