public class Pixel {
    public final static int ORIGIN = 0;
    private int x;
    private int y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static void main(String[] args) {
        var p4 = new Point(1,2);
        var p5 = new Point(1,2);
        System.out.println(p4.equals(p5));
        var q1 = new Pixel(1,2);
        var q2 = new Pixel(1,2);
        System.out.println(q1.equals(q2));

        // =====================================

        var empty = new Pixel[] {};
		var singlePixel = new Pixel[] { new Pixel(1,1) };
		var fivePixels = new Pixel[] { new Pixel(1,1), new Pixel(2,2), new Pixel(3,3), new Pixel(4,4), new Pixel(5,5) };
		System.out.println(Pixel.displayPixels(empty));
		System.out.println(Pixel.displayPixels(singlePixel));
		System.out.println(Pixel.displayPixels(fivePixels));
		
		Pixel.resetAtOriginAllPixelsWithXAt(3, fivePixels);
		System.out.println(Pixel.displayPixels(fivePixels));
    }

    public void reset() {
        x = ORIGIN;
        y = ORIGIN;
    }

    public void printOnScreen() {
        System.out.println("(" + x + "," + y + ")");
    }

    public static String displayPixels(Pixel[] pixels) {
		int len = pixels.length;
        StringBuilder display = new StringBuilder();
        
        if(len == 0) { return ""; }
        
        display.append(len).append(" pixel(s): {\n");

        // Le modificateur est le mot-clé static devant le type de retour de la methode
        for(int i = 0; i < len; i++) {
            if(i < len - 1) {
            	display.append("(").append(pixels[i].x).append(",").append(pixels[i].y).append(") ;\n");
            } else {
            	display.append("(").append(pixels[i].x).append(",").append(pixels[i].y).append(") }\n");
            }
        }

        return display.toString();
    }
	
	public static void resetAtOriginAllPixelsWithXAt(int targetX, Pixel[] pixels) {
        for(Pixel pixel: pixels) {
            if(pixel.x == targetX) {
                pixel.reset();
            }
        }
    }
}
