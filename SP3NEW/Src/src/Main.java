import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //lokation af vores filer
        String fileName = "C:\\Users\\unito\\OneDrive\\Dokumenter\\GitHub\\SP3NEW\\Src\\ListOfMovies.txt";
        String seriesFileName = "C:\\Users\\unito\\OneDrive\\Dokumenter\\GitHub\\SP3NEW\\Src\\ListOfSeries.txt";
        String fileWatchedMovies = "C:\\Users\\unito\\OneDrive\\Dokumenter\\GitHub\\SP3NEW\\Src\\WatchedMovies.txt";

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        BufferedReader readSeries = new BufferedReader(new FileReader(seriesFileName));
        BufferedReader readerForWatchedMovies = new BufferedReader(new FileReader(fileWatchedMovies));

        FileIO fio = new FileIO();
        List<Movie> movies = fio.getMoviesFromFile(reader);
        List<Series> series = fio.getSeriesFromFile(readSeries);

        ArrayList<String> watchedMovieList = new ArrayList<>();
        BufferedWriter userWriter = new BufferedWriter(new FileWriter("C:\\Users\\unito\\OneDrive\\Dokumenter\\GitHub\\SP3NEW\\Src\\WatchedMovies.txt", true));


        while (true) {
            //System.out.println("Velkommen" + " " + user.getUserName());
            System.out.println("Hvad kunne du tænke dig?\n 1. Se en liste over alle film.\n 2. Se en liste over alle serier.\n 3. Se en liste over alle sete film."
                    + "\n 4. Se en liste over alle gemte film" + "\n 5.Søg. ");
            Scanner choice = new Scanner(System.in);


//            switch (choice.nextLine()) {
//                case "1":
//
//
//                    for (Movie m : movies) {
//                        System.out.println(m.toString());
//                    }
//
//                    System.out.println("Ønsker du at se en af de film? Ja / Nej?");
//                    switch (choice.nextLine()) {
//                        case "Ja":
//                            System.out.println("Hvilken film vil du se?");
//                            String userInput = choice.next();
//                            //TODO
//                            //HVIS USERINPUT ER ET INPUT FRA VORES LISTE MED FILM, SÅ SKAL NEDESTÅENDE KODE EXECUTES
//                            if(userInput.contains(//vores movie liste skal tjekkes igennem her)){
//                                switch (choice.nextLine()) {
//                                        String chosenMovie = userInput;
//                                        System.out.println("Du har valgt at se: " + chosenMovie);
//                                        System.out.println("Filem afspilles nu");
//
//                                        if(!watchedMovieList.contains(chosenMovie))
//                                            watchedMovieList.add(chosenMovie);
//                                        userWriter.write(chosenMovie + "\n ");
//                                        userWriter.close();
//
//                                }
//                            else{
//                                System.out.println("That movie is not available in our list, please try another one");
//                            }
//                            break;
//
//                        case "Nej":
//                            break;
//                    }
//                    break;


            switch (choice.nextLine()) {
                case "1":

                    for (Movie m : movies) {
                        System.out.println(m.toString());
                    }

                    System.out.println("Ønsker du at se en af de film? Ja / Nej?");
                    switch (choice.nextLine()) {
                        case "Ja":
                            System.out.println("Hvilken film vil du se?");
                            String chosenMovie = choice.nextLine();
                            boolean found = false;
                            for (Movie m : movies) {
                                if (m.getName().equalsIgnoreCase(chosenMovie)) {
                                    found = true;
                                }
                            }
                            if (found) {
                                System.out.println("Du har valgt at se: " + chosenMovie);
                                System.out.println("Filmen afspilles nu");
                                if (!watchedMovieList.contains(chosenMovie)) {
                                    watchedMovieList.add(chosenMovie);
                                    userWriter.write(chosenMovie + "\n ");
                                    userWriter.close();
                                }
                            }
                            if (!found) {
                                System.out.println("Filmen findes ikke.");
                            }

                        case "2":


                            for (Series s : series) {
                                System.out.println(s.toString());
                            }
                            break;

                        case "3":
                            File savedMovieFile = new File("C:\\Users\\Public\\SP3-TuransBranch-displayMethod\\Data\\SavedMovieList.txt");
                            //FileInputStream - allows us to read bytes from a file - one byte at a time
                            FileInputStream readFile = new FileInputStream(savedMovieFile);

                            int oneByte;
                            //We can write to System.out 'onebyte' at a time using its write() method.
                            //FileInputStream returns -1 when it reaches the end of the file.
                            while ((oneByte = readFile.read()) != -1) {
                                System.out.print((char) oneByte);
                            }
                            System.out.flush();
                            break;

                        case "4":

                            File watchedMoviesFile = new File("C:\\Users\\Public\\SP3-TuransBranch-displayMethod\\Data\\WatchedMovies.txt");
                            //FileInputStream - allows us to read bytes from a file - one byte at a time
                            FileInputStream readFile1 = new FileInputStream(watchedMoviesFile);

                            int oneByte1;
                            //We can write to System.out 'onebyte' at a time using its write() method.
                            //FileInputStream returns -1 when it reaches the end of the file.
                            while ((oneByte1 = readFile1.read()) != -1) {
                                System.out.print((char) oneByte1);
                            }
                            System.out.flush();
                            break;

                        case "5":
                        switch (choice.nextLine()) {
                            case "film":
                                System.out.println("Hvilken film leder du efter?");
                                String movieSearch = choice.nextLine();

                                boolean foundMovie = false;

                                for (Movie m : movies) {
                                    if (m.getName().toLowerCase().contains(movieSearch.toLowerCase())) {
                                        System.out.println(m.toString());
                                        foundMovie = true;
                                    }

                                }
                                if (!foundMovie) {
                                    System.out.println("Denne film findes ikke i vores bibliotek");
                                    break;
                                }

                            case "serie":
                                System.out.println("Hvilken serie leder du efter");
                                String seriesSearch = choice.nextLine();

                                boolean found1 = false;
                                for (Series s : series) {
                                    if (s.getName().toLowerCase().contains(seriesSearch.toLowerCase())) {
                                        System.out.println(s.toString());
                                        found = true;
                                    }
                                }
                                //TODO
                                //FOUND HER KAN IKKE BLIVE FUNDET - RET NÅR DU KOMMER HJEM !!!!!!
                                if (!found1) {
                                    System.out.println("Denne film findes ikke i vores bibliotek");
                                    break;
                                }

                        }


                    }

            }
        }
    }
}

