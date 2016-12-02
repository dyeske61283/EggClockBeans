/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Controller;

import Logger.OhmLogger;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Logger;
import task9drawing.Model.DrawingModel;
import task9drawing.View.DrawingView;

/**
 *
 * @author kevin
 */
public class DrawingController implements MouseMotionListener, MouseListener
{
  private DrawingView view;
  private DrawingModel model;
  private static Logger lg;
  
  
  public DrawingController(DrawingView view, DrawingModel model)
  {
    this.view = view;
    this.model = model;
    lg = OhmLogger.getLogger();
    lg.info("Begin of logging in controller");
  }
  
  public void registerEvents()
  {
    view.addMouseMotionListener(this);
    view.addMouseListener(this);
    lg.info("Added Listeners to the view");
  }

  @Override
  public void mouseDragged(MouseEvent me)
  {
    Point p = me.getPoint();
    model.addPoint(p);
    lg.info("Mouse got dragged");
  }

  @Override
  public void mouseMoved(MouseEvent me)
  {
  }

  @Override
  public void mouseClicked(MouseEvent me)
  {
  }

  @Override
  public void mousePressed(MouseEvent me)
  {
    model.addFigure();
    lg.info("Mouse got pressed");
  }

  @Override
  public void mouseReleased(MouseEvent me)
  {
  }

  @Override
  public void mouseEntered(MouseEvent me)
  {
  }

  @Override
  public void mouseExited(MouseEvent me)
  {
  }
}
