package AnalizadorLex_Sem;

public class Generador 
{
	//int var , var2 , var3 ; var = var2 + var2 ; if ( var > var3 ) { var3 = var2 ; }
	//int var , var2 , var3 ; var = var2 + var2 ; while ( var < var3 ) { var = var + var2 ; }
	//int var , var2 , var3 ; var = var2 + var2 ; while ( var < var3 ) { var = var + var2 ; } var = var + var2 ; if ( var > var3 ) { var3 = var2 ; }
	private String reservadas[]={  // se definen las palabras reservadas		
			"int","float","char","if","while","else","!=","==","<=",">=","false","true","||","&&"}; 	
	private char simbolos[]={ // se definen los simbolos- No se pueden declarar simbolos que java no acepte, como @ ! y comillas dobles
			'+','-','*','/','=','(',')',',',';','{','}','<','>'
	};	
	private String CodSalida="int main () { \n";
	private boolean ifs=false, whiles=false, id =false, l=true, id2 = false;
	String ids[]=new String[30];
	int can=0;
	public void Analizar(String ent, String lee)
	{
		ent+=" $";
		String lexema="";
		for(int i=0; ent.charAt(i)!='$' ;)
		{
			if(ent.charAt(i)!=' ')
			{
				lexema+=ent.charAt(i);
				i++;
			}
			else
			{
				this.ClasificaLex(lexema,lee);
				i++;
				lexema="";
			}			
		}
		if(id2)
		{
			for(int j=0;j<can;j++)
			{
				this.CodSalida+="printf(\"%d\","+ids[j]+"); \n";
				this.CodSalida+="printf(\"      \"); \n";
			}
			ids=new String[10];
			can=0;
			id=false;
		}
		CodSalida+="\n printf(\"Fin de programa...\"); \n" + "}";
	}
	
	private void ClasificaLex(String lexema, String lee)
	{
		if(this.EsReservada(lexema))
		{
			if(lexema.equals("if"))
			{
				ifs=true;
				if(l)
				{
					this.leer(lee);
					l=false;
				}
				this.CodSalida+=lexema+" ";
			}
			else
			{
				if(lexema.equals("while"))
				{
					whiles=true;
					if(l)
					{
						this.leer(lee);
						l=false;
					}
					this.CodSalida+="mientras: \n if(!";
				}
				else
				{
					if(lexema.equals("int")||lexema.equals("float")||lexema.equals("char"))
					{
						id=true;
						this.CodSalida+=lexema+" ";
					}
					else
					{
						this.CodSalida+=lexema+" ";
					}
				}
			}
		}
		else
			if(this.EsSimbolo(lexema))
			{
				if(lexema.equals("{"))
				{
					if(ifs)
					{
						this.CodSalida+="\n sino : \n";
					}
					else
					{	if(whiles)
						{	
							this.CodSalida+=")\n goto finmientras; \n";
					
						}
					}
				}
				else
				{
					if(lexema.equals("}"))
					{
						if(ifs)
						{
							this.CodSalida+=" finif: \n";
							ifs=false;
						}
						else
						{	if(whiles)
							{	
								this.CodSalida+="goto mientras ; \n finmientras: \n";
								whiles=false;
							}
						}
					}
					else 
					{
						if(lexema.equals(";"))
						{
							this.CodSalida+=lexema+" \n";
							if(l)
							{
								this.leer(lee);
							}
							id=false;
						}
						else
						{
							this.CodSalida+=lexema+" ";
						}
					}
				}
				
			}
			else
				if(this.EsNumero(lexema)){
					this.CodSalida+=lexema+" ";
				}
				else
					if(this.Esid(lexema))
					{
						if(id)
						{
							ids[can]=lexema;
							can++;
							id2=true;
						}
						this.CodSalida+=lexema+" ";
					}
	
	}
	
	private boolean EsReservada(String lexema)
	{
		boolean ban=false;
		for(int i=0; i<reservadas.length;i++){
			if(lexema.equals(reservadas[i]))
			{
				ban=true;
				break;
			}
			ban=false;
		}
		return ban;
	}
	
	private boolean EsSimbolo(String lexema)
	{
		boolean ban=false;
		if(lexema.length()==1){
			for(int i=0; i<simbolos.length;i++){
				if(lexema.charAt(0)==simbolos[i])
				{
					ban=true;
					break;
				}
				ban=false;
			}
		}
		return ban;
	}
	
	private boolean EsNumero(String lexema)
	{
		boolean ban=false;
		boolean ban2=false;
		try
		 {
		   Double.parseDouble(lexema);
		   ban=true;
		   
		 }
		 catch(NumberFormatException nfe)
		 {
		   ban=false;
		 }
		try
		 {
		   Integer.parseInt(lexema);
		   ban2=true;
		 }
		 catch(NumberFormatException nfe)
		 {
		   ban2=false;
		 }
		
		if(ban || ban2)
			return true;
		else
			return false;
	}
	
	private boolean Esid(String lexema)
	{
		boolean ban=false;
		//no puede empezar con numeros 
		//no puede contener caracteres especiales
		//no puede iniciar con guion medio -
		
		String especiales="!°|#@$%&/()=><{}[]-;,.'¿¡?/";
		String numeros="12345678890";
		
		for(int i=0; i<lexema.length();i++){
			if(i==0){
				if(numeros.indexOf(lexema.charAt(i))!=-1){
					ban=false;
					break;
				}
			}				
			if(especiales.indexOf(lexema.charAt(i))!=-1)
			{
				ban=false;
				break;
			}
			else
				ban=true;
		}
		return ban;
	}
	
	public String getCodigo(){
    	return this.CodSalida;
    }
	
	public void leer(String lee)
	{
		lee+=" $";
		String lexema="";
		for(int i=0; lee.charAt(i)!='$' ;)
		{
			if(lee.charAt(i)!=' ')
			{
				lexema+=lee.charAt(i);
				i++;
			}
			else
			{
				if(!lexema.equals("lee"))
				{
					if(this.Esid(lexema))
					{
						this.CodSalida+="printf(\"dame el valor de :"+lexema+"\"); \n";
						this.CodSalida+="scanf(\"%d\",&"+lexema+"); \n";
					}
				}
				i++;
				lexema="";
			}			
		}
		l=false;
    }
}
