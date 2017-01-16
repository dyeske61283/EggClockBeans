/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.Controller;

import beans.Model.Counter;
import beans.View.View;

/**
 *
 * @author kevin
 */
public class CommandStop implements CommandInterface
{
    private View view;
    private Counter model;

    public CommandStop(View view, Counter model) 
    {
        this.view = view;
        this.model = model;
    }

    @Override
    public void execute() 
    {
       if(this.model.isStarted())
       {
         this.model.setStarted(false);
       }
    }
    
}
