import picolib._
import picolib.maze._
import picolib.semantics._
import java.io.File
import piconot.internal._

// # State 0: moving north
// 0 *x** -> E 1    # we can turn right!
// 0 xE** -> N 0
// 0 NE** -> X 3

// # State 1: moving east
// 1 ***x -> S 3    # we can turn right!
// 1 *x*S -> E 1
// 1 *ExS -> X 2

// # State 2: moving west
// 2 x*** -> N 0    # we can turn right!
// 2 N*x* -> W 2
// 2 NxW* -> X 1

// # State 3: moving south
// 3 **x* -> W 2    # we can turn right!
// 3 **Wx -> S 3
// 3 x*WS -> X 0

object RightHandTest extends Implementation() {

    LOAD("MAZE")

    RULE (STATE (0 TO 1)) (IF( List(Open, Anything, Anything, Anything) THEN East))
    RULE (STATE (0 TO 0)) (IF( List(Open, Anything, Anything, Anything) THEN North))
    RULE (STATE (0 TO 3)) (IF( List(Open, Anything, Anything, Anything) THEN Wait))


    GO
}