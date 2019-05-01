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
	JLabel lblTipo = new JLabel("Tipo");
	JLabel lblPuntosSalud = new JLabel ("Puntos de Salud:");
	
	JTextField txtNombre = new JTextField(10);
	JTextField txtAtaque = new JTextField(10);
	JTextField txtDefensa = new JTextField(10);;
	JTextField txtPuntosSalud = new JTextField(10);
	JTextField txtTipo = new JTextField(10);
	
	JButton btnAceptar = new JButton("Aceptar");
	JPanel pnl = new JPanel();
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
		this.setLayout(new GridLayout(5,1));
		
		int idTipo = 0;
		
		ResultSet rs = bd.ejecutarSelect("SELECT * FROM pokemons where idPokemon ="+idPokemon+";", bd.conectar("juegoPokemon","root", "Studium2018;"));
		
		
		try {
			rs.next();
			idTipo = rs.getInt("idTipoFK");
			txtNombre.setText(rs.getString("nombrePokemon"));
			txtPuntosSalud.setText(rs.getString("puntosSalud"));
			txtAtaque.setText(rs.getString("ataque"));
			txtDefensa.setText(rs.getString("defensa"));
			txtNombre.setEditable(false);
			txtPuntosSalud.setEditable(false);
			txtAtaque.setEditable(false);
			txtDefensa.setEditable(false);
		} 
		
		catch (SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,sqle.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		ResultSet rs2 = bd.ejecutarSelect("SELECT * FROM tipos where idTipo="+idTipo+";",bd.conectar("juegoPokemon","root", "Studium2018;") );		
		try {
			rs2.next();

			txtTipo.setText(rs2.getString("nombreTipo"));
			txtTipo.setEditable(false);
			
		} catch (SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,sqle.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		pnl.add(lblNombre);
		pnl.add(txtNombre);
		pnl1.add(lblPuntosSalud);
		pnl1.add(txtPuntosSalud);
		pnl2.add(lblAtaque);
		pnl2.add(txtAtaque);
		pnl3.add(lblDefensa);
		pnl3.add(txtDefensa);
		pnl4.add(lblTipo);
		pnl4.add(txtTipo);
		pnl5.add(btnAceptar);
		
		this.add(pnl);
		this.add(pnl1);
		this.add(pnl2);
		this.add(pnl3);
		this.add(pnl4);
		this.add(pnl5);

		
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
