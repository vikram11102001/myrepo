package assessmentprograms;

import java.util.ArrayList;

class Region{
	
	private String name;
	private double discount;
	
	public Region(String name, double discount) {
        this.name = name;
        this.discount = discount;
    }

	
	public String getName() {
		return name;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	
	
}


public class Product {
	private String name;
	private String desc;
	private double amount;
	private String date;
	private double discount;
	private Region region;
	
	public Product(String name, String desc, double amount, String date, double discount, Region region) {
		this.name = name;
		this.desc = desc;
		this.amount = amount;
		this.date = date;
		this.discount = discount;
		this.region = region;
		
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public double getAmount() {
		return amount;	
	}

	public String getDate() {
		return date;
	}
	
	
	public double getDiscount() {
		return discount;
	}

	public Region getRegion() {
		return region;
	}

	

	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<>();
		
		Region india = new Region("India", 0.25); 
        Region sriLanka = new Region("Sri Lanka", 0.15); 
        Region china = new Region("China", 0.2);
        
        
        Product product1 = new Product("Watch", "desc1", 1200, "2023-09-16", 0.25, india);
        Product product2 = new Product("Mobile Phone", "desc2", 18000, "2023-09-09", 0.1, sriLanka);
        Product product3 = new Product("Head Phone", "desc3", 1800, "2023-09-18", 0.2, china);
        Product product4 = new Product("Pen Drive", "desc4", 400, "2023-09-10", 0.15, india);
        Product product5 = new Product("Power Bank", "desc5", 1900, "2022-09-26", 0.1, china);
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		
		for (int i = 0; i < productList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < productList.size(); j++) {
                
                if (productList.get(j).getDate().compareTo(productList.get(minIndex).getDate()) < 0) {
                    minIndex = j;
                }
            }
           
            Product temp = productList.get(i);
            productList.set(i, productList.get(minIndex));
            productList.set(minIndex, temp);
        }
		
		for (Product product : productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDesc());
            System.out.println("Amount: " + product.getAmount());
            System.out.println("Date: " + product.getDate());
            System.out.println();
        }
		
		for (Product product : productList) {
            double combinedDiscount = product.getDiscount() + product.getRegion().getDiscount();

            if (combinedDiscount >= 0.5) {
                System.out.println("Name: " + product.getName());
                System.out.println("Description: " + product.getDesc());
                System.out.println("Amount: " + product.getAmount());
                System.out.println("Date: " + product.getDate());
                System.out.println("Product Discount: " + (product.getDiscount() * 100) + "%");
                System.out.println("Region Discount: " + (product.getRegion().getDiscount() * 100) + "%");
                System.out.println("Combined Discount: " + (combinedDiscount * 100) + "%");
                System.out.println();
            }
           
        }
		System.out.println("No products");
		
	}
	
	
}


