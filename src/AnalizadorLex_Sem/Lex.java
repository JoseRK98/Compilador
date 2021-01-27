package AnalizadorLex_Sem;
import java.util.Stack;
public class Lex {
	
	private String reservadas[]={  // se definen las palabras reservadas		
			"int","float","char","if","while","else","!=","==","<=",">=","false","true","||","&&"}; 	
	private char simbolos[]={ // se definen los simbolos- No se pueden declarar simbolos que java no acepte, como @ ! y comillas dobles
			'+','-','*','/','=','(',')',',',';','{','}','<','>'
	};	
	int e=30,i=90; 
	private String CodSalida="";/*codigo de salida*/ 
	private Stack<String> pilare=new Stack<String>();/*pila de reservadas*/
	private Stack<Character> pilasim=new Stack<Character>();/*pila de simbolos*/
	private Stack<String> pilaid=new Stack<String>();/*pila de id*/
	private Stack<String> pilaerror=new Stack<String>();/*pila de error*/
	private Stack<String> pilalexica=new Stack<String>();/*pila lexica*/
	
	public void Analizar(String ent){
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
				this.ClasificaLex(lexema);
				i++;
				lexema="";
			}			
		}
	}
	
	private void ClasificaLex(String lexema){
		if(this.EsReservada(lexema)){
			pilare.add(lexema);
			pilalexica.add(lexema);
			this.CodSalida+=" "+lexema;
		}
		else
			if(this.EsSimbolo(lexema))
			{
				pilasim.add(lexema.charAt(0));
				pilalexica.add(lexema);
				this.CodSalida+=" "+lexema;
			}
			else
				if(this.EsNumero(lexema)){
					this.CodSalida+=" num";
					pilalexica.add("num");
				}
				else
					if(this.Esid(lexema))
					{
						pilaid.add(lexema);
						this.CodSalida+=" id";
						pilalexica.add("id");
					}
					else{
						pilaerror.add((pilaerror.size()+1)+".-Error lexico en "+ lexema);
						this.CodSalida+=" Error";
					}
	
	}
	
	
	private boolean EsReservada(String lexema){
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
	
	private boolean EsSimbolo(String lexema){
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
	
	private boolean EsNumero(String lexema){
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
	
	private boolean Esid(String lexema){
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
	
		
	public String[] getPilare(){
		String vec[]=new String[this.pilare.size()];
		int i,j;
		for(i=0,j=this.pilare.size()-1; i<=j ;i++){ //pila reservadas
			vec[i]=this.pilare.elementAt(i);
		}
		return vec;		
	}
	
	public String[] getPilaid(){
		String vec[]=new String[this.pilaid.size()];
		int i,j;
		for(i=0,j=this.pilaid.size()-1; i<=j ;i++){ //pila reservadas
			vec[i]=this.pilaid.elementAt(i);			
		}
		return vec;		
	}        
    
    
    public char[] getPilaSim(){
		char vec[]=new char[this.pilasim.size()];
		int i,j;
		for(i=0,j=this.pilasim.size()-1; i<=j ;i++){ //pila reservadas
			vec[i]=this.pilasim.elementAt(i);			
		}
		return vec;		
	}
    
    public String[] getPilaerror(){
		String vec[]=new String[this.pilaerror.size()];
		int i,j;
		for(i=0,j=this.pilaerror.size()-1; i<=j ;i++){ //pila reservadas
			vec[i]=this.pilaerror.elementAt(i);
		}
		return vec;		
	}
    
    public String[] getComponentesLexicos(){
		String vec[]=new String[this.pilalexica.size()];
		int i,j;
		for(i=0,j=this.pilalexica.size()-1; i<=j ;i++){ //pila reservadas
			vec[i]=this.pilalexica.elementAt(i);
		}
		return vec;		
	}
    
    
    
    public String getCodigo(){
    	return this.CodSalida;
    }
}