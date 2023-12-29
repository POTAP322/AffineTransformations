package cgvsu.AffineTransformation;

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


    @org.junit.jupiter.api.Test
    void testRotateObject() throws PathReadException, IncorrectFileException {
        String fileContent = null;
        try {
            Path fileName = Path.of("C:\\Users\\User\\IdeaProjects\\AffineTransformations\\Objects\\new1.obj");
            fileContent = Files.readString(fileName);
        } catch (IOException e) {
            throw new PathReadException();
        }
        Model model = ObjReader.read(fileContent);

        rotate(model, (float) Math.toRadians(180),"x");
        Vector3f expectedVector = new Vector3f(12.7f,-146.2f,8.46f);
        assertEquals(expectedVector,model.vertices.get(0));

    }

    @org.junit.jupiter.api.Test
    void testScaleObject()throws PathReadException, IncorrectFileException {
        String fileContent = null;
        try {
            Path fileName = Path.of("C:\\Users\\User\\IdeaProjects\\AffineTransformations\\Objects\\new1.obj");
            fileContent = Files.readString(fileName);
        } catch (IOException e) {
            throw new PathReadException();
        }
        Model model = ObjReader.read(fileContent);

        Vector3f vector3f = new Vector3f(1.5F,1.0F, 0.8F);
        scale(model,vector3f);

        Vector3f expectedVector = new Vector3f(19.05f,146.2f,-6.768f);
        assertEquals(expectedVector,model.vertices.get(0));
    }

    @org.junit.jupiter.api.Test
    void testTranslateObject()throws PathReadException, IncorrectFileException {
        String fileContent = null;
        try {
            Path fileName = Path.of("C:\\Users\\User\\IdeaProjects\\AffineTransformations\\Objects\\new1.obj");
            fileContent = Files.readString(fileName);
        } catch (IOException e) {
            throw new PathReadException();
        }
        Model model = ObjReader.read(fileContent);

        Vector3f vector3f = new Vector3f(2.0f,4.1f,5.6f);
        translate(model,vector3f);

        Vector3f expectedVector = new Vector3f(14.7f,150.3f,-2.86f);
        assertEquals(expectedVector,model.vertices.get(0));

    }
}