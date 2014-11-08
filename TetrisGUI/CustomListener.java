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
//Mouse Action
class CustomListener implements MouseListener,MouseMotionListener {

	public void mouseMoved(MouseEvent me){
		if(TetrisGUI.changable==true){
			TetrisGUI.shape.detectCursor();
		}
	}
	public void mouseDragged(MouseEvent me){
		System.out.println("Dragged");

	}
	public void mousePressed(MouseEvent me){
		System.out.println("Pressed");

	}
	public void mouseReleased(MouseEvent me){
		System.out.println("Released");

	}
	public void mouseClicked(MouseEvent me){
		if(TetrisGUI.entered == true){
			TetrisGUI.shape.transferShape();
		}

	}
	
	public void mouseEntered(MouseEvent me){
		TetrisGUI.entered = true;
		TetrisGUI.changable = true;
		

	}
	public void mouseExited(MouseEvent me){
		System.out.println("Exited");
		TetrisGUI.entered = false;
	}

	


}