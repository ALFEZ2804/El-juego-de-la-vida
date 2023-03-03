/*Copyright [2023] [Alberto Fernández Rodríguez]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
either express or implied. See the License for the specific
language governing permissions and limitations under the
License.*/

package aplicacion;

import dominio.Tablero;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Principal
{
	public static void main(String[] args) throws IOException
	{
		try
		{
			Tablero tablero = new Tablero();
			System.out.println("SIMULACIÓN CON TABLERO LEÍDO");
			tablero.leerEstadoActual("matriz.txt");
			System.out.println(tablero);
			for(int i = 0; i <= 5; i++)
			{
				TimeUnit.SECONDS.sleep(1);
				tablero.transitarAlEstadoSiguiente();
				System.out.println(tablero);
			}

			System.out.println("SIMULACIÓN CON TABLEROGENERADO MEDIANTE MONTECARLO");
			tablero.generarEstadoActualPorMontecarlo();
			System.out.println(tablero);
			for(int i = 0; i <= 15; i++)
			{
				TimeUnit.SECONDS.sleep(1);
				tablero.transitarAlEstadoSiguiente();
				System.out.println(tablero);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
}
