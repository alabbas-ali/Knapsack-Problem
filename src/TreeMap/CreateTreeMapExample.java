package TreeMap;

import java.util.SortedMap;
import java.util.TreeMap;

public class CreateTreeMapExample {
    public static void main(String[] args) {
        // Creating a TreeMap
        SortedMap<ID, Customer> fileExtensions  = new TreeMap<>();

        // Adding new key-value pairs to a TreeMap
        fileExtensions.put(new ID("rr",1), new Customer("me"));
        fileExtensions.put(new ID("usx",2), new Customer("Mok"));
        fileExtensions.put(new ID("usx",2), new Customer("Mok2"));
        
        Customer ex = fileExtensions.get(new ID("rr",1));
        // Printing the TreeMap (Output will be sorted based on keys)
        System.out.println(fileExtensions);
    }

}

class ID {
	String uuid;
	int idSufix;
	public ID(String uuid, int ids) {
		this.uuid = uuid;
		this.idSufix = ids;
	}
	
}

class Customer {
	String name;
	public Customer(String name) {
		this.name = name;
	}
}
