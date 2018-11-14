package br.com.projuris;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFindCharTest {

    private MyFindChar myFindChar = new MyFindChar();

    @Test
    public void deveValidarOPrimeiroCharacterNaoDuplicado() {

        assertEquals('t', myFindChar.findChar("stress"));
        assertEquals('m', myFindChar.findChar("reembolsar"));
        assertEquals('e', myFindChar.findChar("ocorrencia"));
        assertEquals('a', myFindChar.findChar("a"));
        assertEquals('a', myFindChar.findChar("ab"));

        assertEquals(Character.MIN_VALUE, myFindChar.findChar("aabbcc"));
    }

}
