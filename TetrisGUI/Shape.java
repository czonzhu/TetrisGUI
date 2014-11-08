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
// Shape changing
public class Shape {
	public int index;
	public int xPosition = 0;
	public int yPosition=0;
	public int state = 0;
	public boolean reached = false;
	public boolean cursorIN = false;
	public int shapeNumber = 7;
	
	
	public Shape() {
		index = 0;
		yPosition = 0;
		setRandomShape();
		setNextIndex();
	}

	public void setRandomShape(){
		Random rand = new Random();
		if(TetrisGUI.nextIndex == 0){
			index = rand.nextInt((shapeNumber-1)+1)+1;
		}
		else{
			index = TetrisGUI.nextIndex;
		}
		System.out.println("index is: " + index);
		
	}
	public void setNextIndex(){
		Random rand1 = new Random();
		TetrisGUI.nextIndex = rand1.nextInt((shapeNumber-1)+1)+1;
		System.out.println("next index is: "+TetrisGUI.nextIndex);
	}

	public void transferShape(){
			index = TetrisGUI.nextIndex;
			Random rand1 = new Random();
			TetrisGUI.nextIndex = rand1.nextInt((shapeNumber-1)+1)+1;
			TetrisGUI.score = TetrisGUI.score-TetrisGUI.level*TetrisGUI.mFactor;
			TetrisGUI.label3.setText("Score:" + TetrisGUI.score);
	}

	public void detectCursor(){
		Point p = MouseInfo.getPointerInfo().getLocation();
		int mouseX = (int)p.getX();
		int mouseY = (int)p.getY();
		if(TetrisGUI.shape.index == 1){
			if(TetrisGUI.shape.state==0||TetrisGUI.shape.state == 2){
				if(mouseX>TetrisGUI.drawPanel.xRel(3+TetrisGUI.shape.xPosition)
				&& mouseX<TetrisGUI.drawPanel.xRel(7+TetrisGUI.shape.xPosition)
				&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+2)
				&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3)
				){
					TetrisGUI.shape.transferShape();
					TetrisGUI.changable=false;
				}

			}
		}
		else if(TetrisGUI.shape.index == 2){
			if(TetrisGUI.shape.state == 0){
				if((mouseX>TetrisGUI.drawPanel.xRel(4+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(7+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+4))
					||(mouseX>TetrisGUI.drawPanel.xRel(5+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(6+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+2)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3))
				){

					TetrisGUI.shape.transferShape();
					TetrisGUI.changable=false;
				}
			}
		}
		
		else if(TetrisGUI.shape.index == 3){
			if(TetrisGUI.shape.state == 0){
				if((mouseX>TetrisGUI.drawPanel.xRel(4+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(6+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+2)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+4))
					
				){

					TetrisGUI.shape.transferShape();
					TetrisGUI.changable=false;
				}
			}
		}

		else if(TetrisGUI.shape.index == 4){
			if(TetrisGUI.shape.state == 0){
				if((mouseX>TetrisGUI.drawPanel.xRel(4+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(7+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+4))
					||(mouseX>TetrisGUI.drawPanel.xRel(4+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(5+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+2)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3))
				){

					TetrisGUI.shape.transferShape();
					TetrisGUI.changable=false;
				}
			}
		}

		else if(TetrisGUI.shape.index == 5){
			if(TetrisGUI.shape.state == 0){
				if((mouseX>TetrisGUI.drawPanel.xRel(4+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(7+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+4))
					||(mouseX>TetrisGUI.drawPanel.xRel(6+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(7+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+2)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3))
				){

					TetrisGUI.shape.transferShape();
					TetrisGUI.changable=false;
				}
			}
		}

		else if(TetrisGUI.shape.index == 7){
			if(TetrisGUI.shape.state == 0){
				if((mouseX>TetrisGUI.drawPanel.xRel(4+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(6+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+4))
					||(mouseX>TetrisGUI.drawPanel.xRel(5+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(7+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+2)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3))
				){

					TetrisGUI.shape.transferShape();
					TetrisGUI.changable=false;
				}
			}
		}

		else if(TetrisGUI.shape.index == 6){
			if(TetrisGUI.shape.state == 0){
				if((mouseX>TetrisGUI.drawPanel.xRel(5+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(7+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+4))
					||(mouseX>TetrisGUI.drawPanel.xRel(4+TetrisGUI.shape.xPosition)
					&&mouseX<TetrisGUI.drawPanel.xRel(6+TetrisGUI.shape.xPosition)
					&&mouseY>TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+2)
					&&mouseY<TetrisGUI.drawPanel.yRel(TetrisGUI.shape.yPosition+3))
				){

					TetrisGUI.shape.transferShape();
					TetrisGUI.changable=false;
				}
			}
		}




	}

}