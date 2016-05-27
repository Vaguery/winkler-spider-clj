# Three Polite Spiders Share an Ant on a Cube

Based on a puzzle in Peter Winkler's excellent [Mathematical Mind-Benders](https://books.google.com/books/about/Mathematical_Mind_Benders.html?id=phIlAQAAIAAJ).

> Three spiders and an ant are walking on the edges (and corners) of a cube. The spiders can walk 1/3 as fast as the ant. It's provable that the spiders can (with some coordination) always catch the ant, even though it's faster than they are.

This is a simple Clojure library that models the cube, the bugs, and provides a few utility functions for calculating minimum distances and movement of arbitrary points along the edges of a cube. Eventually it'll probably also generalize to movement on graphs.