/**
 * Maman 12 , third question.
 * "RectangleB"
 * Name: @David Nalivkin
 * TZ:332403468
 * That class describe rectangle in cartesian system. And have methods to influence on rectangle.
 */
public class RectangleB
{
    public static void main(String[]args){
        /////////////////////////////////////////////////
        Point p1 = new Point(2,2);
        Point p2 = new Point(7,10);
        Point p3 = new Point(0,0);
        RectangleB r1 = new RectangleB(5,8);
        RectangleB r2 = new RectangleB(p3,5,8);
        RectangleB r2_3 = new RectangleB(p1,5,8);
        RectangleB r3 = new RectangleB(p1,p2);
        /////////////////////////////////////////////////
        if(r1.equals(r2))System.out.println("v");else System.out.println("x");
        if(r2.equals(r1))System.out.println("v");else System.out.println("x");
        if(r2_3.equals(r3))System.out.println("v");else System.out.println("x");
        if(r3.equals(r2_3))System.out.println("v");else System.out.println("x");
        //////////////////////
        System.out.println("//////////////////////////////////");
        Point P1 = new Point(5,5);
        Point P2 = new Point(10,10);
        Point P3 = new Point(5,5);
        Point P4 = new Point(2,2);
        System.out.println("//////////////////////////////////");
        RectangleB R1 = new RectangleB(P1,P2);
        RectangleB R2 = new RectangleB(P3,P4);
        System.out.println("//////////////////////////////////");
        if(R2.isIn(R1))System.out.println("v");else System.out.println("x");
        System.out.println("//////////////////////////////////");
    }
    // instance variables
    private Point _pointSW, _pointNE;

    /** Constructor 1
     * Constructor for objects of class RectangleB
     * @param w - width of rectangle
     * @param h - height of rectangle
     */
    public RectangleB(int w, int h)
    {
        _pointSW = new Point(0,0);
        if(w >= 0 && h >= 0)_pointNE = new Point(w,h);
        else if(w >= 0)_pointNE = new Point(w,1);
        else if(h >= 0)_pointNE = new Point(1,h);
    }

    /** Constructor 2
     * Constructor for objects of class RectangleB
     * @param p - SW point of rectangle
     * @param w - width of rectangle
     * @param h - height of rectangle
     */
    public RectangleB(Point p, int w, int h)
    {
        _pointSW = new Point(p);
        if(w >= 0 && h >= 0)_pointNE = new Point(p.getX() + w , p.getY() + h);
        else if(w >= 0)_pointNE = new Point(p.getX() + w , p.getY() + 1);
        else if(h >= 0)_pointNE = new Point(p.getX() + 1, p.getY() + h);
    }

    /** Constructor 3
     * Constructor for objects of class RectangleB
     * @param sw - one of the points (SW)
     * @param ne - one of the points (NE)
     */
    public RectangleB(Point sw, Point ne)
    {
        _pointSW = new Point(sw);
        _pointNE = new Point(ne);
    }

    /** Constructor 4 copy constructor
     * Constructor for objects of class RectangleB
     * @param r - other rectangle
     */
    public RectangleB(RectangleB r)
    {
        _pointSW = new Point(r._pointSW);
        _pointNE = new Point(r._pointNE);
    }

    /** getWidth
     * Method that get width of rectangle.
     * 
     * @return width of rectangle
     */
    public int getWidth()
    {
        return _pointNE.getX() - _pointSW.getX();
    }

    /** getHeight
     * Method that get height of rectangle.
     *
     * @return height of rectangle
     */
    public int getHeight()
    {
        return  _pointNE.getY() - _pointSW.getY();
    }

    /** getPointSW
     * Method that get point of rectangle.
     *
     * @return point of rectangle
     */
    public Point getPointSW()
    {
        return new Point(_pointSW);
    }

    /** setWidth
     * Method set new value of width
     *
     * @param w - new width of rectangle
     */
    public void setWidth(int w)
    {
        if(w > 0) _pointNE.setX(_pointSW.getX() + w);
    }

    /** setHeight
     * Method set new value of height
     *
     * @param w - new height of rectangle
     */
    public void setHeight(int h)
    {
        if(h > 0) _pointNE.setY(_pointSW.getY() + h);
    }

    /** setPointSW
     * Method set new value of point
     *
     * @param  p - new value of point
     */
    public void setPointSW(Point p)
    {
        _pointSW = new Point (p);
    }

    /** toString
     * That method print rectangle such a "Width=w Height=h PointSW=(x,y)"
     *
     * @return print of rectangle
     * @override
     */
    public String toString()
    {
        return "Width=" + this.getWidth() + " Height=" + this.getHeight() + " PointSW=("+ _pointSW.getX() + "," + _pointSW.getY() + ")";
    }

    /** getPerimeter
     * Method that calculate perimeter of rectangle.
     *
     * @return perimeter of rectangle
     */
    public int getPerimeter()
    {
        return (this.getWidth() * 2) + (this.getHeight() * 2);
    }

    /** getArea
     * Method that calculate area of rectangle.
     *
     * @return area of rectangle
     */
    public int getArea()
    {
        return this.getWidth() * this.getHeight();
    }

    /** move
     * Method that move rectangle.
     *
     * @param deltaX - delta that move rectangle on x axis
     * @param deltaY - delta that move rectangle on y axis
     * @return new place of rectangle
     */
    public void move(int deltaX, int deltaY)
    {
        if(this.getWidth() + deltaX >= 0){
            _pointSW.setX(_pointSW.getX()+deltaX);
            _pointNE.setX(_pointNE.getX()+deltaX);
        }
        if(this.getHeight() + deltaY >= 0){
            _pointSW.setY(_pointSW.getY()+deltaY);
            _pointNE.setY(_pointNE.getY()+deltaY);
        }
    }

    /** equals
     * Method that check if 2 rectangles are equals.
     *
     * @param other - other rectangle that compare with
     * @return  true if rectangles are equals
     */
    public boolean equals(RectangleB other)
    {
        return _pointSW.equals(other._pointSW) && _pointNE.equals(other._pointNE);
    }

    /** getDiagonalLength
     * Method that calculate diagonal of rectangle
     *
     * @return  diagonal of rectangle
     */
    public double getDiagonalLength()
    {
        return Math.sqrt(Math.pow(_pointNE.getX() - _pointSW.getX(),2)+Math.pow(_pointNE.getY() - _pointSW.getY(),2));
    }

    /** isLarger
     * Method that checks if rectangle is larger
     *
     * @param   other - rectangle that we copmare with
     * @return  if rectangle is larger
     */
    public boolean isLarger(RectangleB other)
    {
        return this.getArea() > other.getArea(); 
    }

    /** getPointNE
     * Method that show NE point of rectangle
     *
     * @return  NE point of rectamgle
     */
    public Point getPointNE()
    {
        return new Point(_pointNE);        
    }

    /** changeSides
     * Method that change sides of rectangle
     *
     * @return  rectangle with changed sides
     */
    public void changeSides()
    {
        _pointNE = new Point(_pointSW.getX() +  this.getWidth() , _pointSW.getY() +  this.getWidth());
    }

    /** isIn
     * Method that checks if rectangle are have other rectangle inside.
     *
     * @param   r - rectangle that checks with
     * @return  true if rectangle are inside.
     */
    public boolean isIn(RectangleB r)
    {
        boolean sw_in_y = _pointSW.isAbove(r.getPointSW()) && _pointSW.isUnder(r.getPointNE());
        boolean ne_in_y = _pointNE.isAbove(r.getPointSW()) && _pointNE.isUnder(r.getPointNE());
        boolean sw_in_x = _pointSW.isRight(r.getPointSW()) && _pointSW.isLeft(r.getPointNE());
        boolean ne_in_x = _pointNE.isRight(r.getPointSW()) && _pointNE.isLeft(r.getPointNE());
        return sw_in_y && ne_in_y && sw_in_x && ne_in_x;
    }

    /** overlap
     * Method that checks if both rectangles have same points
     *
     * @param   r - rectangle that checks with
     * @return  true if rectangles have same points
     */
    public boolean overlap(RectangleB r)
    {
        boolean sw_between_y = !r.getPointSW().isAbove(_pointNE) && !r.getPointSW().isUnder(_pointSW);
        boolean ne_between_y = !r.getPointNE().isAbove(_pointNE) && !r.getPointNE().isUnder(_pointSW);
        boolean sw_between_x = !r.getPointSW().isRight(_pointNE) && !r.getPointSW().isLeft(_pointSW);
        boolean ne_between_x = !r.getPointNE().isRight(_pointNE) && !r.getPointNE().isLeft(_pointSW);
        return (sw_between_y && sw_between_x) || (ne_between_y && ne_between_x) || (sw_between_y && ne_between_x) || (ne_between_y && sw_between_x);
    }
}
