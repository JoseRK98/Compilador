package AnalizadorLex_Sem;

public class Sintactico {
	
	private String matriz[][]={//si se agregan datos a la tabla se tienen que modificar la cabezera para la entrada
			{" ","id","num","(",")","+","-","*","/","<",">","<=",">=","!=","==","!","&&","||","true","false","flotante","doble","entero","boleano","{","}","publico",";","inicio","fin","si","mientras","for","no","$"},
			
			{"sentencias","sentencia,sentencias","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","sentencia,sentencias","sentencia,sentencias","sentencia,sentencias","sentencia,sentencias","ERROR","","sentencia,sentencias","ERROR","inicio,sentencias,fin","","sentencia,sentencias","sentencia,sentencias","sentencia,sentencias","ERROR",""},
			{"sentencia","asigna,;","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","asigna,;","asigna,;","asigna,;","asigna,;","ERROR","","publico,no_retorno,id,{,sentencias,}","ERROR","ERROR","","si,L,op,sigif","mientras,L,op","for,(,asigna,;,L,;,asigna,),op","ERROR","ERROR"},
			
			{"tipo","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","flotante","doble","entero","boleano","ERROR","ERROR","ERROR","ERROR","ERROR","","ERROR","ERROR","ERROR","ERROR","ERROR"},
			
			{"op","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","{,sentencias,}","ERROR","ERROR",";","ERROR","","ERROR","ERROR","ERROR","ERROR","ERROR"},
			
			{"sigif","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","ERROR","ERROR","ERROR","ERROR","","ERROR","ERROR","ERROR","no,op",""},
			{"asigna","id,=,L","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","tipo,id,=,L","tipo,id,=,L","tipo,id,=,L","tipo,id,=,L","ERROR","ERROR","","ERROR","ERROR","","ERROR","ERROR","ERROR","ERROR","ERROR"},
			
			{"L","R,L'","R,L'","R,L'","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","!,L","ERROR","ERROR","R,L'","R,L'","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"L'","ERROR","ERROR","ERROR","","","","","","","","","","","","ERROR","&,&,R,L'","|,|,R,L","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","","ERROR","","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR",""},
			
			{"R","E,R'","E,R'","E,R'","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","","E,R'","E,R'","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR",""},
			{"R'","ERROR","ERROR","ERROR","","","","","","<,E",">,E","<=,E",">=,E","!=,E","==,E","ERROR","","","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","","ERROR","","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR",""},
			
			{"E","T,E'","T,E'","T,E'","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","","T,E'","T,E'","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR",""},
            {"E'","ERROR","ERROR","ERROR","","+,T,E'","-,T,E'","","","","","","","","","ERROR","","","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","","ERROR","","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR",""},
            
            {"T","F,T'","F,T'","F,T'","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","","F,T'","F,T'","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR",""},
            {"T'","ERROR","ERROR","ERROR","","","","*,F,T'","/,F,T'","","","","","","","ERROR","","","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","","ERROR","","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR",""},
            
            {"F","id","num","(,L,)","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","true","false","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","ERROR","ERROR","ERROR","ERROR","ERROR"},
            {"fin","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","","ERROR","ERROR","fin","","ERROR","ERROR","ERROR","ERROR","ERROR"}
	};

	String pila[] = {"$","sentencias"};
	String pilaaxuliar[];
	String pala[];
	int punteroPila=1, punteroAnalizador;
	int columnas, renglones, palab;
	String cadenaconcidencia="";
	String pilademostrador;
	public String metodo(String ana[])
	{
		pilademostrador="$ sentencias \n";
		while(punteroAnalizador<ana.length)
		{
			columnas=0; renglones=0; 
			
			if(pila[punteroPila].compareTo(ana[punteroAnalizador])==0)
			{
				punteroAnalizador++;
				pilaaxuliar=new String[punteroPila];
				for(int i=0;i<punteroPila;i++)
				{
					pilaaxuliar[i]=pila[i];
				}
			}
			else
			{
				for(int i=0;matriz[0][i].compareTo(ana[punteroAnalizador])!=0;i++)
				{
					columnas++;
				}
				for(int i=0;matriz[i][0].compareTo(pila[punteroPila])!=0;i++)
				{
					renglones++;
				}
				String cad="";
				
				cadenaconcidencia=matriz[renglones][columnas];
				
				if(cadenaconcidencia.compareTo("ERROR")==0)
				{
					pilademostrador+="\n"+cadenaconcidencia+""; 
					return pilademostrador;
				}
				if(cadenaconcidencia.compareTo("")==0)
				{
					pilaaxuliar=new String[punteroPila];
					for(int i=0;i<punteroPila;i++)
					{
						pilaaxuliar[i]=pila[i];
					}
					punteroPila--;
				}
				else
				{
					palab=1;
					
					int posicion;
			        posicion = cadenaconcidencia.indexOf(",");
			        while (posicion != -1)
			        {
			            palab++;
			            posicion = cadenaconcidencia.indexOf(",", posicion + 1);
			        }
			        
			        pala= new String [palab];
			        posicion=1;
			        
					for(int i=0;cadenaconcidencia.length()>i;i++)
					{
						if(cadenaconcidencia.charAt(i)!=',')
						{
							cad+=cadenaconcidencia.charAt(i);
						}
						else
						{
							pala[palab-posicion]=cad;
							posicion++;
							punteroPila++;
							cad="";
						}
					}
					
					pala[palab-posicion]=cad;
					
					pilaaxuliar=new String[pila.length +palab-1];
					for(int i=0;i<pilaaxuliar.length;i++)
					{
						if(i<pila.length-1)
						{
							pilaaxuliar[i]=pila[i];
						}
						else
						{
							pilaaxuliar[i]=pala[i-pila.length+1];
						}
					}
				
				}
			}
			
			//aqui es como va a mostrar las concluciones del analizador sintactico
			pila=pilaaxuliar;
			punteroPila=pila.length-1;
			pilademostrador+="\n";
			for(int i=0;i<pila.length;i++)
			{
				pilademostrador+=pila[i]+" ";
			}
			pilademostrador+="\n";
		}
		return pilademostrador;
	}
}