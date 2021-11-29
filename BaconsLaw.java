
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * The class BaconsLaw reads a file containing many actors and movies and then asks the user for an actor name to play the game "Bacon's Law" with.
 * A shortest path graph algorithm is used to find a path to Kevin Bacon from the chosen actor and the program presents the path and its length to the user.
 *
 * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
 */
public class BaconsLaw {


    private final static String FILE_PATH = "path to the textfile containing actor names and movies";


    private static final HashMap<String, Actor> actors = new HashMap<> ();
    private static final HashMap<String, LinkedList<Actor>> castInMovies = new HashMap<> ();
    private static Actor bacon = null;

    public static void main(String[] args) {
        BaconsLaw baconsLaw = new BaconsLaw ();
        baconsLaw.run ();
    }
    /**
     * This method is the driver of the class, making sure operations are executed in sequence until the program has run its course.
     * It first calls a method to read file and another to perform shorthest path algorithm on all the actors and the prompts user to enter an actor's name to see the Bacon number and path that that actor has.
     * It continues prompting the user for actors until the user enters "exit".
     *
     * @return	void
     * @author	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    private void run() {
        final String prefix = "<a>";
        readFile (FILE_PATH);
        shortestPath (bacon, castInMovies);
        Scanner scanner = new Scanner (System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println ("Enter query or type 'exit'.");
            String query = scanner.nextLine ();
            String hashQuery = prefix + query;
            if (query.equals ("exit")) {
                exit = true;
            } else if (actors.get (hashQuery) == null) {
                System.out.println ("error: Actor not found");
            } else {
                System.out.print ("'" + query + "' is " + actors.get (hashQuery).getDistance () + " steps away from Kevin B. The path is ");
                System.out.print (getPath ("", hashQuery) + "\n");
            }
        }

        scanner.close ();
    }

    /**
     * This static method is a recursive method that for each actor in the path from user's chosen actor to Kevin Bacon calls the method sending the String created so far to it along with the adjacent actor in the path.
     * The text so far assembled is taken and whichever actor is next in the path is added to as prefix to the String received and if Bacon is reached it is then returned. 
     * If not then the movie which connects the current actor to the next is added to the front of the String and the method is called again recursively with the next actor's name and the String so far built.
     *
     * @param	previous	String object containing the path constructed recursively, empty if it's the first call to the method.
     * @param	actor		The actor in the path from the user chosen actor to Kevin Bacon currently being looked at during the recursive String building.
     * @return 	String		Returns the String object built during recursion.
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    private static String getPath(String previous, String actor) {
        Actor adjacentActor = actors.get (actor);
        String newString = adjacentActor.getName () + previous;
        if (adjacentActor.getPath () == null) {
            return newString;
        } else {
            String newerString = adjacentActor.getPathMovie () + newString;
            return getPath (newerString, adjacentActor.getPath ().getName ());
        }
    }
    /**
     * This static method takes in the file path to the file with actor and movie names as a String object and then reads the file and looks at each line and determines whether the line represents an actor or a movie and creates objects and builds the graph from the file.
     *
     * @param	filePath	Text file containing names of actors along with movies they've been in.
     * @return 	void
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    private static void readFile(String filePath) {
        BufferedReader br = null;
        Actor currentActor = null;

        try {

            String data;
            br = new BufferedReader (new FileReader (filePath));

            while ((data = br.readLine ()) != null) {
                if (data.charAt (1) == 'a') {
                    Actor newActor = new Actor (data);
                    currentActor = newActor;
                    actors.put (data, newActor);

                } else if (data.charAt (1) == 't') {
                    if (castInMovies.get (data) == null) {
                        LinkedList<Actor> newList = new LinkedList<> ();
                        newList.add (currentActor);
                        castInMovies.put (data, newList);

                        if (currentActor != null) {
                            currentActor.addMovie (data);
                        }

                    } else {
                        LinkedList<Actor> existingList = castInMovies.get (data);
                        existingList.add (currentActor);

                        if (currentActor != null) {
                            currentActor.addMovie (data);
                        }
                    }
                }
            }
            bacon = actors.get ("<a>Bacon, Kevin (I)");

        } catch (IOException e) {
            e.printStackTrace ();

        }


        if (br != null) {
            try {
                br.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }


    }


    /**
     * The static method takes in the actor the path is built from (Kevin Bacon) along with a hashmap that contains lists of actors who starred in movies together using the movies as keys.
     * The method runs an unweighted shortest path algorithm using a LinkedList queue that builds a path from Kevin Bacon to all other actors. 
     * Each actor object is given a distance value from K. Bacon and an actor object adjacent to itself on the path to K. Bacon as well as the movie which the actor and the adjacent actor starred together in.
     *
     * @param	startActor	Is the actor we build the path from, which is always Kevin Bacon unless the code is edited.
     * @param 	movieCast	Is a HashMap which uses movie names as keys and contains lists of actors who participated in the movies as its values.
     * @return 	void
     * @throws 	NullPointerException If either the startActor or the movieCast parameters are null then the exception is thrown.
     * @author 	Christian Neij & Christoffer Öhman (or Oehman in the english alphabet)
     */
    private static void shortestPath(Actor startActor, HashMap<String, LinkedList<Actor>> movieCast) {
        if (startActor == null || movieCast == null) {
            throw new NullPointerException ();
        }
        Queue<Actor> queue = new LinkedList<> ();
        startActor.setDistance ((short) 0);
        queue.add (startActor);
        while (!queue.isEmpty ()) {
            Actor current = queue.poll ();
            for (String movie : current.getMovies ()) {
                LinkedList<Actor> cast = movieCast.get (movie);
                for (Actor adjacent : cast) {
                    if (adjacent.getDistance () == Short.MAX_VALUE) {
                        adjacent.setPath (current);
                        adjacent.setDistance ((short) (current.getDistance () + 1));
                        adjacent.setPathMovie (movie);
                        queue.add (adjacent);
                    }
                }
            }
        }
    }
}

