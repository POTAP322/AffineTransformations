package cgvsu;

import javax.vecmath.*;
import cgvsu.model.Model;
import cgvsu.objreader.IncorrectFileException;
import cgvsu.objreader.ObjReader;
import cgvsu.objreader.PathReadException;
import cgvsu.AffineTransformation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static cgvsu.AffineTransformation.AffineTransformations.*;


public class Main {

    public static void main(String[] args) throws PathReadException, IncorrectFileException {
        String fileContent = null;
        try {
            Path fileName = Path.of("C:\\Users\\User\\IdeaProjects\\AffineTransformations\\Objects\\new1.obj");
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

        //scale
//        Vector3f vector3f = new Vector3f(1.5F,1.0F, 0.8F);
//        scale(model,vector3f);
//        System.out.println(model.vertices.get(0));
//        System.out.println(Math.cos(30)*(-1));

        //rotate
        List<Vector3f> vector3fs1 = new ArrayList<>();
        rotate(vector3fs1, (float) Math.toRadians(180),Axis.x);


        System.out.println(model.vertices.get(0));

        //translation

//        Vector3f vector3f = new Vector3f(2.0f,4.1f,5.6f);
//        translate(model,vector3f);
//        System.out.println(model.vertices.get(0));


    }

}