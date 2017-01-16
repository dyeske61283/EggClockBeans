/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.Model;

import java.util.Observable;

/**
 *
 * @author kevin
 */
public class Counter extends Observable implements Runnable
{
  private static final long sec = 1000;
  private int bound;
  private Thread thd;
  private int currentVal;
  private Boolean started;

  public Counter()
  {
    bound = 9;
    currentVal = bound;
    started = false;

    thd = new Thread(this);
    thd.start();
  }

  public synchronized void setStarted(Boolean started)
  {
    this.started = started;
    notifyAll();
  }

  public int getAugen()
  {
    return this.currentVal;
  }

  public Boolean isStarted()
  {
    return this.started;
  }

  public int getBound()
  {
    return this.bound;
  }

  public void setBound(int bound)
  {
    if (!started)
    {
      this.currentVal = bound;
    }
    this.bound = bound;
  }

  @Override
  public void run()
  {
    while (true)
    {
      try
      {
        this.berechneAugen();
      }
      catch (InterruptedException ex)
      {
        ex.printStackTrace();
      }
    }
  }

  private synchronized void berechneAugen() throws InterruptedException
  {
    while (!started)
    {
      wait();
    }
    if (currentVal > 0)
    {
      currentVal = --bound;
      wait(sec);
    }
    else
    {
      this.setStarted(false);
      this.currentVal = this.bound;
    }
    this.setChanged();
    this.notifyObservers();
    notifyAll();
  }

}
