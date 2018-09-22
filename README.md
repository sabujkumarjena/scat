# scat

A library for pragmatic application of Category Theory and Mordern Algebra

## How to compile and test it?

Steps:
1. Clone the sbt project
2. Change to home directory of project
3. Enter sbt compile to comile it.
4. Enter sbt test to test

## how to use it?

Create a simple algebratic structure by providing its type as most of algebraic instances
are available as implicit values. To make implicit values visible import instaces object of the 
algebraic strucure. 

### Example:

-  `import scat._`
-  `import MonadInstances._`
-  `val l = Monad[List]`
-  `println(l.flatMap(List(1,2,3))(x=> List(x,x)))`

- `>>List(1, 1, 2, 2, 3, 3)`

## how to contribute..

You can define new instances of an algebraic structure inside instance object of 
that algebraic structure inside instances/<algebraicstructure>Instaces.scala file.
e.g you can add new Monad instaces in instances/MonadInstances .please make those instances
as implicit value.

you can add new algebraic structure as type class in TypeClasses folder and its laws in Law folder
and testcases in spec/ folder. 
