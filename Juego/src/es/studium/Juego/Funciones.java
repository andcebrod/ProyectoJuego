package es.studium.Juego;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Funciones {
	
	BaseDatos bd = new BaseDatos();
	
	public int calcularDanio (int ataque, int defensa, int idAtaque,int tipoPkm) 
	{
		
		String consultaMovimiento = "SELECT * FROM movimiento WHERE idMovimiento ="+idAtaque+";";
		ResultSet rs = bd.ejecutarSelect(consultaMovimiento, bd.conectar("juegoPokemon","root", "Studium2018;"));
		
		int potencia;
		int danio = 0;
		double efectividad = 1;
		try {
			rs.next();
			potencia = rs.getInt("danioMovimiento");
			int tipoAtaque = rs.getInt("idTipoFK");
		
		//ACERO
			//MUY EFICAZ
		if (tipoAtaque ==1 & tipoPkm==8) {
			efectividad =2;
		} else if(tipoAtaque == 1 && tipoPkm == 13) {
			efectividad = 2;
		} 
			//POCO EFICAZ
		 else if(tipoAtaque == 1 && tipoPkm == 1) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 1 && tipoPkm == 2) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 1 && tipoPkm == 5) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 1 && tipoPkm == 7) {
				efectividad = 0.5;
			}
		//AGUA
			//MUY EFICAZ
		else if(tipoAtaque == 2 && tipoPkm == 7) {
			efectividad = 2;
		} else if(tipoAtaque == 2 && tipoPkm == 13) {
			efectividad = 2;
		} else if(tipoAtaque == 2 && tipoPkm == 15) {
			efectividad = 2;
		}
			//POCO EFICAZ
		else if(tipoAtaque == 2 && tipoPkm == 2) {
			efectividad = 0.5;
		}
		else if(tipoAtaque == 2 && tipoPkm == 4) {
			efectividad = 0.5;
		}
		else if(tipoAtaque == 2 && tipoPkm == 11) {
			efectividad = 0.5;
		}
		//BICHO
			//MUY EFICAZ
		else if(tipoAtaque == 3 && tipoPkm == 11) {
			efectividad = 2;
		} else if(tipoAtaque == 3 && tipoPkm == 12) {
			efectividad = 2;
		} else if(tipoAtaque == 3 && tipoPkm == 14) {
			efectividad = 2;
		} 
			//POCO EFICAZ
		else if(tipoAtaque == 3 && tipoPkm == 1) {
			efectividad = 0.5;
		}
		else if(tipoAtaque == 3 && tipoPkm == 6) {
			efectividad = 0.5;
		}
		else if(tipoAtaque == 3 && tipoPkm == 7) {
			efectividad = 0.5;
		}
		else if(tipoAtaque == 3 && tipoPkm == 9) {
			efectividad = 0.5;
		}
		else if(tipoAtaque == 3 && tipoPkm == 16) {
			efectividad = 0.5;
		}
		else if(tipoAtaque == 3 && tipoPkm == 17) {
			efectividad = 0.5;
		}
		//DRAGÓN
			//MUY EFICAZ
		else if(tipoAtaque == 4 && tipoPkm == 4) {
			efectividad = 2;
		}
			//POCO EFICAZ
		else if(tipoAtaque == 4 && tipoPkm == 1) {
			efectividad = 0.5;
		}
		//ELÉCTRICO
			//MUY EFICAZ
		 else if(tipoAtaque == 5 && tipoPkm == 2) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 5 && tipoPkm == 17) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 5 && tipoPkm == 4) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 5 && tipoPkm == 5) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 5 && tipoPkm == 11) {
				efectividad = 0.5;
			}
			//NO AFECTA
		 else if(tipoAtaque == 5 && tipoPkm == 15) {
				efectividad = 0;
			}
		//FANTASMA
			//MUY EFICAZ
		 else if(tipoAtaque == 6 && tipoPkm == 6) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 6 && tipoPkm == 12) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 6 && tipoPkm == 11) {
				efectividad = 0.5;
			}
			//NO AFECTA
		 else if(tipoAtaque == 6 && tipoPkm == 10) {
				efectividad = 0;
			}
		//FUEGO
			//MUY EFICAZ
		 else if(tipoAtaque == 7 && tipoPkm == 1) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 7 && tipoPkm == 3) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 7 && tipoPkm == 8) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 7 && tipoPkm == 11) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 7 && tipoPkm == 2) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 7 && tipoPkm == 4) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 7 && tipoPkm == 7) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 7 && tipoPkm == 13) {
				efectividad = 0.5;
			}
			
		//HIELO
			//MUY EFICAZ
		 else if(tipoAtaque == 8 && tipoPkm == 4) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 8 && tipoPkm == 11) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 8 && tipoPkm == 15) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 8 && tipoPkm == 17) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 8 && tipoPkm == 1) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 8 && tipoPkm == 2) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 8 && tipoPkm == 7) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 8 && tipoPkm == 8) {
				efectividad = 0.5;
			}
		//LUCHA
			//MUY EFICAZ
		 else if(tipoAtaque == 9 && tipoPkm == 1) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 9 && tipoPkm == 8) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 9 && tipoPkm == 10) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 9 && tipoPkm == 13) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 9 && tipoPkm == 14) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 9 && tipoPkm == 3) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 9 && tipoPkm == 12) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 9 && tipoPkm == 16) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 9 && tipoPkm == 17) {
				efectividad = 0.5;
			}
			//NO AFECTA
		 else if(tipoAtaque == 1 && tipoPkm == 6) {
				efectividad = 0;
			}
		//NORMAL
			//POCO EFICAZ
		 else if(tipoAtaque == 10 && tipoPkm == 1) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 10 && tipoPkm == 13) {
				efectividad = 0.5;
			}
			//NO AFECTA
		 else if(tipoAtaque == 10 && tipoPkm == 6) {
				efectividad = 0;
			}
			
		//PLANTA
			//MUY EFICAZ
		 else if(tipoAtaque == 11 && tipoPkm == 2) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 11 && tipoPkm == 13) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 11 && tipoPkm == 15) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 11 && tipoPkm == 1) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 11 && tipoPkm == 3) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 11 && tipoPkm == 4) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 11 && tipoPkm == 7) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 11 && tipoPkm == 11) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 11 && tipoPkm == 16) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 11 && tipoPkm == 17) {
				efectividad = 0.5;
			}
		//PSIQUICO
			//MUY EFICAZ
		 else if(tipoAtaque == 12 && tipoPkm == 9) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 12 && tipoPkm == 16) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 12 && tipoPkm == 1) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 1 && tipoPkm == 12) {
				efectividad = 0.5;
			}
			//NO AFECTA
		 else if(tipoAtaque == 12 && tipoPkm == 15) {
				efectividad = 0;
			}
		//ROCA
			//MUY EFICAZ
		 else if(tipoAtaque == 13 && tipoPkm == 3) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 13 && tipoPkm == 7) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 13 && tipoPkm == 8) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 13 && tipoPkm == 17) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 13 && tipoPkm == 1) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 13 && tipoPkm == 9) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 13 && tipoPkm == 14) {
				efectividad = 0.5;
			}
		//SINIESTRO
			//MUY EFICAZ
		 else if(tipoAtaque == 14 && tipoPkm == 6) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 14 && tipoPkm == 12) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 14 && tipoPkm == 9) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 14 && tipoPkm == 14) {
				efectividad = 0.5;
			}

		//TIERRA
			//MUY EFICAZ
		 else if(tipoAtaque == 15 && tipoPkm == 1) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 15 && tipoPkm == 5) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 15 && tipoPkm == 7) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 15 && tipoPkm == 13) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 15 && tipoPkm == 16) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 15 && tipoPkm == 3) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 15 && tipoPkm == 11) {
				efectividad = 0.5;
			}
			//NO AFECTA
		 else if(tipoAtaque == 15 && tipoPkm == 17) {
				efectividad = 0;
			}
		//VENENO
			//MUY EFICAZ
		 else if(tipoAtaque == 16 && tipoPkm == 11) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 16 && tipoPkm == 6) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 16 && tipoPkm == 13) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 16 && tipoPkm == 15) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 16 && tipoPkm == 16) {
				efectividad = 0.5;
			}
			//NO AFECTA
		 else if(tipoAtaque == 16 && tipoPkm == 1) {
				efectividad = 0;
			}
		//VOLADOR
			//MUY EFICAZ
		 else if(tipoAtaque == 17 && tipoPkm == 3) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 17 && tipoPkm == 9) {
				efectividad = 2;
			}
		 else if(tipoAtaque == 17 && tipoPkm == 11) {
				efectividad = 2;
			}
			//POCO EFICAZ
		 else if(tipoAtaque == 17 && tipoPkm == 1) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 17 && tipoPkm == 5) {
				efectividad = 0.5;
			}
		 else if(tipoAtaque == 17 && tipoPkm == 13) {
				efectividad = 0.5;
			}
		 else {
			 efectividad = 1;
		 }
		
		//FORMULA DAÑO:
		danio = (int) (0.1*efectividad*100*((ataque*potencia*((0.2*100)+1))/(200*defensa)+2));
		
		
		
		return danio;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		return danio;
		
	}

}
