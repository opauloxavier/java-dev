import java.lang.Math;

public class HashMaker {
	int[] m;
	int[] n;
	int mod;
	
	public HashMaker(int tamanho){
		this.m = new int[tamanho];
		mod = m.length;
	}
	
	public boolean insereHash(int posicao, int numero){
		
		if(posicao<mod){
			if(m[posicao]==0){
				m[posicao] = numero; 
				System.out.println("Inserida na posicao: "+posicao);
				
				return true;
			}
			
			else{
				System.out.println("Colisao Detectada na posicao "+posicao);
				return false;
			}
		}
		
		else{
			System.err.println("A Posicao "+posicao+" nao existente nessa Hash. Essa Hash possui apenas "+mod+" posições.");
			return false;
		}
	}
	
	
	public void dispersaoDivisao(int numero){
		
		int posicao = numero%mod;
		
		insereHash(posicao,numero);
	}
		
	public void dispersaoDobra(int numero){
		
		String n = Integer.toString(numero);
		String numeroFinal= new String();
		int numeroDobra=0;
		
		if(n.length()%2!=0){
			numeroFinal='0'+n;
			//numeroDobra = Integer.parseInt(numeroFinal);
		}
		
		else
			numeroFinal=n;
		
		String Dobra = new String();
		
		for (int i = 0; i < numeroFinal.length()/2; i++) {
			String a = numeroFinal.substring(i,i+1);
			String b = numeroFinal.substring(numeroFinal.length()-i-1,numeroFinal.length()-i);
			
			int total = Integer.parseInt(a)+Integer.parseInt(b);
			
			Dobra+=total;
			
		}
		
		int posicao = Integer.parseInt(Dobra);
		
		insereHash(posicao,numero);
		
	}
	
	public void dispersaoMultiplicacao(int numero){
		
		int numeroBits = (Integer.toBinaryString(mod)).length();

		String chave = Integer.toBinaryString(numero*numero);
	
		while(chave.length()>numeroBits){
			chave = chave.substring(1,chave.length()-2);
		}
		
		int posicao = 0;
		
		for(int i=chave.length()-1;i>-1;i--){
			
			if(Integer.parseInt(chave.substring(i,i+1))==0)
				posicao+=0;
			
			else if(Integer.parseInt(chave.substring(i,i+1))==1)
				posicao += (int) Math.pow(2,(i));
		}				
		
		insereHash(posicao,numero);
		
	}
	
	
	public static void main(String[] args) {
		HashMaker a = new HashMaker(100);
		
		a.dispersaoDobra(1244);
		a.dispersaoDobra(11244);
		//a.dispersao(4);
	}	
}