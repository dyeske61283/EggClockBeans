/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class MenuController implements ActionListener
{
  private DrawingWindow view;
  private CommandInvoker invoker;
  
  public MenuController(DrawingWindow view)
  {
      this.view = view;
  }
  
  public void registerEvents()
  {
      view.getMiPrint().addActionListener(this);
      view.getMiLoad().addActionListener(this);
      view.getMiSave().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == this.view.getMiPrint())
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
}
