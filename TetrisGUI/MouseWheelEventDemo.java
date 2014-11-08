import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.lang.Object;
import java.util.Random;
import javax.swing.Timer;
import static java.lang.System.*;
import java.util.Queue;
import java.util.Hashtable;

public class MouseWheelEventDemo implements MouseWheelListener{

	
	public void mouseWheelMoved(MouseWheelEvent me) {
		int notches = me.getWheelRotation();
		if(notches<0) {
			if(TetrisGUI.shape.state<3){
				TetrisGUI.shape.state++;
			}
			else{
				TetrisGUI.shape.state = 0;
			}

			System.out.println("forwards clockWise");
		}
		else if(notches>0){
			if(TetrisGUI.shape.state>0){
				TetrisGUI.shape.state--;
			}
			else{
				TetrisGUI.shape.state = 3;
			}
			System.out.println("backwards counterClockWise");
		}

	}
}
