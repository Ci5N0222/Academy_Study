package quizs;

abstract class Animal {
	private String name;
	
	public String getName() {
		return name;
	}
	
	abstract public void sound();
	
	public Animal() {
		
	}
	public Animal(String name) {
		this.name = name;
	}
}

class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println(getName() +" : BowWow");
	}
	
	public Dog() {
		
	}
	public Dog(String name) {
		super(name);
	}
	
}

class Cat extends Animal {
	@Override
	public void sound() {
		System.out.println(getName() + " : Meow");
	}
	
	public Cat() {
		
	}
	public Cat(String name) {
		super(name);
	}
}

public class Quiz01 {

	public static void main(String[] args) {
		Animal[] animal = new Animal[5];
		
		animal[0] = new Dog("Hodu");
		animal[1] = new Cat("Navi");
		animal[2] = new Dog("Browny");
		
		for(int i=0; i<3; i++) {
			animal[i].sound();
		}
	}

}
