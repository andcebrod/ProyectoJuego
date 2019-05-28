package es.studium.Juego;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Top10 extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	JPanel pnlPrimero = new JPanel();
	BaseDatos bd = new BaseDatos();
	
	JLabel lblPartidas = new JLabel("Mejores Jugadores");
	
	DefaultTableModel modelo = new DefaultTableModel();
	JTable tablaJugadores = new JTable(modelo);
	
	JButton btnOk = new JButton("Ok");
	
	JPanel pnlBtn = new JPanel();
	
	
	public Top10()
	{

		this.setTitle("Top 10");
		this.setLocationRelativeTo(null);
		this.setSize(549,354);
		this.setLayout(new GridLayout(3,1));
		pnlBtn.setLayout(new FlowLayout());
		modelo.addColumn("Nombre Jugador");
		modelo.addColumn("Puntuación");
		pnlPrimero.setLayout(new FlowLayout());
		
		ResultSet rs = bd.ejecutarSelect("SELECT nombreJugador, puntuacion FROM jugadores JOIN puntuaciones WHERE idJugador = idJugadorFK ORDER BY puntuacion ASC;", bd.conectar("juegoPokemon","root", "Studium2018;"));		
		try {
			while (rs.next())
			{

			   Object [] fila = new Object[2];

			   for (int i=0;i<2;i++) {
			    	 fila[i] = rs.getObject(i+1);
			   }
			   modelo.addRow(fila); 
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		bd.desconectar(bd.conectar("juegoPokemon","root" ,"Studium2018;"));
		
		this.add(pnlPrimero);
		pnlPrimero.add(lblPartidas);
		
		this.add(new JScrollPane(tablaJugadores),BorderLayout.CENTER);
		pnlBtn.add(btnOk);
		this.add(pnlBtn,BorderLayout.SOUTH);
		btnOk.addActionListener(this);
		this.addWindowListener(this);
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

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(btnOk.equals(ae.getSource())) {
			this.setVisible(false);
			new MenuPrincipal();
		}
		
	}

}
