/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Model;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class Figur
{
  private ArrayList<Point> daten;
  private Point neuerPunkt;
  
  public Figur()
  {
    daten = new ArrayList<Point>();
  }
  
  public ArrayList<Point> getDaten()
  {
    return daten;
  }
  
  public void addPoint(Point p)
  {
    neuerPunkt = new Point(p);
    daten.add(neuerPunkt);
  }
  
  public Point getNeuerPunkt()
  {
    return neuerPunkt;
  }
}
