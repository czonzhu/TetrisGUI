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

class MyDrawPanel extends JPanel {
		public static int maxX,maxY,minMaxXY,xCenter,yCenter;
		public static float pixelSize;
		int iX(float x){return Math.round(xCenter + x/pixelSize);}
		int iY(float y) {return Math.round(yCenter-y/pixelSize);}
		public static Color deepRed = new Color(248,0,4);
		public static Color seaBlue = new Color(26,160,235);
		public static Color soilYellow = new Color(253,180,11);
		public static Color deepGreen = new Color(35,165,63);
		public static Color jewelBlue = new Color(11,90,178);
		public static Color deepPurple = new Color(92,26,143);
		public static Color zYellow = new Color(255,255,12);
		public static float rWidth;
		public static int sqrSize;

	public void paintComponent(Graphics g) {
		this.repaint();
		
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		Dimension d = getSize();
		maxX = d.width-1;maxY = d.height-1;
		minMaxXY = Math.min(maxX,maxY);
		xCenter = maxX/2;yCenter = maxY/2;
		rWidth = 0.055F*minMaxXY;
		sqrSize = Math.round(rWidth);
		pixelSize = Math.max(rWidth/maxX,rWidth/maxY);
		g.setColor(Color.black);
		g.drawRect(iX(-0.45F*rWidth),iY(0.55F*rWidth),10*sqrSize,20*sqrSize);//mainArea
		g.drawRect(iX(-0.45F*rWidth)+11*sqrSize,iY(0.55F*rWidth)+18*sqrSize,5*sqrSize,2*sqrSize);//QuitButton
		TetrisGUI.quit.setFont(new Font("Arial", Font.BOLD, sqrSize));//QuitFont
		
		

		
		//NextShape Blocks
		g.setColor(Color.black);
		g.drawRect(iX(-0.45F*rWidth)+11*sqrSize,iY(0.55F*rWidth),5*sqrSize,3*sqrSize);
		

		TetrisGUI.quit.setSize(5*sqrSize,2*sqrSize);
		TetrisGUI.quit.setLocation(iX(-0.45F*rWidth)+11*sqrSize,iY(0.548F*rWidth)+18*sqrSize);
		TetrisGUI.quit.setBorder(BorderFactory.createEmptyBorder());//Make the border unseen

		//Set Label Font
		TetrisGUI.label1.setFont(new Font("Arial", Font.BOLD, sqrSize));
		TetrisGUI.label2.setFont(new Font("Arial", Font.BOLD, sqrSize));
		TetrisGUI.label3.setFont(new Font("Arial", Font.BOLD, sqrSize));
		TetrisGUI.mLabel.setFont(new Font("Arial", Font.PLAIN,sqrSize));
		TetrisGUI.nLabel.setFont(new Font("Arial", Font.PLAIN,sqrSize));
		TetrisGUI.sLabel.setFont(new Font("Arial", Font.PLAIN,sqrSize));

		//Set Label Size
		TetrisGUI.label1.setSize(5*sqrSize,2*sqrSize);
		TetrisGUI.label1.setLocation(iX(-0.45F*rWidth)+11*sqrSize,iY(0.55F*rWidth)+4*sqrSize);
		TetrisGUI.label2.setSize(5*sqrSize,2*sqrSize);
		TetrisGUI.label2.setLocation(iX(-0.45F*rWidth)+11*sqrSize,iY(0.55F*rWidth)+6*sqrSize);
		TetrisGUI.label3.setSize(5*sqrSize,2*sqrSize);
		TetrisGUI.label3.setLocation(iX(-0.45F*rWidth)+11*sqrSize,iY(0.55F*rWidth)+8*sqrSize);
		TetrisGUI.mLabel.setSize(sqrSize,sqrSize);
		TetrisGUI.mLabel.setLocation(iX(-0.43F*rWidth)+10*sqrSize,iY(0.55F*rWidth)+11*sqrSize);
		TetrisGUI.nLabel.setSize(sqrSize,sqrSize);
		TetrisGUI.nLabel.setLocation(iX(-0.43F*rWidth)+10*sqrSize,iY(0.55F*rWidth)+13*sqrSize);
		TetrisGUI.sLabel.setSize(sqrSize,sqrSize);
		TetrisGUI.sLabel.setLocation(iX(-0.43F*rWidth)+10*sqrSize,iY(0.55F*rWidth)+15*sqrSize);
		TetrisGUI.mSizeLabel.setSize(5*sqrSize,1*sqrSize);
		TetrisGUI.sSizeLabel.setSize(5*sqrSize,1*sqrSize);
		TetrisGUI.mSizeLabel.setLocation(iX(-0.43F*rWidth)+1*sqrSize,iY(0.55F*rWidth)-2*sqrSize);
		TetrisGUI.sSizeLabel.setLocation(iX(-0.43F*rWidth)+1*sqrSize,iY(0.54F*rWidth)+20*sqrSize);



		//Set Slider Position
		TetrisGUI.mSlider.setSize(5*sqrSize,2*sqrSize) ;
		TetrisGUI.mSlider.setLocation(iX(-0.45F*rWidth)+11*sqrSize,iY(0.55F*rWidth)+11*sqrSize);
		TetrisGUI.nSlider.setSize(5*sqrSize,2*sqrSize) ;
		TetrisGUI.nSlider.setLocation(iX(-0.45F*rWidth)+11*sqrSize,iY(0.55F*rWidth)+13*sqrSize);
		TetrisGUI.sSlider.setSize(5*sqrSize,2*sqrSize) ;
		TetrisGUI.sSlider.setLocation(iX(-0.45F*rWidth)+11*sqrSize,iY(0.55F*rWidth)+15*sqrSize);
		TetrisGUI.mainAreaSlider.setSize(5*sqrSize,2*sqrSize);
		TetrisGUI.mainAreaSlider.setLocation(iX(-0.45F*rWidth)+5*sqrSize,iY(0.55F*rWidth)-2*sqrSize);
		TetrisGUI.squareSizeSlider.setSize(5*sqrSize,2*sqrSize);
		TetrisGUI.squareSizeSlider.setLocation(iX(-0.45F*rWidth)+5*sqrSize,iY(0.55F*rWidth)+20*sqrSize);
		


		//Set MainArea Size and Location
		TetrisGUI.mainArea.setSize(10*sqrSize,20*sqrSize);
		TetrisGUI.mainArea.setLocation(iX(-0.45F*rWidth),iY(0.55F*rWidth));


		//Animaiton Interface
		//draw a line
		if(TetrisGUI.shape.state == 0) {
			if(TetrisGUI.shape.index == 1) {
				drawSquares(5+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,3+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,seaBlue,g,sqrSize,rWidth);

			}


			//Draw a TShape
			else if(TetrisGUI.shape.index == 2) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,1+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,soilYellow,g,sqrSize,rWidth);
			}

			//Draw a SquareShape
			else if(TetrisGUI.shape.index == 3) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,deepGreen,g,sqrSize,rWidth);
			}

			//Draw a LShape
			else if(TetrisGUI.shape.index == 4) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,jewelBlue,g,sqrSize,rWidth);
			}

			//Draw a mirrored LShape
			else if(TetrisGUI.shape.index == 5) {
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,1+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,deepRed,g,sqrSize,rWidth);
			}

			//ZShape
			else if(TetrisGUI.shape.index == 6) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,deepPurple,g,sqrSize,rWidth);
			}

			//Mirrored ZShape
			else if(TetrisGUI.shape.index == 7) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,zYellow,g,sqrSize,rWidth);
			}
		}

		//ClockWise Rotate once
		else if(TetrisGUI.shape.state == 1) {
			if(TetrisGUI.shape.index == 1) {
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,3+TetrisGUI.shape.yPosition,seaBlue,g,sqrSize,rWidth);
			}


			//Draw a TShape
			else if(TetrisGUI.shape.index == 2) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,soilYellow,g,sqrSize,rWidth);
			}

			//Draw a SquareShape
			else if(TetrisGUI.shape.index == 3) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,deepGreen,g,sqrSize,rWidth);
			}

			//Draw a LShape
			else if(TetrisGUI.shape.index == 4) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,jewelBlue,g,sqrSize,rWidth);
			}

			//Draw a mirrored LShape
			else if(TetrisGUI.shape.index == 5) {
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,deepRed,g,sqrSize,rWidth);
			}

			//ZSha
			else if(TetrisGUI.shape.index == 6) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,deepPurple,g,sqrSize,rWidth);
			}

			//Mirrored ZShape
			else if(TetrisGUI.shape.index == 7) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,zYellow,g,sqrSize,rWidth);
			}

		}
		//Clockwise Rotate twice
		else if(TetrisGUI.shape.state == 2) {
			if(TetrisGUI.shape.index == 1) {
				drawSquares(5+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,3+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,seaBlue,g,sqrSize,rWidth);
			}


			//Draw a TShape
			else if(TetrisGUI.shape.index == 2) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,soilYellow,g,sqrSize,rWidth);
			}

			//Draw a SquareShape
			else if(TetrisGUI.shape.index == 3) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,deepGreen,g,sqrSize,rWidth);
			}

			//Draw a LShape
			else if(TetrisGUI.shape.index == 4) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,jewelBlue,g,sqrSize,rWidth);
			}

			//Draw a mirrored LShape
			else if(TetrisGUI.shape.index == 5) {
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,deepRed,g,sqrSize,rWidth);
			}

			//ZShape
			else if(TetrisGUI.shape.index == 6) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,deepPurple,g,sqrSize,rWidth);
			}

			//Mirrored ZShape
			else if(TetrisGUI.shape.index == 7) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,6+TetrisGUI.shape.xPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,zYellow,g,sqrSize,rWidth);
			}

		}

		//Clockwise Rotate three times
		else if(TetrisGUI.shape.state == 3) {
			if(TetrisGUI.shape.index == 1) {
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,3+TetrisGUI.shape.yPosition,seaBlue,g,sqrSize,rWidth);
			}


			//Draw a TShape
			else if(TetrisGUI.shape.index == 2) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,soilYellow,g,sqrSize,rWidth);
			}

			//Draw a SquareShape
			else if(TetrisGUI.shape.index == 3) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,deepGreen,g,sqrSize,rWidth);
			}

			//Draw a LShape
			else if(TetrisGUI.shape.index == 4) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,2+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,jewelBlue,g,sqrSize,rWidth);
			}

			//Draw a mirrored LShape
			else if(TetrisGUI.shape.index == 5) {
				drawSquares(4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,deepRed,g,sqrSize,rWidth);
			}

			//ZSha
			else if(TetrisGUI.shape.index == 6) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,deepPurple,g,sqrSize,rWidth);
			}

			//Mirrored ZShape
			else if(TetrisGUI.shape.index == 7) {
				
				drawSquares(4+TetrisGUI.shape.xPosition,4+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,5+TetrisGUI.shape.xPosition,0+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,1+TetrisGUI.shape.yPosition,2+TetrisGUI.shape.yPosition,zYellow,g,sqrSize,rWidth);
			}

		}


		//Draw nextShape
		if(TetrisGUI.nextIndex == 1) {
			drawNextSquares(5,4,6,3,1,1,1,1,seaBlue,g,sqrSize,rWidth);
		}

		else if(TetrisGUI.nextIndex == 2){
			drawNextSquares(5,5,6,4,0,1,1,1,soilYellow,g,sqrSize,rWidth);			
		}

		else if(TetrisGUI.nextIndex == 3){
			drawNextSquares(4,4,5,5,0,1,0,1,deepGreen,g,sqrSize,rWidth);			
		}
		else if(TetrisGUI.nextIndex == 4){
			drawNextSquares(4,4,5,6,0,1,1,1,jewelBlue,g,sqrSize,rWidth);			
		}
		else if(TetrisGUI.nextIndex == 5){
			drawNextSquares(4,5,6,6,1,1,1,0,deepRed,g,sqrSize,rWidth);			
		}
		else if(TetrisGUI.nextIndex == 6){
			drawNextSquares(4,5,5,6,0,0,1,1,deepPurple,g,sqrSize,rWidth);			
		}
		else if(TetrisGUI.nextIndex == 7){
			drawNextSquares(4,5,5,6,1,0,1,0,zYellow,g,sqrSize,rWidth);			
		}

		//Remaining Down
		for(int i = 0;i<20;i++){
			if(TetrisGUI.mapTable[0][i]!=0&&TetrisGUI.mapTable[1][i]!=0&&TetrisGUI.mapTable[2][i]!=0
				&&TetrisGUI.mapTable[3][i]!=0&&TetrisGUI.mapTable[4][i]!=0&&TetrisGUI.mapTable[5][i]!=0
				&&TetrisGUI.mapTable[6][i]!=0&&TetrisGUI.mapTable[7][i]!=0&&TetrisGUI.mapTable[8][i]!=0
				&&TetrisGUI.mapTable[9][i]!=0){
				for(int j=0; j<10;j++){
					for(int k=i;k>0;k--){
						if(k>0){
							TetrisGUI.mapTable[j][k]=TetrisGUI.mapTable[j][k-1];
						}
						else
							TetrisGUI.mapTable[j][k]=0;
					}
				}
				TetrisGUI.lines++;
				TetrisGUI.score = TetrisGUI.score + TetrisGUI.level*TetrisGUI.mFactor;
				TetrisGUI.label2.setText("Lines:    " + TetrisGUI.lines);
				TetrisGUI.label3.setText("Score:" + TetrisGUI.score);
				TetrisGUI.level = 1+TetrisGUI.lines/TetrisGUI.nFactor;
				TetrisGUI.label1.setText("Level:    " + TetrisGUI.level);
				if(TetrisGUI.lines%TetrisGUI.nFactor==0&&TetrisGUI.level!=1){
					TetrisGUI.fallingSpeed = TetrisGUI.fallingSpeed*(1+TetrisGUI.level*TetrisGUI.sFactor);
					TetrisGUI.frequency = (int)(1/TetrisGUI.fallingSpeed);
					TetrisGUI.timer.setDelay(TetrisGUI.frequency);
				}
				

			}
		}

		
		//Draw remaining
		for(int i = 0; i<10;i++){
			for(int j = 0; j<20; j++) {
				if(TetrisGUI.mapTable[i][j] == 1) {
					drawaSquare(i,j,seaBlue,g,sqrSize,rWidth);
				}
				else if(TetrisGUI.mapTable[i][j] == 2) {
					drawaSquare(i,j,soilYellow,g,sqrSize,rWidth);
				}
				else if(TetrisGUI.mapTable[i][j] == 3) {
					drawaSquare(i,j,deepGreen,g,sqrSize,rWidth);
				}
				else if(TetrisGUI.mapTable[i][j] == 4) {
					drawaSquare(i,j,jewelBlue,g,sqrSize,rWidth);
				}
				else if(TetrisGUI.mapTable[i][j] == 5) {
					drawaSquare(i,j,deepRed,g,sqrSize,rWidth);
				}
				else if(TetrisGUI.mapTable[i][j] == 6) {
					drawaSquare(i,j,deepPurple,g,sqrSize,rWidth);
				}
				else if(TetrisGUI.mapTable[i][j] == 7) {
					drawaSquare(i,j,zYellow,g,sqrSize,rWidth);
				}

			}
		}

		//Game over
		if(TetrisGUI.mapTable[0][0]!=0||TetrisGUI.mapTable[1][0]!=0||TetrisGUI.mapTable[2][0]!=0
				||TetrisGUI.mapTable[3][0]!=0||TetrisGUI.mapTable[4][0]!=0||TetrisGUI.mapTable[5][0]!=0
				||TetrisGUI.mapTable[6][0]!=0||TetrisGUI.mapTable[7][0]!=0||TetrisGUI.mapTable[8][0]!=0
				||TetrisGUI.mapTable[9][0]!=0){
				Color deepBlue = new Color(11,90,178);
				g.setColor(deepBlue);
				g.setFont(new Font("Arial", Font.BOLD, sqrSize));
				g.drawString("Over !",iX(-0.43F*rWidth)+3*sqrSize,iY(0.55F*rWidth)+10*sqrSize);
				g.drawRect(iX(-0.43F*rWidth)+2*sqrSize,iY(0.57F*rWidth)+9*sqrSize,5*sqrSize,2*sqrSize);

				TetrisGUI.timer.stop();

		}
	

		
		
		//Draw Pause
		if(TetrisGUI.entered == true) { 
			Color deepBlue = new Color(11,90,178);
			g.setColor(deepBlue);
			g.setFont(new Font("Arial", Font.BOLD, sqrSize));
			g.drawString("Pause",iX(-0.43F*rWidth)+3*sqrSize,iY(0.55F*rWidth)+10*sqrSize);
			g.drawRect(iX(-0.43F*rWidth)+2*sqrSize,iY(0.57F*rWidth)+9*sqrSize,5*sqrSize,2*sqrSize);

			TetrisGUI.timer.stop();
		}
		else{
			TetrisGUI.timer.start();
		}
	}


	public void drawSquares(int xPosition1,int xPosition2,int xPosition3,int xPosition4,
								int yPosition1,int yPosition2, int yPosition3,int yPosition4,
								Color color,Graphics g, int sqrSize,float rWidth){
			g.setColor(Color.black);
			g.drawRect(iX(-0.45F*rWidth)+xPosition1*sqrSize,iY(0.55F*rWidth)+yPosition1*sqrSize,sqrSize,sqrSize);
			g.drawRect(iX(-0.45F*rWidth)+xPosition2*sqrSize,iY(0.55F*rWidth)+yPosition2*sqrSize,sqrSize,sqrSize);
			g.drawRect(iX(-0.45F*rWidth)+xPosition3*sqrSize,iY(0.55F*rWidth)+yPosition3*sqrSize,sqrSize,sqrSize);
			g.drawRect(iX(-0.45F*rWidth)+xPosition4*sqrSize,iY(0.55F*rWidth)+yPosition4*sqrSize,sqrSize,sqrSize);
			g.setColor(color);
			g.fillRect(iX(-0.45F*rWidth)+xPosition1*sqrSize+1,iY(0.55F*rWidth)+yPosition1*sqrSize+1,sqrSize-2,sqrSize-2);
			g.fillRect(iX(-0.45F*rWidth)+xPosition2*sqrSize+1,iY(0.55F*rWidth)+yPosition2*sqrSize+1,sqrSize-2,sqrSize-2);
			g.fillRect(iX(-0.45F*rWidth)+xPosition3*sqrSize+1,iY(0.55F*rWidth)+yPosition3*sqrSize+1,sqrSize-2,sqrSize-2);
			g.fillRect(iX(-0.45F*rWidth)+xPosition4*sqrSize+1,iY(0.55F*rWidth)+yPosition4*sqrSize+1,sqrSize-2,sqrSize-2);
	}

	public void drawNextSquares(int xPosition1,int xPosition2,int xPosition3,int xPosition4,
								int yPosition1,int yPosition2, int yPosition3,int yPosition4,
								Color color,Graphics g, int sqrSize,float rWidth){
		g.setColor(Color.black);
		g.drawRect(iX(-0.44F*rWidth)+(xPosition1+8)*sqrSize,iY(0.52F*rWidth)+yPosition1*sqrSize,sqrSize,sqrSize);
		g.drawRect(iX(-0.44F*rWidth)+(xPosition2+8)*sqrSize,iY(0.52F*rWidth)+yPosition2*sqrSize,sqrSize,sqrSize);
		g.drawRect(iX(-0.44F*rWidth)+(xPosition3+8)*sqrSize,iY(0.52F*rWidth)+yPosition3*sqrSize,sqrSize,sqrSize);
		g.drawRect(iX(-0.44F*rWidth)+(xPosition4+8)*sqrSize,iY(0.52F*rWidth)+yPosition4*sqrSize,sqrSize,sqrSize);
		g.setColor(color);
		g.fillRect(iX(-0.44F*rWidth)+(xPosition1+8)*sqrSize+1,iY(0.52F*rWidth)+yPosition1*sqrSize+1,sqrSize-2,sqrSize-2);
		g.fillRect(iX(-0.44F*rWidth)+(xPosition2+8)*sqrSize+1,iY(0.52F*rWidth)+yPosition2*sqrSize+1,sqrSize-2,sqrSize-2);
		g.fillRect(iX(-0.44F*rWidth)+(xPosition3+8)*sqrSize+1,iY(0.52F*rWidth)+yPosition3*sqrSize+1,sqrSize-2,sqrSize-2);
		g.fillRect(iX(-0.44F*rWidth)+(xPosition4+8)*sqrSize+1,iY(0.52F*rWidth)+yPosition4*sqrSize+1,sqrSize-2,sqrSize-2);
	}

	public void drawaSquare(int i,int j,Color color,Graphics g,int sqrSize,float rWidth){
		g.setColor(Color.black);
		g.drawRect(iX(-0.45F*rWidth)+i*sqrSize,iY(0.55F*rWidth)+j*sqrSize,sqrSize,sqrSize);
		g.setColor(color);
		g.fillRect(iX(-0.45F*rWidth)+i*sqrSize+1,iY(0.55F*rWidth)+j*sqrSize+1,sqrSize-2,sqrSize-2);
	}

	public int xRel(int i){
		
		return iX(-0.45F*rWidth)+i*sqrSize;
	}
	public int yRel(int j) {
		
		return (iY(0.55F*rWidth)+j*sqrSize);}

}