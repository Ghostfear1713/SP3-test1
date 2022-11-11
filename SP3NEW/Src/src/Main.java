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
                            for (Movie m: movies){
                                if(m.getName().equalsIgnoreCase(chosenMovie)){
                                    found = true;
                                }
                            }
                            if (found){
                                System.out.println("Du har valgt at se: " + chosenMovie);
                                System.out.println("Filmen afspilles nu");
                                if(!watchedMovieList.contains(chosenMovie)){
                                    watchedMovieList.add(chosenMovie);
                                    userWriter.write(chosenMovie + "\n ");
                                    userWriter.close();
                                }
                            }
                            if(!found){
                                System.out.println("Filmen findes ikke.");
                            }




                    }


            }

        }
    }
}


































