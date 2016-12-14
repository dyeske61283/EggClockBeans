/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Controller;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JOptionPane;
import task9drawing.Model.DrawingModel;

/**
 *
 * @author kevin
 */
public class CommandPrint implements CommandInterface
{
  private DrawingModel model;
  private DrawingWindow view;
  
  public CommandPrint(DrawingModel model, DrawingWindow view)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    HashPrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
      PrinterJob pj = PrinterJob.getPrinterJob();
      pj.setPrintable(this.view.getDrawingView());
      try
      {
        if(pj.printDialog(aset))
        {
          pj.print(aset);
        }
      }
      catch(PrinterException pe)
      {
        JOptionPane.showMessageDialog(this.view,pe);
      }
  }

}
