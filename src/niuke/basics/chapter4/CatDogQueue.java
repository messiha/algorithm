/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/8 21:17
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列问题:
 * <p>
 * 思路：分别定义猫队列，狗队列
 */
public class CatDogQueue {


    /**
     * 对Pet类型再封装，定义类似"时间戳"用于记录Pet对象进队列"时间"
     */
    public static class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }
    }

    public static class DogCatQueue {
        private Queue<PetEnter> dogQueue;
        private Queue<PetEnter> catQueue;
        private long count;


        public DogCatQueue() {
            dogQueue = new LinkedList<>();
            catQueue = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet) {
            if (pet.getType().equals("dog")) {
                dogQueue.add(new PetEnter(pet, count++));
            } else if (pet.getType().equals("cat")) {
                catQueue.add(new PetEnter(pet, count++));
            } else {
                throw new RuntimeException("error,not dog or cat!");
            }
        }

        /**
         * 将队列中所有实例按照进入队列的先后顺序依次弹出
         *
         * @return
         */
        public Pet pollAll() {
            if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
                //判断猫队列中最早入队元素和狗队列中最早入队元素
                if (dogQueue.peek().count < catQueue.peek().count) {
                    return dogQueue.poll().getPet();
                } else {
                    return catQueue.poll().getPet();
                }
            } else if (!catQueue.isEmpty()) {
                return catQueue.poll().getPet();
            } else if (!dogQueue.isEmpty()) {
                return dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("error,queue is empty!");
            }
        }

        public Cat pollCat() {
            if (!isCatQueueEmpty()) {
                return (Cat) catQueue.poll().getPet();
            } else throw new RuntimeException("Cat queue is empty!");
        }

        private boolean isCatQueueEmpty() {
            return catQueue.isEmpty();
        }

        public boolean isEmpty() {
            return dogQueue.isEmpty() && catQueue.isEmpty();
        }

    }


    /**
     * ================外部包================
     */
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static class Dog extends Pet {
        public Dog(String type) {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat(String type) {
            super("cat");
        }
    }
}
