package org.amad.rubik;

import com.jme3.system.AppSettings;

/**
 * test
 * @author normenhansen
 */
public class Main {
    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setSamples(2);
        settings.setTitle("Cubik - Rubik Cube Game");
        
        Game app = new Game();
        app.setSettings(settings); 
        app.start();
    }
}
