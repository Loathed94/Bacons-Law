# Bacons-Law
A graph construction that uses unweighted shortest path algorithm to find the shortest path to Kevin Bacon from any actor connecting actors via movies they've starred in. (Look up Bacon's Law for more background)

Keep in mind that with a big sample of actors this program will eat a lot of RAM. 

Our program bases its input of actors and movies thusly: 
Actor names has the prefix "<a>" followed by the name and a roman numeral in case of multiple actors having the same name.
Movies are listed after each actor, movies listed under an actor are movies that the actor participated in. When a new actor shows up in the list the movies following him/her are connected to that actor. Movies have prefix "<t>" and then the name and release-year follows. To use this code your input data must be listed the same way or the file reading in the code must be changed.
