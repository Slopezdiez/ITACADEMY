package Nivell3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AsertjTests extends Assertions {
    int a=1;
    int b=1;
    int c=2;
//Exercici1
    @Test
    public void test1(){
        assertThat(a).isEqualTo(b);
    }
    @Test
    public void test2(){
        assertThat(c).isNotEqualTo(a);
    }
    //Exercici2
    @Test
    public void test3(){
        int d=a;
        assertThat(d).isEqualTo(a);
    }
    @Test
    public void test4(){
        int d=c;
        assertThat(d).isNotEqualTo(a);
    }
    //Exercici3
    @Test
    public void test5(){
        int[] i1= {1,2,3,4,5};
        int[] i2= {1,2,3,4,5};
        assertThat(i1).isEqualTo(i2);
    }
    //Exercici4

    @Test
    public void test6(){
        ArrayList<Object> lista= new ArrayList<Object>();
        Player player= new Player("player");
        Game game= new Game("game");
        Dog dog = new Dog("perro");
        lista.add(dog);
        lista.add(player);
        lista.add(game);

        assertThat(lista)
                .contains(dog, atIndex(0))
                .contains(player,atIndex(1))
                .contains(game,atIndex(2)
                );
    }
    @Test
    public void test7(){
        ArrayList<Object> lista= new ArrayList<Object>();
        Player player= new Player("player");
        Game game= new Game("game");
        Dog dog = new Dog("perro");
        lista.add(dog);
        lista.add(player);
        lista.add(game);

        assertThat(lista)
                .contains(dog)
                .contains(player)
                .contains(game);
    }
    @Test
    public void test8(){
        ArrayList<Object> lista= new ArrayList<Object>();
        Player player= new Player("player");
        Game game= new Game("game");
        Dog dog = new Dog("perro");
        lista.add(dog);
        lista.add(player);
        //lista.add(game);


        assertThat(lista).containsOnlyOnce(dog);
        assertThat(lista).doesNotContain(game);
    }

    //Exercici5

    @Test
    public void test9(){

        Map<String, String> map= new HashMap<String, String>();
        for (int i = 0; i <5 ; i++) {
            map.put(String.valueOf(i),String.valueOf(i));
        }
        assertThat(map).containsKey("2");
    }

    //Exercici6

    @Test
    public void test10(){
        assertThatThrownBy(() -> {
            List<String> list = Arrays.asList("String one", "String two");
            list.get(2);
        }).isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("Index 2 out of bounds for length 2");
    }

    //Exercici6

    @Test
    public void test11(){
        Optional<String> empty = Optional.empty();
        assertThat(empty).isEmpty();
    }

    public class Player {
        private final String name;

        public Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public class Game {
        private final String name;

        public Game(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public class Dog {
        private final String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
