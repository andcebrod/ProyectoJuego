package es.studium.Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class MenuPrincipal extends JFrame implements WindowListener, ActionListener {
	
	private static final long serialVersionUID = 1L;
	JButton btnIniciar = new JButton("Iniciar");
	JButton btnTop10 = new JButton("Top 10");
	JButton btnAyuda = new JButton("Ayuda");
	
	JPanel pnlImagen = new JPanel();
	JPanel pnluno = new JPanel();
	JLabel lblImg = new JLabel("");
	
	
	public MenuPrincipal() 
	{
		this.setTitle("Combate Pokemon!");
		setLocationRelativeTo(null);
		this.setSize(600,350);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbcPnlImagen = new GridBagConstraints();

		gbcPnlImagen.gridy = 0;
		this.add(pnlImagen, gbcPnlImagen);
		lblImg.setIcon(new ImageIcon("imagenes/pokemon.png"));
		
		pnlImagen.add(lblImg);
		GridBagConstraints gbcPnluno = new GridBagConstraints();

		gbcPnluno.gridy = 1;
		this.add(pnluno, gbcPnluno);
		pnluno.add(btnIniciar);
		pnluno.add(btnTop10);
		pnluno.add(btnAyuda);
		btnAyuda.addActionListener(this);
		btnTop10.addActionListener(this);
		btnIniciar.addActionListener(this);
		
		this.setVisible(true);
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new MenuPrincipal();
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if (btnIniciar.equals(ae.getSource())) 
		{
			new NuevaPartida();
			this.setVisible(false);
			
		} else if (btnTop10.equals(ae.getSource())) {
			
			new Top10();
			
		} else if (btnAyuda.equals(ae.getSource())) {
			
			new Ayuda();
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
