package Tests;

import cgvsu.model.Model;
import cgvsu.objreader.IncorrectFileException;
import cgvsu.objreader.ObjReader;
import cgvsu.objreader.PathReadException;

import javax.vecmath.Vector3f;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static cgvsu.AffineTransformation.AffineTransformations.*;
import static org.junit.jupiter.api.Assertions.*;

class AffineTransformationsTest {
    public static final String filepath = "C:\\Users\\User\\IdeaProjects\\AffineTransformations\\Objects\\new1.obj";


    @org.junit.jupiter.api.Test
    void testRotateObjectX() throws PathReadException, IncorrectFileException {

        Model model = getModel(filepath);
        rotate(model.vertices , (float) Math.toRadians(180),Axis.x);
        Vector3f expectedVector = new Vector3f(12.7f,-146.2f,8.46f);
        assertTrue(expectedVector.epsilonEquals(model.vertices.get(0), 1E-4f));

    }
    @org.junit.jupiter.api.Test
    void testRotateObjectY() throws PathReadException, IncorrectFileException {

        Model model = getModel(filepath);
        rotate(model.vertices , (float) Math.toRadians(180),Axis.y);
        Vector3f expectedVector = new Vector3f(-12.7f,146.2f,8.46f);
        assertTrue(expectedVector.epsilonEquals(model.vertices.get(0), 1E-4f));

    }
    @org.junit.jupiter.api.Test
    void testRotateObjectZ() throws PathReadException, IncorrectFileException {

        Model model = getModel(filepath);
        rotate(model.vertices , (float) Math.toRadians(180),Axis.z);
        Vector3f expectedVector = new Vector3f(-12.7f,-146.2f,-8.46f);
        //assertEquals(expectedVector,model.vertices.get(0));
        assertTrue(expectedVector.epsilonEquals(model.vertices.get(0), 1E-4f));

    }


    @org.junit.jupiter.api.Test
    void testScaleObject()throws PathReadException, IncorrectFileException {
        Model model = getModel(filepath);

        Vector3f vector3f = new Vector3f(1.5F,1.0F, 0.8F);
        scale(model.vertices,vector3f);

        Vector3f expectedVector = new Vector3f(19.05f,146.2f,-6.768f);
        assertTrue(expectedVector.epsilonEquals(model.vertices.get(0), 1E-4f));

    }

    @org.junit.jupiter.api.Test
    void testTranslateObject()throws PathReadException, IncorrectFileException {
        Model model = getModel(filepath);

        Vector3f vector3f = new Vector3f(2.0f,4.1f,5.6f);
        translate(model.vertices,vector3f);

        Vector3f expectedVector = new Vector3f(14.7f,150.3f,-2.86f);
        assertTrue(expectedVector.epsilonEquals(model.vertices.get(0), 1E-4f));


    }
    public static Model getModel(String filepath) throws IncorrectFileException, PathReadException {
        String fileData = null;
        try {
            Path fileName = Path.of(filepath);
            fileData = Files.readString(fileName);
        } catch (IOException e) {
            throw new PathReadException();
        }
        return ObjReader.read(fileData);
    }
}