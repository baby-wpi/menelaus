Kabasuji: Menelaus (Frank, Oba, Dimitar, Sanjay, Matt)

Attached is the builder and game.

Run the game by running "MainGame.java"
Run the builder by running "MainBuilder.java"

Currently, not all functionality is supported, so some buttons may not work properly, and there are graphical glitches

To clear the custom levels, delete "customLevels.boba"
To load the new custom levels you create, replace "defaultLevels.boba" with "customLevels.boba" (with the name "defaultLevels.boba")

The builder has the ability to load the last built level, by clicking "Edit Level". However, the output file still has both the original, and new level.

Building takes the following steps:

Step 1: Build board:
    Select Level type, name, width, height, and chop out pieces on board that you don't want. (click to chop/unchop)

Step 2: Build level: (Please resize window so bigger)
    Set name, max moves/time.
    Puzzle:
        Click on a square to select it, click "Make Piece" after 6 squares. Hit "Complete" to finish and save the level.
        Note that the piece will STAY ON THE BOARD for your reference, and also be added to the bullpen.
        In the final output level, the board will be wiped, and the bullpen will remain intact.
        
    Lightning:
        After inputting max time, hit complete. (Note that the rest of the UI still functions, as it has not been disabled yet).
        -Still need to add in number of pieces allowed. Coming soon.
        
Step 3: Finish Level
    Click Complete 
    

Editing Levels:
    When you open up a level to edit, you lose the reference board view, so be careful.
    

Undo is there behind the scenes, but the controllers don't link to it yet.
Validity checking and other mode features still must be added.
Hint functionality is behind the scenes, but controllers don't link to it yet.