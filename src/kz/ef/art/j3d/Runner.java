package kz.ef.art.j3d;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by yevgeniy on 16.02.16.
 */
public class Runner extends JFrame {

    public static void main(String[] args) throws IOException {
        new Runner();
    }

    public Runner() throws IOException {
        setTitle("Java 3D");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(240, 320);
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);

//        ModelLoader.loadLwoScene("src/main/resources/M1-A1_FREE.lwo");
//        ModelLoader.loadObjScene("src/main/resources/M1A1-Abrams.obj");
//        Scene scene = ModelLoader.loadLwoScene("src/main/resources/small_car.obj");

        SimpleUniverse simpleUniverse = new SimpleUniverse();

        simpleUniverse.getViewingPlatform().setNominalViewingTransform();
//        simpleUniverse.addBranchGraph(scene.getSceneGroup());

    }

}
