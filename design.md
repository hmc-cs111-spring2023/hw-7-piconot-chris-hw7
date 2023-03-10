# Design

## Who is the target for this design, e.g., are you assuming any knowledge on the part of the language users?

My target for this design is for people with as little computing experience as possible. Think normal people in your life who aren't very tech savvy and have never coded before. The goal is that these people can be given some introduction to data types and conditionals and then be ready to program picobot using my DSL!

## Why did you choose this design, i.e., why did you think it would be a good idea for users to express the maze-searching computation using this syntax?

Picobot is meant to be an introductory tool to get people thinking about logic and simple algorithm design in computer science. To make it as simple as possible (and in a manner that is applicable to real programming languages) I was inspired by SQL to make my design rely on short and clear keywords that express exactly what is going on. I also want to change the order of how information is programmed for each rule. For instance, instead of the start and end state bookending the rule in the classic syntax, the state changes goes up front in mine: STATE 0 TO 1. 

## What behaviors are easier to express in your design than in Picobot’s original design?  If there are no such behaviors, why not?

In my design it's easier to express the directional parameters of each rule. The N-E-W-S-x-* syntax of the original language is concise, but not very readable in my view. I also think it's kind of misleading for those who are less familiar with the syntax - you'd think that the x means that direction is blocked (based on convention), but it actually means it's open. The Open, Blocked, and Anything syntax from the given picobot implementation are more understandable and don't abstract away too much. I also think it's easier to list out the state transitions when it's formatted like STATE X to Y instead of at the start and end of the rule as in the original syntax.

## What behaviors are more difficult to express in your design than in Picobot’s original design? If there are no such behaviors, why not?

The fact that it is more verbose makes it take longer to type a rule out. However, for those just learning CS concepts for the first time, their typical speed is not going to be the bottleneck, so the improvements to clarity and readability are worth such downsides.

## On a scale of 1–10 (where 10 is “very different”), how different is your syntax from PicoBot’s original design?

I would give this a 5. I've noticeably changed all of the operators along with the order in which the information is coded, but it's not a radical reimagining of how one uses picobot either.

## Is there anything you would improve about your design?

Overall, I'm pretty satisfied with what I settled on. But if I were designing for more experienced users (or those who desire a more succinct language) then my design would have come out a lot different!