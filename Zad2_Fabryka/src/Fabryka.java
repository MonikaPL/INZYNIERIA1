abstract class Panstwa
{
	
	abstract double oblicz_podatek_liniowy(double kwota);
	abstract double oblicz_podatek_progresywny(double kwota);		
	
}

class Polska extends Panstwa
{
	
	@Override
	double oblicz_podatek_liniowy(double kwota)
	{
		return kwota * 0.81;
	}

	@Override
	double oblicz_podatek_progresywny(double kwota)
	{
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

class USA extends Panstwa
{
	
	@Override
	double oblicz_podatek_liniowy(double kwota)
	{
		return kwota * 0.9;
	}

	@Override
	double oblicz_podatek_progresywny(double kwota)
	{
		return kwota * 0.9;
	}
	
}
class Francja extends Panstwa
{
	
	@Override
	double oblicz_podatek_liniowy(double kwota)
	{
		return kwota * 0.3;
	}

	@Override
	double oblicz_podatek_progresywny(double kwota)
	{
		if(kwota <= 40000)
		{
			return kwota * 0.82;
		}
		return kwota;
	}
	
}

class Niemcy extends Panstwa
{
	
	@Override
	double oblicz_podatek_liniowy(double kwota)
	{
		return kwota * 0.8;
	}

	@Override
	double oblicz_podatek_progresywny(double kwota)
	{
		if(kwota <= 50000)
		{
			return kwota * 0.6;
		}
		return kwota;
	}
	
}

class FabrykaPanstw 
{
	
public Panstwa get_panstwo(String nazwa_panstwa)
	{

	 switch (nazwa_panstwa) {
     case "POLSKA":
     	return new Polska();
     case "USA":
     	return new USA();
     case "FRANCJA":
     	return new Francja();
     case "NIEMCY":
     	return new Niemcy();
	default:
         throw new IllegalArgumentException("Wpisa³eœ zle pañstwo: " + nazwa_panstwa);
 }
		
	}
}

public class Fabryka {

	public static void main(String[] args){
		try{
		int wartosc = 20000;
		
		FabrykaPanstw f = new FabrykaPanstw();
		
		Panstwa p = f.get_panstwo("POLSKA");
		Panstwa u = f.get_panstwo("USA");
		Panstwa fr = f.get_panstwo("FRANCJA");
		Panstwa n = f.get_panstwo("NIEMCY");
		
		System.out.println(p.oblicz_podatek_progresywny(wartosc));
		System.out.println(p.oblicz_podatek_liniowy(wartosc));
		
		} catch (IllegalArgumentException exception) {
	        System.out.println(exception);
		}

	}

}
