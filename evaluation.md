# Evaluation: running commentary

## Internal DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

One change was that I had to wrap each rule in a RULE function instead of having the STATE and IF as separate things in my ideal example. This was because I needed some sort of function to get the state and parameters, encode them as a formal rule using the Rule class, and then append it to my running list of rules.

Another change was that my ideal example had no parentheses, but in practice I needed a lot of them for my implementation to work. For example, both STATE and IF needed parentheses wrapped around the rest of those lines to allow the rest to be passed into STATE/IF as an argument. I also had to wrap both the STATE and IF lines in parentheses for them to be inputs to RULE. Of all the changes I had to make, this was the one that saddened me the most, as I think it makes the code a good bit harder to implement for a first-time programmer.

An additional change that I had to make was to put each RULE all on one line. It would have been nice to have support for the spacing as shown in my ideal example! My syntax could've been approximated with method chaining and dot notation, but I thought that the dots would be too confusing for first-time coders, and instead opted for my current approach.

Finally, the direction parameters need to be encoded explicitly as a list. I thought a lot about alternate ways to solve this problem (making a more relevant alias for List like Group or passing the directions in as a String and pattern-matching on the back-end to get the right list) but keeping this syntax as-is felt like the right choice. 

Overall things could have gone a lot worse here. I think that I preserved the core spirit of my ideal example, but I would've been happier if some (if not all) of these changes could have been fixed.

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

I would give it a 3 or 4. As I stated before, the key parts of my syntax - the SQL-like expression names and the order in which information is stated - was preserved here. If I had more time to work on this assignment, it's possible that I could have fixed some of my necessary changes and gotten closer to my intended syntax. However, it's likely that some of my changes were unavoidable if I am to implement this language as an internal DSL.

**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**

I would give it a 3. There were some trouble spots, and I had to make a good number of adjustments to get it working, but it could have been a lot worse. For example, I think that implementing the syntax by Tiffany Fong & Samantha Andow (from the class slides on March 1st) would have been a lot more involved. I also preserved some important parts of the given picobot DSL, like Open, Block, and Anything for the direction parameters.

## External DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**