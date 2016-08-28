package org.smth.useful.core;

import org.smth.useful.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kitten {
    private String name;
    private int age;
    private int weight;
    private Person owner;

    // getters and setters omitted
}
