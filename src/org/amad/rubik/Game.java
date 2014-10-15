package org.amad.rubik;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.light.SpotLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.CartoonEdgeFilter;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * test
 * @author normenhansen
 */
public class Game extends SimpleApplication {
    private static int LINS = 3, COLS = 3;
    private Spatial cubes[][];
    private Node xPivot, yPivot, zPivot;
    
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
                    cubes[i][j].setLocalTranslation(new Vector3f(1f*j, 1f*i, 1f*z));
                    rootNode.attachChild(cubes[i][j]);
                }
            }
        }
        
        viewPort.setBackgroundColor(ColorRGBA.LightGray);
        
        // translate camera to a nice position
        cam.setLocation(new Vector3f(6.5f, 5.f, 7f));
        // make the cam look at the ZERO coords for a perspective view
        cam.lookAt(Vector3f.ZERO, cam.getUp());
        
        // sets the spot light to be in front of the cube point to it.
        SpotLight spot = new SpotLight();
        spot.setSpotRange(100f);                           // distance
        spot.setSpotInnerAngle(15f * FastMath.DEG_TO_RAD); // inner light cone (central beam)
        spot.setSpotOuterAngle(35f * FastMath.DEG_TO_RAD); // outer light cone (edge of the light)
        spot.setColor(ColorRGBA.White.mult(2.3f));         // light color
        spot.setPosition(cam.getLocation());               // shine from camera loc
        spot.setDirection(cam.getDirection());             // shine forward from camera loc
        rootNode.addLight(spot);
        
        /**
         * @todo: rotate the cubes.
         */
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
