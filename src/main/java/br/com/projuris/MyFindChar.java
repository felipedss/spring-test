package br.com.projuris;

import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;

@Component
public class MyFindChar implements FindCharacter {

    @Override
    public char findChar(String word) {

        final Set<Character> uniqueChars = new LinkedHashSet<>();
        final char[] chars = word.toCharArray();

        IntStream.range(0, chars.length)
                .mapToObj(word::charAt)
                .forEach(index -> toAdd(uniqueChars, index));

        return uniqueChars
                .stream()
                .findFirst()
                .orElse(Character.MIN_VALUE);
    }

    private void toAdd(Set<Character> uniqueChars, Character letter) {
        if (!uniqueChars.add(letter)) {
            uniqueChars.remove(letter);
        }
    }

}
