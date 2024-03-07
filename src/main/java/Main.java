import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        runMenu();
    }
    public static void runMenu() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter \"movie\" or \"sctor\"");
        String save = in.next(), name = "";
        if (save.charAt(0) == 'm' || save.charAt(0) == 'M') {
            name = in.next();
            Movie movie = new Movie(new ArrayList<>(),"",0);
            String dis = movie.getMovieData(name);
            while (dis.equals("please check movies name :(")) {
                System.out.println(dis);
                name = in.next();
                dis = movie.getMovieData(name);
            }
            int movieImdbVotes = movie.getImdbVotesViaApi(dis);
            String movieRating = movie.getRatingViaApi(dis);
            movie.getActorListViaApi(dis);
            ArrayList<String> actors = movie.actorsList;
            System.out.println("imdb Rating : " + movieRating + " with " + movieImdbVotes + " vote");
            System.out.println("cast: ");
            for (int i = 0; i < actors.size(); i++) {
                System.out.print(actors.get(i) + " ");
            }
        }
        else {
            name = in.next();
            Actors actor = new Actors("", false);
            String dis = actor.getActorData(name);
            System.out.print("do you mean " + actor.getName(dis) + "? ");
            String yn;
            yn = in.next();
            while (yn.equals("no")) {
                System.out.print("Enter new name ");
                name = in.next();
                dis = actor.getActorData(name);
                System.out.print("do you mean " + actor.getName(dis) + "? ");
                yn = in.next();
            }
//            System.out.println(dis);
            double nw = actor.getNetWorthViaApi(dis);
            System.out.println("NetWorth of actor is " + (int)nw);
            Boolean isAlive = actor.isAlive(dis);
            String marg = actor.getDateOfDeathViaApi(dis);
            if (isAlive) {
                System.out.println("Actor is Alive");
            }
            else {
                System.out.println("Actor is dead at " + marg);
            }
        }
    }
}
