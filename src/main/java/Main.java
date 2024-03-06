import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        runMenu();
    }
    public static void runMenu() throws IOException {
//        System.out.print("do you want actors or movies?\n->");
//        Scanner in = new Scanner(System.in);
//        if (in.next().charAt(0) == 'm') {
//            System.out.println("please enter movies name");
//            String mov = in.next(), dis = "";
//            Movie movie = new Movie(new ArrayList<>(), "", 0);
//            dis = movie.getMovieData(mov);
//            int cnt = 0;
//            while (dis.equals("please check movies name :(")) {
//                System.out.println(dis);
//                mov = in.next();
//                dis = movie.getMovieData(mov);
//                cnt++;
//                if (cnt > 5) {
//                    System.out.println("baba havaseto jam kon");
//                }
//            }
//            System.out.print(movie.getRatingViaApi(dis));
//        }
//        else {
//            String name = in.next();
//            Actors actor = new Actors("", false);
//            if (in.hasNext())
//                name += " " + in.next();
//            String dis = actor.getActorData(name);
//            System.out.println(dis);
//        }

    }
}