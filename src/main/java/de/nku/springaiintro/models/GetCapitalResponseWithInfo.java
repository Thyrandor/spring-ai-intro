package de.nku.springaiintro.models;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record GetCapitalResponseWithInfo(@JsonPropertyDescription("Der Name der Hauptstadt") String name,
                                         @JsonPropertyDescription("Die Anzahl der Einwohner der Hauptstadt") String population,
                                         @JsonPropertyDescription("Region der Hauptstadt") String region,
                                         @JsonPropertyDescription("Die Hauptsprache der Hauptstadt") String language,
                                         @JsonPropertyDescription("Die Währung der Hauptstadt") String currency,
                                         @JsonPropertyDescription("Der Bürgermeister der Hauptstadt") String mayor) {
}
