/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import task9drawing.Model.DrawingModel;

/**
 *
 * @author kevin
 */
public class CommandSave implements CommandInterface
{
  private DrawingModel model;
  private DrawingWindow view;
  
  public CommandSave(DrawingModel model, DrawingWindow view)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    JFileChooser fcSave = new JFileChooser(this.model.getFilePath());
    fcSave.setDialogTitle("Specify a file to save");
    if(fcSave.showSaveDialog(this.view) == JFileChooser.APPROVE_OPTION)
    {
      File fileToSave = fcSave.getSelectedFile();
      if(fileToSave.exists())
      {
        
      }
      else
      {
        try
        {
          fileToSave.createNewFile();
        }
        catch (IOException ex)
        {
          Logger.getLogger(CommandSave.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      try
      {
        this.model.saveData(fileToSave);
      }
      catch (IOException ex)
      {
        Logger.getLogger(CommandSave.class.getName()).log(Level.SEVERE, null, ex);
      }
      this.model.setFilePath(fileToSave.getAbsolutePath());
    }
  }
  
  
}
