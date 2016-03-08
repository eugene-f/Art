//package kz.ef.art.j3d;
//
//import com.sun.j3d.loaders.Scene;
//import com.sun.j3d.loaders.objectfile.ObjectFile;
//import com.sun.j3d.utils.universe.SimpleUniverse;
//
//import javax.media.j3d.Texture2D;
//
//import com.sun.j3d.utils.image.TextureLoader;
//
//import javax.media.j3d.*;
//import javax.swing.*;
//import javax.vecmath.Color3f;
//import javax.vecmath.Vector3f;
//import java.awt.*;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Map;
//import javax.media.j3d.Background;
//
//public class SimpleModelView2 extends JFrame {
//
//    public SimpleModelView2() throws IOException {
//
//        Canvas3D canvas;
//        SimpleUniverse universe;
//        BranchGroup root;
//
//
////        addLightsToUniverse();
//        Bounds influenceRegion = new BoundingSphere();
//        Color3f lightColor = new Color3f(Color.WHITE);
//        Vector3f lightDirection = new Vector3f(-1F, -1F, -1F);
//        DirectionalLight light = new DirectionalLight(lightColor, lightDirection);
//        light.setInfluencingBounds(influenceRegion);
//        root.addChild(light);
//
//
//
//
//
//            /* A dull gray background */
//        Background background = new Background(new Color3f(Color.LIGHT_GRAY));
//            /* incluencRegion is a BoundingSphere. See the "Lights" section for details */
//        background.setApplicationBounds(influenceRegion);
//            /* root is a BranchGroup, root node of your Scene object */
//        root.addChild(background);
//
//
////        TextureLoader textureLoader = new TextureLoader("src/main/resources/carbodyD.png", canvas);
////        Texture2D texture = new Texture2D(Texture2D.BASE_LEVEL,
////                Texture2D.RGB,
////                2048,
////                2048
////        );
////        texture.setImage(0, textureLoader.getImage());
////        Appearance appearance = new Appearance();
////        appearance.setTexture(texture);
////
////
////        TextureLoader textureLoader2 = new TextureLoader("src/main/resources/WheelD.png", canvas);
////        Texture2D texture2 = new Texture2D(Texture2D.BASE_LEVEL,
////                Texture2D.RGB,
////                1024,
////                1024
////        );
////        texture2.setImage(0, textureLoader2.getImage());
////        Appearance appearance2 = new Appearance();
////        appearance2.setTexture(texture2);
//
//
//        Map<String, Shape3D> nameMap = scene.getNamedObjects();
//        for (String name : nameMap.keySet()) {
//            System.out.printf("Name: %s\n", name);
//        }
////        nameMap.get("carbody_cube.003").setAppearance(appearance);
////        nameMap.get("wheelrf_cube.004").setAppearance(appearance2);
////        nameMap.get("wheellb_cube.006").setAppearance(appearance2);
////        nameMap.get("wheellf_cube.000").setAppearance(appearance2);
//
//
//        root.compile();
//        universe.addBranchGraph(root);
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        new SimpleModelView2().setVisible(true);
//    }
//
//
//}
