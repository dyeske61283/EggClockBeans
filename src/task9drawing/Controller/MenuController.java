/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import task9drawing.Model.DrawingModel;

/**
 *
 * @author kevin
 */
public class MenuController implements ActionListener
{
  private DrawingWindow view;
  private DrawingModel model;
  private CommandInvoker invoker;
  
  public MenuController(DrawingWindow view, DrawingModel model)
  {
      this.view = view;
      this.model = model;
      this.invoker = new CommandInvoker();
  }
  
  public void registerEvents()
  {
      view.getMiPrint().addActionListener(this);
      view.getMiLoad().addActionListener(this);
      view.getMiSave().addActionListener(this);
  }
  
  public void registerCommands()
  {
    this.invoker.addCommand(view.getMiLoad(), new CommandLoad(model, view));
    this.invoker.addCommand(view.getMiPrint(), new CommandPrint(model, view));
    this.invoker.addCommand(view.getMiSave(), new CommandSave(model, view));
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    Component key = (Component)e.getSource();
    this.invoker.executeCommand(key);
  }
}
