import picolib._
import picolib.maze._
import picolib.semantics._
import java.io.File
import piconot.internal._

object RightHandTest extends Implementation {

    LOAD("MAZE")

    // # State 0: moving north
    RULE (STATE (0 TO 1)) (IF( List(Anything, Open, Anything, Anything) THEN East))
    RULE (STATE (0 TO 0)) (IF( List(Open, Blocked, Anything, Anything) THEN North))
    RULE (STATE (0 TO 3)) (IF( List(Blocked, Blocked, Anything, Anything) THEN Wait))

    // # State 1: moving east
    RULE (STATE (1 TO 3)) (IF( List(Anything, Anything, Anything, Open) THEN South))
    RULE (STATE (1 TO 1)) (IF( List(Anything, Open, Anything, Blocked) THEN East))
    RULE (STATE (1 TO 2)) (IF( List(Anything, Blocked, Open, Blocked) THEN Wait))

    // # State 2: moving west
    RULE (STATE (2 TO 0)) (IF( List(Open, Anything, Anything, Anything) THEN North))
    RULE (STATE (2 TO 2)) (IF( List(Blocked, Anything, Open, Anything) THEN West))
    RULE (STATE (2 TO 1)) (IF( List(Blocked, Open, Blocked, Anything) THEN Wait))

    // # State 3: moving south
    RULE (STATE (3 TO 2)) (IF( List(Anything, Anything, Open, Anything) THEN West))
    RULE (STATE (3 TO 3)) (IF( List(Anything, Anything, Blocked, Open) THEN South))
    RULE (STATE (3 TO 0)) (IF( List(Open, Anything, Blocked, Blocked) THEN Wait))    
    
    GO
}