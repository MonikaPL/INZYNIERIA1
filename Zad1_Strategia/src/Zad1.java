import java.util.ArrayList;

class Magazyn
{	
	Przedmiot dodajDoSpisu(Przedmiot P){
	
		return P;		 
	}
	
	void pobierzWartoscPoOpodatkowaniu(Podatek P,ArrayList<Przedmiot> lista){
		
		double wartosc = 0;
		
		for (int i = 0; i < lista.size(); i++) {
			wartosc = wartosc + lista.get(i).okreslWartosc();
			
		}
		System.out.println(P.oblicz_podatek(wartosc));
		
		
	}
	
}

abstract class Przedmiot
{
	protected int wartosc;
	protected int rok;
	abstract double okreslWartosc();
	
	Przedmiot(int rok)
	{
		this.rok = rok;
	}
	
}

abstract class Podatek
{
	abstract double oblicz_podatek(double kwota);
}

class Ksiazka extends Przedmiot
{
	protected int numer_wydania;
	
	Ksiazka(int rok,int numer_wydania)
	{
		super(rok);
		this.numer_wydania = numer_wydania;
		
		wartosc = 2050;
	}
	
	@Override
	double okreslWartosc() 
	{
		return ((wartosc - rok)/numer_wydania);
	}
	
	double get_wartosc(){
		return wartosc;
	}
	
}
class Obraz extends Przedmiot
{
	Obraz(int rok)
	{
		super(rok);
		wartosc = 2100;
	}

	@Override
	double okreslWartosc() {
		
		return wartosc * 10;
	}
	
}
class Rzezba extends Przedmiot
{	
	protected int rozmiar_rzezby;
	
	Rzezba(int rok,int rozmiar_rzezby)
	{
		super(rok);
		this.rozmiar_rzezby = rozmiar_rzezby;
		wartosc = 2020;
	}

	@Override
	double okreslWartosc()
	{
		return (((wartosc - rok) * Math.pow(rozmiar_rzezby,3)) * 2);
	}
	
}
class PodatekLiniowy extends Podatek
{
	@Override
	double oblicz_podatek(double kwota) 
	{
		return kwota * 0.81;
	}
	
}
class PodatekProgresywny extends Podatek
{
	@Override
	double oblicz_podatek(double kwota) {
		
		if(kwota <= 10000)
		{
			return kwota * 0.82;
		}
		else if(kwota > 10000)
		{
			return kwota * 0.68;
		}
		return 0;
	}
	
}


public class Zad1 {

	public static void main(String[] args) {
		
		double cala_wartosc;
		double podatek_liniowy;
		double podatek_progresywny;
		
		Przedmiot k = new Ksiazka(2010,2);
		Przedmiot o = new Obraz(2010);
		Przedmiot r = new Rzezba(2011,13);
		
		Podatek p1 = new PodatekLiniowy();
		Podatek p2 = new PodatekProgresywny();
		
		Magazyn m = new Magazyn();
		
		
		ArrayList <Przedmiot> lista_przedmiotow = new ArrayList<Przedmiot>();
		lista_przedmiotow.add(m.dodajDoSpisu(k));
		lista_przedmiotow.add(m.dodajDoSpisu(o));
		lista_przedmiotow.add(m.dodajDoSpisu(r));
		
		for (int i = 0; i < lista_przedmiotow.size(); i++) {
			System.out.println(lista_przedmiotow.get(i));
		}
		
		m.pobierzWartoscPoOpodatkowaniu(p1, lista_przedmiotow);
		m.pobierzWartoscPoOpodatkowaniu(p2, lista_przedmiotow);
		
		
		
		
		
			
		
	}

}
