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
  private OhmLogger lg;
  
  
  public DrawingController(DrawingView view, DrawingModel model)
  {
    this.view = view;
    this.model = model;
    lg = OhmLogger.getInstance();    
    lg.getLogger().info("Begin of logging in controller");
  }
  
  public void registerEvents()
  {
    view.addMouseMotionListener(this);
    view.addMouseListener(this);
    lg.getLogger().info("Added Listeners to the view");
  }

  @Override
  public void mouseDragged(MouseEvent me)
  {
    if(model.getNeueFigur() == null)
    {
      model.addFigure();
    }
    Point p = me.getPoint();
    Point p2 = model.getNeueFigur().getNeuerPunkt();
    if(p2 != null)
    {
      view.drawPoint(p2,p);
    }
    model.addPoint(p);
    lg.getLogger().info("Mouse got dragged");
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
  }

  @Override
  public void mouseReleased(MouseEvent me)
  {
    model.resetFigure();
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
