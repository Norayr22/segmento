package com.segmento.Test.CLasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.segmento.triangle.classes.MockTriangleFactory;
import com.segmento.triangle.classes.TriangleAttribute;
import com.segmento.triangle.classes.Vertex;


public class TriangleTest {




	@Test()
	public void test1() {
		MockTriangleFactory factory = new MockTriangleFactory();

		TriangleAttribute attribute = new TriangleAttribute();


		Vertex vertex1 = new Vertex(0, 0);
		Vertex vertex2 = new Vertex(3, 4);
		Vertex vertex3 = new Vertex(4, 0);
		//	    по данным кординатам можно строить треугольник(5,4,4)
		//		(0,0,0) это стороны треугольника


		factory.setVertex1(vertex1);
		factory.setVertex2(vertex2);
		factory.setVertex3(vertex3);

		boolean actual = attribute.isTriangle(factory.getTriangle());

		assertEquals(actual, true);
	}


	@Test()
	public void test2() {
		MockTriangleFactory factory = new MockTriangleFactory();

		TriangleAttribute attribute = new TriangleAttribute();


		Vertex vertex1 = new Vertex(0, 0);
		Vertex vertex2 = new Vertex(10, 10);
		Vertex vertex3 = new Vertex(4, 4);
		//	    по данным кординатам не можно строить треугольник
		//		как видно из него не можно получить треугольник,так как сумма двух сторон меньше чем третьая сторона



		factory.setVertex1(vertex1);
		factory.setVertex2(vertex2);
		factory.setVertex3(vertex3);

		boolean actual = attribute.isTriangle(factory.getTriangle());

		assertEquals(actual, false);
	}


	@Test()
	public void test3() {
		MockTriangleFactory factory = new MockTriangleFactory();

		TriangleAttribute attribute = new TriangleAttribute();


		Vertex vertex1 = new Vertex(0, 0);
		Vertex vertex2 = new Vertex(0, 0);
		Vertex vertex3 = new Vertex(0, 0);
		//	    по данным кординатам не можно строить треугольник(0,0,0)
		//		(0,0,0) это стороны треугольника
		//		как видно из него не можно получить треугольник


		factory.setVertex1(vertex1);
		factory.setVertex2(vertex2);
		factory.setVertex3(vertex3);

		boolean actual = attribute.isTriangle(factory.getTriangle());

		assertEquals(actual, false);
	}


}


