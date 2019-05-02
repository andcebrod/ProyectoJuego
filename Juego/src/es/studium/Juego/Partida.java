package es.studium.Juego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Partida extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	int turno = 1;

	BaseDatos bd = new BaseDatos();
	Funciones f = new Funciones();

	JPanel pnluno = new JPanel();
	JPanel pnldos = new JPanel();
	JPanel pnltres = new JPanel();
	JPanel pnlcuatro = new JPanel();

	Border bordejpanel = new TitledBorder(new EtchedBorder());

	JPanel pnlVida1 = new JPanel();
	JPanel pnlPkm1 = new JPanel();

	JPanel pnlVida2 = new JPanel();
	JPanel pnlPkm2 = new JPanel();

	JPanel pnlMovimientos = new JPanel();
	JPanel pnlMovimientosJ1 = new JPanel();
	JPanel pnlMovimientosJ2 = new JPanel();

	JPanel pnlOpciones = new JPanel();

	JPanel pnlTranscurso = new JPanel();

	JLabel lblQueHacer = new JLabel("¿Qué quieres hacer?");
	JLabel lblAtaque = new JLabel("");
	JLabel lblDanio = new JLabel("");

	JLabel lblVida1 = new JLabel("");
	JLabel lblVida2 = new JLabel("");
	JLabel lblPkm1 = new JLabel("");
	JLabel lblPkm2 = new JLabel("");

	JProgressBar PBvida1;
	JProgressBar PBvida2;

	JButton btnAtacar = new JButton ("Atacar");
	JButton btnRendirse = new JButton ("Rendirse");

	JButton btnSi = new JButton ("Sí");
	JButton btnNo = new JButton ("No");

	JButton btnAtaque1J1 = new JButton ("");
	JButton btnAtaque2J1 = new JButton ("");
	JButton btnAtaque3J1 = new JButton ("");
	JButton btnAtaque4J1 = new JButton ("");

	JButton btnAtaque1J2 = new JButton ("");
	JButton btnAtaque2J2 = new JButton ("");
	JButton btnAtaque3J2 = new JButton ("");
	JButton btnAtaque4J2 = new JButton ("");

	JDialog dlgRendirse = new JDialog();
	JDialog dlgFin = new JDialog();

	JLabel lblRendirse = new JLabel("¿Está seguro de rendirte?");
	JLabel lblFin = new JLabel("Fin de la Partida.");
	int vidaRestada;
	String consultaJ1 = "";
	String consultaJ2 = "";


	String consultaAtaquesJ1;
	String consultaAtaquesJ2;
	int ataque, defensa, idAtaque, tipoPkm;

	public Partida(int idJ1,int idJ2) 
	{

		this.setTitle("Batalla");
		this.setLayout(new GridLayout(4,1));
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);

		consultaJ1 = "select * from jugadores join pokemons on idPokemonFK = idPokemon where idJugador ="+idJ1+";";
		consultaJ2 = "select * from jugadores join pokemons on idPokemonFK = idPokemon where idJugador ="+idJ2+";";

		ResultSet rsJ1 = bd.ejecutarSelect(consultaJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
		

		try {
			rsJ1.next();
			
			PBvida1 = new JProgressBar(0,rsJ1.getInt("puntosSalud"));

			PBvida1.setValue(rsJ1.getInt("puntosSalud"));
			pnlVida1.setLayout(new FlowLayout());
			pnlVida1.setBorder(bordejpanel);

			lblPkm1.setText(rsJ1.getString("nombrePokemon"));
			pnlVida1.add(lblPkm1);

			lblVida1.setText("PS: "+PBvida1.getValue());
			pnlVida1.add(lblVida1);
			pnlVida1.add(PBvida1);

			pnluno.add(pnlVida1);
			pnluno.add(pnlPkm1);
			this.add(pnluno);
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error 1 ", JOptionPane.ERROR_MESSAGE);
		}
			
			ResultSet rsJ2 = bd.ejecutarSelect(consultaJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
			rsJ2.next();
			PBvida2 = new JProgressBar(0,rsJ2.getInt("puntosSalud"));
			PBvida2.setValue(rsJ2.getInt("puntosSalud"));
			pnlVida2.setLayout(new FlowLayout());
			pnlVida2.setBorder(bordejpanel);
			lblPkm2.setText(rsJ2.getString("nombrePokemon"));
			pnlVida2.add(lblPkm2);
			lblVida2.setText("PS: "+PBvida2.getValue());
			pnlVida2.add(lblVida2);
			pnlVida2.add(PBvida2);
			pnldos.add(pnlVida2);
			pnldos.add(pnlPkm2);
			this.add(pnldos);

			pnlMovimientos.setVisible(false);
			pnlMovimientos.setLayout(new FlowLayout());
			pnlMovimientos.setBorder(bordejpanel);
			pnlMovimientosJ1.setLayout(new GridLayout(2,2));
			
			
			consultaAtaquesJ1 = "SELECT * FROM lineaMovimientos join movimientos on idMovimiento = idMovimientoFK where idPokemonFK="+rsJ1.getInt("idPokemonFK")+";";
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error 2", JOptionPane.ERROR_MESSAGE);
			}
			ResultSet rsMovimientos = bd.ejecutarSelect(consultaAtaquesJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
			String [] arrayMovimientos = new String[4];
			int i=0;
			rsMovimientos.next();
			for(i=0;i<4;i++) 
			{
				arrayMovimientos[i]=rsMovimientos.getString("nombreMovimiento");
				rsMovimientos.next();
			}
			
			btnAtaque1J1.setText(arrayMovimientos[0]);
			pnlMovimientosJ1.add(btnAtaque1J1);
			btnAtaque1J1.addActionListener(this);

			btnAtaque2J1.setText(arrayMovimientos[1]);
			pnlMovimientosJ1.add(btnAtaque2J1);
			btnAtaque2J1.addActionListener(this);

			btnAtaque3J1.setText(arrayMovimientos[2]);
			pnlMovimientosJ1.add(btnAtaque3J1);
			btnAtaque3J1.addActionListener(this);

			btnAtaque4J1.setText(arrayMovimientos[3]);
			pnlMovimientosJ1.add(btnAtaque4J1);
			btnAtaque4J1.addActionListener(this);
			
			
			pnlMovimientosJ2.setLayout(new GridLayout(2,2));
			
			
			consultaAtaquesJ2 = "SELECT * FROM lineaMovimientos join movimientos on idMovimiento = idMovimientoFK where idPokemonFK="+rsJ2.getInt("idPokemonFK")+";";
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error 3", JOptionPane.ERROR_MESSAGE);
			}
				
			ResultSet rsMovimientos2 = bd.ejecutarSelect(consultaAtaquesJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
			String [] arrayMovimientos2 = new String[4];
			int j=0;
			rsMovimientos2.next();
			for(j=0;j<4;j++) 
			{
				arrayMovimientos2[j]=rsMovimientos2.getString("nombreMovimiento");
				rsMovimientos2.next();
			}
			btnAtaque1J2.setText(arrayMovimientos2[0]);
			pnlMovimientosJ2.add(btnAtaque1J2);
			btnAtaque1J2.addActionListener(this);

			btnAtaque2J2.setText(arrayMovimientos2[1]);
			pnlMovimientosJ2.add(btnAtaque2J2);
			btnAtaque2J2.addActionListener(this);

			btnAtaque3J2.setText(arrayMovimientos2[2]);
			pnlMovimientosJ2.add(btnAtaque3J2);
			btnAtaque3J2.addActionListener(this);

			btnAtaque4J2.setText(arrayMovimientos2[3]);
			pnlMovimientosJ2.add(btnAtaque4J2);
			btnAtaque4J2.addActionListener(this);
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error 4", JOptionPane.ERROR_MESSAGE);
			}
			
			pnltres.add(pnlMovimientos);

			pnlOpciones.setLayout(new GridLayout(2,1));
			pnlOpciones.setBorder(bordejpanel);
			pnlOpciones.add(btnAtacar);
			btnAtacar.addActionListener(this);
			pnlOpciones.add(btnRendirse);
			btnRendirse.addActionListener(this);
			pnltres.add(pnlOpciones);
			this.add(pnltres);

			pnlTranscurso.setLayout(new FlowLayout());
			pnlTranscurso.setBorder(bordejpanel);
			pnlTranscurso.add(lblQueHacer);
			pnlcuatro.add(pnlTranscurso);
			this.add(pnlcuatro);


			dlgRendirse.setSize(200,100);
			dlgRendirse.setTitle("Rendirse");
			dlgRendirse.setLayout(new FlowLayout());
			dlgRendirse.add(lblRendirse);
			dlgRendirse.add(btnSi);
			btnSi.addActionListener(this);
			dlgRendirse.add(btnNo);
			btnNo.addActionListener(this);
			dlgRendirse.setLocationRelativeTo(null);

			dlgFin.setSize(200,100);
			dlgFin.setTitle("Fin de Partida");
			dlgFin.setLayout(new FlowLayout());
			dlgFin.setLocationRelativeTo(null);
			dlgFin.add(lblFin);

			this.addWindowListener(this);
			this.setVisible(true);

		

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//RENDIRSE 
		if (btnRendirse.equals(ae.getSource())) 
		{
			dlgRendirse.setVisible(true);
		}

		if(btnSi.equals(ae.getSource())) {
			dlgRendirse.setVisible(false);
			dlgFin.setVisible(true);
			this.setVisible(false);
			new MenuPrincipal();


		} else if(btnNo.equals(ae.getSource())) {
			dlgRendirse.setVisible(false);
		}

		//PELEA
		if(btnAtacar.equals(ae.getSource())) {
			pnlMovimientos.setVisible(true);
		}
		//ATAQUES J1
		if(btnAtaque1J1.equals(ae.getSource())) 
		{
			ResultSet rsJ1m = bd.ejecutarSelect(consultaJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
			ResultSet rsJ2m = bd.ejecutarSelect(consultaJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));
			ResultSet rsMov = bd.ejecutarSelect("SELECT * FROM movimientos where nombreMovimiento ="+btnAtaque1J1.getText()+";", bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
				rsJ1m.next();
				rsJ2m.next();
				rsMov.next();
				pnlMovimientos.setVisible(false);
				pnlTranscurso.remove(lblQueHacer);
				lblAtaque.setText(rsJ1m.getString("nombrePokemon")+" Usó "+btnAtaque1J1.getText());
				pnlTranscurso.add(lblAtaque);

				ataque = rsJ1m.getInt("ataque");
				defensa = rsJ2m.getInt("defensa");
				idAtaque = rsMov.getInt("idMovimiento");
				tipoPkm = rsJ2m.getInt("idTipoFK");

				vidaRestada = f.calcularDanio(ataque, defensa, idAtaque, tipoPkm);
				PBvida1.setValue(PBvida1.getValue()-vidaRestada);
				lblDanio.setText(rsJ2m.getString("nombrePokemon")+" pierde "+vidaRestada+" PS");
				pnlTranscurso.add(lblDanio);
				pnlTranscurso.add(lblQueHacer);
				turno=turno+1;
			} catch (SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error A1J1", JOptionPane.ERROR_MESSAGE);
			}

		} 
		else if (btnAtaque2J1.equals(ae.getSource()))
		{
			ResultSet rsJ1m = bd.ejecutarSelect(consultaJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
			ResultSet rsJ2m = bd.ejecutarSelect(consultaJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));

			ResultSet rsMov = bd.ejecutarSelect("SELECT * FROM movimientos where nombreMovimiento ="+btnAtaque2J1.getText()+";", bd.conectar("juegoPokemon","root", "Studium2018;"));

			try {
				rsJ1m.next();
				rsJ2m.next();
				rsMov.next();
				pnlMovimientos.setVisible(false);
				pnlTranscurso.remove(lblQueHacer);
				lblAtaque.setText(rsJ1m.getString("nombrePokemon")+" Usó "+btnAtaque2J1.getText());
				pnlTranscurso.add(lblAtaque);

				ataque = rsJ1m.getInt("ataque");
				defensa = rsJ2m.getInt("defensa");
				idAtaque = rsMov.getInt("idMovimiento");
				tipoPkm = rsJ2m.getInt("idTipoFK");

				vidaRestada = f.calcularDanio(ataque, defensa, idAtaque, tipoPkm);
				PBvida1.setValue(PBvida1.getValue()-vidaRestada);
				lblDanio.setText(rsJ2m.getString("nombrePokemon")+" pierde "+vidaRestada+" PS");
				pnlTranscurso.add(lblDanio);
				pnlTranscurso.add(lblQueHacer);
				turno=turno+1;
			} catch (SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error A2J1", JOptionPane.ERROR_MESSAGE);
			}
		} 
		else if(btnAtaque3J1.equals(ae.getSource())) 
		{
			ResultSet rsJ1m = bd.ejecutarSelect(consultaJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
			ResultSet rsJ2m = bd.ejecutarSelect(consultaJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));

			ResultSet rsMov = bd.ejecutarSelect("SELECT * FROM movimientos where nombreMovimiento ="+btnAtaque3J1.getText()+";", bd.conectar("juegoPokemon","root", "Studium2018;"));

			try {
				rsJ1m.next();
				rsJ2m.next();
				rsMov.next();
				pnlMovimientos.setVisible(false);
				pnlTranscurso.remove(lblQueHacer);
				lblAtaque.setText(rsJ1m.getString("nombrePokemon")+" Usó "+btnAtaque3J1.getText());
				pnlTranscurso.add(lblAtaque);

				ataque = rsJ1m.getInt("ataque");
				defensa = rsJ2m.getInt("defensa");
				idAtaque = rsMov.getInt("idMovimiento");
				tipoPkm = rsJ2m.getInt("idTipoFK");

				vidaRestada = f.calcularDanio(ataque, defensa, idAtaque, tipoPkm);
				PBvida1.setValue(PBvida1.getValue()-vidaRestada);
				lblDanio.setText(rsJ2m.getString("nombrePokemon")+" pierde "+vidaRestada+" PS");
				pnlTranscurso.add(lblDanio);
				pnlTranscurso.add(lblQueHacer);
				turno=turno+1;
			} catch (SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error A3J1", JOptionPane.ERROR_MESSAGE);
			}
		} 
		else if(btnAtaque4J1.equals(ae.getSource())) 
		{
			ResultSet rsJ1m = bd.ejecutarSelect(consultaJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
			ResultSet rsJ2m = bd.ejecutarSelect(consultaJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));

			ResultSet rsMov = bd.ejecutarSelect("SELECT * FROM movimientos where nombreMovimiento ="+btnAtaque4J1.getText()+";", bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
				rsJ1m.next();
				rsJ2m.next();
				rsMov.next();
				pnlMovimientos.setVisible(false);
				pnlTranscurso.remove(lblQueHacer);
				lblAtaque.setText(rsJ1m.getString("nombrePokemon")+" Usó "+btnAtaque4J1.getText());
				pnlTranscurso.add(lblAtaque);

				ataque = rsJ1m.getInt("ataque");
				defensa = rsJ2m.getInt("defensa");
				idAtaque = rsMov.getInt("idMovimiento");
				tipoPkm = rsJ2m.getInt("idTipoFK");

				vidaRestada = f.calcularDanio(ataque, defensa, idAtaque, tipoPkm);
				PBvida1.setValue(PBvida1.getValue()-vidaRestada);
				lblDanio.setText(rsJ2m.getString("nombrePokemon")+" pierde "+vidaRestada+" PS");
				pnlTranscurso.add(lblDanio);
				pnlTranscurso.add(lblQueHacer);
				turno=turno+1;
			} catch (SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error A4J1", JOptionPane.ERROR_MESSAGE);
			}
		} 

		//ATAQUES J2
		if(btnAtaque1J2.equals(ae.getSource())) 
		{
			ResultSet rsJ1m = bd.ejecutarSelect(consultaJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
			ResultSet rsJ2m = bd.ejecutarSelect(consultaJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));

			ResultSet rsMov = bd.ejecutarSelect("SELECT * FROM movimientos where nombreMovimiento ="+btnAtaque1J2.getText()+";", bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
				rsJ1m.next();
				rsJ2m.next();
				rsMov.next();
				pnlMovimientos.setVisible(false);
				pnlTranscurso.remove(lblQueHacer);
				lblAtaque.setText(rsJ2m.getString("nombrePokemon")+" Usó "+btnAtaque1J2.getText());
				pnlTranscurso.add(lblAtaque);

				ataque = rsJ2m.getInt("ataque");
				defensa = rsJ1m.getInt("defensa");
				idAtaque = rsMov.getInt("idMovimiento");
				tipoPkm = rsJ1m.getInt("idTipoFK");

				vidaRestada = f.calcularDanio(ataque, defensa, idAtaque, tipoPkm);
				PBvida1.setValue(PBvida1.getValue()-vidaRestada);
				lblDanio.setText(rsJ1m.getString("nombrePokemon")+" pierde "+vidaRestada+" PS");
				pnlTranscurso.add(lblDanio);
				pnlTranscurso.add(lblQueHacer);
				turno=turno+1;
			} catch (SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error A1J2", JOptionPane.ERROR_MESSAGE);
			}
		} 
		else if (btnAtaque2J2.equals(ae.getSource()))
		{
			ResultSet rsJ1m = bd.ejecutarSelect(consultaJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
			ResultSet rsJ2m = bd.ejecutarSelect(consultaJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));

			ResultSet rsMov = bd.ejecutarSelect("SELECT * FROM movimientos where nombreMovimiento ="+btnAtaque2J2.getText()+";", bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
				rsJ1m.next();
				rsJ2m.next();
				rsMov.next();
				pnlMovimientos.setVisible(false);
				pnlTranscurso.remove(lblQueHacer);
				lblAtaque.setText(rsJ2m.getString("nombrePokemon")+" Usó "+btnAtaque2J2.getText());
				pnlTranscurso.add(lblAtaque);

				ataque = rsJ2m.getInt("ataque");
				defensa = rsJ1m.getInt("defensa");
				idAtaque = rsMov.getInt("idMovimiento");
				tipoPkm = rsJ1m.getInt("idTipoFK");

				vidaRestada = f.calcularDanio(ataque, defensa, idAtaque, tipoPkm);
				PBvida1.setValue(PBvida1.getValue()-vidaRestada);
				lblDanio.setText(rsJ1m.getString("nombrePokemon")+" pierde "+vidaRestada+" PS");
				pnlTranscurso.add(lblDanio);
				pnlTranscurso.add(lblQueHacer);
				turno=turno+1;
			} catch (SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error A2J2", JOptionPane.ERROR_MESSAGE);
			}
		} 
		else if(btnAtaque3J2.equals(ae.getSource())) 
		{
			ResultSet rsJ1m = bd.ejecutarSelect(consultaJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
			ResultSet rsJ2m = bd.ejecutarSelect(consultaJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));

			ResultSet rsMov = bd.ejecutarSelect("SELECT * FROM movimientos where nombreMovimiento ="+btnAtaque3J2.getText()+";", bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
				rsJ1m.next();
				rsJ2m.next();
				rsMov.next();
				pnlMovimientos.setVisible(false);
				pnlTranscurso.remove(lblQueHacer);
				lblAtaque.setText(rsJ2m.getString("nombrePokemon")+" Usó "+btnAtaque3J2.getText());
				pnlTranscurso.add(lblAtaque);

				ataque = rsJ2m.getInt("ataque");
				defensa = rsJ1m.getInt("defensa");
				idAtaque = rsMov.getInt("idMovimiento");
				tipoPkm = rsJ1m.getInt("idTipoFK");

				vidaRestada = f.calcularDanio(ataque, defensa, idAtaque, tipoPkm);
				PBvida1.setValue(PBvida1.getValue()-vidaRestada);
				lblDanio.setText(rsJ1m.getString("nombrePokemon")+" pierde "+vidaRestada+" PS");
				pnlTranscurso.add(lblDanio);
				pnlTranscurso.add(lblQueHacer);
				turno=turno+1;
			} catch (SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error A3J2", JOptionPane.ERROR_MESSAGE);
			}
		} 
		else if(btnAtaque4J2.equals(ae.getSource())) 
		{
			ResultSet rsJ1m = bd.ejecutarSelect(consultaJ1, bd.conectar("juegoPokemon","root", "Studium2018;"));
			ResultSet rsJ2m = bd.ejecutarSelect(consultaJ2, bd.conectar("juegoPokemon","root", "Studium2018;"));

			ResultSet rsMov = bd.ejecutarSelect("SELECT * FROM movimientos where nombreMovimiento ="+btnAtaque4J2.getText()+";", bd.conectar("juegoPokemon","root", "Studium2018;"));
			try {
				rsJ1m.next();
				rsJ2m.next();
				rsMov.next();
				pnlMovimientos.setVisible(false);
				pnlTranscurso.remove(lblQueHacer);
				lblAtaque.setText(rsJ2m.getString("nombrePokemon")+" Usó "+btnAtaque4J2.getText());
				pnlTranscurso.add(lblAtaque);

				ataque = rsJ2m.getInt("ataque");
				defensa = rsJ1m.getInt("defensa");
				idAtaque = rsMov.getInt("idMovimiento");
				tipoPkm = rsJ1m.getInt("idTipoFK");

				vidaRestada = f.calcularDanio(ataque, defensa, idAtaque, tipoPkm);
				PBvida1.setValue(PBvida1.getValue()-vidaRestada);
				lblDanio.setText(rsJ1m.getString("nombrePokemon")+" pierde "+vidaRestada+" PS");
				pnlTranscurso.add(lblDanio);
				pnlTranscurso.add(lblQueHacer);
				turno=turno+1;
			} catch (SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error A4J2", JOptionPane.ERROR_MESSAGE);
			}
		}
		//MOSTRAR MOVIMIENTOS
		if(turno%2!=0) 
		{
			pnlMovimientos.remove(pnlMovimientosJ2);
			pnlMovimientos.add(pnlMovimientosJ1);

		} else {
			pnlMovimientos.remove(pnlMovimientosJ1);
			pnlMovimientos.add(pnlMovimientosJ2);

		}
		if(PBvida1.getValue()<=0) 
		{
			lblFin.setText("Jugador 1 Gana en "+turno/2+" turnos.");
			bd.desconectar(bd.conectar("juegoPokemon","root", "Studium2018;"));
			dlgFin.setVisible(true);
			this.setVisible(false);

		} else if ( PBvida2.getValue()<=0) {
			lblFin.setText("Jugador 2 Gana en "+turno/2+" turnos");
			bd.desconectar(bd.conectar("juegoPokemon","root", "Studium2018;"));
			dlgFin.setVisible(true);
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
	public void windowClosing(WindowEvent e) 
	{
		int seleccion = JOptionPane.showOptionDialog( null,"¿Desea finalizar la partida?","Finalizar partida",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] { "Finalizar", "Cancelar"},"Cancelar");
		if (seleccion == 0)
		{
			this.setVisible(false); 
		}
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
