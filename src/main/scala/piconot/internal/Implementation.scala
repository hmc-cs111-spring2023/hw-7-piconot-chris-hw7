package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._


// def RULE(states : Expr)(move : Expr) : 

def LOAD(str: String) = Maze(str)

// def TO(start : Int)(end : Int) : List[Int] = List(start, end)

def STATE(e : List[Int]) : List[Int] = e

def IF(s : List[Anything]) : List[Anything] = s

extension (i : Int)
    def TO(j : Int) : List[Int] = List(i, j)

extension (i : List[picolib.semantics.RelativeDescription])
    def THEN(dir : picolib.semantics.MoveDirection) = List(i, dir)