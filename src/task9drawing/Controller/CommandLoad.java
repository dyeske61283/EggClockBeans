/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import task9drawing.Model.DrawingModel;

/**
 *
 * @author kevin
 */
public class CommandLoad implements CommandInterface
{
  private DrawingModel model;
  private DrawingWindow view;
  
  public CommandLoad(DrawingModel model, DrawingWindow view)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    JFileChooser fcLoad = new JFileChooser(this.model.getFilePath());
    if(fcLoad.showOpenDialog(this.view)==JFileChooser.APPROVE_OPTION)
    {
      try
      {
        this.model.readData(fcLoad.getSelectedFile());
      }
      catch (IOException ex)
      {
        Logger.getLogger(CommandLoad.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (ClassNotFoundException ex)
      {
        Logger.getLogger(CommandLoad.class.getName()).log(Level.SEVERE, null, ex);
      }
      this.model.setFilePath(fcLoad.getSelectedFile().getAbsolutePath());
      this.view.getDrawingView().repaint();
    }
  }

}
