package AnalizadorLex_Sem;

public class Semantico {
	
	private String matriz[][]={//si se agregan datos a la tabla se tienen que modificar la cabezera para la entrada
			// int var1 , var2 ; var1 = var2 ; while ( false ) { int var1 , var2 ; var1 = var2 ; } if ( id < id ) { int var1 , var2 ; var1 = var2 ; } else { int var1 , var2 ; var1 = var2 ; }
			{" ","id","int","float","char",",",";","+","-","*","/","=","(",")","{","}","if","while","else","<",">","!=","==","<=",">=","false","true","||","&&","S","I","W","P","Tipo","V","A","E","T","F","C","O","N","$"},
			
			{"I0","I12","I9","I10","I11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I5","I6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I1","I2","I3","I4","I7","ERROR","I8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I1","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P0"},
			{"I2","I12","I9","I10","I11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P4","I5","I6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I13","I2","I3","I4","I7","ERROR","I8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P4"},
			{"I3","I12","I9","I10","I11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P4","I5","I6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I14","I2","I3","I4","I7","ERROR","I8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P4"},
			{"I4","I12","I9","I10","I11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P4","I5","I6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I15","I2","I3","I4","I7","ERROR","I8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P4"},
			
			{"I5","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I16","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P0"},
			{"I6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I17","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P0"},
			{"I7","I18","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P0"},		
			
			{"I8","P8","P8","P8","P8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P8","P8","P8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P8"},
			{"I9","P9","P9","P9","P9","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P9","P9","P9","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P9"},
			{"I10","P10","P10","P10","P10","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P10","P10","P10","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P10"},
			{"I11","P11","P11","P11","P11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P11","P11","P11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P11"},
			{"I12","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I19","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P9"},
			
			{"I13","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P1","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P1"},
			{"I14","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P2","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P2"},
			{"I15","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P3","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P3"},
			{"I16","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I22","I23","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I21","I29","I30","I20","ERROR","ERROR","ERROR"},
			{"I17","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I22","I23","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I21","I29","I30","I24","ERROR","ERROR","ERROR"},
			{"I18","ERROR","ERROR","ERROR","ERROR","I26","I27","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I25","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I19","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I28","I29","I30","ERROR","ERROR","ERROR","ERROR"},
			{"I20","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P33","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I34","I35","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","C","I33","ERROR","P33"},
			
			{"I21","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I37","I38","I39","I40","I41","I42","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P0"},	
			
			{"I22","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P29","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P29","29","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P33"},
			{"I23","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P30","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P30","30","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P33"},
			
			{"I24","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P33","ERROR","P33","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I34","I35","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I43","ERROR","P33"},
			{"I25","P7","P7","P7","P7","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P7","P7","P7","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P7"},
			{"I26","I44","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P0"},		
			{"I27","I12","I9","I10","I11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I45","I7","ERROR","I8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I28","ERROR","ERROR","ERROR","ERROR","ERROR","I36","I46","I47","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I29","ERROR","ERROR","ERROR","ERROR","ERROR","P17","P17","P17","I48","I49","ERROR","ERROR","P17","ERROR","ERROR","ERROR","ERROR","ERROR","P17","P17","P17","P17","P17","P17","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I30","ERROR","ERROR","ERROR","ERROR","ERROR","P20","P20","P20","P20","P20","ERROR","ERROR","P20","ERROR","ERROR","ERROR","ERROR","ERROR","P20","P20","P20","P20","P20","P20","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I31","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I50","I29","I30","ERROR","ERROR","ERROR","ERROR"},
			{"I32","ERROR","ERROR","ERROR","ERROR","ERROR","P22","P22","P22","P22","P22","ERROR","ERROR","P22","ERROR","ERROR","ERROR","ERROR","ERROR","P22","P22","P22","P22","P22","P22","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I33","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I51","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I34","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I22","I23","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I21","ERROR","ERROR","I53","ERROR","ERROR","ERROR"},
			{"I35","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I22","I23","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I21","ERROR","ERROR","I54","ERROR","ERROR","ERROR"},
			{"I36","P14","P14","P14","P14","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P14","P14","P14","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P14"},

			{"I37","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I54","I29","I30","ERROR","ERROR","ERROR","ERROR"},
			{"I38","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I55","I29","I30","ERROR","ERROR","ERROR","ERROR"},
			{"I39","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I56","I29","I30","ERROR","ERROR","ERROR","ERROR"},
			{"I40","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I57","I29","I30","ERROR","ERROR","ERROR","ERROR"},
			{"I41","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I58","I29","I30","ERROR","ERROR","ERROR","ERROR"},
			{"I42","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I59","I29","I30","ERROR","ERROR","ERROR","ERROR"},

			{"I43","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I60","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I44","ERROR","ERROR","ERROR","ERROR","I26","I27","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I61","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I45","P13","P13","P13","P13","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P13","P13","P13","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P13"},

			{"I46","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I62","I30","ERROR","ERROR","ERROR","ERROR"},
			{"I47","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I63","I30","ERROR","ERROR","ERROR","ERROR"},
			{"I48","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I64","ERROR","ERROR","ERROR","ERROR"},
			{"I49","I32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I65","ERROR","ERROR","ERROR","ERROR"},

			{"I50","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I46","I47","ERROR","ERROR","ERROR","ERROR","I66","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I51","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I67","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I52","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I34","I35","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I68","ERROR","ERROR"},
			{"I53","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I34","I35","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I69","ERROR","ERROR"},

			{"I54","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I46","I47","ERROR","ERROR","ERROR","ERROR","P23","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P23","P23","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I55","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I46","I47","ERROR","ERROR","ERROR","ERROR","P24","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P24","P24","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I56","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I46","I47","ERROR","ERROR","ERROR","ERROR","P25","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P25","P25","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I57","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I46","I47","ERROR","ERROR","ERROR","ERROR","P26","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P26","P26","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I58","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I46","I47","ERROR","ERROR","ERROR","ERROR","P27","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P27","P27","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I59","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I46","I47","ERROR","ERROR","ERROR","ERROR","P28","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P28","P28","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},

			{"I60","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I70","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I61","P12","P12","P12","P12","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P12","P12","P12","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P12"},
			
			{"I62","ERROR","ERROR","ERROR","ERROR","ERROR","P15","P15","P15","I48","I49","ERROR","ERROR","P15","ERROR","ERROR","ERROR","ERROR","ERROR","P15","P15","P15","P15","P15","P15","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I63","ERROR","ERROR","ERROR","ERROR","ERROR","P16","P16","P16","I48","I49","ERROR","ERROR","P16","ERROR","ERROR","ERROR","ERROR","ERROR","P16","P16","P16","P16","P16","P16","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I64","ERROR","ERROR","ERROR","ERROR","ERROR","P18","P18","P18","P18","P18","ERROR","ERROR","P18","ERROR","ERROR","ERROR","ERROR","ERROR","P18","P18","P18","P18","P18","P18","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I65","ERROR","ERROR","ERROR","ERROR","ERROR","P19","P19","P19","P19","P19","ERROR","ERROR","P19","ERROR","ERROR","ERROR","ERROR","ERROR","P19","P19","P19","P19","P19","P19","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I66","ERROR","ERROR","ERROR","ERROR","ERROR","P21","P21","P21","P21","P21","ERROR","ERROR","P21","ERROR","ERROR","ERROR","ERROR","ERROR","P21","P21","P21","P21","P21","P21","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},

			{"I67","I12","I9","I10","I11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I5","I6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I71","I2","I3","I4","I7","ERROR","I8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I68","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P31","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P31"},
			{"I69","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P32","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P32"},
			{"I70","I12","I9","I10","I11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I5","I6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I72","I2","I3","I4","I7","ERROR","I8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I71","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I73","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I72","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I74","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},

			{"I73","P35","P35","P35","P35","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P35","P35","I76","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I75","P35"},
			{"I74","P6","P6","P6","P6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P6","P6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P6"},
			{"I75","P5","P5","P5","P5","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P5","P5","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P5"},
			
			{"I76","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I78","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I77","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I78","I12","I9","I10","I11","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I5","I6","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I79","I2","I3","I4","I7","ERROR","I8","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I79","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","I80","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR"},
			{"I80","P34","P34","P34","P34","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P34","P34","P34","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","ERROR","P34"},

	};
	//int var1 , var2 ; var1 = var2 ;
	public String[] DevuelvecabeceraRen(){
		String vec[]={" ","id","int","float","char",",",";","+","-","*","/","=","(",")","{","}"
				,"if","while","else","<",">","!=","==","<=",">=","false","true","||","&&","S","I"
				,"W","P","Tipo","V","A","E","T","F","C","O","N","$"};
		return vec;
		
	}
	public int DevnumCol(){
		int vec=this.matriz.length;
		return vec;
	}
	public String[][] DevueltaTabla(){
		return this.matriz;
	}
	public String[] devuelveFila(int fila)
	{
		String vec[]=new String[matriz[0].length];
		for(int i=0;i<vec.length;i++)
		{
			vec[i]=this.matriz[fila][i];
		}
		
		return vec;
	}

	String pila[] = {"$","I0"};
	String aux[];
	String pala[]= new String [9];
	int act=1, act2;
	int pun, pun2, palab;
	String cad2="";
	String pilaS;
	int pan2;
	String p[]={"S","I,S","W,S","P,S","3","if,(,C,O,),{,S,},N","while,(,C,O,),{,S,}","Tipo,id,V"
			,"A","int","float","char",",,id,V",";,P","id,=,E,;","E,+,T","E,-,T","T","T,*,F",
			"T,/,F","F","(,E,)","id","E,<,E","E,>,E","E,!=,E","E,==,E","E,<=,E","E,>=,E","false"
			,"true","||,C,O","&&,C,O","3","else,{,S,}","3"};
	
	String ter[]={"id","int","float","char",",",";","+","-","*","/","=","(",")","{","}"
			,"if","while","else","<",">","!=","==","<=",">=","false","true","||","&&","S","I"
			,"W","P","Tipo","V","A","E","T","F","C","O","N","$"};
	boolean ban3=true;
	public String metodo(String ana[])
	{
		pilaS="$ I0 \n";
		aux=new String[ana.length+1];
		for(int i=0;i<ana.length;i++)
		{
			aux[i]=ana[i];
		}
		aux[ana.length]="$";
		ana=aux;
		while(ban3)
		{
			pun=0; pun2=0; palab=0;
			pala= new String [18];
			if(pila[act].compareTo(ana[act2])==0)
			{
				act2++;
				aux=new String[act];
				for(int i=0;i<act;i++)
				{
					aux[i]=pila[i];
				}
			}
			else
			{
				System.out.println(ana[act2]);
				for(int i=0;matriz[0][i].compareTo(ana[act2])!=0;i++)
				{
					pun++;
				}
				System.out.println(pila[act]);
				for(int i=0;matriz[i][0].compareTo(pila[act])!=0;i++)
				{
					pun2++;
				}
				String cad="";
				cad2=matriz[pun2][pun];
				System.out.println(cad2);
				if(cad2.compareTo("ERROR")==0)
				{
					pilaS+="\n"+cad2+""; 
					return pilaS;
				}
				if((cad2.charAt(0)+"").compareTo("P")!=0)
				{
					aux=new String[pila.length+2];
					for(int i=0;i<aux.length;i++)
					{
						if(i<pila.length)
						{
							aux[i]=pila[i];
						}
						else
						{
							aux[i]=matriz[0][pun];
							aux[i+1]=matriz[pun2][pun];
							i++;
						}
					}
					act2++;
				}
				else
				{
					int ps=0;
					if(matriz[pun2][pun].length()==2)
					{
						ps=Integer.parseInt(matriz[pun2][pun].charAt(1)+"");
					}
					else
					{
						ps=Integer.parseInt(matriz[pun2][pun].charAt(2)+"");
						ps+=Integer.parseInt(matriz[pun2][pun].charAt(1)+"")*10;
					}
					if(ps!=12)
					{
						cad2=p[ps];
						for(int i=0;cad2.length()>i;i++)
						{
							if(cad2.charAt(i)!=',')
							{
								cad+=cad2.charAt(i);
							}
							else
							{
								pala[palab]=cad;
								palab++;
								act++;
								System.out.print(cad);
								cad="";
							}
						}
						pala[palab]=cad;
						System.out.println(cad);
						palab++;
					}
					else
					{
						pala[0]=",";
						pala[1]="id";
						pala[2]="V";
						palab+=3;
					}
					
					int pan=0;
					boolean ban=true, ban2=false;
					for(int i=0;palab>i;i++)
					{
						if(pila[pila.length-(2*(i+1))].compareTo(pala[palab-i-1])==0)
						{
							System.out.print(pala[palab-i-1]+" ");
							pan=2*(i+1);
							System.out.print(pan+" ");
						}
					}
					System.out.println();
					System.out.println();
					ban=false;
					aux=new String [pila.length-pan+2];
					pan=0;
					for(int i=0;i<aux.length-2;i++)
					{
						aux[i]=pila[i];
						pan++;
					}
					if(ps==0)
					{
						aux[pan]="S'";
					}
					else
					{
						if(ps>0&&ps<5)
						{
							aux[pan]="S";
						}
						else
						{
							if(ps==5)
							{
								aux[pan]="I";
							}
							else
							{
								if(ps==6)
								{
									aux[pan]="W";
								}
								else
								{
									if(ps>6&&ps<9)
									{
										aux[pan]="P";
									}
									else
									{
										if(ps>8&&ps<12)
										{
											aux[pan]="Tipo";
										}
										else
										{
											if(ps>11&&ps<14)
											{
												aux[pan]="V";
											}
											else
											{
												if(ps==14)
												{
													aux[pan]="A";
												}
												else
												{
													if(ps>14&&ps<18)
													{
														aux[pan]="E";
													}
													else
													{
														if(ps>17&&ps<21)
														{
															aux[pan]="T";
														}
														else
														{
															if(ps>20&&ps<23)
															{
																aux[pan]="F";
															}
															else
															{
																if(ps>22&&ps<31)
																{
																	aux[pan]="C";
																}
																else
																{
																	if(ps>30&&ps<34)
																	{
																		aux[pan]="O";
																	}
																	else
																	{
																		if(ps>33&&ps<36)
																		{
																			aux[pan]="N";
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					pun=0; pun2=0;
					if(aux[pan].compareTo("S'")!=0)
					{
						for(int i=0;matriz[0][i].compareTo(aux[pan])!=0;i++)
						{
							pun++;
						}
						for(int i=0;matriz[i][0].compareTo(aux[pan-1])!=0;i++)
						{
							pun2++;
						}
						pan++;
						aux[pan]=matriz[pun2][pun];
					
						for(int i=0;i<aux.length;i++)
						{
							System.out.print(aux[i]+" ");
						}
						System.out.println();
					}
					else
					{
						ban3=false;
					}
				}
			}
			if(ban3)
			{
				pila=aux;
				act=pila.length-1;
				pilaS+="\n";
				for(int i=0;i<pila.length;i++)
				{
					pilaS+=pila[i]+" ";
					//System.out.println(pila[i]);
				}
			}
			else
			{
				pilaS+="\n";
				pilaS+="$"+" ";
				pilaS+="I0"+" ";
				pilaS+="S'";
				pilaS+="\n";
				pilaS+="\n";
				pilaS+="ACEPTADA";
			}
			pilaS+="\n";
		}
		return pilaS;
	}
}