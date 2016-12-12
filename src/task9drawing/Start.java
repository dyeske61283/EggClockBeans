/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import task9drawing.Controller.DrawingController;
import task9drawing.Model.DrawingModel;
import task9drawing.View.DrawingView;

/**
 * Builder Class
 * @author kevin
 */
public class Start
{
  public Start()
  {
      DrawingModel model = new DrawingModel();
      DrawingView view = new DrawingView(model);
      DrawingController controller = new DrawingController(view, model);
      controller.registerEvents();
      JFrame frm = new JFrame();
      frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frm.setContentPane(view);
      frm.setSize(600, 800);
      frm.setTitle("MyPaint");
      frm.setVisible(true);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) 
  {
    new Start();
  }
}
