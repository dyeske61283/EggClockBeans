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
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JComponent;
import task9drawing.Model.DrawingModel;
import task9drawing.Model.Figur;

/**
 *
 * @author kevin
 */
public class DrawingView extends JComponent implements Printable
{
  private static OhmLogger lg;
  private DrawingModel model;
  private Line2D.Double pixel;
  private Dimension eins;

  public DrawingView(DrawingModel model)
  {
    this.model = model;
    this.setBackground(Color.WHITE);
    pixel = new Line2D.Double();
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

  public void drawPoint(Point p1,Point p2)
  {
    Graphics g = this.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    pixel.setLine(p1, p2);
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

  @Override
  public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException
  {
    if (pageIndex == 0)
    {

      Graphics2D g2d = (Graphics2D) g;

      g2d.translate(pf.getImageableX(), pf.getImageableY());

      g2d.scale(pf.getImageableWidth() / pf.getWidth(), pf.getImageableHeight() / pf.getHeight());

      Color hintergrund = this.getBackground();
      this.setBackground(Color.WHITE);

      try{
        super.print(g2d);
      }
      finally
      {
        this.setBackground(hintergrund);
      }
      return Printable.PAGE_EXISTS;
    }
    else
    {
      return Printable.NO_SUCH_PAGE;
    }
  }
}
