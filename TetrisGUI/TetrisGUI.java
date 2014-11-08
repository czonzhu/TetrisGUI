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
import javax.swing.event.*;


public class TetrisGUI implements ActionListener,ChangeListener{
	public static JButton quit = new JButton();
	public static JLabel label1 = new JLabel();
	public static JLabel label2 = new JLabel();
	public static JLabel label3 = new JLabel();
	public static JFrame frame = new JFrame();
	public static MyDrawPanel drawPanel = new MyDrawPanel();
	public static JPanel mainArea = new JPanel();
	public static boolean entered = false;
	public static Shape shape;
	public static Timer timer;
	public static int[][] mapTable = new int[11][21];
	public static int nextIndex;
	public static int mFactor = 5;
	public static int nFactor = 30;
	public static double sFactor = 1.0;
	public static int level = 1;
	public static int lines = 0;
	public static int score = 0;
	public static double fallingSpeed = 0.002;
	public static int frequency = 500 ;
	public static ActionListener actListner;
	public static JSlider mSlider = new JSlider(JSlider.HORIZONTAL,1,10,5);
	public static JSlider nSlider = new JSlider(JSlider.HORIZONTAL,20,50,30);
	public static JSlider sSlider = new JSlider(JSlider.HORIZONTAL,1,10,5);
	public static JLabel mLabel = new JLabel();
	public static JLabel nLabel = new JLabel();
	public static JLabel sLabel = new JLabel();
	public static boolean changable = false;
	public static JSlider mainAreaSlider = new JSlider(JSlider.HORIZONTAL,1,3,1);
	public static JSlider squareSizeSlider = new JSlider(JSlider.HORIZONTAL,1,3,1);
	public static JLabel mSizeLabel = new JLabel();
	public static JLabel sSizeLabel = new JLabel();


	
	
	
	
	

	public static void main(String[] args) {
		TetrisGUI gui = new TetrisGUI();
		gui.go();
		
		
	}

	public void go() {
		shape = new Shape();


		//Timer 
		ActionListener actListner = new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent event) {
				goDown();
			}
		};
		timer = new Timer(frequency,actListner);
		timer.start();

		
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    quit = new JButton("QUIT");
		label1 = new JLabel();
		label1.setText("Level:    "+level);
		label2 = new JLabel();
		label2.setText("Lines:    " + lines);
		label3 = new JLabel();
		label3.setText("Score:    "+score);
		mLabel.setText("M");
		nLabel.setText("N");
		sLabel.setText("S");
		mSizeLabel.setText("MainArea Size");
		sSizeLabel.setText("Square Size");


	
		
		


		MyDrawPanel drawPanel = new MyDrawPanel();

		//SET SLIDERS
		mSlider.setMajorTickSpacing(9);
		mSlider.setMinorTickSpacing(1);
		mSlider.setPaintTicks(true);
		mSlider.setPaintLabels(true);
		nSlider.setMajorTickSpacing(10);
		nSlider.setMinorTickSpacing(2);
		nSlider.setPaintTicks(true);
		nSlider.setPaintLabels(true);
		sSlider.setMajorTickSpacing(9);
		sSlider.setMinorTickSpacing(1);
		mainAreaSlider.setMajorTickSpacing(3);
		mainAreaSlider.setMinorTickSpacing(1);
		mainAreaSlider.setPaintTicks(true);
		mainAreaSlider.setPaintLabels(true);
		squareSizeSlider.setMajorTickSpacing(3);
		squareSizeSlider.setMinorTickSpacing(1);
		squareSizeSlider.setPaintLabels(true);
		squareSizeSlider.setPaintTicks(true);
		Hashtable sLabelTable = new Hashtable();
		sLabelTable.put(new Integer(1), new JLabel("0.1"));
		sLabelTable.put(new Integer(10), new JLabel("1"));
		sSlider.setLabelTable(sLabelTable);
		sSlider.setPaintTicks(true);
		sSlider.setPaintLabels(true);



		quit.addActionListener(this);
		mainArea.addMouseListener(new CustomListener(){});
		mainArea.addMouseMotionListener(new CustomListener(){});
		frame.addMouseListener(new SquareListener(){});
		frame.addMouseWheelListener(new MouseWheelEventDemo(){});
		mSlider.addChangeListener(this);
		nSlider.addChangeListener(this);
		sSlider.addChangeListener(this);
		mainAreaSlider.addChangeListener(this);
		squareSizeSlider.addChangeListener(this);
		
		
		frame.getContentPane().add(quit);
		frame.getContentPane().add(label1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(label3);
		frame.getContentPane().add(mLabel);
		frame.getContentPane().add(nLabel);
		frame.getContentPane().add(sLabel);
		frame.getContentPane().add(mSlider);
		frame.getContentPane().add(nSlider);
		frame.getContentPane().add(sSlider);
		frame.getContentPane().add(mainAreaSlider);
		frame.getContentPane().add(squareSizeSlider);
		frame.getContentPane().add(mSizeLabel);
		frame.getContentPane().add(sSizeLabel);
		frame.getContentPane().add(mainArea);
		frame.getContentPane().add(drawPanel);
		
		
		
		
		
		mainArea.setOpaque(false);
		drawPanel.setOpaque(false);//Set the drawPanel opaque
		
		
		frame.setSize(450,650);
		frame.setVisible(true);
		
		
	}

	

	public void actionPerformed(ActionEvent event) {
		System.exit(0);
	}

	public void stateChanged(ChangeEvent e){
		mFactor = (int)mSlider.getValue();
		sFactor = 0.1*(int)sSlider.getValue();
		nFactor = (int)nSlider.getValue();
		if((int)mainAreaSlider.getValue()!=1){
		frame.setSize(450*(int)mainAreaSlider.getValue(),650*(int)mainAreaSlider.getValue());}
		else
		frame.setSize(450*(int)squareSizeSlider.getValue(),650*(int)squareSizeSlider.getValue());
		
	}

	public void goDown(){
		if(shape.state == 0){
			if(((shape.yPosition<18&&shape.index!=1)||(shape.yPosition<19&&shape.index==1))
				&&
				((shape.index==1&&mapTable[shape.xPosition+5][shape.yPosition+1]==0 && mapTable[shape.xPosition+4][shape.yPosition+1]==0 && mapTable[shape.xPosition+6][shape.yPosition+1]==0 && mapTable[shape.xPosition+3][shape.yPosition+1]==0)
				||(shape.index == 2 &&mapTable[shape.xPosition+4][shape.yPosition+2]==0 && mapTable[shape.xPosition+5][shape.yPosition+2]==0 && mapTable[shape.xPosition+6][shape.yPosition+2]==0)
				||(shape.index == 3 && mapTable[shape.xPosition+4][shape.yPosition+2]==0 && mapTable[shape.xPosition+5][shape.yPosition+2]==0 )
				||(shape.index == 4 && mapTable[shape.xPosition+4][shape.yPosition+2]==0 &&mapTable[shape.xPosition+5][shape.yPosition+2]==0 &&mapTable[shape.xPosition+6][shape.yPosition+2]==0 )
				||(shape.index == 5 && mapTable[shape.xPosition+4][shape.yPosition+2]==0 &&mapTable[shape.xPosition+5][shape.yPosition+2]==0 &&mapTable[shape.xPosition+6][shape.yPosition+2]==0)
				||(shape.index == 6 && mapTable[shape.xPosition+4][shape.yPosition+1]==0&& mapTable[shape.xPosition+5][shape.yPosition+2]==0 &&  mapTable[shape.xPosition+6][shape.yPosition+2]==0)
				||(shape.index == 7 &&  mapTable[shape.xPosition+4][shape.yPosition+2]==0 &&  mapTable[shape.xPosition+5][shape.yPosition+2]==0&& mapTable[shape.xPosition+6][shape.yPosition+1]==0)
				)
			)
			{
				shape.yPosition++;
				System.out.println(shape.yPosition);
			}
			else{
				shape.yPosition = shape.yPosition;
				shape.reached = true;
				if(TetrisGUI.shape.index == 1) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+0] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+3][TetrisGUI.shape.yPosition+0] = 1;

					}
			    }


				//Draw a TShape
				else if(TetrisGUI.shape.index == 2) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+1] = 2;

					}
				}

				//Draw a SquareShape
				else if(TetrisGUI.shape.index == 3) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 3;

					}
				}

				//Draw a LShape
				else if(TetrisGUI.shape.index == 4) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+1] = 4;

					}
				}

				//Draw a mirrored LShape
				else if(TetrisGUI.shape.index == 5) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+1] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+0] = 5;

					}
				}

				//ZSha
				else if(TetrisGUI.shape.index == 6) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+1] = 6;

					}
				}

				//Mirrored ZShape
				else if(TetrisGUI.shape.index == 7) {
					
					
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+0] = 7;

					}
				}
				shape = new Shape();
			}
		}

		//state1 goDown
		else if(shape.state == 1){
			if(((shape.yPosition<18&&shape.index==3)||(shape.yPosition<16&&shape.index==1)||(shape.yPosition<17&&shape.index!=1&&shape.index!=3))
				&&
				((shape.index==1&&mapTable[shape.xPosition+4][shape.yPosition+4]==0 )
				||(shape.index == 2 &&mapTable[shape.xPosition+4][shape.yPosition+3]==0 && mapTable[shape.xPosition+5][shape.yPosition+2]==0)
				||(shape.index == 3 && mapTable[shape.xPosition+4][shape.yPosition+2]==0 && mapTable[shape.xPosition+5][shape.yPosition+2]==0 )
				||(shape.index == 4 && mapTable[shape.xPosition+4][shape.yPosition+3]==0 &&mapTable[shape.xPosition+5][shape.yPosition+1]==0  )
				||(shape.index == 5 && mapTable[shape.xPosition+4][shape.yPosition+3]==0 &&mapTable[shape.xPosition+5][shape.yPosition+3]==0 )
				||(shape.index == 6 && mapTable[shape.xPosition+4][shape.yPosition+3]==0 &&  mapTable[shape.xPosition+5][shape.yPosition+2]==0)
				||(shape.index == 7 &&  mapTable[shape.xPosition+4][shape.yPosition+2]==0 &&  mapTable[shape.xPosition+5][shape.yPosition+3]==0)
				)
			)
			{
				shape.yPosition++;
				System.out.println(shape.yPosition);
			}
			else{
				shape.yPosition = shape.yPosition;
				shape.reached = true;
				if(TetrisGUI.shape.index == 1) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+2] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+3] = 1;

					}
			    }


				//Draw a TShape
				else if(TetrisGUI.shape.index == 2) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+2] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 2;

					}
				}

				//Draw a SquareShape
				else if(TetrisGUI.shape.index == 3) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 3;

					}
				}

				//Draw a LShape
				else if(TetrisGUI.shape.index == 4) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+2] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 4;

					}
				}

				//Draw a mirrored LShape
				else if(TetrisGUI.shape.index == 5) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+2] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+2] = 5;

					}
				}

				//ZSha
				else if(TetrisGUI.shape.index == 6) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+2] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 6;

					}
				}

				//Mirrored ZShape
				else if(TetrisGUI.shape.index == 7) {
					
					
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+2] = 7;

					}
				}
				shape = new Shape();
			}
		}


		// State 2 goDown
		else if(shape.state == 2){
			if(((shape.yPosition<18&&shape.index!=1)||(shape.yPosition<19&&shape.index==1))&&
				((shape.index==1&&mapTable[shape.xPosition+5][shape.yPosition+1]==0 && mapTable[shape.xPosition+4][shape.yPosition+1]==0 && mapTable[shape.xPosition+6][shape.yPosition+1]==0 && mapTable[shape.xPosition+3][shape.yPosition+1]==0)
				||(shape.index == 2 &&mapTable[shape.xPosition+4][shape.yPosition+1]==0 && mapTable[shape.xPosition+5][shape.yPosition+2]==0 && mapTable[shape.xPosition+6][shape.yPosition+1]==0)
				||(shape.index == 3 && mapTable[shape.xPosition+4][shape.yPosition+2]==0 && mapTable[shape.xPosition+5][shape.yPosition+2]==0 )
				||(shape.index == 4 && mapTable[shape.xPosition+4][shape.yPosition+1]==0 &&mapTable[shape.xPosition+5][shape.yPosition+1]==0 &&mapTable[shape.xPosition+6][shape.yPosition+2]==0 )
				||(shape.index == 5 && mapTable[shape.xPosition+4][shape.yPosition+2]==0 &&mapTable[shape.xPosition+5][shape.yPosition+1]==0 &&mapTable[shape.xPosition+6][shape.yPosition+1]==0)
				||(shape.index == 6 && mapTable[shape.xPosition+4][shape.yPosition+1]==0&& mapTable[shape.xPosition+5][shape.yPosition+2]==0 &&  mapTable[shape.xPosition+6][shape.yPosition+2]==0)
				||(shape.index == 7 &&  mapTable[shape.xPosition+4][shape.yPosition+2]==0 &&  mapTable[shape.xPosition+5][shape.yPosition+2]==0&& mapTable[shape.xPosition+6][shape.yPosition+1]==0)
				)
			)
			{
				shape.yPosition++;
				System.out.println(shape.yPosition);
			}
			else{
				shape.yPosition = shape.yPosition;
				shape.reached = true;
				if(TetrisGUI.shape.index == 1) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+3][TetrisGUI.shape.yPosition+0] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+0] = 1;

					}
			    }


				//Draw a TShape
				else if(TetrisGUI.shape.index == 2) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+0] = 2;

					}
				}

				//Draw a SquareShape
				else if(TetrisGUI.shape.index == 3) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 3;

					}
				}

				//Draw a LShape
				else if(TetrisGUI.shape.index == 4) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+0] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+1] = 4;

					}
				}

				//Draw a mirrored LShape
				else if(TetrisGUI.shape.index == 5) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+0] = 5;

					}
				}

				//ZSha
				else if(TetrisGUI.shape.index == 6) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+1] = 6;

					}
				}

				//Mirrored ZShape
				else if(TetrisGUI.shape.index == 7) {
					
					
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+6][TetrisGUI.shape.yPosition+0] = 7;

					}
				}
				shape = new Shape();
			}
		}


		//State 3
		else if(shape.state == 3){
			if(((shape.yPosition<18&&shape.index==3)||(shape.yPosition<16&&shape.index==1)||(shape.yPosition<17&&shape.index!=1&&shape.index!=3))
				&&
				((shape.index==1&&mapTable[shape.xPosition+4][shape.yPosition+4]==0 )
				||(shape.index == 2 &&mapTable[shape.xPosition+4][shape.yPosition+2]==0 && mapTable[shape.xPosition+5][shape.yPosition+3]==0)
				||(shape.index == 3 && mapTable[shape.xPosition+4][shape.yPosition+2]==0 && mapTable[shape.xPosition+5][shape.yPosition+2]==0 )
				||(shape.index == 4 && mapTable[shape.xPosition+4][shape.yPosition+1]==0 &&mapTable[shape.xPosition+5][shape.yPosition+3]==0  )
				||(shape.index == 5 && mapTable[shape.xPosition+4][shape.yPosition+1]==0 &&mapTable[shape.xPosition+5][shape.yPosition+3]==0 )
				||(shape.index == 6 && mapTable[shape.xPosition+4][shape.yPosition+3]==0 &&  mapTable[shape.xPosition+5][shape.yPosition+2]==0)
				||(shape.index == 7 &&  mapTable[shape.xPosition+4][shape.yPosition+2]==0 &&  mapTable[shape.xPosition+5][shape.yPosition+3]==0)
				)
			)
			{
				shape.yPosition++;
				System.out.println(shape.yPosition);
			}
			else{
				shape.yPosition = shape.yPosition;
				shape.reached = true;
				if(TetrisGUI.shape.index == 1) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+2] = 1;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+3] = 1;

					}
			    }


				//Draw a TShape
				else if(TetrisGUI.shape.index == 2) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 2;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+2] = 2;

					}
				}

				//Draw a SquareShape
				else if(TetrisGUI.shape.index == 3) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 3;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 3;

					}
				}

				//Draw a LShape
				else if(TetrisGUI.shape.index == 4) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+2] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+2] = 4;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 4;

					}
				}

				//Draw a mirrored LShape
				else if(TetrisGUI.shape.index == 5) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 5;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+2] = 5;

					}
				}

				//ZSha
				else if(TetrisGUI.shape.index == 6) {
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+2] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+0] = 6;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 6;

					}
				}

				//Mirrored ZShape
				else if(TetrisGUI.shape.index == 7) {
					
					
					if(TetrisGUI.shape.reached){
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+0] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+4][TetrisGUI.shape.yPosition+1] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+1] = 7;
						TetrisGUI.mapTable[TetrisGUI.shape.xPosition+5][TetrisGUI.shape.yPosition+2] = 7;

					}
				}
				shape = new Shape();
			}
		}




	}

	
}











