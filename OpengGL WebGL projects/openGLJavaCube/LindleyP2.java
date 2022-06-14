/**
 * Author: Lindley, Thomas
 * Date: 07FEB2022
 * Project: CMSC 405 Project 2
 * Purpose: Create 6 shapes and apply transformations using JOGL
 * Dependencies: JOGL 2.3.2, glugen 2.3.2
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;

public class LindleyP2 extends JPanel implements GLEventListener{

	public static void main(String[] args) {
		JFrame window = new JFrame("Color Cube of Spheres -- USE MOUSE TO ROTATE");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new LindleyP2());
        window.pack();
        window.setVisible(true);
	}
	private Camera camera;
	private GLJPanel drawable;
	private int frameNumber;
	
	private int cubeDisplayList;
	private int pyramidDisplayList;
	private int hextetrahedronDisplayList;
	private int spikedCubeDisplayList;
	private int shipDisplayList;
	private int triangularPrismDisplayList;
	
	public LindleyP2() {
		drawable = new GLJPanel();
        drawable.setPreferredSize(new Dimension(800,600));
        drawable.addGLEventListener(this);
        setLayout(new BorderLayout());
        add(drawable, BorderLayout.CENTER);
        
        // timer to base transformations off of
        Timer timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frameNumber++;	
                drawable.repaint();
            }
        });
        timer.setInitialDelay(1000);
        timer.start();
        
        // camera object provides info needed for viewing transform and projection
        camera = new Camera();
        camera.setLimits(-30,30,-30,30,-30,30);
        // trackball allows moving camera view in 3d world with left click drag
        camera.installTrackball(this);
        
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        camera.apply(gl);
        
        // Display Cube
        gl.glPushMatrix();
        gl.glTranslated(-20, -15, 0);
		gl.glRotated(-frameNumber*0.7,0,0,1);
        gl.glCallList(cubeDisplayList);
        gl.glPopMatrix();
        
        // Display Pyramid
        gl.glPushMatrix();
        gl.glTranslated(frameNumber%100-30, 18, 7);
		gl.glRotated(-frameNumber*0.5,1,1,1);
        gl.glCallList(pyramidDisplayList);
        gl.glPopMatrix();
    
        // Display Hextetrahedron
        gl.glPushMatrix();
        gl.glTranslated(5, 0, -2);
        gl.glRotated(-frameNumber*0.3,1,0,1);
        gl.glCallList(hextetrahedronDisplayList);
        gl.glPopMatrix();
    
        // Draw Spiked Cube
        gl.glPushMatrix();
        gl.glTranslated(-8, 10, -2);
        gl.glScalef(frameNumber%100*0.01f, frameNumber%100*0.01f, frameNumber%100*0.01f);
        gl.glRotated(-frameNumber*0.3,1,0,1);
        gl.glCallList(spikedCubeDisplayList);
        gl.glPopMatrix();
        
        // Draw Ship
        gl.glPushMatrix();
	    gl.glTranslated(frameNumber%100-25, 20, -2);
	    gl.glScalef(frameNumber%100*0.01f, frameNumber%100*0.01f, frameNumber%100*0.01f);
	    gl.glCallList(shipDisplayList);
	    gl.glPopMatrix();
        
	    // Draw Triangular Prism
        gl.glPushMatrix();
        gl.glTranslated(9, -10, 7);
		gl.glRotated(-frameNumber*0.9,1,0,0);
		gl.glScalef(frameNumber%100*0.01f, 1, 1);
		gl.glCallList(triangularPrismDisplayList);
		gl.glPopMatrix();
        
        
	}
	
	public void drawPyramid(float r, float g, float b) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		gl.glColor3f(r, g, b);
		// tip of pyramid
        gl.glVertex3f(2, 2, -2);
        // front right corner
        gl.glVertex3f(4, 0, 0);
        // front left corner
        gl.glVertex3f(0, 0, 0);
        // back left corner
        gl.glVertex3f(0, 0, -4);
        // back right corner
        gl.glVertex3f(4, 0, -4);
        // front right corner
        gl.glVertex3f(4, 0, 0);
		gl.glEnd();
		// base of pyramid
		drawRect(0, 0, 0);
	}
	
	public void drawRect(float r, float g, float b) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(r, g, b);
		// front left corner
		gl.glVertex3f(0, 0, 0);
		// front right corner
		gl.glVertex3f(4, 0, 0);
		// back left corner
		gl.glVertex3f(0, 0, -4);
		// back right corner
		gl.glVertex3f(4, 0, -4);
		// front right corner
		gl.glVertex3f(4, 0, 0);
		gl.glEnd();
	}
	
	public void drawCube() {
		GL2 gl = drawable.getGL().getGL2();
		// bottom face
		drawRect(0, 0, 0);
		// front face
		gl.glPushMatrix();
		gl.glRotated(90, 1, 0, 0);
		drawRect(1, 0, 0);
		gl.glPopMatrix();
		// left face
		gl.glPushMatrix();
		gl.glRotated(90, 0, 0, 1);
		drawRect(0, 0, 1);
		gl.glPopMatrix();
		// back face
		gl.glPushMatrix();
		gl.glTranslated(0, 0, -4);
		gl.glRotated(90, 1, 0, 0);
		drawRect(0, 1, 0);
		gl.glPopMatrix();
		// right face
		gl.glPushMatrix();
		gl.glTranslated(4, 0, 0);
		gl.glRotated(90, 0, 0, 1);
		drawRect(0, 1, 1);
		gl.glPopMatrix();
		// top face
		gl.glPushMatrix();
		gl.glTranslated(0, 4, 0);
		drawRect(0.5f, 0.3f, 0.7f);
		gl.glPopMatrix();
	}
	
	public void drawHextetrahedron() {
		GL2 gl = drawable.getGL().getGL2();
		// use already made pyramids
		// left pyramid
		gl.glPushMatrix();
		gl.glRotated(90, 0, 0, 1);
		drawPyramid(0, 1, 1);
		gl.glPopMatrix();
		// front pyramid
		gl.glPushMatrix();
		gl.glRotated(90, 1, 0, 0);
		drawPyramid(0, 1, 0);
		gl.glPopMatrix();
		// bottom pyramid
		gl.glPushMatrix();
		gl.glScalef(1, -1, 1);
		drawPyramid(0.5f, 0.3f, 0.7f);
		gl.glPopMatrix();
		// top pyramid
		gl.glPushMatrix();
		gl.glTranslatef(0, 4, 0);
		drawPyramid(0, 0, 1);
		gl.glPopMatrix();
		// right pyramid
		gl.glPushMatrix();
		gl.glTranslatef(4, 0, 0);
		gl.glRotated(90, 0, 0, 1);
		gl.glScalef(1, -1, 1);
		drawPyramid(0,0,0);
		gl.glPopMatrix();
		// back pyramid
		gl.glPushMatrix();
		gl.glTranslatef(0, 0, -4);
		gl.glRotated(90, 1, 0, 0);
		gl.glScalef(1, -1, 1);
		drawPyramid(1,0,0);
		gl.glPopMatrix();
	}
	
	public void drawSpikes() {
		GL2 gl = drawable.getGL().getGL2();
		// create 4 spikes by elongating pyramids
		gl.glPushMatrix();
		gl.glScalef(0.5f, 3, 0.5f);
		// front right spike
		gl.glPushMatrix();
		drawPyramid(1, 0, 0);
		gl.glPopMatrix();
		// front left spike
		gl.glPushMatrix();
		gl.glTranslatef(-4, 0, 0);
		drawPyramid(0, 1, 0);
		gl.glPopMatrix();
		// back left spike
		gl.glPushMatrix();
		gl.glTranslatef(-4, 0, -4);
		drawPyramid(0, 0, 1);
		gl.glPopMatrix();
		// back right spike
		gl.glPushMatrix();
		gl.glTranslatef(0, 0, -4);
		drawPyramid(1, 0, 1);
		gl.glPopMatrix();
		gl.glPopMatrix();
	}
	
	public void drawSpikedCube() {
		GL2 gl = drawable.getGL().getGL2();
		// use an enlarged cube as base
		gl.glPushMatrix();
		gl.glScalef(2,2,2);
		drawCube();
		gl.glPopMatrix();
		// left face spikes
		gl.glPushMatrix();
		gl.glTranslatef(0, 4, -2);
		gl.glRotated(90, 0, 0, 1);
		drawSpikes();
		gl.glPopMatrix();
		// front face spikes
		gl.glPushMatrix();
		gl.glTranslatef(4, 2, 0);
		gl.glRotated(90, 1, 0, 0);
		drawSpikes();
		gl.glPopMatrix();
		// bottom face spikes
		gl.glPushMatrix();
		gl.glTranslatef(4, 0, -2);
		gl.glScalef(1, -1, 1);
		drawSpikes();
		gl.glPopMatrix();
		// top face spikes
		gl.glPushMatrix();
		gl.glTranslatef(4, 8, -2);
		drawSpikes();
		gl.glPopMatrix();
		// right face spikes
		gl.glPushMatrix();
		gl.glTranslatef(8, 4, -2);
		gl.glRotated(90, 0, 0, 1);
		gl.glScalef(1, -1, 1);
		drawSpikes();
		gl.glPopMatrix();
		// back face spikes
		gl.glPushMatrix();
		gl.glTranslatef(4, 2, -8);
		gl.glRotated(90, 1, 0, 0);
		gl.glScalef(1, -1, 1);
		drawSpikes();
		gl.glPopMatrix();
	}
	
	public void drawShip(){
		GL2 gl = drawable.getGL().getGL2();
		// use pre-made rectangles to make body of ship to allow color selection
		// Body
		// back face
		gl.glPushMatrix();
		gl.glScalef(2,0.5f,0.5f);
		drawRect(0,1,0);
		gl.glPopMatrix();
		// front face
		gl.glPushMatrix();
		gl.glTranslatef(0, 4, 0);
		gl.glScalef(2,0.5f,0.5f);
		drawRect(0,1,0);
		gl.glPopMatrix();
		// left face
		gl.glPushMatrix();
		gl.glRotatef(90, 0,0,1);
		gl.glScalef(1,0.5f,0.5f);
		drawRect(0,1,0);
		gl.glPopMatrix();
		// right face
		gl.glPushMatrix();
		gl.glTranslatef(8, 0, 0);
		gl.glRotatef(90, 0,0,1);
		gl.glScalef(1,0.5f,0.5f);
		drawRect(0,1,0);
		gl.glPopMatrix();
		// Top face
		gl.glPushMatrix();
		gl.glTranslatef(0, 0, -2);
		gl.glRotatef(90, 1,0,0);
		gl.glScalef(2, 1, 1);
		drawRect(0.5f,0,1);
		gl.glPopMatrix();
		// bottom face
		gl.glPushMatrix();
		gl.glRotatef(90, 1,0,0);
		gl.glScalef(2, 1, 1);
		drawRect(0.5f,0,1);
		gl.glPopMatrix();
		
		// Thrusters ------------------------
		
		// rear thrusters---------
		// bottom rear thruster
		gl.glPushMatrix();
		gl.glTranslatef(-0.5f,-2,0);
		gl.glScaled(0.5, 0.5, 0.5);
		drawCube();
		gl.glPopMatrix();
		// bottom rear thruster flame
		gl.glPushMatrix();
		gl.glTranslatef(-0.5f,-2,0);
		gl.glScaled(1.5f, 0.5, 0.5);
		gl.glRotatef(90, 0, 0, 1);
		drawPyramid(0,1,1);
		gl.glPopMatrix();
		// top rear thruster
		gl.glPushMatrix();
		gl.glTranslatef(-0.5f,4,0);
		gl.glScaled(0.5, 0.5, 0.5);
		drawCube();
		gl.glPopMatrix();
		// top rear thruster flame
		gl.glPushMatrix();
		gl.glTranslatef(-0.5f,4,0);
		gl.glScaled(1.5f, 0.5, 0.5);
		gl.glRotatef(90, 0, 0, 1);
		drawPyramid(0,1,1);
		gl.glPopMatrix();
		
		// front thrusters---------
		// bottom front thruster
		gl.glPushMatrix();
		gl.glTranslatef(6.5f,-2,0);
		gl.glScalef(0.5f, 0.5f, 0.5f);
		drawCube();
		gl.glPopMatrix();
		// bottom front thruster flame
		gl.glPushMatrix();
		gl.glTranslatef(6.5f,-2,0);
		gl.glScalef(1.5f, 0.5f, 0.5f);
		gl.glRotatef(90, 0, 0, 1);
		drawPyramid(0,1,1);
		gl.glPopMatrix();
		// top front thruster
		gl.glPushMatrix();
		gl.glTranslatef(6.5f,4,0);
		gl.glScalef(0.5f, 0.5f, 0.5f);
		drawCube();
		gl.glPopMatrix();
		// top front thruster flame
		gl.glPushMatrix();
		gl.glTranslatef(6.5f,4,0);
		gl.glScalef(1.5f, 0.5f, 0.5f);
		gl.glRotatef(90, 0, 0, 1);
		drawPyramid(0,1,1);
		gl.glPopMatrix();
		
		// cabin -------------------------
		gl.glPushMatrix();
		gl.glTranslatef(6.5f,1,2);
		gl.glScalef(0.5f, 0.5f, 0.5f);
		drawCube();
		gl.glPopMatrix();
	}
	
	public void drawTriangularPrism() {
		GL2 gl = drawable.getGL().getGL2();
		
		// bottom face
		gl.glBegin(gl.GL_POLYGON);
		gl.glColor3f(0, 0, 1);
		gl.glVertex3f(0, 0, 2);
		gl.glColor3f(1, 0, 0);
		gl.glVertex3f(0, 0, -2);
		gl.glColor3f(1, 1, 0);
		gl.glVertex3f(8, 0, -2);
		gl.glColor3f(0, 1, 0);
		gl.glVertex3f(8, 0, 2);
		gl.glEnd();
		
		// front face
		gl.glBegin(gl.GL_POLYGON);
		gl.glColor3f(0, 1, 1);
		gl.glVertex3f(0, 4, 0);
		gl.glVertex3f(8, 4, 0);
		gl.glVertex3f(8, 0, 2);
		gl.glVertex3f(0, 0, 2);
		gl.glEnd();
		
		// back face
		gl.glBegin(gl.GL_POLYGON);
		gl.glColor3f(1, 0, 1);
		gl.glVertex3f(0, 4, 0);
		gl.glVertex3f(8, 4, 0);
		gl.glVertex3f(8, 0, -2);
		gl.glVertex3f(0, 0, -2);
		gl.glEnd();
		
		// left side face
		gl.glBegin(gl.GL_POLYGON);
		gl.glColor3f(1, 0, 0);
		gl.glVertex3f(0, 0, -2);
		gl.glVertex3f(0, 4, 0);
		gl.glVertex3f(0, 0, 2);
		gl.glEnd();
		
		// right side face
		gl.glBegin(gl.GL_POLYGON);
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(8, 0, -2);
		gl.glVertex3f(8, 4, 0);
		gl.glVertex3f(8, 0, 2);
		gl.glEnd();
		
	}
	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
        gl.glClearColor(0.5f,0.5f,0.5f,1);
        
        // init display lists
        cubeDisplayList = gl.glGenLists(1);
        gl.glNewList(cubeDisplayList, GL2.GL_COMPILE);
        drawCube();
        gl.glEndList();
        
        pyramidDisplayList = gl.glGenLists(2);
        gl.glNewList(pyramidDisplayList, GL2.GL_COMPILE);
        drawPyramid(1,0,1);
        gl.glEndList();
        
        hextetrahedronDisplayList = gl.glGenLists(3);
        gl.glNewList(hextetrahedronDisplayList, GL2.GL_COMPILE);
        drawHextetrahedron();
        gl.glEndList();
        
        spikedCubeDisplayList = gl.glGenLists(4);
        gl.glNewList(spikedCubeDisplayList, GL2.GL_COMPILE);
        drawSpikedCube();
        gl.glEndList();
        
        shipDisplayList = gl.glGenLists(5);
        gl.glNewList(shipDisplayList, GL2.GL_COMPILE);
        drawShip();
        gl.glEndList();
        
        triangularPrismDisplayList = gl.glGenLists(6);
        gl.glNewList(triangularPrismDisplayList, GL2.GL_COMPILE);
        drawTriangularPrism();
        gl.glEndList();
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}

}
