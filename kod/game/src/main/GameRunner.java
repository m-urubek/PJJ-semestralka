package cz.mendelu.pjj.game;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.game.greenfoot.MyWorld;

/**
 * A sample runner for a greenfoot project.
 */
public class GameRunner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(GameRunner.class,
                // 3. Prepare the configuration for the runner based on the world class
                Configuration.forWorld(MyWorld.class)
                        // Set the project name as you wish
                        .projectName("Moje hra")
                        .hideControls(true)
        );
    }
}