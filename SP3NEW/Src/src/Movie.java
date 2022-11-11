import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie extends Amedia {
    //property
    private String movieName;

    //constructors
    public Movie(String name, String year, String genre, String rating) {
        super(name, year, genre, rating);
    }

    public Movie() {

    }

    //getter and setter
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }



    public static Movie MovieSavedList() throws IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Movie> savedMovieList = new ArrayList<>();
        Movie movie = new Movie("Godfather", "1972", "Crime; Drama", "9.2");
        BufferedWriter userWriter = new BufferedWriter(new FileWriter("C:\\Users\\unito\\OneDrive\\Dokumenter\\GitHub\\SP3NEW\\Src\\SavedMovieList", true));


        try {
            System.out.println("Indtast venligst den film du ønsker at gemme");
            //gemmer users input som 'saveMovie'
            String saveMovie = scan.nextLine();
            //erstatter det gamle navn af filmen til vores nye input som brugeren angiver
            movie.setMovieName(saveMovie);

            //tilføjer vores movie til vores arraylist og printer det ud
            savedMovieList.add(movie);

            //Fortæller hvad der skal skrives til vores fil
            userWriter.write(movie.getMovieName() + "\n");

            //Gemmer det i filen
            userWriter.close();
            System.out.println("Du har valgt at gemme filmen " + movie.getMovieName());
        } catch (Exception e) {
            e.printStackTrace();

        }

        return movie;
    }

        //TODO
        //PRØVE AT LAVE EN METODE PLAYMOVIE, I STEDET FOR AT LAVE HELE KODEN I MAIN
//            ArrayList<String> watchedMovieList = new ArrayList<>();
//            BufferedWriter userWriter = new BufferedWriter(new FileWriter("C:\\Users\\unito\\OneDrive\\Dokumenter\\GitHub\\SP3NEW\\Src\\WatchedMovies.txt", true));
//        Scanner choice = new Scanner(System.in);
//        public void playMovie() {
//            try {
//                System.out.println("Hvilken film vil du se?");
//                String chosenMovie = choice.nextLine();
//                System.out.println("Du har valgt at se: " + chosenMovie);
//                watchedMovieList.add(chosenMovie);
//                userWriter.write(chosenMovie);
//                userWriter.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

}






