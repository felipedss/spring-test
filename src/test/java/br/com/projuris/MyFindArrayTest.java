package br.com.projuris;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFindArrayTest {

    private MyFindArray myFindArray = new MyFindArray();

    @Test
    public void deveValidarPosicaoDoSegundoArray() {
        final int[] first = {4, 9, 3, 7, 8};
        final int[] second = {3, 7};
        assertEquals(2, myFindArray.findArray(first, second));
    }

    @Test
    public void deveValidarPosicaoZero() {
        final int[] first = {1, 3, 5};
        final int[] second = {1};
        assertEquals(0, myFindArray.findArray(first, second));
    }

    @Test
    public void naoDeveValidarPosicaoDoSegundoArray() {
        final int[] first = {7, 8, 9};
        final int[] second = {8, 9, 10};
        assertEquals(-1, myFindArray.findArray(first, second));
    }

    @Test
    public void deveValidarPosicaoDoSegundoArrayComDuplaOcorrencia() {
        final int[] first = {4, 9, 3, 7, 8, 3, 7, 1};
        final int[] second = {3, 7};
        assertEquals(5, myFindArray.findArray(first, second));
    }

}
