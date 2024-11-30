package org.example.adressline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Region {
    private Integer id=regId++;
    private String name;
    public static int regId=1;
    private Integer countryId;

    public Region(String name, Integer countryId) {
        this.name = name;
        this.countryId = countryId;
    }
}
