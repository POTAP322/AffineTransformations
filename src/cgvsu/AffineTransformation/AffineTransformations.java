package cgvsu.AffineTransformation;
import java.io.*;
import java.util.List;
import javax.vecmath.*;
import cgvsu.model.Model;

public class AffineTransformations {

    public enum Axis{
        x,
        y,
        z
    }

    public static void rotate(List<Vector3f> vertices, float radianAngle, Axis axis) {
        // Применить поворот ко всем вершинам

        Matrix4f rotationMatrix = new Matrix4f();
        rotationMatrix.setIdentity(); // создали единичная матрциа
        if (axis == Axis.z){
            rotationMatrix.m00 = (float) Math.cos(radianAngle);
            rotationMatrix.m01 = (float) Math.sin(radianAngle);
            rotationMatrix.m10 = (float) Math.sin(radianAngle)*(-1);
            rotationMatrix.m11 = (float) Math.cos(radianAngle);
        } else if (axis== Axis.y) {
            rotationMatrix.m00 = (float) Math.cos(radianAngle);
            rotationMatrix.m02 = (float) Math.sin(radianAngle);
            rotationMatrix.m20 = (float) Math.sin(radianAngle)*(-1);
            rotationMatrix.m22 = (float) Math.cos(radianAngle);
        } else if (axis == Axis.x) {
            rotationMatrix.m11 = (float) Math.cos(radianAngle);
            rotationMatrix.m12 = (float) Math.sin(radianAngle);
            rotationMatrix.m21 = (float) Math.sin(radianAngle)*(-1);
            rotationMatrix.m22 = (float) Math.cos(radianAngle);
        }
        for (Vector3f vertex: vertices){
            rotationMatrix.transform(vertex);
        }
    }


    public static void scale(List<Vector3f> vertices,Vector3f scaleVector) {
        Matrix4f scaleMatrix = new Matrix4f();
        scaleMatrix.setIdentity(); // создали единичную матрицу

        // Установка масштабных коэффициентов на диагонали матрицы(типа 00 11 22 корды на матрице пон да)
        scaleMatrix.m00 = scaleVector.x;
        scaleMatrix.m11 = scaleVector.y;
        scaleMatrix.m22 = scaleVector.z;

        // Применение матрицы масштабирования ко всем вершинам модели
        for (Vector3f vertex : vertices) {
            scaleMatrix.transform(vertex);
        }
    }
    public static void translate(List<Vector3f> vertices, Vector3f translationVector) {
        // Применить вектор перемещения ко всем вершинам
        Matrix4f translateMatrix = new Matrix4f();
        translateMatrix.setIdentity();


        translateMatrix.m03 = translationVector.x;
        translateMatrix.m13 = translationVector.y;
        translateMatrix.m23 = translationVector.z;
        //translateMatrix.m33 = 1;

        for (Vector3f vertex : vertices) {
            Vector4f vertex4f =  new Vector4f(vertex.x, vertex.y, vertex.z,1);
            translateMatrix.transform(vertex4f);

            vertex.x = vertex4f.x;
            vertex.y = vertex4f.y;
            vertex.z = vertex4f.z;
        }
    }
    public static void rotateScaleTranslate(){

    }
}
