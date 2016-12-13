/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Controller;

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
  }

}
