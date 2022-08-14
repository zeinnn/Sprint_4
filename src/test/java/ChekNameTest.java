import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChekNameTest {

    private boolean expectedTrue = true;
    private boolean expectedFalse = false;

    @Test
    @DisplayName("Проверка текста, соответсующего условию")
    public void checkRightString() {
        Account account = new Account("Тимоти Шаламе");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedTrue, actual);
    }

    @Test
    @DisplayName("Проверка текста без пробела")
    public void checkStringWithoutSpace() {
        Account account = new Account("ТимотейШевроле");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedFalse, actual);
    }

    @Test
    @DisplayName("Проверка текста с пробелом в начале")
    public void checkStringWithSpaceInStart() {
        Account account = new Account(" Тимоти Шаламе");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedFalse, actual);
    }

    @Test
    @DisplayName("Проверка текста с пробелом в конце")
    public void checkStringWithSpaceInEnd() {
        Account account = new Account("Тимоти Шаламе ");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedFalse, actual);
    }

    @Test
    @DisplayName("Проверка текста с двумя пробелами")
    public void checkStringWithTwoSpaces() {
        Account account = new Account("Тимоти  Шаламе");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedFalse, actual);
    }

    @Test
    @DisplayName("Проверка текста с двумя символами")
    public void checkStringWithTwoChars() {
        Account account = new Account("Т ");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedFalse, actual);
    }

    @Test
    @DisplayName("Проверка текста с тремя символами")
    @Step
    public void checkStringWithThreeChars() {
        Account account = new Account("В у");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedTrue, actual);
    }

    @Test
    @DisplayName("Проверка текста с четырмя символами")
    public void checkStringWithFourthChars() {
        Account account = new Account("Ли х");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedTrue, actual);
    }

    @Test
    @DisplayName("Проверка текста с 18 символами")
    public void checkStringWithEighteenChars() {
        Account account = new Account("Тимоти Шаламееееее");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedTrue, actual);
    }

    @Test
    @DisplayName("Проверка текста с 19 символами")
    public void checkStringWithNineteenChars() {
        Account account = new Account("Тимоти Шаламеееееее");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedTrue, actual);
    }

    @Test
    @DisplayName("Проверка текста с 20 символами")
    public void checkStringWithTwentyChars() {
        Account account = new Account("Тимоти Шаламееееееее");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedFalse, actual);
    }

    @Test
    @DisplayName("Проверка текста с 0 символами")
    public void checkStringWithEmptyChars() {
        Account account = new Account("");
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedFalse, actual);
    }
}
