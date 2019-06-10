package es.studium.Juego;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EstadisticaMovimiento extends JFrame implements WindowListener, ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblNombre = new JLabel("Nombre:");
	JLabel lblDanio = new JLabel("Daño:");
	JLabel lblTipo = new JLabel("Tipo:");
	JTextField txtNombre = new JTextField(10);
	JTextField txtDanio = new JTextField(10);
	JTextField txtTipo = new JTextField(10);
	JButton btnAceptar = new JButton("Aceptar");
	
	JPanel pnl1 = new JPanel();
	JPanel pnl2 = new JPanel();
	JPanel pnl3 = new JPanel();
	JPanel pnl4 = new JPanel();
	BaseDatos bd = new BaseDatos();
	
	public EstadisticaMovimiento(int idMovimiento) 
	{
		this.setLayout(new GridLayout(4,1));
		this.setLocationRelativeTo(null);
		this.setSize(500,300);
		//Rellenar Estadísticas.
		ResultSet Mov = bd.ejecutarSelect("select nombreMovimiento, danioMovimiento, nombreTipo from movimientos, tipos where idTipoFK = idTipo and idMovimiento ="+idMovimiento+";", 
				bd.conectar("juegoPokemon", "usuarioJuego", "Studium2018;"));
		try {
		Mov.next();
		txtNombre.setText(Mov.getString("nombreMovimiento"));
		txtDanio.setText(Mov.getString("danioMovimiento"));
		txtTipo.setText(Mov.getString("nombreTipo"));
		pnl1.add(lblNombre);
		pnl1.add(txtNombre);
		txtNombre.setEditable(false);
		pnl2.add(lblDanio);
		pnl2.add(txtDanio);
		txtDanio.setEditable(false);
		pnl3.add(lblTipo);
		pnl3.add(txtTipo);
		txtTipo.setEditable(false);
		pnl4.add(btnAceptar);
		btnAceptar.addActionListener(this);
		this.add(pnl1);
		this.add(pnl2);
		this.add(pnl3);
		this.add(pnl4);
		this.setVisible(true);
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		bd.desconectar(bd.conectar("juegoPokemon", "usuarioJuego", "Studium2018;"));
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(btnAceptar.equals(ae.getSource())) {
			this.setVisible(false);
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
