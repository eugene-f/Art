package kz.ef.art.j3d.model; /**
 * Created by yevgeniy on 16.02.16.
 */

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.lw3d.Lw3dLoader;
import com.sun.j3d.loaders.objectfile.ObjectFile;

import java.io.FileReader;
import java.io.IOException;

public class ModelLoader {

    public static Scene loadLwoScene(String location) throws IOException {
        Lw3dLoader loader = new Lw3dLoader();
        return loader.load(new FileReader(location));
    }

    public static Scene loadObjScene(String location) throws IOException {
        ObjectFile loader = new ObjectFile(ObjectFile.RESIZE);
        return loader.load(new FileReader(location));
    }

}
