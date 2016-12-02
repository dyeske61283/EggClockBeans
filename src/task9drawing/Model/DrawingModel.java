/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Model;

import Logger.OhmLogger;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class DrawingModel
{
  private ArrayList<Figur> daten;
  private Figur neueFigur;
  private static Logger lg;
  
  public DrawingModel()
  {
      daten = new ArrayList<>();
      lg = OhmLogger.getLogger();
      lg.info("Begin of logging in model");
  }
  
  public void addPoint(Point p)
  {
    neueFigur.addPoint(p);
    lg.info("Added new point to new figure in model");
  }
  
  public void addFigure()
  {
    neueFigur = new Figur();
    daten.add(neueFigur);
    lg.info("Added new figure to model");
  }
  
  public ArrayList<Figur> getDaten()
  {
    return daten;
  }
  
  public Figur getNeueFigur()
  {
    return neueFigur;
  }
}
