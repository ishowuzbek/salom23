package org.example.adressline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country {
    private Integer id=idGen++;
    private String name;
    public static int idGen=1;

    public Country(String name) {
        this.name = name;
    }
}
