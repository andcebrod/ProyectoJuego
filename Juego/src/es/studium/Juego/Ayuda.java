package es.studium.Juego;

import java.io.IOException;

public class Ayuda {

	
	public Ayuda() 
	
	{
		try
		{
		Runtime.getRuntime().exec("hh.exe AyudaJuego/AyudaJuego.chm");
		}
		catch (IOException e)
		{
		e.printStackTrace();
		}

	}

}
