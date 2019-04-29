package es.studium.Juego;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class EstadisticasPokemon extends JFrame implements WindowListener, ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BaseDatos bd = new BaseDatos();
	
	JLabel lblNombre = new JLabel("Nombre:");
	JLabel lblAtaque = new JLabel("Ataque:");
	JLabel lblDefensa = new JLabel ("Defensa:");
	JLabel lblVelocidad = new JLabel("Velocidad:");
	JLabel lblAtaqueEsp = new JLabel ("Ataque Especial:");
	JLabel lblDefensaEsp = new JLabel ("Defensa Especial:");
	JLabel lblTipo1 = new JLabel("Tipo 1:");
	JLabel lblTipo2 = new JLabel("Tipo 2:");
	
	JTextField txtNombre = new JTextField(10);
	JTextField txtAtaque = new JTextField(10);
	JTextField txtDefensa = new JTextField(10);
	JTextField txtVelocidad = new JTextField(10);
	JTextField txtAtaqueEsp = new JTextField(10);
	JTextField txtDefensaEsp = new JTextField(10);
	JTextField txtTipo1 = new JTextField(10);
	JTextField txtTipo2 = new JTextField(10);
	
	JButton btnAceptar = new JButton("Aceptar");

	JPanel pnl1 = new JPanel();
	JPanel pnl2 = new JPanel();
	JPanel pnl3 = new JPanel();
	JPanel pnl4 = new JPanel();
	JPanel pnl5 = new JPanel();
	JPanel pnl6 = new JPanel();
	JPanel pnl7 = new JPanel();
	JPanel pnl8 = new JPanel();
	JPanel pnl9 = new JPanel();
	
	public EstadisticasPokemon(int idPokemon) 
	{
		this.setTitle("Estadísticas Pokemon");
		this.setSize(300,600);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(9,1));
		
		int idTipo1 = 0;
		int idTipo2 = 0;
		
		ResultSet rs = bd.ejecutarSelect("SELECT * FROM pokemons where idPokemon ="+idPokemon+";", bd.conectar("juegoPokemon","root", "Studium2018;"));
		
		
		try {
			rs.next();
			idTipo1 = rs.getInt("idTipo1FK");
			idTipo2 = rs.getInt("idTipo2FK");
			
			txtNombre.setText(rs.getString("nombrePokemon"));
			txtAtaque.setText(rs.getString("ataque"));
			txtDefensa.setText(rs.getString("defensa"));
			txtVelocidad.setText(rs.getString("velocidad"));
			txtAtaqueEsp.setText(rs.getString("ataqueEspecial"));
			txtDefensaEsp.setText(rs.getString("defensaEspecial"));
			
		} 
		
		catch (SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,sqle.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		ResultSet rs2 = bd.ejecutarSelect("SELECT * FROM tipos where idTipo="+idTipo1+";",bd.conectar("juegoPokemon","root", "Studium2018;") );
		ResultSet rs3 = bd.ejecutarSelect("SELECT * FROM tipos where idTipo="+idTipo2+";",bd.conectar("juegoPokemon","root", "Studium2018;") );
		
		try {
			rs2.next();
			rs3.next();
			txtTipo1.setText(rs2.getString("nombreTipo"));
			txtTipo2.setText(rs3.getString("nombreTipo"));
			
		} catch (SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,sqle.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}

		pnl1.add(lblNombre);
		pnl1.add(txtNombre);
		pnl2.add(lblAtaque);
		pnl2.add(txtAtaque);
		pnl3.add(lblDefensa);
		pnl3.add(txtDefensa);
		pnl4.add(lblVelocidad);
		pnl4.add(txtVelocidad);
		pnl5.add(lblAtaqueEsp);
		pnl5.add(txtAtaqueEsp);
		pnl6.add(lblDefensaEsp);
		pnl6.add(txtDefensaEsp);
		pnl7.add(lblTipo1);
		pnl7.add(txtTipo1);
		pnl8.add(lblTipo2);
		pnl8.add(txtTipo2);
		pnl9.add(btnAceptar);
		
		this.add(pnl1);
		this.add(pnl2);
		this.add(pnl3);
		this.add(pnl4);
		this.add(pnl5);
		this.add(pnl6);
		this.add(pnl7);
		this.add(pnl8);
		this.add(pnl9);
		this.addWindowListener(this);
		btnAceptar.addActionListener(this);
		this.setVisible(true);
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
		// TODO Auto-generated method stub
		this.setVisible(false);
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

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(btnAceptar.equals(ae.getSource())) {
			this.setVisible(false);
		}
	}

}
