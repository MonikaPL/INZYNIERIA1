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
	if(nazwa_panstwa == null)
	{
		return null;
	}
	if(nazwa_panstwa.equalsIgnoreCase("POLSKA"))
	{
		return new Polska();
	}
	if(nazwa_panstwa.equalsIgnoreCase("USA"))
	{
		return new USA();
	}
	if(nazwa_panstwa.equalsIgnoreCase("FRANCJA"))
	{
		return new Francja();
	}
	if(nazwa_panstwa.equalsIgnoreCase("NIEMCY"))
	{
		return new Niemcy();
	}
	
	return null;
	}

}
class Adaptee_New_Z³oty_na_euro
{		
			double z_zl_na_euro(double kwota){
				return (kwota/4.2);
			}	
					
}
class Adaptee_New_Dolar_na_euro
{
			double z_dolarów_na_euro(double kwota){
				return ((kwota * 3)/3.8);
			}		
		
}


class AdapterPolska extends Panstwa{
	
Adaptee_New_Z³oty_na_euro a;

Panstwa p;

public AdapterPolska(Panstwa p) 
{
	this.p = p;
	a = new Adaptee_New_Z³oty_na_euro(); 
}

	@Override
	double oblicz_podatek_liniowy(double kwota) {
		
		double obliczone = p.oblicz_podatek_liniowy(kwota);
		
		System.out.println(obliczone);
		
		return a.z_zl_na_euro(obliczone);		
	}

	@Override
	double oblicz_podatek_progresywny(double kwota)
	{
		
		double obliczone = p.oblicz_podatek_progresywny(kwota);
		
		return a.z_zl_na_euro(obliczone);
	}

}
class AdapterUSA extends Panstwa{
	
Adaptee_New_Dolar_na_euro a;

Panstwa p;

public AdapterUSA(Panstwa p) 
{
	this.p = p;
	a = new Adaptee_New_Dolar_na_euro(); 
}

@Override
double oblicz_podatek_liniowy(double kwota) {
	
	double obliczone = p.oblicz_podatek_liniowy(kwota);
	
	System.out.println(obliczone);
	
	return a.z_dolarów_na_euro(obliczone);	
}

@Override
double oblicz_podatek_progresywny(double kwota) {
	
	double obliczone = p.oblicz_podatek_liniowy(kwota);
	
	System.out.println(obliczone);
	
	return a.z_dolarów_na_euro(obliczone);	
	
}
	
}	

public class Zad3_Adapter {

	public static void main(String[] args) {
		
		int wartosc = 20000;
		
		FabrykaPanstw f = new FabrykaPanstw();
		
		Panstwa polska = f.get_panstwo("POLSKA");
		Panstwa usa = f.get_panstwo("USA");
		Panstwa francja = f.get_panstwo("FRANCJA");
		Panstwa niemcy = f.get_panstwo("NIEMCY");
		
		
		
		AdapterPolska a = new AdapterPolska(polska);
		AdapterUSA a2 = new AdapterUSA(usa);
		
		System.out.println(a.oblicz_podatek_progresywny(wartosc));
		//System.out.println(a2.oblicz_podatek_liniowy(wartosc));
		
		

		

	}

}
