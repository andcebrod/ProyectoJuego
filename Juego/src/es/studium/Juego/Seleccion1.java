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
	
	String jugador1="";
	String jugador2="";
	
	
	public Seleccion1(String j1, String j2) 
	{
		jugador1 = j1;
		jugador2 = j2;
		this.setTitle(jugador1+" ¡Elige Pokémon!");
		this.setLocationRelativeTo(null);
		this.setSize(350,250);
		this.setLayout(new GridLayout(4,1));
		
		//Rellenar choice con Pokemons
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
		
		pnltres.add(Pokemons);
		this.add(pnltres);
		
		pnlcuatro.add(btnAceptar);
		pnlcuatro.add(btnEstadisticas);
		btnAceptar.addActionListener(this);
		btnEstadisticas.addActionListener(this);
		this.add(pnlcuatro);
		
		this.setVisible(true);
		addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(btnAceptar.equals(ae.getSource())) 
		{
			int idJugador = 0;
			String[] array= Pokemons.getSelectedItem().toString().split(".-");
			int idPokemon = Integer.parseInt(array[0]);
			bd.ejecutarIDA("INSERT INTO jugadores VALUES (null,'"+jugador1+"',"+idPokemon+");", bd.conectar("juegoPokemon","root", "Studium2018;"));
			JOptionPane.showMessageDialog(null,"Primer Jugador añadido!","Jugador añadido", JOptionPane.INFORMATION_MESSAGE);
			ResultSet jugadorCreado = bd.ejecutarSelect("SELECT idJugador FROM jugadores ORDER BY idJugador DESC;", bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
				jugadorCreado.next();
				idJugador = jugadorCreado.getInt("idJugador");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
			}
			
			this.setVisible(false);
			new Seleccion2(jugador2, idJugador);
		}
		if(btnEstadisticas.equals(ae.getSource())) {
			String[] array= Pokemons.getSelectedItem().toString().split(".-");
			int idPokemon = Integer.parseInt(array[0]);
			new EstadisticasPokemon(idPokemon);
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
		this.setVisible(false);
		new MenuPrincipal();
		
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
