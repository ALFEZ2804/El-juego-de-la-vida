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

package dominio;
import java.util.Random;
import java.io.*;

public class Tablero
{

	private static int dimension = 30;
	private int [] [] estadoActual;
	private int [] [] estadoSiguiente;
	
	public Tablero()
	{
		this.estadoActual = new int[dimension][dimension];
		this.estadoSiguiente = new int[dimension][dimension];
	}

	//Lee un archivo, lo va leyendo por líneas y posteriormente coge caracter a caracter, si el caracter es 1 se asigna un 1 en la matirz estado actual. si es un 0, se asigna un 0 en la matriz.
	public void leerEstadoActual(String archivo) throws FileNotFoundException, IOException
	{
		String contenidoLinea;
		int linea = 0;

		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);

		for(int i = 0; i<dimension; i++)
		{
			contenidoLinea = br.readLine();
			for(int j = 0; j < dimension; j++)
			{
				estadoActual[i][j] = Character.getNumericValue(contenidoLinea.charAt(j));
			}
		}
		br.close();
	}

	//Asigna un numero random entre 0 y 1, si el námero es mayor que 0,5 se asigna un 1 en la matriz estado estadoActual, si es menor se asigna un 0.
	public void generarEstadoActualPorMontecarlo()
	{
		Random random = new Random();
		for(int i = 0; i<dimension; i++)
		{
			for(int j = 0; j<dimension; j++)
			{
				double numeroAleatorio;
				numeroAleatorio = random.nextDouble();
				if(numeroAleatorio > 0.5)
				{
					estadoActual[i][j] = 1;
				}
				else
				{
					estadoActual[i][j] = 0;
				}
			}
		}

	}

	// Mira las vecinas vivas de cada una de las ceélulas, para ello llama a un método llamado contarVecinasVivas(), después de invocar el método estipula, 
	// según las normas del juego de la vida, si la célula vive o muere en el siguiente estado.
	public void transitarAlEstadoSiguiente()
	{
		for(int i = 0; i<dimension; i++)
		{
			for(int j = 0; j< dimension; j++)
			{
				int vecinasVivas = contarvecinasVivas(i,j);
				if((estadoActual[i][j] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) || (estadoActual[i][j] == 0 && vecinasVivas == 3))
				{
					estadoSiguiente[i][j] = 1;
				}
				else
				{
					estadoSiguiente[i][j] = 0;
				}
			}
		}
		almacenarEnEstadoActual();
	}

	// Almacena en el estado siguiente el estado actual.
	public void almacenarEnEstadoActual()
	{
		for(int i=0; i<dimension; i++)
		{
			for(int j=0; j<dimension; j++)
			{
				estadoActual[i][j] = estadoSiguiente[i][j];
			}
		}
	}

	// Cuenta las vecinas vivas de una célula utilizando dos bucles for el primero para ver las filas y el segundo las columnas
	private int contarvecinasVivas(int fila, int columna)
	{
		int vecinasVivas = 0;
		
		for(int i = fila -1; i<= fila +1; i++)
		{
			for(int j = columna -1; j <=columna +1; j++)
			{
				if(i >= 0 && i < dimension && j >= 0 && j < dimension && !(i == fila && j == columna))
				{
					if(estadoActual[i][j] ==1) vecinasVivas++;
				}
			}
		}
		return vecinasVivas;
	}

	//Se analiza para cada posición de la matriz si lo que contiene es un 0 o un 1, si es un 1 se añade al stringbuilder un *, si es un 0 se añade un espacio en el stringbuider.
	//Finalmente se devuelve el stringbuilder.
	@Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimension; i++) 
        {
            for (int j = 0; j < dimension; j++) 
            {
                if(estadoActual[i][j] == 1)
                {
                	sb.append("*");	
                }
                else
                {
                	sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
