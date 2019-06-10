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
	JLabel lblImg = new JLabel("");

	JTextField txtNombre = new JTextField(10);
	JTextField txtAtaque = new JTextField(10);
	JTextField txtDefensa = new JTextField(10);;
	JTextField txtPuntosSalud = new JTextField(10);
	JTextField txtTipo = new JTextField(10);

	JButton btnAceptar = new JButton("Aceptar");
	JButton btnMovimiento1 = new JButton("");
	JButton btnMovimiento2 = new JButton("");
	JButton btnMovimiento3 = new JButton("");
	JButton btnMovimiento4 = new JButton("");

	String [] arrayMovimientos = new String[4];
	int [] arrayMovimientosid = new int[4];

	JPanel pnlImagen = new JPanel();
	JPanel pnl = new JPanel();
	JPanel pnl1 = new JPanel();
	JPanel pnl2 = new JPanel();
	JPanel pnl3 = new JPanel();
	JPanel pnl4 = new JPanel();
	JPanel pnl5 = new JPanel();
	JPanel pnl6 = new JPanel();

	public EstadisticasPokemon(int idPokemon) 
	{
		this.setTitle("Estadísticas Pokemon");
		this.setSize(500,700);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(8,1));

		int idTipo = 0;

		ResultSet rs = bd.ejecutarSelect("SELECT * FROM pokemons where idPokemon ="+idPokemon+";", bd.conectar("juegoPokemon","usuarioJuego", "Studium2018;"));


		try {
			rs.next();
			lblImg.setIcon(new ImageIcon("imagenes/"+rs.getString("imagen")));
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
		ResultSet rs2 = bd.ejecutarSelect("SELECT * FROM tipos where idTipo="+idTipo+";",bd.conectar("juegoPokemon","usuarioJuego", "Studium2018;") );		
		try {
			rs2.next();

			txtTipo.setText(rs2.getString("nombreTipo"));
			txtTipo.setEditable(false);

		} catch (SQLException sqle)
		{
			JOptionPane.showMessageDialog(null,sqle.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}

		//CONSULTA DE MOVIMIENTOS 
		String consultaAtaquesJ1 = "SELECT * FROM lineaMovimientos join movimientos on idMovimiento = idMovimientoFK where idPokemonFK="+idPokemon+";";

		ResultSet rsMovimientos = bd.ejecutarSelect(consultaAtaquesJ1, bd.conectar("juegoPokemon","usuarioJuego", "Studium2018;"));
		try {

			int i=0;
			rsMovimientos.next();
			for(i=0;i<4;i++) 
			{
				arrayMovimientos[i]=rsMovimientos.getString("nombreMovimiento");
				arrayMovimientosid[i]=rsMovimientos.getInt("idMovimiento");
				rsMovimientos.next();
			}
			btnMovimiento1.setText(arrayMovimientos[0]);
			btnMovimiento2.setText(arrayMovimientos[1]);
			btnMovimiento3.setText(arrayMovimientos[2]);
			btnMovimiento4.setText(arrayMovimientos[3]);
			pnlImagen.add(lblImg);
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
			pnl5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Estadísticas de movimientos"));
			pnl5.add(btnMovimiento1);
			pnl5.add(btnMovimiento2);
			pnl5.add(btnMovimiento3);
			pnl5.add(btnMovimiento4);
			pnl6.add(btnAceptar);
			btnMovimiento1.addActionListener(this);
			btnMovimiento2.addActionListener(this);
			btnMovimiento3.addActionListener(this);
			btnMovimiento4.addActionListener(this);
			
			this.add(pnlImagen);
			this.add(pnl);
			this.add(pnl1);
			this.add(pnl2);
			this.add(pnl3);
			this.add(pnl4);
			this.add(pnl5);
			this.add(pnl6);


			this.addWindowListener(this);
			btnAceptar.addActionListener(this);
			this.setVisible(true);
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error 3", JOptionPane.ERROR_MESSAGE);
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
		//Movimientos
		else if(btnMovimiento1.equals(ae.getSource())) {
			new EstadisticaMovimiento(arrayMovimientosid[0]);
		}
		else if(btnMovimiento2.equals(ae.getSource())) {
			new EstadisticaMovimiento(arrayMovimientosid[1]);
		}
		else if(btnMovimiento3.equals(ae.getSource())) {
			new EstadisticaMovimiento(arrayMovimientosid[2]);
		}
		else if(btnMovimiento4.equals(ae.getSource())) {
			new EstadisticaMovimiento(arrayMovimientosid[3]);
		}
		
	}

}
