package Structural.Proxy.Dynamic;


public class Client {

	public static void main(String[] args) {
		Image img = ImageFactory.getImage("AI.bmp");

		img.setLocation(new Point2D(-10,0));
		System.out.println("Image location: "+ img.getLocation());
		System.out.println("Rendering image now .....");
		img.render();
	}

}
