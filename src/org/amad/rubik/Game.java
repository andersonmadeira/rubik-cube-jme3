package org.amad.rubik;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.CartoonEdgeFilter;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author normenhansen
 */
public class Game extends SimpleApplication {
    private static int LINS = 3, COLS = 3;
    private Spatial cubes[][];
    @Override
    public void simpleInitApp() {
        cubes = new Spatial[LINS][COLS];
        
        // generate cubes
        for(int z = 0; z < 3; z++) {
            for (int i = 0; i < LINS; i++) {
                for (int j = 0; j < COLS; j++) {
                    cubes[i][j] = assetManager.loadModel("Models/Cube/Cube.j3o");
                    cubes[i][j].scale(0.5f);
                    //cubes[i][j] = new Geometry("Box", new Box(0.5f, 0.5f, 0.5f));
                    cubes[i][j].setLocalTranslation(new Vector3f(1.01f*j, 1.01f*i, 1.01f*z));
                    rootNode.attachChild(cubes[i][j]);
                }
            }
        }
        
        // adds a directional light so we can view the cubes
        AmbientLight sun = new AmbientLight();
        //sun.setDirection(new Vector3f(6.5f, 5.f, 7f));
        rootNode.addLight(sun);
        
        viewPort.setBackgroundColor(ColorRGBA.White);
        
        // translate camera to a nice position
        cam.setLocation(new Vector3f(6.5f, 5.f, 7f));
        // make the cam look at the ZERO coords for a perspective view
        cam.lookAt(Vector3f.ZERO, cam.getUp());
        
        // enable cell shading
//        FilterPostProcessor fpp = new FilterPostProcessor(assetManager);
//        fpp.addFilter(new CartoonEdgeFilter());
//        viewPort.addProcessor(fpp);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
