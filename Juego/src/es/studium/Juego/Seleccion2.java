package es.studium.Juego;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;


public class Seleccion2 extends JFrame implements WindowListener, ActionListener, TextListener
{
	
	private static final long serialVersionUID = 1L;
	JLabel lblSeleccionar = new JLabel("Selecciona Pokemon: ");
	JLabel lblBUscar = new JLabel("Buscar:");
	
	JTextField txtBuscar = new JTextField (10);
	Choice Pokemons = new Choice ();
	
	JButton btnAceptar = new JButton ("Aceptar");
	
	JPanel pnluno = new JPanel();
	JPanel pnldos = new JPanel();
	JPanel pnltres = new JPanel();
	JPanel pnlcuatro = new JPanel();
	
	
	public Seleccion2(String jugador2) 
	{
		
		this.setTitle(jugador2);
		this.setLocationRelativeTo(null);
		this.setSize(300,250);
		this.setLayout(new GridLayout(4,1));
		
		
		
		pnluno.add(lblSeleccionar);
		this.add(pnluno);
		
		pnldos.add(lblBUscar);
		pnldos.add(txtBuscar);
		this.add(pnldos);
		
		pnltres.add(Pokemons);
		this.add(pnltres);
		
		pnlcuatro.add(btnAceptar);
		btnAceptar.addActionListener(this);
		this.add(pnlcuatro);
		
		
		this.setVisible(true);
		addWindowListener(this);
	}

	@Override
	public void textValueChanged(TextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(btnAceptar.equals(ae.getSource())) {
			
			this.setVisible(false);
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

