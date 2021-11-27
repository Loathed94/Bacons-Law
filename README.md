# Bacons-Law
A graph construction that uses unweighted shortest path algorithm to find the shortest path to Kevin Bacon from any actor connecting actors via movies they've starred in. (Look up Bacon's Law for more background)

Keep in mind that with a big sample of actors this program will eat a lot of RAM. 

Our program bases its input of actors and movies thusly: 
Actor names has the prefix "<a>" followed by the name and a roman numeral in case of multiple actors having the same name.
Movies are listed after each actor, movies listed under an actor are movies that the actor participated in. When a new actor shows up in the list the movies following him/her are connected to that actor. Movies have prefix "<t>" and then the name and release-year follows. To use this code your input data must be listed the same way or the file reading in the code must be changed. Input example:
  
<a>Markey, John (II)
<t>Waydowntown (2000)
<a>Markey, Keith
<t>Beer Pong Saved My Life (2010)
<t>Last Call (2012/I)
<t>Placebo (2010)
<a>Markey, Kevin
<t>Universal Squadrons (2011)
<a>Markey, Matt (I)
<t>Biohazardous (2001)
<t>Over Cards (2010)
<t>Ricky (2010)
<t>Tracks (2005/II)
<a>Markey, Miguel
<t>Broer (2015)
<a>Markey, Mike
<t>Air (2014/III)
<a>Markey, Paul (I)
<t>Dead Meat (2004)
<a>Markey, Peter
<t>Amateur Hour (2011)
<t>Birds of a Feather (2011/II)
<t>Derivative (2014)
<t>Family Bonds (2012)
<t>Guess Who's Coming to Dinner (Doritos Spec Commercial)
<t>Ice House (2015)
<t>Together Forever (2013)
<a>Markey, Sean (I)
<t>Alizarin Woods (2011)
<t>Dublin 26.06.08: A Movie in 4 Days (2008)
<t>Invasion Ireland (2013)
<t>Life's a Breeze (2013)
<t>Portrait of a Zombie (2012)
<t>The Nixer (2011)
<t>The Tiger's Tail (2006)
<t>Véronique (2010)
