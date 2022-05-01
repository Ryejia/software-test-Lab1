import org.junit.jupiter.api.*;
import text.Dictionary;
import text.Person;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextTest {
    // Текст:
    // Поскольку Форд так и не научился произносить свое настоящее имя, его отец, в конце концов, умер от стыда,
    // который в некоторых частях Галактики все еще является смертельной болезнью. В школе Форду дали прозвище Ыкс,
    // что на языке Бетельгейзе-5 означает: "мальчик, который не может внятно объяснить, что такое Хрунг, и почему
    // он решил сотрястись именно на Бетельгейзе-7". Популярность: 21, Last-modified: Sun, 17 Apr 2011 08:48:58 GMT

    // Предметная область:
    // В рамках предметной области создано два класса Человек (Person) и Словарь (Dictionary). Человек имеет параметры:
    // имя, вес и рост - они нужны для создания тестов, чтобы сравнивать не просто имя, но и др. параметры. Словарь
    // используется для описания слов.

    Person andrey;
    Person ford;
    Person vlad;
    Person serge;

    Dictionary dictionaryOne;
    Dictionary dictionaryTwo;

    @BeforeEach
    void init() throws Exception {
        andrey = new Person("Andrey", 100, 190);
        ford = new Person("Boris", 200, 170);
        vlad = new Person("Vlad", 300, 400);
        serge = new Person("Denis", 50, 170);


        dictionaryOne = new Dictionary("Словарь Бетельгейзе-5");
        dictionaryTwo = new Dictionary("Какой-то словарь");

        dictionaryOne.addMeaning("Ыкс", "мальчик, который не может внятно объяснить, что такое Хрунг, и почему" +
                " он решил сотрястись именно на Бетельгейзе-7");

    }

    @Nested
    class PersonConstructorTest {

        @Test
        @DisplayName("check valid constructor")
        void basicTest() throws Exception {
            Person newPerson = new Person("Andrey", 100, 190);
            assertEquals(newPerson, andrey);
        }

        @Test
        @DisplayName("person constructor test (height)")
        void testWithNegativeHeight() {
            Exception e = assertThrows(Exception.class, () -> new Person("TestE", 100, -100));
            assertEquals("Height must be more than zero!", e.getMessage());
        }

        @Test
        @DisplayName("person constructor test (weight)")
        void testWithNegativeWeight() {
            Exception e = assertThrows(Exception.class, () -> new Person("TestE", -100, 100));
            assertEquals("Weight must be more than zero!", e.getMessage());
        }
    }

    // Тесты для методов, связанные со словарём (Dictionary)
    @Nested
    class DictionaryTests {

        @Test
        @DisplayName("dictionary value check")
        void constructorTest(){
            Dictionary testDictionary = new Dictionary("Какой-то словарь");

            Assertions.assertEquals(testDictionary, dictionaryTwo);
        }

        @Test
        @DisplayName("Check adding meanings")
        void addTest(){
            Dictionary test = new Dictionary("Словарь Бетельгейзе-5");
            test.addMeaning("Ыкс", "мальчик, который не может внятно объяснить, что такое Хрунг, и почему" +
                    " он решил сотрястись именно на Бетельгейзе-7");

            Assertions.assertEquals(test, dictionaryOne);
        }

        @Test
        @DisplayName("Check change meanings")
        void changeTest(){
            Dictionary test = new Dictionary(" Словарь Бетельгейзе-5");
            test.addMeaning("Ыкс", "мальчик, который не может внятно объяснить, что такое Хрунг, и почему" +
                    " он решил сотрястись именно на Бетельгейзе-7");
            test.changeMeaning("Икс", "мальчик, который не может внятно объяснить, что такое Хрунг, и почему" +
                    " он решил сотрястись именно на Бетельгейзе-7 ");

            Assertions.assertNotEquals(test, dictionaryOne);
        }

        @Test
        @DisplayName("Check get meanings")
        void getValueTest(){
            Dictionary test = new Dictionary("Словарь Бетельгейзе-5");
            test.addMeaning("Тест", "Значение теста");

            Assertions.assertEquals(test.getMeaning("Тест"), "Значение теста");
        }

    }

    //Просто тесты для большего кол-ва кода
    @Test
    public void givenMultipleAssertion_whenAssertingAll_thenOK() {
        assertAll(
                "heading",
                () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
                () -> assertEquals("java", "JAVA".toLowerCase()),
                () -> assertEquals((Short) null, (Short) null, "null is equal to null")
        );
    }
}
