/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9drawing.Controller;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import task9drawing.View.DrawingView;

/**
 *
 * @author kevin
 */
public class DrawingWindow extends JFrame
{
  private DrawingView view;
  private JMenuBar mb;
  private JMenu mnFile;
  private JMenuItem miPrint;
  private JMenuItem miSave;
  private JMenuItem miLoad;
  
  public DrawingWindow(DrawingView view)
  {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(800, 600);
    this.setTitle("MyPaint");
    this.view = view;
    this.init();
    this.setContentPane(view);
  }
  
  
  private void init()
  {
    mb = new JMenuBar();
    mnFile = new JMenu("File");
    mnFile.setMnemonic(KeyEvent.VK_F);
    mnFile.getAccessibleContext().setAccessibleDescription(
        "File menu");
    
    mb.add(mnFile);
    
    //Save
    miSave = new JMenuItem("Save");
    miSave.setMnemonic(KeyEvent.VK_S);
    mnFile.add(miSave);
    //Load
    miLoad = new JMenuItem("Load");
    miLoad.setMnemonic(KeyEvent.VK_L);
    mnFile.add(miLoad);
    //Print
    miPrint = new JMenuItem("Print");
    miPrint.setMnemonic(KeyEvent.VK_P);
    mnFile.add(miPrint);
    
    this.setJMenuBar(mb);
  }
  
  public DrawingView getDrawingView()
  {
    return view;
  }

  public JMenuItem getMiPrint()
  {
    return miPrint;
  }

  public JMenuItem getMiSave()
  {
    return miSave;
  }

  public JMenuItem getMiLoad()
  {
    return miLoad;
  }
  
}
