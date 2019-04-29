package es.studium.Juego;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;

import javax.swing.*;


public class Seleccion1 extends JFrame implements WindowListener, ActionListener
{
	
	private static final long serialVersionUID = 1L;
	JLabel lblSeleccionar = new JLabel("Selecciona Pokemon: ");
	JLabel lblBUscar = new JLabel("Buscar:");
	BaseDatos bd = new BaseDatos();
	JTextField txtBuscar = new JTextField (10);
	Choice Pokemons = new Choice ();
	
	JButton btnAceptar = new JButton ("Aceptar");
	JButton btnEstadisticas = new JButton("Estadísticas");
	
	JPanel pnluno = new JPanel();
	JPanel pnldos = new JPanel();
	JPanel pnltres = new JPanel();
	JPanel pnlcuatro = new JPanel();
	
	
	public Seleccion1() 
	{
		this.setTitle("Jugador 1");
		this.setLocationRelativeTo(null);
		this.setSize(300,250);
		this.setLayout(new GridLayout(4,1));
		
		ResultSet rs = bd.ejecutarSelect("SELECT * FROM pokemons", bd.conectar("juegoPokemon","root", "Studium2018;"));
		try {
			while(rs.next())
			{
				String pokemon=Integer.toString(rs.getInt("idPokemon"));
				pokemon = pokemon+".-"+rs.getString("nombrePokemon");
				Pokemons.add(pokemon);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		bd.desconectar( bd.conectar("juegoPokemon","root", "Studium2018;"));
		
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
	public void actionPerformed(ActionEvent ae) {
		if(btnAceptar.equals(ae.getSource())) {
			
			this.setVisible(false);
		}
		if(btnEstadisticas.equals(ae.getSource())) {
			
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
