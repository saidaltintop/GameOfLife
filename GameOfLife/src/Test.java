import java.util.Scanner;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Scanner scan1=new Scanner(System.in);
		int numbergrid=0;
			System.out.print("kaçlık bir ızgara girmek istersiniz => ");
			numbergrid=scan.nextInt();//ızgara boyutunu belirletiyoruz
		boolean [][] array=new boolean[numbergrid][numbergrid];//ızgaraboyuna göre bir dizi olusturduk
		String exit;//döngüden cıkmak için kullanacagız 
		do//do while döngüsüne koyduk cunku kullanıcının istediği kadar girdi yapmasına izin verecegiz
		{
			try{//try catch bir hata olustugunda catch e girmesini saglar
				System.out.print("hücrenin x kordinati => ");
				int x=scan.nextInt();
				System.out.print("hücrenin y kordinati => ");
				int y=scan.nextInt();
				if(numbergrid>=x && numbergrid>=y && x>0 && y>0)//ızgara boyundan buyuk yada 0 dan kucuk sayı girilirse atama yapmasını engelledik hata olmaması için 
					array[x-1][y-1]=true;
				else
					System.out.print("Lütfen x ve y kordinatlarını "+(numbergrid+1)+"'den küçük (en fazla ızgara boyutu kadar) 0'dan büyük değer giriniz!!");	
			}catch (Exception e) {
				System.out.println("Lütfen x ve y kordinatlarını pozitif tam sayı olarak giriniz!!");
			}
			
				
			System.out.print("Yeni canlı bir hücre oluşturmak için 'E' Devam etmek için başka bir tuşla giriş yapınız => ");
			exit=scan1.nextLine();
		}while(exit.equalsIgnoreCase("E"));
		
		/*array[1][2]=true;
		array[1][3]=true;
		array[2][1]=true;
		array[3][2]=true;
		array[3][3]=true;
		array[4][2]=true;*/
		GameOfLife gameoflife=new GameOfLife(array);//gameoflife nesnesini olusturduk
		System.out.println("=====Sizin girdiğiniz canlı hücreler====== ");
		gameoflife.displayGrid();//displayGrid ızgaranın o anki halini ekrana yazdırmak için kullanılır. Canlı hücreler için "*", ölü hücreler için "_" sembolü kullanılmalıdır.
		gameoflife.nextGeneration();//nextGeneration metodu ızgaranın bir sonraki nesildeki halini hesaplar
		System.out.println("=====Son olarak canlı hücreler====== ");
		gameoflife.displayGrid();//yeni nesili ekrana yazdırıyoruz
	}

}
