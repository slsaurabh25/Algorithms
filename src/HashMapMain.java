import java.util.HashMap;

public class HashMapMain {

    public static void main(String[] args) {
        HashMap<Country,String> countryCapitalMap=new HashMap<>();
        Country indiaCountry= new Country("India",10000);
        countryCapitalMap.put(indiaCountry, "Delhi");
        indiaCountry.setName("Dummy");
        System.out.println("Capital of India is: "+countryCapitalMap.get(indiaCountry));
    }
}

class Country
{
    String name;
    long population;

    Country(String name,long population)
    {
        this.name=name;
        this.population=population;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (population ^ (population >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (population != other.population)
            return false;
        return true;
    }
}