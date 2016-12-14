/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import task9drawing.Controller.DrawingController;
import task9drawing.Controller.DrawingWindow;
import task9drawing.Controller.MenuController;
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
      DrawingWindow window = new DrawingWindow(view);
      DrawingController controller = new DrawingController(view, model);
      controller.registerEvents();
      MenuController pcontroller = new MenuController(window, model);
      pcontroller.registerEvents();
      pcontroller.registerCommands();
      window.setVisible(true);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) 
  {
        try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
    new Start();
  }
}
