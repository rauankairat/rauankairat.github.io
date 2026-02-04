public class Rectangle {


    private int x;
    private int y;
    private int height;
    private int width;


    public Rectangle(){
        this(0,0,1,1);
    }

    public Rectangle(int x, int y, int height, int width){

        if (height <= 0 || width <=0 ){
            throw new IllegalArgumentException("width and height should be positive");
        }

        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;

    }
    public  int getHeight(){
        return height;

    }
    public int getWidth(){
        return width;

    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){

        this.y = y;
    }

    public void setHeight(int height){
        if(height <= 0){
            throw new IllegalArgumentException("Only positive");
        }
        this.height = height;
    }
    public void setWidth(int width){
        if( width <= 0){
            throw new IllegalArgumentException("Only positive");
        }
        this.width = width;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Rectangle)) return false;

        Rectangle r = (Rectangle) o;

        return this.x == r.x &&
                this.y == r.y &&
                this.width == r.width &&
                this.height == r.height;
    }

    public int getArea(){
        return height * width;
    }

    public boolean contains(Rectangle other) {
        if (other == null) {
            return false;
        }

        if (other.x >= this.x &&
                other.y >= this.y &&
                other.x + other.width <= this.x + this.width &&
                other.y + other.height <= this.y + this.height) {
            return true;
        }
        return false;
    }
}

________________________________________________________________________


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {



    @Test
    void rectangleConstructor(){

        Rectangle r = new Rectangle(2,2,4,4);
        assertEquals(2, r.getX());
        assertEquals(2, r.getY());
        assertEquals(4, r.getHeight());
        assertEquals(4, r.getWidth());

    }

    @Test
    void CheckHeightAndWidth(){
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0,0,-1,1));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0,0,1,-1));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0,0,0,1));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0,0,1,0));
    }

    @Test
    void DefaultRectangle(){
        Rectangle r = new Rectangle();
        assertEquals(0, r.getX());
        assertEquals(0, r.getY());
        assertEquals(1, r.getHeight());
        assertEquals(1, r.getWidth());

    }

    @Test
    void modifyRectangleLocation(){
        Rectangle r = new Rectangle();
        r.setX(5);
        r.setY(4);

        assertEquals(5, r.getX());
        assertEquals(4, r.getY());

    }

    @Test
    void modifyRectangleSize(){
        Rectangle r = new Rectangle();
        r.setHeight(10);
        r.setWidth(10);

        assertEquals(10, r.getHeight());
        assertEquals(10, r.getWidth());
    }

    @Test
    void CheckHeightAndWidthModification(){
        Rectangle r = new Rectangle();

        assertThrows(IllegalArgumentException.class, () -> r.setWidth(-1));
        assertThrows(IllegalArgumentException.class, () -> r.setHeight(-1));
        assertThrows(IllegalArgumentException.class, () -> r.setWidth(0));
        assertThrows(IllegalArgumentException.class, () -> r.setHeight(0));
    }

    @Test
    void RectangleEquality(){
        Rectangle a = new Rectangle(1,1,2,2);
        Rectangle b = new Rectangle(1,1,2,2);
        Rectangle c = new Rectangle(1,1,3,3);

        assertEquals(a,b);
        assertNotEquals(a,c);
        assertNotEquals(b,c);
    }

    @Test
    void RectangleArea(){
        Rectangle r = new Rectangle(1,1,2,2);
        assertEquals(4, r.getArea());
    }

    @Test
    void containsRectangle(){
        Rectangle a = new Rectangle(1,1,2,2);
        Rectangle b = new Rectangle(0,0,5,5);
        Rectangle c = new Rectangle(4,5,4,5);

        assertTrue(b.contains(a));
        assertTrue(a.contains(a));

        assertFalse(a.contains(b));
        assertFalse(b.contains(c));
        assertFalse(c.contains(b));
        assertFalse(c.contains(a));
    }



}