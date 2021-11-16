package ru.job4j.lsp;

public class Animal {

    protected float food;

    protected int pawCount;

    public Animal(float food) {
        this.food = food;
    }

    public void feed(int hrs) {
        if (food < 0) { /*предусловие*/
            throw new IllegalArgumentException("Feed the animal pls!");
        }
        /*other logic*/
    }

    public void goForAWalk(int restHours) {
        if (restHours > 7) {
            System.out.println("Выпускайте кракена!");
        }
    }

    public float getFood() {
        return food;
    }

    public void setFood(float food) {
        this.food = food;
    }

    public int getPawCount() {
        return pawCount;
    }

    public void setPawCount(int pawCount) {
        if (pawCount < 4) {
            throw new IllegalArgumentException("Invalid!");
        }
        this.pawCount = pawCount;
    }
}

class Elephant extends Animal {

    public Elephant(float food) {
        super(food);
    }

    public void feed(int hrs) {
        if (food < 5) { /*усиление условия*/
            throw new IllegalArgumentException("Elephant needs more food!");
        }
       /* other logic*/
    }

    @Override
    public void goForAWalk(int restHours) {
        if (restHours > 1) {
            System.out.println("Иииии-таааааак-сойдёоооот...");
        }
    }

    @Override
    public void setPawCount(int paws) {
        /*some logic*/
    }

}
