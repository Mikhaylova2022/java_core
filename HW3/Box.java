package lesson3.HW3;

import java.util.ArrayList;

public class Box <T extends Fruit> {
        private ArrayList<T> fruits;

        public Box(ArrayList<T> fruits) {
            this.fruits = fruits;
        }

        /* Узнать вес текущего ящика */
        public double getWeight() {
            double fullBoxWeight = 0;
            if (fruits != null && !fruits.isEmpty()) {
                for (T fruit : fruits) {
                    fullBoxWeight += fruit.getWeight();
                }
            }
            return fullBoxWeight;
        }

        /*Сравнение*/
        public <Y extends Fruit> boolean compare(Box<Y> another) {
            return this.getWeight() == another.getWeight();
        }

       /*Разделние фруктов*/
        public void pourAllFruits(Box<T> another) {
            for (T fruit : this.fruits) {
                another.addFruit(fruit);
            }
            this.fruits.clear();
            this.fruits.trimToSize();
        }

        /*Добавим фрукт в коробку*/

        public void addFruit(T newFruit) {
            fruits.add(newFruit);
        }
    }
