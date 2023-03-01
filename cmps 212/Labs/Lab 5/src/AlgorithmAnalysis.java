public class AlgorithmAnalysis {
    /*
    1- O(n) for loop form 0 to n-1 with 3 operation compare add ad increment so runtime 3n implies O(n)
    2- O(n^2) 2 nested for loops same as above except in each iteration of i we have n operation os n*n=n^2
    3- O(log(n)) for loop where we increment by *2 to in n we have log base 2 (n) increments so O(log(n))
    4- 0(n^3) 3 nested for loops
    5- O(nlog(n)log(n)) first loop is n then log(n) then log(n) so n*log(n)*log(n)
    Part 1
a- best O(1) adds without resizing
worst O(n) adds with resizing and thus needs to iterate over the entire array
averageO(n)
b- best O(1) removes without resizing
worst O(n) removes with resizing and thus needs to iterate over the entire array
average O(n)
Part 2
a = O(n^2)
b = O(log(n))
c = O(n^4+n^4*log(n))
Part 3
a) 0.01n^2+500n<=cn^2
  c=1 && no>=506
b)  5 + 100log(n)
   c=101 && no>=30
c)  5n^3+ n^4*log(n)
c=1 && no>=5
we proved a is O(n^2), we should prove that a should be omega(n^2) to prove that a is theta(n^2).
However, a can't be theta(n^2) since (0.01n^2+500n)/n^2 as n tends to infinity tends to 0 which means n^2 is always larger at infinity than 0.01n^2+500n

     */
}
