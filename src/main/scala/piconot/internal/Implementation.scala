package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import scala.collection.mutable.ListBuffer
import picolib.display.TextDisplay
import java.io.File

// Class structure, the rules being a ListBuffer, and my GO function is all lovingly ripped off from the sample solution!

class Implementation extends App {

    // Default-initialize the maze with an empty one
    private var mazeName = Maze("resources" + File.separator + "empty.txt")
    private val rules = ListBuffer.empty[Rule]

    // Make a more usable alias for the StayHere keyword
    val Wait = StayHere

    // Combine the STATE and IF results to get the rule, add it to the class ListBuffer
    def RULE(state : List[Int])(params : (List[picolib.semantics.RelativeDescription], picolib.semantics.MoveDirection)) = 
        val startState = State(state(0).toString)
        val endState = State(state(1).toString)
        val surroundings = Surroundings(params(0)(0), params(0)(1), params(0)(2), params(0)(3))
        val rule = Rule(startState, surroundings, params(1), endState)
        rules += rule

    // Parse the given maze keyword for the proper file/Maze class instantiation
    def LOAD(str: String) = str match
        case "EMPTY" => mazeName = Maze("resources" + File.separator + "empty.txt")
        case "MAZE" => mazeName = Maze("resources" + File.separator + "maze.txt")

    // THEN does all the work, and STATE just passes the result through to RULE
    def STATE(e : List[Int]) : List[Int] = e

    // Like with STATE, all the work gets done by the lower-lying operator
    def IF(s : (List[picolib.semantics.RelativeDescription], picolib.semantics.MoveDirection)) : (List[picolib.semantics.RelativeDescription], picolib.semantics.MoveDirection) = s

    // Have TO combined the state ints into a list for later parsing by RULE
    extension (i : Int)
        def TO(j : Int) : List[Int] = List(i, j)

    // THEN combines the direction parameters and the next direction into a tuple for RULE
    extension (i : List[picolib.semantics.RelativeDescription])
        def THEN(dir : picolib.semantics.MoveDirection) : (List[picolib.semantics.RelativeDescription], picolib.semantics.MoveDirection) = 
            (i, dir)

    // Take the maze and rules list and run the picobot with visualization!
    def GO = {
        object bot extends Picobot(mazeName, rules.toList) with TextDisplay
        bot.run()
    }
}

