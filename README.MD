# The Mars Rover Tech task

As an engineer for the Melody Mars Mission, I have the task to create a program to move rovers around the surface of
Mars! I started checking the requirements and classes needed. I started expanding my design and creating the code. This
was developed in Java 17.

## Key Features of Solution

Classes: Rover, Mars, Plateau, Earth, Coordinate, Direction.
Attributes: Cameras, Arms, X and Y, N, S, E and W
Restrictions: Square/Rectangle, verify invalid things and missing inputs

## Assumptions

The surface of Mars is represented by a Plateau.
Plateau is a square/rectangle based on the positive quadrant.
Rovers navigate the Plateau.
Coordinates: X, Y.
Cardinal Compass points: N, S, E, W.
Rotation/Move:
L: Rotates 90 degrees to the left.
R: Rotates 90 degrees to the right.
M: Move forward.

## Approaches

Mars → Plateau → Rovers → Coordinates → Direction
Mars has Plateau.
Plateau has a List of Rovers and size.
The rover has direction and coordinates.

## UML

![This is an image](https://github.com/hvferreira/Java-The-Mars-Rover/blob/master/src/UML/img.png)

## Future Thoughts

Add planets.
Add vehicles.
Add different plateaus.
Add skins with different obstacles.
Add features to the vehicles.
