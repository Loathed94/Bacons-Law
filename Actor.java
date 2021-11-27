// This class was written in equal parts by Christian Neij and Christoffer Öhman

import java.util.LinkedList;

/**
 * The class Actor creates an object representation of the actors dealt with in the BaconsLaw class and stores the relevant data needed.
 *
 * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
 */
public class Actor {
    private final String name;
    private final LinkedList<String> movies = new LinkedList<> ();
    private Actor path = null;
    private String pathMovie;
    private short distance = Short.MAX_VALUE;
    /**
     * The constructor of the class takes the actor's name and stores it. 
     *
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public Actor(String name) {
        this.name = name;
    }
    /**
     * A get-method that returns the name of the actor as a String object.
     *
     * @return	String	The name of the actor.
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public String getName() {
        return this.name;
    }
    /**
     * This method takes a movie name as a String object and stores it in a list of movie names that the actor participated in.
     *
     * @param	movie	String object representing a movie name.
     * @return	void
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public void addMovie(String movie) {
        movies.add (movie);
    }
    /**
     * A get-method that returns a LinkedList of movie names that the actor participated in. 
     *
     * @return	LinkedList	The list of movies the actor participated in.
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public LinkedList<String> getMovies() {
        return movies;
    }
    /**
     * A set-method that takes the Actor object to the adjacent actor one step closer to Kevin Bacon on the path that leads to Kevin Bacon. 
     *
     * @param	actor	The adjacent actor. 
     * @return	void
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public void setPath(Actor actor) {
        path = actor;
    }
    /**
     * A get-method that returns the adjacent actor one step closer to Kevin Bacon on the path to Kevin Bacon.
     *
     * @return	Actor	The actor object adjacent to this object.
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public Actor getPath() {
        return this.path;
    }
    /**
     * A set-method that takes a movie name as a String object and stores it as the movie in which this actor starred in together with the adjacent actor.
     *
     * @param	movie	String object representing the name of the movie connecting this actor with the adjacent actor.
     * @return	void
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public void setPathMovie(String movie) {
        this.pathMovie = movie;
    }
    /**
     * A get-method that returns the name of the movie that this actor starred in together with the adjacent actor.
     *
     * @return	String	The name of the movie.
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public String getPathMovie() {
        return this.pathMovie;
    }
    /**
     * A set-method that takes in a short representing the distance between Kevin Bacon and this actor and stores it. 
     *
     * @param	cost	A short representing the distance to Kevin Bacon.
     * @return	void
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public void setDistance(short cost) {
        this.distance = cost;
    }
    /**
     * A get-method that returns the distance from this actor to Kevin Bacon.
     *
     * @return	short	The distance in steps from this actor to Kevin Bacon.
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    public short getDistance() {
        return this.distance;
    }
    /**
     * Default hashCode is overwritten and instead uses the default hashCode assigned to the String object representing the actor's name.
     *
     * @return	int		The hashCode.
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    @Override
    public int hashCode() {
        return this.name.hashCode ();
    }
    /**
     * Default equals-method is overwritten. Two Actor-objects are considered equal if they are both instanceof Actor and if a comparison of actor names shows that they are equal.
     *
     * @return	boolean		The boolean result of the equals-control. 
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Actor)) {
            return false;
        }
        return this.name.equals (((Actor) other).getName ());
    }
    /**
     * Default toString overwritten, the name of the actor is returned. 
     *
     * @return	String	The name of the actor.
     * @author 	Christian Neij and Christoffer Öhman (or Oehman in the english alphabet)
     */
    @Override
    public String toString() {
        return this.name;
    }
}
