package com.segmento.triangle.classes;


public class MockTriangleFactory implements TriangleFactory {
	private Vertex vertex1;
	private Vertex vertex2;
	private Vertex vertex3;

	public Polygon getTriangle() {
		return new Polygon(vertex1, vertex2, vertex3);

	}

	public void setVertex1(Vertex vertex1) {
		this.vertex1 = vertex1;
	}

	public void setVertex2(Vertex vertex2) {
		this.vertex2 = vertex2;
	}

	public void setVertex3(Vertex vertex3) {
		this.vertex3 = vertex3;
	}



}
