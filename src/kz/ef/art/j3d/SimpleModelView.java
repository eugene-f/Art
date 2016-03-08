package kz.ef.art.j3d;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.universe.SimpleUniverse;
import kz.ef.art.*;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class SimpleModelView extends JFrame {

//    private static final String FILE_PATH = "src/main/resources/";
    private static final String OBJ_MODEL_FILE_PATH = "/res/j3d/T72 Tank.obj";

    public static void main(String[] args) throws IOException {
        new SimpleModelView();
    }

    private Scene scene;
    private Canvas3D canvas;
    private SimpleUniverse universe;
    private BranchGroup root;

    public SimpleModelView() throws IOException {
        configureWindow();
        configureCanvas();
        conigureUniverse();
        addModelToUniverse();
        addLightsToUniverse();



        Background background = new Background(new Color3f(Color.LIGHT_GRAY));
        background.setApplicationBounds(root.getBounds());
        root.addChild(background);

//        TextureLoader textureLoader = new TextureLoader("res/j3d/carbodyD.png", canvas);
//        Texture2D texture = new Texture2D(Texture2D.BASE_LEVEL, Texture2D.RGB, 2048, 2048);
//        texture.setImage(0, textureLoader.getImage());
//        Appearance appearance = new Appearance();
//        appearance.setTexture(texture);

        Map<String, Shape3D> nameMap = scene.getNamedObjects();
//        nameMap.get("carbody_cube.003").setAppearance(appearance);



        root.compile();
        universe.addBranchGraph(root);
        setVisible(true);
    }

    private void configureWindow() {
        setTitle("Java3D");
        setSize(640, 480);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int locationX = (screenSize.width - getWidth()) / 2;
//        int locationY = (screenSize.height - getHeight()) / 2;
//        setLocation(locationX,locationY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void configureCanvas() {
        canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        canvas.setDoubleBufferEnable(true);
        getContentPane().add(canvas, BorderLayout.CENTER);
    }

    private void conigureUniverse() {
        universe = new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
    }

    private void addModelToUniverse() throws IOException {
        scene = getSceneFromFile(OBJ_MODEL_FILE_PATH);
        listSceneNamedObjects(scene);
        root = scene.getSceneGroup();
    }

    private void addLightsToUniverse() {
        Bounds influenceRegion = new BoundingSphere();
        Color3f lightColor = new Color3f(Color.WHITE);
        Vector3f lightDirection = new Vector3f(-1F, -1F, -1F);
        DirectionalLight light = new DirectionalLight(lightColor, lightDirection);
        light.setInfluencingBounds(influenceRegion);
        root.addChild(light);
    }

    public static Scene getSceneFromFile(String location) throws IOException {
        ObjectFile file = new ObjectFile(ObjectFile.RESIZE);
        return file.load(kz.ef.art.Runner.class.getResource(location));
    }

    void listSceneNamedObjects(Scene scene) {
        Map<String, Shape3D> nameMap = scene.getNamedObjects();
        for (String name : nameMap.keySet()) {
            System.out.printf("Name: %s\n", name);
        }
    }

}
