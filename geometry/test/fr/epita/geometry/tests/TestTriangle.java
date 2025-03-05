package fr.epita.geometry.tests;

import fr.epita.geometry.datamodel.Triangle;

public class TestTriangle {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(100.0, 10.0, 5.0, 5.0);

        //get area: we should expect 100 * 10 / 2 = 500.0
        System.out.println(triangle.getArea());

    }
}
