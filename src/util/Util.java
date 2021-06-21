package util;

import java.util.ArrayList;
import java.util.Random;

import persistencia.ClinicaDTO;



public class Util
{
       
    public static ClinicaDTO clinicaDTOFromCLinica() 
    {
	ClinicaDTO respuesta=new ClinicaDTO();
	return respuesta;
    }
    
    public static void clinicaFromClinicaDTO(ClinicaDTO clinicaDTO) 
    {
	
    }
    
    
  
	public static final Random r = new Random();

	public static void espera(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void espera() {
		Util.espera(r.nextInt(300));
	}

    
    
    
}
