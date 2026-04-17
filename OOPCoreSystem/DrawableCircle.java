// ==== MULTIPLE INHERITANCE VIA INTERFACES ====
// WHAT: Class extends one class, implements multiple interfaces
// WHEN: Need IS-A relationship + multiple capabilities
// HOW: extends ClassName implements Interface1, Interface2

public class DrawableCircle extends Circle implements Drawable, Resizable {
    
    private int xPosition;
    private int yPosition;
    private boolean isVisible;
    
    // ==== CONSTRUCTOR ====
    public DrawableCircle(double radius, int x, int y) {
        super(radius);
        this.xPosition = x;
        this.yPosition = y;
        this.isVisible = true;
    }
    
    // ==== IMPLEMENT Drawable INTERFACE ====
    @Override
    public void draw() {
        if (isVisible) {
            System.out.println("Drawing circle at (" + xPosition + "," + yPosition + ")");
            System.out.println("Radius: " + getRadius() + ", Color: " + getColor());
        }
    }
    
    @Override
    public void draw(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
        draw();
    }
    
    @Override
    public String getDescription() {
        return "Circle[r=" + getRadius() + ", pos=(" + xPosition + "," + yPosition + ")]";
    }
    
    // ==== IMPLEMENT Resizable INTERFACE ====
    @Override
    public void resize(double scale) {
        // Use inherited scale method
        scale(scale);
    }
    
    @Override
    public void resize(double width, double height) {
        // For circle, use average or max
        double newRadius = (width + height) / 4.0;
        setRadius(newRadius);
    }
    
    @Override
    public boolean canResizeTo(double width, double height) {
        double neededRadius = Math.max(width, height) / 2.0;
        return neededRadius <= MAX_SIZE / 2.0;  // Interface constant
    }
    
    // ==== ADDITIONAL METHODS ====
    public void moveTo(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
    
    public void hide() {
        isVisible = false;
    }
    
    public void show() {
        isVisible = true;
    }
    
    public int getX() {
        return xPosition;
    }
    
    public int getY() {
        return yPosition;
    }
}
