
/**
 * Maman 12 , first question.
 * "Point"
 * Name: @David Nalivkin
 * TZ:332403468
 * That class describe point on cartesian system. And have methods to influence on point.
 */
public class Point
{
    // instance variables
    private int _x, _y;
    /** Constructor 1
     * Constructor that recieve coordinates x and y and build point.
     * @param  y - y coordinate of point
     * @param  x - x coordinate of point
     */
    public Point(int x, int y)
    {
        _x = x;
        _y = y;
    }

    /** Constructor 2 (Copy constructor)
     * Copy constructor that recive point and copy to new point
     * @param  other - point that we copy
     */
    public Point(Point other)
    {
        _x = other._x;
        _y = other._y;
    }

    /** getX
     * Method that return coordinate x of point.
     * @return    _x - x coordinate of point
     */
    public int getX()
    {
        return _x;
    }

    /** getY
     *Method that return coordinate y of point.
     * @return    _y - y coordinate of point
     */
    public int getY()
    {
        return _y;
    }

    /** setX
     * Method that change coordinate x to recieved number.
     * @param  num - new coordinate of x
     */
    public void setX(int num)
    {
        _x = num;
    }

    /** setY
     * Method that change coordinate y to recieved number.
     * @param  num - new coordinate of y
     */
    public void setY(int num)
    {
        _y = num;        
    }

    /** toString
     * Override method of String that return format of point coordinate.
     * @return String that describe point "(x,y)"
     * @override
     */
    public String toString()
    {
        return "("+ _x +"," + _y + ")";
    }

    /** equals
     * Compare 2 points if they equals.
     * @param  other - Point to compare with
     * @return  value of comparing
     */
    public boolean equals(Point other)
    {
        return this._x == other._x && this._y == other._y;
    }

    /** isAbove
     * Method check if a point is above that one we recieve.
     * @param  other - point to compare with
     * @return  value of comparing
     */
    public boolean isAbove(Point other)
    {   
        return this._y > other._y;
    }

    /** isUnder
     * Method check if a point is under that one we recieve.
     * @param  other - point to compare with
     * @return  value of comparing
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }

    /** isLeft
     * Method check if a point to the left that one we recieve.
     * @param  other - point to compare with
     * @return  value of comparing
     */
    public boolean isLeft(Point other)
    {
        return this._x < other._x;
    }

    /** isRight
     * Method check if a point to the right that one we recieve.
     * @param  other - point to compare with
     * @return  value of comparing
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }

    /** move 
     * Method that move point with values of delta that we recieve.
     * @param  deltaX - value that we move x cordinate
     * @param  deltaY - value that we move y cordinate
     */
    public void move(int deltaX, int deltaY)
    {
        if(this._x + deltaX >= 0)this._x += deltaX;
        if(this._y + deltaY >= 0)this._y += deltaY;
    }

    /** distance
     * Method that count a distance between 2 points.
     *
     * @param  p - point that we receive to count distance
     * @return  distance between points
     */
    public double distance(Point p)
    {
        return Math.sqrt(Math.pow(this._x - p._x,2)+Math.pow(this._y - p._y,2));
    }

}
