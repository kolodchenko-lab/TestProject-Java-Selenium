package Animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.String.valueOf;

class CatTest {

    @Test
    public void checkCatSound(){
        //GIVEN
        Cat cat = new Cat("TestCat",2,"pet");
        String expectedSound = "meow meow";
        //WHEN
        String actualSound = cat.makeSound();
        //THEN
        Assertions.assertEquals(expectedSound,actualSound,
                String.format("Expected '%s', but was '%s'", expectedSound , actualSound));
    }
    @Test
    public void checkCatClass(){
        //GIVEN
        Cat cat = new Cat("TestCat",2,"pet");
        String expectedSimpleName = "Cat";
        //WHEN
        String simpleName = cat.getClass().getSimpleName();
        //THEN
        Assertions.assertEquals(expectedSimpleName, simpleName);

    }
    @Test
    public void checkCateat(){
        //GIVEN
        Cat cat = new Cat("TestCat",3,"pet");
        String expectedEat = "Cat eats";
        //WHEN
        String actualEat = cat.eat();
        //THEN
        Assertions.assertEquals(expectedEat, actualEat, String.format("Expected '%s', but was '%s'", expectedEat, actualEat));
    }
    @Test
    public void checkClass() throws NoSuchFieldException {
        //GIVEN
        Cat cat = new Cat("TestCat",3,"pet");
        List<String> expectedFiledNames = Collections.emptyList();
        //WHEN
        Field[]fields = cat.getClass().getFields();
        List<String> nameActual = new ArrayList<>();
        for( Field field : fields){
            nameActual.add(field.getName());
        }
        //THEN

        org.assertj.core.api.Assertions.assertThat(nameActual.isEmpty());


    }


}