
/**
 * Maman 12 , second question.
 * "RectangleA"
 * Name: @David Nalivkin
 * TZ:332403468
 * That class describe rectangle in cartesian system. And have methods to influence on rectangle.
 */
public class RectangleA
{
    public static void main(String[]args){
        System.out.println("////////////////////");
        RectangleA r1 = new RectangleA(5,5);
        Point p1 = new Point(2,2);
        Point p2 = new Point(10,10);
        RectangleA r2 = new RectangleA(p1,5,5);
        RectangleA r3 = new RectangleA(p1,p2);
        RectangleA r4 = new RectangleA(r1);
        System.out.println("////////////////////");
        System.out.println(r1);
        System.out.println(r3);
        System.out.println(r3.getDiagonalLength());
        //////////////////////////////////
        Point p01 = new Point(5,5);
        Point p02 = new Point(10,10);
        Point p03 = new Point(2,2);
        Point p04 = new Point(5,5);
        RectangleA r01 = new RectangleA(p01,p02);
        RectangleA r02 = new RectangleA(p03,p04);
        if(r01.overlap(r02))System.out.println("r02 inside r01");
        /////////////////////////////////
        Point p05 = new Point(15,15);
        Point p06 = new Point(10,10);
        RectangleA r03 = new RectangleA(p05,p06);
        if(r01.overlap(r03))System.out.println("r03 inside r01");
        ////////////////////////////////////////
        Point p07 = new Point(20,1);
        Point p08 = new Point(10,5);
        RectangleA r04 = new RectangleA(p07,p08);
        if(r01.overlap(r04))System.out.println("r04 inside r01");
        Point p09 = new Point(15,15);
        Point p010 = new Point(10,10);
        RectangleA r05 = new RectangleA(p09,p010);
        if(r01.overlap(r05))System.out.println("r05 inside r01");
        Point p011 = new Point(15,15);
        Point p012 = new Point(11,11);
        RectangleA r06 = new RectangleA(p011,p012);
        if(r01.overlap(r06))System.out.println("r06 inside r01");
        System.out.println("//////////////////////////////////");
        Point P1 = new Point(5,5);
        Point P2 = new Point(10,10);
        Point P3 = new Point(5,5);
        Point P4 = new Point(2,2);
        System.out.println("//////////////////////////////////");
        RectangleA R1 = new RectangleA(P1,P2);
        RectangleA R2 = new RectangleA(P3,P4);
        System.out.println("//////////////////////////////////");
        if(R2.isIn(R1))System.out.println("v");else System.out.println("x");
        System.out.println("//////////////////////////////////");
    }
    // instance variables
    private int _width, _height;
    private Point _pointSW;
    /** Constructor 1
     * Constructor for objects of class RectangleA
     * @param w - width of rectangle
     * @param h - height of rectangle
     */
    public RectangleA(int w, int h)
    {
        _pointSW = new Point(0,0);
        if(w > 0 && h > 0){
            _width = w;
            _height = h;
        }
        else if(w < 0)
            _width = 1;
        else if(h < 0)
            _height = 1;
    }

    /** Constructor 2
     * Constructor for objects of class RectangleA
     * @param p - SW point of rectangle
     * @param w - width of rectangle
     * @param h - height of rectangle
     */
    public RectangleA(Point p, int w, int h)
    {
        if(w > 0 && h > 0){
            _width = w;
            _height = h;
        }
        else if(w < 0)
            _width = 1;
        else if(h < 0)
            _height = 1;
        _pointSW = new Point(p);
    }

    /** Constructor 3
     * Constructor for objects of class RectangleA
     * @param sw - one of the points (SW)
     * @param ne - one of the points (NE)
     */
    public RectangleA(Point sw, Point ne)
    {
        _width = ne.getX() - sw.getX();
        _height = ne.getY() - sw.getY();
        _pointSW = new Point(sw);
    }

    /** Constructor 4 copy constructor
     * Constructor for objects of class RectangleA
     * @param r - other rectangle
     */
    public RectangleA(RectangleA r)
    {
        _width = r._width;
        _height = r._height;
        _pointSW = new Point(r._pointSW);
    }

    /** getWidth
     * Method that get width of rectangle.
     * 
     * @return width of rectangle
     */
    public int getWidth()
    {
        return _width;
    }

    /** getHeight
     * Method that get height of rectangle.
     *
     * @return height of rectangle
     */
    public int getHeight()
    {
        return _height;
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
        if(w >= 0) _width = w;
    }

    /** setHeight
     * Method set new value of height
     *
     * @param w - new height of rectangle
     */
    public void setHeight(int h)
    {
        if(h >= 0) _width = h;
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
        return "Width=" + _width + " Height=" + _height + " PointSW=("+ _pointSW.getX() + "," + _pointSW.getY() + ")";
    }

    /** getPerimeter
     * Method that calculate perimeter of rectangle.
     *
     * @return perimeter of rectangle
     */
    public int getPerimeter()
    {
        return (_width * 2) + (_height * 2);
    }

    /** getArea
     * Method that calculate area of rectangle.
     *
     * @return area of rectangle
     */
    public int getArea()
    {
        return _width * _height;
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
        if(_pointSW.getX()+deltaX >= 0)_pointSW.setX(_pointSW.getX()+deltaX);
        if(_pointSW.getY()+deltaY >= 0)_pointSW.setY(_pointSW.getY()+deltaY);
    }

    /** equals
     * Method that check if 2 rectangles are equals.
     *
     * @param other - other rectangle that compare with
     * @return  true if rectangles are equals
     */
    public boolean equals(RectangleA other)
    {
        return _pointSW.equals(other._pointSW) && _width == other._width && _height == other._height;
    }

    /** getDiagonalLength
     * Method that calculate diagonal of rectangle
     *
     * @return  diagonal of rectangle
     */
    public double getDiagonalLength()
    {
        return Math.sqrt(Math.pow(_width,2)+Math.pow(_height,2));
    }

    /** isLarger
     * Method that checks if rectangle is larger
     *
     * @param   other - rectangle that we copmare with
     * @return  if rectangle is larger
     */
    public boolean isLarger(RectangleA other)
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
        return new Point(_pointSW.getX() + _width , +_pointSW.getY() + _height);        
    }

    /** changeSides
     * Method that change sides of rectangle
     *
     * @return  rectangle with changed sides
     */
    public void changeSides()
    {
        int temp = _width;
        _width = _height;
        _height = temp;
    }

    /** isIn
     * Method that checks if rectangle are have other rectangle inside.
     *
     * @param   r - rectangle that checks with
     * @return  true if rectangle are inside.
     */
    public boolean isIn(RectangleA r)
    {
        return _pointSW.getX() <= r._pointSW.getX() && _pointSW.getY() <= r._pointSW.getY() && this.getPointNE().getX() >= r.getPointNE().getX() && this.getPointNE().getY() >= r.getPointNE().getY();
    }

    /** overlap
     * Method that checks if both rectangles have same points
     *
     * @param   r - rectangle that checks with
     * @return  true if rectangles have same points
     */
    public boolean overlap(RectangleA r)
    {
        boolean sw_between_x = !r._pointSW.isLeft(_pointSW) && !r._pointSW.isRight(this.getPointNE());
        boolean sw_between_y = !r._pointSW.isUnder(_pointSW) && !r._pointSW.isAbove(this.getPointNE());
        boolean ne_between_x = !r.getPointNE().isLeft(_pointSW) && !r.getPointNE().isRight(this.getPointNE());
        boolean ne_between_y = !r.getPointNE().isUnder(_pointSW) && !r.getPointNE().isAbove(this.getPointNE());
        return (sw_between_y && sw_between_x) || (ne_between_y && ne_between_x) || (sw_between_y && ne_between_x) || (ne_between_y && sw_between_x);
    }

}
