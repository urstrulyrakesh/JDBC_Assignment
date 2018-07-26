package com.capgemini.labs.Jdbclesson1;

public class RemoveDuplicate {

	public static void main(String[] args) {

		System.out.println("List 1\n");
		ItemsList list = new ItemsList();
		servicedao service = new servicedao();
		list.setItems("Ajay");
		service.Save(list);
		list.setItems("Jay");
		service.Save(list);
		list.setItems("Sangu");
		service.Save(list);
		list.setItems("Mani");
		service.Save(list);
		
		System.out.println("\nList 2\n");
		list.setItems("Sanjay");
		service.Save1(list);
		list.setItems("Vijay");
		service.Save1(list);
		list.setItems("Rakesh");
		service.Save1(list);
		list.setItems("Jay");
		service.Save1(list);
		
	}

}