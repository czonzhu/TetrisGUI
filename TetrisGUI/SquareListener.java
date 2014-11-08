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
//MouseAction for the Squares
class SquareListener implements MouseListener {

	public void mouseMoved(MouseEvent me){
		
	}
	public void mouseDragged(MouseEvent me){

	}
	public void mousePressed(MouseEvent me){
	}
	public void mouseReleased(MouseEvent me){
	}
	public void mouseClicked(MouseEvent me){
		if (
				(me.getButton() == MouseEvent.BUTTON3 && TetrisGUI.entered == false && (TetrisGUI.shape.state==0)&& (
						(TetrisGUI.shape.index==1&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0)
	        		   ||(TetrisGUI.shape.index==2&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0)
	        		   ||(TetrisGUI.shape.index==3&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==4&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==5&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==6&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==7&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		)

				)
				||
				(me.getButton() == MouseEvent.BUTTON3 && TetrisGUI.entered == false && (TetrisGUI.shape.state==1)&& (
						(TetrisGUI.shape.index==1&&TetrisGUI.shape.xPosition<5&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+3]==0)
	        		   ||(TetrisGUI.shape.index==2&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==3&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==4&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==5&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==6&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==7&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		)

				)
				||
				(me.getButton() == MouseEvent.BUTTON3 && TetrisGUI.entered == false && (TetrisGUI.shape.state==2)&& (
						(TetrisGUI.shape.index==1&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0)
	        		   ||(TetrisGUI.shape.index==2&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==3&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==4&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==5&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==6&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==7&&TetrisGUI.shape.xPosition<3&&TetrisGUI.mapTable[7+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		)

				)
				||
				(me.getButton() == MouseEvent.BUTTON3 && TetrisGUI.entered == false && (TetrisGUI.shape.state==3)&& (
						(TetrisGUI.shape.index==1&&TetrisGUI.shape.xPosition<5&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+3]==0)
	        		   ||(TetrisGUI.shape.index==2&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==3&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==4&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==5&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==6&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==7&&TetrisGUI.shape.xPosition<4&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[6+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		)

				)


			)
        {
            TetrisGUI.shape.xPosition++;
			
        }
        else if (
	        	(me.getButton() == MouseEvent.BUTTON1 && TetrisGUI.entered == false&& (TetrisGUI.shape.state==0)&&(
	        		   (TetrisGUI.shape.index==1&&TetrisGUI.shape.xPosition>-3&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0)
	        		   ||(TetrisGUI.shape.index==2&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==3&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==4&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==5&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==6&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==7&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		)
	        	)
	        	||
	        	(me.getButton() == MouseEvent.BUTTON1 && TetrisGUI.entered == false&& (TetrisGUI.shape.state==1)&&(
	        		   (TetrisGUI.shape.index==1&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+3]==0)
	        		   ||(TetrisGUI.shape.index==2&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==3&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==4&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==5&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==6&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==7&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0)
	        		)
	        	)
				||
				(me.getButton() == MouseEvent.BUTTON1 && TetrisGUI.entered == false&& (TetrisGUI.shape.state==2)&&(
	        		   (TetrisGUI.shape.index==1&&TetrisGUI.shape.xPosition>-3&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0)
	        		   ||(TetrisGUI.shape.index==2&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==3&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==4&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[5+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==5&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==6&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==7&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		)
	        	)
				||
				(me.getButton() == MouseEvent.BUTTON1 && TetrisGUI.entered == false&& (TetrisGUI.shape.state==3)&&(
	        		   (TetrisGUI.shape.index==1&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+3]==0)
	        		   ||(TetrisGUI.shape.index==2&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==3&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0)
	        		   ||(TetrisGUI.shape.index==4&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==5&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==6&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+2]==0)
	        		   ||(TetrisGUI.shape.index==7&&TetrisGUI.shape.xPosition>-4&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0&&TetrisGUI.mapTable[3+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition+1]==0&&TetrisGUI.mapTable[4+TetrisGUI.shape.xPosition][TetrisGUI.shape.yPosition]==0)
	        		)
	        	)
	        )
        {

        	 TetrisGUI.shape.xPosition--;
			
        }
	}
	public void mouseEntered(MouseEvent me){
		
	}
	public void mouseExited(MouseEvent me){
	}

}