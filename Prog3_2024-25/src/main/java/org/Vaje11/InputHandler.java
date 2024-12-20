package org.Vaje11;


import java.awt.*;
import java.awt.event.KeyEvent;

public class InputHandler implements Runnable{



    @Override
    public void run() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getID() == KeyEvent.KEY_TYPED){
                    GameLoop.events.add(keyEvent.getKeyChar());
                }
                return false;
            }
        });
    }
}
