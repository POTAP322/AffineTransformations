package cgvsu.AffineTransformation;
import java.io.*;
import javax.vecmath.*;
import cgvsu.model.Model;

public class AffineTransformations {
    Matrix4d matr4d = new Matrix4d();

    public void rotate(float angle, Vector3f rotationAxis) {
        // Применить поворот ко всем вершинам
    }
    public static void scale(Model model,Vector3f scaleVector) {
        Matrix4f scaleMatrix = new Matrix4f();
        scaleMatrix.setIdentity(); // создали единичная матрциа

        // Установка масштабных коэффициентов на диагонали матрицы(типа 00 11 22 корды на матрице пон да)
        scaleMatrix.m00 = scaleVector.x;
        scaleMatrix.m11 = scaleVector.y;
        scaleMatrix.m22 = scaleVector.z;

        // Применение матрицы масштабирования ко всем вершинам модели
        for (Vector3f vertex : model.vertices) {
            scaleMatrix.transform(vertex);
        }
    }
    public static void translate(Vector3f translationVector) {
        // Применить вектор перемещения ко всем вершинам
    }
}
