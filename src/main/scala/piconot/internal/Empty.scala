import picolib._
import picolib.maze._
import picolib.semantics._
import java.io.File
import piconot.internal._

/** This is an intentionally bad internal language, but it uses all the parts of
  * the picolib library that you might need to implement your language
  */

object EmptyTest extends Implementation {

  LOAD("EMPTY")

  /////////////////////////////////////////////////////////
  // State 0: go West
  /////////////////////////////////////////////////////////

  // as long as West is unblocked, go West  
  RULE (STATE (0 TO 0)) (IF( List(Anything, Anything, Open, Anything) THEN West))

  // can't go West anymore, so try to go North (by transitioning to State 1)
  RULE (STATE (0 TO 1)) (IF( List(Anything, Anything, Blocked, Anything) THEN Wait))


  /////////////////////////////////////////////////////////
  // State 1: go North
  /////////////////////////////////////////////////////////

  // as long as North is unblocked, go North
  RULE (STATE (1 TO 1)) (IF( List(Open, Anything, Anything, Anything) THEN North))

  // can't go North any more, so try to go South (by transitioning to State 2)
  RULE (STATE (1 TO 2)) (IF( List(Blocked, Anything, Anything, Open) THEN South))


  /////////////////////////////////////////////////////////
  // States 2 & 3: fill from North to South, West to East
  /////////////////////////////////////////////////////////

  // State 2: fill this column from North to South
  RULE (STATE (2 TO 2)) (IF( List(Anything, Anything, Anything, Open) THEN South))

  // can't go South anymore, move one column to the East and go North
  // (by transitioning to State 3)
  RULE (STATE (2 TO 3)) (IF( List(Anything, Open, Anything, Blocked) THEN East))

  // State 3: fill this column from South to North
  RULE (STATE (3 TO 3)) (IF( List(Open, Anything, Anything, Anything) THEN North))

  // can't go North anymore, move one column to the East and go South
  // (by transitioning to State 2)
  RULE (STATE (3 TO 2)) (IF( List(Blocked, Open, Anything, Anything) THEN East))

  GO
}