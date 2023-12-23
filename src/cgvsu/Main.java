package cgvsu;

import javax.vecmath.*;
import cgvsu.model.Model;
import cgvsu.objreader.IncorrectFileException;
import cgvsu.objreader.ObjReader;
import cgvsu.objreader.PathReadException;
import cgvsu.AffineTransformation.*;
import static cgvsu.AffineTransformation.AffineTransformations.scale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws PathReadException, IncorrectFileException {
        String fileContent = null;
        try {
            Path fileName = Path.of("C:\\Users\\Dima\\IdeaProjects\\AffineTransformations\\Objects\\new1.obj");
            fileContent = Files.readString(fileName);
        } catch (IOException e) {
            throw new PathReadException();
        }

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

//        System.out.println("Vertices: " + model.vertices.size());
//        System.out.println("Texture vertices: " + model.textureVertices.size());
//        System.out.println("Normals: " + model.normals.size());
//        System.out.println("Polygons: " + model.polygons.size());
//        System.out.println("_________");
        System.out.println(model.vertices.get(0));
        ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
        Vector3f vector3f = new Vector3f(1.5F,1.0F, 0.8F);
        scale(model,vector3f);
        System.out.println(model.vertices.get(0));
    }

    public static final float eps = 1e-7f;
}