import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckNameParamTest {
    private final String cardName;
    private final boolean expected;

    public CheckNameParamTest(String cardName, boolean expected){
        this.cardName = cardName;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getStringValue(){
        return new Object[][]{
                {"Ли",false}, //false
                {"Ада",false}, //false
                {"ТимотейШевролееееее",false}, //false
                {"Тимотей Шевролееееее",false}, //false
                {"Тимотей Шевролееее",true},
                {"Тимоти Шаламе",true},
                {"Тимоти  Шаламе",false},
                {" ТимотиШаламе",false},
                {"ТимотиШаламе ",false},
                {" ТимотиШаламе ",false},
                {" Тимоти Шаламе ",false}


        };
    }

    @Test
    @DisplayName("Проверка строки на соотвествие условиям")
    public void checkNumberOfSymbols(){
        Account account = new Account(cardName);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected,actual);
    }
}
