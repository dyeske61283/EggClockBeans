/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.View;

import Logger.OhmLogger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import task9drawing.Model.DrawingModel;
import task9drawing.Model.Figur;

/**
 *
 * @author kevin
 */
public class DrawingView extends JComponent
{
  private static OhmLogger lg;
  private DrawingModel model;
  private Rectangle2D.Double pixel;
  private Dimension eins;
  
  public DrawingView(DrawingModel model)
  {
    this.model = model;
    this.setBackground(Color.WHITE);
    pixel = new Rectangle2D.Double();
    eins = new Dimension(1, 1);
    lg = OhmLogger.getInstance();
    lg.getLogger().info("Begin of logging in view");
  }
  
  public void paintComponent(Graphics g)
  {
    lg.getLogger().info("repaint");
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    this.drawAllPoints(g2);
  }
  
  public void drawPoint(Point p)
  {
    Graphics g = this.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    pixel.setFrame(p, eins);
    g2.draw(pixel);
    g.dispose();
  }

  private void drawAllPoints(Graphics2D g2)
  {
    double x1 = 0,y1 = 0, y2 = 0, x2 = 0;
    Boolean first = false;
    for(Figur f:model.getDaten())
    {
      for(Point p:f.getDaten())
      {
        if(! first)
        {
          x1 = p.getX();
          y1 = p.getY();
          first = true;
        }
        else
        {
          x2 = p.getX();
          y2 = p.getY();
          
          g2.draw(new Line2D.Double(x1, y1, x2, y2));
          x1 = x2;
          y1 = y2;
        }
      }
    }
  }
}
