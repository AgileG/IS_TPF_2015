package main.java.headfirst.combined.djview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SubmarineView extends JPanel implements KeyListener, Runnable{
	
	ControllerInterface controller;
	SubmarineModelInterface model;
	Thread hilo;
	
	private Image Background;
	private Image explosion;
	private boolean dibujar, vivo, keyboard_on;
	private Image Oceano;
	
	private Image Submarino;
	

	public SubmarineView(ControllerInterface controller, SubmarineModelInterface model) {
		
		this.controller=controller;
		this.model=model;
		
		vivo = true;
		setFocusable(true);
		Oceano = new ImageIcon("Imagenes/Background.gif").getImage();
		Submarino = new ImageIcon("Imagenes/Submarino_fx.png").getImage();
		this.addKeyListener(this);
		dibujar = false;
		vivo = true;
		setFocusable(true);
		this.addKeyListener(this);
		Background = new ImageIcon("Data/Background2.0.jpg").getImage();
		explosion = new ImageIcon("Data/Explosion.gif").getImage();
		dibujar = false;
		keyboard_on=true;

	}
	
	public void run() {
		
		while (vivo)
		{
			repaint();			
		}
	}
	
	public void addNotify() {
		super.addNotify();
		hilo = new Thread(this);
		hilo.start();
		model.iniciarHilo();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(Oceano, 0, 0, null);		
		g2.drawImage(Submarino, model.getX(), model.getY(), null);
		g2.setFont(new Font("digital display tfb", Font.ITALIC, 75));
		g2.setColor(Color.red.darker());
		g2.drawString(""+model.getSegundos()+"."+model.getCentesimas(),30,75);

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		String aux = "";
		if(keyboard_on)
		{
			if (c==KeyEvent.VK_UP&&model.getY()>190)
			{			
				int y= model.getY() - 2;
				model.setY(y);
				Submarino = new ImageIcon("Imagenes/Submarino_fx_up.png").getImage();
			}
			
			if (c==KeyEvent.VK_DOWN&&model.getY()<570)
			{
				int y= model.getY() + 2;
				model.setY(y);
				Submarino = new ImageIcon("Imagenes/Submarino_fx_down.png").getImage();
			}
			
			if (c==KeyEvent.VK_RIGHT&&model.getX()<570)
			{
				int x= model.getX() + 2;
				model.setX(x);
				Submarino = new ImageIcon("Imagenes/Submarino_fx.png").getImage();
			}
			
			if (c==KeyEvent.VK_LEFT&&model.getX()>0)
			{
				int x= model.getX() - 2;
				model.setX(x);
				Submarino = new ImageIcon("Imagenes/Submarino_fx.png").getImage();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		String aux = "";
		
		if (c==KeyEvent.VK_UP)
		{
			//y-=1;
			Submarino = new ImageIcon("Imagenes/Submarino_fx.png").getImage();
		}
		
		if (c==KeyEvent.VK_DOWN)
		{
			//y+=1;
			Submarino = new ImageIcon("Imagenes/Submarino_fx.png").getImage();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}