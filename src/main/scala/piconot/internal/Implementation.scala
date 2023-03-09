package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import scala.collection.mutable.ListBuffer
import picolib.display.TextDisplay
import java.io.File

// Class structure, the rules being a ListBuffer, and my GO function is all lovingly ripped off from the sample solution!

class Implementation() extends App {

    // We default-initialize the maze with an empty one
    private var mazeName = Maze("resources" + File.separator + "empty.txt")
    private val rules = ListBuffer.empty[Rule]

    val Wait = StayHere

    def RULE(state : List[Int])(params : (List[picolib.semantics.RelativeDescription], picolib.semantics.MoveDirection)) = 
        val startState = State(state(0).toString)
        val endState = State(state(1).toString)
        val surroundings = Surroundings(params(0)(0), params(0)(1), params(0)(2), params(0)(3))
        val rule = Rule(startState, surroundings, params(1), endState)
        rules += rule

    def LOAD(str: String) = str match
        case "EMPTY" => mazeName = Maze("resources" + File.separator + "empty.txt")
        case "MAZE" => mazeName = Maze("resources" + File.separator + "maze.txt")

    def STATE(e : List[Int]) : List[Int] = e

    def IF(s : (List[picolib.semantics.RelativeDescription], picolib.semantics.MoveDirection)) : (List[picolib.semantics.RelativeDescription], picolib.semantics.MoveDirection) = s

    extension (i : Int)
        def TO(j : Int) : List[Int] = List(i, j)

    extension (i : List[picolib.semantics.RelativeDescription])
        def THEN(dir : picolib.semantics.MoveDirection) : (List[picolib.semantics.RelativeDescription], picolib.semantics.MoveDirection) = 
            (i, dir)

    def GO = {
        object bot extends Picobot(mazeName, rules.toList) with TextDisplay
        bot.run()
    }
}

