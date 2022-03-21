public record Point(int x, int y) {	
	public static void main(String[] args) {
		var empty = new Point[] {};
		var singlePoints = new Point[] { new Point(1,1) };
		var fivePoints = new Point[] { new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4), new Point(5,5) };
		System.out.println(Point.displayPoints(empty));
		System.out.println(Point.displayPoints(singlePoints));
		System.out.println(Point.displayPoints(fivePoints));
		
		Point.resetAtOriginAllPointsWithXAt(3, fivePoints);
		System.out.println(Point.displayPoints(fivePoints));
	}
	
	private Point reset() {
		return new Point(0, 0);
	}
	
	public static String displayPoints(Point[] points) {
        int len = points.length;
        StringBuilder display = new StringBuilder();

        display.append(len).append(" point(s): {\n");

        // Le modificateur est le mot-clé static devant le type de retour de la methode
        for(int i = 0; i < len; i++) {
            if(i < len - 1) {
                display.append("(").append(points[i].x).append(",").append(points[i].y).append(") ;\n");
            } else {
                display.append("(").append(points[i].x).append(",").append(points[i].y).append(") }\n");
            }
        }

        return display.toString();
    }
	 
    public static void resetAtOriginAllPointsWithXAt(int targetX, Point[] points) {
        for(Point point: points) {
            if(point.x == targetX) {
                point = point.reset();
            }
            // Dès qu'il sort de la boucle, il n'a plus la mm valeur
        }
    }
}
