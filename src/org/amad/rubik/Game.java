package org.amad.rubik;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.CartoonEdgeFilter;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author normenhansen
 */
public class Game extends SimpleApplication {
    private static int LINS = 3, COLS = 3;
    private Geometry boxes[][];
    @Override
    public void simpleInitApp() {
        boxes = new Geometry[LINS][COLS];
        ColorRGBA colors[] = {ColorRGBA.Cyan, ColorRGBA.Green, ColorRGBA.Red};
        
        
        for(int z = 0; z < 3; z++) {
            for (int i = 0; i < LINS; i++) {
                for (int j = 0; j < COLS; j++) {
                    boxes[i][j] = new Geometry("Box", new Box(0.5f, 0.5f, 0.5f));
                    boxes[i][j].setLocalTranslation(new Vector3f(1.05f*j, 1.05f*i, 1.05f*z));
                    Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                    mat.setColor("Color", colors[z]);
                    boxes[i][j].setMaterial(mat);
                    rootNode.attachChild(boxes[i][j]);
                }
            }
        }
        
        viewPort.setBackgroundColor(ColorRGBA.White);
        
        // enable cell shading
        FilterPostProcessor fpp = new FilterPostProcessor(assetManager);
        fpp.addFilter(new CartoonEdgeFilter());
        viewPort.addProcessor(fpp);
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
